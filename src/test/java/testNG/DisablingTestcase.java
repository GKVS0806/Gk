// if we disabling the testcase , then that particular test case will be skipped for execution
package testNG;

import org.testng.annotations.Test;

public class DisablingTestcase 
{
	@Test(invocationCount = 2)
	public void demo1()
	{
		System.out.println("demo 1");
	}
	@Test(invocationCount = 4)
	public void demo2()
	{
		System.out.println("demo 2");
	}
	@Test(enabled=false)// disabling the testcase
	public void demo3()
	{
		System.out.println("demo 3");
	}
	@Test(invocationCount = 4)
	public void demo4()
	{
		System.out.println("demo 4");
	}
}
