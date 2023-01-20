package ddt;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WritingDataIntotheNewRowOfExcell
{
	public static void main(String[] args) throws EncryptedDocumentException, IOException
	{
		
	
	FileInputStream fis=new FileInputStream("./src/test/resources/testdata.xlsx");	
	 Workbook wb = WorkbookFactory.create(fis);		
                 Sheet sheet = wb.getSheet("Sheet1");
                 
                 // to create the new Row by deleting the older data in the row
                               Row row = sheet.createRow(4);
                               
                               //to create the new cell by deleting the older data in the cell
                                      Cell cell = row.createCell(0);
                                      
                                      //writes data into the cell
                                      cell.setCellValue("Gkvs");
                                      
                                      //saves data into the excell
                                      FileOutputStream fos=new FileOutputStream("./src/test/resources/testdata.xlsx");
                                      wb.write(fos);
                                      wb.close();
                               
                               
	}
}