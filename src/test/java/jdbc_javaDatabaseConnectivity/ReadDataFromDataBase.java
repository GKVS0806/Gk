package jdbc_javaDatabaseConnectivity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class ReadDataFromDataBase 
{
	public static void main(String[] args) throws SQLException 
	{
		//step 1:create an instance for driver
		//Driver should be imported from com.mysql.cj.jdbc.Driver
		//new driver throws SQL exception
		Driver dbDriver=new Driver();

		//Step 2: Register to the driver
		//DriverManager is in java.sql package
		DriverManager.deregisterDriver(dbDriver);

		//step 3:Establish database connection
		//connection should be imported from java.sql package
		Connection connect=DriverManager.getConnection("jdbc:mysql://localhost:3306/advanceselenium","root","root");

		//step4:create statement
		//statement should be imported from java.sql package
		Statement statement = connect.createStatement();

		//step 5:Execute query to fetch data 
		ResultSet result=statement.executeQuery("select * from personaldetails;");

		while(result.next())
		{
			System.out.println(result.getInt(1)+"\t"+result.getString(2)+"\t"+result.getString(3));
		}
		
		//modifing databases
		
		        int  result1=statement.executeUpdate("insert into personaldetails(id,name,adress) values(114,'gkvsgk','USA');");
		        
		        
		        if(result1==1)
		        {
		        	System.out.println("Data base updated successfully");
		        }
		        else
		        {
		        	System.out.println("Data base not updated");
		        }
		        
		        
		        
		    

		//step 6:close database
		connect.close();



	}

}
