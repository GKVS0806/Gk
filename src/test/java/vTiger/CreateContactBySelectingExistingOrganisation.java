package vTiger;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



public class CreateContactBySelectingExistingOrganisation 
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
	driver.findElement(By.xpath("//a[@href='index.php?module=Contacts&action=index']")).click();
	driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
	driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("girish");
	driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("kumar");
	driver.findElement(By.xpath("//img[@src='themes/softed/images/select.gif']")).click();
    Runtime.getRuntime().exec("C:\\Users\\Girish\\Desktop\\Autoit exe files\\contactsORG.exe");	
    driver.findElement(By.xpath("//input[@class='crmButton small save']")).click();
    Thread.sleep(2000);
    driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
    Thread.sleep(2000);
    driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
    Thread.sleep(2000);
    driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys("admin");
    driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys("admin");
    driver.findElement(By.xpath("//input[@id='submitButton']")).click();
    driver.findElement(By.xpath("//a[@href='index.php?module=Contacts&action=index']")).click();
    List<WebElement> contacts = driver.findElements(By.xpath("//a[@title='Contacts']"));
    int count=0;
    for(int i=0;i<contacts.size();i++)
    {
    if(contacts.get(i).getText().equals("girish"))
    {
    count++;
    }
    }
    if (count>=1)
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
