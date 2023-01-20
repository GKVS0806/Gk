//xpath contains - when text length is more and if the text is separeted with spaces
package xpath;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ContainsTextPractice
{
	public static void main(String[] args) 
	{
	WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
	driver.get("https://demo.actitime.com/login.do");
	driver.findElement(By.xpath("//a[contains(text(),'Forgot')]")).click();
	
	}
	
	
	
	
}
