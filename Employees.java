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

public class Employees {
	public static void createTableEmployees() {
		String url = "jdbc:mysql://localhost:3306/HotelDBMS";
		String user = "root";
		String pass = "root";

		String sqlDB = "CREATE TABLE Employees " + "(id INTEGER not NULL, " + "employee_type_id INTEGER  ,"
				+ "FOREIGN KEY (employee_type_id) REFERENCES Employee_Type(id) ON DELETE CASCADE ,"
				+ "room_id  INTEGER  ," + "FOREIGN KEY (room_id) REFERENCES Rooms(id) ON DELETE CASCADE ,"
				+ " created_date Date not NULL, " + " updated_date Date , " + " is_Active  Boolean  not NULL, "
				+ " PRIMARY KEY ( id ))";

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

		String sql = "SELECT * FROM Employees";

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
				Integer employee_type_id = resultSet.getInt("employee_type_id");
				Integer room_id = resultSet.getInt("room_id");
				Date created_date = resultSet.getDate("created_date");
				Date updated_date = resultSet.getDate("updated_date");
				Boolean is_Active = resultSet.getBoolean("is_Active");
				System.out.println(id + " " + employee_type_id + " " + room_id + " " + created_date + " " + updated_date
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
			String sql = "SELECT * FROM Employees WHERE id='" + userin + "'";
			ResultSet result = st.executeQuery(sql);

			while (result.next()) {

				int id1 = result.getInt("id");
				Integer employee_type_name = result.getInt("employee_type_id ");
				Integer room_id = result.getInt("room_id ");
				Date created = result.getDate("created_date");
				Date update = result.getDate("updated_date");
				boolean Active = result.getBoolean("is_Active");
				System.out.println(id1 + " " + employee_type_name + " " + created + " " + update + " " + Active);

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
			System.out.println("PLS Enter any id to Update  :");
			int user_input = sa.nextInt();
			System.out.println("Please Enter the new employee_type_id:");
			Integer employee_type_id = sa.nextInt();

			String sql = "UPDATE Employees SET employee_type_id='" + employee_type_id + "' WHERE id='" + user_input
					+ "'";

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
			String sql = "delete from Employees where id ='" + enter + "'";
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

			String sql = "UPDATE Employees SET is_Active=false LIMIT 10 ;";

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

			Scanner sa = new Scanner(System.in);
//			System.out.println("enter Employee type name?");
//			int number3 = sa.nextInt();
//			System.out.println("enter room type name?");
//			int number4 = sa.nextInt();
			// Integer id=1;
//			Integer employee_type_id = ;
//			Integer room_id = 
			String created_date = "2023-01-01";
			String updated_date = "2022-12-6";
			boolean is_Active = true;

			Random rn = new Random();
			Integer numberToAdd = rn.nextInt(100);

			for (int i = 1; i <= num; i++) {
				String sql = "INSERT INTO Employees VALUES (" + i + ","  + 26  +","+3+",'"
						 + created_date + "','" + updated_date + "'," + is_Active + ")";

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
	
//	public static void insertIntoTable(int a) {
//		try {
//			String url = "jdbc:mysql://localhost:3306/HotelDBMS";
//			String user = "root";
//			String pass = "root";
//
//			Scanner sa = new Scanner(System.in);
//			System.out.println("enter Employee type name?");
//			int number3 = sa.nextInt();
//			System.out.println("enter room type name?");
//			int number4 = sa.nextInt();
//			// Integer id=1;
////			Integer employee_type_id = ;
////			Integer room_id = 
//			String created_date = "2023-01-01";
//			String updated_date = "2022-12-6";
//			boolean is_Active = true;
//
//			Random rn = new Random();
//			Integer numberToAdd = rn.nextInt(100);
//
//			for (int i = 1; i >= a; i++) {
//				String sql = "INSERT INTO Employees VALUES (" + i + numberToAdd + ",'" + "SELECT id FROM Employee_Type WHERE Employee_Type_name ="+number3 + "','"
//						+ "SELECT id from Rooms INNER JOIN Room_Type ON Room.Room_Typed_id=Room_Typed_id WHERE Room_Type.Room_Typed_name"+number4 + "','" + created_date + "','" + updated_date + "'," + is_Active + ")";
//
//				Connection conn = null;
//
//				Driver driver = (Driver) Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
//				DriverManager.registerDriver(driver);
//				conn = DriverManager.getConnection(url, user, pass);
//				Statement st = conn.createStatement();
//				int m = st.executeUpdate(sql);
//				if (m >= 1) {
//					System.out.println("Created table in given database...");
//
//				} else {
//					System.out.println(" table already Created in given database...");
//				}
//				conn.close();
//			}
//		} catch (Exception ex) {
//			System.err.println(ex);
//		}
//
//	}

}
