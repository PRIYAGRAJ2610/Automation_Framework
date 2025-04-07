### Tools and Technologies Used :
## Tools and Technologies

- **Programming Language**: Java
- **Build Tool**: Apache Maven
- **Testing Framework**: TestNG
- **Automation Tool**: Selenium WebDriver
- **Reporting Tools**:
  - Allure Report (Commandline 2.33.0)
  - Extent Reports
- **CI/CD**: Jenkins
- **Version Control**: Git (GitHub)
- **IDE**: IntelliJ IDEA
- **Operating System**: Windows 10

**Project Structure**

Automation_Framework/
├── src/
│   ├── main/
│   │   ├── java/                    # Main source code (if any)
│   │   └── resources/               # Main resources (e.g., config files)
│   └── test/
│       ├── java/                    # Test source code
│       │   ├── Base/                # Base classes (e.g., BaseTest.java, WebDriverBase.java)
│       │   ├── Helper/              # Utility classes (e.g., RetryAnalyzer.java, WaitHelper.java)
│       │   ├── Pages/               # Page object models (e.g., SignInPage.java)
│       │   ├── ReportManager/       # Reporting utilities (e.g., ExtentManager.java)
│       │   ├── SetUp/               # Setup classes (e.g., ConfigReader.java)
│       │   └── Tests/               # Test cases (e.g., SignInTest.java)
│       └── resources/               # Test resources
│           ├── testng.xml           # TestNG suite configuration
│           └── config.properties    # Test configuration (e.g., URLs, credentials)
├── target/                          # Build output (ignored by .gitignore)
│   ├── allure-results/              # Allure raw results
│   ├── surefire-reports/            # Surefire reports (if any left)
│   └── test-output/                 # Extent Reports output
├── pom.xml                          # Maven configuration
├── .gitignore                       # Git ignore file


![image](https://github.com/user-attachments/assets/caca3529-15df-464c-9996-3475f4759763)


![image](https://github.com/user-attachments/assets/1c96f50e-af4f-48e5-a04d-2905e1431249)

