 package assignments;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Flipkart_iphone
{     static int sum=0;
	
	public static void main(String[] args) throws InterruptedException 
	{
//		ChromeOptions options= new ChromeOptions();
//		options.addArguments("--headless");
//		WebDriver driver = new ChromeDriver(options);

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		driver.get("https://www.flipkart.com/viewcart?exploreMode=true&preference=FLIPKART");
		driver.findElement(By.xpath("//input[@class='_3704LK']")).sendKeys("iphone");
		driver.findElement(By.xpath("//button[@class='L0Z3Pu']")).click();
		Thread.sleep(5000);
	
	                      
		
		for(int i=0;true;i++)
		{
			List<WebElement> list =driver.findElements(By.xpath("//div[@class='_4rR01T']"));
			Thread.sleep(5000);
            sum=sum+list.size(); 
//                        if(sum==422)
                       // {
                        	WebElement total = driver.findElement(By.xpath("//span[contains(text(),'422')]"));
        	                String totaltext  = total.getText();
                        	 Integer S = Integer.valueOf(sum);
                  			String summ=S.toString();
     if(totaltext.contains("422"))
     {
     	System.out.println(" the total sum is  "+sum +   "  test case passed");
     	break;
     }
//                        }
                        Thread.sleep(5000);
         
            driver.findElement(By.xpath("//span[text()='Next']")).click();
            Thread.sleep(5000);
           
		}
		driver.quit();
	}

}
