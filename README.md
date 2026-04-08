# 🏥 Clinic API

A REST API for managing doctors and patients in a medical clinic, built with Java and Spring Boot.

## 📌 About the Project

Clinic API is a backend application designed to manage clinic data through REST endpoints.

The project currently includes:

- doctor registration and management
- patient registration and management
- paginated listing endpoints
- input validation with Jakarta Validation
- database versioning with Flyway
- soft delete using an `active` flag

## 🚀 Technologies

- Java
- Spring Boot
- Spring Data JPA
- Hibernate
- Flyway
- MySQL
- Lombok
- Maven

## 📂 Project Structure

src/main/java/com/marcos/api
├── config
├── controller
├── dto
├── model
├── repository
├── service

## ⚙️ Features

### Doctors

- Create a doctor
- List doctors with pagination
- Update doctor data
- Soft delete a doctor

### Patients

- Create a patient
- List patients with pagination
- Update patient data
- Soft delete a patient

## 🔌 API Endpoints

### Doctors

- POST /doctors
- GET /doctors
- PUT /doctors
- DELETE /doctors/{id}

### Patients

- POST /patients
- GET /patients
- PUT /patients
- DELETE /patients/{id}

## 🧾 Request Examples

### Create Doctor

{
"name": "John Doe",
"email": "john@example.com",
"phone": "47999999999",
"crm": "123456",
"especialization": "CARDIOLOGY",
"address": {
"street": "Main Street",
"neighborhood": "Downtown",
"zipCode": "89200000",
"city": "Sao Bento do Sul",
"state": "SC",
"number": 123,
"complement": "Office 1"
}
}

### Update Doctor

{
"id": 1,
"name": "John Updated",
"phone": "47988888888",
"address": {
"street": "New Street",
"neighborhood": "Center",
"zipCode": "89200000",
"city": "Sao Bento do Sul",
"state": "SC",
"number": 321,
"complement": "Room 2"
}
}

### Create Patient

{
"name": "Maria Silva",
"email": "maria@example.com",
"phone": "47999999999",
"cpf": "12345678901",
"address": {
"street": "Avenida Brasil",
"neighborhood": "Centro",
"zipCode": "89200000",
"city": "Sao Bento do Sul",
"state": "SC",
"number": 45,
"complement": "House"
}
}

### Update Patient

{
"id": 1,
"name": "Maria Updated",
"phone": "47988888888",
"address": {
"street": "Rua Nova",
"neighborhood": "Centro",
"zipCode": "89200000",
"city": "Sao Bento do Sul",
"state": "SC",
"number": 78,
"complement": "Apartment"
}
}

## 🗃️ Database

The application uses MySQL and Flyway migrations.

## 🛠️ Configuration

Set your database properties in `application.properties`:

spring.application.name=api
spring.datasource.url=jdbc:mysql://localhost:3306/consultancy
spring.datasource.username=root
spring.datasource.password=${DB_PASSWORD}
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

Set environment variable:

DB_PASSWORD=your_password

## ▶️ Running the Project

git clone https://github.com/marcosscheffer/clinic-api.git
cd clinic-api

Run with Maven Wrapper:

./mvnw spring-boot:run

Or:

mvn spring-boot:run

## 📬 Testing

Use:

- Postman
- Insomnia

## 🌐 CORS

Allowed origin:
http://localhost:3000

## 📚 Future Improvements

- add GET by id endpoints
- improve exception handling
- add authentication
- Swagger/OpenAPI docs
- automated tests

## 👨‍💻 Author

Developed by Marcos Scheffer
