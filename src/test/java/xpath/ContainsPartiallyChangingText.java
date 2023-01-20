package xpath;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.idealized.Javascript;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ContainsPartiallyChangingText 
{
public static void main(String[] args) throws InterruptedException 
{
WebDriverManager.chromedriver().setup();
WebDriver driver=new ChromeDriver();
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
driver.get("https://demo.actitime.com/login.do");
driver.findElement(By.name("username")).sendKeys("admin");
driver.findElement(By.name("pwd")).sendKeys("manager");
driver.findElement(By.id("loginButton")).click();

WebElement selectDp = driver.findElement(By.xpath("//div[@class='menu_icon']"));
    JavascriptExecutor js= (JavascriptExecutor)driver;
    js.executeScript("arguments[0].click()",selectDp);

Thread.sleep(2000);
driver.findElement(By.xpath("//*[text()='About your actiTIME']")).click();





}
}
