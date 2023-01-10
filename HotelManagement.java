package SqlText;

import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Date;

public class HotelManagement {

	public static void readFromGuests () {
		String url = "jdbc:mysql://localhost:3306/HotelDBMS";
		String username = "root";
		String password = "root";

		String sql = "select * from guests where guest_name like '%e';";
		// Connection, Driver, DriverRegister lines will be exactly same

		java.sql.Connection conn = null;
		try {
			Driver driver = (Driver) Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			DriverManager.registerDriver(driver);
			conn = DriverManager.getConnection(url, username, password);
			java.sql.Statement st = conn.createStatement();
			ResultSet resultSet = st.executeQuery(sql);
			int count = 1;
			while (resultSet.next()) {
				Integer id = resultSet.getInt("id");
				String guest_name = resultSet.getString("guest_name");
				String guest_phone = resultSet.getString("guest_phone");
				Integer guest_accompanying_members = resultSet.getInt("guest_accompanying_members");
				Integer guest_payment_amount = resultSet.getInt("guest_payment_amount");
				Integer room_id = resultSet.getInt("room_id");
				Integer hotel_id = resultSet.getInt("hotel_id");
				Date created_date = resultSet.getDate("created_date");
				Date updated_date = resultSet.getDate("updated_date");
				Boolean is_Active = resultSet.getBoolean("is_Active");
				System.out.println(id + " " + guest_name + " " + guest_phone +" "+guest_accompanying_members+" "+guest_payment_amount+" "+room_id+" "+hotel_id+ " " + created_date + " "
						+ updated_date + " " + is_Active);
				count++;
			}

			conn.close();
		} catch (Exception ex) {
			System.err.println(ex);
		}

	}

	public static void readFromRooms () {
		String url = "jdbc:mysql://localhost:3306/HotelDBMS";
		String username = "root";
		String password = "root";

		String sql = "Select * from Rooms  INNER join guests on guests.room_id=Rooms.id where guests.guest_payment_amount>20";
		// Connection, Driver, DriverRegister lines will be exactly same

		java.sql.Connection conn = null;
		try {
			Driver driver = (Driver) Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			DriverManager.registerDriver(driver);
			conn = DriverManager.getConnection(url, username, password);
			java.sql.Statement st = conn.createStatement();
			ResultSet resultSet = st.executeQuery(sql);
			int count = 1;
			while (resultSet.next()) {
				Integer id = resultSet.getInt("id");
				Integer room_type_id = resultSet.getInt("room_type_id");
				Integer hotel_id = resultSet.getInt("hotel_id");
				Date created_date = resultSet.getDate("created_date");
				Date updated_date = resultSet.getDate("updated_date");
				Boolean is_Active = resultSet.getBoolean("is_Active");
				
				String guest_name = resultSet.getString("guest_name");
				String guest_phone = resultSet.getString("guest_phone");
				Integer guest_accompanying_members = resultSet.getInt("guest_accompanying_members");
				Integer guest_payment_amount = resultSet.getInt("guest_payment_amount");
				Integer room_id = resultSet.getInt("room_id");
				
			


				System.out.println(id +" " +room_type_id+" "+hotel_id+" "+created_date+" "+updated_date+" "+is_Active+ " " + guest_name + 
						" " + guest_phone +" "+guest_accompanying_members+" "+guest_payment_amount+" "+room_id );
				count++;
			}

			conn.close();
		} catch (Exception ex) {
			System.err.println(ex);
		}

	}
	
	public static void readFromCount () {
		String url = "jdbc:mysql://localhost:3306/HotelDBMS";
		String username = "root";
		String password = "root";

		String sql = "Select * from Rooms  INNER join guests on guests.room_id=Rooms.id where guests.guest_payment_amount>20";
		// Connection, Driver, DriverRegister lines will be exactly same

		java.sql.Connection conn = null;
		try {
			Driver driver = (Driver) Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			DriverManager.registerDriver(driver);
			conn = DriverManager.getConnection(url, username, password);
			java.sql.Statement st = conn.createStatement();
			ResultSet resultSet = st.executeQuery(sql);
			
			while (resultSet.next()) {
				Integer count1 = resultSet.getInt(1);
				System.out.println(count1);
				conn.close();
			}

			
		} catch (Exception ex) {
			System.err.println(ex);
		}
		

	}
	
	public static void readFromstaing () {
		String url = "jdbc:mysql://localhost:3306/HotelDBMS";
		String username = "root";
		String password = "root";

		String sql = "SELECT * FROM guests INNER JOIN Rooms ON guests.room_id = Rooms.id INNER JOIN employees ON Rooms.id = employees.room_id INNER JOIN employee_type  ON employees.employee_type_id = employee_type.id WHERE employee_type.employee_type_name LIKE '%A%'";
		// Connection, Driver, DriverRegister lines will be exactly same

		java.sql.Connection conn = null;
		try {
			Driver driver = (Driver) Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			DriverManager.registerDriver(driver);
			conn = DriverManager.getConnection(url, username, password);
			java.sql.Statement st = conn.createStatement();
			ResultSet resultSet = st.executeQuery(sql);
			
			while (resultSet.next()) {
				int id=resultSet.getInt(1);
				String   guest_name=resultSet.getString(2);
				int guest_phone=resultSet.getInt(3);
				int guest_accompanying_members = resultSet.getInt(4);
				System.out.println( id+" "+guest_name+""+guest_phone+" "+guest_accompanying_members);
				
				conn.close();
			}

			
		} catch (Exception ex) {
			System.err.println(ex);
		}
		

	}
	
	public static void readFromactive () {
		String url = "jdbc:mysql://localhost:3306/HotelDBMS";
		String username = "root";
		String password = "root";

		String sql = "SELECT COUNT(Rooms.room_type_id), Room_Type.room_type_name FROM Rooms INNER JOIN Room_Type ON Rooms.room_type_id = Room_Type.id GROUP BY room_type_name HAVING COUNT(Rooms.room_type_id) > 5 ORDER BY COUNT(Rooms.room_type_id) DESC ";
		// Connection, Driver, DriverRegister lines will be exactly same

		java.sql.Connection conn = null;
		try {
			Driver driver = (Driver) Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			DriverManager.registerDriver(driver);
			conn = DriverManager.getConnection(url, username, password);
			java.sql.Statement st = conn.createStatement();
			ResultSet resultSet = st.executeQuery(sql);
			
			while (resultSet.next()) {
				Integer CountOfRooms=resultSet.getInt(1);
				String room_type_name=resultSet.getString(2);
				System.out.println( CountOfRooms+" "+room_type_name);
				conn.close();
			}

			
		} catch (Exception ex) {
			System.err.println(ex);
		}
		

	}
	
	public static void readFromhotels() {
		String url = "jdbc:mysql://localhost:3306/HotelDBMS";
		String username = "root";
		String password = "root";
		String sql = "SELECT * FROM Guests INNER JOIN Rooms ON Guests.room_id = Rooms.id INNER JOIN Employee ON Rooms.id = Employee.room_id INNER JOIN Employee_Type  ON Employee.employee_type_id = Employee_Type.id WHERE Employee_Type.employee_type_name LIKE '%H%'";

		// Connection, Driver, DriverRegister lines will be exactly same

		java.sql.Connection conn = null;
		try {
			Driver driver = (Driver) Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			DriverManager.registerDriver(driver);
			conn = DriverManager.getConnection(url, username, password);
			java.sql.Statement st = conn.createStatement();
			ResultSet resultSet = st.executeQuery(sql);
			
			while (resultSet.next()) {
				int id=resultSet.getInt(1);
				String   guest_name=resultSet.getString(2);
				int   guest_phone=resultSet.getInt(3);
				int   guest_accompanying_members=resultSet.getInt(4);
				System.out.println( id+" "+guest_name+""+guest_phone+guest_accompanying_members);
				conn.close();
			}

			
		} catch (Exception ex) {
			System.err.println(ex);
		}
		

	}
}
