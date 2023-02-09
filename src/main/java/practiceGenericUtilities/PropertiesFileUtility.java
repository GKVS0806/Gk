package practiceGenericUtilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * this class contains all the reusable methods related to the actions performed on properties file
 * @author Girish
 *
 */
public class PropertiesFileUtility 
{
	 private Properties property;
public void proprtyFileInitialization(String path)
{
FileInputStream fis=null;
try {
	fis = new FileInputStream(path);
} catch (FileNotFoundException e) {
	e.printStackTrace();
}
property = new Properties();
try {
	property.load(fis);
} catch (IOException e) {
	e.printStackTrace();
}
}
/**
 * this method is used to fetch the data from the properties file 
 * @param key
 * @return
 */
public String fetchProperty(String key)
{
 return property.getProperty(key);	
}
/**
 * this method is used to update/modify the data in the  properties file 
 * @param key
 * @param value
 * @param path
 * @param message
 */
public void modifyPropertiesFile(String key, String value, String path, String message)
{
	property.put(key,value);
	FileOutputStream fos=null;
	try {
		fos = new FileOutputStream(path);
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	}
	try {
		property.store(fos, message);
	} catch (IOException e) {
		e.printStackTrace();
	}
}
}

