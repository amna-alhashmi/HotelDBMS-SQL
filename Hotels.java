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
		
		
	//public static getById
	    	

	
		
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
							String hotel_name = resultSet.getString("hotel_name");
							String hotel_location = resultSet.getString("hotel_location");
							Date created_date = resultSet.getDate("created_date");
							Date updated_date = resultSet.getDate("updated_date");
							Boolean is_Active = resultSet.getBoolean("is_Active");
							System.out.println(id+" "+hotel_name+" "+hotel_location+" "+created_date+" "+updated_date+" "+is_Active);
							count++;
							 }
					
						conn.close();
					}
					catch (Exception ex) {
						System.err.println(ex);
					}
		
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
//		String url = "jdbc:mysql://localhost:3306/HotelDBMS";
//		String username = "root";
//		String password = "root";
//		
//		System.out.println("pls enter how many rows you want to show:");
//		Scanner sa = new Scanner(System.in); // System.in is a standard input stream
//		int id1 = sa.nextInt();
//		
//		//for(int i=1;i<10;i++) {
//		String sqlDB = " SELECT * FROM Hotels";
//		Connection conn = null;
//		
//		
//		try {
//			Driver driver = (Driver) Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
//			Connection conn1 = DriverManager.getConnection(url, username, password);
//			Statement st = conn1.createStatement();
//			ResultSet m = st.executeQuery(sqlDB);
//			if (m.next()) {
//				do {
//					System.out.println("id : " + m.getInt(1));
//					System.out.println("hotel_name :" + m.getString(2));
//					System.out.println("hotel_location :" + m.getString(3));
//					System.out.println("created_date :" + m.getString(4));
//					System.out.println("updated_date :" + m.getString(5));
//					if (m.getInt(6) == 1) {
//						System.out.println("is_Active : true");
//					} else {
//						System.out.println("is_Active : false");
//					}
//					System.out.println("*********************************");
//				} while (m.next());
//			} else {
//				System.out.println("No such user id is already registered");
//			}
//		
//			conn1.close();
//		}
//		 catch (Exception ex) {
//			System.err.println(ex);
//		}
		
	//}
		
//		try {
//		String url = "jdbc:mysql://localhost:3306/HotelDBMS";
//		String user = "root";
//		String pass = "root";
//		
//		Scanner sa = new Scanner(System.in);
//		System.out.println("How many users you want?");
//		int input=sa.nextInt();
//		
//		for(int i=1;i<=10;i++) {
//			String sqlDB = "SELECT * FROM Hotels";			   
//				Connection conn = null;
//					Driver driver = (Driver) Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
//					DriverManager.registerDriver(driver);
//					conn = DriverManager.getConnection(url, user, pass);
//					Statement st = conn.createStatement();
//					int m = st.executeUpdate(sqlDB);
//					ResultSet resultSet = st.executeQuery(sqlDB);
//					while(resultSet.next()){
//						Integer id = resultSet.getInt("id");
//						String hotelName = resultSet.getString("hotel_name");
//						String hotelLocation=resultSet.getString("hotel_location");
//						String createDate=resultSet.getString("created_date");
//						String updatedDate=resultSet.getString("updated_date");
//						
//						
//						
//					if (m >= 1) {
//						System.out.println("Created table in given database...");
//						
//					} else {
//						System.out.println(" table already Created in given database...");
//					}
//					conn.close();
//		}
//				} 
//		}catch (Exception ex) {
//					System.err.println(ex);
//		}
		
	
		
		
		
		
		
		
		
//		for(int i=1;i<10;i++) {
//			
//			String sql = "SELECT * FROM hotels";
//			Connection conn = null;
//			Statement stmt = null;
//			
//				Class.forName("com.mysql.cj.jdbc.Driver");
//				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/HotelDBMS", "root", "root");
//				stmt = conn.createStatement();
//				ResultSet rs = stmt.executeQuery(query);
//				while (rs.next()) {
//					Integer id = rs.getInt(1);
//					String hotel_name = rs.getString(2);
//					String hotel_location = rs.getString(3);
//					Date created_date = rs.getDate(4);
//					Date updated_date=rs.getDate(5);
//					String is_Active=rs.getString(6);
//					
//					System.out.println("hotel name" + hotel_name);
//					System.out.println("hotel location:" + hotel_location);
//					System.out.println("created date:" + created_date);
//					System.out.println("updated date:" + updated_date);
//					System.out.println("is_Active"+is_Active);
//				}
//				rs.close();
//			} catch (Exception e) {
//				e.printStackTrace();
//			} finally {
//				try {
//					stmt.close();
//					conn.close();
//				} catch (Exception e) {
//					
//				}
//					}
//				}
	
			public static void insertIntoTable () {
				try {
			    String url = "jdbc:mysql://localhost:3306/HotelDBMS";
			    String user = "root";
			    String pass = "root";
			    
			    Scanner sa = new Scanner (System.in);
				System.out.println("enter how many users you want to print?");
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
				
			    

