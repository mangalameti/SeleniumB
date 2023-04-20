package Organization;

import java.time.Duration;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Generic_Utility.Baseclass;
import Generic_Utility.Excel_Utility;
import Generic_Utility.Java_Utility;
import Generic_Utility.Property_Utility;
import Generic_Utility.Webdriver_Utility;
import POM.Homepage1;
import POM.Organizationcreation;
import POM.ValidationAndVerification;
//@Listeners(Generic_Utility.ListenerClass.class)
public class OrganizationPom  extends Baseclass{
@Test//(groups="regressiontest")
	//@Test(retryAnalyzer=Generic_Utility.RetryExample.class)
	public  void organizationPom() throws Throwable {
		
		// TODO Auto-generated method stub

		
		
	Property_Utility plib1=new Property_Utility();
	 
        driver.manage().window().maximize();
        
        Webdriver_Utility wlib=new Webdriver_Utility();
        Thread.sleep(1000);
        wlib.implicitwait(driver);
        Thread.sleep(1000);
		Homepage1 home=new Homepage1(driver);
		Thread.sleep(1000);
		//home.clickOrganizationsLinkText();
		driver.findElement(By.linkText("Organizations")).click();
       // Assert.assertEquals(false, true);
		
		Organizationcreation org=new Organizationcreation(driver);
		org.clickOrganizationCreateImage();
		Java_Utility jlib=new Java_Utility();
		int RanNum = jlib.getRandomNum();
		
		Excel_Utility elib=new Excel_Utility();
		String exceldata = elib.getExcelData("Organization",0, 0)+RanNum;
		
		org.organizationNamesTextField(exceldata);
		org.saveButton();
		ValidationAndVerification validate=new ValidationAndVerification(driver);
		validate.organisationValidation(driver, exceldata);
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		String actdata = validate.organisationValidation(driver, exceldata);
		Assert.assertEquals(actdata, exceldata);
		
      
	}

}
