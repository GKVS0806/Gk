package testForListeners;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericUtilities.BaseClass;
//@Listeners(genericUtilities.ListenerImplementation.class)// we can provide this in the particular class or even we can provide in the xml file itself
public class RetryAnalyser extends BaseClass
{
	@Test(retryAnalyzer=genericUtilities.RetryImplementation.class)
	public void retryanalyser()
	{
	System.out.println("retryanalyser");	
	Assert.fail();
}
}