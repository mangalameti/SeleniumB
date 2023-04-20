package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ValidationAndVerification {
	
	public ValidationAndVerification(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
  @FindBy(id="dtlview_Organization Name")
	private WebElement actualOrganizationData;
	
  //getter method
	public WebElement getActualOrganizationData() {
		return actualOrganizationData;
	}
	@FindBy(id="dtlview_Campaign Name")
	private WebElement actualOrganizationData1;
	
	public WebElement getActualOrganizationData1() {
		return actualOrganizationData1;
	}
	@FindBy(id="dtlview_Product Name")
	private WebElement actualOrganizationData2;
	
	public WebElement getActualOrganizationData2() {
		return actualOrganizationData2;
	}

	//bussiness logics
	public String organisationValidation(WebDriver driver,String data)
	{
	String actData = actualOrganizationData.getText();
	
	if(actData.contains(data))
	   {
	  	 System.out.println("pass");
	   }
	   else
	   {
	  	 System.out.println("fail");
	   }
	return actData;
	}
	public String organisationValidation1(WebDriver driver,String data1)
	{
	String actData1 = actualOrganizationData1.getText();
	
	if(actData1.contains(data1))
	   {
	  	 System.out.println("pass");
	   }
	   else
	   {
	  	 System.out.println("fail");
	   }
	return actData1;
	}
	public String organisationValidation2(WebDriver driver,String data2)
	{
	String actData2 = actualOrganizationData2.getText();
	
	if(actData2.contains(data2))
	   {
	  	 System.out.println("pass");
	   }
	   else
	   {
	  	 System.out.println("fail");
	   }
	return actData2;
	}


}
