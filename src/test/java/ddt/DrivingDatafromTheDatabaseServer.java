package ddt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;
import com.mysql.cj.xdevapi.Result;

public class DrivingDatafromTheDatabaseServer 
{
public static void main(String[] args) throws SQLException 
{
Driver dbDriver=new Driver();
DriverManager.registerDriver(dbDriver);
Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/advanceselenium","root","root");
                       Statement statement = connection.createStatement();
                                             ResultSet result = statement.executeQuery("Select * from personaldetails");
                                             while(result.next())
                                             {
                                            	 System.out.println(result.getInt(1));
                                             }

}
}
