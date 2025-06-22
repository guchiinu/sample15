# Sample Spring Boot Application

This project demonstrates a simple "Hello World" web application using:

- Java 21
- Spring Boot 3
- Thymeleaf for server-side HTML rendering
- MyBatis for database access
- Flyway for database migrations
- PostgreSQL as the database

The home page displays the PostgreSQL version retrieved from the database.

## Running the application

Ensure you have PostgreSQL running locally with a database named `postgres` and user `postgres`/`postgres`.

Run the application using Gradle (version 8.14 or newer):

```bash
gradle bootRun
```

Then open `http://localhost:8080` in your browser.

## Test Database

Integration tests expect a PostgreSQL database named `sample15_test`. Use the default user `postgres` with password `postgres`.

