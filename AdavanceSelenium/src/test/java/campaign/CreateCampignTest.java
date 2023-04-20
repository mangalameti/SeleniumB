package campaign;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import Generic_Utility.Baseclass;
import Generic_Utility.Excel_Utility;
import Generic_Utility.Property_Utility;
import Generic_Utility.Webdriver_Utility;
import POM.Homepage1;
import POM.Productcreation;

public class CreateCampignTest {

	@Test	(groups="smoketest")
public void CreateCampignTest() throws Throwable
{
		WebDriver driver=new FirefoxDriver();
		
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		Property_Utility plib=new Property_Utility();
	    String URL=plib.getKeyValue("url");
	    String USERNAME = plib.getKeyValue("username");
	    String PASSWORD = plib.getKeyValue("password");
		
		
		/*FileInputStream fis=new FileInputStream("./src/test/resources/PropertyFileData.properties");
		Properties pro=new Properties();
		pro.load(fis);
		String URL = pro.getProperty("url");
		String USERNAME = pro.getProperty("username");
		String PASSWORD = pro.getProperty("password");*/
	    
		driver.get(URL);
		//driver.get("http://localhost:8888");
		driver.findElement(By.name("user_name")).sendKeys(USERNAME); 
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.linkText("More")).click();
		
		driver.findElement(By.linkText("Campaigns")).click();
		driver.findElement(By.xpath("//img[@alt='Create Campaign...']")).click();
		
		Random ran=new Random();
		int ranNum = ran.nextInt();
		
		FileInputStream fes=new FileInputStream("./src/test/resources/Book1.xlsx");
		
		Workbook book = WorkbookFactory.create(fes);
		Sheet sheet = book.getSheet("campaign");
		Row row = sheet.getRow(0);
		Cell cel = row.getCell(0);
		
		String campaigndata = cel.getStringCellValue()+ranNum;
		
		
		
		driver.findElement(By.name("campaignname")).sendKeys(campaigndata);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		String actdata = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		//both we can use xpath or cssselector
		//String actdata = driver.findElement(By.cssSelector("span.dvHeaderText")).getText();
		
		if(actdata.contains(campaigndata))
		{
			System.out.println("pass");
		}
		else
		{
			System.out.println("Fail");
		}
		Thread.sleep(2000);
		driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		driver.findElement(By.linkText("Sign Out")).click();
		
	}
	@Test
	public void method1()
	{
		System.out.println("method1");
	}
	@Test (groups={"smoketest","regressiontest"})
	public class CreateproductTest extends Baseclass {

		public  void CreateproductTest() throws Throwable {
			
			
			 Property_Utility plib1=new Property_Utility();
			 Webdriver_Utility wlib=new Webdriver_Utility();
		        wlib.implicitwait(driver);

				//login.getSubmitBtn().click();
		        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				//Thread.sleep(1000);
				Homepage1 home=new Homepage1(driver);
				home.clickProductLink();
				Productcreation prd=new Productcreation(driver);
				prd.clickproductCreateImage();

			
			
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
			driver.findElement(By.id("submitButton")).click();
			driver.findElement(By.linkText("Products")).click();
			driver.findElement(By.xpath("//img[@alt='Create Product...']")).click();*/
			
			
			Random ran=new Random();
			int ranNum = ran.nextInt(1000);
			
			Excel_Utility elib=new Excel_Utility();
			String productdata = elib.getExcelData("product",0, 0)+ranNum;
			
		
			
			//prd.productNamesTextField(productdata);
			
			driver.findElement(By.name("productname")).sendKeys(productdata);
			prd.saveButton();
			//driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
			/*String actdata = driver.findElement(By.cssSelector("span.lvtHeaderText")).getText();
			if(actdata.contains(productdata))
				
			{
				System.out.println("pass");
			}
			else
			{
				System.out.println("fail");
			}
			
			//driver.findElement(By.xpath("//div[@class='lvtCol']/div[@class='lvtColData'][6]")).click();
			
			
			Thread.sleep(1000);
			driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
			driver.findElement(By.linkText("Sign Out")).click();
			*/
			home.signoutLink(driver);
			

		}


}
}
