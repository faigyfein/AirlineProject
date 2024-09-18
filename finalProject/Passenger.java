package finalProject;

public class Passenger extends Person{
	private int bookingReference;
	private String passportNumber;
	private String nationality;
	/**
	 * Constructs a Passenger object using the passed values to first create a Person object and then a Passenger object.
	 * @param f Passed in value for Person object first name.
	 * @param l Passed in value for Person object last name.
	 * @param g Passed in value for Person object gender.
	 * @param addr Passed in value for Person object's address.
	 * @param birthdate Passed in String value for Person object's birthdate.
	 * @param bookingReference Passed in value for bookingReference field.
	 * @param passportNumber Passed in value for passportNumber reference field.
	 * @param nationality Passed in value for nationality field.
	 */
	public Passenger(String f, String l, Gender g, Address addr, String birthdate, int bookingReference, String passportNumber,
			String nationality) {
		super(f,l,g,addr,birthdate);
		this.passportNumber = passportNumber;
		this.nationality = nationality;
	}
	/**
	 * Copy constructor, creates a deep copy of a Passenger object.
	 * @param p The Passenger object that to be copied.
	 */
	public Passenger(Passenger p) {
		this(p.getFirstName(), p.getLastName(),p.getGender(),p.getAddress(), p.getBirthdate().toString(), p.bookingReference, 
				p.passportNumber, p.nationality);
	}
	/**
	 * Sets the bookingReference field.
	 * @param bookingReference The passed in value for the booking reference field.
	 */
	public void setBookingReference(int bookingReference) {
		this.bookingReference = bookingReference;
	}
	/**
	 * Sets the passportNumber field.
	 * @param passportNumber The passed in value for the passportNumber field.
	 */
	public void setPassportNumber(String passportNumber) {
		this.passportNumber = passportNumber;
	}
	/**
	 * Sets the nationality field.
	 * @param nationality The passed in value for the nationality field.
	 */
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	/**
	 * Returns the value in the bookingReference field.
	 * @return The objects bookingReference.
	 */
	public int getBookingReference() {
		return bookingReference;
	}
	/**
	 * Returns the value in the passportNumber field.
	 * @return The objects passportNumber.
	 */
	public String getPassportNumber() {
		return passportNumber;
	}
	/**
	 * Returns the value in the nationality field.
	 * @return The objects nationality.
	 */
	public String getNationality() {
		return nationality;
	}
	/**
	 * This method returns a String value indicating the object fields status.
	 * @return A string indicating the Passenger Person object details, the Passengers booking reference, passport number, and nationality.
	 */
	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append("\n").append(super.toString());
		str.append("\nBooking Reference: ").append(bookingReference);
		str.append("\nPassport Number: ").append(passportNumber);
		str.append("\nNationality: ").append(nationality);
		return str.toString();
	}
	/**
	 * This method checks to see if two Passenger objects are equal to each other by comparing their passport Numbers.
	 * @return True if the two Passenger objects are equal to each other, false if they are not.
	 */
	@Override
	public boolean equals (Object o) {
		if(this == o)
			return true;
		if(o == null)
			return false;
		if(!(o instanceof Passenger))
			return false;
		Passenger other = (Passenger)o;
		if(passportNumber == null) {
			if(other.passportNumber != null)
				return false;
		}else if(!passportNumber.equals(other.passportNumber))
			return false;
		return true;
	}
}
