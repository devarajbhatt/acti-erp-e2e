package com.acti.erp.common.constants;

/**
 * Contains all the constant variables like Browser Path, Exe file Path..
 * @author Devaraj Bhat
 *
 */
public class Constants {

	/** Absolute Path @author Devaraj **/
	private String currentDirectory = System.getProperty("user.dir");

	public String getAbsolutePath() {
		return this.currentDirectory;
	}

	/**  Chrome Path @author Devaraj **/
	private String chromePath = currentDirectory.concat("\\src\\test\\resources\\browserExeFile\\chromedriver.exe");

	public String getChromePath() {
		return this.chromePath;
	}

	/**  FireFox Path @author Devaraj **/
	private String fireFoxPath = currentDirectory.concat("\\src\\test\\resources\\browserExeFile\\geckodriver.exe");

	public String getFireFoxPath() {
		return this.fireFoxPath;
	}
	
	/**  Internet Explorer Path @author Devaraj **/
	private String internetExplorerPath = currentDirectory.concat("\\src\\test\\resources\\browserExeFile\\IEDriverServer.exe");

	public String getInternetExplorerPath() {
		return this.internetExplorerPath;
	}

	/**  Excel File Name @author Devaraj **/
	private String excelFileName = "TestData.xlsx";

	public String getExcelFileName() {
		return this.excelFileName;
	}
	
	/**  Excel File Sheet Name @author Devaraj **/
	private String excelSheetNameForLogin = "Login";

	public String getExcelSheetNameForLogin() {
		return this.excelSheetNameForLogin;
	}

	/**  Excel Path @author Devaraj **/
	private String testDataPath = currentDirectory.concat("\\src\\test\\resources\\testData\\" + excelFileName);

	public String getTestDataPath() {
		return this.testDataPath;
	}

	/**  Property File Path @author Devaraj **/
	private String propertyFilePath = currentDirectory.concat("\\src\\test\\resources\\propertyFiles\\environmentDetails.properties");

	public String getPropertyFilePath() {
		return this.propertyFilePath;
	}
	
	/**  DB Property File Path @author Devaraj **/
	private String dbPropertyFilePath = currentDirectory.concat("\\src\\test\\resources\\propertyFiles\\dbDetails.properties");

	public String getDdPropertyFilePath() {
		return this.dbPropertyFilePath;
	}
	
	/**  ScreenShot Folder Path @author Devaraj **/
	private String screenShotFolderPath = currentDirectory.concat("\\screenshots\\");

	public String getScreenShotFolderPath() {
		return this.screenShotFolderPath;
	}
	
	/**  Saved Images Folder Path @author Devaraj **/
	private String savedImagesFolderPath = currentDirectory.concat("\\src\\test\\resources\\savedImages\\");

	public String getSavedImagesFolderPath() {
		return this.savedImagesFolderPath;
	}
	
	/**  Test Output Folder Path @author Devaraj **/
	private String testOutPutFolderPath = currentDirectory.concat("\\test-output\\");

	public String getTestOutPutFolderPath() {
		return this.testOutPutFolderPath;
	}
	
	/**  Extent Report Folder Path @author Devaraj **/
	private String extentReportFolderPath = currentDirectory.concat("\\test-output\\TestReport.html");

	public String getExtentReportFolderPath() {
		return this.extentReportFolderPath;
	}
}
