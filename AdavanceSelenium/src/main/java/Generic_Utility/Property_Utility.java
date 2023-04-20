package Generic_Utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class Property_Utility 
{
	public String getKeyValue(String key) throws Throwable
	{
	/**
	 * This method is used to fetch the data from file
	 * @thhows Throwable
	 * @author Umesha K
	 * @return
	 * @parm
	 */
	FileInputStream fis=new FileInputStream("./src/test/resources/PropertyFileData.properties");
	Properties pro=new Properties();
	pro.load(fis);
	String Value = pro.getProperty(key);
	
	return Value;

}
}
