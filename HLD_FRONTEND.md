# High-Level Design — Frontend

## 1. Overview

Skill-Bridge frontend is a React SPA built with Vite. It provides a career profile experience: target role selection, skill extraction from resume (AI or keyword fallback), gap analysis, and learning roadmaps. Authentication uses JWT cookies with `credentials: 'include'`.

---

## 2. Architecture

```
┌─────────────────────────────────────────────────────────────────────────┐
│                         BROWSER (React SPA)                              │
│                                                                         │
│  ┌─────────────────────────────────────────────────────────────────┐   │
│  │                     React Router (BrowserRouter)                  │   │
│  │  /  /login  /register  /forgot-password  /reset-password          │   │
│  │  /dashboard  /dashboard/gaps  /dashboard/roadmap                 │   │
│  └─────────────────────────────────────────────────────────────────┘   │
│                                          │                              │
│  ┌──────────────────────────────────────┼──────────────────────────┐   │
│  │           AuthContext                 │                          │   │
│  │  isAuthenticated, checkAuth, logout   │                          │   │
│  │  → checkAuth() on mount (is-authenticated)                        │   │
│  └──────────────────────────────────────┼──────────────────────────┘   │
│                                          │                              │
│  ┌──────────────────────────────────────┼──────────────────────────┐   │
│  │           API Client (client.js)      │                          │   │
│  │  credentials: 'include' | VITE_BACKEND_URL or /api (proxy)       │   │
│  └──────────────────────────────────────┼──────────────────────────┘   │
└──────────────────────────────────────────┼──────────────────────────────┘
                                           │
                                           │ HTTPS + JWT Cookie
                                           ▼
                              ┌────────────────────────┐
                              │   Backend API (/api)   │
                              └────────────────────────┘
```

---

## 3. Project Structure

```
Frontend_JS/
├── src/
│   ├── api/
│   │   ├── client.js      # Base HTTP client (get, post, put, delete, postForm)
│   │   ├── auth.js        # authApi
│   │   └── career.js      # careerApi, rolesApi
│   ├── components/
│   │   ├── AuthLayout.jsx
│   │   ├── FormField.jsx
│   │   └── SearchableRoleSelect.jsx
│   ├── context/
│   │   └── AuthContext.jsx
│   ├── pages/
│   │   ├── Home.jsx
│   │   ├── Login.jsx
│   │   ├── Register.jsx
│   │   ├── ForgotPassword.jsx
│   │   ├── ResetPassword.jsx
│   │   ├── Dashboard.jsx
│   │   ├── Profile.jsx
│   │   ├── Gaps.jsx
│   │   └── Roadmap.jsx
│   ├── App.jsx
│   └── main.jsx
├── vite.config.js
├── .env
└── package.json
```

---

## 4. Pages & Routes

| Route | Page | Purpose |
|-------|------|---------|
| `/` | Home | Landing; links to login/register |
| `/login` | Login | Email/password |
| `/register` | Register | User registration |
| `/forgot-password` | ForgotPassword | Request OTP |
| `/reset-password` | ResetPassword | Reset with OTP |
| `/dashboard` | Dashboard (layout) | Nav + Profile (index) |
| `/dashboard/gaps` | Gaps | Gap analysis |
| `/dashboard/roadmap` | Roadmap | Learning roadmap |

**Protected routes:** `/dashboard` and children use `ProtectedRoute`; redirect to `/` if not authenticated.

---

## 5. Components

| Component | Purpose |
|-----------|---------|
| **AuthLayout** | Wrapper for auth pages (login, register, etc.) |
| **FormField** | Reusable labeled input |
| **SearchableRoleSelect** | Role dropdown with search; filters by title/id |

---

## 6. State Management

| Approach | Usage |
|----------|--------|
| **AuthContext** | `isAuthenticated`, `checkAuth`, `logout`; `checkAuth` on mount |
| **useState** | Page-level: profile, roles, gaps, roadmap, loading, form fields |
| **No global store** | No Redux/Zustand |

---

## 7. API Integration

### Base URL

- **Dev:** `VITE_BACKEND_URL` empty → `/api` (Vite proxy to `http://localhost:8080`)
- **Prod:** `VITE_BACKEND_URL=https://api.example.com` → `https://api.example.com/api`

### API Modules

| Module | Methods |
|--------|---------|
| **authApi** | login, register, logout, isAuthenticated, sendResetOtp, resetPassword |
| **careerApi** | getProfile, updateProfile, addSkill, removeSkill, extractSkills, extractSkillsFromFile, getGaps, getRoadmap |
| **rolesApi** | getAll, getById |

### Credentials

- All requests use `credentials: 'include'`; JWT sent via cookie.

---

## 8. Key User Flows

### 8.1 Login → Dashboard

1. User logs in → backend sets JWT cookie
2. `AuthContext.checkAuth()` → `GET /api/is-authenticated` → `isAuthenticated = true`
3. Navigate to `/dashboard` (Profile)

### 8.2 Skill Extraction

1. User pastes resume text or uploads PDF/Word
2. Selects merge strategy (Replace / Merge)
3. Clicks "Extract & save skills"
4. Backend returns `{ source: "AI" | "FALLBACK", skillsAdded }`
5. UI shows: "Added X skills (AI extraction)" or "keyword matching"

### 8.3 Gap Analysis

1. User selects target role (SearchableRoleSelect)
2. `GET /api/career-profile/gaps?roleId=...`
3. Display match score and missing categories

### 8.4 Roadmap

1. User selects target role
2. `GET /api/career-profile/roadmap?roleId=...`
3. Display missing skills with suggested resources per category

---

## 9. Build & Deployment

| Command | Purpose |
|---------|---------|
| `npm run dev` | Vite dev server (port 5173) |
| `npm run build` | Production build → `dist/` |

**Env:** `VITE_BACKEND_URL` for production API base.
