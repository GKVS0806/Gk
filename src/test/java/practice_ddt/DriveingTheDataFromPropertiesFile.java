package practice_ddt;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class DriveingTheDataFromPropertiesFile 
{
public static void main(String[] args) throws IOException 
{
FileInputStream fis=new FileInputStream("./src/test/resources/practice.properties");	
Properties property = new Properties();
property.load(fis);
System.out.println(property.getProperty("username"));
System.out.println(property.getProperty("password"));
System.out.println(property.getProperty("url"));

property.put("username","girish");
property.put("password", "0806");

FileOutputStream fos = new FileOutputStream("./src/test/resources/practice.properties");

property.store(fos, "modified username and password");




}
}
