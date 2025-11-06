package com.Demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class RealWorldExample {
/*
You're testing a web app with the following flow:
- Launch browser and login
- Add items to cart
- Proceed to checkout
- Validate order summary
- Logout and close browser

Execution flow:
🔧 @BeforeSuite
🌐 @BeforeTest
🔐 @BeforeClass

🧹 @BeforeMethod
🛒 @Test addItemToCart
📋 @AfterMethod

🧹 @BeforeMethod
💳 @Test checkoutProcess
📋 @AfterMethod

🧹 @BeforeMethod
📦 @Test validateOrderSummary
📋 @AfterMethod

🚪 @AfterClass
🧯 @AfterTest
🗃️ @AfterSuite
 */
    WebDriver driver;

    @BeforeSuite
    public void setupSuite() {
        System.out.println("🔧 Setup global test suite: Connect to DB, load config");
    }

    @BeforeTest
    public void setupTestEnv() {
        System.out.println("🌐 Setup test environment: Launch browser");
        System.setProperty("webdriver.chrome.driver","C:\\Users\\akash\\Downloads\\driver\\chromedriver.exe");
    }

    @BeforeClass
    public void loginToApp() {
        System.out.println("🔐 Login to e-commerce app");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo-ecommerce.com/login");
        // login logic here
    }

    @BeforeMethod
    public void resetCart() {
        System.out.println("🧹 Reset cart before each test");
        // clear cart logic
    }

    @Test(priority = 1)
    public void addItemToCart() {
        System.out.println("🛒 Adding item to cart");
        // add item logic
    }

    @Test(priority = 2)
    public void checkoutProcess() {
        System.out.println("💳 Proceeding to checkout");
        // checkout logic
    }

    @Test(priority = 3)
    public void validateOrderSummary() {
        System.out.println("📦 Validating order summary");
        // validation logic
    }

    @AfterMethod
    public void logTestStatus() {
        System.out.println("📋 Log test result and capture screenshot");
        // logging logic
    }

    @AfterClass
    public void logoutFromApp() {
        System.out.println("🚪 Logout from app");
        driver.quit();
    }

    @AfterTest
    public void tearDownTestEnv() {
        System.out.println("🧯 Cleanup test environment: Close browser");
    }

    @AfterSuite
    public void tearDownSuite() {
        System.out.println("🗃️ Close DB connection and finalize reports");
    }

}
