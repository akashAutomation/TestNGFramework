package com.Demo;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.support.BaseController;

public class ExtentReportDemo extends BaseController{

	public ExtentReports extent;
	public ExtentTest logger;
	
	@BeforeTest
	public void setExtent()  {
		extent = new ExtentReports(System.getProperty("user.dir")+"\\test-output\\ExtentReport.html", true);
		extent.addSystemInfo("Host Name", "Bahubali");
		extent.addSystemInfo("User Name", "Akash");
		extent.addSystemInfo("Environment", "QA");
	}
	
	@AfterTest
	public void endReport()  {
		extent.flush();
		extent.close();
	}
	
	@BeforeMethod
	public void setUp() throws InterruptedException {
		setProperty();
		openBrowser();
		openUrl();
	}
	
	@Test
	public void test1() {
		System.out.println("test1");
		logger = extent.startTest("test1"); 
		Assert.assertEquals(true, false);
	}
	
	@Test
	public void test2() {
		System.out.println("test2");
		logger = extent.startTest("test2"); 
		Assert.assertEquals(true, true);
	}
	
	@AfterMethod
	public void tearDown(ITestResult result) {
		
		if(result.getStatus() == ITestResult.FAILURE) {
			logger.log(LogStatus.FAIL, "Test Case Failed : "+result.getName());
			logger.log(LogStatus.FAIL, "Test Case Failed : "+result.getThrowable());
			
			String screenshotPath = takeScreenshot(result.getMethod().getMethodName());
			System.out.println("screenshotPath = "+screenshotPath);
			logger.log(LogStatus.FAIL, logger.addScreenCapture(screenshotPath));
		}
		else if(result.getStatus() == ITestResult.SUCCESS) {
			logger.log(LogStatus.PASS, "Test Case success : "+result.getName());
		}
		else if(result.getStatus() == ITestResult.SKIP) {
			logger.log(LogStatus.SKIP, "Test Case skipped : "+result.getName());
		}

		
		extent.endTest(logger);
		driver.quit();
	}
}
