

# EduAdmin 🎓

EduAdmin is a **College Administration System** built using **Java and Spring Boot**.
It provides a powerful backend for managing **students, teachers, parents, guardians, fees, and transactions** in an educational institution.

This project focuses on creating **REST APIs** and secure data management to support a modern education management system.

---

## 🚀 Features

* **Student Management**

  * Add, update, and manage student details
  * Admission records, roll numbers, classes, and sections

* **User & Role Management**

  * Students, Teachers, Parents, and Guardians
  * Role-based authentication and authorization

* **Fee & Transactions**

  * Add and manage fee structures
  * Track transactions, pending dues, and receipts

* **Library (Planned)**

  * Manage books, issue/return, and student-library records

* **Secure APIs**

  * RESTful endpoints with Spring Boot
  * Validation, error handling, and DTOs

---

## 🛠️ Tech Stack

* **Language:** Java
* **Framework:** Spring Boot
* **Database:** PostgreSQL / MySQL
* **ORM:** Spring Data JPA / Hibernate
* **Security:** Spring Security (JWT planned)
* **Build Tool:** Maven / Gradle
* **Testing:** JUnit, Mockito
* **API Testing:** Postman

---

## 📂 Project Structure

```
eduadmin-backend/
 ├── src/main/java/com/education/eduadmin
 │    ├── controller     # REST Controllers
 │    ├── dto            # Data Transfer Objects
 │    ├── entity         # JPA Entities
 │    ├── repository     # Spring Data JPA Repositories
 │    ├── service        # Business Logic Layer
 │    └── EduAdminApp.java # Main Application
 ├── src/main/resources
 │    ├── application.properties # DB config & settings
 └── pom.xml            # Maven dependencies
```

---

## ⚡ Getting Started

### Prerequisites

* Java 17+
* Maven
* PostgreSQL/MySQL

### Installation & Run

1. **Clone the repository**

   ```bash
   git clone https://github.com/iuzaifa/eduadmin.git
   cd eduadmin/backend
   ```

2. **Configure Database**
   Update your `application.properties` or `application.yml` with DB credentials:

   ```properties
   spring.datasource.url=jdbc:postgresql://localhost:5432/eduadmin
   spring.datasource.username=your_username
   spring.datasource.password=your_password
   spring.jpa.hibernate.ddl-auto=update
   ```

3. **Run the Application**

   ```bash
   mvn spring-boot:run
   ```

4. **Test APIs**

   * Base URL: `http://localhost:8080/api/v1/`
   * Use Postman/Swagger to test endpoints

---

## 📊 Project Status

* ✅ Student & User APIs
* ✅ Guardian ↔ User Mapping
* ✅ Fee & Transaction APIs
* 🔄 Library APIs *(in progress)*
* 🔄 JWT Authentication *(planned)*

---

## 🤝 Contribution

Contributions are welcome! Fork the repo, raise issues, and submit pull requests.

---

## 📜 License

This project is licensed under the MIT License.

---

👉 Do you also want me to **add example API endpoints** (like `/api/v1/students`, `/api/v1/fees`) to the README so anyone can directly test your project?
