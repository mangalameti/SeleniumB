package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import Generic_Utility.Baseclass;
import Generic_Utility.Webdriver_Utility;


public class Flipkart {
	@Test

	public void FlipkartTest() throws Throwable
	{
		WebDriver driver=new EdgeDriver();
	//Webdriver_Utility wlib=new Webdriver_Utility();
	//wlib.implicitwait(driver);
	driver.manage().window().maximize();
	driver.get("http://www.flipkart.com/");
	driver.findElement(By.xpath("[Text()='✕']")).click();
	

}
}