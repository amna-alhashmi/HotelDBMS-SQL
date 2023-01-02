package SqlText;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Room_Type {
	public static void createTableRoomTyped(){
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
	        String sqlDB = "CREATE TABLE room_type " +
	                   "(id INTEGER not NULL, " +
	                   " room_type_name   VARCHAR(100) not NULL, " +
	                   " created_date Date , " +
	                   " updated_date Date , " +
	                   " is_Active  Boolean  not NULL, " +
	                   " PRIMARY KEY ( id ))";
	        
	       
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
