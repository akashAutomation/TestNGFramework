package com.support;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



public class BaseController {

	public static WebDriver driver;
	
	public static void setProperty() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\DELL\\Downloads\\chromedriver_win32\\chromedriver.exe");
	}
	
	public static void openBrowser() {
		driver = new ChromeDriver();
	}
	
	
	@SuppressWarnings("deprecation")
	public static void openUrl() {
		
		driver.manage().window().maximize();    //maximize window
	    driver.manage().deleteAllCookies();     //delete all the cookies
	        
	    //dynamic wait
	    driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    driver.get("http://demo.automationtesting.in/Register.html");
	    try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static String takeScreenshot(String testMethodName) {
		
		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
	
			String formatter = DateTimeFormatter.ofPattern( "yyyy_MM_dd_HH_mm_ss" ).format(LocalDateTime.now());
			String s = System.getProperty("user.dir")+"\\screenshots\\"+"failed_"+testMethodName+"_"+formatter+".jpg";
			try {
				FileUtils.copyFile(srcFile, new File(s));
			} catch (IOException e) {
				e.printStackTrace();
			}
		
		
		return s;
	}
	
	
	
}
