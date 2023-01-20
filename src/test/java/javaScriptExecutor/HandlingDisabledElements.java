package javaScriptExecutor;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingDisabledElements 
{
public static void main(String[] args) 
{
WebDriver driver = new ChromeDriver();
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
  driver.get("file:///C:/Users/Girish/Desktop/notepad%20nts/Selenium/Advanced%20selenium/disabeled%20elements.html");   
 WebElement disabledTF = driver.findElement(By.xpath("//input[@id='abc']"));
    JavascriptExecutor js = (JavascriptExecutor)driver;
//js.executeScript("window.location=arguments[0]","file:///C:/Users/Girish/Desktop/notepad%20nts/Selenium/Advanced%20selenium/disabeled%20elements.html");

    js.executeScript("arguments[0].value=arguments[1]",disabledTF,"gkvs");

}
}
