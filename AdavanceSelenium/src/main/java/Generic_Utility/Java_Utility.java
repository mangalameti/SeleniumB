package Generic_Utility;

import java.util.Random;

public class Java_Utility {
	public int getRandomNum()
	{
		/**
		 * This method is used to avoid duplicates
		 * @return
		 * @author Umesha K
		 */
		Random ran=new Random();
	    int	RanNum=ran.nextInt(1000);
		return RanNum;
	}


}
