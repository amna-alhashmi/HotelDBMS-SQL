package SqlText;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

public class Rooms {
	public static void createTableRoom(){
		String url = "jdbc:mysql://localhost:3306/HotelDBMS";
		String user = "root";
		String pass = "root";
		
        String sqlDB = "CREATE TABLE Rooms " +
        "(id INTEGER not NULL, " +
        "room_type_id INTEGER  ,"+
     "FOREIGN KEY (room_type_id) REFERENCES room_type(id) ON DELETE CASCADE ,"+
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
	
	public static void readFromTable(){
		String url = "jdbc:mysql://localhost:3306/HotelDBMS";
		String username = "root";
		String password = "root";
		
			Scanner sa=new Scanner(System.in);
			System.out.println("Enter how many users you have to print:");
			int user=sa.nextInt();
			
			
		   
			String sql = "SELECT * FROM hotels";
			//Connection, Driver, DriverRegister lines will be exactly same
			
			
		
			 java.sql.Connection conn = null;
			 try {
					Driver driver = (Driver) Class.forName("com.mysql.jdbc.Driver").newInstance();
					DriverManager.registerDriver(driver);
					conn = DriverManager.getConnection(url, username, password);
					java.sql.Statement st = conn.createStatement();
					ResultSet resultSet = st.executeQuery(sql);
					int count=0;
					while(resultSet.next()&& count<user){
						Integer id = resultSet.getInt("id");
						Integer room_type_id = resultSet.getInt("room_type_id");
						Integer hotel_id = resultSet.getInt("hotel_id");
						Date created_date = resultSet.getDate("created_date");
						Date updated_date = resultSet.getDate("updated_date");
						Boolean is_Active = resultSet.getBoolean("is_Active");
						System.out.println(id+" "+room_type_id+" "+hotel_id+" "+created_date+" "+updated_date+" "+is_Active);
						count++;
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
			String room_type_id="Amna";
			String hotel_id="11s";
			String created_date="2023-01-01";
			String updated_date = "2022-12-6";
			boolean is_Active=true ;
			
		    Random rn = new Random();
			Integer numberToAdd = rn.nextInt(100);
			
			
			for(int i=1;i<=1;i++) {
				   String sql = "INSERT INTO Rooms VALUES ("+ i+numberToAdd +",'"+ (room_type_id+i)+"','"+hotel_id+"','"+created_date+
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
//	        String sqlDB = "CREATE TABLE Rooms " +
//	                   "(id INTEGER not NULL, " +
//	                   "room_type_id INTEGER  ,"+
//                    "FOREIGN KEY (room_type_id) REFERENCES room_type(id) ON DELETE CASCADE ,"+
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

