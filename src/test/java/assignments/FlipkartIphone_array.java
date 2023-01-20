package assignments;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class FlipkartIphone_array
{     static int sum=0;
public static void main(String[] args) throws InterruptedException 
{
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
	driver.get("https://www.flipkart.com/viewcart?exploreMode=true&preference=FLIPKART");
	driver.findElement(By.xpath("//input[@class='_3704LK']")).sendKeys("iphone");
	driver.findElement(By.xpath("//button[@class='L0Z3Pu']")).click();
	Thread.sleep(5000);
	WebElement total = driver.findElement(By.xpath("//span[contains(text(),'422')]"));
	String totaltext  = total.getText();
	String text[]=totaltext.split(" ");
	ArrayList a1 = new ArrayList();
	for (int i = 0; i < text.length; i++) 
	{
		a1.add(text[i]);	
	}
	int totalelements=  Integer.parseInt((String) a1.get(5));
	System.out.println(totalelements);
	for(int i=0;true;i++)
	{
		List<WebElement> list =driver.findElements(By.xpath("//div[@class='_4rR01T']"));
		Thread.sleep(5000);
		sum=sum+list.size(); 
		if(sum==totalelements)
		{
			System.out.println(" the total sum is  "+sum +   "  test case passed");
			break;
		}                      
		Thread.sleep(5000);   
		driver.findElement(By.xpath("//span[text()='Next']")).click();
		Thread.sleep(5000);
	}
	driver.quit();
}

}
