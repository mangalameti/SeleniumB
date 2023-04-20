package product;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import Generic_Utility.Baseclass;
import Generic_Utility.Excel_Utility;
import Generic_Utility.Java_Utility;
import Generic_Utility.Property_Utility;
import Generic_Utility.Webdriver_Utility;
import POM.CreateProductandDeleteProductCreationPage;
import POM.Homepage1;
import POM.Loginpage;
import POM.Productcreation;
import POM.ValidationandVerificationPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateproductandDelete extends Baseclass{
	
	
	
	@Test (groups={"smoketest","regressiontest"})
	//public class CreateproductandDeleteTest extends Baseclass {

		public  void CreateproductdeleteTest() throws Throwable {
			
			
	
		 Property_Utility plib1=new Property_Utility();
		 Webdriver_Utility wlib=new Webdriver_Utility();
	        wlib.implicitwait(driver);

			//login.getSubmitBtn().click();
			Thread.sleep(1000);
			Homepage1 home=new Homepage1(driver);
			home.clickProductLink();
			
		
		
		
		
		

			Productcreation prd=new Productcreation(driver);
			prd.clickproductCreateImage();

			
			Random ran=new Random();
			int ranNum = ran.nextInt(1000);
			
			Excel_Utility elib=new Excel_Utility();
			String productdata = elib.getExcelData("product",0, 0)+ranNum;
			
		
			
			//prd.productNamesTextField(productdata);
			
			driver.findElement(By.name("productname")).sendKeys(productdata);
			prd.saveButton();
		
		home.clickProductLink();
		//driver.findElement(By.xpath("//a[text()='Products']")).click();
		
		driver.findElement(By.xpath("//table[@class='lvt small']/tbody//td//a[text()='"+productdata+"']/../preceding-sibling::td[1]")).click();
		
		//prd.deleteproduct();
		driver.findElement(By.xpath("//input[@value='Delete']")).click();
		
		wlib.switchToAlertAndAccpect(driver);
		//Alert alert = driver.switchTo().alert();
		//alert.accept();
		
		ValidationandVerificationPage validate=new ValidationandVerificationPage(driver);
		validate.productValidation(driver, productdata);
		/*List<WebElement> lists = driver.findElements(By.xpath("(//table[@class='lvt small']/tbody/tr/td[3])[position()>1]"));
		
		boolean flag=false;
		for(WebElement wb:lists)
		{
			String act = wb.getText();
			if(act.contains(productdata))
			{s
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
		}*/
		
		//home.signoutLink(driver);
		
	}



}
