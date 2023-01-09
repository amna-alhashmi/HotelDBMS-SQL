package SqlText;

import java.util.Scanner;

public class Main_Text {

	public static void main(String[] args)
			throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Scanner sa = new Scanner(System.in);
		boolean Menui = true;
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
			System.out.println("9.Insert More than 100 hotels, 20 employees, 1000 guests");

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
				System.out.println("enter how many number of rows you want to be inserted?");
				int type1=sa.nextInt();
				Employee_Type employee_type=new Employee_Type();
				employee_type.insertIntoTable(type1);
				
				Rooms rooms1 =new Rooms();
				System.out.println("enter how many user you want to insert?");
				int number3 = sa.nextInt();
				rooms1.insertIntoTable1(number3);
				
				System.out.println("enter how many user you want to insert?");
				int number5 = sa.nextInt();
				Guests guests1=new Guests();
				guests1.insertIntoTable1(number5);
				
				System.out.println("enter how many user you want to insert?");
				int number6 = sa.nextInt();
				Employees employee=new Employees();
				employee.insertIntoTable(number6);
				
				break;
			case 9:
				
				Hotels hotels6 = new Hotels();
				hotels6.readFromTable(100);
				
				Employees employee1=new Employees();
				employee1.insertIntoTable(20);
				
				Guests guests3=new Guests();
				guests3.insertIntoTable1(1000);
				
				
				break;
				

						
					
					

				}
			}
		
		round = false;

	}
}