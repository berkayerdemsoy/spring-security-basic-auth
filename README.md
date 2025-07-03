# Spring Boot Basic Authentication Demo

This project demonstrates a simple user authentication and role-based authorization setup using Spring Boot, Spring Security, and H2 in-memory database.

## ✅ Features

- 🔐 Basic Authentication with HTTP headers
- 👥 User registration with default `ROLE_USER`
- 🛡️ Role-based access control (`ROLE_ADMIN`, `ROLE_USER`)
- 🧑‍💻 In-memory H2 database integration
- 💾 Password encryption using BCrypt
- 🔄 Auto-creation of default admin user via `DataLoader`
- 🔍 `/h2-console` enabled for development

---

## 🧱 Tech Stack

- Java 17+
- Spring Boot
- Spring Security
- H2 Database
- Maven
- Postman (for testing)

---

## 📂 Endpoints

| Method | Endpoint        | Access         | Description                  |
|--------|------------------|----------------|------------------------------|
| POST   | `/register`      | Public         | Create new user (default role: USER) |
| GET    | `/hello`         | USER / ADMIN   | Protected greeting endpoint |
| GET    | `/admin/**`      | ADMIN only     | Admin-only protected routes |
| GET    | `/h2-console`    | Public         | Access H2 database UI |

---

## 🔐 Default Admin Credentials

```text
username: admin
password: admin123
