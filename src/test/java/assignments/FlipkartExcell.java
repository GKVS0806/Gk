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

public class FlipkartExcell 
{
	static int sum;
	public static void main(String[] args) throws EncryptedDocumentException, IOException, InterruptedException 
	{
        FileInputStream fis;
		Workbook workbook;
		Sheet sheet;
		Row row;
		Cell cell;
		FileOutputStream fos;
		ChromeOptions options= new ChromeOptions();
		options.addArguments("--headless");
		WebDriver driver = new ChromeDriver(options);

		//WebDriverManager.chromedriver().setup();
		//WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.flipkart.com/viewcart?exploreMode=true&preference=FLIPKART");
		driver.findElement(By.cssSelector("input[class='_3704LK']")).sendKeys("iphone");
		driver.findElement(By.xpath("//button[@class='L0Z3Pu']")).click();
		WebElement total = driver.findElement(By.xpath("//span[contains(text(),'422')]"));
		String totaltext  = total.getText();
		String text[]=totaltext.split(" ");
		ArrayList a1 = new ArrayList();
		for (int i = 0; i < text.length; i++) 
		{
			a1.add(text[i]);	
		}
		int totalelements=  Integer.parseInt((String) a1.get(5));
		ArrayList a2= new ArrayList();
		ArrayList a3= new ArrayList();
		
		while(true)
		{
			List<WebElement> names =driver.findElements(By.xpath("//div[@class='_4rR01T']"));
			List<WebElement> prices = driver.findElements(By.xpath("//div[@class='_30jeq3 _1_WHN1']"));

			Thread.sleep(5000);
		   
			for(WebElement name :names)
			{
				a2.add(name.getText());
			}
			for(WebElement price :prices)
			{
				a3.add(price.getText());
			}
			sum=sum+names.size(); 
			if(sum==totalelements)
			{
				break;
			}  

			Thread.sleep(5000);   
			driver.findElement(By.xpath("//span[text()='Next']")).click();
			Thread.sleep(5000);
		}

		System.out.println(a2);
		System.out.println(a2.size());
		System.out.println(a3);
		System.out.println(a3.size());

		for(int i=0;i<sum;i++)
		{
			fis = new FileInputStream("./src/test/resources/FlipkartExcell.xlsx");
			workbook = WorkbookFactory.create(fis);
			sheet = workbook.getSheet("Sheet1");
			row = sheet.createRow(i);
			cell = row.createCell(0);
			cell.setCellValue((String)a2.get(i));

			fos = new FileOutputStream("./src/test/resources/FlipkartExcell.xlsx");
			workbook.write(fos);
			workbook.close();

			fis = new FileInputStream("./src/test/resources/FlipkartExcell.xlsx");
			workbook = WorkbookFactory.create(fis);
			sheet = workbook.getSheet("Sheet1");
			row = sheet.getRow(i);
			cell = row.createCell(1);
			cell.setCellValue((String)a3.get(i));

			fos = new FileOutputStream("./src/test/resources/FlipkartExcell.xlsx");
			workbook.write(fos);
			workbook.close();                                          

		}

		driver.quit();
	}
}

























