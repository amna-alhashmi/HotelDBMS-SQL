package SqlText;

import java.util.Scanner;

public class Main_Text {

	public static void main(String[] args) {
		Scanner sa = new Scanner(System.in);
		boolean round=true;
while(round) {
		System.out.println("1.create Tables");
		System.out.println("2.Insert 10,000 hotels");
		System.out.println("3.Insert 1 hotel");
		System.out.println("4.Print 10 hotels");
		System.out.println("5.Make first 10 hotels 'is_Active' = false");
		System.out.println("6.Print hotel information by user input");

		String a = sa.next();
		int option = Integer.parseInt(a);
		switch (option) { 
		case 1:
		Hotels hotels=new Hotels();
		hotels.createTableHotel();

		Room_Type RT=new Room_Type();
		RT.createTableRoomTyped();
		
		Rooms rooms=new Rooms();
		rooms.createTableRoom();
		
		Guests guests= new Guests();
		guests.createTableGuest();
		
		Employee_Type ET=new Employee_Type();
		ET.createTableEmployee_Type();
		
		Employees employees=new Employees();
		employees.createTableEmployees();
		break;
		
		case 2:
		
			Hotels hotels1=new Hotels();
			hotels1.insertIntoTable();
			
			
			
			break;
		case 3:
			Hotels hotels2=new Hotels();
			hotels2.insertIntoTable1();
			break;
			
		case 4:
			Hotels hotels3=new Hotels();
			hotels3.readFromTable();
			break;
		}
	}round=false;

}
}