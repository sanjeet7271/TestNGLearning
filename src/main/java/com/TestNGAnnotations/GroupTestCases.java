package com.TestNGAnnotations;

import org.testng.annotations.Test;

public class GroupTestCases {
	
	@Test(groups="sanity")
	public void Test1() {
		System.out.println("Grouping Test Cases with sanity");
		
	}
	@Test(groups= {"sanity","regression"})
	public void Test2() {
		System.out.println("Grouping Test Cases with sanity and regression both");
		
	}
	@Test(groups="regression")
	public void Test3() {
		System.out.println("Grouping Test Cases with regression");
		
	}

}
