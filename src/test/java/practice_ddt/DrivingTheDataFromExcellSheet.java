package practice_ddt;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class DrivingTheDataFromExcellSheet 
{
public static void main(String[] args) throws EncryptedDocumentException, IOException 
{
FileInputStream fis =new FileInputStream("./src/test/resources/practice.xlsx");	
                   Workbook workbook = WorkbookFactory.create(fis);
                                    Sheet sheet = workbook.getSheet("Sheet1");
                                                Row row = sheet.getRow(0);
                                                     Cell cell = row.getCell(0);
                                                              
                                                     System.out.println(cell.getStringCellValue());
                                                     System.out.println(sheet.getRow(2).getCell(0).getNumericCellValue());
                                                     DataFormatter df = new DataFormatter();
                                                     
                                                     System.out.println(df.formatCellValue(sheet.getRow(2).getCell(0)));
// to store the data from script into the excell sheet//
                                                     
                                                     Row row3 = sheet.createRow(3);
                                                               Cell cell1 = row3.createCell(1);
                                                     cell1.setCellValue("080643");
                                                     FileOutputStream fos = new FileOutputStream("./src/test/resources/practice.xlsx");
                                                     workbook.write(fos);
                                                     workbook.close(); 

}
}
