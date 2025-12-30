


# 🏧 ATM Simulation Service

> **Core Concept:** Aspect-Oriented Programming (AOP) with `@Aspect`

## 📖 Project Overview
The **ATM Simulation** is a backend service mimicking core banking operations (Withdraw, Deposit).

In a standard banking application, we often need to apply rules across multiple methods without modifying the core business logic.
* **Security:** "If a withdrawal is over ₹10,000, force a PIN check."
* **Logging:** "Print a receipt after every successful deposit."
* **Performance:** "Track how long the withdrawal process takes."

Writing these checks inside the main service (`AtmService`) would make the code messy and hard to maintain.

This project solves that problem using **Spring AOP**. By using the `@Aspect` annotation, I separated these "cross-cutting concerns" into a dedicated aspect class (`AtmAspect`), keeping the main service clean and focused solely on the transaction logic.

---

## 🏗️ Architecture & Design Pattern

This project implements the **Proxy Pattern** via Spring AOP.

### The Problem
* **Tangled Code:** Mixing security checks (PIN validation) directly with money transfer logic.
* **Code Duplication:** Repeating logging lines in every method.

### The Solution: `@Aspect`
I utilized the `@Aspect` annotation to intercept method calls at runtime.

**Key Components:**
1.  **`AtmService`:** Pure business logic. It simply returns "Success" or "Failure". It knows *nothing* about PINs or Timers.
2.  **`AtmAspect`:** A centralized class that "weaves" security and logging logic around the service methods.
3.  **`AtmController`:** Exposes REST endpoints (`/atm/withdraw`, `/atm/deposit`) to trigger the simulation.

---

## 💻 Technical Implementation

Here is the exact implementation logic used in the `com.prasanna.atm_simulation` package:

### 1. The Core Service (`AtmService.java`)
Notice how clean the method is. It does not handle security or logging.
```java
@Service
public class AtmService {

    // 1. Withdraw Method
    public String withdraw(int amount) {
        System.out.println("💰 [ATM MACHINE] Dispensing " + amount + "...");
        return "SUCCESS: Withdrew " + amount;
    }

    // 2. Deposit Method
    public void deposit(int amount) {
        System.out.println("KW [ATM MACHINE] Accepting " + amount + "...");
    }
}

```

### 2. The Aspect (`AtmAspect.java`)

This class handles the cross-cutting concerns.

**Scenario A: Security Check (`@Before`)**
Intercepts the `withdraw` method. If the amount is > 10,000, it enforces a simulated security check.

```java
@Before("execution(* com.prasanna.atm_simulation.service.AtmService.withdraw(..)) && args(amount)")
public void verifyPin(int amount) {
    if (amount > 10000) {
        System.out.println("🚨 [SECURITY] ALERT! High value transaction. PIN Required.");
        // Logic to verify PIN...
    }
}

```

**Scenario B: Performance Monitoring (`@Around`)**
Wraps the `withdraw` method to calculate execution time (Latency).

```java
@Around("execution(* com.prasanna.atm_simulation.service.AtmService.withdraw(..))")
public Object measureTime(ProceedingJoinPoint joinPoint) throws Throwable {
    System.out.println("⏱️ [TIMER] Transaction Started...");
    long start = System.currentTimeMillis();

    Object result = joinPoint.proceed(); // Execute the actual method

    long end = System.currentTimeMillis();
    System.out.println("⏱️ [TIMER] Transaction Finished in " + (end - start) + "ms");
    return result;
}

```

**Scenario C: Post-Transaction Logging (`@After`)**
Automatically prints a receipt after a `deposit` is finished.

```java
@After("execution(* com.prasanna.atm_simulation.service.AtmService.deposit(..))")
public void printReceipt() {
    System.out.println("🧾 [PRINTER] Printing Receipt: 'Deposit Successful'");
}

```

---

## ⚙️ How to Run

1. **Clone the repository.**
2. **Build the project:**
```bash
mvn clean install

```


3. **Run the application:**
```bash
mvn spring-boot:run

```


4. **Test the Concept (via Postman or Browser):**
* **Normal Withdrawal:** `GET /atm/withdraw?amount=5000`
* *Result:* Transaction runs normally.


* **High-Value Withdrawal:** `GET /atm/withdraw?amount=50000`
* *Result:* Console shows `[SECURITY] ALERT!` before dispensing cash.


* **Deposit:** `GET /atm/deposit?amount=2000`
* *Result:* Console shows `[PRINTER] Printing Receipt` after acceptance.
---

## 🧠 Learning Outcomes

By building this project, I mastered:

* **Separation of Concerns:** Decoupling Security logic from Business logic.
* **Advice Types:** Understanding when to use `@Before` (Validation) vs `@After` (Logging) vs `@Around` (Performance).
* **JoinPoints:** Accessing method arguments (like `amount`) inside the Aspect.

---

*Developed by **Prasanna Lakshmi Motati***

```

```
