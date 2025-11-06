package com.Demo;

import org.testng.annotations.Test;

public class ExpectedExceptionDemo {
	/*
	 * 1. By using expectedExceptions method we can handle exceptions in TestNG without using any try-catch block. 
	 * 2. Suppose we want handle NumberFormatException then we can use expectedExceptions and pass exception name then it will pass our test case.
	 * 3. You can also pass multiple exceptions:
	 *    Ex: @Test(expectedExceptions = {IOException.class, SQLException.class})
	 * 4. you can use Exception.class or even Throwable.class for generic exception
	 *    Ex: @Test(expectedExceptions = Exception.class)

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
