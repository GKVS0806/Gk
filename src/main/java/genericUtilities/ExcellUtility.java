package genericUtilities;

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
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
/**
 *this class contains all the reusable methods to perform operations on the excell
 */
public class ExcellUtility
{
	private	Workbook workbook;
	private DataFormatter df;
	private Sheet sheet;
	/**
	 * this method initialises excell workbook
	 * @param path
	 */
	public void excellInitialisation(String path)
	{
		FileInputStream fis=null;
		try 
		{
			fis = new FileInputStream(path);
		} catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
		try
		{
			workbook = WorkbookFactory.create(fis);
		} catch (EncryptedDocumentException | IOException e1)
		{
			e1.printStackTrace();
		}
	}
	/**
	 * this method is used to fetch single data fom excell
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum
	 * @return
	 */
	public String readDataFromExcell(String sheetName, int rowNum, int cellNum)
	{
		df = new DataFormatter();
		sheet = workbook.getSheet(sheetName);
		return   df.formatCellValue(sheet.getRow(rowNum).getCell(cellNum));

	}

	/**
	 * this methos is used to fetch multiple data in key-value pair from excell
	 * @param exceptedTestName
	 * @param sheetName 
	 * @return
	 */
	public Map<String, String> readDataFromExcell(String exceptedTestName, String sheetName)
	{
		Map<String,String> map= new HashMap();
		sheet = workbook.getSheet(sheetName);
		for(int i=0;i<sheet.getLastRowNum();i++)
		{
			if(df.formatCellValue(sheet.getRow(i).getCell(2)).contains(exceptedTestName))
			{
				for(int j=i;j<sheet.getLastRowNum();j++)
				{
					String key=df.formatCellValue(sheet.getRow(j).getCell(2));
					String value=df.formatCellValue(sheet.getRow(j).getCell(3));
					map.put(key, value);
					if(df.formatCellValue(sheet.getRow(i).getCell(2)).equals("####"))
					{
						break;
					}
				}
				break;
			}			
		
		}
		return map;	
	}
	
	/**
	 * this method is used to write data into the excell
	 * @param cellnum
	 * @param rownum
	 * @param data
	 * @param path
	 * @param sheetName 
	 */
	public void setDataToExcell(int cellnum, int rownum, String data, String path, String sheetName)
	{
		sheet = workbook.getSheet(sheetName);
		Cell cell = sheet.getRow(rownum).createCell(cellnum);
		cell.setCellValue(data);

		FileOutputStream fos=null;
		try
		{
			fos=new FileOutputStream(path);
		} catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}

		try 
		{
			workbook.write(fos);
		} catch (IOException e)
		{
			e.printStackTrace();
		}
		try
		{
			fos.flush();
		} catch (IOException e)
		{
			e.printStackTrace();
		}

	}
	/**
	 * this method is used to update test status into excell workbook
	 * @param expectedTestname
	 * @param status
	 * @param path
	 * @param sheetName 
	 */
	
	public void setDataToExcell(String expectedTestname, String status, String path, String sheetName)
	{
		sheet = workbook.getSheet(sheetName);
		for(int i=0;i<sheet.getLastRowNum();i++)
		{
			if(df.formatCellValue(sheet.getRow(i).getCell(1)).contains(expectedTestname))
			{
				sheet.getRow(i).getCell(4).setCellValue(status);
			}			
		}
		FileOutputStream fos=null;
		try 
		{
			fos=new FileOutputStream(path);
		} catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
		try 
		{
			workbook.write(fos);
		} catch (IOException e) 
		{
		
			e.printStackTrace();
		}
		try 
		{
			fos.flush();
		} 
		catch (IOException e)
		{
			
			e.printStackTrace();
		}
		
	}	
	/**
	 * this method is used to close the excell workbook
	 */
	public void closeWorkBook()
	{
		try 
		{
			workbook.close();
		} catch (IOException e) 
		{
			e.printStackTrace();
		}	

	}










}
