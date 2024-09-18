package finalProject;
import java.util.*;
import java.time.*;

public class ClientCode {
	static Scanner keyboard = new Scanner(System.in);
	private static Airline airline = new Airline();
	
	public static void main(String[] args) {
		ArrayList<Passenger> passengers = new ArrayList<>();
		int userChoice;
		do {
			displayMenu();
			userChoice = getIntInput("Please enter your choice here (Enter 9 to exit): ");
			switch(userChoice) {
				case 1: 
					addFlight();
					break;
				case 2:
					addPassenger(passengers);
					break;
				case 3:
					addEmployee();
					break;
				case 4:
					bookReservation(passengers);
					break;
				case 5:
					cancelReservation();
					break;
				case 6:
					viewFlightDetails();
					break;
				case 7:
					viewPassengerDetails(passengers);
					break;
				case 8:
					viewEmployeeDetails();
					break;
				case 9:
					System.out.println("Exiting program. Goodbye!");
					break;
				default:
					System.out.println("Invalid choice. Please try again.");
			}
		}while(userChoice != 9);
	}
	/**
	 * Displays detailed information of an employee based on the provided employee ID. If an employee with the specified ID exists in the airline 
	 * system, their details,including full name, gender, address, birthdate, employee ID, type, and department, are printed to the console. 
	 * If the employee is not found, an appropriate message is displayed indicating that no employee with the given ID exists.
	 * @throws InputMismatchException if the input provided for the employee ID is invalid.
	 */
	public static void viewEmployeeDetails() {
		System.out.println("\n---- View Employee Details ----");
		String employeeID = getStringInput("Enter employee ID: ");
		Employee employee = airline.employeeInformation(employeeID);
		if(employee != null) {
			System.out.println(employee);
		}else {
			System.out.println("Employee with the employee ID " + employeeID + " could not be found.");
		}
	}
	/**
	 * Displays details of a passenger based on the provided booking reference. If the passenger is found in the list, their details are 
	 * @param passengers The list of passengers from which to retrieve details.
	 */
	public static void viewPassengerDetails(ArrayList<Passenger> passengers) {
		System.out.println("\n---- View Passenger Details ----");
		int bookingReference = getIntInput("Enter booking reference");
		Passenger passenger = getPassengerByBookingReference(bookingReference, passengers);
		if(passenger != null) {
			System.out.println(passenger);
		}else {
			System.out.println("The passenger with the booking reference " + bookingReference + " could not be found.");
		}
	}
	/**
	 * Retrieves a passenger from the provided list based on the booking reference.
	 * @param bookingReference The booking reference number of the passenger to find.
	 * @param passengers       The list of passengers to search through.
	 * @return The Passenger object if found, or null if not found.
	 */
	public static Passenger getPassengerByBookingReference(int bookingReference, ArrayList<Passenger> passengers) {
        for (Passenger passenger : passengers) { 
            if (passenger.getBookingReference() == bookingReference) {
                return passenger;
            }
        }
        return null;
    }
	/**
	 * Displays details of a flight based on the provided flight number. If the flight is found, its details are printed to the console.
	 * If not found, a message indicating the absence of the flight with the given flight number is printed.
	 */
	public static void viewFlightDetails() {
		System.out.println("\n---- View Flight Details ----");
		int flightNumber = getIntInput("Enter flight number: ");
		Flight flight = airline.flightInformation(flightNumber);
		if (flight != null) {
	        System.out.println(flight);
	    }else {
	    	System.out.println("The flight with the flight number " + flightNumber + " could not be found.");
	    }
	}
	/**
	 * Cancels a reservation based on the provided booking reference. If successful, a confirmation message is printed. If the reservation
	 *  is not found, an exception message is printed.
	 * @throws ReservationNotFoundException If the reservation with the provided booking reference is not found.
	 */
	public static void cancelReservation() throws ReservationNotFoundException {
		System.out.println("\n---- Cancel Reservation ----");
		int bookingReference = getIntInput("Enter booking reference:");
	    try{
	    	airline.cancelReservation(bookingReference);
	    	System.out.println("Reservation successfully canceled.");
	    }catch(ReservationNotFoundException e) {
	    	System.out.println(e.getMessage());
	    }
	}
	/**
	 * Books a reservation for a passenger on a flight based on user inputs.
	 * If the flight or passenger is not found, appropriate error messages are displayed.
	 * @param passengers The list of passengers to search through for booking.
	 */
	public static void bookReservation(ArrayList<Passenger> passengers) {
		System.out.println("\n---- Book Reservation ----");
		int flightNumber = getIntInput("Enter flight number:");
		Flight flight = airline.flightInformation(flightNumber);
		if(flight == null) {
			System.out.println("The flight with the flight number " + flightNumber + " could not be found.");
			return;
		}
		
		String passportNumber = getStringInput("Enter passengers passport number:");
		Passenger passenger = null;
	    try {
	        passenger = findPassenger(passportNumber, passengers);
	    } catch (PassengerNotFoundException e) {
	        System.out.println(e.getMessage());
	        return; 
	    }
		
		LocalDate reservationDate = LocalDate.now();
		Reservation reservation = new Reservation(flight, passenger, BookingStatus.BOOKED, reservationDate);
		airline.bookReservation(reservation);
		System.out.println("Reservation successfully booked!");
	}
	/**
	 * Finds a passenger based on the provided passport number in the given list. If found, returns the Passenger object. If not found,
	 *  throws a PassengerNotFoundException.
	 * @param passportNumber The passport number of the passenger to find.
	 * @param passengers     The list of passengers to search through.
	 * @return The Passenger object if found.
	 * @throws PassengerNotFoundException If the passenger with the provided passport number is not found.
	 */
	public static Passenger findPassenger(String passportNumber, ArrayList<Passenger> passengers) throws PassengerNotFoundException{
		for(Passenger passenger : passengers) {
			if((passenger.getPassportNumber().equalsIgnoreCase(passportNumber))) {
				return passenger;
			}
		}
		throw new PassengerNotFoundException("The passenger with the passport number " + passportNumber + " was not found.");
	}
	/**
	 * Adds a new employee to the airline system with the provided details.
	 * If an employee with the same ID already exists, an error message is displayed.
	 */
	public static void addEmployee() {
		System.out.println("\n---- Add Employee ----");
		String firstName = getStringInput("Enter first name:");
		String lastName = getStringInput("Enter last name:");
		Gender gender = getGenderInput("Enter gender (M/F):");
		LocalDate birthdate = getLocalDateInput("Enter birthdate (YYYY-MM-DD):");
		String street = getStringInput("Enter street:");
		String city = getStringInput("Enter city:");
		String state = getStringInput("Enter state:");
		String zipcode = getStringInput("Enter zipcode:");
		String employeeID = getStringInput("Enter employee ID:");
		String employeeType = getStringInput("Enter employee type:");
		String department = getStringInput("Enter department:");
		try {
			airline.addEmployee(firstName, lastName, gender, new Address(street, city, state, zipcode), birthdate.toString(),  
				employeeID, employeeType, department);
		}catch(EmployeeExistsException e) {
			System.out.println(e.getMessage());
		}
	}
	/**
	 * Adds a new passenger to the provided list with the given details. Checks if a passenger with the same booking reference already exists.
	 * If so, displays an error message.
	 * @param passengers The list of passengers to add to.
	 */
	public static void addPassenger(ArrayList<Passenger> passengers) {
		System.out.println("\n---- Add Passenger ----");
		String firstName = getStringInput("Enter first name:");
		String lastName = getStringInput("Enter last name:");
		Gender gender = getGenderInput("Enter gender (M/F):");
		LocalDate birthdate = getLocalDateInput("Enter birthdate (YYYY-MM-DD):");
		String street = getStringInput("Enter street:");
		String city = getStringInput("Enter city:");
		String state = getStringInput("Enter state:");
		String zipcode = getStringInput("Enter zipcode:");
		int bookingReference = getIntInput("Enter booking reference:");
		if(passengerExists(bookingReference, passengers)) {
			System.out.println("Passenger with booking reference " + bookingReference + " already exists.");
			return;
		}
		String passportNumber = getStringInput("Enter passport number");
		String nationality = getStringInput("Enter nationality:");
		Passenger passenger = new Passenger(firstName, lastName, gender, new Address(street, city, state, zipcode), birthdate.toString(), 
				bookingReference, passportNumber, nationality);
		passenger.setBookingReference(bookingReference);
		passengers.add(passenger);
		System.out.println("Passenger added successfully.");
	}
	/**
	 * Checks if a passenger with the provided booking reference exists in the given list.
	 * @param bookingReference The booking reference number of the passenger to check.
	 * @param passengers       The list of passengers to search through.
	 * @return True if the passenger exists, false otherwise.
	 */
	private static boolean passengerExists(int bookingReference, ArrayList<Passenger> passengers) {
		for(Passenger passenger: passengers) {
			if(passenger.getBookingReference() == bookingReference) {
				return true;
			}
		}
		return false;
		
	}
	/**
	 * This method adds a Flight object to the Airline objects Flight arrayList. It prompts the user to enter the details for all
	 * the Flight fields.  
	 */
	public static void addFlight() {
		System.out.println("\n---- Add Flight ----");
		boolean success = false;
		while(!success) {
			try {
				int flightNumber = getIntInput("Flight Number:");
				String departureCity = getStringInput("Departure City:");
				String destinationCity = getStringInput("Destination City:");
				LocalDateTime departureTime = getInputAsLocalDateTime("Departure Time (yyyy-MM-ddTHH:mm): ");
				LocalDateTime arrivalTime = getInputAsLocalDateTime("Arrival Time (yyyy-MM-ddTHH:mm): ");
		
				Flight flight = new Flight(flightNumber, departureCity, destinationCity, departureTime, arrivalTime);
				airline.addFlight(flight);
				System.out.println("Flight successfully added.");
				success = true;
			}catch(InvalidFlightRouteException | InvalidTimeException e) {
				System.out.println("Error: " + e.getMessage());
				System.out.println("Please try again: ");
			}catch(FlightExistsException e) {
				System.out.println("This flight already exists.");
				return;
			}
		}	
	}
	/**
	 * This method displays the passed in message to the user and then prompts the user to enter a value that is one of the enum Gender 
	 * types.
	 * @param prompt The passed in message to be displayed.
	 * @return The Gender enum.
	 */
	public static Gender getGenderInput(String prompt) {
		System.out.println(prompt);
		while(true) {
			try {
				return Gender.valueOf(keyboard.nextLine());
			}catch(IllegalArgumentException e) {
				System.out.println("Invalid gender. Please enter either M or F.");
			}
		}
	}
	/**
	 * This method displays the passed in message to the user and then prompts the user to enter a String that can become a LocalDate
	 * object and validates it.
	 * @param prompt The passed in message to be displayed.
	 * @return The LocalDate object.
	 */
	public static LocalDate getLocalDateInput(String prompt) {
		System.out.println(prompt);
		while(true) {
			try {
				return LocalDate.parse(keyboard.nextLine());
			}catch(Exception e) {
				System.out.println("Invalid Format. Please enter date in the format YYYY-MM-DD.");
			}
		}
	}
	/**
	 * This method displays the passed in message to the user and then prompts the user to enter a String that can become a 
	 * LocalDateObject and validates it.
	 * @param prompt The passed in message to be displayed.
	 * @return The LocalDateTime object.
	 */
	public static LocalDateTime getInputAsLocalDateTime(String prompt) {
		System.out.println(prompt);
		while(true) {
			try {
			return LocalDateTime.parse(keyboard.nextLine());
			}catch(Exception e) {
				System.out.println("Invalid Format. Please enter date and time in the format yyyy-MM-ddTHH:mm.");
			}
		}
	}
	/**
	 * This method displays the passed in message to the user and then prompts the user to enter a String and returns the String.
	 * @param prompt The passed in message to be displayed.
	 * @return The entered String.
	 */
	public static String getStringInput(String prompt) {
		System.out.println(prompt);
		String stringInput = keyboard.nextLine();
		return stringInput;
	}
	/**
	 * This method displays the passed in message to the user and then prompts the user to enter an integer and validates that the entered
	 * value is an integer.
	 * @param prompt The passed in message to be displayed.
	 * @return The entered integer.
	 */
	public static int getIntInput(String prompt) {
		System.out.println(prompt);
		int intInput = 0;
		boolean validInput = false;
		while(!validInput) {
			try {
				intInput = keyboard.nextInt();
				validInput = true;
			}catch(InputMismatchException e) {
				System.out.println("You did not enter an integer.\n"
						+ "Please try again.");
				keyboard.nextLine();
			}
		}
		keyboard.nextLine();
		return intInput;
	}
	/**
	 * This method displays the menu to the user.
	 */
	public static void displayMenu() {
		System.out.println("\n=====================================");
        System.out.println("     Welcome to My Airline System     ");
        System.out.println("=====================================");
        System.out.println("1. Add Flight");
        System.out.println("2. Add Passenger");
        System.out.println("3. Add Employee");
        System.out.println("4. Book Reservation");
        System.out.println("5. Cancel Reservation");
        System.out.println("6. View Flight Details");
        System.out.println("7. View Passengers Details");
        System.out.println("8. View Employee Details");
        System.out.println("9. Exit");
        System.out.println("=====================================");
	}

}
