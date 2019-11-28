package com.acti.erp.application.objects;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class ActiveProjectAndCustomer {

	public Logger logger = Logger.getLogger(ActiveProjectAndCustomer.class);
	
	/** Success Message Text @author Devaraj **/
	@FindBy(how = How.XPATH, using = "//*[@class='successmsg']")
	private WebElement locatorForSuccessMessage;
	public WebElement getSuccessMessageText() {
		return this.locatorForSuccessMessage;
	}
	
	/** To Get individual delete checkbox @author Devaraj **/
	@FindBy(how = How.XPATH, using = "//table/tbody/tr[5]/td/table/tbody")
	private WebElement locatorForIndividualProjectCheckBox;
	public WebElement getIndividualProjectCheckBox(String customerName) {
		return this.locatorForSuccessMessage.findElement(By.xpath("//tr[td[1]//a[contains(text(),' " + customerName + "')]]/td[6]/input"));
	}
	
	/** To Get the Delete Button @author Devaraj**/
	@FindBy(how = How.XPATH, using = "//table/tbody/tr[6]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td[1]/input")
	private WebElement locatorForDeleteButton;
	public WebElement getDeleteButton() {
		return this.locatorForDeleteButton;
	}
	
	/** To Get Delete Button from Popup Message @author Devaraj**/
	@FindBy(how = How.ID, using = "deleteButton")
	private WebElement locatorForPopUpDeleteButton;
	public WebElement getPopUpDeleteButton() {
		return this.locatorForPopUpDeleteButton;
	}
	
	public ActiveProjectAndCustomer(WebDriver driver) {
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 20), this);
	}
}
