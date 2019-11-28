package com.acti.erp.common.base;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Random;

import javax.imageio.ImageIO;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.acti.erp.common.constants.Constants;
import com.assertthat.selenium_shutterbug.core.Shutterbug;
import com.assertthat.selenium_shutterbug.utils.web.ScrollStrategy;

public class WebDriverActions {

	public Logger logger = Logger.getLogger(WebDriverActions.class);
	Constants constantValues = new Constants();
	
	/**
	 * Method which is used to navigate the respective URL
	 * @param driver: WebDriver
	 * @param url: URL of an application
	 * 
	 * @author Devaraj Bhat
	*/
	public void navigateURL(WebDriver driver, String url) {

		driver.navigate().to(url);
		logger.info("Navigated to URL : " + url);
	}

	/**
	 * Method which is used to switch the window
	 * @param driver: WebDriver
	 * 
	 * @author Devaraj Bhat
	*/
	public void switchToTheCurrentWindow(WebDriver driver) {

		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
			logger.info("Switched to child widnow");
		}
	}

	/**
	 * Method which is used to switch the frames
	 * @param driver: WebDriver
	 * @param frameVal: Frame Name/Frame ID/Frame Index
	 * 
	 * @author Devaraj Bhat
	*/
	public void switchToTopFrame(WebDriver driver, String frameVal) {

		driver.switchTo().frame("topFrame");
		logger.info("Switched to top frame");
	}
	
	
	/**
	 * This method will get the full page screenshot
	 * @param WebDriver driver
	 * @param testCaseNumber: Test Case Number/Name
	 * 
	 * @author Devaraj Bhat
	*/
	public void getscreenshot(WebDriver driver, String testCaseNumber) {

		Shutterbug.shootPage(driver, ScrollStrategy.WHOLE_PAGE).withName(testCaseNumber).save();
		logger.info("Successfully screenshot is taken and stored in screenshot folder for the test case " + testCaseNumber);
	}

	/**
	 * This method will Compare two images
	 * @param WebDriver driver
	 * @param expectedImageFileName: Expected Image File Name
	 * 
	 * @author Devaraj Bhat
	 * @throws Throwable 
	*/	
	public void compareTwoImages(WebDriver driver, String expectedImageFileName) throws Throwable {
		
		BufferedImage expectedImages = ImageIO.read(new File(constantValues.getSavedImagesFolderPath() + "\\" + expectedImageFileName + ".png"));
		
		Random randomVal = new Random();
		boolean comapareReturnValue = Shutterbug.shootPage(driver, ScrollStrategy.WHOLE_PAGE).withName(String.valueOf(randomVal.nextInt(1000))).equals(expectedImages);
		Assert.assertTrue(comapareReturnValue);
		logger.info("Both imanges are matching as expected");
	}
	
}
