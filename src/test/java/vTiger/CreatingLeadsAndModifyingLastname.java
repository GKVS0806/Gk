package vTiger;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CreatingLeadsAndModifyingLastname 
{
	public static void main(String[] args) throws InterruptedException, IOException 
	{
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
	driver.get("http://localhost:8888/index.php?action=Login&module=Users");
	driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys("admin");
	driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys("admin");
	driver.findElement(By.xpath("//input[@id='submitButton']")).click();
	driver.findElement(By.xpath("//a[@href='index.php?module=Leads&action=index']")).click();
	driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
	driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("girish");
	driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("kumar");
	driver.findElement(By.xpath("//input[@name='company']")).sendKeys("Deloite");
	driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	driver.findElement(By.xpath("//input[@title='Duplicate [Alt+U]']")).click();
	WebElement lastnameTF = driver.findElement(By.xpath("//input[@name='lastname']"));
	                JavascriptExecutor js = (JavascriptExecutor)driver;
	                js.executeScript("arguments[0].value=arguments[1]",lastnameTF,"GKVS");
	            	driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	            	 Thread.sleep(4000);
	                 driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
	                 driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
	                 driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys("admin");
	                 driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys("admin");
	                 driver.findElement(By.xpath("//input[@id='submitButton']")).click();
	             	driver.findElement(By.xpath("//a[@href='index.php?module=Leads&action=index']")).click();
	               List<WebElement> leads = driver.findElements(By.xpath("//a[@title='Leads']"));
	                 
	
	               int count=0;
	               for(int i=0;i<leads.size();i++)
	               {
	               if(leads.get(i).getText().equals("GKVS"))
	               {
	               	count++;
	               }
	               }
	               if(count>=1)
	               {
	               	System.out.println("test case passed");
	               }
	               else
	               {
	               	System.out.println("test case failed");
	               }
	               driver.quit();
	               
	
}
}
