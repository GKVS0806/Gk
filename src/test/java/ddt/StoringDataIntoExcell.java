package ddt;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class StoringDataIntoExcell 
{
public static void main(String[] args) throws EncryptedDocumentException, IOException 
{
FileInputStream fis = new FileInputStream("./src/test/resources/StorinngDataintoExcell.xlsx");	
                      Workbook workbook = WorkbookFactory.create(fis);
                      
                 
}
}
