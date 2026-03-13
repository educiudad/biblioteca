# biblioteca
About the Project

The Library Management System is a backend application developed in Java that simulates the core operations of a library.
The system manages books, users, and loans, storing all data in a MySQL database using JDBC for database communication.

This project was created to practice backend development concepts such as:

Object-Oriented Programming (OOP)

Database integration

DAO (Data Access Object) Pattern

CRUD operations

Relational database modeling

🚀 Features

📚 Register books

👤 Register users

🔄 Register book loans

🔍 Retrieve data from the database

✏ Update records

❌ Delete records

The project uses relational data modeling where:

A user can borrow multiple books

A book can be borrowed multiple times over time

🛠 Technologies Used

Java

JDBC

MySQL

Maven

Git & GitHub

🗂 Project Structure
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
Explanation

model

Contains the entity classes representing database tables.

dao

Responsible for database communication using JDBC.
Each DAO implements CRUD operations.

connection

Manages the database connection.

Main

Used to test the system functionalities.

🗄 Database Structure

The system uses three main tables:

📚 books
Column	Type
id	INT
title	VARCHAR
author	VARCHAR
publication_year	INT
👤 users
Column	Type
id	INT
name	VARCHAR
email	VARCHAR
🔄 loans
Column	Type
id	INT
user_id	INT
book_id	INT
loan_date	DATE
return_date	DATE

Relationships:

user_id → references users

book_id → references books

⚙ How to Run the Project
1 Clone the repository
git clone https://github.com/your-username/library-system.git
2 Create the database
CREATE DATABASE library;
3 Configure the connection

Edit the database credentials inside:

ConnectionFactory.java

Example:

String url = "jdbc:mysql://localhost:3306/library";
String user = "root";
String password = "your_password";
4 Run the project

Execute the Main.java file to test the system operations.

📷 Project Demonstration

You can include screenshots like:

/images/database.png
/images/loan-example.png
/images/code-example.png

Example:

![Database](images/database.png)
🎯 Learning Goals

This project was developed to improve knowledge in:

Java backend development

JDBC database interaction

Relational database design

Code organization using DAO pattern

📌 Future Improvements

Possible improvements for the project:

REST API with Spring Boot

Frontend interface

Authentication system

Pagination for queries

Dockerized database
