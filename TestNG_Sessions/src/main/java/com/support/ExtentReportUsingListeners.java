package com.support;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.ExtentReports;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ExtentReportUsingListeners extends BaseController implements ITestListener  {

        public ExtentReports extent;
        public ExtentTest logger;

        @Override
        public void onStart(ITestContext context) {
            ExtentSparkReporter spark = new ExtentSparkReporter(System.getProperty("user.dir") + "\\test-output\\ExtentReport.html");
            extent = new ExtentReports();
            extent.attachReporter(spark);
            extent.setSystemInfo("Host Name", "Bahubali");
            extent.setSystemInfo("User Name", "Akash");
            extent.setSystemInfo("Environment", "QA");

            context.setAttribute("extent", extent); // share with test class
        }

        @Override
        public void onTestStart(ITestResult result) {
            extent = (ExtentReports) result.getTestContext().getAttribute("extent");
            logger = extent.createTest(result.getMethod().getMethodName());
            result.setAttribute("logger", logger); // share with test class
        }

        @Override
        public void onTestSuccess(ITestResult result) {
            logger = (ExtentTest) result.getAttribute("logger");
            logger.pass("Test Passed: " + result.getName());
        }

        @Override
        public void onTestFailure(ITestResult result) {
            logger = (ExtentTest) result.getAttribute("logger");
            logger.fail("Test Failed: " + result.getName());
            logger.fail(result.getThrowable());

            String screenshotPath = BaseController.takeScreenshot(result.getMethod().getMethodName());
            logger.addScreenCaptureFromPath(screenshotPath);
        }

        @Override
        public void onTestSkipped(ITestResult result) {
            logger = (ExtentTest) result.getAttribute("logger");
            logger.skip("Test Skipped: " + result.getName());
        }

        @Override
        public void onFinish(ITestContext context) {
            extent = (ExtentReports) context.getAttribute("extent");
            extent.flush();
        }

}
