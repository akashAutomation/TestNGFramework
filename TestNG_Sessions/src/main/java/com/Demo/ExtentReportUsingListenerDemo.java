package com.Demo;

import com.support.BaseController;
import com.support.ExtentReportUsingListeners;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(ExtentReportUsingListeners.class)

public class ExtentReportUsingListenerDemo extends BaseController {

    @BeforeMethod
    public void setUp() throws InterruptedException {
        setProperty();
        openBrowser();
        openUrl();
    }

    @Test
    public void test1() {
        System.out.println("test1");
        Assert.assertEquals(true, false);
    }

    @Test
    public void test2() {
        System.out.println("test2");
        Assert.assertEquals(true, true);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
