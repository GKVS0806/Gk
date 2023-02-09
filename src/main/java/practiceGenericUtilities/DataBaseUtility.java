package practiceGenericUtilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.jdbc.Driver;
import com.mysql.cj.xdevapi.Result;


/**
 * this class contains all the reusable methods related to the actions performed on the database 
 * @author Girish
 *
 */
public class DataBaseUtility
{
	private Connection connection;
	/**
	 * this method is used to initialize and establish the database connection
	 * @param url
	 * @param username
	 * @param password
	 */
public void initializeDataBaseConnection(String url, String username, String password)
{
Driver dbdriver=null;
try {
	dbdriver= new Driver();
} catch (SQLException e) {
	e.printStackTrace();
}
try {
	DriverManager.registerDriver(dbdriver);
} catch (SQLException e) {
	e.printStackTrace();
}
connection=null;
try {
	connection=DriverManager.getConnection(url,username,password);
} catch (SQLException e) {
	
	e.printStackTrace();
}

}
	
/**
 * this method is used to fetch the data from the data base 	
 * @param query
 * @param columnName
 * @return
 * @throws SQLException
 */
public List<String> toFetchDataFromDataBase(String query, String columnName) throws SQLException
{
	Statement statement= null;
             try {
				statement=connection.createStatement();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}	
               ResultSet result=null;
                 try {
					result=  statement.executeQuery(query);
				} catch (SQLException e) {
					e.printStackTrace();
				}
                 
                 List<String> columndata=new ArrayList<>();
                 while(result.next())
                 {
                	columndata.add(result.getString(columnName));
                 }
            return columndata;
}	
/**
 * this method is used to modify the data base
 * @param query
 * @return
 */
	public int modifyDataBase(String query)
	{
		Statement statement=null;
		try {
			statement=connection.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		int result=0;
		try {
			statement.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	/**
	 * this method is used to close the data base connection
	 */
	public void closeDataBase()
	{
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	
	
	
	
}
