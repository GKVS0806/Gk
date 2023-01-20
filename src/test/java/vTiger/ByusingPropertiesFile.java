package vTiger;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import dev.failsafe.Timeout;

public class ByusingPropertiesFile 
{
	public static void main(String[] args) throws InterruptedException, IOException 
	{
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\logincredentials.properties");
		Properties property=new Properties();
		property.load(fis);
	
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Long.parseLong(property.getProperty("timeouts"))));
	driver.get(property.getProperty("url"));
	driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(property.getProperty("username"));
	driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(property.getProperty("password"));
	driver.findElement(By.xpath("//input[@id='submitButton']")).click();
	if(driver.getTitle().contains("vtiger"))
	{
	System.out.println("test case passed ");	
	}
	else
	{
		System.out.println("test case failed ");	
	}
	driver.quit();
}
}