
# Vehicle Registry Service (JPA One-to-One Mapping) 🚗📄

A Spring Boot backend application demonstrating **One-to-One Unidirectional Mapping** using Spring Data JPA. This project simulates a real-world scenario of a **Vehicle** and its corresponding **Registration Certificate (RC)**.

It implements industry best practices including **DTOs**, **ModelMapper**, **Cascade Types**, and **RESTful API design**.

## 🛠️ Tech Stack

* **Java 17**
* **Spring Boot 3.x** (Web, Data JPA)
* **MySQL** (Database)
* **Hibernate** (ORM)
* **ModelMapper** (DTO Conversion)
* **Lombok** (Boilerplate reduction)
* **Maven** (Build Tool)

## 📂 Project Structure

src/main/java/com/example/vehicleregistry
├── controller     # API Endpoints (VehicleController)
├── dto            # Data Transfer Objects (VehicleDTO, RcDTO)
├── entity         # DB Tables (Vehicle, RC)
├── repository     # Database Access (VehicleRepository)
└── service        # Business Logic (VehicleService)


## 🚀 Key Features

* **One-to-One Unidirectional Mapping:** `Vehicle` (Parent) owns `RC` (Child).
* **Cascade Operations:** Saving/Deleting a Vehicle automatically saves/deletes the RC.
* **DTO Pattern:** Secure data transfer without exposing Entities directly.
* **Custom Queries:** Search Vehicle by nested RC Number.
* **Update Logic:** Modify Child entity (RC expiry) through the Parent (Vehicle).

## 🔌 API Endpoints (Postman)

### 1. Register a Vehicle (Create)

**POST** api/register

{
    "brand": "Mahindra",
    "model": "Thar",
    "price": 1800000,
    "rc": {
        "rcNumber": "TS-09-TH-1111",
        "issuingRto": "Hyderabad Central",
        "expiryDate": "2030-12-31"
    }
}



### 2. Get Vehicle Details (Read)

**GET** /api/{id}

* Example: /api/vehicles/1

### 3. Renew RC (Update Child via Parent)

**PUT** `/api/{id}/renew-rc?date={YYYY-MM-DD}`

* Example: `/api/1/renew-rc?date=2040-01-01`

### 4. Deregister Vehicle (Cascade Delete)

**DELETE** `/api/{id}`

* Example: `/api/1`

## ⚙️ Setup & Installation

**1. Clone the Repository**

```bash
git clone https://github.com/your-username/jpa-one-to-one-vehicle.git
cd jpa-one-to-one-vehicle

```

**2. Configure Database**
Update `src/main/resources/application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/vehicle_db?createDatabaseIfNotExist=true
spring.datasource.username=root
spring.datasource.password=YOUR_PASSWORD

```

**3. Run the Application**

```bash
mvn spring-boot:run

```

## 🧪 Testing

Use **Postman** to test the endpoints.

* Ensure MySQL is running.
* The application runs on `http://localhost:8080`.

## 📝 Learning Outcomes

This project is a practical implementation of:

* `@OneToOne` mapping with `@JoinColumn`.
* Handling `CascadeType.ALL` and `FetchType`.
* Using `ModelMapper` for Entity-DTO conversion.
