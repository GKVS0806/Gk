package assignments;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TocountTheNumberOfLinks 
{
public static void main(String[] args) 
{
WebDriverManager.chromedriver().setup();
WebDriver driver = new ChromeDriver();
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
driver.get("https://demowebshop.tricentis.com/");
List<WebElement> countLink = driver.findElements(By.tagName("div"));
System.out.println("The count of links present in the HTMl source code of the given webpage is "+countLink.size());
driver.quit();
}
}
