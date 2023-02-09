// first it will execute according to the priority
// then by invocation count , it will execute for specefied number of times 

package testNG;


import org.testng.annotations.Test;

public class InvocationcountANDpriority 
{
	@Test(invocationCount = 2,priority=-1)
	public void demo1()
	{
		System.out.println("demo 1");
	}
	@Test(priority=1)
	public void demo5()
	{
		System.out.println("demo 5");
	}
	@Test(invocationCount = -1,priority=2)
	public void demo6()
	{
		System.out.println("demo 6");
	}
	@Test(invocationCount = 4,priority=3)
	public void demo2()
	{
		System.out.println("demo 2");
	}
	@Test(invocationCount = 2,priority=4)
	public void demo3()
	{
		System.out.println("demo 3");
	}
	@Test(invocationCount = 4,priority=5)
	public void demo4()
	{
		System.out.println("demo 4");
	}
}
