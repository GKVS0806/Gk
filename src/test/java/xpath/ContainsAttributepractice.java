//xpath contains - when attribute length is more
package xpath;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ContainsAttributepractice 
{
public static void main(String[] args) throws InterruptedException 
{
WebDriverManager.chromedriver().setup();	
WebDriver driver=new ChromeDriver();
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
driver.get("https://www.facebook.com/");
Thread.sleep(2000);
driver.findElement(By.xpath("//a[contains(@title,'Read')]")).click();
}	
}
