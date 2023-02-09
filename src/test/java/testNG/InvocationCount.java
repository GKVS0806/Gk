//default invocation count is 1
// if we give invocation count in negative , then that particular test case will not be executed
package testNG;

import org.testng.annotations.Test;

public class InvocationCount 
{
	@Test(invocationCount = 2)
	public void demo1()
	{
		System.out.println("demo 1");
	}
	@Test
	public void demo5()
	{
		System.out.println("demo 5");
	}
	@Test(invocationCount = -1)
	public void demo6()
	{
		System.out.println("demo 6");
	}
	@Test(invocationCount = 4)
	public void demo2()
	{
		System.out.println("demo 2");
	}
	@Test(invocationCount = 2)
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
