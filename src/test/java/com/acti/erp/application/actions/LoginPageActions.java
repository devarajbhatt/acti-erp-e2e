package com.acti.erp.application.actions;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.acti.erp.application.objects.HomePageObjects;
import com.acti.erp.application.objects.LoginPageObjects;

public class LoginPageActions {
	
	public Logger logger = Logger.getLogger(LoginPageActions.class);

	/**
	 * Method to Login to the Application
	 * @param driver : WebDriver
	 * @param username
	 * @param password
	 * @param needToLogin : True/False
	 * @author Devaraj
	**/
	public void loginToApplication(WebDriver driver, String userName, String passWord, boolean needToLogin) {

		LoginPageObjects loginPgObjects = new LoginPageObjects(driver);
		HomePageObjects homePgObjects = new HomePageObjects(driver);

		loginPgObjects.getUserNameTextBox().sendKeys(userName);
		logger.info("Successfully entered user name as : " + userName);

		loginPgObjects.getPasswordTextBox().sendKeys(passWord);
		logger.info("Successfully entered password as : " + passWord);

		if (needToLogin) {

			loginPgObjects.getLoginButton().click();
			logger.info("Clicked on Login button");

			Assert.assertTrue(homePgObjects.getTasksLink().isDisplayed(), "Failed to login");
			logger.info("Successfully logged in to Application");
		}
	}
}
