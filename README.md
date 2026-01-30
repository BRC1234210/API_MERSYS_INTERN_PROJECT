# MERSYS Campus - API Test Automation Framework

<div align="center">

![Java](https://img.shields.io/badge/Java-21-orange?style=flat-square&logo=java)
![REST Assured](https://img.shields.io/badge/REST%20Assured-5.5.6-green?style=flat-square)
![TestNG](https://img.shields.io/badge/TestNG-7.11.0-red?style=flat-square)
![Allure](https://img.shields.io/badge/Allure-2.31.0-yellow?style=flat-square)
![Maven](https://img.shields.io/badge/Maven-Build-blue?style=flat-square&logo=apache-maven)

**An API Test Automation Framework by TEAM3**

</div>

---

## About The Project

This is a comprehensive REST API test automation framework for the MERSYS Campus School Management System. Built using REST Assured and TestNG, it provides end-to-end API test coverage for critical school management functionalities including authentication, geography management, exams, custom fields, and student groups.

**TEAM3** - Professional QA Engineering Team

---

## Tech Stack

- **Java 21** - Programming Language
- **REST Assured 5.5.6** - HTTP/REST API Testing Framework
- **TestNG 7.11.0** - Test Execution Framework
- **Allure 2.31.0** - Test Reporting Framework
- **Hamcrest 3.0** - Assertion & Matcher Library
- **Jackson 2.20.1** - JSON Serialization/Deserialization
- **Maven** - Build & Dependency Management

---

## Project Structure

```
API_MERSYS_INTERN_PROJECT/
├── src/
│   └── test/
│       └── java/
│           └── api/
│               ├── BaseTest.java                      # Base configuration & setup
│               ├── US001_Login.java                   # Authentication tests
│               ├── US002_CreateCountryWithState.java  # Country creation tests
│               ├── US003_CRUDState.java              # State CRUD operations
│               ├── US004_CRUD_City.java              # City CRUD operations
│               ├── US005_ExamsAPITest.java           # Exams API tests
│               ├── US006_CustomFieldAPITest.java     # Custom field tests
│               ├── US007CreateStudentGroup.java      # Student group CRUD
│               ├── US_008_AddStudentsByGroup.java    # Group management tests
│               └── pojo/                             # Data model classes
│                   ├── Login.java
│                   ├── Country.java
│                   ├── Exams.java
│                   └── StudentsByGroup.java
├── target/
│   └── allure-results/                               # Test execution results
├── pom.xml
└── README.md
```

---

## Prerequisites

- Java Development Kit (JDK) 21 or higher
- Apache Maven 3.6+
- Git

---

## Installation

```bash
# Clone the repository
git clone https://github.com/your-organization/API_MERSYS_INTERN_PROJECT.git

# Navigate to project directory
cd API_MERSYS_INTERN_PROJECT

# Install dependencies
mvn clean install
```

---

## Test Coverage

### Authentication
- **US_001** - User Login

### Geography Management
- **US_002** - Create Country with State
- **US_003** - State CRUD Operations
- **US_004** - City CRUD Operations

### Academic Management
- **US_005** - Exams API Testing
- **US_006** - Custom Field API Testing

### Student Management
- **US_007** - Student Group CRUD
- **US_008** - Add/Remove Students by Group

---

## Running Tests

### Run all tests
```bash
mvn clean test
```

### Run specific test suite
```bash
mvn test -Dtest=US001_Login
```

### Run with Allure reporting
```bash
mvn clean test
mvn allure:serve
```

---

## Test Reports

After test execution, **Allure Reports** generates a comprehensive HTML report:

**Location:** `target/allure-results/`

The report includes:
- Test execution summary with pass/fail statistics
- Detailed test steps with API request/response data
- HTTP request and response payloads
- Test execution timeline
- Test categorization by severity levels
- User story mapping and traceability

**To generate and view the report:**
```bash
mvn allure:serve
```

---

## Best Practices

- Follow REST API testing standards
- Use POJO classes for request/response mapping
- Implement proper status code validation
- Write comprehensive negative test scenarios
- Use Hamcrest matchers for readable assertions
- Clean up test data after execution
- Add Allure annotations for better reporting
- Maintain test independence

---

## Contributing

1. Create a feature branch (`git checkout -b feature/US_XX_description`)
2. Commit your changes (`git commit -m 'Add US_XX API test scenarios'`)
3. Push to the branch (`git push origin feature/US_XX_description`)
4. Create a Pull Request

---

## Team

**TEAM3** - QA Engineering Team

Specialized in API test automation, quality assurance, and continuous testing for enterprise applications.

---

<div align="center">

**Built with excellence by TEAM3**

</div>