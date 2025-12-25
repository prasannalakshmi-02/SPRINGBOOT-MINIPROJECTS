
 🚀 Notification Engine (Feature Flag Edition)

A Spring Boot backend service demonstrating **Dynamic Bean Loading** and **Feature Flagging**. This project uses the `@ConditionalOnProperty` annotation to load specific service implementations (Email vs. SMS) into memory based on a configuration file, optimizing resource usage.

---

## 🛠️ Tech Stack
* **Language:** Java 17 / 21
* **Framework:** Spring Boot 3.x
* **Build Tool:** Maven
* **Key Concept:** Conditional Bean Creation

---

## 🌟 Key Features
### 1. Feature Flagging Strategy
* Implemented a "switch" mechanism using `@ConditionalOnProperty`.
* The application decides **at startup** which class to instantiate (`EmailNotificationService` or `SmsNotificationService`).
* **Efficiency:** Unlike standard `if-else` logic where both objects exist in memory, here **only the chosen bean is created**. The unused service is never loaded, saving memory.

### 2. Configurable Properties
* The entire behavior of the backend changes simply by editing one line in `application.properties`.
* No code changes or recompilation required to switch providers.

---

## 📂 Project Architecture

```text
src/main/java/com/prasanna/notification
│
├── controller
│   └── NotificationController.java  # Agnostic Controller (Doesn't know if it's Email or SMS)
│
└── service
    ├── NotificationService.java     # The Contract (Interface)
    ├── EmailNotificationService.java# Loads ONLY if app.mode=email
    └── SmsNotificationService.java  # Loads ONLY if app.mode=sms

```

---

## ⚙️ Configuration & Setup

### The Magic Switch

The behavior is controlled entirely by `src/main/resources/application.properties`.

**Mode 1: Email Service**
To enable Email notifications:

```properties
app.notification.mode=email
server.port=9090

```

*Effect: Spring creates `EmailNotificationService`. `SmsNotificationService` is ignored.*

**Mode 2: SMS Service**
To switch to SMS notifications:

```properties
app.notification.mode=sms
server.port=9090

```

*Effect: Spring creates `SmsNotificationService`. `EmailNotificationService` is ignored.*

---

## 🚀 How to Run

### 1. Clone the Parent Repository

https://github.com/prasannalakshmi-02/SPRINGBOOT-MINIPROJECTS.git

2. Navigate to the Project
cd SPRINGBOOT-MINIPROJECTS/notification-engine

4. Set Notification Mode
Open src/main/resources/application.properties and set:
properties
app.notification.mode=email
or
app.notification.mode=sms

5. Run the Application
mvn spring-boot:run

6. Test the Endpoint
Open your browser or Postman.

http://localhost:9090/send?msg=HelloPrasanna

Response (Email mode): 📧 EMAIL sent: HelloPrasanna

Response (SMS mode): 📱 SMS sent: HelloPrasanna

---

## 🧠 Learning Outcomes

This project demonstrates mastery of:

* **Spring Boot Conditionals:** Using `@ConditionalOnProperty` to control the IoC Container.
* **Interface-Driven Design:** Decoupling the Controller from specific implementations.
* **Property Management:** Externalizing configuration for safer deployments.

---

## 👤 Author

**Prasanna Lakshmi Motati**

* Backend Developer


