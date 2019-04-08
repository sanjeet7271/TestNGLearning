package com.MoreSchenarios;

import org.testng.Assert;
import org.testng.annotations.Test;

public class makedependentTestCase {
	//making test2 Test case Passed if Test1 is Passed
	@Test
	public void Test1() {
		System.out.println("I can run without any help");
		
	}
	@Test(dependsOnMethods= {"Test1"})
	public void Test2() {
		System.out.println("Sorry, I can not run without Test1 case");
	}
	//making test4 Test case failed if Test3 is failed
	@Test()
	public void Test3() {
		System.out.println("I can run without any help");
		Assert.assertTrue(false);
		
	}
	@Test(dependsOnMethods= {"Test3"})
	public void Test4() {
		System.out.println("Sorry, I can not run without Test1 case");
	}

}
