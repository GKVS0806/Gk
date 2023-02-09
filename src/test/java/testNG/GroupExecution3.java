package testNG;

import org.testng.annotations.Test;

public class GroupExecution3 
{
	@Test(groups="smoke")
public void test0()
{
	System.out.println("test0");
}
	@Test(groups="regression")
public void test1()
{
	System.out.println("test1");
}
	@Test(groups={"smoke","sanity"})
public void test2()
{
	System.out.println("test2");
}
	@Test(groups="sanity")
public void test3()
{
	System.out.println("test3");
}
}
