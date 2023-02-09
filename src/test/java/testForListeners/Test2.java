package testForListeners;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericUtilities.BaseClass;
//@Listeners(genericUtilities.ListenerImplementation.class)
public class Test2 extends BaseClass
{
	@Test(retryAnalyzer=genericUtilities.RetryImplementation.class)
public void test2()
{
System.out.println("test2");	
Assert.fail();
}
}
