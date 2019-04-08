package com.TestNGAnnotations;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DependsOnMethodTest {
	/**
	 * checking test cases dependency
	 */
	@Test(description="Test Case one execution")
	public void Test1() {
		System.out.println("Test1 Case execution ");
		Assert.assertTrue(true);
	}
	@Test(dependsOnMethods= {"Test1"})
	public void Test2() {
		System.out.println("Test2 Case execution ");
	}
	@Test(dependsOnMethods= {"Test1","Test2"})
	public void Test3() {
		System.out.println("Test2 Case execution ");
	}

	/**
	 * checking dependant test cases failing or not if we failing we false 
	 */
	@Test
	public void Test4() {
		System.out.println("Test4 Case execution ");
		Assert.assertTrue(false); //check test cases to pass true and false in asertion
	}
	@Test(dependsOnMethods= {"Test4"})
	public void Test5() {
		System.out.println("Test5 Case execution ");
	}
	@Test(dependsOnMethods= {"Test4","Test5"})
	public void Test6() {
		System.out.println("Test6 Case execution ");
	}

}
