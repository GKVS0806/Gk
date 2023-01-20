package xpath;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
public class FlipkartElements 
{
public static void main(String[] args) throws InterruptedException 
{
	WebDriverManager.chromedriver().setup();
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
	driver.get("https://www.flipkart.com/viewcart?exploreMode=true&preference=FLIPKART");
	driver.findElement(By.xpath("//input[@class='_3704LK']")).sendKeys("iphone");
	Thread.sleep(5000);
	driver.findElement(By.xpath("//button[@class='L0Z3Pu']")).click();
	Thread.sleep(5000);
	
	List<WebElement> list = driver.findElements(By.xpath("//div[@class='_4rR01T']"));
	 List<WebElement> iprice = driver.findElements(By.xpath("//div[@class='_30jeq3 _1_WHN1']"))	; 
	 
for (int i = 0; i < list.size(); i++)
{
	System.out.println(list.get(i).getText() +  "                    " +iprice.get(i).getText());
}
}
}
