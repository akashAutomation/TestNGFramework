package com.Demo;

import org.testng.annotations.Test;

public class EnabledDemo {

	// If you want to not execute any test case then set enabled method as false. 
	
	@Test() 
	public void test1() {
		System.out.println("test1");		
	}
	
	@Test(enabled = false) 
	public void test2() {
		System.out.println("test2");		
	}
	
	@Test(enabled = true) 
	public void test3() {
		System.out.println("test3");		
	}
}
