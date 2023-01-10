package SqlText;

import java.util.Scanner;

public class Main_Text {

	public static void main(String[] args)
			throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Scanner sa = new Scanner(System.in);
		boolean smallMenu = true;
		boolean round = true;
		while (round) {
			System.out.println("1.create Tables");
			System.out.println("2.Insert 10,000 hotels");
			System.out.println("3.Insert 1 hotel");
			System.out.println("4.Print 10 hotels");
			System.out.println("5.Make first 10 hotels 'is_Active' = false");
			System.out.println("6.Print hotel information by user input");
			System.out.println("7.Insert Room_type table");
			System.out.println("8.Insert all tables");
			System.out.println("9.answer Question:");

			String a = sa.next();
			int option = Integer.parseInt(a);
			switch (option) {
			case 1:
				Hotels hotels = new Hotels();
				hotels.createTableHotel();

				Room_Type RT = new Room_Type();
				RT.createTableRoomTyped();

				Rooms rooms = new Rooms();
				rooms.createTableRoom();

				Guests guests = new Guests();
				guests.createTableGuest();

				Employee_Type ET = new Employee_Type();
				ET.createTableEmployee_Type();

				Employees employees = new Employees();
				employees.createTableEmployees();
				break;

			case 2:

				Hotels hotels1 = new Hotels();
				hotels1.insertIntoTable();

				break;
			case 3:
				Hotels hotels2 = new Hotels();
				hotels2.insertIntoTable1();
				break;

			case 4:
				Hotels hotels3 = new Hotels();
				hotels3.readFromTable(10);
				break;

			case 5:
				Hotels hotels4 = new Hotels();
				hotels4.makeIsActiveFalseById();
				break;
			case 6:
				System.out.println("Enter how many hotel information you want?");
				int information = sa.nextInt();
				Hotels hotels5 = new Hotels();
				hotels5.readFromTable(information);

			case 7:
				System.out.println("enter how many number of rows you want to be inserted?");
				int type=sa.nextInt();
				Room_Type room_type = new Room_Type();
				room_type.insertIntoTable(type);
				
				break;
				
			case 8:
//				System.out.println("enter how many number of rows you want to be inserted?");
//				int type1=sa.nextInt();
//				Employee_Type employee_type=new Employee_Type();
//				employee_type.insertIntoTable(type1);
				
//				Rooms rooms1 =new Rooms();
//				rooms1.insertIntoTable1();
//				
				
//				Guests guests1=new Guests();
//				guests1.insertIntoTable1();
//				
				System.out.println("enter how many user you want to insert?");
				int number6 = sa.nextInt();
				Employees employee=new Employees();
				employee.insertIntoTable1(number6);
				
				break;
		
			case 9:
				while(smallMenu) {
					System.out.println("1.Guests who's name end with");
					System.out.println("2.Rooms where guests are paying more than 1000");
					System.out.println("3.Count of guests who are staing in 'DELUXE' rooms");
					System.out.println("4.Guests who are staing in rooms and served by employee who have 'A' in their name");
					System.out.println("5.All rooms which are not active but room type is 'Deluxe'");
					System.out.println("6.All room type in hotels who's name have 'H' or are active but have more than 5 rooms.");
					System.out.println("7.Exit small");
					

					String a1 = sa.next();
					int option1 = Integer.parseInt(a1);
					switch (option1) {
					case 1:
						HotelManagement hotelManagement=new HotelManagement();
						hotelManagement.readFromGuests();
						
						break;
					case 2:
						HotelManagement hotelManagement1=new HotelManagement();
						hotelManagement1.readFromRooms();
						
						break;
					case 3:
						HotelManagement hotelManagement2=new HotelManagement();
						hotelManagement2.readFromCount();
				
						break;
						
					case 4:
						HotelManagement hotelManagement3=new HotelManagement();
						hotelManagement3.readFromstaing();
						break;
						
					case 5:
						HotelManagement hotelManagement4=new HotelManagement();
						hotelManagement4.readFromactive();
						
						break;
						
					case 6:
						HotelManagement hotelManagement5=new HotelManagement();
						hotelManagement5.readFromhotels();
						break;
					case 7:
						smallMenu=false;
						round=true;
						break;
					}
				}smallMenu=false;
				break;
				

						
					
					

				}
			}
		
		round = false;

	}
}