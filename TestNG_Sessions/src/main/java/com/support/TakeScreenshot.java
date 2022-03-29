package com.support;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class TakeScreenshot extends BaseController implements ITestListener{
	
	public void onTestStart(ITestResult result) {
	    // not implemented
	  }
	
	public void onTestSuccess(ITestResult result) {
	    // not implemented
	  }
	
	public void onTestFailure(ITestResult result) {
		takeScreenshot(result.getMethod().getMethodName());
		
	 }
	
	public void onTestSkipped(ITestResult result) {
	    // not implemented
	  }

}
