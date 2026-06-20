# UI + API Automation Framework (Selenium + Rest Assured + Docker Grid)

Scalable automation framework supporting UI and API testing using Selenium WebDriver, Java, TestNG, Cucumber BDD, Rest Assured, and Selenium Grid with Docker for parallel and cross-browser execution.

---

## Features

* UI automation using Selenium WebDriver
* API automation using Rest Assured
* Selenium Grid 4 integration
* Docker-based browser execution
* Parallel test execution
* Cross-browser testing (Chrome, Firefox, Edge)
* Page Object Model (POM) design
* TestNG + Cucumber BDD support
* Reusable utilities and helper classes
* Thread-safe driver management
* CI/CD ready framework
* Clean and scalable project architecture
* Enterprise-level reporting and logging

---

## Architecture

```text
Test Layer
    ↓
Page Objects
    ↓
Reusable Utilities
    ↓
Driver Factory
    ↓
Selenium Grid (Docker)
    ↓
Chrome | Firefox | Edge

API Layer (Rest Assured)
    ↓
Request/Response Specifications
    ↓
Schema Validation
    ↓
Reporting
```

---

## Prerequisites

Make sure you have installed:

* Java 11+
* Maven
* Docker Desktop
* Chrome Browser
* Firefox Browser
* Microsoft Edge Browser
* IntelliJ IDEA / Eclipse

---

## Quick Start

### Clone Repository

```bash
git clone https://github.com/pnilava03/AutomationUIAndAPI.git
```

### Install Dependencies

```bash
mvn clean install
```

---

## Running Tests

### Run Complete Test Suite

```bash
mvn test
```

### Run Smoke Suite

```bash
mvn test -Dsurefire.suiteXmlFiles=src/test/resources/xmlFiles/smoke.xml
```

---

## Selenium Grid with Docker

### Start Grid

```bash
docker compose up -d
```

### Verify Grid

Open:

```text
http://localhost:4444/ui
```

Verify that Chrome, Firefox, and Edge nodes are available.

### Stop Grid

```bash
docker compose down
```

---

## Parallel Execution

The framework supports parallel execution through:

* Selenium Grid 4
* Docker Containers
* TestNG Parallel Execution
* ThreadLocal WebDriver Management

Supported browsers:

* Chrome
* Firefox
* Edge

---

## API Automation Features

* REST Assured
* Request Specification
* Response Specification
* JSON Schema Validation
* Authentication Handling
* Positive and Negative API Testing
* Reusable API Utilities

---

## CI/CD Integration

Framework can be integrated with:

* Jenkins
* GitHub Actions
* Docker-based Execution Pipelines

---

## Why This Framework?

* Supports UI + API Automation in a single project
* Dockerized Selenium Grid support
* Cross-browser execution
* Parallel execution capability
* Scalable architecture
* Maintainable framework design
* Enterprise-ready implementation
* CI/CD friendly

---

## Author

**Nilava Pal**
Lead SDET | Senior QA Automation Engineer

### Skills

* Selenium WebDriver
* Java
* TestNG
* Cucumber BDD
* REST Assured
* Selenium Grid
* Docker
* Jenkins
* GitHub Actions
* API Testing
* CI/CD Integration


## CI/CD and Docker Execution Flow
This framework supports local execution, Selenium Grid execution, Dockerized execution, and CI/CD integration through GitHub Actions and Jenkins.

The execution behavior can be controlled through `config.properties`.

### Execution Modes
Supported modes:

- local
- grid
- docker

### Example Configuration:
```properties
executionMode=docker
browser=chrome
gridUrl=http://localhost:4444
headless=false
```
## Execution Flow
```text
Code Push from Eclipse / Git
        ↓
GitHub Repository
        ↓
GitHub Actions Triggered
        ↓
Build + Test Execution
        ↓
Docker Selenium Grid Started
        ↓
Tests Run on Chrome / Firefox / Edge
        ↓
Reports Generated
```

## Jenkins Execution Flow
```text
Code Push from Eclipse / Git
        ↓
GitHub Repository
        ↓
GitHub Webhook
        ↓
Jenkins Pipeline Triggered
        ↓
Docker Grid Started
        ↓
Maven Test Execution
        ↓
Reports Generated
```


### Key Capabilities

- Local Execution
- Selenium Grid Execution
- Dockerized Browser Execution
- Parallel Test Execution
- Cross Browser Testing
- GitHub Actions Integration
- Jenkins Pipeline Integration
- Config Driven Execution


