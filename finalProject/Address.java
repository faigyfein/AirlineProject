package finalProject;

public class Address {
	private String street;
	private String city;
	private String state;
	private String zipcode;
	/**
	 * Constructs a Address object with the passed in values for the street, city, state, and zip fields.
	 * @param street The passed in value for the street field.
	 * @param city The passed in value for the city field.
	 * @param state The passed in value for the state field.
	 * @param zip The passed in value for the zipcode field.
	 */
	public Address(String street, String city, String state, String zip) {
		if(street == null || street.isEmpty() ||
			city == null || city.isEmpty() ||
			state == null || state.isEmpty() ||
			zip == null || zip.isEmpty()){ 
			throw new IllegalArgumentException("All fields must be non-null and non-empty.");
		}
		this.street = street;
		this.city = city;
		this.state = state;
		this.zipcode = zip;
	}
	/**
	 * Copy constructor, deep copies the field of one Address object into another Address object. 
	 * @param other The Address copy that is being copied.
	 */
	public Address(Address other) {
		this(other.street, other.city, other.state, other.zipcode);
	}
	/**
	 * Returns the value in the street field.
	 * @return The objects street name.
	 */
	public String getStreet() {
		return street;
	}
	/**
	 * Returns the value in the city field.
	 * @return The objects city name.
	 */
	public String getCity() {
		return city;
	}
	/**
	 * Returns the value in the state field.
	 * @return The objects states name.
	 */
	public String getState() {
		return state;
	}
	/**
	 * Returns the value in the zipcode field.
	 * @return The objects zipcode.
	 */
	public String getZip() {
		return zipcode;
	}
	/**
	 * Returns a String representing the state of the objects fields.
	 * @return A string indicating the objects street, city, state, and zipcode.
	 */
	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append("\nStreet: ").append(street);
		str.append("\n City: ").append(city);
		str.append("\nState: ").append(state);
		str.append("\nZipcode: ").append(zipcode);
		return str.toString();
	}
}
