package com.Listeners;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

public class ListenersClass {
	int i=0;
	@Test
	public void test1() {

	}
	@Test
	public void test2() {
		throw new SkipException("I am Skiping THis test");

	}
	@Test(successPercentage=60, invocationCount=5)
	public void test3() {
		i++;
		System.out.println("TEST3 Test method, invoationCount :"+i);
		if(i==1 || i==2) {
			System.out.println("Test3 cases failed");
			Assert.assertEquals(i, 8);
		}

	}

}
