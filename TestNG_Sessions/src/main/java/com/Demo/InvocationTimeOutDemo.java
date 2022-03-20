package com.Demo;

import org.testng.annotations.Test;

public class InvocationTimeOutDemo {
	/*
	 * 1. By using invocationTimeOut method we can set time to our test case. If our test case taking a lot of time to complete then we can set
	 *    the time. If in that time our test case will not be completed then it will throw ThreadTimeoutException.
	 * 2. Suppose we have infinite loop, so for this we have to manually terminate the code. But by using invocationTimeOut method our test case
	 *    will be running for only that given time and then throw ThreadTimeoutException
	 */
	
	@Test(invocationTimeOut = 2000)
	public void test1() {		
		int i = 1;
		while(i==1) {
			System.out.println(i);
		}
	}
}
