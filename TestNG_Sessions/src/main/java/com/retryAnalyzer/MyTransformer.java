package com.retryAnalyzer;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;


public class MyTransformer implements IAnnotationTransformer{
	/*
	 * 1. Suppose 30 test cases got failed out of 100 then "IAnnotationTransformer" will read all failed cases and will call transform()
	 *    and it's all parameters will be passed at run time and then retry() will be called for each failed cases.
	 */
	
	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstrutor, Method testMethod) {
		annotation.setRetryAnalyzer(RetryAnalyzer.class);
	}
	

}
