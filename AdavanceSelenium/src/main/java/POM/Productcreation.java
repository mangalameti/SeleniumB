package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Productcreation {
	public  Productcreation(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
    //Declaration
	@FindBy(xpath="//img[@alt='Create Product...']")
	private WebElement productCreateImage;
	
	@FindBy(name="product")
	private WebElement productNameTextField;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveButton;
	
	
	//getter Methods
	public WebElement getSaveButton() {
		return saveButton;
	}
	
	
	public WebElement getProductCreateImage()
	{
		return productCreateImage;
	}

	public WebElement getProductNameTextField()
	{
		return productNameTextField;
	}






	/**
	 * This Method is used for ClickOn +img
	 */
	public void clickproductCreateImage()
	{
		productCreateImage.click();
	}

	/**
	 * This Method is used to Pass Value to Campaign TextField
	 */
	public void productNamesTextField(String orgName)
	{
		productNameTextField.sendKeys(orgName);
	}
	/**
	 * This Method is used to Save cmpName
	 */

	public void saveButton()
	{
		saveButton.click();	
	}


	public void deleteproduct() {
		// TODO Auto-generated method stub
		
	}
	


}
