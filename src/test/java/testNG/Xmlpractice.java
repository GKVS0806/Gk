// <!-- comments --> this syntax is used in the xme file to write the comments/ suggestions
package testNG;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Xmlpractice 
{
@Test
public void demo()
{
WebDriver driver = new ChromeDriver();
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
driver.get("http://www.google.com");
driver.quit();
}

}
