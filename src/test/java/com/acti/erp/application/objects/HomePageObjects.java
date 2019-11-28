package com.acti.erp.application.objects;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class HomePageObjects {
	
public Logger logger = Logger.getLogger(HomePageObjects.class);
	
	/** Task Link @author Devaraj **/
	@FindBy(how = How.XPATH, using = "//*[@id=\"topnav\"]/tbody/tr[1]/td[1]/div/div[3]/img")
	private WebElement locatorForTasksLink;
	public WebElement getTasksLink() {
		return this.locatorForTasksLink;
	}
	
	/** Project and Customer Link @author Devaraj **/
	@FindBy(how = How.XPATH, using = "//*[@id=\"topnav\"]/tbody/tr[1]/td[5]/div/table/tbody/tr/td[6]/nobr/a")
	private WebElement locatorForProjectAndCustomerLink;
	public WebElement getProjectAndCustomerLink() {
		return this.locatorForProjectAndCustomerLink;
	}
	
	/** Create New Customer button @author Devaraj **/
	@FindBy(how = How.XPATH, using = "//*[@id=\"customersProjectsForm\"]/table/tbody/tr/td/table/tbody/tr[1]/td/table/tbody/tr/td[2]/input[1]")
	private WebElement locatorForCreateNewCustomerButton;
	public WebElement getCreateNewCustomerButton() {
		return this.locatorForCreateNewCustomerButton;
	}
	
	public HomePageObjects(WebDriver driver) {
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 20), this);
	}

}
