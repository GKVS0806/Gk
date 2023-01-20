package genericUtilities;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * this class contains all reusable methods of webDriver
 * @author Girish
 *
 */
public class WebDriverUtility

{

	public WebDriver driver;
	/**
	 * this method is used to launch browser
	 * @param browser
	 * @return
	 */
	public WebDriver launchBrowser(String browser)
	{
		switch(browser)
		{
		case "chrome" :driver = new ChromeDriver();
		break;

		case "firefox":driver=new FirefoxDriver();
		break;

		case "edge":driver=new EdgeDriver();
		break;

		default:
			System.out.println("invalid browser");
			break;

		}
		return driver;
	}
	/**
	 * this method is used to maximize browser
	 */
	public void maximizeBrowser()
	{
		driver.manage().window().maximize();
	}
	/**
	 * this method is used to navigate to application
	 * @param url
	 */
	public void navigateToApplication(String url)
	{
		driver.get(url);

	}
	/**
	 * this method is used to wait till the web page is loaded
	 * @param time 
	 */
	public void waitTillPageload(long time)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));

	}  
	/**
	 * this method is used to wait untill the visibality of the element
	 * @param time
	 * @param element 
	 */
	public void explicitlyWait(long time, WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(time));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	/**
	 * this method is used to mousehover on an element
	 * @param element
	 */

	public void mouseHover(WebElement element)
	{
		Actions a = new Actions(driver);
		a.moveToElement(element).perform();

	}
	/**
	 * this method is used to double click on an element
	 * @param element
	 */
	public void doubleclickonElement(WebElement element)
	{
		Actions a = new Actions(driver);
		a.doubleClick(element).perform();

	}
	/**
	 * this method is used to right click on an element
	 * @param element
	 */
	public void rightClick(WebElement element)
	{
		Actions a = new Actions(driver);
		a.contextClick(element).perform();

	}

	/**
	 * this method is used to drag and drop an element
	 * @param src
	 * @param dest
	 */
	public void dragAndDrop(WebElement src, WebElement dest)
	{
		Actions a = new Actions(driver);
		a.dragAndDrop(src,dest);
	}




	/**
	 * this method is used to select an element from drop down based on index
	 * @param element
	 * @param index
	 */
	public void dropdown(WebElement element, int index)
	{

		Select s = new Select(element);
		s.selectByIndex(index);

	}
	/**
	 * this method is used to select an element from drop down based on value
	 * @param element
	 * @param value
	 */
	public void dropdown(WebElement element, String value)
	{

		Select s = new Select(element);
		s.selectByValue(value);

	}
	/**
	 *  this method is used to select an element from drop down based on text
	 * @param element
	 * @param text
	 */
	public void dropdown( String text,WebElement element)
	{

		Select s = new Select(element);
		s.selectByVisibleText(text);

	}
	/**
	 * this method is used to get parentwindowID
	 * @return
	 */
	public String getparentWindowID()
	{
		return driver.getWindowHandle();
	}
	/**
	 * this method is used to handle child browser popup
	 */
	public void childBrowserpopup()
	{
		Set<String> set = driver.getWindowHandles();
		for (String window : set)
		{
			driver.switchTo().window(window);	
		}
	}
	/**
	 * this method is used to switch to frame based on index
	 * @param index
	 */
	public void switchToFrames(String index)
	{
		driver.switchTo().frame(index);

	}
	/**
	 * this method is used to switch to frame based on element
	 * @param element
	 */
	public void switchToFrame(WebElement element)
	{
		driver.switchTo().frame(element);

	}
	/**
	 * this method is used to handle alert pop up by clicking 'oK'
	 */
	public void alertOK()
	{
		driver.switchTo().alert().accept();

	}
	/**
	 * this method is used to handle alert by clicking 'cancel'
	 */
	public void alertCancel()
	{
		driver.switchTo().alert().dismiss();

	}
	/**
	 * this method is used to disable browser notifications
	 * @return
	 */

	public ChromeOptions disableNotifications()
	{
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disable-notifications");
		return options;

	}
	/**
	 * this method is used to fetch the screenshot of the web page in the file 
	 * @param javautil
	 * @param classname
	 * @return
	 */
	public String getScreenshot(Javautility javautil, String classname)
	{ 
		TakesScreenshot ts= (TakesScreenshot)driver;
		String currentTime = javautil.getCurrentTime(); 
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest  =new File("./Screenshot/"+classname+"_"+currentTime+".png");

		try
		{
			FileUtils.copyFile(src, dest);
		} 
		catch (IOException e)
		{

			e.printStackTrace();
		}
		return dest.getAbsolutePath();
	}

	/**
	 * This method is used to fetch the screenshot based on base64 format
	 * @return
	 */
	public String getScreenshot()
	{
		TakesScreenshot ts= (TakesScreenshot)driver;
		return ts.getScreenshotAs(OutputType.BASE64);
	}
	/**
	 * This method is used to scroll the page till the webelement 
	 * @param element
	 */
	public void scrollTillElement(WebElement element)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true)",element);

	}
	/**
	 * this method is used to close the current window 
	 */
	public void closeCurrentWindow()
	{

		driver.close();
	}
	/**
	 * this method is used to close all the windows and exit browser
	 */
	public void closeWindows()
	{
		driver.quit();
	}

}
