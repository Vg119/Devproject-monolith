# My app

A production-ready Spring Boot backend application built with clean design principles and a product-engineering mindset.

---

## Overview

**loveable.dev** is a modular monolithic backend system designed to deliver reliable, maintainable, and scalable business functionality.

The project demonstrates:

- Clean code practices
- Layered application design
- Strong domain modeling
- RESTful API development
- Structured error handling
- Professional Git workflow

---

##  Tech Stack

- Java 17
- Spring Boot
- Spring Data JPA
- Hibernate
- PostgreSQL / MySQL
- Maven
- Lombok
- SLF4J Logging

---

##  Core Features

- Project Management
- Member Management
- Contribution Module
- Soft Delete Support
- Global Exception Handling
- Validation & Structured API Responses

---

## 🧪 Running Locally

### 1. Clone the Repository

```bash
git clone https://github.com/<your-username>/loveable.dev.git
cd loveable.dev
```

### 2. Configure Database

Update your `application.yml`:

```yaml
spring:
  datasource:
    url: jdbc:postgresql://localhost:9000/testDB
    username: your_username
    password: your_password
```

### 3. Build and Run

```bash
mvn clean install
mvn spring-boot:run
```

Application runs at:

```
http://localhost:8081
```

---

##  Git Workflow

- `main` → stable branch
- `dev` → active development
- Feature branches → merged into `dev`
- `dev` → merged into `main` after validation

---

##  Future Scope

- Docker support
- CI/CD integration
- API documentation (OpenAPI/Swagger)
- Test coverage improvements





---

Built with love ,
---
Regards 
---
