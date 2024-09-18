package finalProject;
import java.time.*;
public class Flight {

	private int flightNumber;
	private String departureCity;
	private String destinationCity;
	private LocalDateTime departureTime;
	private LocalDateTime arrivalTime;
	/**
	 * Constructs a Flight object with the passed in values, with the times as LocalDateTime objects. Validates that the arrival time is after the departure time and that the departure city is 
	 * different than the destination city. If either are not it throws the exceptions InvalidTimeException or the InvalidFlightRouteException.
	 * @param flightNumber The passed in value for the flightNumber field.
	 * @param departureCity The passed in value for the destinationCity field.
	 * @param destinationCity The passed in value for the destinationCity field.
	 * @param departureTime The passed in value for the departureTime field as a LocalDateTime object.
	 * @param arrivalTime The passed in value for the arrivalTime field as a LocalDateTime object.
	 * @throws InvalidTimeException If arrival time is not after departure time.
     * @throws InvalidFlightRouteException If departure city is the same as destination city.
	 */
	public Flight(int flightNumber, String departureCity, String destinationCity, LocalDateTime departureTime, LocalDateTime arrivalTime) {
		if(departureTime.isAfter(arrivalTime))
			throw new InvalidTimeException("The arrival time must be after the departure time.");
		if(departureCity.equals(destinationCity))
			throw new InvalidFlightRouteException("The departure city must be different then the destination city.");
		this.flightNumber = flightNumber;
		this.departureCity = departureCity;
		this.destinationCity = destinationCity;
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
	}
	/**
	 * Constructs a Flight object with the passed in values, with the times passed in as Strings and converted to LocalDateTime objects. Validates that 
	 * the arrival time is after the departure time and that the departure city is different than the destination city. If either are not it throws the 
	 * exceptions InvalidTimeException or the InvalidFlightRouteException.
	 * @param flightNumber The passed in value for the flightNumber field.
	 * @param departureCity The passed in value for the destinationCity field.
	 * @param destinationCity The passed in value for the destinationCity field.
	 * @param departureTime The passed in value for the departureTime field as a String value.
	 * @param arrivalTime The passed in value for the arrivalTime field as a String value.
	 * @throws InvalidTimeException If arrival time is not after departure time.
     * @throws InvalidFlightRouteException If departure city is the same as destination city.
	 */
	public Flight(int flightNumber, String departureCity, String destinationCity, String DepartureTime, String ArrivalTime) {
		this(flightNumber, departureCity, destinationCity, LocalDateTime.parse(DepartureTime), LocalDateTime.parse(ArrivalTime));
	}
	/**
	 * Copy constructor, creates a deep copy of a Flight object.
	 * @param other The Flight object to be copied.
	 */
	public Flight(Flight other) {
		this(other.flightNumber, other.departureCity, other.destinationCity, other.departureTime,other.arrivalTime);
	}
	/**
	 * This method sets the flightNumber field to the passed in value.
	 * @param flightNumber The passed in value for the flightNumber field.
	 */
	public void setFlightNumber(int flightNumber){
		this.flightNumber = flightNumber;
	}
	/**
	 * This method returns the fieldNumber value.
	 * @return The fieldNumber value.
	 */
	public int getFlightNumber() {
		return flightNumber;
	}
	/**
	 * This method sets the departureCity field to the passed in value after validating that the departure city is different from the destination city. If
	 * they are the same then it throws a InvalidFlightRouteException.
	 * @param departureCity The passed in value for the departureCity field.
	 * @throws InvalidFlightRouteException If departure city is the same as destination city.
     */
	public void setDepartureCity(String departureCity) {
		if(destinationCity != null && departureCity.equals(destinationCity)) {
				throw new InvalidFlightRouteException("The departure city must be different then the destination city.");
		}
		this.departureCity = departureCity;
	}
	/**
	 * This method returns the value in the departureCity field.
	 * @return The value in the departureCity field.
	 */
	public String getDepartureCity() {
		return departureCity;
	}
	/**
	 * This method sets the destination city field to the passed in value after validating that it is different than the departure city. If it is the same
	 * then it throws an InvalidFlightRouteException.
	 * @param destinationCity The passed in value.
	 * @throws InvalidFlightRouteException If destination city is the same as departure city.
     */
	public void setDestinationCity(String destinationCity) {
		if(departureCity != null && departureCity.equals(destinationCity)) {
				throw new InvalidFlightRouteException("The departure city must be different then the destination city.");
		}
		this.destinationCity = destinationCity;
	}
	/**
	 * This method returns the value in the destinationCity field.
	 * @return The destination city.
	 */
	public String getDestinationCity() {
		return destinationCity;
	}
	/**
	 * This method sets the departureTime field to the passed in LocalDateTime object after validating that it is before the arrival time. If it is not
	 * then it throws an InvalidTimeException.
	 * @param departureTime The passed in LocalDateTime object.
	 * @throws InvalidTimeException If departure time is not before arrival time.
     */
	public void setDepartureTime(LocalDateTime departureTime) {
		if(arrivalTime != null) {
			if(departureTime.isAfter(arrivalTime))
				throw new InvalidTimeException("The departure time must be before the arrival time.");
		}
		this.departureTime = departureTime;
	}
	/**
	 * This method sets the departureTime field to the passed in String value, first converting the String to a LocalDateTime object, and validating that
	 * it is before the arrival time. If it is not then it throws an InvalidTimeExcpetion.
	 * @param departureTime The passed in string value.
	 * @throws InvalidTimeException If departure time is not before arrival time.
     */
	public void setDepartureTime(String sDepartureTime) {
		LocalDateTime newDepartureTime = LocalDateTime.parse(sDepartureTime);
		if(arrivalTime != null && newDepartureTime.isAfter(arrivalTime)) {
				throw new InvalidTimeException("The departure time must be before the arrival time.");
		}
		this.departureTime = newDepartureTime;
	}
	/**
	 * This method returns the LocalDateTime object in the departureTime field.
	 * @return The LocalDateTime object in the departureTime field.
	 */
	public LocalDateTime getDepartureTime() {
		return departureTime;
	}
	/**
	 * This method sets the arrivalTime field to the passed in LocalDateTime object after validating that it is after the departureTime. If it is not then
	 * it throws an InvalidTimeException.
	 * @param arrivalTime The passed in LocalDateTime object.
	 * @throws InvalidTimeException If arrival time is not after departure time.
     */
	public void setArrivalTime(LocalDateTime arrivalTime) {
		if(departureTime != null && departureTime.isAfter(arrivalTime)) {
				throw new InvalidTimeException("The arrival time must be after the departure time.");
		}
		this.arrivalTime = arrivalTime;
	}
	/**
	 * This method sets the arrivalTime field to the passed in String value, first converting the String to a LocalDateTime object, and validating that
	 * the arrival time is after the departure time. If it is not it throws an InvalidTimeException.
	 * @param arrivalTime The passed in string value.
	 * @throws InvalidTimeException If arrival time is not after departure time.
     */
	public void setArrivalTime(String sArrivalTime) {
		LocalDateTime newArrivalTime = LocalDateTime.parse(sArrivalTime);
		if(departureTime != null && departureTime.isAfter(newArrivalTime)) {
				throw new InvalidTimeException("The arrival time must be after the departure time.");
		}
		this.arrivalTime = newArrivalTime;
	}
	/**
	 * This method returns a String indicating the status of the Flight object fields.
	 * @return The String indicating the Flight objects flightNumber, departureCity, destinationCity, departureTime, and arrivalTime.
	 */
	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append("Flight Number: ").append(flightNumber);
		str.append("\nDeparture City: ").append(departureCity);
		str.append("\nDestination City: ").append(destinationCity);
		str.append("\nDeparture Time: ").append(departureTime);
		str.append("\nArrival Time: ").append(arrivalTime);
		return str.toString();
	} 
	/**
	 * This method checks to see if two Flight objects are equal to each other based on the flightNumbers.
	 * @param obj The object to compare with.
	 * @return True if the two Flight objects are equal or false if they are not equal.
	 */
	@Override
	public boolean equals(Object obj) {
		if(this == obj)
			return true;
		if(obj == null)
			return false;
		if(!(obj instanceof Flight))
				return false;
		Flight other = (Flight)obj;
		if(this.flightNumber != other.flightNumber)
			return false;
		return true;
	}
	
}
