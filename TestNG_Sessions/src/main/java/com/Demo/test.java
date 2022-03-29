package com.Demo;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;



public class test {

	public static void main(String[] args) {
//		SimpleDateFormat sdf = new SimpleDateFormat();
//		String formatter = DateTimeFormatter.ofPattern( "yyyy_MM_dd_HH_mm_ss" ).format(LocalDateTime.now());
//		System.out.println(formatter);
		
		String s =System.getProperty("user.dir")+"\\test-output\\ExtentReport.html";
		System.out.println(s);

	}

}
