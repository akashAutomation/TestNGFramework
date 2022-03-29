package com.Demo;


import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertionDemo {
	
	/*
	 * Hard Assert --> Hard Assert throws an AssertException immediately when an assert statement fails and test suite continue with 
  				       the next @Test.
  				       
	 * 1. Soft Assert collects error during @Test. 
	 * 2. Soft Assert does not throw any exception when an assert fails and would continue with the next step after the assert statement.
	 * 3. If there is any exception and you want to throw it then you need to use assertAll() method as a last statement in the
     *    @Test and test suite again continue with the next @Test as it is.
     * 4. If you want to that test case marked as failed where we have use soft assertions then use assertAll() in last statement, 
     * 	  otherwise test case will be marked as passed. 
     * 
     * 5. Create SoftAssert object in each method otherwise it will give all the assertions of (previous methods + current method) .
	 */
	
	SoftAssert sfa = new SoftAssert();
	
	@Test
	public void test1() {
		Assert.assertEquals("ab", "abc", "title is not matched");  // hard assertion
	}
	
	@Test
	public void test2() {
		System.out.println("login");
		
		sfa.assertEquals("ab", "abc", "title is not matched for test2()");  // soft assert
		
		System.out.println("click on button");
		System.out.println("click on dropdown");
		
		sfa.assertEquals(true, false); // soft assert
		
		System.out.println("click on radio button");
		
		sfa.assertAll(); // it will marked testcase as failed.
	}
	
	@Test
	public void test3() {
		sfa = new SoftAssert();
		System.out.println("logout");
		
		sfa.assertEquals(true, false, "test3 failed");  // soft assert
		
		sfa.assertAll(); // it will marked testcase as failed.
	}
		
	
	
	
}
