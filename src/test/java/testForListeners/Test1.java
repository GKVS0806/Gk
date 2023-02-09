package testForListeners;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericUtilities.BaseClass;
//@Listeners(genericUtilities.ListenerImplementation.class)
public class Test1 extends BaseClass
{
	@Test
public void test1()
{
System.out.println("test1");
//success//
}
}
