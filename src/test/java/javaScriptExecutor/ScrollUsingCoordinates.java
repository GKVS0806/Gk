package javaScriptExecutor;

import java.time.Duration;

import org.apache.commons.math3.geometry.partitioning.Region.Location;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScrollUsingCoordinates 
{
public static void main(String[] args) 
{
WebDriver driver=new ChromeDriver();	
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
driver.get("https://www.amazon.in/");
         
WebElement element = driver.findElement(By.xpath("//img[@alt='MULTIZONE Crystal Clear Toughened Glass Tea Cup with Convenient Solid Handle Cups, Espresso Mug Set for Tea, Coffee,...']"));

Point location = element.getLocation();
location.getX();
location.getY();
JavascriptExecutor js=(JavascriptExecutor)driver;



}
}
