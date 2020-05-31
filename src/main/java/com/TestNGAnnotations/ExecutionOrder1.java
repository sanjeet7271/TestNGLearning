package com.TestNGAnnotations;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ExecutionOrder1 {
	@BeforeTest
	public void TestBeforeTest() {
		System.out.println("Before Test");
	}
	@AfterTest
	public void TestAfterTest() {
		System.out.println("After Test");
	}
	@AfterSuite
	public void TestAfterSuite() {
		System.out.println("After Suite");
	}
	@BeforeMethod
	public void TestBeforeMethod() {
		System.out.println("Before Method");
	}
	
	@Test
	public void TestCase() {
		System.out.println("Test Case run here");
	}
	@BeforeSuite
	public void TestBeforeSuite() {
		System.out.println("Before Suite");
	}
	@AfterClass
	public void TestAfterClass() {
		System.out.println("After Class");
	}
	@AfterMethod
	public void TestAfterMethod() {
		System.out.println("After Method");
	}
	@BeforeClass
	public void TestBeforeClass() {
		System.out.println("Before Class");
	}
}
