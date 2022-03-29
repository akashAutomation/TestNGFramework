package com.Demo;

import java.util.ArrayList;
import java.util.Iterator;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderDemo {
	/*
	 * 1. Apart from @Parameters, there is another way to achieve parameterization which is by using @DataProvider in TestNG. 
	 * 2. DataProviders are used for data driven testing which means same test case can be run with different set of data.
	 *    It is very powerful feature of TestNG and effectively used during framework development
	 * 3. It marks a methods for supplying the data to other methods.
	 * 4. DataProvider can be implemented in the same class or different class. 
	 * 5. A method which is annotated with @DataProvider is must return either Object[][] or Object[] or Iterator<Object[]> or Iterator<Object>, 
	 *    not class java.lang.Object otherwise throw "TestNGException".
	 *     
	 * 6. DataProvider can have a name, and it will be used in other methods by using its name.
	 * 7. We can also use DataProvider methods by using method name 
	 * 8. We have to pass same number arguments in the data otherwise throw "MethodMatcherException" - Data provider mismatch
	 * 9. Pass exact method name or DataProvider name otherwise throw "TestNGException"
	 * 10. If DataProvider method is present in another class then we have to use dataProviderClass method and pass the class name.
	 *     ex. dataProviderClass = ParameterTest.class
	 * 
	 */
	
	@DataProvider(name="username")
	public Object[][] a() {
		Object[][] data = {{"a", "b"},{"c","d"},{"e","f"}};
		return data;
	}
	
	@DataProvider()
	public Object[][] b() {
		Object[][] data = {{"p", "q"},{"r","s"},{"t", "u"}};
		return data;
	}
	
	@DataProvider()
	public Iterator<Object[]> usingArrayList() {
		Object[] data = {"a","b"};
		Object[] data1 = {"c","d"};
		
		ArrayList<Object[]> value = new ArrayList<Object[]>();
		value.add(data);
		value.add(data1);
		
		return value.iterator();
		
	}
	
	
	@Test(dataProvider="username") // using DataProvider method by its name
	public void test1(String fname, String lname) {
		System.out.println("test1");
		System.out.println("fname = "+fname+" , lname = "+lname);
	}
	
	@Test(dataProvider="b") // using DataProvider method without its name, only using method name
	public void test2(String fname, String lname) {
		System.out.println("test2");
		System.out.println("fname = "+fname+" , lname = "+lname);
	}
	
	@Test(dataProvider="c", dataProviderClass = ParameterTest.class) // using DataProvider method without its name, only using method name
	public void test3(String fname) {
		System.out.println("test3");
		System.out.println("fname = "+fname);
	}
	
	@Test(dataProvider="usingArrayList") // using DataProvider method without its name, only using method name
	public void test4(String fname, String lname) {
		System.out.println("test4");
		System.out.println("fname = "+fname+" , lname = "+lname);
	}
}
