package finalProject;
import java.time.*;

public class Reservation {
	private Flight flight;
	private Passenger passenger;
	private BookingStatus bookingStatus;
	private LocalDate reservationDate;
	/**
	 * Constructs a Reservation object using the passed in objects and values.
	 * @param flight The passed in Flight object.
	 * @param passenger The passed in Passenger object.
	 * @param bookingStatus The passed in bookingStatus enum.
	 * @param reservationDate The passed in reservationDate as a LocalDate object.
	 */
	public Reservation(Flight flight, Passenger passenger, BookingStatus bookingStatus, LocalDate reservationDate) {
		this.flight = new Flight(flight);
		this.passenger = new Passenger(passenger);
		this.bookingStatus = bookingStatus;
		this.reservationDate = reservationDate;
	}
	/**
	 * Constructs a Reservation object using the passed in objects and values, converting the String into a LocalDate object.
	 * @param flight The passed in Flight object.
	 * @param passenger The passed in Passenger object.
	 * @param bookingStatus The passed in BookingStatus enum.
	 * @param reservationDate The string value to be converted to a LocalDate object.
	 */
	public Reservation(Flight flight, Passenger passenger, BookingStatus bookingStatus, String reservationDate) {
		this(new Flight(flight), new Passenger(passenger), bookingStatus, LocalDate.parse(reservationDate));
	}
	/**
	 * Copy constructor, creates a deep copy of a Reservation object.
	 * @param other The Reservation object to be copied.
	 */
	public Reservation(Reservation other) {
		this(other.flight, other.passenger, other.bookingStatus, other.reservationDate);
	}
	/**
	 * Constructs a Reservation object using the passed in values and LocalDate objects, creating Flight and Passenger objects.
	 * @param flightNumber The flightNumber for the Flight object.
	 * @param departureCity The departureCity for the Flight object. 
	 * @param destinationCity The destinationCity for the Flight object.
	 * @param departureTime The departureTime for the Flight object.
	 * @param arrivalTime The arrivalTime for the Flight object.
	 * @param f The firstName for the Passenger object.
	 * @param l The lastName for the Passenger object.
	 * @param g The gender for the Passenger object.
	 * @param addr The address for the Passenger object.
	 * @param birthdate The birthdate for the Passenger object.
	 * @param bookingReference The in booking reference for the Passenger object. 
	 * @param passportNumber The passport number for the Passenger object.
	 * @param nationality The nationality for the Passenger object.
	 * @param bookingStatus The BookingStatus enum.
	 * @param reservationDate The reservation date as a LocalDate object.
	 */
	public Reservation(int flightNumber, String departureCity, String destinationCity, LocalDateTime departureTime,LocalDateTime arrivalTime, 
			String f, String l, Gender g, Address addr, String birthdate, int bookingReference, String passportNumber, String nationality, 
			BookingStatus bookingStatus, LocalDate reservationDate) {
		this(new Flight(flightNumber, departureCity, destinationCity, departureTime, arrivalTime), new Passenger(f, l, g, addr, birthdate, bookingReference, 
				passportNumber, nationality), bookingStatus, reservationDate);
	}
	/**
	 * Constructs a Reservation object using the passed in values, creating Flight and Passenger objects and converting 
	 * some Strings to LocalDate objects.
	 * @param flightNumber The passed in flightNumber for the Flight object.
	 * @param departureCity The passed in departureCity for the Flight object. 
	 * @param destinationCity The passed in destinationCity for the Flight object.
	 * @param departureTime The passed in departureTime for the Flight object.
	 * @param arrivalTime The passed in arrivalTime for the Flight object.
	 * @param f The passed in firstName for the Passenger object.
	 * @param l The passed in lastName for the Passenger object.
	 * @param g The passed in gender for the Passenger object.
	 * @param addr The passed in address for the Passenger object.
	 * @param birthdate The passed in birthdate for the Passenger object.
	 * @param bookingReference The passed in booking reference for the Passenger object. 
	 * @param passportNumber The passed in passport number for the Passenger object.
	 * @param nationality The passed in nationaity for the Passenger object.
	 * @param bookingStatus The passed in bookingStatus enum.
	 * @param reservationDate The passed in reservation date as a String.
	 */
	public Reservation(int flightNumber, String departureCity, String destinationCity, LocalDateTime departureTime,LocalDateTime arrivalTime, 
			String f, String l, Gender g, Address addr, String birthdate, int bookingReference, String passportNumber, String nationality, 
			BookingStatus bookingStatus, String reservationDate) {
		this(new Flight(flightNumber, departureCity, destinationCity, departureTime, arrivalTime), new Passenger(f, l, g, addr, birthdate, bookingReference, 
				passportNumber, nationality), bookingStatus, LocalDate.parse(reservationDate));
	}
	/**
	 * Sets the flight field to the passed in Flight object.
	 * @param flight The passed in Flight object.
	 */
	public void setFlight(Flight flight) {
		this.flight = new Flight(flight);
	}
	/**
	 * Sets the flight field to the passed in values, creating a Flight object.
	 * @param flightNumber The passed in flightNumber.
	 * @param departureCity The passed in departureCity.
	 * @param destinationCity The passed in destinationCity.
	 * @param departureTime The passed in departureTime as a LocalDateTime object.
	 * @param arrivalTime The passed in arrivalTime as a LocalDateTime object.
	 */
	public void setFlight(int flightNumber, String departureCity, String destinationCity, LocalDateTime departureTime,LocalDateTime arrivalTime) {
		this.flight = new Flight(flightNumber, departureCity, destinationCity, departureTime, arrivalTime);
	}
	/**
	 * Returns the Flight object in the flight field.
	 * @return The Flight object in the flight field.
	 */
	public Flight getFlight() {
		return new Flight(flight);
	}
	/**
	 * Sets the passenger field to the passed in Passenger object.
	 * @param passenger The passed in Passenger object.
	 */
	public void setPassenger(Passenger passenger) {
		this.passenger = new Passenger(passenger);
	}
	/**
	 * Sets the passenger field to the passed in values, creating a Passenger object.
	 * @param f The passed in first name.
	 * @param l The passed in last name.
	 * @param g The passed in gender.
	 * @param addr The passed in address.
	 * @param birthdate The passed in birthdate.
	 * @param bookingReference The passed in booking reference.
	 * @param passportNumber The passed in passport number.
	 * @param nationality The passed in nationality.
	 */
	public void setPassenger(String f, String l, Gender g, Address addr, String birthdate, int bookingReference, String passportNumber, String nationality) {
		this.passenger = new Passenger(f,l,g,addr,birthdate,bookingReference,passportNumber,nationality);
	}
	/**
	 * Returns the Passenger object in the passenger field.
	 * @return The Passenger object in the passenger field.
	 */
	public Passenger getPassenger() {
		return new Passenger(passenger);
	}
	/**
	 * Sets the bookingStatus field to the passed in enum value.
	 * @param bookingStatus The passed in enum value.
	 */
	public void setBookingStatus(BookingStatus bookingStatus){
		this.bookingStatus = bookingStatus;
	}
	/**
	 * Returns the enum value in the bookingStatus field.
	 * @return The enum value in the bookingStatus field.
	 */
	public BookingStatus getBookingStatus() {
		return bookingStatus;
	}
	/**
	 * Sets the reservationDate field to the passed in LocalDate object
	 * @param reservationDate The passed in LocalDate object.
	 */
	public void setReservationDate(LocalDate reservationDate) {
		this.reservationDate = reservationDate;
	}
	/**
	 * Sets the reservationDate field to the passed in String, first converting it to a LocalDate object.
	 * @param reservationDate The passed in String.
	 */
	public void setReservationDate(String reservationDate) {
		this.reservationDate = LocalDate.parse(reservationDate);
	}
	/**
	 * Returns the LocalDate object in the reservationDate field.
	 * @return The LocalDate object in the reservationDate field.
	 */
	public LocalDate getReservationDate() {
		return reservationDate;
	}
	/**
	 * 
	 * @param o
	 * @return
	 */
	@Override
	public boolean equals(Object o) {
		if(this == o)
			return true;
		if(o == null)
			return false;
		if(!(o instanceof Reservation))
			return false;
		Reservation other = (Reservation)o;
		if(this.passenger.getBookingReference() != other.passenger.getBookingReference()) {
			return false;
		}
		return true;
	}

	/**
	 * Returns a string representing the object's field statuses.
	 * @return A string indicating the Reservation object's Flight object details, Passenger object details, booking status, and reservation date.
	 */
	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append(flight);
		str.append(passenger);
		str.append("\nBooking Status: ").append(bookingStatus);
		str.append("\nReservation Date: ").append(reservationDate);
		return str.toString();
	}
}
