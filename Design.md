# Skill-Bridge — Design Documentation

## 1. Problem Statement

Job seekers and career switchers often struggle to:
- Articulate their skills and map them to target roles
- Identify gaps between their current skills and role requirements
- Understand how to close those gaps with learning resources

Skill-Bridge bridges this gap by providing a career profile with AI-powered skill extraction, gap analysis against role requirements, and personalized learning roadmaps.

---

## 2. Design Outline

### 2.1 High-Level Solution

```
┌──────────────┐     ┌──────────────┐     ┌──────────────┐     ┌──────────────┐
│   Resume /   │     │  AI or       │     │  Gap         │     │  Learning    │
│   Text Input │ ──► │  Keyword     │ ──► │  Analysis    │ ──► │  Roadmap     │
│              │     │  Extraction  │     │  vs Role     │     │  (Courses,   │
│              │     │              │     │              │     │   Projects)   │
└──────────────┘     └──────────────┘     └──────────────┘     └──────────────┘
```

### 2.2 Core Design Decisions

| Decision | Rationale |
|----------|-----------|
| **AI + keyword fallback** | Ensures skill extraction works even when AI is unavailable or fails |
| **Role-based skill categories** | 18 roles with `skillCategories` and `experienceLevels` (ENTRY/MID/SENIOR) for weighted gap scoring |
| **Stateless backend** | JWT-based; no server-side sessions; scales horizontally |
| **Static roles.json** | Role definitions loaded at startup; no DB for roles; easy to extend |

### 2.3 Data Flow

1. **User** → Register → Login (JWT cookie)
2. **Profile** → Set target role + experience level
3. **Skills** → Extract from resume (AI or keyword) or add manually
4. **Gaps** → Compare user skills vs role categories (weighted by experience)
5. **Roadmap** → Map missing skills to courses, certifications, projects

---

## 3. Tech Stack

### 3.1 Backend

| Technology | Version | Purpose |
|------------|---------|---------|
| **Spring Boot** | 4.0.3 | REST API, security, JPA |
| **Java** | 21 | Runtime |
| **Spring Data JPA** | (built-in) | Persistence |
| **MySQL** | (Aiven) | Database |
| **Spring Security** | (built-in) | JWT auth, CORS |
| **Spring AI** | 2.0.0-M3 | OpenAI-compatible client → Groq |
| **Groq** | llama-3.1-8b-instant | LLM for skill extraction |
| **Apache Tika** | (Spring AI) | PDF/Word text extraction |
| **Thymeleaf** | 3.1.2 | Email templates |
| **Brevo** | SMTP | Transactional email |

### 3.2 Frontend

| Technology | Version | Purpose |
|------------|---------|---------|
| **React** | 19.x | UI | 
| **Vite** | 8.x | Build tool, dev server |
| **React Router** | 7.x | Routing |
| **Fetch API** | — | HTTP + cookies |

### 3.3 Infrastructure

| Component | Purpose |
|-----------|---------|
| **Aiven MySQL** | Hosted database |
| **Render** | Backend hosting |
| **Netlify** | Frontend hosting |
| **Docker** | Backend container image |

---

## 4. AI Feature & Fallback

### 4.1 AI Extraction

- **Provider:** Groq (OpenAI-compatible API)
- **Model:** `llama-3.1-8b-instant`
- **Flow:** Prompt → JSON array `[{name, category}]`; categories from `roles.json`
- **Fallback:** If AI fails (parse error, timeout, no API key) → keyword match against `roles.json` skills

### 4.2 Fallback Behavior

| Scenario | Result |
|----------|--------|
| AI API available, valid response | `source: "AI"` |
| AI fails or unavailable | `source: "FALLBACK"` (keyword extraction) |
| Skills added | UI shows extraction source (AI vs keyword matching) |

---

## 5. Future Enhancements

| Enhancement | Description |
|-------------|-------------|
| **Manual skill picker** | Dropdown to add skills from `roles.json` (MANUAL source already supported) |
| **Learning path tracking** | Mark resources as completed; track progress |
| **Multi-role comparison** | Compare gaps across multiple target roles |
| **Recommendation engine** | Suggest roles based on current skills |
| **AI interview questions** | Generate interview questions based on target role and user skills (role-based + skill-based) |

---

## 6. Related Documents

- **HLD_BACKEND.md** — Backend architecture, API, flows
- **HLD_FRONTEND.md** — Frontend architecture, pages, routes
- **README.md** — Setup, run, deploy
