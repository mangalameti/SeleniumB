package practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DtaProviderExm {
	@Test(dataProvider="dataProvider")
	
	public void booktickets(String src,String des)
	{
		System.out.println("book tickets from"+src+"to"+des);
	}
	
	
	@DataProvider
	public Object [] [] dataProvider()
	{
		Object[][]  objarr=new Object[3][2];
		objarr[0][0]="Bangalore";
		objarr[0][1]="Goa";
		
		objarr[1][0]="Bangalore";
		objarr[1][1]="Mysore";
		
		objarr[2][0]="Bangalore";
		objarr[2][1]="kolkata";
		
		return objarr;
		
	}

}
