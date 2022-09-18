## TestNG Learning for Interviews
1.) Annotations in TestNG and execution Orders <br>
                                              @BeforeSuite <br>
                                              @BeforeTest <br>
                                              @BeforeClass <br>
                                              @BeforeMethod <br>
                                              @Test <br>
                                              @AfterMethod <br>
                                              @AfterClass <br>
                                              @AfterTest <br>
                                              @AfterSuite <br>
                                           
## i) Arrange TestNG Annotations:
      1. @BeforeSuite
      2. @BeforeTest
      3. @BeforeClass
      4. @BeforeMethod
      5. @Test
      6. @AfterMethod
      7. @AfterClass
      8. @AfterTest
      9. @AfterSuite
## ii.) Arrange TestNG.xml tags
      1. Suite
      2. Test
      3. classes
      4. class
      5. Method
## iii.) Assertions Supported by TestNG
    - assertEqual(String actual,String expected)
    - assertEqual(String actual,String expected, String message)
    - assertEquals(boolean actual,boolean expected)
    - assertTrue(condition)
    - assertTrue(condition, message)
    - assertFalse(condition)
    - assertFalse(condition, message)

## iv.) Soft Assertion and Hard Assertion
      Soft Assertion: Soft Assert collects errors during @Test. Soft Assert does not throw an exception when an assert fails and would continue with the next step after the assert statement.
      If there is any exception and you want to throw it then you need to use assertAll() method as a last statement in the @Test and test suite again continue with next @Test as it is.

      Hard Assertion: Hard Assert throws an AssertException immediately when an assert statement fails and test suite continues with next @Test

        package TestNGExamples;
        import org.testng.Assert;
        import org.testng.annotations.Test;
        import org.testng.asserts.SoftAssert;

        public class SoftHardAssertions {

          @Test
          public void SoftAssertion() {
            SoftAssert soft=new SoftAssert();
            System.out.println("SoftAssert method was started.");
            soft.assertTrue(false);
            System.out.println("SoftAssert method was failed.");
            soft.assertAll();
          }

          @Test
          public void HardAssertion() {
            System.out.println("HardAssert method was started.");
            Assert.assertTrue(false);
            System.out.println("HardAssert method was failed.");
          }

        }
## v.) TestNG Exceptions:
      TestNG gives an option for tracing the Exception handling of code. You can verify whether a code throws the expected exception or not. The expected exception to validate while running the test case is mentioned using the expectedExceptions attribute value along with @Test annotation.
      import org.testng.annotations.Test;

          public class TestNGException {

            @Test(expectedExceptions = ArithmeticException.class)
            public void ExceptionINTestNG() {
              System.out.println("Exception in TestNG .");
              int i=1/0;
            }

          }

		
## VI.) Priority in TestNG: 
  1. The default test priority in TestNG is 0
  2. We can also set negative (for e.g -1,-2,-3,-4) priority, and it will execute before 0
  3. Priority in TestNG contains only integer value. The value can be negative, zero, or positive. If a tester defines a priority in decimal in TestNG, it needs to convert first to Integer (through typecasting)


## VII.)  Disable Test Case: @Test(enabled=false)
## VIII.)     How to skip a @Test method from execution in TestNG
	=> throw new SkipException("Skiiping - this is not ready for testing");
	
## IX) What is the use of @Test(invocationCount=x)?
=> The invocationcount attribute tells how many times TestNG should run a test method.    
