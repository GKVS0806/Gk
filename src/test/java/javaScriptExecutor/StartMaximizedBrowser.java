package javaScriptExecutor;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class StartMaximizedBrowser
{
	public static void main(String[] args) 
	{
		ChromeOptions option = new ChromeOptions();
		option.addArguments("start-maximized");
		WebDriver driver = new ChromeDriver();
		//driver.manage().window().maximize();// directly we are starting the browser in the maximized mode, so no need of this line of code
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		driver.get("https://www.yatra.com/");
	}
}
