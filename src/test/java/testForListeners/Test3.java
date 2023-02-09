package testForListeners;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericUtilities.BaseClass;
//@Listeners(genericUtilities.ListenerImplementation.class)
public class Test3 extends BaseClass
{
	@Test
	public void test3()
	{
	System.out.println("test3");
// we cannot skip it manually , it need to be done after execution//
	
	}
}
