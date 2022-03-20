package com.Demo;


import org.testng.annotations.Test;

public class GroupsDemo {
	// 1. By using groups method we can segregate our test cases in groups.
	
	@Test(groups="a")
	public void enterName() {
		System.out.println("enterName");
	}
	
	@Test(groups="b")
	public void abc() {
		System.out.println("abc");
	}
	
	@Test(groups="b")
	public void homePage() {
		System.out.println("homePage");
	}
	
	@Test(groups="test")
	public void test1() {
		System.out.println("test 1");
	}
	
	@Test(groups="test")
	public void test2() {
		System.out.println("test 2");
	}
	
	@Test(groups="test")
	public void test3() {
		System.out.println("test 3");
	}
	
}
