# LifestyleSurveyBackend – Milestone 3

## 📌 Milestone 3: Goal Management & Gamification System (Backend)

This milestone extends the existing Lifestyle Survey backend by introducing a **goal-based gamification system**.  
The implementation follows a **layered Spring Boot architecture** and focuses entirely on backend logic.

---

## 🎯 Objectives of Milestone 3

- Design a Goal Management System
- Provide APIs for Goal Creation & Configuration
- Track Goal Progress dynamically
- Implement a Badge & Achievement System
- Automate Badge Assignment on Goal Completion
- Generate a Leaderboard based on user achievements

---

## 🧱 Backend Architecture

The backend follows standard Spring Boot layered architecture:

LifestyleSurveyBackend
├── controller
│ ├── GoalController.java
│ └── LeaderboardController.java
│
├── service
│ ├── GoalService.java
│ └── BadgeService.java
│
├── repository
│ ├── GoalRepository.java
│ ├── GoalProgressRepository.java
│ └── UserBadgeRepository.java
│
├── entity
│ ├── Goal.java
│ ├── GoalProgress.java
│ ├── Badge.java
│ └── UserBadge.java
│
└── dto
├── GoalRequestDTO.java
└── ProgressUpdateDTO.java

---

## 🧩 Component Description

### 🔹 Controller Layer
- **GoalController**
  - Create goals
  - Update goal progress
- **LeaderboardController**
  - Fetch leaderboard rankings based on badge points

### 🔹 Service Layer
- **GoalService**
  - Handles goal creation
  - Calculates progress percentage
  - Marks goals as completed
  - Triggers badge assignment
- **BadgeService**
  - Automatically assigns badges when goals are completed

### 🔹 Repository Layer
- Uses Spring Data JPA for database operations
- No manual SQL required
- Includes custom query for leaderboard generation

### 🔹 Entity Layer
- Maps Java classes to database tables
- Represents Goals, Progress, Badges, and User Achievements

### 🔹 DTO Layer
- Defines request payloads for APIs
- Ensures clean data transfer between client and backend

---

## 🔄 Workflow (How the System Works)

1. User creates a goal using the Goal API
2. Goal is stored with status `ACTIVE`
3. User updates progress
4. Progress percentage is calculated
5. If progress ≥ 100%:
   - Goal is marked `COMPLETED`
   - Badge is automatically assigned
6. Badge points contribute to leaderboard ranking

---

## 🏆 Gamification Features

- **Automated Badge Assignment**
- **Point-based Achievement System**
- **Dynamic Leaderboard using Aggregated Scores**

---

## 🛠 Technologies Used

- Java 17
- Spring Boot
- Spring Data JPA
- MySQL
- RESTful APIs

---


## ✅ Milestone 3 Outcome

This milestone successfully introduces **goal tracking and gamification**, improving user engagement and enabling future extensions such as carbon footprint goal analysis and analytics.

---


