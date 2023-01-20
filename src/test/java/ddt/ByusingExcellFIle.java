package ddt;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ByusingExcellFIle 
{
public static void main(String[] args) throws EncryptedDocumentException, IOException 
{
//Step 1:Convert physical to java readable object
FileInputStream fis=new FileInputStream("./src/test/resources/testdata.xlsx");	

//Step 2:open the Excel workbook
//Import workbook from org.apche.poi.ss.usermodel
//the below statement throws EncryptedDocumentException and IOException
       Workbook wb = WorkbookFactory.create(fis);
                            
 //step 3:Get controll over the perticular sheet
       Sheet s = wb.getSheet("Sheet1");
                             
 //step 4:get controll over specific row
         Row r = s.getRow(0);
                           
  //step 5:get controll over cell
        Cell c = r.getCell(1);
                           
 //step 6:Fetch data from cell
      System.out.println(c.getStringCellValue());
      
    //step 7:Fetch data from cell           
      double data = wb.getSheet("sheet1").getRow(3).getCell(0).getNumericCellValue();      
      System.out.println(data);       
 //step 8:close workbook
        wb.close();
                           
                // or - in single line of code we can fetch data //
        
          String data1 = wb.getSheet("sheet1").getRow(0).getCell(1).getStringCellValue();      
                     System.out.println(data1);       
}
}
