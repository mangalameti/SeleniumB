package Generic_Utility;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
//import org.testng.annotations.Test;


public class ListenerClass implements ITestListener {
	public void onTestFailure(ITestResult result)
	{
	String testName=result.getMethod().getMethodName();
	EventFiringWebDriver edriver=new EventFiringWebDriver(Baseclass.sdriver);
File src = edriver.getScreenshotAs(OutputType.FILE);
	try
	{
		FileUtils.copyFile(src,new File("./Screenshot/"+testName+".png"));
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	
	
	}
	}


