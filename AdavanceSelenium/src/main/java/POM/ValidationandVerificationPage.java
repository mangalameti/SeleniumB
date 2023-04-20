package POM;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ValidationandVerificationPage {
	public ValidationandVerificationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
  @FindBy(xpath="//div[@class='lvtCol']/div[@class='lvtColData'][6]")
	private WebElement productdeletionData;

public WebElement getProductdeletionData() {
	return productdeletionData;
}
	public void productValidation(WebDriver driver,String productdata )
	{
List<WebElement> lists = driver.findElements(By.xpath("(//table[@class='lvt small']/tbody/tr/td[3])[position()>1]"));
		
		boolean flag=false;
		for(WebElement wb:lists)
		{
			String act = wb.getText();
			if(act.contains(productdata))
			{
				flag=true;
				break;
			}
		}
		if(flag)
		{
			System.out.println("Product deleted");
		}
		else
		{
			System.out.println("Product not deleted");
		}
		
	}
	
}
	

