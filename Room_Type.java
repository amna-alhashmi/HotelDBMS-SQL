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
						String room_type_name = resultSet.getString("room_type_name");
						Date created_date = resultSet.getDate("created_date");
						Date updated_date = resultSet.getDate("updated_date");
						Boolean is_Active = resultSet.getBoolean("is_Active");
						System.out.println(id+" "+room_type_name+" "+created_date+" "+updated_date+" "+is_Active);
						count++;
						 }
				
					conn.close();
				}
				catch (Exception ex) {
					System.err.println(ex);
				}
	
	}
	public static void getById() {
		String url = "jdbc:mysql://localhost:3306/HotelDBMS";
		String username = "root";
		String password = "root";
		Scanner scanner = new Scanner(System.in);
		Connection con = null;

		try {

			Driver driver = (Driver) Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			DriverManager.registerDriver(driver);
			con = DriverManager.getConnection(url, username,password);
			Statement st = con.createStatement();
			
			Scanner sa = new Scanner(System.in);
			System.out.println("Pls Enter the id:");
			int userin = sa.nextInt();
			String sql = "SELECT * FROM Hotels WHERE id='" + userin + "'";
			ResultSet result = st.executeQuery(sql);

			while (result.next()) {

				int id1 = result.getInt("id");
				String room_type_name = result.getString("room_type_name");
				Date created = result.getDate("created_date");
				Date update = result.getDate("updated_date");
				boolean Active = result.getBoolean("is_Active");
				System.out.println(id1 + " " + room_type_name + " " + created + " " + update + " " + Active);

			}
		}

		catch (Exception ex) {

			System.err.println(ex);

		}

	}
	
	public static void updateById() {

		String url = "jdbc:mysql://localhost:3306/HotelDBMS";
		String username = "root";
		String password = "root";
		Connection con = null;

		try {

			Driver driver = (Driver) Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			DriverManager.registerDriver(driver);
			con = DriverManager.getConnection(url, username,password);
			Statement st = con.createStatement();
			
			Scanner sa = new Scanner(System.in);
			System.out.println("PLS Enter any id to Update :");
			int user_input = sa.nextInt();
			System.out.println("Please Enter the new room_type_name:");
			String hotel_name = sa.next();
			
			String sql = "UPDATE Hotels SET hotel_name='" + hotel_name + "',hotel_location='"
					+ "' WHERE id='" + user_input + "'";

			int result = st.executeUpdate(sql);

		}

		catch (Exception ex) {

			System.err.println(ex);

		}

	}
	public static void deleteById() {
		
		String url = "jdbc:mysql://localhost:3306/HotelDBMS";
		String username = "root";
		String password = "root";
		Connection con = null;
		try {

			Driver driver = (Driver) Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			DriverManager.registerDriver(driver);
			con = DriverManager.getConnection(url, username,password);
			Statement st = con.createStatement();
			
			Scanner sa = new Scanner(System.in);
			System.out.println("Please Enter the id you want to delet it:");
			String enter = sa.next();
			String sql = "delete from users where id ='"+ enter+"'";
			int result = st.executeUpdate(sql);

		}

		catch (Exception ex) {

			System.err.println(ex);

		}
		
		
	}
	
	public static void makeIsActiveFalseById() {
		String url = "jdbc:mysql://localhost:3306/HotelDBMS";
		String username = "root";
		String password = "root";
		Connection con = null;
		
		try {

			Driver driver = (Driver) Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			DriverManager.registerDriver(driver);
			con = DriverManager.getConnection(url, username,password);
			Statement st = con.createStatement();
		
			
			String sql = "UPDATE Hotels SET is_Active=false LIMIT 10 ;";

			int result = st.executeUpdate(sql);

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
	

