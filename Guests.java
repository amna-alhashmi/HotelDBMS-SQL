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

public class Guests {

	public void createTableGuest() {
		String url = "jdbc:mysql://localhost:3306/HotelDBMS";
		String user = "root";
		String pass = "root";

		String sqlDB = "CREATE TABLE Guests " + "(id INTEGER not NULL, " + " guest_name   VARCHAR(100) not NULL, "
				+ " guest_phone  VARCHAR(100) not NULL, " + " guest_accompanying_members   INTEGER not NULL, "
				+ " guest_payment_amount INTEGER not NULL, " + "room_id INTEGER  ,"
				+ "FOREIGN KEY (room_id) REFERENCES Rooms(id) ON DELETE CASCADE ," + "hotel_id INTEGER  ,"
				+ "FOREIGN KEY (hotel_id) REFERENCES Hotels(id) ON DELETE CASCADE ," + " created_date Date not NULL, "
				+ " updated_date Date , " + " is_Active  Boolean  not NULL, " + " PRIMARY KEY ( id ))";

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
		} catch (Exception ex) {
			System.err.println(ex);
		}

	}

	public static void readFromTable() {
		String url = "jdbc:mysql://localhost:3306/HotelDBMS";
		String username = "root";
		String password = "root";

		Scanner sa = new Scanner(System.in);
		System.out.println("Enter how many users you have to print:");
		int user = sa.nextInt();

		String sql = "SELECT * FROM Guests";

		java.sql.Connection conn = null;
		try {
			Driver driver = (Driver) Class.forName("com.mysql.jdbc.Driver").newInstance();
			DriverManager.registerDriver(driver);
			conn = DriverManager.getConnection(url, username, password);
			java.sql.Statement st = conn.createStatement();
			ResultSet resultSet = st.executeQuery(sql);
			int count = 0;
			while (resultSet.next() && count < user) {
				Integer id = resultSet.getInt("id");
				String room_type_id = resultSet.getString("guest_name");
				String hotel_id = resultSet.getString("guest_phone");
				Integer guest_accompanying_members = resultSet.getInt("guest_accompanying_members");
				Integer guest_payment_amount = resultSet.getInt("guest_payment_amount");
				Integer room_id = resultSet.getInt("room_id");
				Date created_date = resultSet.getDate("created_date");
				Date updated_date = resultSet.getDate("updated_date");
				Boolean is_Active = resultSet.getBoolean("is_Active");
				System.out.println(id + " " + room_type_id + " " + hotel_id + " " + created_date + " " + updated_date
						+ " " + is_Active);
				count++;
			}

			conn.close();
		} catch (Exception ex) {
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
			con = DriverManager.getConnection(url, username, password);
			Statement st = con.createStatement();

			Scanner sa = new Scanner(System.in);
			System.out.println("Pls Enter the id:");
			int userin = sa.nextInt();
			String sql = "SELECT * FROM guests WHERE id='" + userin + "'";
			ResultSet result = st.executeQuery(sql);

			while (result.next()) {

				int id1 = result.getInt("id");
				String room_type_id = result.getString("guest_name ");
				String hotel_id = result.getString("guest_phone");
				Integer guest_accompanying_members = result.getInt("guest_accompanying_members");
				Integer guest_payment_amoun = result.getInt("guest_payment_amoun");
				Integer room_id = result.getInt("room_id");
				Integer hotel_id1 = result.getInt("hotel_id");
				Date created = result.getDate("created_date");
				Date update = result.getDate("updated_date");
				boolean Active = result.getBoolean("is_Active");
				System.out.println(id1 + " " + room_type_id + " " + hotel_id1 + " " + guest_accompanying_members + " "
						+ guest_payment_amoun + " " + room_id + " " + hotel_id1 + " " + created + " " + update + " "
						+ Active);

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
			con = DriverManager.getConnection(url, username, password);
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
			String sql = "UPDATE guests SET guest_name='" + guest_name + "',guest_phone='" + guest_phone
					+ "',guest_accompanying_members='" + "',guest_payment_amoun='" + "',hotel_id='" + "' WHERE id='"
					+ user_input + "'";

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
			con = DriverManager.getConnection(url, username, password);
			Statement st = con.createStatement();

			Scanner sa = new Scanner(System.in);
			System.out.println("Please Enter the id you want to delet it:");
			String enter = sa.next();
			String sql = "delete from guests where id ='" + enter + "'";
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
			con = DriverManager.getConnection(url, username, password);
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

			Scanner sa = new Scanner(System.in);
			System.out.println("enter how many number of rows you want to be inserted?");
			int number3 = sa.nextInt();

			// Integer id=1;
			String guest_name = "Amna";
			String guest_phone = "98765211";
			Integer guest_accompanying_members = 1223;
			Integer guest_payment_amount = 123;
			Integer room_id = 11;
			Integer hotel_id = 12;
			String created_date = "2023-01-01";
			String updated_date = "2022-12-6";
			boolean is_Active = true;

			Random rn = new Random();
			Integer numberToAdd = rn.nextInt(100);

			for (int i = 1; i <= 1; i++) {
				String sql = "INSERT INTO guests VALUES (" + i + numberToAdd + ",'" + (guest_name + i) + "','"
						+ guest_phone + "','" + guest_accompanying_members + "','" + guest_payment_amount + "','"
						+ room_id + "','" + hotel_id + "','" + created_date + "','" + updated_date + "'," + is_Active
						+ ")";

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
