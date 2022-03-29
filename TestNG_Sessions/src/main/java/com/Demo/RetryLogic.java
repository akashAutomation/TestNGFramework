package com.Demo;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.retryAnalyzer.RetryAnalyzer;


public class RetryLogic {
	/*
	 * 1. we can implement retry logic in 2 way: 
	 * 		1. @Test level --> we can provide "retryAnalyzer" attribute in @Test. But this is not a good approach because if there more than
	 * 						   100 test cases then it is difficult to do retry each test cases and also time consuming. 
	 * 		2. Run time --> by using "IAnnotationTransformer" interface
	 * 
	 *  
	 */
	

	@Test(retryAnalyzer = RetryAnalyzer.class) // @Test level retry
	public void test1() {		
		System.out.println("login");		
		Assert.assertEquals(true, false, "test1 failed");		
	}
	
	@Test  //run time retry
	public void test2() {
		System.out.println("logout");		
		Assert.assertEquals(true, false, "test2 failed");		
	}
	
	@Test  //run time retry
	public void test3() {
		System.out.println("test3");		
		Assert.assertEquals(true, true, "test3 failed");		
	}
}
