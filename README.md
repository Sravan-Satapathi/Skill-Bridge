# Skill-Bridge

Career navigation platform that uses resume/GitHub-like input to provide a personalized learning roadmap, gap analysis, and AI-powered skill extraction.

---

## README Template

**Candidate Name:** SVGN Sai Sravan

**Scenario Chosen:** Skill-Bridge Career Navigator (Scenario 2)

**Estimated Time Spent:** 7 hours

**Demo Video:** https://drive.google.com/file/d/1nU7VVtfrJwYsPQ1K8Nkoq6Xp9nVN0OrX/view?usp=sharing

---

## Quick Start

### Prerequisites

- **Java 21** (Backend)
- **Node.js 18+** (Frontend)
- **MySQL**
- **Maven**

### Run Commands

**Backend:**
```bash
cd Backend
./mvnw spring-boot:run
# Or: mvn spring-boot:run
```
Backend runs at `http://localhost:8080` with context path `/api`.

**Frontend:**
```bash
cd Frontend_JS
npm install
npm run dev
```
Frontend runs at `http://localhost:5173` with Vite proxy to backend.
```

---

## AI Disclosure

- **Did you use an AI assistant (Copilot, ChatGPT, etc.)?** Yes, I used ChatGPT and Cursor
- **How did you verify the suggestions?** Code review, running the app, testing flows manually, and checking edge cases (e.g., AI parse failure → keyword fallback).
- **Give one example of a suggestion you rejected or changed:** I decided to add category weights based on experience levels (ENTRY, MID, SENIOR) for gap analysis, and the experience level concept was my idea. The assistant initially suggested keeping only skill categories; I pushed for experience-level weights so that gap scoring reflects seniority.

---

## Tradeoffs & Prioritization

### What did you cut to stay within the 4–6 hour limit?

- Manual skill picker (dropdown from roles.json) — backend supports MANUAL source; UI not built
- Mock interview questions (AI-generated) — listed as future enhancement
- UI polish — functional but minimal styling
- Job description parsing / 100+ job comparison — used static roles.json instead of live job data

### What would you build next if you had more time?

- AI-based interview questions (role + skill based)
- Manual skill picker UI
- Learning path tracking (mark resources completed)
- Multi-role gap comparison

### Known limitations

- Roles data is static (`roles.json`); no live job board integration
- Roadmap resources are hardcoded per skill; no dynamic course API
- No automated test suite yet
- AI extraction can fail on long resumes (JSON truncation), fallback to keyword matching

---

## Project Structure

```
Skill-Bridge/
├── Backend/          # Spring Boot 4, Java 21
├── Frontend_JS/      # React 19, Vite 8
├── design.md         # Design doc (outline, tech stack, future enhancements)
├── HLD_BACKEND.md    # Backend high-level design
├── HLD_FRONTEND.md   # Frontend high-level design
└── README.md
```

## Synthetic Dataset

- **roles.json** — `Backend/src/main/resources/data/roles.json` — 18 roles with skill categories and experience-level weights (no real personal data).

## Documentation

- **design.md** — Design outline, tech stack, future enhancements
- **HLD_BACKEND.md** — Backend architecture, API, flows
- **HLD_FRONTEND.md** — Frontend architecture, pages, routes
