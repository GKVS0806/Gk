package javaScriptExecutor;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class StartMaximizedBrowser_HandlingNotificationPopup 
{
	public static void main(String[] args) 
	{
		ChromeOptions option = new ChromeOptions();
		option.addArguments("start-maximized");
		option.addArguments("--disable-notifications");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));// directly we are starting the browser in the maximized mode, so no need of this line of code
		driver.get("https://www.yatra.com/");
	}
}
