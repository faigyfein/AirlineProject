package finalProject;
import java.util.*;
import java.time.*;
public class Airline {
	private ArrayList<Flight> flights;
	private ArrayList<Reservation> reservations;
	private ArrayList<Employee> employees;
	/**
	 * Constructs an Airline object initializing all arrayLists to empty.
	 */
	public Airline() {
		this(new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
	}
	/**
	 * Constructs an Airline object with the specified ArrayLists.
	 * @param flights The passed in arraylist of flight objects.
	 * @param reservations The passed in arraylist for reservation objects.
	 * @param employees The passed in arraylist for employee objects.
	 */
	public Airline(ArrayList<Flight> flights, ArrayList<Reservation> reservations, ArrayList<Employee> employees) {
		this.flights = (flights != null) ? new ArrayList<>(flights) : new ArrayList<>();
		this.reservations = (reservations != null) ? new ArrayList<>(reservations) : new ArrayList<>();
        this.employees = (employees != null) ? new ArrayList<>(employees) : new ArrayList<>();
	}
	/**
	 * Copy constructor, performs a deep copy of an existing Airline object
	 * @param airline The airline object that is being copied.
	 */
	public Airline(Airline airline) {
		this(airline.flights, airline.reservations, airline.employees);
	}
	/**
	 * This method returns the arraylist of flight objects in the flights field.
	 * @return A new list containing Flight objects.
	 */
	public ArrayList<Flight> getFlights(){
		return new ArrayList<>(flights);
	}
	/**
	 * This method sets the array list of flight objects to the passed in array list.
	 * @param flights The passed in array list.
	 */
	public void setFlights(ArrayList<Flight> flights) {
		this.flights = new ArrayList<>(flights);
	}
	/**
	 * This method returns the array list of employee objects in the employees field.
	 * @return A new arrayList containing employee objects.
	 */
	public ArrayList<Employee> getEmployees(){
		return new ArrayList<>(employees);
	}
	/**
	 * This method sets the array list of employee objects to the passed in array list.
	 * @param employees The passed in array list.
	 */
	public void setEmployees(ArrayList<Employee> employees) {
		this.employees = new ArrayList<>(employees);
	}
	/**
	 * This method returns the array list of reservation objects in the reservations field.
	 * @return A new array list containing reservation objects.
	 */
	public ArrayList<Reservation> getReservations(){
		return new ArrayList<>(reservations);
	}
	/**
	 * This method sets the array list of reservation objects to the passed in array list.
	 * @param reservations The passed in array list.
	 */
	public void setReservations(ArrayList<Reservation> reservations) {
		this.reservations = new ArrayList<>(reservations);
	}
	/**
	 * This method returns a String indicating the state of the objects fields.
	 * @return A string with the values in the objects flight array list, employees array list, and reservation array list.
	 */
	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append("Flights:\n");
		for(Flight flight : flights) 
			str.append(flight).append("\n");
		str.append("Employees:\n");
		for(Employee employee : employees)
			str.append(employee).append("\n");
		str.append("Reservations:\n");
		for(Reservation reservation : reservations)
			str.append(reservation).append("\n");
		return str.toString();
	}
	/**
	 * This method adds the passed in new flight object to the flight array list, if the flight does not already exist. However, if the flight already exists 
	 * it throws a FlightExistsException.
	 * @param flight The flight object that is trying to be added to the flight array list.
	 */
	public void addFlight(Flight flight) {
		if(flights.contains(flight)) {
			throw new FlightExistsException("Flight with number " + flight.getFlightNumber() + " alreadyExists");
		}else {
			flights.add(flight);
		}
	}
	/**
	 * This method creates a flight object with the passed in values (of all Strings or ints) and then adds the new flight object to the flight array list, if the flight does not
	 *  already exist. However, if the flight already exists it throws a FlightAlreadyExistsException.
	 * @param flightNumber The passed in value for the flight objects flight number.
	 * @param departureCity The passed in value for the flight objects departure city.
	 * @param destinationCity The passed in value for the flight objects destination city. 
	 * @param departureTime The passed in value for the flight objects departure time as a String.
	 * @param arrivalTime The passed in value for the flight objects arrival time as a String.
	 */
	/**
	 */
	public void addFlight(int flightNumber, String departureCity, String destinationCity, String departureTime, String arrivalTime) {
		Flight flight = new Flight(flightNumber,departureCity,destinationCity,departureTime,arrivalTime);
		addFlight(flight);
	}
	/**
	 * 
	 * This method creates a flight object with the passed in values (of Strings, ins, and LocalDateTime objetcs) and then adds the new flight object 
	 * to the flight array list, if the flight does not already exist. However, if the flight already exists it throws a FlightAlreadyExistsException.
	 * @param flightNumber The passed in value for the flight objects flight number.
	 * @param departureCity The passed in value for the flight objects departure city.
	 * @param destinationCity The passed in value for the flight objects destination city. 
	 * @param departureTime The passed in value for the flight objects departure time as a LocalDateTime object.
	 * @param arrivalTime The passed in value for the flight objects arrival time as a LocalDateTime object.
	 */
	public void addFlight(int flightNumber, String departureCity, String destinationCity, LocalDateTime departureTime, LocalDateTime arrivalTime) {
		Flight flight = new Flight(flightNumber,departureCity,destinationCity,departureTime,arrivalTime);
		addFlight(flight);
	}
	/**
	 * This method adds a reservation object to the reservation array list.
	 * @param reservation The reservation object to be added.
	 */
	public void bookReservation(Reservation reservation) {
		reservations.add(reservation);
	}
	/**
	 * This method checks if a reservation object is found and if so it removes the reservation object from the array list of reservations.
	 * @param bookingReference The reservation objects booking reference, to check if the reservation already exists.
	 */
	public void cancelReservation(int bookingReference){
		Reservation reservationToRemove = null;
		boolean found = false;
		for(Reservation reservation : reservations) {
			if(reservation.getPassenger().getBookingReference() == bookingReference) {
				reservationToRemove = reservation;
				found = true;
				break;
			}
		}
		if(found) {
			reservations.remove(reservationToRemove);
		}else {
			throw new ReservationNotFoundException("The reservation with the booking reference " + bookingReference + " was not found.");
		}
	}
	/**
	 * This reservation returns a flight object based on the passed in flight number. If it is not found it returns null.
	 * @param flightNumber The passed in flight number to search for the flight object.
	 * @return The found flight object or null.
	 */
	public Flight flightInformation(int flightNumber) {
		for(Flight flight : flights) {
			if(flight.getFlightNumber() == flightNumber)
				return flight;
		}
		return null;
	}
	/**
	 * This reservation returns a passenger object based on the passed in booking reference. If it is not found it returns null.
	 * @param bookingReference The passed in booking reference to search for the passenger object.
	 * @return The found passenger object or null.
	 */
	public Passenger passengerInformation(int bookingReference) {
		for(Reservation reservation : reservations) {
			if(reservation.getPassenger().getBookingReference() == bookingReference) 
				return reservation.getPassenger();
		}
		return null;
	}
	/**
	 * This method adds an employee object to the array list of employees if an employee with the same id is not already on the array list. If the employee 
	 * object is then the method will throw an EmployeeExistsException.
	 * @param employee The employee object that is being added.
	 */
	public void addEmployee(Employee employee) {
		if(employees.contains(employee)) {
			throw new EmployeeExistsException("Employee with ID " + employee.getEmployeeID() + " already exists.");
		}else {
			employees.add(employee);
		}
	}
	/**
	 * This method creates an employee object based on the passed in fields and then goes to the addEmployee() method to verify and add the employee
	 * object to the array list of employees.
	 */
	public void addEmployee(String f, String l, Gender g, Address addr, String birthdate, String employeeID,
			String employeeType, String department) {
		Employee employee = new Employee(f,l,g,addr,birthdate, employeeID, employeeType, department);
		addEmployee(employee);
	}
	/**
	 * This method returns an employee object found based on the passed in values of the employees ID. If the employee object is not found the method will
	 * return null.
	 * @param employeeID The passed in value for the employee ID to help search for the employee object.
	 * @return
	 */
	public Employee employeeInformation(String employeeID) {
		for(Employee employee : employees) {
			if(employee.getEmployeeID().equals(employeeID)) 
				return employee;
		}
		return null;
	}
	
	
	
	
}
