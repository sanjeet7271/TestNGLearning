package com.TestNGAnnotations;

import org.testng.annotations.Test;

import junit.framework.Assert;

public class AssertionInTestNG {
	@Test
	public void Test1() {
	
		Assert.assertTrue(true);
		//Assert.assertTrue(false);
		
	}
	@Test
	public void Test2() {
		Assert.assertTrue(false);
		
	}
	
	@Test
	public void Test3() {
		Assert.assertEquals("Test","Test1");
		
	}
	@Test
	public void Test6() {
		Assert.assertEquals("Test","Test");
		
	}
	@Test
	public void Test4() {
		Assert.assertTrue("not matching expected conditions",false);
		
	}

}
