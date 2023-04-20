package campaign;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
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
import org.testng.annotations.Test;

import Generic_Utility.Baseclass;
import Generic_Utility.Excel_Utility;
import Generic_Utility.Java_Utility;
import Generic_Utility.Property_Utility;
import Generic_Utility.Webdriver_Utility;
import POM.Campaigncreation;
import POM.Homepage1;
import POM.Loginpage;
import POM.Productcreation;
import io.github.bonigarcia.wdm.WebDriverManager;
@Test
public class campaignwithProductTest extends Baseclass{

	public  void campaignwithProductTest() throws Throwable {
		
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

		
		
		
		
		
		 Property_Utility plib1=new Property_Utility();
		 Webdriver_Utility wlib=new Webdriver_Utility();
	        wlib.implicitwait(driver);

			
			Thread.sleep(1000);
			Homepage1 home=new Homepage1(driver);
home.clickProductLink();
Productcreation prd=new Productcreation(driver);
prd.clickproductCreateImage();

		
		
		
		
		
		
		
//		Random ran=new Random();
//		int ranNum = ran.nextInt();
		
		Java_Utility jlib=new Java_Utility();
		int RanNum = jlib.getRandomNum();
		
		Excel_Utility elib=new Excel_Utility();
		String productdata = elib.getExcelData("product", 0,0)+RanNum;
		
		
		/*FileInputStream fes=new FileInputStream("./src/test/resources/Book1.xlsx");
		
		Workbook book = WorkbookFactory.create(fes);
		Sheet sheet = book.getSheet("product");
		Row row = sheet.getRow(0);
		Cell cel = row.getCell(0);
		
		String productdata = cel.getStringCellValue()+RanNum;*/
		
		
	
		//prd.productNamesTextField(productdata);
		driver.findElement(By.name("productname")).sendKeys(productdata);
		prd.saveButton();
		//driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		/*String actdata = driver.findElement(By.cssSelector("span.dvHeaderText")).getText();
		if(actdata.contains(exceldata))
			
		{
			System.out.println("pass");
		}
		else
		{
			System.out.println("fail");
		}*/
		Thread.sleep(1000);
		Homepage1 home1=new Homepage1(driver);
		home1.moreLink(driver);
		home1.campaignLinkText();
		
		Campaigncreation cmp=new Campaigncreation(driver);
		cmp.clickCampaignCreateImage();
		
		
		
		
		
/*driver.findElement(By.linkText("More")).click();
		
		driver.findElement(By.linkText("Campaigns")).click();
		driver.findElement(By.xpath("//img[@alt='Create Campaign...']")).click();*/
		
		Java_Utility jlib1=new Java_Utility();
		int RanNum1 = jlib1.getRandomNum();
		/*FileInputStream fes1=new FileInputStream("./src/test/resources/Book1.xlsx");
		
		Workbook book1 = WorkbookFactory.create(fes1);
		Sheet sheet1 = book1.getSheet("campaign");
		Row row1 = sheet.getRow(0);
		Cell cel1 = row.getCell(0);
		
		String campaigndata = cel1.getStringCellValue()+ranNum1;*/
		Excel_Utility elib1=new Excel_Utility();
		String campaigndata = elib1.getExcelData("product", 0,0)+RanNum1;
		
		cmp.campaignNamesTextField(campaigndata);
		
	
		
		//driver.findElement(By.name("campaignname")).sendKeys(campaigndata);
//		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
//		String actdata1 = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
//		
		driver.findElement(By.xpath("//img[@alt='Select']")).click();
	Set<String> allId = driver.getWindowHandles();
		Iterator<String> id = allId.iterator();
		while(id.hasNext())
		{
			String window = id.next();
			driver.switchTo().window(window);
			String title = driver.getTitle();
			if(title.contains("Products&action"))
			{
				break;
			}
		}
			
			driver.findElement(By.id("search_txt")).sendKeys(productdata);
			
			
			driver.findElement(By.name("search")).click();
		

driver.findElement(By.xpath("//a[text()='"+productdata+"']")).click();
Set<String> allId1 = driver.getWindowHandles();
Iterator<String> id1 = allId1.iterator();
while(id1.hasNext())
{
	String window = id1.next();
	driver.switchTo().window(window);
	String title = driver.getTitle();
	if(title.contains("Campaigns&action"))
	{
		break;
	}
}
	
	driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	String actdata = driver.findElement(By.xpath("//span[@id='dtlview_Campaign Name']")).getText();
	
	if(actdata.contains(campaigndata))
		
	{
		System.out.println(" campaign pass");
	}
	else
	{
		System.out.println("fail");
	}
	String act = driver.findElement(By.xpath("//span[@id='dtlview_Product']")).getText();
	
	
if(act.contains(productdata))
		
	{
		System.out.println("product pass");
	}
	else
	{
		System.out.println("fail");
	}
Thread.sleep(2000);
driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
driver.findElement(By.linkText("Sign Out")).click();




	}

}
