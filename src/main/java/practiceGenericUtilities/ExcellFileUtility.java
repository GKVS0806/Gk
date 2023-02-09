package practiceGenericUtilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * this class contains reusable methods related to the actions performed on the excel file
 * @author Girish
 *
 */
public class ExcellFileUtility
{
	private Workbook workbook;
public void excellFileInitialization(String path)
{
FileInputStream fis= null;

try {
	fis = new FileInputStream(path);
} catch (FileNotFoundException e) {
	
	e.printStackTrace();
}
        try {
			workbook=WorkbookFactory.create(fis);
		} catch (EncryptedDocumentException | IOException e) {
			e.printStackTrace();
		}
}
/**
 * this method is used to fetch data from the excell
 * @param Sheetname 
 * @param Rownum 
 * @param Cellnum 
 * @return 
 * 
 */
public String fetchDataFromExcell(String Sheetname, int Rownum, int Cellnum)
{
	DataFormatter df = new DataFormatter();
	return df.formatCellValue( workbook.getSheet(Sheetname).getRow(Rownum).getCell(Cellnum));
}
/**
 * this method is used to fetch multiple data from excell
 * @param Sheetname
 * @param ExceptedTestname
 * @return
 */
public Map<String, String> fetchMultipleDataFromExcell(String Sheetname, String ExceptedTestname)
{
DataFormatter df = new DataFormatter();
Sheet sheet = workbook.getSheet(Sheetname);
Map <String,String>map=new HashMap<>();
for(int i=0;i<sheet.getLastRowNum();i++)
{
	if(df.formatCellValue(sheet.getRow(i).getCell(1)).equals(ExceptedTestname))
	{
		for(int j=i;i<sheet.getLastRowNum();i++)
		{
		 String key=df.formatCellValue(sheet.getRow(j).getCell(2));
		 String value =df.formatCellValue(sheet.getRow(j).getCell(3));
			map.put(key, value);
			if(df.formatCellValue(sheet.getRow(j).getCell(2)).equals("####"))
			{
				break;
			}
		}
	}
	break;
}
return map;
}
/**
 * this method is used to modify the data in the excel file
 * @param Sheetname
 * @param Rownum
 * @param Cellnum
 * @param data
 * @param path
 */
public void modifyDataInExcell(String Sheetname, int Rownum, int Cellnum, Date data, String path)
{
     Sheet sheet = workbook.getSheet(Sheetname);
                 Row row = sheet.getRow(Rownum);
                Cell cell = row.getCell(Cellnum);
                cell.setCellValue(data);
                FileOutputStream fos=null;
                try {
					fos = new FileOutputStream(path);
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
                try {
					workbook.write(fos);
				} catch (IOException e) {
					e.printStackTrace();
				}
}
/**
 * this method is used to update the status in the excel sheet
 * @param status
 * @param path
 * @param expectedTestname 
 * @param sheetname 
 */
public void updateStatus( String status, String path, String expectedTestname, String sheetname)
{
	DataFormatter df = new DataFormatter();
	Sheet sheet = workbook.getSheet(sheetname);
	              for(int i=0;i<sheet.getLastRowNum();i++)
	              {
	            	  if(df.formatCellValue(sheet.getRow(i).getCell(1)).contains(expectedTestname))
	            	  {
	            		 sheet.getRow(i).getCell(4).setCellValue(status); 
	            	  }
	              }
FileOutputStream fos = null;	
try {
	fos = new FileOutputStream(path);
} catch (FileNotFoundException e) {
	e.printStackTrace();
}
try {
	workbook.write(fos);
} catch (IOException e) {
	e.printStackTrace();
}
try {
	fos.flush();
} catch (IOException e) {
	e.printStackTrace();
}
}

/**
 * this method is used to close the workbook
 */
public void closeWorkbook()
{
try {
	workbook.close();
} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}	
}

}
