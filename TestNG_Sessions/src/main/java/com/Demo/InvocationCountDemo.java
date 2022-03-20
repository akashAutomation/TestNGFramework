package com.Demo;

import org.testng.annotations.Test;

public class InvocationCountDemo {
	// 1. By using invocationCount method we can execute same test case multiple times
	
	@Test(invocationCount = 10)  // 10 time executed
	public void test1() {		
		System.out.println("test1");
	}
}
