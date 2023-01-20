package practiceGenericUtilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * This class contains reuseable methods Related to the actions performed on properties file
 * @author Girish
 *
 */
public class PropertiesFileUtilities 
{
	private Properties property;
	/**
	 * this method is used to initialise the properties file
	 * @param path
	 */
	public void propertfileInitialisation(String path)
	{
		FileInputStream fis=null;
		try {
			fis=new FileInputStream(path);
		} catch (FileNotFoundException e)
		{
         e.getStackTrace();
		}
		property=new Properties();
		
		try {
			property.load(fis);
		} catch (IOException e)
		{
			e.getStackTrace();
		}
		
		
		
	}
	/**
	 * this method is used to fetch the data from properties file
	 * @param key
	 * @return
	 */
	public String toFetchtheDatafromPropertiesFile(String key)
	{
		 return  property.getProperty(key);
	}
	/**
	 * this method is used to update the data in the properties file 
	 * @param key
	 * @param value
	 * @param path
	 * @param message
	 */
	public void toUpdataTheDatainthePropertiesFile(String key,String value,String path,String message)
	{
		FileOutputStream fos=null;
		try {
			
			fos = new FileOutputStream(path);
		} catch ( FileNotFoundException e) {
			e.getStackTrace();
		}
		property.put(key, value);
		try {
			property.store(fos, message);
		} catch (IOException e) {
			e.getStackTrace();
		}
		}
	
	
}

