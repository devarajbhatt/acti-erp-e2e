package com.acti.erp.application.objects;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class CreateNewProjectPageObjects {
	
	public Logger logger = Logger.getLogger(CreateNewProjectPageObjects.class);
	
	/** Customer Name Textbox @author Devaraj **/
	@FindBy(how = How.NAME, using = "name")
	private WebElement locatorForCustomerNameTextBox;
	public WebElement getCustomerNameTextBox( ) {
		return this.locatorForCustomerNameTextBox;
	}
	
	/** Customer Description Text-Area @author Devaraj **/
	@FindBy(how = How.NAME, using = "description")
	private WebElement locatorForCustomerDetailsTextArea;
	public WebElement getCustomerDetailsTextArea() {
		return this.locatorForCustomerDetailsTextArea;
	}
	
	/** Show List of Active Projects and Customers Checkbox @author Devaraj **/
	@FindBy(how = How.ID, using = "active_customers_action")
	private WebElement locatorForActProjectAndCust;
	public WebElement getActProjectAndCustCheckbox() {
		return this.locatorForActProjectAndCust;
	}
	
	/** Create Customer Button @author Devaraj **/
	@FindBy(how = How.NAME, using = "createCustomerSubmit")
	private WebElement locatorForCreateCustomerButton;
	public WebElement getCreateCustomerButton() {
		return this.locatorForCreateCustomerButton;
	}
	
	
	public CreateNewProjectPageObjects(WebDriver driver) {
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 20), this);
	}

}
