package assignments;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ToSelectPerticularElementFromTheSuggestionsDropdown
{
public static void main(String[] args) 
{
//	ChromeOptions options = new ChromeOptions();
//	options.addArguments("--headless");
//	WebDriver driver= new ChromeDriver(options);
	
	
WebDriverManager.chromedriver().setup();
WebDriver driver= new ChromeDriver();
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
driver.get("https://www.google.com/");

}
}
