package com.acti.erp.application.objects;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class LoginPageObjects {

	public Logger logger = Logger.getLogger(LoginPageObjects.class);

	/** User Name Textbox @author Devaraj **/
	@FindBy(how = How.NAME, using = "username")
	private WebElement locatorForUserNameTextBox;
	public WebElement getUserNameTextBox() {
		return this.locatorForUserNameTextBox;
	}

	/** Password Textbox @author Devaraj **/
	@FindBy(how = How.NAME, using = "pwd")
	private WebElement locatorForPasswordTextBox;
	public WebElement getPasswordTextBox() {
		return this.locatorForPasswordTextBox;
	}

	/** Login Button @author Devaraj **/
	@FindBy(how = How.ID, using = "loginButton")
	private WebElement locatorForLoginButton;
	public WebElement getLoginButton() {
		return this.locatorForLoginButton;
	}

	public LoginPageObjects(WebDriver driver) {
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 20), this);
	}

}
