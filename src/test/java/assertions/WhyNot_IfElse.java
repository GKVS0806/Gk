package assertions;

import org.testng.annotations.Test;

public class WhyNot_IfElse // since it will not show the failed scripts in if else conditions
{
	@Test
public void demo()
{
String s1="hi";
String s2="hello";
if(s1.equals(s2))
{
System.out.println("pass");	
}
else
{
	System.out.println("fail");	
}
}
}
