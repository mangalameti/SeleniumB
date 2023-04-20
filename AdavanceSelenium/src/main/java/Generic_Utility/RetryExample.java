package Generic_Utility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryExample implements IRetryAnalyzer{
int count=0;
int retryLimit=4;
	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		if(count<retryLimit)
		{
			count++;
			return true;
		}
		return false;
	}
	

}
