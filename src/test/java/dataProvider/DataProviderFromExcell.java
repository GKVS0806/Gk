package dataProvider;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderFromExcell 
{
	
	@Test(dataProvider="testDataFromExcell")
	public void testData(String org, String ind, String type)
	{
		System.out.println("organisation name  "+org+"      industry  "+ind+"  type  "  +type);	
	}
	@DataProvider
	public Object[][] testDataFromExcell() 
	{
		Object[][] obj=new Object[5][3];
		FileInputStream fis=null;
		try {
			fis = new FileInputStream("./src/test/resources/DataProvider-multipleData.xlsx");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		Workbook workbook = null;
		try {
			workbook=WorkbookFactory.create(fis);
		} catch (EncryptedDocumentException | IOException e) {
			e.printStackTrace();
		}
	Sheet sheet=workbook.getSheet("Sheet1");
	for(int i=0;i<3;i++)
	{
		for(int j=1;j<5;j++)
		{
			obj[j][i]=sheet.getRow(i).getCell(j).getStringCellValue();
		}
		
	}
		try {
			workbook.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return obj;
	}
}
