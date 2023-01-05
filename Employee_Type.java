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

public class Employee_Type {
	public static void createTableEmployee_Type(){
		String url = "jdbc:mysql://localhost:3306/HotelDBMS";
		String user = "root";
		String pass = "root";
		
		 String sqlDB = "CREATE TABLE Employee_Type " + "(id INTEGER not NULL, " + 
		 " employee_type_name VARCHAR(20)not NULL, "
				 + " created_date DATE not NULL, "+"updated_date DATE, "+
		 "is_Active BOOLEAN not NULL," + " PRIMARY KEY ( id ))";
        
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
	
	public static void getById() {

		String url = "jdbc:mysql://localhost:3306/HotelDBMS";
		String username = "root";
		String password = "root";
		Scanner scanner = new Scanner(System.in);
		Connection con = null;

		try {

			Driver driver = (Driver) Class.forName("com.mysql.jdbc.Driver").newInstance();
			DriverManager.registerDriver(driver);
			con = DriverManager.getConnection(url, username,password);
			Statement st = con.createStatement();
			
			Scanner sa = new Scanner(System.in);
			System.out.println("Pls Enter the id:");
			int userin = sa.nextInt();
			String sql = "SELECT * FROM Employee_Type WHERE id='" + userin + "'";
			ResultSet result = st.executeQuery(sql);

			while (result.next()) {

				int id1 = result.getInt("id");
				String employee_type_name = result.getString("employee_type_name ");
				Date created = result.getDate("created_date");
				Date update = result.getDate("updated_date");
				boolean Active = result.getBoolean("is_Active");
				System.out.println(id1 + " " + employee_type_name +" " + created + " " + update + " " + Active);

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

			Driver driver = (Driver) Class.forName("com.mysql.jdbc.Driver").newInstance();
			DriverManager.registerDriver(driver);
			con = DriverManager.getConnection(url, username,password);
			Statement st = con.createStatement();
			
			Scanner sa = new Scanner(System.in);
			System.out.println("PLS Enter any id to Update  :");
			int user_input = sa.nextInt();
			System.out.println("Please Enter the new guest_name:");
			String guest_name = sa.next();
			System.out.println("Please Enter the new guest_phone:");
			String guest_phone = sa.next();
			System.out.println("Please Enter the new guest_accompanying_members:");
			String guest_accompanying_members = sa.next();
			System.out.println("Please Enter the new guest_payment_amoun:");
			String guest_payment_amoun = sa.next();
			System.out.println("Please Enter the new hotel_id:");
			String hotel_id = sa.next();
			String sql = "UPDATE guests SET guest_name='" + guest_name + "',guest_phone='" + guest_phone+"',guest_accompanying_members='"+"',guest_payment_amoun='"+"',hotel_id='"
					+ "' WHERE id='" + user_input + "'";

			ResultSet result = st.executeQuery(sql);

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
			String sql = "delete from guests where id ='"+ enter+"'";
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
		
			
			String sql = "UPDATE guests SET is_Active=false LIMIT 10 ;";

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
		String employee_type_name="Amna";
		String created_date="2023-01-01";
		String updated_date = "2022-12-6";
		boolean is_Active=true ;
		
	    Random rn = new Random();
		Integer numberToAdd = rn.nextInt(100);
		
		
		for(int i=1;i<=1;i++) {
			   String sql = "INSERT INTO Employee_Type VALUES ("+ i+numberToAdd +",'"+ (employee_type_name+i)+
					   "','"+created_date+"','"+updated_date+"',"+ is_Active+")";
			   
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
//	        String sqlDB = "CREATE TABLE Employee_Type " + "(id INTEGER not NULL, " + " employee_type_name VARCHAR(20)not NULL, "
//				 + " created_date DATE not NULL, "+"updated_date DATE, "+"is_Active BOOLEAN not NULL," + " PRIMARY KEY ( id ))";
//	                                       
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

