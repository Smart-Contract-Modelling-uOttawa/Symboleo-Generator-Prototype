package org.xtext.example.symg.tests;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class GetInputValues {
	String result;
	InputStream inputStream;
	InputStream expectedStream;
	
	public String getInputValues(String value, String requestedValue) throws IOException {
 
		try {
			
			Properties inputProp = new Properties();
			Properties expectedProp = new Properties();
			String inputPropFileName = "input.properties";
			String expectedPropFileName = "expected.properties";
 
			inputStream = getClass().getClassLoader().getResourceAsStream(inputPropFileName);
			expectedStream = getClass().getClassLoader().getResourceAsStream(expectedPropFileName);
 
			if (inputStream != null && requestedValue.equals("input")) {
				
				inputProp.load(inputStream);
				result = inputProp.getProperty(value);
				
			} else if (expectedStream != null && requestedValue.equals("expected")) {
				
				expectedProp.load(expectedStream);
				result = expectedProp.getProperty(value);
				
			} else {
				
				throw new FileNotFoundException("property file '" + inputPropFileName + "' not found in the classpath");
				
			}
		} catch (Exception e) {
			System.out.println("Exception: " + e);
		} finally {
			inputStream.close();
		}
		return this.result;
	}
}
