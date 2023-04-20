package practice;

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

import Generic_Utility.Java_Utility;
import Generic_Utility.Property_Utility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Sales {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		
		Property_Utility plib=new Property_Utility();
		String Browser = plib.getKeyValue("browser");
		
		WebDriver driver;
		if(Browser.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if(Browser.equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}
		else if(Browser.equalsIgnoreCase("firefox"))
				{
					WebDriverManager.firefoxdriver().setup();
					driver=new FirefoxDriver();
				}
		else
		{
			driver=new EdgeDriver();
		}
		
		
		
		
		driver.manage().window().maximize();
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
		/*driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		
		/*Random ran=new Random();
		int RanNum=ran.nextInt();*/
		
		
	/*	Java_Utility jlib=new Java_Utility();
		int RanNum = jlib.getRandomNum();
		
		
		
		FileInputStream fes=new FileInputStream("./src/test/resources/Book1.xlsx");
		
		Workbook book = WorkbookFactory.create(fes);
		Sheet sheet = book.getSheet("Organization");
		Row row = sheet.getRow(0);
		Cell cel = row.getCell(0);
		
		String exceldata1 = cel.getStringCellValue()+RanNum;
		driver.findElement(By.name("accountname")).sendKeys(exceldata1);
		
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();*/
		
		
		
		Thread.sleep(2000);
		driver.findElement(By.linkText("More")).click();
		driver.findElement(By.linkText("Sales Order")).click();
		driver.findElement(By.xpath("//img[@alt='Create Sales Order...']")).click();
		
		
		Random ran2=new Random();
		int ranNum1 = ran2.nextInt(1000);
		
		FileInputStream fes2=new FileInputStream("./src/test/resources/Book1.xlsx");
		
		Workbook book2 = WorkbookFactory.create(fes2);
		Sheet sheet2 = book2.getSheet("sales");
		Row row2 = sheet2.getRow(0);
		Cell cel2 = row2.getCell(0);
		
		String salesdata = cel2.getStringCellValue()+ranNum1;
		
		
		
		driver.findElement(By.name("subject")).sendKeys(salesdata);
		
		driver.findElement(By.xpath("input#single_accountid")).sendKeys("123");
		//driver.findElement(By.xpath("(//img[alt='Select'])[3]")).click();
		//driver.findElement(By.id("search_txt")).sendKeys(exceldata1);
		
		//driver.findElement(By.xpath("//a[text()='"+exceldata1+"']")).click();
		
		Set<String> allId = driver.getWindowHandles();
		Iterator<String> id = allId.iterator();
		while(id.hasNext())
		{
			String window = id.next();
			driver.switchTo().window(window);
			String title = driver.getTitle();
			if(title.contains("Potentials&action"))
			{
				break;
			}
		}

		
		
		driver.findElement(By.name("search")).click();
		//driver.findElement(By.xpath("//a[text()='"+exceldata1+"']")).click();
	
		Set<String> allId1 = driver.getWindowHandles();
		Iterator<String> id1 = allId1.iterator();
		while(id1.hasNext())
		{
			String window = id1.next();
			driver.switchTo().window(window);
			String title = driver.getTitle();
			if(title.contains("Potentials&action"))
			{
				break;
			}
		}

		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		

	}

}
