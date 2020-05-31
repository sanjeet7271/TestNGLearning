package TestNGListenersSuiteLevel;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener{

	public void onFinish(ITestContext result) {
		
		System.out.println("Test cases on Finished and details are :"+result.getName());
	}

	public void onStart(ITestContext result) {
		System.out.println("Test cases on starts and details are :"+result.getName());
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("Test cases failed with success % and details are :"+result.getName());
		
	}

	public void onTestFailure(ITestResult result) {
		System.out.println("Test cases on failed and details are :"+result.getName());
		
	}

	public void onTestSkipped(ITestResult result) {
		System.out.println("Test cases on skipped and details are :"+result.getName());
		
	}

	public void onTestStart(ITestResult result) {
		System.out.println("Test cases on test start and details are :"+result.getName());
		
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("Test cases on success and details are :"+result.getName());
	}

}
