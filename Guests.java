package SqlText;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
import java.util.Scanner;

public class Guests {
	

	public void createTableGuest() {
		String url = "jdbc:mysql://localhost:3306/HotelDBMS";
		String user = "root";
		String pass = "root";
		
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
        
		Connection conn = null;
		try {
			Driver driver = (Driver) Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			DriverManager.registerDriver(driver);
			conn = DriverManager.getConnection(url, user, pass);
			Statement st = conn.createStatement();
			int m = st.executeUpdate(sqlDB);
			if (m >= 1) {
				System.out.println("Created table in given database...");
				
			} else {
				System.out.println(" table already Created in given database...");
			}
			conn.close();
		}
		catch (Exception ex) {
			System.err.println(ex);
		}
		
	}
	public static void insertIntoTable1() {
	try {
	    String url = "jdbc:mysql://localhost:3306/HotelDBMS";
	    String user = "root";
	    String pass = "root";
	    
	    Scanner sa = new Scanner (System.in);
		System.out.println("enter how many number of rows you want to be inserted?");
		int number3=sa.nextInt();
		
		
	    //Integer id=1;
		String guest_name="Amna";
		String guest_phone="98765211";
		Integer guest_accompanying_members=1223;
		Integer guest_payment_amount=123;
		Integer room_id=11;
		Integer hotel_id=12;
		String created_date="2023-01-01";
		String updated_date = "2022-12-6";
		boolean is_Active=true ;
		
	    Random rn = new Random();
		Integer numberToAdd = rn.nextInt(100);
		
		
		for(int i=1;i<=1;i++) {
			   String sql = "INSERT INTO Rooms VALUES ("+ i+numberToAdd +",'"+ (guest_name+i)+"','"+guest_phone+
					   "','"+guest_accompanying_members+"','"+guest_payment_amount+"','"+
					   room_id+"','"+hotel_id+"','"+created_date+
					   "','"+updated_date+"',"+ is_Active+")";
			   
				Connection conn = null;
				
					Driver driver = (Driver) Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
					DriverManager.registerDriver(driver);
					conn = DriverManager.getConnection(url, user, pass);
					Statement st = conn.createStatement();
					int m = st.executeUpdate(sql);
					if (m >= 1) {
						System.out.println("Created table in given database...");
						
					} else {
						System.out.println(" table already Created in given database...");
					}
					conn.close();
		}
				} catch (Exception ex) {
					System.err.println(ex);
				}
	
}
}		
		
		
		
		
		
		
		
		
//		Connection con = null;
//	    String url = "jdbc:mysql://localhost:3306/HotelDBMS";
//	    //String dbName = "HotelDBMS;";
//	    String driverName = "com.mysql.cj.jdbc.Driver";
//	    String userName = "root";
//	    String password = "root";
//	    try{
//	      Class.forName(driverName).newInstance();
//	      con = DriverManager.getConnection(url, userName, password);
//	      try{
//	        Statement st = con.createStatement();
//	        String sqlDB = "CREATE TABLE Guests " +
//	                   "(id INTEGER not NULL, " +
//	                   " guest_name   VARCHAR(100) not NULL, " +
//	                   " guest_phone  VARCHAR(100) not NULL, " +
//	                   " guest_accompanying_members   INTEGER not NULL, " +
//	                   " guest_payment_amount INTEGER not NULL, " +
//	                   "room_id INTEGER  ,"+
//                    "FOREIGN KEY (room_id) REFERENCES Rooms(id) ON DELETE CASCADE ,"+
//                    "hotel_id INTEGER  ,"+
//                    "FOREIGN KEY (hotel_id) REFERENCES Hotels(id) ON DELETE CASCADE ,"+
//	                   " created_date Date not NULL, " +
//	                   " updated_date Date , " +
//	                   " is_Active  Boolean  not NULL, " +
//	                   " PRIMARY KEY ( id ))";
//	        
//	                                   
//	        st.executeUpdate(sqlDB);
//	        System.out.println("Table creation process successfully!");
//	        
//	      }
//	      catch(SQLException s){
//	        System.out.println("Table all ready exists 1!");
//	      }
//	      con.close();
//	    }
//	    catch (Exception e){
//	      e.printStackTrace();
//	    }		

