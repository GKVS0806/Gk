package xpath;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class googlesearch 
{
public static void main(String[] args) 
{
WebDriverManager.chromedriver().setup();
WebDriver driver = new ChromeDriver();
driver.manage().window().maximize();
driver.get("https://www.google.com/");
     driver.findElement(By.xpath("//input[@class='gLFyf']")).sendKeys("girish");
     List<WebElement> element = driver.findElements(By.className("class='sbct'"));
  ArrayList a1 = new ArrayList();
  for (WebElement e :element) 
  {
	a1.add(e);
}
          System.out.println(a1.get(4));

driver.quit();
}
}
