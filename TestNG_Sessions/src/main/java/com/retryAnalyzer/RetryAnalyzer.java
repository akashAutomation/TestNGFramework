package com.retryAnalyzer;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer{

	/*
	 * 1. IRetryAnalyzer is an interface and use for to execute failed test cases at @Test level. 
	 * 2. retry() is present in IRetryAnalyzer so we have to override this method in our class.
	 * 		boolean retry(ITestResult result); --> this is a declaration of retry()
	 */
	
	int counter = 0;
	int retryLimit = 3;
	
	@Override
	public boolean retry(ITestResult result) {
		if(counter < retryLimit) {
			counter++;
			return true;
		}
		return false;
	}
	
	
}
