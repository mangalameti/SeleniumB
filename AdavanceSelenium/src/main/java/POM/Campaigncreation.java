package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Campaigncreation {

	public  Campaigncreation(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
    //Declaration
	@FindBy(xpath="//img[@alt='Create Campaign...']")
	private WebElement campaignCreateImage;
	
	@FindBy(name="campaignname")
	private WebElement campaignNameTextField;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveButton;
	
	
	//getter Methods
	public WebElement getSaveButton() {
		return saveButton;
	}
	
	
	
	public WebElement getCampaignCreateImage() {
		return campaignCreateImage;
	}



	public WebElement getCampaignNameTextField() {
		return campaignNameTextField;
	}



	/**
	 * This Method is used for ClickOn +img
	 */
	public void clickCampaignCreateImage()
	{
		campaignCreateImage.click();
	}

	/**
	 * This Method is used to Pass Value to Campaign TextField
	 */
	public void campaignNamesTextField(String orgName)
	{
		campaignNameTextField.sendKeys(orgName);
	}
	/**
	 * This Method is used to Save cmpName
	 */

	public void saveButton()
	{
		saveButton.click();	
	}
	
}



