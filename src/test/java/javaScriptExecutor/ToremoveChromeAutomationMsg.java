package javaScriptExecutor;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ToremoveChromeAutomationMsg 
{

	public static void main(String[] args) 
	{
		ChromeOptions option = new ChromeOptions();
		option.setExperimentalOption("excludeSwitches" ,new String[] {"enable-automation"});
		WebDriver driver = new ChromeDriver(option);
		System.out.println("ToremoveChromeAutomationMsg - removed");   
}
}
