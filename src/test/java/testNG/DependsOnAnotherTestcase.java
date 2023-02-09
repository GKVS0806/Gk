package testNG;

import org.testng.annotations.Test;

public class DependsOnAnotherTestcase
{

	@Test(dependsOnMethods  = "demo4")
	public void demo1()
	{
		System.out.println("demo 1");
	}
	
	@Test
	public void demo2()
	{
		System.out.println("demo 2");
	}
	@Test
	public void demo3()
	 
	{
		System.out.println("demo 3");
	}
	@Test
	public void demo4()
	{
		System.out.println("demo 4");
	}
}
