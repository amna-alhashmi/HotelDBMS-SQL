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

		String sql = "SELECT * FROM Rooms";

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
			con = DriverManager.getConnection(url, username, password);
			Statement st = con.createStatement();

			Scanner sa = new Scanner(System.in);
			System.out.println("Pls Enter the id:");
			int userin = sa.nextInt();
			String sql = "SELECT * FROM Rooms WHERE id='" + userin + "'";
			ResultSet result = st.executeQuery(sql);

			while (result.next()) {

				int id1 = result.getInt("id");
				String room_type_id = result.getString("room_type_id");
				String hotel_id = result.getString("hotel_id");
				Date created = result.getDate("created_date");
				Date update = result.getDate("updated_date");
				boolean Active = result.getBoolean("is_Active");
				System.out.println(
						id1 + " " + room_type_id + " " + hotel_id + " " + created + " " + update + " " + Active);

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
			System.out.println("Please Enter the new room_type_id:");
			String room_type_id = sa.next();
			System.out.println("Please Enter the new hotel_id:");
			String hotel_id = sa.next();
			String sql = "UPDATE Rooms SET Rooms='" + hotel_id + "',hotel_location='" + hotel_id + "' WHERE id='"
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
			String sql = "delete from Rooms where id ='" + enter + "'";
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

			String sql = "UPDATE Rooms SET is_Active=false LIMIT 10 ;";

			int result = st.executeUpdate(sql);

		}

		catch (Exception ex) {

			System.err.println(ex);

		}
	}

	public static void insertIntoTable1(int num) {
		try {
			String url = "jdbc:mysql://localhost:3306/HotelDBMS";
			String user = "root";
			String pass = "root";

			
			String created_date = "2023-01-01";
			String updated_date = "2022-12-6";
			boolean is_Active = true;

			Random rn = new Random();
			Integer numberToAdd = rn.nextInt(100);

			for (int i = 1; i <=num; i++) {
				Scanner sa = new Scanner(System.in);
				System.out.println("enter room type you want?");
				String number3 = sa.next();
				System.out.println("enter hotel name you want?");
				String number4 = sa.next();
				// Integer id=1;
//				String sql1 ="insert into Rooms (Rooms, id) select Rooms, id from room_type where id ="+number3+","+"select Rooms, id from hotel_name where id ="+number4+")";
//				String hotel_id = "SELECT id FROM Hotels WHERE hotel_name="+number4;
				String sql = "INSERT INTO Rooms VALUES (" + i + numberToAdd  + "SELECT id FROM room_type WHERE room_type_name="+number3
						+ "SELECT id FROM hotels WHERE hotel_name="+number4 + ",'" + created_date + "','" + updated_date + "'," + is_Active + ")";

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
