package com.Demo;

import org.testng.annotations.Test;

public class ExpectedExceptionDemo {
	/*
	 * 1. By using expectedExceptions method we can handle exceptions in TestNG without using any try-catch block. 
	 * 2. Suppose we want handle NumberFormatException then we can use expectedExceptions and pass exception name then it will pass our test case.
	 */
	
	
	@Test()
	public void test1() {	// failed	
		String x = "100A";
		Integer.parseInt(x);
	}
	
	@Test(expectedExceptions = NumberFormatException.class)
	public void test2() {		// passed
		String x = "100A";
		Integer.parseInt(x);
	}

}
