package javaScriptExecutor;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CompleteJacascriptExecutor 
{
public static void main(String[] args) throws InterruptedException 
{
WebDriver driver = new ChromeDriver();	
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

JavascriptExecutor js = (JavascriptExecutor)driver;
js.executeScript("window.location=arguments[0]","https://demowebshop.tricentis.com/");
WebElement searchTF = driver.findElement(By.xpath("//input[@id='small-searchterms']"));
               WebElement searchBT = driver.findElement(By.xpath("//input[@class='button-1 search-box-button']"));
js.executeScript("arguments[0].value=arguments[1]",searchTF,"laptop" );
js.executeScript("arguments[0].click(0)",searchBT);
     WebElement google = driver.findElement(By.xpath("//a[@href='https://plus.google.com/+nopcommerce']"));
js.executeScript("arguments[0].scrollIntoView(true)",google);
          WebElement books = driver.findElement(By.xpath("//a[@href='/books']"));
                       Point location=  books.getLocation();
                                        int x =location.getX();
                                        int y =location.getY();
                                        js.executeScript("window.scrollBy("+x+","+y+")");
                                        Thread.sleep(2000);
                                        js.executeScript("history.go(0)");
                                        System.out.println("executed succesfully");
                                        driver.quit();
}
}
