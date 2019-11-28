/**
 * 
 */
package com.acti.erp.application.base;

import java.io.File;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.acti.erp.common.constants.Constants;
import com.acti.erp.common.constants.PropertyFile;
import com.acti.erp.common.util.ExcelOperationHandling;

public class WebDriverBase {

	public Logger logger = Logger.getLogger(WebDriverBase.class);

	protected PropertyFile propertyFile = new PropertyFile();

	public WebDriver driver;

	public Properties appPropertyFile;
	public String userName;
	public String passWord;
	public String userName2;
	public String passWord2;
	public String language;

	Constants constantValues = new Constants();
	ExcelOperationHandling excelOperation = new ExcelOperationHandling();
	
	int row;

	/**
	 * This method will  fetch excel data sheet row number for the matching test case
	 * @return will return the row number
	 * 
	 * @author Devaraj
	*/
	public int getclassName(String excelDataWorkBookName, String userStory) {

		try {
			
			excelOperation.excelInitialize(excelDataWorkBookName, userStory);
			Thread.sleep(3000);
			String sTestCaseName = this.toString();
			row = excelOperation.getRowContains(sTestCaseName, 0);

			System.out.println("ROW :" + row);

		} catch (IOException e) {
			e.printStackTrace();
			logger.info("unable to intialize excecl file" + e.getMessage());
			logger.info("unable to intialize excecl file" + e.getMessage());

		} catch (InterruptedException e) {
			e.printStackTrace();
			logger.info("Exception for thread sleep" + e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("Exception while reading from excel: " + e.getMessage());
		}

		return row;
	}

	/**
	 * This method will load the properties
	 * 
	 * @author Devaraj
	*/
	public void loadProperties() throws IOException {

		appPropertyFile = propertyFile.readProperFile(constantValues.getPropertyFilePath());
		logger.info("Property files are loaded sucessfully");

		userName = appPropertyFile.getProperty("userName");
		logger.info("userName is : " + userName);
		
		passWord = appPropertyFile.getProperty("passWord");
		logger.info("passWord is : " + passWord);
		
		userName2 = appPropertyFile.getProperty("userName2");
		logger.info("userName is : " + userName);
		
		passWord2 = appPropertyFile.getProperty("passWord2");
		logger.info("passWord is : " + passWord);
		
		language = appPropertyFile.getProperty("language");
		logger.info("language is : " + language);
		

	}

	/**
	 * This method will initiate the browser
	 * @param browserName: will be taken from TestNG parameters
	 * 
	 * @author Devaraj
	*/
	@SuppressWarnings("deprecation")
	@Parameters({"browserName", "url"})
	@BeforeClass
	public void initTest(String browserName, String url) throws IOException {

		loadProperties();
		logger.info("Loading Properties");

		DesiredCapabilities capabilities;

		if (browserName.equalsIgnoreCase("Chrome")) {

			System.setProperty("webdriver.chrome.driver", constantValues.getChromePath());

			ChromeOptions options = new ChromeOptions();
			options.addArguments("disable-infobars");
			driver = new ChromeDriver(options);
		}

		else if (browserName.equalsIgnoreCase("FF") || browserName.equalsIgnoreCase("FireFox")) {

			System.setProperty("webdriver.gecko.driver", constantValues.getFireFoxPath());
			capabilities = DesiredCapabilities.firefox();
			capabilities.setCapability("marionette", true);
			driver = new FirefoxDriver();
		}
		
		else if (browserName.equalsIgnoreCase("IE") || browserName.equalsIgnoreCase("Internet Explorer")) {

			System.setProperty("webdriver.ie.driver", constantValues.getInternetExplorerPath());
			capabilities = new DesiredCapabilities();

			capabilities.setCapability("browser", "IE");
			capabilities.setCapability("os", "Windows");
			capabilities.setCapability("os_version", "7");
			capabilities.setCapability("nativeEvents", true);
			capabilities.setCapability("ie.ensureCleanSession", true);
			capabilities.setCapability("acceptSslCerts", "true");
			capabilities.setCapability(InternetExplorerDriver.NATIVE_EVENTS, false);
			capabilities.setCapability("browserstack.ie.enablePopups", "false");
			capabilities.setCapability("ignoreZoomSetting", true);
			capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			capabilities.setJavascriptEnabled(true);
			capabilities.setCapability("enablePersistentHover", false);

			DesiredCapabilities.internetExplorer().setCapability("ignoreProtectedModeSettings", true);
			
			driver = new InternetExplorerDriver(capabilities);
			logger.info("Launched IE browser");
		}
		
		else {
			
			logger.info("Browser value is not valid");
		}

		driver.get(url);
		logger.info("Opening Browser");
		driver.manage().window().maximize();
		logger.info("Maximizing Browser Window");
		driver.manage().timeouts().implicitlyWait(35, TimeUnit.SECONDS);
	}

	/**
	 * This method will Close the browser
	 * 
	 * @author Devaraj
	*/
	@AfterClass
	public void quitBrowser() {

		driver.quit();
		logger.info("Quit the browser");
	}
	/**
	 * Method to delete all the screenshot from previous runs
	 * @author Devaraj
	 *  
	**/
	@BeforeSuite
	public void cleanUpScreenshots() throws Throwable {
		FileUtils.cleanDirectory(new File(constantValues.getScreenShotFolderPath()));
		logger.info("Deleted all the files in Screenshot folder");
		
		FileUtils.cleanDirectory(new File(constantValues.getTestOutPutFolderPath()));
		logger.info("Deleted all the files in test-output folder");
	}
}
