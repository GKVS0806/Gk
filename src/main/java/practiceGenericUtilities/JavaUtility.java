package practiceGenericUtilities;
/**
 * this class contains reusable methods of java 
 * @author Girish
 *
 */
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class JavaUtility
{
	/**
	 * this method is used to generate the random number
	 * @param limit
	 * @return
	 */
public int generateRandomNumber(int limit)
{
Random random = new Random();
    return random.nextInt(limit);
}
public void getCurrentTime()
{
Date date = new Date();
SimpleDateFormat sdf = new SimpleDateFormat();
sdf.format(date);

}
}
