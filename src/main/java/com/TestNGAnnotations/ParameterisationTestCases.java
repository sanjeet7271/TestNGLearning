package com.TestNGAnnotations;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameterisationTestCases {
	@Test
	@Parameters({"data"})
	public void Test1(@Optional("default")String data) {
		System.out.println(data);
	}

}
