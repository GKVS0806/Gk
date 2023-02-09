package grid;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CrossBrowserParallel 
{
	WebDriver driver;
	@Parameters("Browser")
@BeforeMethod
public void methodConfiguration(String BROWSER) throws MalformedURLException
{
	URL url = new URL("http://192.168.23.1:4444/wd/hub");
	DesiredCapabilities cap = new DesiredCapabilities();
	cap.setPlatform(Platform.WINDOWS);
	if(BROWSER.equals("chrome"))
	{
		cap.setBrowserName("chrome");
	}
	else
	{
		cap.setBrowserName("firefox");	
	}
	driver=new RemoteWebDriver(url,cap);
	driver.manage().window().maximize();
}
	@Test
	public void test() throws InterruptedException
	{
		driver.get("http://www.google.com");
		Thread.sleep(3000);
		driver.quit();
	}
	
}
