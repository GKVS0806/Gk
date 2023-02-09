package practiceGenericUtilities;

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
 * this class contains all the reusable methods related to actions performed on the webDriver
 * @author Girish
 *
 */
public class WebDriverUtility 
{
	public WebDriver driver;
	/**
	 * this class is used to launch the browser
	 * @param browser
	 * @return
	 */
public WebDriver lauchBrowser(String browser)
{
switch(browser)
{
case "chrome":driver = new ChromeDriver();
              break;
case "edge":driver= new EdgeDriver();
              break;
case "firefox":driver = new FirefoxDriver();
              break;
default:System.out.println("invalid browser");
              break;
}
return driver;
}
/**
 * this method is used to maximize the browser
 */
public void maximizeBrowser()
{
driver.manage().window().maximize();	
}
/**
 * this method is used to navigate to the application
 * @param url
 */
public void navigateToTheApplication(String url)
{
	driver.get(url);

}
/**
 * this method is used to wait until the web page is loaded
 * @param time
 */
public void waitUntillElementFound(long time)
{
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));
}
/**
 * this method is used to open the application
 * @param browser
 * @param url
 * @param time
 * @return
 */
public WebDriver openApplcation(String browser, String url, long time)
{
driver=lauchBrowser(browser);
maximizeBrowser();
navigateToTheApplication(url);
waitUntillElementFound(time);
return driver;
}
/**
 * this method is used to wait explicitly until the element is found
 * @param time
 * @param element
 */
public void explicitWait(long time, WebElement element)
{
WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(time));	
wait.until(ExpectedConditions.visibilityOf(element));
}
/**
 * this method is used to shift the mouse over on the particular element
 * @param element
 */
public void moveToElement(WebElement element)
{
Actions a = new Actions(driver);
a.moveToElement(element).perform();
}
/**
 * this method is used to double click on the element
 * @param element
 */
public void doubleClick(WebElement element)
{
Actions a = new Actions(driver);
a.doubleClick(element).perform();
}
/**
 * this method is used to right click on the element
 * @param element
 */
public void rightClick(WebElement element)
{
Actions a = new Actions(driver);
a.contextClick(element).perform();;
}
/**
 * this method is used to drap and drop the element from source to destination
 * @param source
 * @param destination
 */
public void dragAndDrop(WebElement source, WebElement destination)
{
Actions a = new Actions(driver);
a.dragAndDrop(source,destination).perform();
}
/**
 * this method is used to select the element in the drop down by using visible text
 * @param element
 * @param text
 */
public void selectByVisibleText(WebElement element, String text)
{
Select s = new Select(element);
s.selectByVisibleText(text);
}
/** 
 * this method is used to select the element in the drop down by using index value
 * @param element
 * @param index
 */
public void selectByIndex(WebElement element, int index)
{
Select s = new Select(element);
s.selectByIndex(index);
}
/**
 * this method is used to select the element in the drop down by using attribute value
 * @param element
 * @param attributeValue
 */
public void selectByValue(WebElement element, String attributeValue)
{
Select s = new Select(element);
s.selectByValue(attributeValue);
}
/**
 * this method is used to switch to frame by using index value
 * @param index
 */
public void switchToFrameByIndex(int index)
{
driver.switchTo().frame(index);
}
/**
 * this method is used to switch to frame by using element
 * @param element
 */
public void switchToFrameByElement(String element)
{
driver.switchTo().frame(element);	
}
/**
 * this method is used to get the  parent window handle 
 * @return
 */
public String getWindowHandle()
{
return driver.getWindowHandle();	
}
/**
 * this method is used to handle child browser pop-up
 */
public void getWindowHandels()
{
Set<String> handels = driver.getWindowHandles();	
for (String handle : handels) 
{
driver.switchTo().window(handle);// in order to move the driver control from parent to child window 
}
}
/**
 * this method is used to handle the alert pop-up by clicking on OK button
 */
public void alertOk()
{
driver.switchTo().alert().accept();	
}
/**
 * this method is used to handle the alert pop-up by clicking on cancel button
 */
public void alertCancel()
{
driver.switchTo().alert().dismiss();	
}
/**
 * this method is used to disable the browser notifications
 */
public void toDisableNotifications()
{
ChromeOptions options = new ChromeOptions();
options.addArguments("--disable-notifications");
WebDriver driver= new ChromeDriver(options);
}
/**
 * this method is used to take screenshot of the web page in file format
 * @param classname
 * @param currentTime
 * @return
 */
public String takeScreenShotOfWebpage(String classname,  String currentTime )
{
	TakesScreenshot ts =(TakesScreenshot)driver;
  File source = ts.getScreenshotAs(OutputType.FILE);
  File destination= new File("./screenshot"+classname+"_"+currentTime+".png");
  try {
	FileUtils.copyFile(source, destination);
} catch (IOException e) {
	e.printStackTrace();
}
return destination.getAbsolutePath();
}
/**
 * this method is used to take screenshot of the web page in Base 64 format 
 * @return
 */
public String takeScreenShotBase64()
{
	TakesScreenshot ts =(TakesScreenshot)driver;
 return	ts.getScreenshotAs(OutputType.BASE64);
}
/**
 * this method is used to scroll the web page till the specified WebElement
 * @param element
 */
public void toscrolTillTheElement(WebElement element)
{	
 JavascriptExecutor js = (JavascriptExecutor)driver;
 js.executeScript("arguments[0].scrollIntoView(true)",element);
}
/**
 * this method is used to close all windows and to exit the browser
 */
public void closeWindows()
{
driver.quit();	
}


}
