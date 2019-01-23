package com.datadriven.schatch;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestProFile {
	
	public static void main(String[] args) throws IOException {
		
		Properties config = new Properties();
		
		System.out.println(System.getProperty("user.dir"));
		
		String file = (System.getProperty("user.dir")) 
				+ "/src/test/resources/properties/Config.properties";
		
		FileInputStream fis = new FileInputStream(file);
		
		config.load(fis);
		
		System.out.println(config.getProperty("browser"));
		System.out.println(config.getProperty("testsiteurl"));
		
		
	}

}
