package Generic_Utility;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import POM.Homepage1;
import POM.Loginpage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Baseclass {
public static WebDriver sdriver;
public WebDriver driver;
	
	@BeforeSuite(groups={"smoketest","regressiontest"})
	public void BS()
	{
		System.out.println("database connection");
	}
	@BeforeTest(groups={"smoketest","regressiontest"})
	public void BT()
	{
		System.out.println("Parallel execution");
	}
	@Parameters("BROWSER")
	@BeforeClass(groups={"smoketest","regressiontest"})
	public void BC() throws Throwable
	//public void BC(String Browser)
	{
		Property_Utility plib=new Property_Utility();
		String Browser = plib.getKeyValue("browser"); 
		
		//WebDriver driver;
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
			driver=new FirefoxDriver();
		}
		
		System.out.println("Launching Browser");
		sdriver=driver;
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	@BeforeMethod(groups={"smoketest","regressiontest"})
	public void BM() throws Throwable
	{
		Property_Utility plib=new Property_Utility();
	
		String URL=plib.getKeyValue("url");
	    String USERNAME = plib.getKeyValue("username");
	    String PASSWORD = plib.getKeyValue("password");
		driver.get(URL);
		
		Loginpage login=new Loginpage(driver);
		login.loginToApp(USERNAME, PASSWORD);
	
		
		System.out.println("Login application");
	}
  @AfterMethod(groups={"smoketest","regressiontest"})
	public void AM()
	{
	 Homepage1 home=new Homepage1(driver);
	  home.getSignoutImg().click();
		home.getSignoutLinkText().click();
		
		System.out.println("Logout application");
	}
  @AfterClass(groups={"smoketest","regressiontest"})
  public void AC()
	{
		System.out.println("Browser closed");
	}
  @AfterTest(groups={"smoketest","regressiontest"})
  public void AT()
	{
		System.out.println("parallel Excution Done");
	
	}
  @AfterSuite(groups={"smoketest","regressiontest"})
  public void AS()
	{
		System.out.println("DataBase connection close");
	}



}
