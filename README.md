git s# Web Automation Framework

![Java](https://img.shields.io/badge/Java-17+-blue.svg)
![Maven](https://img.shields.io/badge/Maven-3.9.6+-red.svg)
![TestNG](https://img.shields.io/badge/TestNG-7.10.2+-green.svg)
![Selenium](https://img.shields.io/badge/Selenium-4.23.0+-yellow.svg)

## Overview

The **Web Automation Framework** is a robust and scalable solution for automating web application testing. Built with **Java**, **TestNG**, **Selenium WebDriver**, and **Maven**, it enables efficient execution of regression tests. The framework supports parallel test execution, detailed reporting, and CI/CD integration, making it ideal for ensuring high-quality web applications.

## Salient Features

### 1. TestNG-Driven Test Execution
- Leverages **TestNG** for flexible test management.
- Supports parallel execution (`parallel="classes"`, `thread-count="4"`) to optimize runtime.
- Configurable test suites via XML files (e.g., `testng-regression.xml`) for tests.

### 2. Selenium WebDriver Integration
- Uses **Selenium WebDriver** for reliable browser automation.
- Supports multiple browsers (Chrome, Firefox, Edge) with configurable WebDriver setups.
- Implements the Page Object Model (POM) for maintainable test code.

### 3. Maven-Based Build System
- Utilizes **Maven** for dependency management and build automation.
- Supports profiles (e.g., `regression`) to customize test execution via properties like `<suiteXmlFile>`.

### 4. Parallel and Scalable Execution
- Configured for parallel test execution at the class level.
- Scalable to handle large test suites with minimal configuration.
- Thread-safe design to prevent race conditions.

### 5. Comprehensive Reporting
- Generates **TestNG reports** (HTML/XML) for test result analysis.
- Supports integration with **ExtentReports** .
- Provides clear pass/fail/skip status and stack traces for debugging.

### 6. Page Object Model (POM)
- Follows POM design pattern for modular and reusable test code.
- Separates test logic from page interactions.
- Enhances code maintainability and reduces duplication.

### 7. CI/CD Integration
- Compatible with **Jenkins**, **GitHub Actions**, or **GitLab CI**.
- Supports Maven commands (e.g., `mvn test -Pregression`) for automated test runs.
- Configurable for headless browser execution in CI environments.

### 8. Customizable Configuration
- Uses properties files or TestNG XML parameters for environment-specific settings (e.g., URLs, credentials).
- Supports Maven profiles for different test scenarios (e.g., regression, smoke).
- Easily extensible for additional test suites or environments.

### 9. Error Handling and Logging
- Robust error handling with meaningful exception messages.
- Integrates with logging frameworks **Log4j**.
- Supports screenshot capture on test failures.

## Prerequisites

- **Java**: JDK 17 (recommended)
- **Maven**: 3.9.6 or higher
- **IDE**: IntelliJ IDEA (recommended) or Eclipse
- **Git**: For cloning the repository

## Setup Instructions

1. **Clone the Repository**:
   ```bash
   git clone https://github.com/vivek-lakhina/web-automation.git
   cd web-automation
   ```

2. **Install Dependencies**:
   ```bash
   mvn clean install
   ```

3. **Set Up IntelliJ IDEA**:
    - Open the project in IntelliJ IDEA.
    - Configure JDK 17:
        - Go to `File > Project Structure > Project` and set `Project SDK` to JDK 17.
    - Enable the TestNG plugin:
        - Go to `File > Settings > Plugins`, search for "TestNG," and install if needed.
    - Reimport Maven dependencies:
        - Open the Maven tool window and click `Reload All Maven Projects`.

4. **Configure TestNG XML**:
- The default suite is at `src/test/resources/testng-regression.xml`.
    - Update the XML to add test classes or modify parameters as needed.

## Running Tests

### Via Maven
- Run the regression suite with the `regression` profile:
  ```bash
  mvn test -Pregression
  ```
- This executes tests defined in `testng-regression.xml`.

### Via IntelliJ IDEA
- Open `src/test/resources/testng-regression.xml`.
- Right-click and select `Run 'testng-regression.xml'`.
- Ensure the project SDK is JDK 17 to avoid compilation errors.

## Project Structure

```
web-automation/
├── src/
│   ├── main/
│   │   └── java/
│   │       └── org.automation/
│   │           ├── pages/         # Page objects for POM
│   │           └── utils/         # Utility classes
│   ├── test/
│   │   └── java/
│   │       └── org.automation.tests/ # Test classes (e.g., FlightBookingTest)
│   └── resources/
│       └── testng-regression.xml  # TestNG suite configuration
├── pom.xml                       # Maven configuration
└── README.md                     # This file
```

Happy Testing! 🚀