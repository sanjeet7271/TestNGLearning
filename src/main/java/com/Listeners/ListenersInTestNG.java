package com.Listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenersInTestNG implements ITestListener{

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("Test Cases are started"+getMethodName(result));
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("Test Cases are passed"+getMethodName(result));
		
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("Test Cases are failed"+getMethodName(result));
		
	}

	public void onTestSkipped(ITestResult result) {
		System.out.println("Test Cases are skipped"+getMethodName(result));
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("Test Cases are passed based on percentage"+getMethodName(result));
		
	}

	public void onStart(ITestContext context) {
		System.out.println("All Test Cases are started");
		
	}

	public void onFinish(ITestContext context) {
		System.out.println("All Test Cases are finished");
		
	}
	private static String getMethodName(ITestResult result) {
		return result.getMethod().getConstructorOrMethod().getName();
	}

}
