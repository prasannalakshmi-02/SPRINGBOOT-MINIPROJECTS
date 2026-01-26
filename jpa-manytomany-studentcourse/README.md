# 🎓 Student Course Management System

A robust backend REST API built with **Spring Boot** to manage Students and Courses. This project demonstrates advanced database relationships, specifically **Many-to-Many mapping**, using Spring Data JPA and Hibernate.

## 🚀 Key Features

* **RESTful API:** Full CRUD operations for Students and Courses.
* **Advanced JPA Mapping:**
    * **Many-to-Many:** Students can enroll in multiple courses, and courses can have multiple students.
    * **Loose Coupling:** Uses a hidden Join Table (`student_courses`) to manage relationships.
* **DTO Pattern:**
    * Clean separation between Entities and API responses using **ModelMapper**.
    * **Slim DTOs:** Optimized endpoints (e.g., fetching students without their full course history).
* **Analytics & Filtering:**
    * Find the "Most Popular Course" using Java Streams.
    * Filter students by Course Title using Request Parameters.
    * "My Courses" endpoint (Inverse querying).

## 🛠️ Tech Stack

* **Java 17**
* **Spring Boot 3**
* **Spring Data JPA (Hibernate)**
* **MySQL Database**
* **ModelMapper** (Entity-DTO conversion)
* **Lombok** (Boilerplate reduction)
* **Maven**

## 🔌 API Endpoints

### 👤 Student Controller
| Method | URL | Description |
| :--- | :--- | :--- |
| `POST` | `/api/students` | Create a new Student |
| `GET` | `/api/students` | Get all Students |
| `GET` | `/api/students?courseTitle=Java` | **Filter:** Get Students enrolled in a specific course |
| `POST` | `/api/students/{stdId}/courses/{crsId}` | **Action:** Assign a Course to a Student |

### 📚 Course Controller
| Method | URL | Description |
| :--- | :--- | :--- |
| `POST` | `/api/courses` | Create a new Course |
| `GET` | `/api/courses` | Get all Courses |
| `GET` | `/api/courses/student/{studentId}` | **Inverse:** Get all courses for a specific Student |
| `GET` | `/api/courses/popular` | **Analytics:** Get the course with the highest enrollment |

## ⚙️ Configuration (`application.properties`)

Make sure your MySQL server is running and update your credentials:

properties
spring.application.name=StudentCoursePlatform
spring.datasource.url=jdbc:mysql://localhost:3306/student_course_db
spring.datasource.username=root
spring.datasource.password=YOUR_PASSWORD_HERE
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

🏗️ Project Structure

src/main/java/com/prasanna/student_course_platform
├── controller   # REST Controllers (API Layer)
├── dto          # Data Transfer Objects (StudentDto, StudentSummaryDto)
├── entity       # JPA Entities (Student, Course)
├── repository   # Interfaces extending JpaRepository
└── service      # Business Logic (ServiceImpl)

💡 Learning Highlights
Solved the "Infinite Recursion" (StackOverflowError) issue in Bidirectional relationships using Sets and careful DTO design.

Implemented custom JPQL / Derived Queries for inverse fetching.

Used Java Streams (.map, .max) for data processing within the Service layer.

Author: Prasanna Lakshmi Motati Built as part of Final Year B.Tech (AI) Learning Journey.
