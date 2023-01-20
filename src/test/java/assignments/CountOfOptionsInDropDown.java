package assignments;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CountOfOptionsInDropDown 
{
public static void main(String[] args) 
{

WebDriver driver = new ChromeDriver();
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
driver.get("file:///C:/Users/Girish/Desktop/dropdown.html");
List<WebElement> list = driver.findElements(By.id("single"));
System.out.println(list);

}
}
