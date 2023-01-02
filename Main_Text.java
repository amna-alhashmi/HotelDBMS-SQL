package SqlText;

public class Main_Text {

	public static void main(String[] args) {
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
	}

}
