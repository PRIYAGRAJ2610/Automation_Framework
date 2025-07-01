
# SauceDemo Automation Framework

A robust, scalable, and maintainable Selenium-based automation framework for end-to-end testing of the SauceDemo web application. This framework leverages industry best practices such as the Page Object Model, ThreadLocal WebDriver management, and rich reporting with Allure and Extent Reports. It is designed for easy integration with CI/CD pipelines and supports parallel execution.

---

## :rocket: Tech Stack

- **Language:** Java 18
- **Build Tool:** Maven
- **Test Framework:** TestNG
- **Automation:** Selenium WebDriver
- **WebDriver Management:** WebDriverManager
- **Reporting:** Allure, Extent Reports
- **Logging:** Log4j2
- **CI/CD:** Jenkins
- **Version Control:** Git (GitHub)
- **IDE:** IntelliJ IDEA
- **OS:** Windows 10

### Key Dependencies (from `pom.xml`)
- `org.seleniumhq.selenium:selenium-java:4.28.1`
- `org.testng:testng:7.4.0`
- `io.github.bonigarcia:webdrivermanager:5.8.0`
- `com.aventstack:extentreports:5.1.2`
- `io.qameta.allure:allure-testng:2.25.0`
- `org.apache.logging.log4j:log4j-api/core/slf4j2-impl:2.20.0`
- `org.apache.poi:poi:5.2.3` (for Excel data, if needed)
- `org.aspectj:aspectjweaver:1.9.22`

---

## :triangular_ruler: Project Structure

```
Automation_Framework/
├── src/
│   └── test/
│       ├── java/
│       │   ├── Base/           # Base classes (BaseTest, BasePage)
│       │   ├── Helper/         # Utilities (DriverManager, LoggerHelper, AssertionHelper)
│       │   ├── Pages/          # Page Object Models (SignInPage, PageObjectManager)
│       │   ├── ReportManager/  # Reporting (ExtentManager, ListenerClass)
│       │   ├── SetUp/          # Setup (ConfigReader, WebDriverBase)
│       │   └── Tests/          # Test cases (SignInTest, etc.)
│       └── resources/
│           ├── config.properties # Test configuration (URLs, credentials)
│           └── testng.xml        # TestNG suite config
├── target/
│   ├── allure-results/         # Allure raw results
│   ├── surefire-reports/       # Surefire reports
│   └── test-output/            # Extent Reports output
├── pom.xml                     # Maven configuration
└── README.md                   # Project documentation
```

---

### Key Design Patterns & Concepts

- **Page Object Model (POM):** All page interactions are encapsulated in dedicated classes under `Pages/`, managed by `PageObjectManager`.
- **ThreadLocal WebDriver:** Ensures thread safety and parallel execution by isolating WebDriver instances per test thread.
- **Centralized Test Base:** `BaseTest` handles setup/teardown, reporting, and driver/page manager lifecycle.
- **Config Management:** `ConfigReader` loads properties from a single source for easy environment/config changes.
- **Rich Reporting:** Both Allure and Extent Reports are integrated for detailed, visual test results.
- **Logging:** Log4j2 provides robust logging for debugging and traceability.

---

## :hammer_and_wrench: How to Use

### 1. Clone the Repository

```bash
git clone https://github.com/your-username/SauceDemo_Automation.git
cd SauceDemo_Automation/Automation_Framework
```

### 2. Configure Properties

Edit `src/test/resources/config.properties` to set the target URL, credentials, and other environment-specific values.

### 3. Build the Project

```bash
mvn clean install
```

### 4. Run Tests

- **All Tests:**  
  `mvn test`
- **Specific Suite:**  
  `mvn test -DsuiteXmlFile=parallel-testng.xml`

### 5. View Reports

- **Extent Report:**  
  Open `Automation_Framework/test-output/ExtentReport.html` in your browser.
- **Allure Report:**  
  Generate and open Allure report:
  ```bash
  allure serve target/allure-results
  ```

---

## :repeat: CI/CD & Monitoring

- **Jenkins Integration:**  
  The framework is CI-ready. Configure Jenkins to trigger builds, run tests, and publish Allure/Extent reports.
- **Daily Build Trends:**  
  [Allure Trend Example] :
![image](https://github.com/user-attachments/assets/078c8ad8-d520-40d1-bd8a-2df7c314480c)

  [complete logs of testcase at each step] :
![image](https://github.com/user-attachments/assets/fd5339a2-5862-4cd6-8ca5-8ace884156ca)


---

## :books: Example Test Flow

1. **TestNG** triggers a test method in `Tests/`.
2. `BaseTest` sets up the WebDriver and reporting.
3. The test uses `PageObjectManager` to interact with page objects.
4. Assertions and logging are handled via helpers.
5. Results are logged and reported to Allure/Extent.
6. WebDriver is cleaned up after each test.

---

## :star: Contributing

Pull requests are welcome! For major changes, please open an issue first to discuss what you would like to change.

---

