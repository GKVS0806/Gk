package vTiger;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOrganisation 
{
public static void main(String[] args) throws InterruptedException 
{
WebDriver driver = new ChromeDriver();
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
driver.get("http://localhost:8888/index.php?action=Login&module=Users");
driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys("admin");
driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys("admin");
driver.findElement(By.xpath("//input[@id='submitButton']")).click();
driver.findElement(By.xpath("//a[@href='index.php?module=Accounts&action=index']")).click();
driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys("walmart@Gkvs");
driver.findElement(By.xpath("//td[@colspan='4']/descendant::input[@title='Save [Alt+S]' and @style='width:70px']")).click();
Thread.sleep(4000);
driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys("admin");
driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys("admin");
driver.findElement(By.xpath("//input[@id='submitButton']")).click();
driver.findElement(By.xpath("//a[@href='index.php?module=Accounts&action=index']")).click();

List<WebElement> list = driver.findElements(By.xpath("//a[@title='Organizations']"));
int count=0;
for(int i=0;i<list.size();i++)
{
if(list.get(i).getText().equals("walmart@Gkvs"))
{
	count++;
}
}
if(count==1)
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
