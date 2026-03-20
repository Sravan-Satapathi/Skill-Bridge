# High-Level Design — Backend

## 1. Overview

Skill-Bridge backend is a Spring Boot 4 REST API that powers career profile management, AI-powered skill extraction, gap analysis, and learning roadmaps. It uses JWT-based authentication, MySQL for persistence, and Groq (via Spring AI) for skill extraction with a keyword fallback.

---

## 2. Architecture

```
┌─────────────────────────────────────────────────────────────────────────┐
│                           CLIENT (Frontend)                              │
└─────────────────────────────────────────────────────────────────────────┘
                                    │
                                    │ HTTPS / JWT Cookie
                                    ▼
┌─────────────────────────────────────────────────────────────────────────┐
│                         SPRING BOOT APPLICATION                          │
│  ┌─────────────┐  ┌──────────────┐  ┌─────────────────────────────────┐ │
│  │   CORS      │  │ JWT Filter   │  │   Security Filter Chain         │ │
│  │   Filter    │→ │ (Cookie/     │→ │   (permitAll vs authenticated)  │ │
│  │             │  │  Bearer)     │  │                                 │ │
│  └─────────────┘  └──────────────┘  └─────────────────────────────────┘ │
│                                          │                              │
│                                          ▼                              │
│  ┌─────────────────────────────────────────────────────────────────┐   │
│  │                     REST CONTROLLERS                              │   │
│  │  AuthController │ ProfileController │ CareerProfileController │   │   │
│  │                 │                   │ RoleController           │   │   │
│  └─────────────────────────────────────────────────────────────────┘   │
│                                          │                              │
│                                          ▼                              │
│  ┌─────────────────────────────────────────────────────────────────┐   │
│  │                       SERVICES                                   │   │
│  │  ProfileService │ SkillExtractionService │ GapAnalysisService │   │   │
│  │  RoadmapService │ RoleService │ AppUserDetailsService │ Email   │   │
│  └─────────────────────────────────────────────────────────────────┘   │
│                                          │                              │
│                                          ▼                              │
│  ┌─────────────────────────────────────────────────────────────────┐   │
│  │              REPOSITORIES (Spring Data JPA)                       │   │
│  │  UserRepository │ ProfileRepository │ SkillRepository            │   │
│  └─────────────────────────────────────────────────────────────────┘   │
└─────────────────────────────────────────────────────────────────────────┘
                                    │
                    ┌───────────────┼───────────────┐
                    ▼               ▼               ▼
            ┌─────────────┐  ┌─────────────┐  ┌─────────────┐
            │   MySQL     │  │  Groq API   │  │  Brevo SMTP │
            │  (Aiven)    │  │  (Spring AI)│  │  (Email)    │
            └─────────────┘  └─────────────┘  └─────────────┘
```

---

## 3. Package Structure

| Package | Responsibility |
|---------|----------------|
| `com.sravan` | Main application entry point |
| `com.sravan.config` | Dotenv loader for `.env` → Spring properties |
| `com.sravan.authentication` | User registration, login, JWT, password reset, email |
| `com.sravan.skillbridge` | Career profiles, skills, gaps, roadmap, roles |

---

## 4. API Endpoints

**Context path:** `/api`

### Public (no auth)

| Method | Path | Description |
|--------|------|-------------|
| POST | `/login` | Authenticate; returns JWT in cookie + body |
| POST | `/register` | Create user account |
| POST | `/send-reset-otp` | Send OTP for password reset |
| POST | `/reset-password` | Reset password with OTP |
| POST | `/logout` | Clear JWT cookie |
| GET | `/roles` | List all roles |
| GET | `/roles/{roleId}` | Get role by ID |
| GET | `/is-authenticated` | Check if user has valid JWT (returns boolean) |

### Authenticated (JWT required)

| Method | Path | Description |
|--------|------|-------------|
| GET | `/profile` | Get auth user profile (email, name) |
| GET | `/career-profile` | Get or create career profile |
| POST | `/career-profile` | Create career profile |
| PUT | `/career-profile` | Update target role, experience level |
| POST | `/career-profile/skills` | Add single skill |
| POST | `/career-profile/skills/bulk` | Add multiple skills |
| DELETE | `/career-profile/skills/{skillId}` | Remove skill |
| POST | `/career-profile/skills/extract` | Extract skills from text (JSON) or file (multipart) |
| GET | `/career-profile/gaps?roleId=` | Gap analysis vs selected role |
| GET | `/career-profile/roadmap?roleId=` | Learning roadmap for missing skills |

---

## 5. Data Model

### Entities

```
UserEntity (tbl_users)
├── id, userId (UUID), name, email, password
├── resetOtp, resetOtpExpireAt
└── createdAt, updatedAt

UserProfile (user_profiles)
├── id, userId (FK → UserEntity), targetRoleId, experienceLevel
├── createdAt, updatedAt
└── skills (OneToMany → Skill)

Skill (skills)
├── id, profile_id (FK → UserProfile)
├── name, category, proficiency, source
└── createdAt
```

### Roles Data (roles.json)

- 18 roles with `skillCategories` and `experienceLevels` (ENTRY, MID, SENIOR)
- Each level has `categoryWeights` for gap scoring
- Loaded at startup; in-memory lookup via `RoleService`

---

## 6. Core Flows

### 6.1 Authentication

1. **Login:** `AuthController` → `AuthenticationManager` → `AppUserDetailsService`
2. On success: `JwtUtil.generateToken()` → set httpOnly cookie (`jwt`, SameSite=None, Secure)
3. **JwtRequestFilter:** reads JWT from `Authorization: Bearer` or `jwt` cookie → validates → sets `SecurityContext`

### 6.2 Skill Extraction (AI + Fallback)

1. **SkillExtractionService.extractAndSave**
2. Call `extractSkillsFromText(text)`:
   - If `ChatModel` available: Spring AI → Groq (`llama-3.1-8b-instant`) → parse JSON `[{name, category}]`
   - On failure or no AI: **keyword fallback** — match text against skills in `roles.json`
3. Save to `Skill` with source `AI_EXTRACTED` or `KEYWORD_EXTRACTED`
4. Merge strategy: REPLACE (clear existing) or MERGE (add, dedupe)

### 6.3 Gap Analysis

1. **GapAnalysisService:** Load role from `roles.json`, get user skills
2. For each category: compute match score using `categoryWeights` for user's experience level
3. Return missing categories and overall match percentage

### 6.4 Roadmap

1. **RoadmapService:** Uses `GapAnalysisService` for missing skills
2. Maps each missing skill to suggested resources (courses, certifications, projects) from static map
3. Returns `MissingSkillWithResources` with estimated hours

---

## 7. Configuration

| Source | Key Settings |
|--------|--------------|
| `application.properties` | DB URL, JWT secret, AI base URL/model, mail, `frontend.url` |
| `.env` | `DB_URL`, `DB_USERNAME`, `DB_PASSWORD`, `JWT_SECRET_KEY`, `AI_API_KEY`, `FRONTEND_URL`, `MAIL_*` |
| **DotenvConfig** | Loads `.env` into Spring `Environment` (EnvironmentPostProcessor) |
| **SecurityConfig** | CORS from `frontend.url`, stateless JWT, public vs authenticated paths |

---

## 8. External Integrations

| Integration | Purpose |
|-------------|---------|
| **MySQL (Aiven)** | User, profile, skills persistence |
| **Groq (Spring AI)** | LLM for skill extraction from resume text |
| **Apache Tika** | PDF/Word → text extraction |
| **Brevo SMTP** | Welcome email, password reset OTP email |

---

## 9. Deployment

- **Docker:** Multi-stage build (Maven → JRE), JAR at `/app/app.jar`
- **Render:** Web service; env vars for DB, JWT, AI, mail, `FRONTEND_URL`
