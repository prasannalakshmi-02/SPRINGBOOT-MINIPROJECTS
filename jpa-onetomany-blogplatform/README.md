# 📝 Blogging Platform API (Spring Boot + JPA)

A robust Backend REST API built to demonstrate advanced **Spring Data JPA mappings**, specifically the **One-to-Many** relationship between Users and Blog Posts. This project implements industry-standard practices like DTOs, Service Layer abstraction, and Cascade deletions.

## 🚀 Tech Stack
* **Language:** Java 17+
* **Framework:** Spring Boot 3
* **Database:** MySQL
* **ORM:** Hibernate / Spring Data JPA
* **Tools:** Postman, Maven, ModelMapper
* **IDE:** IntelliJ IDEA

## ✨ Key Features
* **One-to-Many Mapping:** A single User can have multiple Blog Posts.
* **Cascade Delete:** Deleting a User automatically deletes all their associated Posts (orphaned records are removed).
* **DTO Pattern:** Clean separation between Database Entities and API responses using ModelMapper.
* **CRUD Operations:** Complete Create, Read, Update, and Delete functionality for both Users and Posts.
* **Service Layer:** Business logic is isolated from Controllers.

---

## 🔌 API Endpoints

### 👤 User Management
| Method | Endpoint | Description |
| :--- | :--- | :--- |
| **POST** | `/api/users` | Create a new User |
| **GET** | `/api/users` | Get all Users |
| **GET** | `/api/users/{id}` | Get a specific User (includes their Posts) |
| **PUT** | `/api/users/{id}` | Update User details |
| **DELETE** | `/api/users/{id}` | **Delete User & all their Posts (Cascade)** |

### 📝 Post Management
| Method | Endpoint | Description |
| :--- | :--- | :--- |
| **POST** | `/api/posts/user/{userId}` | Create a Post linked to a specific User |
| **GET** | `/api/posts/user/{userId}` | Get all Posts written by a specific User |
| **GET** | `/api/posts/{id}` | Get a single Post by ID |
| **PUT** | `/api/posts/{id}` | Update Post content |
| **DELETE** | `/api/posts/{id}` | Delete a specific Post |


## ⚙️ Configuration
To run this locally, update `src/main/resources/application.properties` with your MySQL credentials:

properties
spring.datasource.url=jdbc:mysql://localhost:3306/blog_db
spring.datasource.username=root
spring.datasource.password=YOUR_PASSWORD
spring.jpa.hibernate.ddl-auto=update


🧪 JSON Examples for Testing
1. Create User (POST /api/users)

{
    "name": "Prasanna",
    "email": "prasanna@example.com"
}

2. Create Post (POST /api/posts/user/1)
{
    "title": "Learning Spring Boot",
    "content": "One-to-Many mapping is powerful!"
}

👩‍💻 Author
Prasanna Lakshmi Motati Final Year B.Tech (AI Branch) Aspiring Backend Developer specializing in Java, Spring Boot, and Microservices.
