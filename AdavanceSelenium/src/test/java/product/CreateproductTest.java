package product;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import Generic_Utility.Baseclass;
import Generic_Utility.Excel_Utility;
import Generic_Utility.Property_Utility;
import Generic_Utility.Webdriver_Utility;
import POM.Homepage1;
import POM.Loginpage;
import POM.Productcreation;
import POM.ValidationAndVerification;
import io.github.bonigarcia.wdm.WebDriverManager;
@Test (groups={"smoketest","regressiontest"})
public class CreateproductTest extends Baseclass {

	public  void CreateproductTest() throws Throwable {
		
		
		 Property_Utility plib1=new Property_Utility();
		 Webdriver_Utility wlib=new Webdriver_Utility();
	        wlib.implicitwait(driver);

			//login.getSubmitBtn().click();
			Thread.sleep(1000);
			Homepage1 home=new Homepage1(driver);
			home.clickProductLink();
			
		
		
	/*	driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		FileInputStream fis=new FileInputStream("./src/test/resources/PropertyFileData.properties");
		Properties pro=new Properties();
		pro.load(fis);
		String URL = pro.getProperty("url");
		String USERNAME = pro.getProperty("username");
		String PASSWORD = pro.getProperty("password");
		driver.get(URL);
		//driver.get("http://localhost:8888");
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();*/
		//driver.findElement(By.linkText("Products")).click();
		//driver.findElement(By.xpath("//img[@alt='Create Product...']")).click();
		Productcreation prd=new Productcreation(driver);
		prd.clickproductCreateImage();

		
		Random ran=new Random();
		int ranNum = ran.nextInt(1000);
		
		Excel_Utility elib=new Excel_Utility();
		String productdata = elib.getExcelData("product",0, 0)+ranNum;
		
	
		
		//prd.productNamesTextField(productdata);
		
		driver.findElement(By.name("productname")).sendKeys(productdata);
		prd.saveButton();
		ValidationAndVerification validate=new ValidationAndVerification(driver);
		validate.organisationValidation2(driver, productdata);
		String actdata = validate.organisationValidation2(driver, productdata);
		Assert.assertEquals(actdata, productdata);
		

	}

}
