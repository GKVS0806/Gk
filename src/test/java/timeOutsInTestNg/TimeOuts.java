package timeOutsInTestNg;

import org.testng.annotations.Test;

public class TimeOuts 
{
	@Test(timeOut = 5)
public void ByUsingTimeoutsToFailTC()
{
	
System.out.println("in time outs");

}
}
