package Generic_Utility;

import java.sql.Date;
import java.time.Duration;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;

public class Webdriver_Utility {

	public void mouseOverOnElement(WebDriver driver,WebElement element)
	{
		Actions act=new Actions(driver);
		act.moveToElement(element).perform();
		
	}

	
	public void implicitwait(WebDriver driver)
	{
		//driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	}
	
	public void scriptTimeOut(WebDriver driver)
	{
		driver.manage().timeouts().setScriptTimeout(20,TimeUnit.SECONDS);
		
	}

	
	
	public void waitForElementWithCustomTimeOut(WebDriver driver,WebElement Element,int pollingTime)
	{
		FluentWait wait=new FluentWait(driver);
	    wait.pollingEvery(Duration.ofSeconds(20));	
	    wait.until(ExpectedConditions.elementToBeClickable(Element));
	}
	
	public void switchToWindow(WebDriver driver,String PartialWindowTitle)
	{
		  Set<String> allId = driver.getWindowHandles();
	      Iterator<String> it=allId.iterator();
	      while(it.hasNext())
	      {
	      	String wid = it.next();
	      	driver.switchTo().window(wid);
	      	if(driver.getTitle().contains(PartialWindowTitle))
	      	{
	      		break;
	      	}
	}}
	
	
	
	
	
	public void switchToAlertAndAccpect(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	public void switchToAlertAndDismiss(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	
	public void switchToFrame(WebDriver driver,int index)
	{
		driver.switchTo().frame(index);
		}
	
	
	
	public void switchToFrame(WebDriver driver,String id_name_Attribute)
	{
	driver.switchTo().frame(id_name_Attribute);	
	}
	
	public void select(WebElement element,int index)
	{
		Select sel=new Select(element);
		sel.selectByIndex(index);
	}
	public void select(WebElement element, String text)
	{
		Select sel=new Select(element);
		sel.selectByVisibleText(text);
	}
	
	/*public void mouseOverOnElement(WebDriver driver,WebElement element)
	{
		Actions act=new Actions(driver);
		act.moveToElement(element).perform();
		
	}*/
	
	
	
	
	public void rightClickOnElement(WebDriver driver,WebElement element)
	{
		Actions act=new Actions(driver);
		act.contextClick(element).perform();
	}
	public void moveByOffest(WebDriver driver,int x,int y)
	{
		Actions act=new Actions(driver);
		act.moveByOffset(x, y).click().perform();
	}
	public  String takeScreenshot(WebDriver sDriver, String methodName) {
		
		Date date=new Date(0);
		date.toString().replace(" "," ").replace(":","-");
		//TakesScreenshot ts=(TakesScreenshot)driver;
		return null;
	}


	public void max(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
