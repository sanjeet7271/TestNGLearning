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

public class TestCasesWithPriority {
	
	@BeforeMethod
	public void TestBeforeMethod() {
		System.out.println("Before Method ");

	}

	@Test
	public void Test3() {
		System.out.println("Test3 Case execution ");
	}
	@Test(priority=2)
	public void Test4() {
		System.out.println("Test4 Case execution ");
	}
	@AfterMethod
	public void TestAfterMethod() {
		System.out.println("After Method ");
	}
	@BeforeSuite
	public void TestBeforeSuite() {
		System.out.println("Before Suite");
	}
	@AfterSuite
	public void TestAfterSuite() {
		System.out.println("After Suite ");
	}
	@BeforeTest
	public void TestBeforeTest() {
		System.out.println("Before Test");
	}
	@Test
	public void Test1() {
		System.out.println("Test1 Case execution ");
	}
	@Test(priority=1)
	public void Test2() {
		System.out.println("Test2 Case execution ");
	}
	@AfterTest
	public void TestAfterTest() {
		System.out.println("After Test");
	}
	@BeforeClass
	public void TestBeforeClass() {
		System.out.println("Before Class ");
	}
	@AfterClass
	public void  TestAfterClass() {
		System.out.println("After Class ");

	}


}
