package finalProject;

public class Employee extends Person{
	private String employeeID;
	private String employeeType;
	private String department;
	
	/**
	 * Constructs an Employee object with the passed in values, first by creating a Person object and with that creating an Employee object.
	 * @param f Passed in value for Person object first name.
	 * @param l Passed in value for Person object last name.
	 * @param g Passed in value for Person object gender.
	 * @param addr Passed in value for Person object's address.
	 * @param birthdate Passed in String value for Person object's birthdate.
	 * @param employeeID Passed in value for employeeID.
	 * @param employeeType Passed in value for employeeType.
	 * @param department Passed in value for department.
	 */
	public Employee(String f, String l, Gender g, Address addr, String birthdate, String employeeID,
			String employeeType, String department) {
		super(f,l,g,addr,birthdate);
		this.employeeID = employeeID;
		this.employeeType = employeeType;
		this.department = department;
	}
	/**
	 * Copy constructor, creates a deep copy of an Employee object.
	 * @param e The Employee object to be copied.
	 */
	public Employee(Employee e) {
		this(e.getFirstName(),e.getLastName(),e.getGender(), e.getAddress(), e.getBirthdate().toString(),
				e.employeeID, e.employeeType, e.department);
	}
	/**
	 * This method sets the value in the employeeID field to the passed in value.
	 * @param employeeID The passed in value for the employeeID.
	 */
	public void setEmployeeID(String employeeID) {
		this.employeeID = employeeID;
	}
	/**
	 * This method sets the value in the employeeType field to the passed in value.
	 * @param employeeType The passed in value for the employeeType.
	 */
	public void setEmployeeType(String employeeType) {
		this.employeeType = employeeType;
	}
	/**
	 * This method sets the value in the department field to the passed in value.
	 * @param department The passed in value for the department field.
	 */
	public void setDepartment(String department) {
		this.department = department;
	}
	/**
	 * This method returns the value in the employeeID field.
	 * @return The value in the employeeID field.
	 */
	public String getEmployeeID() {
		return employeeID;
	}
	/**
	 * This method returns the value in the department field.
	 * @return The value in the department field.
	 */
	public String getDepartment() {
		return department;
	}
	/**
	 * This method returns the value in the employeeType field.
	 * @return The value in the employeeType field.
	 */
	public String getEmployeeType() {
		return employeeType;
	}
	/**
	 * This method returns a String indicating the state of the Employee objects fields.
	 * @return A String indicating the Employees Person object details, and the Employees emploeeID, employeeType, and department.
	 */
	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append("Employee: " );
		str.append("\n").append(super.toString());
		str.append("\nEmployee ID: ").append(employeeID);
		str.append("\nEmployee Type: ").append(employeeType);
		str.append("\nDepartment: ").append(department);
		return str.toString();
	}
	/**
	 * This method checks to see if one Employee object is equal to another Employee object by comparing the employee IDs. If they are equal then the
	 * method returns true, and if not the method returns false.
	 * @return True if the Employee objects are equal and false if the Employee objects are different.
	 */
	@Override
	public boolean equals(Object o) {
		if(this == o)
			return true;
		if(o == null)
			return false;
		if(!(o instanceof Employee)) 
			return false;
		Employee other = (Employee)o;
		if(employeeID == null) {
			if(other.employeeID != null)
				return false;
		}else if(!employeeID.equals(other.employeeID))
			return false;
		return true;
	}
}
