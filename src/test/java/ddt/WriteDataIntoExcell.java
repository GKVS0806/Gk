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

public class WriteDataIntoExcell 
{
public static void main(String[] args) throws EncryptedDocumentException, IOException 
{
	FileInputStream fis=new FileInputStream("./src/test/resources/testdata.xlsx");	
	 Workbook wb = WorkbookFactory.create(fis);		
                  Sheet sheet = wb.getSheet("Sheet1");
                                Row row = sheet.getRow(3);
               // creates new cell by deleting older data in the cell
                                           Cell cell = row.createCell(1);
                                       
                                  //writes data into the cell
                                               cell.setCellValue("GK");
                                          //saves data into the cell
                                               FileOutputStream fos=new FileOutputStream("./src/test/resources/testdata.xlsx");

                                                 wb.write(fos);
                                                 // always we need to close 
                                                 wb.close();








}                  
}
