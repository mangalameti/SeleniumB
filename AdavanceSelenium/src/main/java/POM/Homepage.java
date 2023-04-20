package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Generic_Utility.Webdriver_Utility;

public class Homepage {

	public Homepage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(linkText="Organizations")
	private WebElement orgLinkText;
	
	
	
	
	@FindBy(xpath="//img[@alt='Create Organization...']")
	private WebElement createOrgLink;
	
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveLink;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement sinLink;
	
	
	public WebElement getOrgLinkText() {
		return orgLinkText;
	}
	public WebElement getCreateOrgLink() {
		return createOrgLink;
	}
	@FindBy(linkText="Sign Out")
	private WebElement signLink;
	 
	
	public WebElement getSinLink() {
		return sinLink;
	}
	public WebElement getSignLink() {
		return signLink;
	}
	public WebElement getSaveLink() {
		return saveLink;
	}
   
	
	
	

	public void clickLink()
	{
		orgLinkText.click();
		createOrgLink.click();
		saveLink.click();
	
	}
	

}
