package com.google.eshopping.generic;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class GetScreenshot {
	/**
	 * 
	 * @param driver Provide the WebDriver Reference to page Screenshot
	 * @param testCaseName Provide test Method Name (@Test)
	 * @return it returns the Screenshot FIle Path
	 */
	public static String getImage(WebDriver driver, String testCaseName) {
		String timeStamp=LocalDateTime.now().toString().replace(':', '-');
		String filePath = IAutoConstants.IMAGE_PATH+timeStamp+testCaseName+".png";
		TakesScreenshot ts=(TakesScreenshot)driver;
		
		File tempFile = ts.getScreenshotAs(OutputType.FILE);		
		File destFile = new File(filePath);
		//tempFile.renameTo(destFile);
		try {
			FileUtils.copyFile(tempFile, destFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return filePath;
	}
}
