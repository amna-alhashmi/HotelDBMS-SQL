package SqlText;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Employee_Type {
	public static void createTableEmployee_Type(){
		Connection con = null;
	    String url = "jdbc:mysql://localhost:3306/HotelDBMS";
	    //String dbName = "HotelDBMS;";
	    String driverName = "com.mysql.cj.jdbc.Driver";
	    String userName = "root";
	    String password = "root";
	    try{
	      Class.forName(driverName).newInstance();
	      con = DriverManager.getConnection(url, userName, password);
	      try{
	        Statement st = con.createStatement();
	        String sqlDB = "CREATE TABLE Employee_Type " + "(id INTEGER not NULL, " + " employee_type_name VARCHAR(20)not NULL, "
				 + " created_date DATE not NULL, "+"updated_date DATE, "+"is_Active BOOLEAN not NULL," + " PRIMARY KEY ( id ))";
	                                       
	                        
	       
	        st.executeUpdate(sqlDB);
	        System.out.println("Table creation process successfully!");
	        
	      }
	      catch(SQLException s){
	        System.out.println("Table all ready exists 1!");
	      }
	      con.close();
	    }
	    catch (Exception e){
	      e.printStackTrace();
	    }
}
}
