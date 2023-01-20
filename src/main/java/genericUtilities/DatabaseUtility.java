package genericUtilities;

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
 * this class contains reusable methods to perform operations on database
 * @author Girish
 *
 */
public class DatabaseUtility
{
private	Connection connection;
/**
 * this method is used to initialise and establish data connection
 * @param url
 * @param user
 * @param password
 */
public void databaseinitialisation(String url, String user, String password)
{
Driver dbDriver = null;
try {
	dbDriver = new Driver();
    }
catch (SQLException e) 
    {
	e.getStackTrace();
	}
try {
	DriverManager.registerDriver(dbDriver);
} catch (SQLException e) {
	e.printStackTrace();
}
 try {
	connection = DriverManager.getConnection(url, user, password);
} catch (SQLException e) {
	
	e.printStackTrace();
}
}

/**
 * this method is used to fetch data from database
 * @param columnName
 * @param query
 * @return
 * @throws SQLException
 */
public List<String> readDataFromDatabase( String columnName, String query) throws SQLException 
{
Statement statement =null;
try {
	statement=connection.createStatement();
} catch (SQLException e) {
	e.printStackTrace();
}
ResultSet result=null;
           try {
		result=	statement.executeQuery(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
 List<String> columndata = new ArrayList<>();
   while(result.next())
   {
	   columndata.add(result.getString(columnName));
   }
   return columndata;

}


/**
 * this method is used to modify database
 * @param query
 * @return
 */
public int modifyDataBase(String query)
{
	Statement statement =null;
 
try {
	statement = connection.createStatement();
} catch (SQLException e) {

	e.printStackTrace();
}

int result=0;

try {
	result=statement.executeUpdate(query);
} catch (SQLException e) {
	e.printStackTrace();
}

return result;
}
/**
 * this method closes database connection
 */
public void closeDatabase()
{
try {
	connection.close();
} catch (SQLException e) {
	e.printStackTrace();
}

}


}
