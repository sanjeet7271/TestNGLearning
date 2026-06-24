# TestNG Tricky Interview Questions and Answers

## 1. What is the execution order of TestNG annotations?
`@BeforeSuite -> @BeforeTest -> @BeforeClass -> @BeforeMethod -> @Test -> @AfterMethod -> @AfterClass -> @AfterTest -> @AfterSuite`

## 2. Difference between @BeforeTest and @BeforeMethod?
- `@BeforeTest` runs once before all test methods in a `<test>` tag.
- `@BeforeMethod` runs before every test method.

## 3. What happens if a @BeforeMethod fails?
The associated test method is skipped.

## 4. Difference between dependsOnMethods and priority?
- `priority` controls execution order.
- `dependsOnMethods` creates execution dependency.

## 5. Which takes precedence: priority or dependency?
Dependencies take precedence.

## 6. What is alwaysRun=true?
Forces execution even when dependencies fail.

## 7. Difference between invocationCount and threadPoolSize?
- `invocationCount` = number of executions.
- `threadPoolSize` = parallel threads for executions.

## 8. Same priority execution?
Methods execute alphabetically.

## 9. enabled=false vs SkipException
- `enabled=false` = ignored before execution.
- `SkipException` = skipped during execution.

## 10. DataProvider parallel execution
`@DataProvider(parallel = true)` allows datasets to run concurrently.

## 11. Retry failed tests
Implement `IRetryAnalyzer`.

## 12. Factory vs DataProvider
- DataProvider = multiple datasets.
- Factory = multiple class instances.

## 13. preserve-order vs priority
- preserve-order = class order.
- priority = method order.

## 14. Parallel execution modes
- methods
- classes
- tests
- instances

## 15. Why WebDriver fails in parallel?
WebDriver is not thread-safe. Use `ThreadLocal<WebDriver>`.

## 16. Can @BeforeSuite run multiple times?
No, once per suite execution.

## 17. SoftAssert vs Assert
- Assert = immediate failure.
- SoftAssert = collect failures; requires `assertAll()`.

## 18. Dynamic execution modifications
- IAnnotationTransformer
- IMethodInterceptor
- ITestListener
- ISuiteListener

## 19. ITestListener vs ISuiteListener
- ITestListener = test method level.
- ISuiteListener = suite level.

## 20. Designing a framework for 5000+ tests
- ThreadLocal WebDriver
- Parallel execution
- Retry mechanism
- Listener-based reporting
- CI/CD integration
- Selenium Grid
- Reporting dashboards
