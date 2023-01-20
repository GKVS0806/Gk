package practiceGenericUtilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Thic class conatins the comman methods related to the actions performed on the properties file 
 * @author Girish
 *
 */
public class PpUt
{
	private Properties property;
	/**
	 * this method is used to initialise the property file
	 * @param path
	 */
public void propertiesFileInitialization(String path)
{
	FileInputStream Fis=null;
	try {
		Fis = new FileInputStream(path);
	} catch ( FileNotFoundException e)
	{
		e.getStackTrace();
	}
	property=new Properties();
	try {
		property.load(Fis);
	} catch (IOException e) {
		e.getStackTrace();
	}
}  
/**
 * this used to fetch the data from the properties file
 * @param key
 * @return
 */

public String toFetchThedatafromPropertiesFile(String key)
{
       return  property.getProperty(key);	
}
/**
 * this method is used to update the data into the properties file
 * @param key
 * @param value
 * @param path
 * @param message
 */
public void toUpdateTheDataInThepropertiesFile(String key,String value,String path,String message)
{
	property.put(key, value);
	FileOutputStream fos=null;
	try {
		fos = new FileOutputStream(path);
	} catch (FileNotFoundException e) {
e.getStackTrace();
	}
	try {
		property.store(fos, message);
	} catch (IOException e)
	{
		e.getStackTrace();
	}
}
}
