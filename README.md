# 📚 Library Management System

## 📖 About the Project

The **Library Management System** is a backend application developed in **Java** that simulates the core operations of a library.

The system manages **books**, **users**, and **loans**, storing all data in a **MySQL database** using **JDBC** for database communication.

This project was created to practice fundamental **backend development concepts**, including:

* Object-Oriented Programming (OOP)
* Database integration with JDBC
* DAO (Data Access Object) design pattern
* CRUD operations
* Relational database modeling
* Code organization in a layered architecture

---

# 🚀 Features

The system currently supports the following operations:

* 📚 Register books
* 👤 Register users
* 🔄 Register book loans
* 🔍 Retrieve records from the database
* ✏ Update existing records
* ❌ Delete records

### Relationship Rules

The system follows a relational model where:

* A **user can borrow multiple books**
* A **book can be borrowed multiple times over time**

---

# 🛠 Technologies Used

* **Java**
* **JDBC**
* **MySQL**
* **Maven**
* **Git & GitHub**

---

# 🗂 Project Structure

```
src
├── model
│    ├── Livro.java
│    ├── Usuario.java
│    └── Emprestimo.java
│
├── dao
│    ├── LivroDAO.java
│    ├── UsuarioDAO.java
│    └── EmprestimoDAO.java
│
├── connection
│    └── ConnectionFactory.java
│
└── Main.java
```

### Explanation

**model**

Contains the entity classes that represent the database tables.

**dao**

Responsible for communication with the database using JDBC.
Each DAO implements **CRUD operations**.

**connection**

Manages the database connection configuration.

**Main**

Entry point of the application, used to test system functionalities through a console menu.

---

# 🗄 Database Structure

The system uses **three main tables**.

## 📚 books

| Column           | Type    |
| ---------------- | ------- |
| id               | INT     |
| title            | VARCHAR |
| author           | VARCHAR |
| publication_year | INT     |

---

## 👤 users

| Column | Type    |
| ------ | ------- |
| id     | INT     |
| name   | VARCHAR |
| email  | VARCHAR |

---

## 🔄 loans

| Column      | Type |
| ----------- | ---- |
| id          | INT  |
| user_id     | INT  |
| book_id     | INT  |
| loan_date   | DATE |
| return_date | DATE |

### Relationships

* `user_id` → references **users**
* `book_id` → references **books**

---

# ⚙ How to Run the Project

### 1️⃣ Clone the repository

```
git clone https://github.com/your-username/library-system.git
```

### 2️⃣ Create the database

```sql
CREATE DATABASE library;
```

### 3️⃣ Configure the database connection

Edit the credentials inside:

```
ConnectionFactory.java
```

Example:

```java
String url = "jdbc:mysql://localhost:3306/library";
String user = "root";
String password = "your_password";
```

---

### 4️⃣ Run the project

Run the `Main.java` file to test the system operations using the console interface.

---

# 📷 Project Demonstration

You can include screenshots such as:

```
/images/database.png
/images/loan-example.png
/images/code-example.png
```

Example:

```
![Database](images/database.png)
```

---

# 🎯 Learning Goals

This project was developed to improve knowledge in:

* Java backend development
* JDBC database interaction
* Relational database design
* Code organization using the DAO pattern
* Building console-based backend systems

---

# 📌 Future Improvements

Possible future improvements include:

* 🌐 REST API with **Spring Boot**
* 🖥 Frontend interface
* 🔐 Authentication and authorization system
* 📊 Pagination for database queries
* 🐳 Dockerized database environment
