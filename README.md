AutomationUIAndAPI

This repository contains a scalable UI + API automation framework built using Selenium WebDriver, Java, TestNG, Cucumber BDD, and Rest Assured.
The framework is designed with reusable components and supports end-to-end automation across UI and API layers.
==============================
**Tech Stack**
1.Java
2.Selenium WebDriver
3.TestNG
4.Cucumber BDD
5.Rest Assured
6.Maven
7.Page Object Model (POM)
8.Jenkins / CI Support
9.Framework Features
10.UI automation using Selenium WebDriver
11.API automation using Rest Assured
12.Page Object Model design pattern
13.TestNG + Cucumber execution support
14.Reusable utilities and configuration handling
15.Scalable architecture
16.CI/CD integration support
17.Reporting support
================
**Project Structure**
src
 ├── main/java/com/qa/opencart
 │   ├── constants
 │   ├── errors
 │   ├── exceptions
 │   ├── factory
 │   └── utils
 │
 ├── test/java/com/qa/opencart
 │   ├── base
 │   ├── pages
 │   ├── tests
 │   ├── stepsDefinition
 │   └── Runner
 │
 └── test/resources
     ├── config
     ├── features
     ├── testdata
     └── xmlFiles
**What This Framework Covers**
1.UI Automation
2.Login page validation
3.Account page validation
4.Registration flow
5.Search functionality
6.API Automation
7.API request validation
8.Response validation
9.Status code validation
10.JSON response validation

**Prerequisites**
**Make sure you have installed:**
Java 11+
Maven
Chrome browser
IDE (IntelliJ / Eclipse)

**Setup**

**Clone repository**
git clone https://github.com/pnilava03/AutomationUIAndAPI.git

**Navigate to project**
cd AutomationUIAndAPI

**Install dependencies**
mvn clean install

**Run Tests**
**Run all tests**
mvn test

**Run specific suite**
mvn test -Dsurefire.suiteXmlFiles=src/test/resources/xmlFiles/testNG.xml

**Run smoke suite**
mvn test -Dsurefire.suiteXmlFiles=src/test/resources/xmlFiles/smoke.xml

**Framework Design**
**This framework follows layered architecture:**

Test Cases
↓
Page Object Model
↓
Base Test
↓
Driver Factory
↓
Utility Layer
↓
Configuration
↓
Execution
↓
Reports

Use Cases:
1.This framework can be used for:
2.UI automation testing
3.API automation testing
4.End-to-end workflow testing
5.Regression testing
6.CI/CD execution
=============
Author
Nilava Pal
Senior QA Automation Engineer

GitHub:
https://github.com/pnilava03/AutomationUIAndAPI
