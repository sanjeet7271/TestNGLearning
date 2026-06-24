# TestNG Interview Preparation Guide (Senior / Lead / Architect Level)

## Part 1: Tricky TestNG Interview Questions
1. Execution order of annotations
2. @BeforeTest vs @BeforeMethod
3. What happens if @BeforeMethod fails?
4. dependsOnMethods vs priority
5. Dependency vs priority precedence
6. alwaysRun=true
7. invocationCount vs threadPoolSize
8. Same priority execution behavior
9. enabled=false vs SkipException
10. Parallel DataProvider
11. Retry using IRetryAnalyzer
12. Factory vs DataProvider
13. preserve-order vs priority
14. Parallel execution modes
15. WebDriver issues in parallel execution
16. @BeforeSuite execution frequency
17. SoftAssert vs Assert
18. Dynamic execution using listeners
19. ITestListener vs ISuiteListener
20. Framework design for 5000+ tests

---

# Part 2: TestNG Coding Questions (10+ Years Experience)

## Retry Analyzer

```java
public class RetryAnalyzer implements IRetryAnalyzer {
    private int count = 0;
    private static final int MAX_RETRY = 3;

    @Override
    public boolean retry(ITestResult result) {
        if (count < MAX_RETRY) {
            count++;
            return true;
        }
        return false;
    }
}
```

## Thread Safe Driver

```java
public class DriverManager {

    private static ThreadLocal<WebDriver> driver =
            new ThreadLocal<>();

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void setDriver(WebDriver webDriver) {
        driver.set(webDriver);
    }
}
```

## Screenshot Listener

```java
public class TestListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        // Capture Screenshot
    }
}
```

## Dynamic Test Skipping

```java
@BeforeMethod
public void checkEnv() {
    if("prod".equals(System.getProperty("env"))) {
        throw new SkipException("Skipped");
    }
}
```

## Excel DataProvider

```java
@DataProvider(parallel = true)
public Object[][] users() {
    return ExcelUtil.readData("users.xlsx","Sheet1");
}
```

## Dynamic XML Generation

```java
XmlSuite suite = new XmlSuite();
XmlTest test = new XmlTest(suite);
```

## IMethodInterceptor Example

```java
public class SmokeFilter implements IMethodInterceptor {
}
```

---

# Part 3: Architect-Level TestNG Questions and Answers

## Q1. How would you execute 5000 tests in under 1 hour?

### Answer
- Parallel execution by classes
- Selenium Grid
- Dynamic suite generation
- Test impact analysis
- Containerized execution
- Distributed nodes
- Retry only flaky tests

Architecture:

```text
Jenkins
   |
Dynamic Suite Generator
   |
Selenium Grid
   |
Chrome | Firefox | Edge Nodes
```

---

## Q2. How would you design a thread-safe automation framework?

### Answer

Use:

```java
ThreadLocal<WebDriver>
ThreadLocal<SoftAssert>
ThreadLocal<ExtentTest>
```

Never use:

```java
public static WebDriver driver;
```

Reason:
Static objects are shared across threads.

---

## Q3. How would you execute tests based on changed source code?

### Answer

Workflow:

```text
Git Diff
   |
Identify impacted modules
   |
Generate TestNG XML
   |
Execute impacted tests only
```

Benefits:
- Faster CI execution
- Reduced infrastructure cost

---

## Q4. How would you build a self-healing TestNG framework?

### Answer

Components:

```text
Page Objects
     |
Locator Repository
     |
AI/Self-Healing Layer
     |
WebDriver
```

Capabilities:

- Dynamic locator recovery
- DOM comparison
- Locator fallback strategy

---

## Q5. How would you detect flaky tests?

### Answer

Store historical execution data.

Metrics:

- Failure frequency
- Retry success rate
- Environment dependency

Formula:

```text
Flaky Index =
(Retry Passed Count / Total Failures) * 100
```

---

## Q6. How would you implement thread-safe Extent Reports?

### Answer

```java
private static ThreadLocal<ExtentTest>
       test = new ThreadLocal<>();
```

Reason:
Each thread should write to its own report instance.

---

## Q7. RetryAnalyzer vs testng-failed.xml

| RetryAnalyzer | testng-failed.xml |
|--------------|------------------|
| Immediate Retry | Post Execution |
| Same Run | Separate Run |
| Good for Flaky Tests | Good for Rerun Jobs |

---

## Q8. How would you design a hybrid UI + API framework?

### Architecture

```text
Tests
 |
 +-- UI Layer
 |
 +-- API Layer
 |
 +-- DB Layer
 |
 Utilities
 |
 Reporting
```

Benefits:

- End-to-end validation
- Faster execution
- Service-level verification

---

## Q9. How would you execute multiple browsers in parallel?

### Answer

Use:

```java
@Factory
parallel="instances"
ThreadLocal<WebDriver>
```

Example:

```java
new LoginTest("Chrome");
new LoginTest("Firefox");
new LoginTest("Edge");
```

---

## Q10. How would you integrate TestNG into CI/CD?

### Pipeline

```text
Git Push
   |
Jenkins
   |
Build
   |
TestNG Execution
   |
Allure Reports
   |
Slack Notification
```

---

## Q11. How do you reduce flaky Selenium tests?

### Answer

- Explicit waits
- Stable locators
- API-assisted setup
- Test isolation
- Retry mechanism
- Network monitoring

---

## Q12. Explain a scalable TestNG framework architecture.

```text
src
├── tests
├── pages
├── api
├── database
├── listeners
├── reports
├── utilities
├── driver
├── data
└── resources
```

Core Components:

- DriverManager
- BaseTest
- RetryAnalyzer
- Listener Framework
- Report Manager
- Config Manager
- Data Manager

---

# Frequently Asked Architect-Level Questions

1. How does TestNG internally resolve dependencies?
2. How does TestNG handle parallel execution?
3. Why do static variables break parallel tests?
4. How would you build a custom TestNG Runner?
5. How would you build a flaky-test detection system?
6. How would you execute impacted tests only?
7. How would you integrate Kubernetes with Selenium Grid?
8. How would you design a cloud-native test framework?
9. How would you build self-healing locators?
10. How would you support UI, API, DB and Contract Testing in a single framework?
