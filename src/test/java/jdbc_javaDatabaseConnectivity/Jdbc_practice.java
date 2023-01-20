package jdbc_javaDatabaseConnectivity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class Jdbc_practice 
{
public static void main(String[] args) throws SQLException 
{
	// 1) we need to create the instance (object) for the driver
Driver dbDriver= new Driver();	
//2)Register for DriverManager
DriverManager.registerDriver(dbDriver);
//3)establish database connection(by using url,username,password)
Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/advanceselenium","root","root");
//4)create the statement
                        Statement statement = connection.createStatement();
//5)execute the query to fetch the data                         
                        ResultSet result = statement.executeQuery("select * from personaldetails");
                        while(result.next())
                        
                        {
                        	System.out.println(result.getInt(1)+"\t"+result.getString(2)+"\t\t"+result.getString(3));
                        }

}
}
