package genericUtilities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * this class contains reuseable methods of java
 * @author Girish
 *
 */
public class Javautility 
{
/**
 * this method generates random number
 * @param limit
 * @return
 */
public int generateRandomNumber(int limit)
{
Random random = new Random();
        return random.nextInt(limit);

}
/**
 * this method is used to get current date and time 
 * @return
 */
	public String getCurrentTime()
	{
		Date date = new Date();
		SimpleDateFormat sdf= new SimpleDateFormat("dd_MM_YYYY_hh_mm_ss");
		return sdf.format(date);
		
	}
	
}
