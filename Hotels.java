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
	public static void createTableHotel(){
		
		String url = "jdbc:mysql://localhost:3306/HotelDBMS";
		String user = "root";
		String pass = "root";
		
		String sqlDB = "CREATE TABLE Hotels " + "(id INTEGER not NULL, " + " hotel_name VARCHAR(20)not NULL, "
		+ " hotel_location VARCHAR(20), " + " created_date DATE not NULL, "+"updated_date DATE, "+"is_Active BOOLEAN not NULL," + " PRIMARY KEY ( id ))";
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
		
		
//		Connection con = null;
//	    String url = "jdbc:mysql://localhost:3306/HotelDBMS";
//	    
//	    String driverName = "com.mysql.cj.jdbc.Driver";
//	    String userName = "root";
//	    String password = "root";
//	    try{
//	      Class.forName(driverName).newInstance();
//	      con = DriverManager.getConnection(url, userName, password);
//	      try{
//	        Statement st = con.createStatement();
//	        String sqlDB = "CREATE TABLE Hotels " + "(id INTEGER not NULL, " + " hotel_name VARCHAR(20)not NULL, "
//				+ " hotel_location VARCHAR(20), " + " created_date DATE not NULL, "+"updated_date DATE, "+"is_Active BOOLEAN not NULL," + " PRIMARY KEY ( id ))";
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
	    	

	public static void readFromTable(){
		
		Scanner sa = new Scanner(System.in);
		System.out.println("How many users you want?");
		int input=sa.nextInt();
		for(int i=1;i<10;i++) {
			String query = "select id, hotel_name, hotel_location, created_date, updated_date,is_Active, from createTableHotel";
			Connection conn = null;
			Statement stmt = null;
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/HotelDBMS", "root", "root");
				stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(query);
				while (rs.next()) {
					Integer id = rs.getInt(1);
					String hotel_name = rs.getString(2);
					String hotel_location = rs.getString(3);
					Date created_date = rs.getDate(4);
					Date updated_date=rs.getDate(5);
					String is_Active=rs.getString(6);
					
					System.out.println("hotel name" + hotel_name);
					System.out.println("hotel location:" + hotel_location);
					System.out.println("created date:" + created_date);
					System.out.println("updated date:" + updated_date);
					System.out.println("is_Active"+is_Active);
				}
				rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					stmt.close();
					conn.close();
				} catch (Exception e) {
					
				}
					}
				}
	}
			public static void insertIntoTable () {
				try {
			    String url = "jdbc:mysql://localhost:3306/HotelDBMS";
			    String user = "root";
			    String pass = "root";
			    
			    Scanner sa = new Scanner (System.in);
				System.out.println("enter how many number of rows you want to be inserted?");
				int number2=sa.nextInt();
				
				
			    //Integer id=0;
				String hotel_name="Amna";
				String hotel_location="Mus";
				String created_date="2023-01-01";
				String updated_date = "2022-12-6";
				boolean is_Active=true ;
				
			    Random rn = new Random();
				Integer numberToAdd = rn.nextInt(100);
				
				
				for(int i=1;i<=number2;i++) {
					   String sql = "INSERT INTO Hotels VALUES ("+ i+numberToAdd +",'"+ (hotel_name+i)+"','"+hotel_location+"','"+created_date+
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
				public static void insertIntoTable1() {
				try {
				    String url = "jdbc:mysql://localhost:3306/HotelDBMS";
				    String user = "root";
				    String pass = "root";
				    
				    Scanner sa = new Scanner (System.in);
					System.out.println("enter how many number of rows you want to be inserted?");
					int number3=sa.nextInt();
					
					
				    //Integer id=1;
					String hotel_name="Amna";
					String hotel_location="Mus";
					String created_date="2023-01-01";
					String updated_date = "2022-12-6";
					boolean is_Active=true ;
					
				    Random rn = new Random();
					Integer numberToAdd = rn.nextInt(100);
					
					
					for(int i=1;i<=1;i++) {
						   String sql = "INSERT INTO Hotels VALUES ("+ i+numberToAdd +",'"+ (hotel_name+i)+"','"+hotel_location+"','"+created_date+
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
					   
		   
					   
					   
//					   String driverName = "com.mysql.cj.jdbc.Driver";
//					   Connection con = null;
//					   Class.forName(driverName).newInstance();
//					   con = DriverManager.getConnection(url, userName, password);
//					   Statement st = con.createStatement();
//					   int m=st.executeUpdate(sql);
//					   if (m >=  1) {
//			                System.out.println("inserted successfully : ");
//					   }else {
//			                System.out.println("insertion failed");
//					   }
//			            
//			            con.close();
//			        }
//				
//			        // Catch block to handle exceptions
//				}catch (Exception ex) {
//			            // Display message when exceptions occurs
//			            System.err.println(ex);
//			        }
				
			    

