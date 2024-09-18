package finalProject;
import java.time.*;
public class Person {
	private String firstName;
	private String lastName;
	private Gender gender;
	private Address address;
	private LocalDate birthdate;
	/**
	 * Constructs a Person object with the passed in values, converting the string birthdate to a LocalDate object.
	 * @param f Passed in value for the firstName field.
	 * @param l Passed in value for the lastName field.
	 * @param g Passed in value for the gender field.
	 * @param add Passed in object for the address field.
	 * @param birthdate Passed in string value for the birthdate field.
	 */
	public Person(String f, String l, Gender g, Address add, String birthdate) {
		this(f, l, g, add, LocalDate.parse(birthdate));
	}
	/**
	 * Constructs a Person object with the passed in values.
	 * @param f Passed in value for the firstName field.
	 * @param l Passed in value for the lastName field.
	 * @param g Passed in value for the gender field.
	 * @param s Passed in street value for the address object.
	 * @param c Passed in city value for the address object.
	 * @param state Passed in state value for the address object.
	 * @param zip Passed in zipcode value for the address object.
	 * @param birthdate Passed in LocalDate object for the birthdate field.
	 */
	public Person(String f, String l, Gender g, String s, String c, String state, String zip, String birthdate) {
		this(f,l,g, new Address(s,c,state,zip), LocalDate.parse(birthdate));
	}
	/**
	 * Constructs a Person object with the passed in values, using them to create an Address object.
	 * @param f Passed in value for the firstName field.
	 * @param l Passed in value for the lastName field.
	 * @param g Passed in value for the gender field.
	 * @param add Passed in object for the address field.
	 * @param birthdate Passed in LocalDate object for the birthdate field.
	 */
	public Person(String f, String l, Gender g, Address add, LocalDate birthdate) {
		firstName = f;
		lastName = l;
		gender = g;
		address = new Address(add);
		this.birthdate = birthdate;
	}
	/**
	 * Copy constructor, creates a deep copy of a Person object.
	 * @param p The Person object to be copied.
	 */
	public Person (Person p) {
		this(p.firstName, p.lastName, p.gender, p.address, p.birthdate);
	}
	/**
	 * Returns the value in the firstName field.
	 * @return The person's first name.
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * Returns the value in the lastName field.
	 * @return The person's last name.
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * Returns the value in the gender field.
	 * @return The person's gender.
	 */
	public Gender getGender() {
		return gender;
	}
	/**
	 * Returns the value in the birthdate field.
	 * @return The person's birthdate.
	 */
	public LocalDate getBirthdate() {
		return birthdate;
	}
	/**
	 * Returns the value in the address field.
	 * @return The person's address.
	 */
	public Address getAddress() {
		return new Address(address);
	}
	/**
	 * Sets the lastName field to the passed in value.
	 * @param last The passed in value for the last name.
	 */
	public void setLastName(String last) {
		lastName = last;
	}
	/**
	 * Sets the address field to the passed in value.
	 * @param add The passed in value for the address.
	 */
	public void setAddress(Address add) {
		address = new Address(add);
	}
	/**
	 * Returns a string representing the object's field statuses.
	 * @return A string indicating the Person object's first name, last name, gender, address, and birthdate.
	 */
	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append("First name: ").append(firstName).append("\nLast name: ").append(lastName);
		str.append("\nGender: ").append(gender);
		str.append("\nAddress: ").append(address);
		str.append("\nBirthdate: ").append(birthdate);
		return str.toString();
	}
	/**
	 * Checks if two Person objects are equal by comparing their first name, last name, and birthdate.
	 * @param o The object to be compared.
	 * @return True if the two Person objects are equal, false if they are not.
	 */
	@Override
	public boolean equals(Object o) {
		if(this == o)
			return true;
		if(o == null)
			return false;
		if(!(o instanceof Person))
			return false;
		Person other = (Person)o;
		if(firstName == null) {
			if(other.firstName != null)
				return false;
		}else if(!firstName.equals(other.firstName))
			return false;
		if(lastName == null) {
			if(other.lastName != null)
				return false;
		}else if(!lastName.equals(other.lastName))
			return false;
		if(birthdate == null) {
			if(other.birthdate != null)
				return false;
		}else if(!birthdate.equals(other.birthdate))
			return false;
		return true;
	}

	
	
}
