package xmlParameterization;

import org.testng.annotations.Test;
import org.testng.xml.XmlTest;

public class Practice
{
	  
	@Test
public void pract(XmlTest xml)
{
System.out.println("in the parametrization practice");	
System.out.println(xml.getParameter("url"));
System.out.println(xml.getParameter("username"));
System.out.println(xml.getParameter("password"));

}
}
