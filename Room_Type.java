package SqlText;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
import java.util.Scanner;

public class Room_Type {
	public static void createTableRoomTyped(){
			
			String url = "jdbc:mysql://localhost:3306/HotelDBMS";
			String user = "root";
			String pass = "root";
			
	        String sqlDB = "CREATE TABLE room_type " +
            "(id INTEGER not NULL, " +
            " room_type_name   VARCHAR(100) not NULL, " +
            " created_date Date , " +
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
			String room_type_name="Amna";
			String created_date="2023-01-01";
			String updated_date = "2022-12-6";
			boolean is_Active=true ;
			
		    Random rn = new Random();
			Integer numberToAdd = rn.nextInt(100);
			
			
			for(int i=1;i<=1;i++) {
				   String sql = "INSERT INTO Room_Typed VALUES ("+ i+numberToAdd +",'"+ (room_type_name+i)+"','"+created_date+
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
//	        String sqlDB = "CREATE TABLE room_type " +
//	                   "(id INTEGER not NULL, " +
//	                   " room_type_name   VARCHAR(100) not NULL, " +
//	                   " created_date Date , " +
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
	

