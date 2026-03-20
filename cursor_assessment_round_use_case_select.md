# Assessment round use case selection
_Exported on 3/19/2026 at 12:46:46 GMT+5:30 from Cursor (2.6.20)_

---

**User**

Palo Alto Networks New Grad SWE
Take-Home Case Study
⏱️ Overview & Timebox
● Timebox: Spend 4–6 hours max. If you hit setup issues, note them in your README
and use a workaround—do not sink hours into environment issues.
● Goal: We are evaluating job-related engineering behaviors: meeting requirements, basic
testing, handling edge cases, and clear communication of tradeoffs.
● What we don't score: UI polish, production-grade deployment, or the specific AI tool
you choose to use.
�� Step 1: Choose One Scenario
Pick ONE of the following to implement. The core requirements remain the same regardless of
the topic.
1. �� Green-Tech Inventory Assistant
Problem Statement: Many small businesses and community organizations struggle to manage
their physical assets and reduce waste. Manual tracking is prone to error, and without
data-driven insights, organizations often over-purchase supplies that eventually expire. Existing
enterprise solutions are too complex and expensive for smaller, sustainability-minded teams.
Your Challenge: Create an intelligent, lightweight inventory assistant that uses AI to track
assets, predict "shelf-life" or usage burnout, and suggest sustainable procurement alternatives.
Target Audience:
● Non-Profits managing donated goods and office supplies.
● Small Cafes tracking perishable inventory to reduce food waste.
● University Labs keeping track of equipment and chemical expiration dates.
Example Features (inspiration only - you are not expected to build all examples):
● Predictive Reorder Insights: The AI analyzes past usage to predict when an item will
run out, sending a notification: "Your coffee supply will run out in 4 days. Want to see
local, fair-trade suppliers?"
● Visual Asset Scanning: Users can take a photo of a shelf, and the AI automatically
identifies the items and updates the digital count.
● Sustainability Impact Score: A dashboard that calculates carbon saved by reducing
waste or choosing refurbished equipment.
Success Metrics:
● Waste Reduction: Does the app effectively help users avoid over-ordering?
● Ease of Entry: How quickly can a user add an item compared to a spreadsheet?
● AI Application: Is AI used appropriately for the chosen task, with a clear fallback when
AI is unavailable or incorrect?
2. �� Skill-Bridge Career Navigator
Problem Statement: Students and early-career professionals often find a "skills gap" between
their academic knowledge and the specific technical requirements of job postings. Navigating
multiple job boards and certification sites makes it difficult to see a clear path from their current
skill set to their "dream role."
Your Challenge: Build a career navigation platform that uses synthetic resume/GitHub-like
input to provide a personalized learning roadmap.
Target Audience:
● Recent Graduates looking to understand which certifications make them competitive.
● Career Switchers needing to identify transferable skills between industries.
● Mentors looking for a data-backed way to guide their mentees' development.
Example Features (inspiration only - you are not expected to build all examples):
● Gap Analysis Dashboard: The AI compares the user's resume against 100+ job
descriptions for a role (e.g., "Cloud Engineer") and highlights missing skills.
● Dynamic Learning Roadmap: The AI suggests specific free or paid courses/projects to
fill those gaps, organized by time to complete.
● Mock Interview Pivot: The AI generates technical interview questions based specifically
on the skills the user added to their profile.
Success Metrics:
● Clarity of Path: Does the user feel they have a concrete next step?
● Data Integration: How effectively does the tool parse resumes and external job data?
● AI Application: Is AI used appropriately for the chosen task, with a clear fallback when
AI is unavailable or incorrect?
3. Community Safety & Digital Wellness
Problem Statement: As digital and physical security threats become more complex, individuals
struggle to keep up with relevant safety information. Information is often scattered across news
sites and social media, leading to alert fatigue or unnecessary anxiety without actionable steps.
Your Challenge: Design a "Community Guardian" platform that aggregates local safety and
digital security data, using AI to filter out noise and provide calm, actionable safety digests.
Target Audience:
● Neighborhood Groups wanting to track local trends without social media toxicity.
● Remote Workers concerned about local network security and home safety. ●
Elderly Users who need a simplified way to be alerted to scams or hazards.
Example Features (inspiration only - you are not expected to build all examples):
● Noise-to-Signal Filtering: The AI scans local reports and filters out venting or repetitive
posts to show only verified incidents or alerts.
● Proactive Digital Defense: If a local data breach or phishing scam is detected, the AI
provides a 1-2-3 checklist on how to secure accounts.
● Privacy-First "Safe Circles": Users can share specific, encrypted status updates with a
small group of trusted guardians during emergencies.
Success Metrics:
● Anxiety Reduction: Does the app provide info in a way that feels empowering?
● Contextual Relevance: Are the alerts specific to the user’s location and habits?
● Trust & Privacy: Does the design ensure user location data is kept secure?
● AI Application: Is AI used appropriately for the chosen task, with a clear fallback when
AI is unavailable or incorrect?
✅ Step 2: Meet the Requirements
Regardless of the scenario, your app must include the following minimum requirements:
1. Core Flow: One end-to-end flow for the main objective (Create + View + Update, or
closest equivalent) plus basic search/filter.
2. AI Integration + Fallback: Implement one AI capability (Summarize, Categorize,
Extract, or Forecast). You must provide a manual or rule-based fallback for when the AI
is unavailable or incorrect.
3. Basic Quality: Input validation, clear error messages, and at least 2 tests (one happy
path and one edge case).
4. Data Safety: Use synthetic data only. Do not scrape live sites. Include a small sample
CSV/JSON in your repo.
5. Security: Do not commit API keys. Use an .env file and provide an .env.example.
�� Step 3: Submission Deliverables
Submit a single repository containing the following items:
● Working Prototype/Demo: A functional application (Web or CLI is acceptable).
● Synthetic Dataset: A small sample CSV or JSON file included in your repository (no
real personal data).
● Design Documentation: An outline of your design, tech stack, and future
enhancements.
● Completed README: Use the provided template below to document your process and
tradeoffs.
● 5–7 Minute Video: Provide a screen recording only.
○ Focus: Cover the problem and your solution, demonstrating the functional flow,
the AI feature with its fallback, your tests, and any key learnings.
○ Requirements: No camera is required, but audio is required. We score the
working product and technical behavior, not presentation polish.
♿ Accommodations & Support
We are committed to an inclusive evaluation process.
● Contact: If you require accommodations or an alternate format if a video is required,
please contact fjoseph@paloaltonetworks.com
�� README Template
(Copy and fill this out in your repository)
Candidate Name:
Scenario Chosen:
Estimated Time Spent:
Quick Start:
● Prerequisites:
● Run Commands:
● Test Commands:
AI Disclosure:
● Did you use an AI assistant (Copilot, ChatGPT, etc.)? (Yes/No)
● How did you verify the suggestions?
● Give one example of a suggestion you rejected or changed:
Tradeoffs & Prioritization:
● What did you cut to stay within the 4–6 hour limit?
● What would you build next if you had more time?
● Known limitations

❓ Candidate FAQs
Technical & AI Execution ��
● Do I need to design and train all AI models myself?
No. You are welcome to leverage existing pre-trained models, APIs (like OpenAI), or
libraries. We are primarily assessing how effectively you apply tools to address the
problem, along with the rigor and creativity of your approach.
● Can I use AI tools (LLMs, Copilot, etc.) to help develop my solution? Yes! You are
permitted to use AI tools when developing your solution. We encourage you to make
thoughtful choices and clearly explain them in your documentation.
● My solution requires data collected over several days. How do I demo this?
To allow for quicker testing, it is perfectly fine to include a “Developer Mode” or
simulated way to advance time. The key is to clearly document your approach so
reviewers understand your logic and assumptions.
● Are AI-generated or stock images allowed?
Yes. Please ensure images are your own work, AI-generated by you, or free-to-use
(Creative Commons) and include a short note on the source.

i have cleared first round of Palo Alto IT Software Engineer Role Process. The second round is an assessment round where we have been given 3 usecases and should pick one and develop it. I am confused of what to pick.
Considering time restrictions and all parameteres, help me identify the best by analysing difficulty, time constraint, feasability, approach and all parameters. I am attaching the spec docs.

---

**Cursor**

Checking your project structure and tech stack to tailor recommendations.


Here’s an analysis of the three scenarios, tailored to your Spring Boot/Java background and the 4–6 hour limit.

---

# Palo Alto Take-Home: Scenario Comparison

## Your Background (from Expensly)

- **Stack**: Spring Boot 3.4, Java 21, JPA, MySQL, JWT, validation
- **Patterns**: CRUD + filter (Create, View, Update, Delete, Filter)
- **Domain**: Expense tracking (similar to inventory in some ways)

---

## Scenario 1: Green-Tech Inventory Assistant

| Parameter | Assessment |
|-----------|------------|
| **Difficulty** | Medium |
| **Feasibility** | High |
| **Time Fit** | Good |
| **Overlap with Expensly** | High |

**Pros:**
- Very close to your expense/inventory domain: items, quantities, dates, categories.
- CRUD + filter maps directly to your existing patterns.
- AI use cases are straightforward:
  - **Categorize**: AI suggests category for new items.
  - **Forecast**: Simple rule-based “reorder soon” (e.g., low quantity + expiry).
- Synthetic data is easy: items, quantities, expiry dates, categories.
- No external APIs or scraping needed.

**Cons:**
- “Predictive reorder” needs some usage history; you can simulate with synthetic data.
- Visual scanning is optional and complex; you can skip it.

**Suggested MVP (4–6 hrs):**
- Items: Create, View, Update, Search/Filter (by category, expiry, quantity).
- AI: **Categorize** new items (e.g., OpenAI API) with rule-based fallback (keyword matching).
- Synthetic CSV: 20–30 items with name, category, quantity, expiry.
- Tests: Happy path (add item, get AI category) + edge case (invalid input, AI unavailable).

---

## Scenario 2: Skill-Bridge Career Navigator

| Parameter | Assessment |
|-----------|------------|
| **Difficulty** | Medium–High |
| **Feasibility** | Medium |
| **Time Fit** | Tight |
| **Overlap with Expensly** | Low |

**Pros:**
- Interesting problem and good for storytelling.
- AI fits well: **Extract** skills from resume text, **Summarize** gaps.

**Cons:**
- Data integration: resume parsing and job data are non-trivial.
- Spec says “100+ job descriptions” and “parse resumes” — heavy for 4–6 hrs.
- Synthetic job data: you must design and maintain a realistic dataset.
- More moving parts: resume input, job matching, gap analysis, learning roadmap.
- Higher risk of scope creep.

**Suggested MVP (4–6 hrs):**
- User profile: skills (manual input or simple text paste).
- AI: **Extract** skills from pasted text, with keyword fallback.
- Synthetic JSON: 20–30 job descriptions with required skills.
- Gap analysis: compare user skills vs job requirements.
- Tests: extraction happy path + fallback when AI fails.

---

## Scenario 3: Community Safety & Digital Wellness

| Parameter | Assessment |
|-----------|------------|
| **Difficulty** | High |
| **Feasibility** | Low |
| **Time Fit** | Poor |
| **Overlap with Expensly** | Low |

**Pros:**
- Security/wellness angle aligns with Palo Alto’s domain.
- Strong narrative for a security company.

**Cons:**
- **Trust & Privacy**: Location data, encryption, “Safe Circles” — hard to do well in 4–6 hrs.
- **Data sources**: “Aggregates local safety and digital security data” implies external feeds; spec says no scraping.
- **Noise-to-signal**: Needs real-ish incident data and filtering logic.
- Synthetic data for safety incidents is less intuitive than inventory or jobs.
- More design and security work than the other two.

**Suggested MVP (4–6 hrs):**
- Alerts/incidents: Create, View, Update, Search/Filter.
- AI: **Summarize** incident text or **Categorize** severity.
- Synthetic JSON: 15–20 fake safety alerts.
- Tests: basic CRUD + AI summarization.

---

## Recommendation: Scenario 1 (Green-Tech Inventory Assistant)

### Why Scenario 1 Fits Best

1. **Leverages your experience**  
   Your Expensly CRUD + filter patterns transfer directly. You can focus on AI and domain logic instead of new architecture.

2. **Clear scope**  
   - Entities: Item (name, category, quantity, expiry, etc.)  
   - CRUD + filter  
   - One AI feature (Categorize or simple Forecast)  
   - Rule-based fallback  

3. **Simple synthetic data**  
   ```csv
   name,category,quantity,expiry_date,unit
   Organic Coffee, Beverages, 5, 2025-04-15, kg
   Paper Towels, Supplies, 12, 2026-01-01, rolls
   ```

4. **Straightforward AI + fallback**  
   - AI: “Given item name/description, suggest category.”  
   - Fallback: keyword mapping (e.g., “coffee” → Beverages, “paper” → Supplies).

5. **Easy to demo**  
   Add item → AI suggests category → manual override → view/filter items. Clear flow in 5–7 minutes.

6. **Low risk**  
   No scraping, no complex integrations, no heavy security/privacy requirements.

---

## Suggested Implementation Plan (4–6 hrs)

| Phase | Time | Tasks |
|-------|------|--------|
| **Setup** | 30 min | New Spring Boot project or module, `.env` for API key, `inventory` entity |
| **Core CRUD** | 1.5 hr | Create, Read, Update, Search/Filter (reuse your existing patterns) |
| **AI + Fallback** | 1.5 hr | Categorize via OpenAI (or similar) + keyword-based fallback |
| **Synthetic Data** | 30 min | CSV/JSON with 20–30 items |
| **Validation & Errors** | 30 min | Input validation, clear error messages |
| **Tests** | 1 hr | Happy path + edge case (e.g., AI down, invalid input) |
| **README & Video** | 30 min | Quick start, design notes, tradeoffs, 5–7 min demo |

---

## If You Prefer Scenario 2

- Use **manual skill input** instead of resume parsing.
- Use a **small synthetic job dataset** (15–20 roles).
- Focus on **Gap Analysis** as the main AI feature (e.g., “missing skills” list).
- Skip learning roadmaps and mock interviews for the MVP.

---

## Summary

| Scenario | Best For | Risk |
|----------|----------|------|
| **1. Inventory** | Your background, time limit, clear scope | Low |
| **2. Career Navigator** | Strong interest in career/learning tools | Medium |
| **3. Community Safety** | Strong interest in security/wellness | High |

Given your stack, experience, and time limit, **Scenario 1 (Green-Tech Inventory Assistant)** is the most practical choice and lets you show solid engineering and AI integration without overreaching.

---

**User**

the time is not limited to 4-6 hours, consider i have 1 day. which one should i pick among scenario 1 or 2.

---

**Cursor**

With **1 full day** (roughly 8–12 hours), the tradeoffs between Scenario 1 and 2 change. Here’s an updated comparison.

---

# Scenario 1 vs 2 with 1 Day

## Scenario 1: Green-Tech Inventory Assistant

**With 1 day you could:**
- Full CRUD + search/filter
- AI categorization with fallback
- Simple predictive reorder (e.g., low stock + expiry → “reorder soon”)
- Basic dashboard (e.g., items expiring soon)
- Synthetic data, tests, README, video

**Pros:**
- Low risk; you’ll likely finish with time to spare
- Strong fit with your Expensly experience
- Very polished result possible

**Cons:**
- May feel like “Expensly with inventory” to reviewers
- Less differentiation
- Might finish in 6–7 hours and feel light for a full day

---

## Scenario 2: Skill-Bridge Career Navigator

**With 1 day you could:**
- User profile with skills (manual + AI extraction from pasted text)
- AI **Extract** skills from resume-like text, with keyword fallback
- Synthetic job dataset (50–100 roles)
- **Gap analysis**: compare user skills vs job requirements
- Optional: simple learning roadmap (e.g., “missing skills” → suggested topics)
- Full flow: Create profile → Extract skills → View gaps → Update profile
- Search/filter by role, skill, etc.
- Tests, README, video

**Pros:**
- More distinctive and memorable
- Strong AI use case (extraction from unstructured text)
- Shows you can work in a different domain
- Clear, impressive demo: paste text → see gaps → get suggestions
- Good balance of ambition and feasibility in 1 day

**Cons:**
- Slightly higher risk if you get stuck on parsing or data design
- More moving parts than Scenario 1

---

## Recommendation: **Scenario 2 (Skill-Bridge Career Navigator)**

With 1 day, Scenario 2 is the better choice.

| Factor | Scenario 1 | Scenario 2 |
|--------|------------|------------|
| Differentiation | Lower (similar to Expensly) | Higher (new domain) |
| AI fit | Categorize (simpler) | Extract (more interesting) |
| Demo impact | Solid but familiar | Strong and memorable |
| Feasibility in 1 day | Very safe | Achievable |
| Risk | Very low | Low–medium |

---

## Suggested 1-Day Plan for Scenario 2

| Phase | Time | Tasks |
|-------|------|--------|
| **Setup & Data** | 1.5 hr | New project, entities (UserProfile, Job, Skill), synthetic job JSON (50 roles) |
| **Core Flow** | 2.5 hr | Create/View/Update profile, add skills, search/filter profiles & jobs |
| **AI Extraction** | 2 hr | Extract skills from pasted text (OpenAI/Claude), keyword fallback |
| **Gap Analysis** | 1.5 hr | Compare user skills vs job requirements, return missing skills |
| **Validation & Errors** | 30 min | Input validation, clear error messages |
| **Tests** | 1.5 hr | Happy path + edge cases (AI down, empty input, etc.) |
| **README & Video** | 1 hr | Design doc, tradeoffs, 5–7 min demo |

---

## When to Choose Scenario 1 Instead

Pick Scenario 1 if:
- You want minimal risk and a guaranteed, polished deliverable
- You prefer to stay in a domain very close to Expensly
- You’re less comfortable with text parsing and AI extraction

---

**Bottom line:** With 1 day, Scenario 2 is the stronger choice: more distinctive, better AI showcase, and still realistic to complete well.

---

**User**

okay. i wou;d like to go with second usecase. generate a list of features and create a architecture (no need to only include those mentioned in the requirements, we are open to changes/improvements). so help me out here

---

**Cursor**

Checking your frontend stack to tailor the architecture.


You’re using **React + Vite + Bootstrap** on the frontend and **Spring Boot** on the backend. Here’s a feature list and architecture tailored to that stack.

---

# Skill-Bridge Career Navigator — Feature List & Architecture

---

## 1. Feature List

### Core (Required)

| # | Feature | Description | Priority |
|---|---------|-------------|----------|
| 1 | **User Profile CRUD** | Create, view, update user career profile (name, target role, experience level) | Must |
| 2 | **Skills Management** | Add, remove, update skills (manual entry or AI-extracted) | Must |
| 3 | **AI Skill Extraction** | Paste resume/GitHub text → AI extracts skills → auto-populate profile | Must |
| 4 | **AI Fallback** | Keyword-based extraction when AI is unavailable or fails | Must |
| 5 | **Gap Analysis** | Compare user skills vs target role requirements → list missing skills | Must |
| 6 | **Search & Filter** | Filter jobs by role, skills, experience level; search profiles | Must |
| 7 | **Input Validation** | Validate all inputs, clear error messages | Must |
| 8 | **Tests** | Happy path + edge cases (AI down, empty input, invalid data) | Must |
| 9 | **Synthetic Data** | JSON with 50–100 job descriptions (no real data) | Must |
| 10 | **Security** | `.env` for API keys, `.env.example` | Must |

### Enhanced (Recommended)

| # | Feature | Description | Priority |
|---|---------|-------------|----------|
| 11 | **Learning Roadmap** | For each missing skill, suggest learning resources (courses, projects) | High |
| 12 | **Role Comparison** | Compare multiple target roles side-by-side | Medium |
| 13 | **Skill Categorization** | Group skills (e.g., Languages, Frameworks, Cloud) | Medium |
| 14 | **Match Score** | % match between user profile and target role | Medium |
| 15 | **Developer Mode** | Simulate time or data for demo (e.g., preload sample profile) | Low |

### Optional (If Time Allows)

| # | Feature | Description |
|---|---------|-------------|
| 16 | **Mock Interview Questions** | Generate technical questions based on user’s skills |
| 17 | **Export Profile** | Export profile/skills as JSON or PDF |
| 18 | **Dashboard** | Overview of gaps, match scores, suggested roles |

---

## 2. High-Level Architecture

```
┌─────────────────────────────────────────────────────────────────────────────┐
│                              FRONTEND (React + Vite)                         │
├─────────────────────────────────────────────────────────────────────────────┤
│  ┌──────────────┐  ┌──────────────┐  ┌──────────────┐  ┌──────────────┐     │
│  │   Profile    │  │   Skills     │  │  Gap         │  │   Jobs       │     │
│  │   Page       │  │   Manager    │  │  Analysis    │  │   Browser    │     │
│  └──────┬───────┘  └──────┬───────┘  └──────┬───────┘  └──────┬───────┘     │
│         │                 │                 │                 │             │
│         └─────────────────┴─────────────────┴─────────────────┘             │
│                                    │                                         │
│                         ┌──────────▼──────────┐                              │
│                         │   API Service      │  (Axios)                     │
│                         │   /api/*           │                              │
│                         └──────────┬──────────┘                              │
└────────────────────────────────────┼────────────────────────────────────────┘
                                     │ HTTP/REST
┌────────────────────────────────────┼────────────────────────────────────────┐
│                              BACKEND (Spring Boot)                           │
├────────────────────────────────────┼────────────────────────────────────────┤
│                         ┌──────────▼──────────┐                              │
│                         │  REST Controllers   │                              │
│                         │  ProfileController  │                              │
│                         │  JobController     │                              │
│                         │  GapController     │                              │
│                         └──────────┬──────────┘                              │
│                                    │                                         │
│         ┌──────────────────────────┼──────────────────────────┐             │
│         │                          │                          │             │
│  ┌──────▼──────┐          ┌───────▼───────┐          ┌───────▼───────┐     │
│  │ Profile     │          │ Job           │          │ Gap           │     │
│  │ Service     │          │ Service       │          │ Analysis      │     │
│  └──────┬──────┘          └───────┬───────┘          │ Service       │     │
│         │                          │                  └───────┬───────┘     │
│         │                          │                          │             │
│  ┌──────▼──────┐          ┌───────▼───────┐                  │             │
│  │ Skill       │          │ Job           │                  │             │
│  │ Extraction  │          │ Repository    │                  │             │
│  │ Service     │          │ (in-memory/   │                  │             │
│  │ (AI +       │          │  JSON load)   │                  │             │
│  │  Fallback)  │          └───────────────┘                  │             │
│  └──────┬──────┘                                               │             │
│         │                                                      │             │
│  ┌──────▼──────┐                                               │             │
│  │ OpenAI/     │  ◄───────────────────────────────────────────┘             │
│  │ Claude API  │     (calls extraction for resume text)                     │
│  └─────────────┘                                                             │
│                                                                              │
│  ┌──────────────────────────────────────────────────────────────────────┐   │
│  │  Data Layer                                                           │   │
│  │  • ProfileRepository (JPA / H2 for demo)                              │   │
│  │  │  - UserProfile, Skill (entities)                                   │   │
│  │  • jobs.json (synthetic, loaded at startup)                           │   │
│  └──────────────────────────────────────────────────────────────────────┘   │
└─────────────────────────────────────────────────────────────────────────────┘
```

---

## 3. Data Model

### Entities

```
┌─────────────────────┐       ┌─────────────────────┐
│    UserProfile      │       │        Job          │
├─────────────────────┤       ├─────────────────────┤
│ id (PK)             │       │ id (PK)             │
│ name                │       │ title               │
│ email               │       │ company             │
│ targetRole          │       │ requiredSkills[]    │
│ experienceLevel     │       │ preferredSkills[]   │
│ createdAt           │       │ experienceLevel     │
│ updatedAt           │       │ (from JSON)         │
└─────────┬───────────┘       └─────────────────────┘
          │
          │ 1:N
          ▼
┌─────────────────────┐
│       Skill         │
├─────────────────────┤
│ id (PK)             │
│ profileId (FK)      │
│ name                │
│ category            │  (optional: Language, Framework, Cloud, etc.)
│ proficiency         │  (optional: Beginner, Intermediate, Expert)
│ source              │  (manual | ai_extracted)
└─────────────────────┘
```

### Synthetic Job JSON Structure

```json
{
  "jobs": [
    {
      "id": "job-1",
      "title": "Cloud Engineer",
      "company": "TechCorp Inc",
      "requiredSkills": ["AWS", "Terraform", "Python", "Docker", "Kubernetes"],
      "preferredSkills": ["Linux", "CI/CD", "Go"],
      "experienceLevel": "mid"
    }
  ]
}
```

---

## 4. API Design

| Method | Endpoint | Description |
|--------|----------|-------------|
| `POST` | `/api/profiles` | Create profile |
| `GET` | `/api/profiles/{id}` | Get profile with skills |
| `PUT` | `/api/profiles/{id}` | Update profile |
| `GET` | `/api/profiles` | List profiles (with search/filter) |
| `POST` | `/api/profiles/{id}/skills` | Add skill(s) |
| `DELETE` | `/api/profiles/{id}/skills/{skillId}` | Remove skill |
| `POST` | `/api/profiles/{id}/skills/extract` | AI extract skills from text (body: `{ "text": "..." }`) |
| `GET` | `/api/jobs` | List jobs (filter by role, skills, level) |
| `GET` | `/api/jobs/{id}` | Get job details |
| `GET` | `/api/profiles/{id}/gaps?jobId={jobId}` | Gap analysis for profile vs job |
| `GET` | `/api/profiles/{id}/gaps?role={role}` | Gap analysis for profile vs role (first matching job) |
| `GET` | `/api/profiles/{id}/roadmap?jobId={jobId}` | Learning roadmap for missing skills |

---

## 5. Component Architecture (Frontend)

```
src/
├── App.jsx
├── main.jsx
├── api/
│   └── skillBridgeApi.js      # Axios instance + all API calls
├── components/
│   ├── Layout/
│   │   ├── Header.jsx
│   │   └── Sidebar.jsx
│   ├── Profile/
│   │   ├── ProfileForm.jsx
│   │   ├── ProfileCard.jsx
│   │   └── SkillList.jsx
│   ├── Extraction/
│   │   ├── ResumePasteModal.jsx   # Textarea + Extract button
│   │   └── ExtractedSkillsPreview.jsx
│   ├── GapAnalysis/
│   │   ├── GapDashboard.jsx
│   │   ├── MissingSkillsList.jsx
│   │   └── MatchScoreBar.jsx
│   ├── Jobs/
│   │   ├── JobCard.jsx
│   │   └── JobFilters.jsx
│   └── Roadmap/
│       └── LearningRoadmap.jsx
├── pages/
│   ├── Dashboard.jsx          # Overview
│   ├── ProfilePage.jsx        # Create/Edit profile
│   ├── GapAnalysisPage.jsx    # Select job → view gaps
│   └── JobsPage.jsx           # Browse jobs
├── context/
│   └── ProfileContext.jsx     # Current profile state
└── util/
    └── constants.js
```

---

## 6. Backend Package Structure

```
com.sravan.skillbridge/
├── SkillBridgeApplication.java
├── config/
│   └── OpenAIConfig.java          # API key from env
├── controller/
│   ├── ProfileController.java
│   ├── JobController.java
│   └── GapAnalysisController.java
├── dto/
│   ├── request/
│   │   ├── ProfileRequest.java
│   │   ├── SkillRequest.java
│   │   └── ExtractSkillsRequest.java
│   └── response/
│       ├── ProfileResponse.java
│       ├── JobResponse.java
│       ├── GapAnalysisResponse.java
│       └── RoadmapResponse.java
├── entity/
│   ├── UserProfile.java
│   └── Skill.java
├── repository/
│   ├── ProfileRepository.java
│   └── SkillRepository.java
├── service/
│   ├── ProfileService.java
│   ├── JobService.java              # Loads JSON, filters
│   ├── GapAnalysisService.java
│   ├── SkillExtractionService.java  # Interface
│   └── impl/
│       ├── OpenAISkillExtractionService.java
│       └── KeywordFallbackExtractionService.java
├── exception/
│   ├── BusinessException.java
│   └── GlobalExceptionHandler.java
└── resources/
    ├── application.yml
    ├── data/
    │   └── jobs.json
    └── .env.example
```

---

## 7. AI Fallback Flow

```
┌─────────────────────────────────────────────────────────────────┐
│                    Skill Extraction Request                       │
│                    (text: "I have 3 years Java...")              │
└────────────────────────────────────┼────────────────────────────┘
                                     │
                                     ▼
                    ┌────────────────────────────────┐
                    │  Try: AI Extraction Service    │
                    │  (OpenAI/Claude API)           │
                    └────────────────┬───────────────┘
                                     │
                    ┌────────────────┴────────────────┐
                    │                                  │
                    ▼ Success                          ▼ Fail/Timeout/Unavailable
         ┌──────────────────┐              ┌──────────────────────────┐
         │ Return AI skills │              │ Keyword Fallback Service │
         │ ["Java","Spring"] │              │ • Predefined skill dict   │
         └──────────────────┘              │ • Regex/tokenize text     │
                                           │ • Match against dict      │
                                           │ Return: ["Java",...]      │
                                           └──────────────────────────┘
```

---

## 8. Tech Stack Summary

| Layer | Technology |
|-------|------------|
| **Frontend** | React 19, Vite, React Router, Axios, Bootstrap |
| **Backend** | Spring Boot 3.x, Spring Data JPA, Spring Validation |
| **Database** | H2 (in-memory for demo) or MySQL |
| **AI** | OpenAI API or Claude API |
| **Auth** | Optional for demo; can skip or use simple API key |

---

## 9. Suggested Build Order

1. Backend: entities, repositories, `JobService` (load JSON)
2. Backend: `ProfileService` + `ProfileController` (CRUD)
3. Backend: `SkillExtractionService` (AI + fallback)
4. Backend: `GapAnalysisService` + controller
5. Backend: `JobController` with filters
6. Frontend: API layer, basic pages
7. Frontend: Profile flow + Resume paste + extraction
8. Frontend: Gap analysis UI
9. Tests, validation, README, video

---

This gives you a clear feature set and architecture for the Skill-Bridge Career Navigator. If you want, we can zoom in on one part (e.g., API contracts, AI extraction prompts, or frontend flows) next.

---

**User**

Problem Statement: Students and early-career professionals often find a "skills gap" between
their academic knowledge and the specific technical requirements of job postings. Navigating
multiple job boards and certification sites makes it difficult to see a clear path from their current
skill set to their "dream role."
Your Challenge: Build a career navigation platform that uses synthetic resume/GitHub-like
input to provide a personalized learning roadmap.
Target Audience:
● Recent Graduates looking to understand which certifications make them competitive.
● Career Switchers needing to identify transferable skills between industries.
● Mentors looking for a data-backed way to guide their mentees' development

here, should we compare the resume against a company's specific job role or should it be generalised for comparision amongst roles only (not comapny specific).

basically, if company based:
{
  "jobs": [
    {
      "id": "job-1",
      "title": "Cloud Engineer",
      "company": "TechCorp Inc",
      "requiredSkills": ["AWS", "Terraform", "Python", "Docker", "Kubernetes"],
      "preferredSkills": ["Linux", "CI/CD", "Go"],
      "experienceLevel": "mid"
    }
  ]
}
if role based:
{
  "Backend Engineer": {
    "languages": ["Java", "Python", "JavaScript"],
    "frameworks": ["Spring Boot", "Django", "Express"],
    "databases": ["SQL", "MongoDB"],
    "concepts": ["REST APIs"]
  }
}

---

**Cursor**

Here’s a comparison and a concrete recommendation.

---

# Company-Specific vs Role-Based Comparison

## Quick Comparison

| Aspect | Company-Specific (Jobs) | Role-Based (Archetypes) |
|--------|--------------------------|---------------------------|
| **Granularity** | Per-job (many variants) | Per-role (fewer archetypes) |
| **Data model** | Job = company + title + skills | Role = title + skill categories |
| **User question** | "How do I match this job?" | "What do I need for this role?" |
| **Problem fit** | Job-post style | "Dream role" style |
| **Audience fit** | Job seekers | Career switchers, mentors, grads |

---

## How It Fits the Problem Statement

The problem talks about:

- "Skills gap" with **job postings**
- "Clear path" to a **dream role**
- **Certifications** that make you competitive
- **Transferable skills** between industries
- **Mentors** guiding development

So both models are valid, but they answer different questions:

- **Company-specific**: "How well do I match this specific posting?"
- **Role-based**: "What do I need to become a Cloud Engineer / Backend Engineer?"

---

## Recommendation: **Role-Based as Primary**

For this take-home, **role-based archetypes** are a better primary model.

### 1. Audience alignment

- **Recent grads**: "Which certifications help for Cloud Engineer?" → role-based.
- **Career switchers**: "What does a Backend Engineer need?" → role-based.
- **Mentors**: "What should my mentee learn for this role?" → role-based.

All three care about **role expectations**, not a specific fake company.

### 2. Synthetic data constraint

- You’re not allowed to scrape real jobs.
- "TechCorp Inc" is fictional.
- Users gain little from fake company names; the value is in the **skill set**.
- Role archetypes are honest: "This is what the industry expects for this role."

### 3. Simpler and more maintainable

- Fewer archetypes (e.g. 8–12 roles) vs many synthetic jobs.
- Easier to design and keep consistent.
- Better for a 1-day scope.

### 4. Better for learning roadmaps

- Roadmap = "To become X, learn A, B, C."
- That’s role-centric, not job-centric.

---

## Suggested Data Model: Role Archetypes

```json
{
  "roles": [
    {
      "id": "backend-engineer",
      "title": "Backend Engineer",
      "description": "Builds server-side logic, APIs, and data pipelines",
      "requiredSkills": ["REST APIs", "SQL", "Java", "Python", "Spring Boot", "Git"],
      "preferredSkills": ["Docker", "Redis", "Kafka", "AWS"],
      "experienceLevels": ["entry", "mid", "senior"]
    },
    {
      "id": "cloud-engineer",
      "title": "Cloud Engineer",
      "description": "Designs and manages cloud infrastructure",
      "requiredSkills": ["AWS", "Terraform", "Docker", "Linux", "Networking"],
      "preferredSkills": ["Kubernetes", "Python", "CI/CD", "Go"],
      "experienceLevels": ["entry", "mid", "senior"]
    }
  ]
}
```

You can still keep `requiredSkills` and `preferredSkills` for gap analysis, but the unit of comparison is the **role**, not a company.

---

## Optional: Hybrid (Role + Job Examples)

If you want to show both perspectives:

1. **Primary**: Role archetypes for gap analysis and roadmap.
2. **Secondary**: Synthetic jobs as "examples" of each role.

```json
{
  "roles": [ /* as above */ ],
  "sampleJobs": [
    {
      "id": "job-1",
      "roleId": "cloud-engineer",
      "company": "TechCorp Inc",
      "title": "Cloud Engineer",
      "requiredSkills": ["AWS", "Terraform", "Python", "Docker", "Kubernetes"],
      "note": "Example instance of Cloud Engineer role"
    }
  ]
}
```

- Gap analysis: compare against **role**.
- Optional: "See sample jobs for this role" for exploration.

---

## Your Two Formats, Refined

**Role-based (recommended primary):**

```json
{
  "roles": [
    {
      "id": "backend-engineer",
      "title": "Backend Engineer",
      "requiredSkills": ["Java", "Python", "SQL", "REST APIs", "Spring Boot", "Git"],
      "preferredSkills": ["Docker", "Redis", "AWS"],
      "skillCategories": {
        "languages": ["Java", "Python", "JavaScript"],
        "frameworks": ["Spring Boot", "Django", "Express"],
        "databases": ["SQL", "MongoDB"],
        "concepts": ["REST APIs", "Microservices"]
      }
    }
  ]
}
```

`skillCategories` is optional; it helps with grouping and UI. For gap logic, `requiredSkills` and `preferredSkills` are enough.

**Company-specific (optional secondary):**

Keep your job format for "sample jobs" or "job browser," but treat the **role** as the main comparison target.

---

## Summary

| Approach | Use case | Recommendation |
|----------|----------|----------------|
| **Role-based** | Gap analysis, roadmap, certifications | **Primary** |
| **Company-specific** | Job browsing, "see examples" | Optional |
| **Hybrid** | Both | Good if you have time |

For the take-home, **role-based archetypes** are the best fit for the problem, audience, and time limit. Company-specific jobs can be added as an optional layer if you want more depth.

---

**User**

explain the data model and API design you mentioned above in detail

---

**Cursor**

Here’s a detailed breakdown of the data model and API design for the Skill-Bridge Career Navigator.

---

# Data Model & API Design — Detailed

---

## 1. Data Model

### 1.1 Entity Relationship Overview

```
┌─────────────────────────────────────────────────────────────────────────────────┐
│                         PERSISTENT (Database - JPA)                              │
├─────────────────────────────────────────────────────────────────────────────────┤
│                                                                                 │
│   ┌──────────────────────────┐                      ┌──────────────────────────┐│
│   │      UserProfile        │                      │         Skill           ││
│   ├──────────────────────────┤                      ├──────────────────────────┤│
│   │ id: Long (PK)            │─────── 1:N ──────────│ id: Long (PK)            ││
│   │ name: String             │                      │ profileId: Long (FK)     ││
│   │ email: String (unique)   │                      │ name: String             ││
│   │ targetRoleId: String     │                      │ category: String         ││
│   │ experienceLevel: Enum   │                      │ proficiency: Enum        ││
│   │ createdAt: LocalDateTime│                      │ source: Enum             ││
│   │ updatedAt: LocalDateTime │                      │ createdAt: LocalDateTime ││
│   └──────────────────────────┘                      └──────────────────────────┘│
│              │                                                                  │
│              │ targetRoleId references                                           │
│              ▼                                                                  │
└──────────────┼─────────────────────────────────────────────────────────────────┘
               │
┌──────────────┼─────────────────────────────────────────────────────────────────┐
│              │              REFERENCE (Loaded from JSON - Read-Only)           │
├──────────────┼─────────────────────────────────────────────────────────────────┤
│              ▼                                                                 │
│   ┌──────────────────────────┐                                                 │
│   │         Role             │                                                 │
│   ├──────────────────────────┤                                                 │
│   │ id: String (e.g. "be")   │                                                 │
│   │ title: String            │                                                 │
│   │ description: String      │                                                 │
│   │ requiredSkills: List     │                                                 │
│   │ preferredSkills: List    │                                                 │
│   │ experienceLevels: List   │                                                 │
│   └──────────────────────────┘                                                 │
│                                                                                 │
└─────────────────────────────────────────────────────────────────────────────────┘
```

---

### 1.2 UserProfile Entity

| Field | Type | Constraints | Description |
|-------|------|-------------|-------------|
| `id` | `Long` | PK, auto-generated | Unique identifier |
| `name` | `String` | Not null, max 100 | User's display name |
| `email` | `String` | Not null, unique, max 255 | Used for identification; can be synthetic |
| `targetRoleId` | `String` | Nullable, max 50 | References `Role.id` (e.g. `"backend-engineer"`) |
| `experienceLevel` | `ExperienceLevel` | Enum | `ENTRY`, `MID`, `SENIOR` |
| `createdAt` | `LocalDateTime` | Auto-set on insert | Creation timestamp |
| `updatedAt` | `LocalDateTime` | Auto-update on change | Last update timestamp |

**Purpose:** Stores the career profile and target role. Skills are stored in a separate `Skill` entity.

---

### 1.3 Skill Entity

| Field | Type | Constraints | Description |
|-------|------|-------------|-------------|
| `id` | `Long` | PK, auto-generated | Unique identifier |
| `profileId` | `Long` | FK → UserProfile.id | Owner profile |
| `name` | `String` | Not null, max 100 | Skill name (e.g. "Java", "AWS") |
| `category` | `String` | Nullable, max 50 | Optional grouping: "Language", "Framework", "Cloud", etc. |
| `proficiency` | `ProficiencyLevel` | Enum | `BEGINNER`, `INTERMEDIATE`, `EXPERT` |
| `source` | `SkillSource` | Enum | `MANUAL`, `AI_EXTRACTED` |
| `createdAt` | `LocalDateTime` | Auto-set | When skill was added |

**Purpose:** Stores skills for a profile. `source` distinguishes manual vs AI-extracted skills.

---

### 1.4 Role (Reference Data — JSON)

| Field | Type | Description |
|-------|------|-------------|
| `id` | `String` | Unique key (e.g. `"backend-engineer"`) |
| `title` | `String` | Display name (e.g. "Backend Engineer") |
| `description` | `String` | Short role description |
| `requiredSkills` | `List<String>` | Must-have skills for the role |
| `preferredSkills` | `List<String>` | Nice-to-have skills |
| `experienceLevels` | `List<String>` | Supported levels: `entry`, `mid`, `senior` |

**Purpose:** Defines role archetypes used for gap analysis and roadmap. Loaded from JSON at startup.

---

### 1.5 Enums

```text
ExperienceLevel:  ENTRY | MID | SENIOR
ProficiencyLevel: BEGINNER | INTERMEDIATE | EXPERT
SkillSource:      MANUAL | AI_EXTRACTED
```

---

### 1.6 Sample `roles.json`

```json
{
  "roles": [
    {
      "id": "backend-engineer",
      "title": "Backend Engineer",
      "description": "Builds server-side logic, APIs, and data pipelines",
      "requiredSkills": ["REST APIs", "SQL", "Java", "Python", "Spring Boot", "Git"],
      "preferredSkills": ["Docker", "Redis", "AWS", "Kafka"],
      "experienceLevels": ["entry", "mid", "senior"]
    },
    {
      "id": "cloud-engineer",
      "title": "Cloud Engineer",
      "description": "Designs and manages cloud infrastructure",
      "requiredSkills": ["AWS", "Terraform", "Docker", "Linux", "Networking"],
      "preferredSkills": ["Kubernetes", "Python", "CI/CD", "Go"],
      "experienceLevels": ["entry", "mid", "senior"]
    },
    {
      "id": "frontend-engineer",
      "title": "Frontend Engineer",
      "description": "Builds user interfaces and client-side applications",
      "requiredSkills": ["JavaScript", "React", "HTML", "CSS", "Git"],
      "preferredSkills": ["TypeScript", "Redux", "Next.js", "Testing"],
      "experienceLevels": ["entry", "mid", "senior"]
    }
  ]
}
```

---

## 2. API Design

### 2.1 Base URL & Conventions

- Base: `/api`
- JSON for request/response
- HTTP status codes: `200`, `201`, `400`, `404`, `500`
- Errors: `{ "message": "...", "errors": [...] }`

---

### 2.2 Profile APIs

#### `POST /api/profiles` — Create Profile

**Request:**
```json
{
  "name": "Jane Doe",
  "email": "jane@example.com",
  "targetRoleId": "backend-engineer",
  "experienceLevel": "ENTRY"
}
```

| Field | Type | Required | Notes |
|-------|------|----------|-------|
| `name` | String | Yes | Max 100 |
| `email` | String | Yes | Unique |
| `targetRoleId` | String | No | Must exist in roles |
| `experienceLevel` | String | No | ENTRY, MID, SENIOR |

**Response (201):**
```json
{
  "id": 1,
  "name": "Jane Doe",
  "email": "jane@example.com",
  "targetRoleId": "backend-engineer",
  "experienceLevel": "ENTRY",
  "skills": [],
  "createdAt": "2025-03-18T10:00:00",
  "updatedAt": "2025-03-18T10:00:00"
}
```

---

#### `GET /api/profiles/{id}` — Get Profile by ID

**Response (200):**
```json
{
  "id": 1,
  "name": "Jane Doe",
  "email": "jane@example.com",
  "targetRoleId": "backend-engineer",
  "experienceLevel": "ENTRY",
  "skills": [
    {
      "id": 101,
      "name": "Java",
      "category": "Language",
      "proficiency": "INTERMEDIATE",
      "source": "AI_EXTRACTED"
    },
    {
      "id": 102,
      "name": "Spring Boot",
      "category": "Framework",
      "proficiency": "BEGINNER",
      "source": "MANUAL"
    }
  ],
  "createdAt": "2025-03-18T10:00:00",
  "updatedAt": "2025-03-18T11:30:00"
}
```

**Errors:** `404` if profile not found.

---

#### `PUT /api/profiles/{id}` — Update Profile

**Request:**
```json
{
  "name": "Jane Doe",
  "targetRoleId": "cloud-engineer",
  "experienceLevel": "MID"
}
```

All fields optional; only provided fields are updated.

**Response (200):** Same shape as `GET /api/profiles/{id}`.

---

#### `GET /api/profiles` — List Profiles (with search/filter)

**Query params:**

| Param | Type | Description |
|-------|------|-------------|
| `search` | String | Search in name/email |
| `targetRoleId` | String | Filter by target role |
| `experienceLevel` | String | Filter by level |
| `page` | int | Page (default 0) |
| `size` | int | Page size (default 20) |

**Example:** `GET /api/profiles?targetRoleId=backend-engineer&experienceLevel=ENTRY`

**Response (200):**
```json
{
  "content": [
    {
      "id": 1,
      "name": "Jane Doe",
      "email": "jane@example.com",
      "targetRoleId": "backend-engineer",
      "experienceLevel": "ENTRY",
      "skillCount": 5,
      "createdAt": "2025-03-18T10:00:00"
    }
  ],
  "totalElements": 1,
  "totalPages": 1,
  "size": 20,
  "number": 0
}
```

---

### 2.3 Skill APIs

#### `POST /api/profiles/{profileId}/skills` — Add Skill(s)

**Request (single):**
```json
{
  "name": "Docker",
  "category": "DevOps",
  "proficiency": "BEGINNER",
  "source": "MANUAL"
}
```

**Request (bulk):**
```json
{
  "skills": [
    { "name": "Docker", "category": "DevOps", "proficiency": "BEGINNER" },
    { "name": "Kubernetes", "category": "DevOps", "proficiency": "BEGINNER" }
  ],
  "source": "MANUAL"
}
```

| Field | Type | Required | Notes |
|-------|------|----------|-------|
| `name` | String | Yes | Max 100 |
| `category` | String | No | Optional grouping |
| `proficiency` | String | No | BEGINNER, INTERMEDIATE, EXPERT |
| `source` | String | No | MANUAL (default) or AI_EXTRACTED |

**Response (201):** For single: skill object. For bulk: list of created skills.

**Validation:** Duplicate skill names for same profile → `400`.

---

#### `DELETE /api/profiles/{profileId}/skills/{skillId}` — Remove Skill

**Response:** `204 No Content` on success.

**Errors:** `404` if profile or skill not found.

---

#### `POST /api/profiles/{profileId}/skills/extract` — AI Skill Extraction

**Request:**
```json
{
  "text": "I have 3 years of experience with Java and Spring Boot. Built REST APIs using PostgreSQL. Familiar with Docker and AWS. Led a team of 4 developers."
}
```

| Field | Type | Required | Notes |
|-------|------|----------|-------|
| `text` | String | Yes | Resume/GitHub-like text |
| `mergeStrategy` | String | No | `REPLACE` (default) or `MERGE` |

- `REPLACE`: Clear existing skills and use only extracted ones.
- `MERGE`: Add extracted skills, keep existing, avoid duplicates.

**Response (200):**
```json
{
  "extractedSkills": [
    { "name": "Java", "category": "Language", "proficiency": null },
    { "name": "Spring Boot", "category": "Framework", "proficiency": null },
    { "name": "REST APIs", "category": "Concept", "proficiency": null },
    { "name": "PostgreSQL", "category": "Database", "proficiency": null },
    { "name": "Docker", "category": "DevOps", "proficiency": null },
    { "name": "AWS", "category": "Cloud", "proficiency": null }
  ],
  "source": "AI",
  "appliedToProfile": true,
  "skillsAdded": 6
}
```

When AI fails, `source` is `"FALLBACK"` and extraction uses keyword matching.

---

### 2.4 Role APIs (Reference Data)

#### `GET /api/roles` — List Roles

**Query params:**

| Param | Type | Description |
|-------|------|-------------|
| `search` | String | Search in title/description |
| `experienceLevel` | String | Filter roles supporting this level |

**Response (200):**
```json
{
  "roles": [
    {
      "id": "backend-engineer",
      "title": "Backend Engineer",
      "description": "Builds server-side logic, APIs, and data pipelines",
      "requiredSkills": ["REST APIs", "SQL", "Java", "Python", "Spring Boot", "Git"],
      "preferredSkills": ["Docker", "Redis", "AWS", "Kafka"],
      "experienceLevels": ["entry", "mid", "senior"]
    }
  ]
}
```

---

#### `GET /api/roles/{roleId}` — Get Role by ID

**Response (200):** Single role object.

**Errors:** `404` if role not found.

---

### 2.5 Gap Analysis APIs

#### `GET /api/profiles/{profileId}/gaps` — Gap Analysis

**Query params:**

| Param | Type | Required | Description |
|-------|------|----------|-------------|
| `roleId` | String | Yes* | Role to compare against |
| `includePreferred` | boolean | No | Include preferred skills in gap (default true) |

\*Either `roleId` or profile’s `targetRoleId` must be available.

**Example:** `GET /api/profiles/1/gaps?roleId=backend-engineer`

**Response (200):**
```json
{
  "profileId": 1,
  "profileName": "Jane Doe",
  "roleId": "backend-engineer",
  "roleTitle": "Backend Engineer",
  "matchScore": 66,
  "matchedSkills": [
    { "name": "Java", "inProfile": true, "inRole": "required" },
    { "name": "Spring Boot", "inProfile": true, "inRole": "required" },
    { "name": "REST APIs", "inProfile": true, "inRole": "required" },
    { "name": "Git", "inProfile": true, "inRole": "required" }
  ],
  "missingRequiredSkills": ["SQL", "Python"],
  "missingPreferredSkills": ["Docker", "Redis", "AWS", "Kafka"],
  "summary": "You have 4 of 6 required skills. Focus on SQL and Python to strengthen your profile."
}
```

**Match score:** `(matchedRequired / totalRequired) * 100` (or a weighted formula you define).

---

### 2.6 Learning Roadmap API

#### `GET /api/profiles/{profileId}/roadmap` — Learning Roadmap

**Query params:**

| Param | Type | Required | Description |
|-------|------|----------|-------------|
| `roleId` | String | Yes* | Target role |

**Example:** `GET /api/profiles/1/roadmap?roleId=backend-engineer`

**Response (200):**
```json
{
  "profileId": 1,
  "roleId": "backend-engineer",
  "roleTitle": "Backend Engineer",
  "missingSkills": [
    {
      "skillName": "SQL",
      "priority": "required",
      "suggestedResources": [
        { "type": "course", "name": "SQL for Beginners", "source": "Coursera", "estimatedHours": 10 },
        { "type": "project", "name": "Build a CRUD API with SQL", "estimatedHours": 8 }
      ]
    },
    {
      "skillName": "Python",
      "priority": "required",
      "suggestedResources": [
        { "type": "course", "name": "Python for Everybody", "source": "Coursera", "estimatedHours": 40 },
        { "type": "certification", "name": "PCEP", "source": "Python Institute", "estimatedHours": 20 }
      ]
    }
  ],
  "estimatedTotalHours": 78
}
```

Resource suggestions can be rule-based (e.g. from a static mapping) or AI-generated if you add that later.

---

## 3. API Summary Table

| Method | Endpoint | Purpose |
|--------|----------|---------|
| `POST` | `/api/profiles` | Create profile |
| `GET` | `/api/profiles/{id}` | Get profile with skills |
| `PUT` | `/api/profiles/{id}` | Update profile |
| `GET` | `/api/profiles` | List profiles (search/filter) |
| `POST` | `/api/profiles/{id}/skills` | Add skill(s) |
| `DELETE` | `/api/profiles/{id}/skills/{skillId}` | Remove skill |
| `POST` | `/api/profiles/{id}/skills/extract` | AI extract skills from text |
| `GET` | `/api/roles` | List roles |
| `GET` | `/api/roles/{roleId}` | Get role |
| `GET` | `/api/profiles/{id}/gaps` | Gap analysis vs role |
| `GET` | `/api/profiles/{id}/roadmap` | Learning roadmap for role |

---

## 4. Error Response Format

```json
{
  "message": "Validation failed",
  "timestamp": "2025-03-18T12:00:00",
  "errors": [
    { "field": "email", "reason": "must not be blank" },
    { "field": "name", "reason": "size must be between 1 and 100" }
  ]
}
```

---

This gives you a concrete data model and API contract to implement the Skill-Bridge Career Navigator.

---

**User**

lets have discussion and then finally lock the design decisions.
1.Since we have user profile, users wan't their profiles to be secure. They don't want others to view profiles right. So shall we include basic auth (email, password) or i already have jwt based auth ready (refer to @src/main/java/com/sravan/expensly/authentication ).
2.mostly, resume are parsed by AI itself. Incase AI fails, we use fallback (should we make 2 way fallback -> use Apache Tika or some parsing tool and parse the resume and build skills section and the other way is to ask users to manually enter skills)
3.for roles.json what if we use format similar like below(lets make a common format analysing my way and your way). What's your opinion on this:
{
  "Backend Engineer": {
    "languages": ["Java", "Python", "JavaScript"],
    "frameworks": ["Spring Boot", "Django", "Express"],
    "databases": ["SQL", "MongoDB"],
    "concepts": ["REST APIs"]
  }
}
because if we use the way you gave (as below), we have multiple required skills (java, python). But a backend engineer can know only one language amomng java and python and he is still considered backend engineer right?
{
      "id": "backend-engineer",
      "title": "Backend Engineer",
      "description": "Builds server-side logic, APIs, and data pipelines",
      "requiredSkills": ["REST APIs", "SQL", "Java", "Python", "Spring Boot", "Git"],
      "preferredSkills": ["Docker", "Redis", "AWS", "Kafka"],
      "experienceLevels": ["entry", "mid", "senior"]
    },
4.API Design:
Create Profile -> POST /api/profiles : Good
View Profile -> GET /api/profiles/{id} : Good
Update Profile -> PUT /api/profiles/{id} : Good
List Profiles -> GET /api/profiles — List Profiles (with search/filter) : Bad because profiles are open to everyone (security issue)
Add Skills -> POST /api/profiles/{profileId}/skills -> single and bulk -> Good
Remove Skill -> DELETE /api/profiles/{profileId}/skills/{skillId}
AI SKill Extraction -> POST /api/profiles/{profileId}/skills/extract (Resume Upload here) -> Good
Gap Analysis -> GET /api/profiles/{profileId}/gaps?roleId -> Good
Learning Roadmap -> GET /api/profiles/{profileId}/roadmap -> Good
We need AI for skill extraction. For Gap Analysis and Learning Roadmap, lets use AI only at one place so that our project won't be entirely AI based. what do you think

---

**Cursor**

Reviewing your auth setup so we can recommend the best approach.


Here’s a concise design discussion and final decisions.

---

# Design Discussion & Locked Decisions

---

## 1. Authentication: JWT vs Basic Auth

**Recommendation: Use your existing JWT auth.**

| Factor | JWT (existing) | Basic Auth (new) |
|--------|----------------|------------------|
| **Effort** | Reuse | New implementation |
| **Security** | Stateless, industry standard | Per-request credentials |
| **Consistency** | Same as Expensly | Different pattern |
| **Profile isolation** | Same pattern as expenses | Same |

**Model:** Profile is tied to the authenticated user (email). No `profileId` in URLs; use the current user’s profile.

**Implementation:**
- `UserProfile` has `userId` (or `email`) as FK to `UserEntity`
- All profile endpoints use `@CurrentSecurityContext(expression = "authentication?.name") String email`
- Resolve profile by `email` and enforce ownership before any operation

**Decision:** Use JWT auth. Profile is 1:1 with user; access by current user only.

---

## 2. Skill Extraction Fallback Chain

**Clarification:** Tika does not extract skills; it only extracts text from PDF/DOCX.

**Flow:**

```
User Input (File or Text)
        │
        ├── If FILE (PDF/DOCX) ──► Tika extracts text ──┐
        │                                                │
        └── If TEXT (paste) ────────────────────────────┤
                                                        │
                                                        ▼
                                            ┌───────────────────────┐
                                            │  AI Skill Extraction  │
                                            │  (OpenAI/Claude)      │
                                            └───────────┬───────────┘
                                                        │
                                    ┌───────────────────┴───────────────────┐
                                    │ Success                               │ Fail/Empty
                                    ▼                                       ▼
                        ┌───────────────────────┐           ┌───────────────────────────┐
                        │ Return extracted      │           │ Keyword Fallback          │
                        │ skills                 │           │ (match against skill dict) │
                        └───────────────────────┘           └─────────────┬─────────────┘
                                                                          │
                                                          ┌───────────────┴───────────────┐
                                                          │ Has results                  │ Empty
                                                          ▼                             ▼
                                              ┌───────────────────────┐    ┌─────────────────────────┐
                                              │ Return keyword-matched│    │ Return empty + prompt   │
                                              │ skills                │    │ user to add manually    │
                                              └───────────────────────┘    └─────────────────────────┘
```

**Fallback chain:**
1. **AI** (primary)
2. **Keyword matching** on text (fallback when AI fails)
3. **Manual entry** (when both return nothing)

**Tika:** Use only for file uploads to get text. It is not a skill-extraction fallback.

**Decision:**  
- Support both: file upload (PDF/DOCX) and text paste  
- File upload: Tika → text → AI → keyword fallback  
- Text paste: AI → keyword fallback  
- If both AI and keyword return empty: return empty and ask user to add skills manually  

---

## 3. Roles Format: Category-Based with OR Logic

Your concern is correct: requiring both Java and Python is too strict. The right model is “at least one per category.”

**Proposed format (hybrid):**

```json
{
  "roles": [
    {
      "id": "backend-engineer",
      "title": "Backend Engineer",
      "description": "Builds server-side logic, APIs, and data pipelines",
      "skillCategories": {
        "languages": ["Java", "Python", "JavaScript", "Go"],
        "frameworks": ["Spring Boot", "Django", "Express", "Gin"],
        "databases": ["SQL", "MongoDB", "PostgreSQL"],
        "coreConcepts": ["REST APIs", "Git"]
      }
    },
    {
      "id": "cloud-engineer",
      "title": "Cloud Engineer",
      "description": "Designs and manages cloud infrastructure",
      "skillCategories": {
        "cloudPlatforms": ["AWS", "GCP", "Azure"],
        "iac": ["Terraform", "CloudFormation", "Pulumi"],
        "containers": ["Docker", "Kubernetes"],
        "scripting": ["Python", "Bash", "Go"],
        "coreConcepts": ["Linux", "Networking", "CI/CD"]
      }
    }
  ]
}
```

**Logic:**
- Within each category: user needs at least one skill (OR).
- Across categories: user needs at least one from each category (AND of categories).
- Example: Java + Spring Boot + SQL + REST APIs + Git → qualifies as Backend Engineer.

**Gap analysis:**
- For each category: if user has 0 matching skills → category is “missing”.
- Missing skills = all options in missing categories.

**Learning roadmap:**
- For each missing category: suggest learning any one skill from that category.

**Decision:** Use category-based format with OR within categories and AND across categories.

---

## 4. API Design: Security & AI Usage

### 4.1 Remove List Profiles

**Decision:** Remove `GET /api/profiles`. Users only access their own profile.

### 4.2 Profile Access Pattern

Since profile is 1:1 with user, use “current user” semantics:

| Endpoint | Purpose |
|----------|---------|
| `GET /api/profile` or `GET /api/profile/me` | Current user’s profile |
| `POST /api/profile` | Create profile (on first use) |
| `PUT /api/profile` | Update current user’s profile |

No `profileId` in URLs; ownership is implicit.

### 4.3 Resume Upload

**Decision:** Support both:
- `multipart/form-data` file upload (PDF/DOCX) → Tika → text → AI/keyword
- `application/json` text paste → AI/keyword

Example:

```
POST /api/profile/skills/extract
Content-Type: multipart/form-data
  - file: (optional) PDF/DOCX
  - text: (optional) pasted text
  - mergeStrategy: REPLACE | MERGE
```

If both `file` and `text` are present, prefer file (Tika → text) and ignore `text`.

### 4.4 AI Usage: One Place Only

**Decision:** Use AI only for skill extraction.

| Feature | Implementation |
|---------|----------------|
| **Skill extraction** | AI (primary) + keyword fallback |
| **Gap analysis** | Rule-based (category logic) |
| **Learning roadmap** | Rule-based (static skill → resources mapping) |

---

## 5. Final Locked Design Summary

### Auth
- JWT auth (reuse existing)
- Profile 1:1 with user
- All profile operations scoped to current user

### Skill Extraction
- Input: file (PDF/DOCX) or text
- File: Tika → text
- Extraction: AI → keyword fallback → manual if empty

### Roles Format
- Category-based with OR within categories
- At least one skill per category required

### API (Final)

| Method | Endpoint | Auth | Description |
|--------|----------|------|-------------|
| `POST` | `/api/profile` | Yes | Create profile |
| `GET` | `/api/profile` | Yes | Get current user’s profile |
| `PUT` | `/api/profile` | Yes | Update profile |
| `POST` | `/api/profile/skills` | Yes | Add skill(s) |
| `DELETE` | `/api/profile/skills/{skillId}` | Yes | Remove skill |
| `POST` | `/api/profile/skills/extract` | Yes | Extract from file or text |
| `GET` | `/api/roles` | No* | List roles |
| `GET` | `/api/roles/{roleId}` | No* | Get role |
| `GET` | `/api/profile/gaps?roleId=` | Yes | Gap analysis |
| `GET` | `/api/profile/roadmap?roleId=` | Yes | Learning roadmap |

\*Roles are reference data; can be public or protected.

### Data Model Adjustments

- `UserProfile.userId` (or `email`) → FK to `UserEntity`
- `Skill.profileId` → FK to `UserProfile`
- Roles loaded from JSON with `skillCategories` structure

---

## 6. Open Points (Optional)

1. **Register:** Reuse `/register` from Expensly or add a minimal registration flow for Skill-Bridge.
2. **Roles auth:** Keep `/api/roles` public for simplicity, or protect if you want everything behind auth.
3. **Profile creation:** Create profile on first access (lazy) or require explicit `POST /api/profile` after signup.

If you want, we can next lock these three and then move to implementation details (DB schema, DTOs, service interfaces).

---

**User**

yes now i want three things. Generate a uml (give the code for plantUml and mermaid code also), give the final architecture we decided (reusing Expensly's Auth), generate a hld.md plan for this as well (backend only)

---

**Cursor**

Generating the UML diagrams, final architecture, and backend HLD document.


Creating the UML diagrams, architecture, and HLD document.


In Ask mode I can’t create files, so here’s the content you can copy into your project.

---

# 1. UML Diagrams

## PlantUML – Class Diagram

Create `docs/skillbridge/uml.puml`:

```plantuml
@startuml Skill-Bridge Class Diagram
!theme plain
skinparam classAttributeIconSize 0
skinparam packageStyle rectangle

title Skill-Bridge Career Navigator - Class Diagram

package "Authentication (Reused from Expensly)" {
  class UserEntity {
    - id: Long
    - userId: String
    - name: String
    - email: String
    - password: String
    - verifyOtp: String
    - isAccountVerified: Boolean
    - createdAt: Timestamp
    - updatedAt: Timestamp
    --
    + getId(): Long
    + getEmail(): String
  }
}

package "Career Profile Domain" {
  class UserProfile {
    - id: Long
    - userId: String
    - targetRoleId: String
    - experienceLevel: ExperienceLevel
    - createdAt: LocalDateTime
    - updatedAt: LocalDateTime
    --
    + getId(): Long
    + getUserId(): String
    + getTargetRoleId(): String
  }

  class Skill {
    - id: Long
    - profileId: Long
    - name: String
    - category: String
    - proficiency: ProficiencyLevel
    - source: SkillSource
    - createdAt: LocalDateTime
    --
    + getId(): Long
    + getName(): String
    + getCategory(): String
  }

  class Role <<reference>> {
    - id: String
    - title: String
    - description: String
    - skillCategories: Map<String, List<String>>
    --
    + getId(): String
    + getSkillCategories(): Map
  }
}

package "Enums" {
  enum ExperienceLevel {
    ENTRY
    MID
    SENIOR
  }

  enum ProficiencyLevel {
    BEGINNER
    INTERMEDIATE
    EXPERT
  }

  enum SkillSource {
    MANUAL
    AI_EXTRACTED
  }
}

UserEntity "1" -- "1" UserProfile : owns >
UserProfile "1" -- "*" Skill : contains >
UserProfile "0..1" -- "1" Role : targets >
Role ..> ExperienceLevel : supports

@enduml
```

---

## PlantUML – Skill Extraction Sequence

Create `docs/skillbridge/sequence-extract.puml`:

```plantuml
@startuml Skill Extraction Sequence Diagram
!theme plain

title Skill Extraction Flow (AI + Fallback)

actor User
participant "ProfileController" as Controller
participant "SkillExtractionService" as Service
participant "TikaParser" as Tika
participant "AIService" as AI
participant "KeywordFallback" as Fallback
participant "SkillRepository" as Repo

User -> Controller: POST /api/profile/skills/extract\n(file or text)
Controller -> Controller: Validate input

alt File Upload (PDF/DOCX)
  Controller -> Tika: extractText(file)
  Tika --> Controller: rawText
else Text Paste
  Controller -> Controller: use text directly
end

Controller -> Service: extractSkills(text, userId, mergeStrategy)

Service -> AI: extractSkillsFromText(text)
alt AI Success
  AI --> Service: List<Skill>
  Service -> Repo: saveSkills(skills)
  Repo --> Service: saved
  Service --> Controller: ExtractResponse(skills, source=AI)
else AI Fails / Timeout / Unavailable
  AI --> Service: exception or empty
  Service -> Fallback: matchKeywords(text)
  Fallback --> Service: List<Skill>
  alt Fallback has results
    Service -> Repo: saveSkills(skills)
    Service --> Controller: ExtractResponse(skills, source=FALLBACK)
  else Fallback empty
    Service --> Controller: ExtractResponse(empty, source=NONE)
  end
end

Controller --> User: 200 OK + extracted skills\n(prompt manual if empty)

@enduml
```

---

## PlantUML – Gap Analysis Sequence

Create `docs/skillbridge/sequence-gap.puml`:

```plantuml
@startuml Gap Analysis Sequence Diagram
!theme plain

title Gap Analysis Flow (Rule-Based)

actor User
participant "GapController" as Controller
participant "GapAnalysisService" as Service
participant "ProfileService" as ProfileSvc
participant "RoleService" as RoleSvc

User -> Controller: GET /api/profile/gaps?roleId=backend-engineer
Controller -> Controller: Get userId from JWT

Controller -> Service: analyzeGaps(userId, roleId)

Service -> ProfileSvc: getProfileWithSkills(userId)
ProfileSvc --> Service: UserProfile + List<Skill>

Service -> RoleSvc: getRoleById(roleId)
RoleSvc --> Service: Role (skillCategories)

Service -> Service: For each category:\n  - Check if user has >= 1 matching skill\n  - OR: category is "missing"

Service -> Service: Build:\n  - matchedCategories\n  - missingCategories\n  - missingSkills\n  - matchScore = (matched/total)*100

Service --> Controller: GapAnalysisResponse

Controller --> User: 200 OK + gap analysis JSON

@enduml
```

---

## Mermaid – Class Diagram

```mermaid
classDiagram
    class UserEntity {
        -Long id
        -String userId
        -String name
        -String email
        -String password
        -Boolean isAccountVerified
        -Timestamp createdAt
        -Timestamp updatedAt
        +getId() Long
        +getEmail() String
    }

    class UserProfile {
        -Long id
        -String userId
        -String targetRoleId
        -ExperienceLevel experienceLevel
        -LocalDateTime createdAt
        -LocalDateTime updatedAt
        +getId() Long
        +getUserId() String
        +getTargetRoleId() String
    }

    class Skill {
        -Long id
        -Long profileId
        -String name
        -String category
        -ProficiencyLevel proficiency
        -SkillSource source
        -LocalDateTime createdAt
        +getId() Long
        +getName() String
        +getCategory() String
    }

    class Role {
        <<reference>>
        -String id
        -String title
        -String description
        -Map skillCategories
        +getId() String
        +getSkillCategories() Map
    }

    UserEntity "1" --> "1" UserProfile : owns
    UserProfile "1" --> "*" Skill : contains
    UserProfile "0..1" --> "1" Role : targets
```

---

## Mermaid – Skill Extraction Sequence

```mermaid
sequenceDiagram
    participant User
    participant Controller
    participant Service
    participant Tika
    participant AI
    participant Fallback
    participant Repo

    User->>Controller: POST /api/profile/skills/extract (file or text)
    Controller->>Controller: Validate input

    alt File Upload
        Controller->>Tika: extractText(file)
        Tika-->>Controller: rawText
    else Text Paste
        Controller->>Controller: use text directly
    end

    Controller->>Service: extractSkills(text, userId, mergeStrategy)
    Service->>AI: extractSkillsFromText(text)

    alt AI Success
        AI-->>Service: List of Skills
        Service->>Repo: saveSkills(skills)
        Service-->>Controller: ExtractResponse(source=AI)
    else AI Fails
        AI-->>Service: exception/empty
        Service->>Fallback: matchKeywords(text)
        Fallback-->>Service: List of Skills
        Service->>Repo: saveSkills(skills)
        Service-->>Controller: ExtractResponse(source=FALLBACK)
    end

    Controller-->>User: 200 OK + extracted skills
```

---

## Mermaid – Gap Analysis Sequence

```mermaid
sequenceDiagram
    participant User
    participant Controller
    participant GapService
    participant ProfileService
    participant RoleService

    User->>Controller: GET /api/profile/gaps?roleId=backend-engineer
    Controller->>Controller: Get userId from JWT
    Controller->>GapService: analyzeGaps(userId, roleId)

    GapService->>ProfileService: getProfileWithSkills(userId)
    ProfileService-->>GapService: UserProfile + Skills

    GapService->>RoleService: getRoleById(roleId)
    RoleService-->>GapService: Role (skillCategories)

    GapService->>GapService: Compare categories (OR within, AND across)
    GapService->>GapService: Compute matchScore, missingSkills

    GapService-->>Controller: GapAnalysisResponse
    Controller-->>User: 200 OK + gap analysis
```

---

# 2. Final Architecture Diagram

## PlantUML – System Architecture

```plantuml
@startuml Skill-Bridge Architecture
!theme plain
skinparam componentStyle rectangle

title Skill-Bridge Career Navigator - System Architecture (Backend)

package "Client" {
  [React Frontend] as Frontend
}

package "API Layer" {
  [ProfileController] as PC
  [RoleController] as RC
  [GapController] as GC
}

package "Service Layer" {
  [ProfileService] as PS
  [SkillExtractionService] as SES
  [RoleService] as RS
  [GapAnalysisService] as GAS
  [RoadmapService] as RMS
}

package "Skill Extraction" {
  [AISkillExtractionService] as AI
  [KeywordFallbackService] as KF
  [TikaTextExtractor] as Tika
}

package "Data Layer" {
  [ProfileRepository] as PR
  [SkillRepository] as SR
  database "H2/MySQL" as DB
  [roles.json] as JSON
}

package "Auth (Reused from Expensly)" {
  [JwtRequestFilter] as JWT
  [UserRepository] as UR
  [AuthController] as AC
}

Frontend --> PC : REST (JWT)
Frontend --> RC : REST
Frontend --> GC : REST
Frontend --> AC : login/register

PC --> PS
PC --> SES
GC --> GAS
GC --> RMS
RC --> RS

PS --> PR
PS --> SR
SES --> AI
SES --> KF
SES --> Tika
SES --> SR

AI ..> Tika : uses text from
KF ..> Tika : uses text from

GAS --> PS
GAS --> RS
RMS --> PS
RMS --> RS

RS --> JSON : load at startup
PR --> DB
SR --> DB
UR --> DB

JWT --> UR : validate token
JWT --> PC : authorize
JWT --> GC : authorize

@enduml
```

---

## Mermaid – System Architecture

```mermaid
flowchart TB
    subgraph Client
        Frontend[React Frontend]
    end

    subgraph APILayer["API Layer"]
        PC[ProfileController]
        RC[RoleController]
        GC[GapController]
        AC[AuthController]
    end

    subgraph ServiceLayer["Service Layer"]
        PS[ProfileService]
        SES[SkillExtractionService]
        RS[RoleService]
        GAS[GapAnalysisService]
        RMS[RoadmapService]
    end

    subgraph SkillExtraction["Skill Extraction"]
        AI[AISkillExtractionService]
        KF[KeywordFallbackService]
        Tika[TikaTextExtractor]
    end

    subgraph DataLayer["Data Layer"]
        PR[ProfileRepository]
        SR[SkillRepository]
        DB[(H2/MySQL)]
        JSON[roles.json]
    end

    subgraph Auth["Auth (Reused)"]
        JWT[JwtRequestFilter]
        UR[UserRepository]
    end

    Frontend -->|REST + JWT| PC
    Frontend -->|REST| RC
    Frontend -->|REST + JWT| GC
    Frontend -->|login/register| AC

    PC --> PS
    PC --> SES
    GC --> GAS
    GC --> RMS
    RC --> RS

    PS --> PR
    PS --> SR
    SES --> AI
    SES --> KF
    SES --> Tika
    SES --> SR

    AI -.->|text| Tika
    KF -.->|text| Tika

    GAS --> PS
    GAS --> RS
    RMS --> PS
    RMS --> RS

    RS --> JSON
    PR --> DB
    SR --> DB
    UR --> DB

    JWT --> UR
    JWT --> PC
    JWT --> GC
```

---

# 3. HLD.md – Backend High-Level Design

Create `docs/skillbridge/hld.md`:

```markdown
# Skill-Bridge Career Navigator — Backend High-Level Design (HLD)

## 1. Overview

Skill-Bridge is a career navigation platform that helps users identify skill gaps against target roles and provides a personalized learning roadmap. This document covers the backend architecture, design decisions, and implementation plan.

### 1.1 Key Design Decisions

| Decision | Choice | Rationale |
|----------|--------|-----------|
| Authentication | JWT (reuse Expensly) | Existing, tested, stateless |
| Profile Model | 1:1 with User | One profile per user, secure by design |
| Skill Extraction | AI + Keyword Fallback | AI primary; rule-based fallback when AI unavailable |
| Role Comparison | Category-based (OR within, AND across) | Realistic: "1 language OR 1 framework" per category |
| Gap/Roadmap | Rule-based | AI used only for extraction; deterministic logic elsewhere |

---

## 2. System Context

```
┌─────────────────────────────────────────────────────────────────┐
│                     Skill-Bridge Backend                         │
│  ┌─────────────┐  ┌─────────────┐  ┌─────────────────────────┐ │
│  │ Profile     │  │ Role        │  │ Gap Analysis & Roadmap   │ │
│  │ Management  │  │ Reference   │  │ (Rule-based)             │ │
│  └─────────────┘  └─────────────┘  └─────────────────────────┘ │
│  ┌─────────────────────────────────────────────────────────────┐│
│  │ Skill Extraction: AI → Keyword Fallback → Manual            ││
│  └─────────────────────────────────────────────────────────────┘│
└─────────────────────────────────────────────────────────────────┘
         │                    │                    │
         ▼                    ▼                    ▼
    [React App]          [roles.json]         [OpenAI API]
    (JWT Auth)           (synthetic)          (optional)
```

---

## 3. Architecture Layers

### 3.1 Layer Diagram

```
┌──────────────────────────────────────────────────────────────────┐
│  Controllers (REST)                                                │
│  ProfileController | RoleController | GapController               │
└─────────────────────────────┬────────────────────────────────────┘
                               │
┌─────────────────────────────▼────────────────────────────────────┐
│  Services (Business Logic)                                         │
│  ProfileService | SkillExtractionService | RoleService |           │
│  GapAnalysisService | RoadmapService                               │
└─────────────────────────────┬────────────────────────────────────┘
                               │
┌─────────────────────────────▼────────────────────────────────────┐
│  Repositories & External                                          │
│  ProfileRepository | SkillRepository | RoleLoader (JSON)         │
│  AIService | KeywordFallback | TikaParser                         │
└─────────────────────────────┬────────────────────────────────────┘
                               │
┌─────────────────────────────▼────────────────────────────────────┐
│  Data: MySQL/H2 | roles.json | OpenAI API                         │
└──────────────────────────────────────────────────────────────────┘
```

### 3.2 Auth Integration (Reused)

- **JwtRequestFilter**: Validates JWT from `Authorization: Bearer` or cookie
- **UserEntity**: Existing; `email` used as principal
- **Profile ownership**: `UserProfile.userId` = `UserEntity.email` (or userId)
- **All profile endpoints**: Require authentication; resolve profile by current user

---

## 4. Data Model

### 4.1 Entity Relationship

```
UserEntity (1) ──────< (1) UserProfile
                              │
                              │ (1:N)
                              ▼
                           Skill
```

### 4.2 Tables

**tbl_users** (existing)
- id, userId, name, email, password, verifyOtp, isAccountVerified, createdAt, updatedAt

**user_profiles**
| Column | Type | Constraints |
|--------|------|-------------|
| id | BIGINT | PK, auto-increment |
| user_id | VARCHAR(255) | FK → tbl_users.email, UNIQUE |
| target_role_id | VARCHAR(50) | nullable |
| experience_level | VARCHAR(20) | ENTRY, MID, SENIOR |
| created_at | TIMESTAMP | |
| updated_at | TIMESTAMP | |

**skills**
| Column | Type | Constraints |
|--------|------|-------------|
| id | BIGINT | PK, auto-increment |
| profile_id | BIGINT | FK → user_profiles.id |
| name | VARCHAR(100) | NOT NULL |
| category | VARCHAR(50) | nullable |
| proficiency | VARCHAR(20) | BEGINNER, INTERMEDIATE, EXPERT |
| source | VARCHAR(20) | MANUAL, AI_EXTRACTED |
| created_at | TIMESTAMP | |

### 4.3 Reference Data: roles.json

```json
{
  "roles": [
    {
      "id": "backend-engineer",
      "title": "Backend Engineer",
      "description": "Builds server-side logic, APIs, and data pipelines",
      "skillCategories": {
        "languages": ["Java", "Python", "JavaScript", "Go"],
        "frameworks": ["Spring Boot", "Django", "Express", "Gin"],
        "databases": ["SQL", "MongoDB", "PostgreSQL"],
        "coreConcepts": ["REST APIs", "Git"]
      }
    }
  ]
}
```

**Logic**: User needs ≥1 skill from each category (OR within category, AND across categories).

---

## 5. API Specification

### 5.1 Endpoints

| Method | Endpoint | Auth | Description |
|--------|----------|------|-------------|
| POST | /api/profile | Yes | Create profile |
| GET | /api/profile | Yes | Get current user's profile |
| PUT | /api/profile | Yes | Update profile |
| POST | /api/profile/skills | Yes | Add skill(s) |
| DELETE | /api/profile/skills/{skillId} | Yes | Remove skill |
| POST | /api/profile/skills/extract | Yes | Extract from file or text |
| GET | /api/roles | No | List roles |
| GET | /api/roles/{roleId} | No | Get role |
| GET | /api/profile/gaps?roleId= | Yes | Gap analysis |
| GET | /api/profile/roadmap?roleId= | Yes | Learning roadmap |

### 5.2 Key Request/Response

**POST /api/profile/skills/extract**
- Input: `multipart/form-data` (file) or `application/json` (text)
- Params: `mergeStrategy` = REPLACE | MERGE
- Response: `{ extractedSkills, source: AI|FALLBACK|NONE, skillsAdded }`

**GET /api/profile/gaps?roleId=backend-engineer**
- Response: `{ matchScore, matchedCategories, missingCategories, missingSkills, summary }`

---

## 6. Skill Extraction Flow

```
Input: File (PDF/DOCX) or Text
    │
    ├─ File → Tika → rawText
    └─ Text → rawText
    │
    ▼
AI Service (OpenAI/Claude)
    │
    ├─ Success → save skills, return (source=AI)
    └─ Fail → Keyword Fallback
              │
              ├─ Match → save skills, return (source=FALLBACK)
              └─ Empty → return empty, prompt manual (source=NONE)
```

---

## 7. Gap Analysis Algorithm (Rule-Based)

```
1. Load user profile + skills
2. Load role by roleId
3. For each category in role.skillCategories:
   - userSkillsInCategory = user skills that match any skill in category
   - if userSkillsInCategory.size() >= 1: category is MATCHED
   - else: category is MISSING, add all category skills to missingSkills
4. matchScore = (matchedCategories / totalCategories) * 100
5. Return { matchScore, matchedCategories, missingCategories, missingSkills, summary }
```

---

## 8. Package Structure

```
com.sravan.skillbridge/
├── SkillBridgeApplication.java
├── config/
│   └── OpenAIConfig.java
├── controller/
│   ├── ProfileController.java
│   ├── RoleController.java
│   └── GapController.java
├── dto/
│   ├── request/
│   │   ├── ProfileRequest.java
│   │   ├── SkillRequest.java
│   │   └── ExtractSkillsRequest.java
│   └── response/
│       ├── ProfileResponse.java
│       ├── ExtractSkillsResponse.java
│       ├── GapAnalysisResponse.java
│       └── RoadmapResponse.java
├── entity/
│   ├── UserProfile.java
│   └── Skill.java
├── repository/
│   ├── ProfileRepository.java
│   └── SkillRepository.java
├── service/
│   ├── ProfileService.java
│   ├── RoleService.java
│   ├── GapAnalysisService.java
│   ├── RoadmapService.java
│   ├── SkillExtractionService.java
│   └── impl/
│       ├── AISkillExtractionService.java
│       ├── KeywordFallbackExtractionService.java
│       └── TikaTextExtractor.java
├── model/
│   └── Role.java
└── exception/
    ├── BusinessException.java
    └── GlobalExceptionHandler.java
```

---

## 9. Dependencies

| Dependency | Purpose |
|------------|---------|
| spring-boot-starter-web | REST API |
| spring-boot-starter-data-jpa | Persistence |
| spring-boot-starter-security | Auth |
| spring-boot-starter-validation | Input validation |
| openai-java / OpenAI SDK | AI extraction |
| apache-tika | PDF/DOCX text extraction |
| mysql-connector-j / H2 | Database |

---

## 10. Configuration

- **application.yml**: DB, OpenAI API base URL
- **.env**: `OPENAI_API_KEY` (not committed)
- **.env.example**: Template with placeholder

---

## 11. Security

- All `/api/profile/*` and `/api/profile/**` require valid JWT
- Profile access: resolve by `userId` from JWT; no profileId in URL for ownership
- Roles: public (reference data)
- API keys: from environment only

---

## 12. Testing Strategy

| Test Type | Scope |
|-----------|-------|
| Unit | GapAnalysisService (category logic), KeywordFallback |
| Integration | ProfileController CRUD, ExtractSkills (with mock AI) |
| Edge Cases | AI timeout, empty text, invalid roleId, duplicate skills |

---

## 13. Future Enhancements

- Resume parsing for more formats (e.g. images)
- AI-generated learning roadmap (optional)
- Role comparison (multiple roles)
- Export profile as PDF
```

---

To use this in your repo, switch to Agent mode and I can create these files under `docs/skillbridge/` for you.

---

**User**

i have made a copy of expensly project. so you can resue thsi repo by deleteing and adding required files.@pom.xml (1-150) -> is this sufficient

---

**Cursor**

Checking the pom for missing or conflicting dependencies:


Here’s a concise assessment of your `pom.xml` for Skill-Bridge.

---

# POM analysis for Skill-Bridge

## Sufficient for Skill-Bridge

| Dependency | Purpose |
|------------|---------|
| spring-boot-starter-web | REST API |
| spring-boot-starter-data-jpa | Persistence |
| spring-boot-starter-security | Auth |
| spring-boot-starter-validation | Input validation |
| spring-boot-starter-test | Tests |
| jjwt | JWT auth |
| lombok | Boilerplate reduction |
| mysql-connector-j | Database |
| spring-ai-starter-model-openai-sdk | AI skill extraction |
| spring-ai-tika-document-reader | PDF/DOCX parsing |
| spring-boot-starter-mail | Auth (reset/verify) |
| spring-boot-starter-thymeleaf | Email templates (if used) |
| jaxb-api | JWT (XML binding) |

---

## Fix: `spring-ai.version` not defined

`dependencyManagement` uses `${spring-ai.version`} but it’s not set in properties. Add it:

```xml
<properties>
    <java.version>21</java.version>
    <spring-ai.version>1.0.0</spring-ai.version>
</properties>
```

---

## Optional: H2 for demo

For a demo without MySQL, you can add H2:

```xml
<dependency>
    <groupId>com.h2database</groupId>
    <artifactId>h2</artifactId>
    <scope>runtime</scope>
</dependency>
```

---

## Optional: Remove Thymeleaf

If you remove Thymeleaf and mail templates, you can drop:

- `spring-boot-starter-thymeleaf`
- `thymeleaf-spring5`

Only do this if you simplify auth (e.g. no email verification). Keep them if you reuse Expensly’s full auth flow.

---

## Recommended changes for Skill-Bridge

| Change | Action |
|--------|--------|
| Add `spring-ai.version` | Required |
| Rename artifact/name | `expensly` → `skillbridge` |
| Add H2 (optional) | For easier demo setup |
| Remove Thymeleaf (optional) | If auth is simplified |

---

## Minimal pom edits for Skill-Bridge

1. Add `spring-ai.version` in `properties`.
2. Update artifact/name/description:

```xml
<artifactId>skillbridge</artifactId>
<name>skillbridge</name>
<description>Skill-Bridge Career Navigator - Palo Alto Take-Home</description>
```

3. (Optional) Add H2 for demo.

---

## Summary

- The current dependencies are enough for Skill-Bridge.
- You must add `spring-ai.version` in `properties`.
- Rename the project and optionally add H2 and/or remove Thymeleaf as above.

