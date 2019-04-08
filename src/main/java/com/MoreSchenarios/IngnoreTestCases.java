package com.MoreSchenarios;

import org.testng.annotations.Test;

import junit.framework.Assert;

public class IngnoreTestCases {
	
	@Test
	public void Test1() {
		System.out.println("Running my Test Case");
	}
	@Test(enabled=true)
	public void Test2() {
		System.out.println("not Skipping my Test Case");
		Assert.assertEquals(true, true);
		
	}
	@Test(enabled=false)
	public void Test3() {
		System.out.println("Please ignored this test case");
		Assert.assertTrue(false);
	}

}
