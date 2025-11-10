---

# 🌟 QA Automation Framework (Selenium + TestNG + Allure + API + DDT)

This is a **Production-Grade Automation Framework** built for **UI + API Testing**, following **Page Object Model**, **Data-Driven Testing**, **Allure Reporting**, and **Scalable Test Execution** structure.
Framework is designed for **real enterprise use cases**, maintainability, reusability, and CI/CD readiness.

---

## ✅ Features

| Feature                     | Status | Description                                     |
| --------------------------- | :----: | ----------------------------------------------- |
| Selenium UI Automation      |    ✅   | Full workflow coverage for SauceDemo app        |
| TestNG Framework            |    ✅   | Supports parallel execution + test suites       |
| Page Object Model (POM)     |    ✅   | Clean, scalable & maintainable structure        |
| Allure Reports              |    ✅   | Rich HTML reports + screenshots on failure      |
| Log4j2 Logging              |    ✅   | Centralized logging for debugging               |
| WebDriverManager            |    ✅   | Auto driver setup (no manual exe required)      |
| API Testing (RestAssured)   |    ✅   | API CRUD tests using ReqRes API                 |
| Data-Driven Testing         |    ✅   | Excel + JSON based test input                   |
| Test Listener (Screenshots) |    ✅   | Screenshots automatically captured              |
| CI/CD Ready                 |    ✅   | Can be integrated with GitHub Actions / Jenkins |

---

## 🏗️ Project Tech Stack

| Layer          | Tools                               |
| -------------- | ----------------------------------- |
| Language       | Java                                |
| Build Tool     | Maven                               |
| UI Automation  | Selenium WebDriver                  |
| API Testing    | RestAssured                         |
| Test Runner    | TestNG                              |
| Reporting      | Allure Report                       |
| Logging        | Log4j2                              |
| Data Providers | Excel (Apache POI) & JSON (Jackson) |

---

## 🧱 Folder Structure

```
src
 ├── main
 │   ├── java
 │   │   ├── base            # Driver setup and TestBase
 │   │   ├── pages           # Page Object Model classes
 │   │   ├── utils           # Helper utilities (Wait, Logs, Excel, JSON)
 │   │   └── api             # API Client + Service classes
 │   └── resources
 │       ├── config.properties
 │       └── log4j2.xml
 └── test
     ├── java
     │   ├── tests/ui        # UI Test Classes
     │   ├── tests/api       # API Test Classes
     │   └── listeners       # Screenshot + Logging Listeners
     └── resources/testdata  # Excel + JSON Test Data
```

---

## 🚀 How to Run Tests

### **Run All Tests**

```
mvn clean test
```

### **Run UI Tests Only**

```
mvn clean test -Dsuite=UI
```

### **Run API Tests Only**

```
mvn clean test -Dsuite=API
```

---

## 📊 Generate Allure Report

### After test execution:

```
mvn allure:serve
```

This opens **live interactive test report** in browser:

* Step by step logs
* Attached screenshots (on failure)
* Environment data
* Test history

---

## 🎯 Test Scenarios Covered

### UI Test Flows (SauceDemo App)

| Scenario                     | Status |
| ---------------------------- | :----: |
| User Login (Valid + Invalid) |    ✅   |
| Add Product to Cart          |    ✅   |
| Checkout Customer Info       |    ✅   |
| Complete Order Flow          |    ✅   |

### API Test Flows (ReqRes API)

| Endpoint          | Method | Purpose     | Status |
| ----------------- | ------ | ----------- | :----: |
| `/api/users`      | POST   | Create User |    ✅   |
| `/api/users/{id}` | GET    | Fetch User  |    ✅   |

---

## 📂 Key Class Locations

| Purpose               | Class                             |
| --------------------- | --------------------------------- |
| Base Web Test Setup   | `base/BaseTest.java`              |
| Driver Manager        | `base/DriverManager.java`         |
| Login Page            | `pages/LoginPage.java`            |
| Checkout Flow         | `tests/ui/CheckoutFlowTests.java` |
| API Client            | `api/ApiClient.java`              |
| API Tests             | `tests/api/ReqResApiTests.java`   |
| Screenshot on Failure | `listeners/TestListener.java`     |

---

## 📌 Screenshots On Failure (Auto Attached in Allure)

* Implemented in → `ScreenshotUtils.java` + `TestListener.java`
* Captures:

  * Browser screen
  * Test step logs

---

## 🏁 CI/CD Integration (Optional)

To run tests automatically on every push – add this file:

```
.github/workflows/ci.yml
```

(If you want, I will generate it next ✅)

---

## 🔥 How to Showcase This Project in Interview

**Say this:**

> “This framework demonstrates complete QA capability — UI + API Test Automation, POM architecture, data-driven execution, logging, reporting, and CI-ready structure. The framework is modular, reusable, and environment-configurable.”

---

## ⭐ Author

**Debasish**
QA Automation Engineer
📧 [22btics06@suiit.ac.in](mailto:22btics06@suiit.ac.in)
🔗 GitHub: [https://github.com/Debasish-87](https://github.com/Debasish-87)

---


I will generate **`.github/workflows/ci.yml`** → copy-paste → CI ready 🚀
