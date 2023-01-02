package SqlText;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Guests {
	

	public void createTableGuest() {
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
	        String sqlDB = "CREATE TABLE Guests " +
	                   "(id INTEGER not NULL, " +
	                   " guest_name   VARCHAR(100) not NULL, " +
	                   " guest_phone  VARCHAR(100) not NULL, " +
	                   " guest_accompanying_members   INTEGER not NULL, " +
	                   " guest_payment_amount INTEGER not NULL, " +
	                   "room_id INTEGER  ,"+
                    "FOREIGN KEY (room_id) REFERENCES Rooms(id) ON DELETE CASCADE ,"+
                    "hotel_id INTEGER  ,"+
                    "FOREIGN KEY (hotel_id) REFERENCES Hotels(id) ON DELETE CASCADE ,"+
	                   " created_date Date not NULL, " +
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