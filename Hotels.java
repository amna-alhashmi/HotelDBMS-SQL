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

public class Hotels {
	public static void createTableHotel() {

		String url = "jdbc:mysql://localhost:3306/HotelDBMS";
		String user = "root";
		String pass = "root";

		String sqlDB = "CREATE TABLE Hotels " + "(id INTEGER not NULL, " + " hotel_name VARCHAR(20)not NULL, "
				+ " hotel_location VARCHAR(20), " + " created_date DATE not NULL, " + "updated_date DATE, "
				+ "is_Active BOOLEAN not NULL," + " PRIMARY KEY ( id ))";
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

	public static void readFromTable(int number) {
		String url = "jdbc:mysql://localhost:3306/HotelDBMS";
		String username = "root";
		String password = "root";

		String sql = "SELECT * FROM hotels";
		// Connection, Driver, DriverRegister lines will be exactly same

		java.sql.Connection conn = null;
		try {
			Driver driver = (Driver) Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			DriverManager.registerDriver(driver);
			conn = DriverManager.getConnection(url, username, password);
			java.sql.Statement st = conn.createStatement();
			ResultSet resultSet = st.executeQuery(sql);
			int count = 1;
			while (resultSet.next() && number >= count) {
				Integer id = resultSet.getInt("id");
				String hotel_name = resultSet.getString("hotel_name");
				String hotel_location = resultSet.getString("hotel_location");
				Date created_date = resultSet.getDate("created_date");
				Date updated_date = resultSet.getDate("updated_date");
				Boolean is_Active = resultSet.getBoolean("is_Active");
				System.out.println(id + " " + hotel_name + " " + hotel_location + " " + created_date + " "
						+ updated_date + " " + is_Active);
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

			Driver driver = (Driver) Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			DriverManager.registerDriver(driver);
			con = DriverManager.getConnection(url, username, password);
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

			Driver driver = (Driver) Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			DriverManager.registerDriver(driver);
			con = DriverManager.getConnection(url, username, password);
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
			con = DriverManager.getConnection(url, username, password);
			Statement st = con.createStatement();

			Scanner sa = new Scanner(System.in);
			System.out.println("Please Enter the id you want to delet it:");
			String enter = sa.next();
			String sql = "delete from users where id ='" + enter + "'";
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

			String sql = "UPDATE Hotels SET is_Active=false LIMIT 10 ;";

			int result = st.executeUpdate(sql);

		}

		catch (Exception ex) {

			System.err.println(ex);

		}
	}

	public static void insertIntoTable() {
		try {
			String url = "jdbc:mysql://localhost:3306/HotelDBMS";
			String user = "root";
			String pass = "root";

			Scanner sa = new Scanner(System.in);
			System.out.println("enter how many users you want to print?");
			int number2 = sa.nextInt();

			// Integer id=0;
			String hotel_name = "Amna";
			String hotel_location = "Mus";
			String created_date = "2023-01-01";
			String updated_date = "2022-12-6";
			boolean is_Active = true;

			Random rn = new Random();
			Integer numberToAdd = rn.nextInt(100);

			for (int i = 1; i <= number2; i++) {
				String sql = "INSERT INTO Hotels VALUES (" + i + numberToAdd + ",'" + (hotel_name + i) + "','"
						+ hotel_location + "','" + created_date + "','" + updated_date + "'," + is_Active + ")";

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

	public static void insertIntoTable1() {
		try {
			String url = "jdbc:mysql://localhost:3306/HotelDBMS";
			String user = "root";
			String pass = "root";

			Scanner sa = new Scanner(System.in);
			System.out.println("enter how many number of rows you want to be inserted?");
			int number3 = sa.nextInt();

			// Integer id=1;
			String hotel_name = "Amna";
			String hotel_location = "Mus";
			String created_date = "2023-01-01";
			String updated_date = "2022-12-6";
			boolean is_Active = true;

			Random rn = new Random();
			Integer numberToAdd = rn.nextInt(100);

			for (int i = 1; i <= 1; i++) {
				String sql = "INSERT INTO Hotels VALUES (" + i + numberToAdd + ",'" + (hotel_name + i) + "','"
						+ hotel_location + "','" + created_date + "','" + updated_date + "'," + is_Active + ")";

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
