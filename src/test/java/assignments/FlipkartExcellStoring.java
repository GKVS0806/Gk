package assignments;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class FlipkartExcellStoring
{
	static String S;
	static int sum=0;
	public static void main(String[] args) throws EncryptedDocumentException, IOException, InterruptedException 
	{
		ChromeOptions options= new ChromeOptions();
		options.addArguments("--headless");
		WebDriver driver = new ChromeDriver(options);


		//	WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		driver.get("https://www.flipkart.com/viewcart?exploreMode=true&preference=FLIPKART");
		driver.findElement(By.xpath("//input[@class='_3704LK']")).sendKeys("iphone");
		driver.findElement(By.xpath("//button[@class='L0Z3Pu']")).click();

		Thread.sleep(5000);

		WebElement total = driver.findElement(By.xpath("//span[contains(text(),'422')]"));
		String totaltext  = total.getText();
		String text[]=totaltext.split(" ");
		ArrayList a1 = new ArrayList();
		for (int i = 0; i < text.length; i++) 
		{
			a1.add(text[i]);	
		}
		int totalelements=  Integer.parseInt((String) a1.get(5));

		

		FileInputStream fis=new FileInputStream("./src/test/resources/FlipkartStoring.xlsx");	
		Workbook workbook=WorkbookFactory.create(fis);
		Sheet sheet = workbook.getSheet("Sheet1");

		int count=0;
		for(int j=0;j<=totalelements;j++)
		{

			List<WebElement> list =driver.findElements(By.xpath("//div[@class='_4rR01T']"));
			
			  for (WebElement ele : list) 
				{
				  for(int r=0;r<=list.size();r++)
				  {
					  for(int c=0;c<1;c++)
					  {
						  Row row = sheet.createRow(r);
						            Cell cell = row.createCell(c);
						            cell.setCellValue(ele.getText());
						            FileOutputStream fos=new FileOutputStream("./src/test/resources/FlipkartStoring.xlsx");

						            count++;
					  }
				  }
				}
		
		sum=sum+list.size(); 
		if(sum==totalelements)
		{
			
			break;
		}          
				driver.findElement(By.xpath("//span[text()='Next']")).click();
				Thread.sleep(5000);
		
		}
		System.out.println(count);
	
			workbook.close();

		
		driver.quit();
	}
}
