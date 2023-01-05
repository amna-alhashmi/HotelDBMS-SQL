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
	public static void createTableRoom() {
		String url = "jdbc:mysql://localhost:3306/HotelDBMS";
		String user = "root";
		String pass = "root";

		String sqlDB = "CREATE TABLE Rooms " + "(id INTEGER not NULL, " + "room_type_id INTEGER  ,"
				+ "FOREIGN KEY (room_type_id) REFERENCES room_type(id) ON DELETE CASCADE ," + "hotel_id INTEGER  ,"
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

		String sql = "SELECT * FROM hotels";
		

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
				Integer room_type_id = resultSet.getInt("room_type_id");
				Integer hotel_id = resultSet.getInt("hotel_id");
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
			con = DriverManager.getConnection(url, username,password);
			Statement st = con.createStatement();
			
			Scanner sa = new Scanner(System.in);
			System.out.println("Pls Enter the id:");
			int userin = sa.nextInt();
			String sql = "SELECT * FROM Hotels WHERE id='" + userin + "'";
			ResultSet result = st.executeQuery(sql);

			while (result.next()) {

				int id1 = result.getInt("id");
				String name = result.getString("hotel_name");
				String location = result.getString("hotel_location");
				Date created = result.getDate("created_date");
				Date update = result.getDate("updated_date");
				boolean Active = result.getBoolean("is_Active");
				System.out.println(id1 + " " + name + " " + location + " " + created + " " + update + " " + Active);

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
			System.out.println("PLS Enter any id to Update hotel data :");
			int user_input = sa.nextInt();
			System.out.println("Please Enter the new Hotel name:");
			String hotel_name = sa.next();
			System.out.println("Please Enter the new Hotel location:");
			String hotel_locatin = sa.next();
			String sql = "UPDATE Hotels SET hotel_name='" + hotel_name + "',hotel_location='" + hotel_locatin
					+ "' WHERE id='" + user_input + "'";

			ResultSet result = st.executeQuery(sql);

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

			Driver driver = (Driver) Class.forName("com.mysql.jdbc.Driver").newInstance();
			DriverManager.registerDriver(driver);
			con = DriverManager.getConnection(url, username,password);
			Statement st = con.createStatement();
		
			Scanner sa = new Scanner(System.in);
			System.out.println("PLS Enter any id to Update hotel data :");
			int user_input = sa.nextInt();
			System.out.println("Please Enter the new Hotel name:");
			String hotel_name = sa.next();
			System.out.println("Please Enter the new Hotel location:");
			String hotel_location = sa.next();
			String sql = "UPDATE Hotels SET hotel_name='" + hotel_name + "',hotel_location='" + hotel_location
					+ "' WHERE id='" + user_input + "'";

			ResultSet result = st.executeQuery(sql);

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
			String room_type_id = "Amna";
			String hotel_id = "11s";
			String created_date = "2023-01-01";
			String updated_date = "2022-12-6";
			boolean is_Active = true;

			Random rn = new Random();
			Integer numberToAdd = rn.nextInt(100);

			for (int i = 1; i <= 1; i++) {
				String sql = "INSERT INTO Rooms VALUES (" + i + numberToAdd + ",'" + (room_type_id + i) + "','"
						+ hotel_id + "','" + created_date + "','" + updated_date + "'," + is_Active + ")";

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


