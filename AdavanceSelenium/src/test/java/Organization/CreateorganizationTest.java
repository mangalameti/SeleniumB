package Organization;

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
import org.testng.annotations.Test;

import Generic_Utility.Baseclass;
import Generic_Utility.Java_Utility;
import Generic_Utility.Property_Utility;
import Generic_Utility.Webdriver_Utility;
import POM.Homepage;
import POM.Homepage1;
import POM.Loginpage;

public class CreateorganizationTest extends Baseclass {
@Test
	public void createorganizationTest() throws Throwable {
	
		
	
		
		Webdriver_Utility wlib=new Webdriver_Utility();
		wlib.implicitwait(driver);
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(10, null);
		//Loginpage login=new Loginpage(driver);
		
		//login.getSubmitBtn().click();
		
		Homepage home=new Homepage(driver);
		//home.getCreateOrgLink().click();
		//home.clickLink();
		driver.findElement(By.linkText("Organizations")).click();
	//home.getOrgLinkText();
		Java_Utility jlib=new Java_Utility();
		int RanNum = jlib.getRandomNum();
		
		
		
		FileInputStream fes=new FileInputStream("./src/test/resources/Book1.xlsx");
		
		Workbook book = WorkbookFactory.create(fes);
		Sheet sheet = book.getSheet("Organization");
		Row row = sheet.getRow(0);
		Cell cel = row.getCell(0);
		
		String exceldata1 = cel.getStringCellValue()+RanNum;
		driver.findElement(By.name("accountname")).sendKeys(exceldata1);
		
		//driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		home.getSaveLink().click();
		
		//String actdata = driver.findElement(By.xpath("/html/body/table[3]/tbody/tr[1]/td/table[2]/tbody/tr/td[2]/div/table[1]/tbody/tr/td/span[1]")).getText();
		//String actdata1 = driver.findElement(By.cssSelector("span.dvHeaderText")).getText();
		/*if(actdata.contains(exceldata1))
			
		{
			System.out.println("pass");
		}
		else
		{
			System.out.println("fail");
	}*/
		Thread.sleep(1000);
		
		//driver.findElement(By.xpath("//div[@class='lvtCol']/div[@class='lvtColData'][6]")).click();
		//driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		home.getSinLink().click();
		//driver.findElement(By.linkText("Sign Out")).click();
		home.getSignLink().click();
		
		
	

}
}
