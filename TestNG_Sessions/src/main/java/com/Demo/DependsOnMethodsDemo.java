package com.Demo;

import org.testng.annotations.Test;

public class DependsOnMethodsDemo {
	
	/*
	 * 1. All test cases are independent to each other in nature.
	 * 
	 * 2. dependsOnMethods is a method which is used for method dependency.
	 *    ex-> We have put dependsOnMethods = "login" in homePage() and registratioPage() so it means that these methods are depending on
	 *         login(). If login() will pass then only it's dependent method will be executed otherwise all dependent methods will be skipped.
	 * 
	 * 3. We have to give exact name of dependent method otherwise it will give
	 *    "org.testng.TestNGException: com.Demo.DependsOnMethodsDemo.RegistratioPage() depends on nonexistent method Home"
	 *    
	 * 4. Order of running the test cases depend on the it's dependent methods.            
	 */
	
	
	@Test()
	public void login() {
		System.out.println("login");
		//int i = 1/0;
	}
	
	@Test(dependsOnMethods="login")
	public void homePage() {
		System.out.println("homePage");
		//int i = 1/0;
	}
	
	@Test(dependsOnMethods="login")
	public void registratioPage() {
		System.out.println("registratioPage");
	}
	
	@Test(dependsOnMethods="registratioPage")
	public void selectCountry() {
		System.out.println("selectCountry");
	}
	
}
