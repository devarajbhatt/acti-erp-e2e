package com.acti.erp.application.testscripts;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.acti.erp.application.actions.LoginPageActions;
import com.acti.erp.application.base.WebDriverBase;
import com.acti.erp.common.annotation.TestCase;
import com.acti.erp.common.base.WebDriverActions;
import com.acti.erp.common.constants.Constants;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class TESTCASE_ACTI_001 extends WebDriverBase {

	public Logger logger = Logger.getLogger(TESTCASE_ACTI_001.class);
	LoginPageActions loginPageAction = new LoginPageActions();
	WebDriverActions webDriverAction = new WebDriverActions();
	Constants constant = new Constants();

	public ExtentReports extentReports;
	public ExtentHtmlReporter extentLogger;
	public ExtentTest extentInfo;

	@BeforeMethod
	public void beforeMethod() {

		extentLogger = new ExtentHtmlReporter(constant.getExtentReportFolderPath());
		extentReports = new ExtentReports();
		extentReports.attachReporter(extentLogger);
		extentInfo = extentReports.createTest("TESTCASE_ACTI_TEST_001");
	}

	@Test
	@TestCase(Author = "Devaraj")
	public void TESTCASE_ACTI_TEST_001() throws Throwable {

		try {
			loginPageAction.loginToApplication(driver, userName, passWord, true);
			extentInfo.log(Status.INFO, "Successfully Login to the Application");
		} catch (Exception e) {
			e.printStackTrace();
			webDriverAction.getscreenshot(driver, "TESTCASE_ACTI_TEST_001");
			extentInfo.fail("Failed due to the attached error", MediaEntityBuilder.createScreenCaptureFromPath(constant.getScreenShotFolderPath() + "\\TESTCASE_ACTI_TEST_001.png").build());
			Assert.fail();
		}
	}

	@AfterMethod
	public void afterMethod() {
		extentReports.flush();
	}
}
