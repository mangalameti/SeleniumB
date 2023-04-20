package campaign;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import Generic_Utility.Baseclass;
import Generic_Utility.Excel_Utility;
import Generic_Utility.Java_Utility;
import Generic_Utility.Property_Utility;
import Generic_Utility.Webdriver_Utility;
import POM.Campaigncreation;
import POM.Homepage1;
import POM.Loginpage;
import POM.ValidationAndVerification;
import io.github.bonigarcia.wdm.WebDriverManager;
@Test
public class CampaignPom extends Baseclass {

	public  void CampaignPom() throws Throwable {
		
		// TODO Auto-generated method stub

		 
		
        driver.manage().window().maximize();
        
        Webdriver_Utility wlib=new Webdriver_Utility();
        wlib.implicitwait(driver);

	
		
		
		Thread.sleep(1000);
		
		Homepage1 home=new Homepage1(driver);
		Thread.sleep(2000);
		home.moreLink(driver);
		home.campaignLinkText();
		
		Campaigncreation cmp=new Campaigncreation(driver);
		cmp.clickCampaignCreateImage();
		Java_Utility jlib=new Java_Utility();
		int RanNum = jlib.getRandomNum();
		
		Excel_Utility elib=new Excel_Utility();
		String campaigndata = elib.getExcelData("campaign",0, 0)+RanNum;
		cmp.campaignNamesTextField(campaigndata);
		cmp.saveButton();
		ValidationAndVerification validate=new ValidationAndVerification(driver);
		validate.organisationValidation1(driver, campaigndata);
		String actdata = validate.organisationValidation1(driver, campaigndata);
		Assert.assertEquals(actdata, campaigndata);
		
		
	}

}
