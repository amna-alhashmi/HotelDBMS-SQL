package SqlText;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Hotels {
	public static void createTableHotel(){
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
	        String sqlDB = "CREATE TABLE Hotels " + "(id INTEGER not NULL, " + " hotel_name VARCHAR(20)not NULL, "
				+ " hotel_location VARCHAR(20), " + " created_date DATE not NULL, "+"updated_date DATE, "+"is_Active BOOLEAN not NULL," + " PRIMARY KEY ( id ))";
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
	    
//		String url = "jdbc:mysql://localhost:3306/HotelDBMS";
//		String user = "root";
//		String pass = "root";
//		String sqlDB = "CREATE TABLE Hotels " + "(id INTEGER not NULL, " + " hotel_name VARCHAR(20)not NULL, "
//				+ " hotel_location VARCHAR(20), " + " created_date DATA not NULL, "+"updated_date DATA, "+"is_Active BOOLEAN not NULL," + " PRIMARY KEY ( id ))";
//		
//		Connection conn = null;
//		try {
//			Driver driver = (Driver) Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
//			DriverManager.registerDriver(driver);
//			conn = DriverManager.getConnection(url, user, pass);
//			Statement st = conn.createStatement();
//			int m = st.executeUpdate(sqlDB);
//			if (m >= 1) {
//				System.out.println("Created table in given database...");
//				
//			} else {
//				System.out.println(" table already Created in given database...");
//			}
//			conn.close();
//		}
//		catch (Exception ex) {
//			System.err.println(ex);
//		}
		
}
	
}
