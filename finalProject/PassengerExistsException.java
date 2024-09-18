package finalProject;

public class PassengerExistsException extends RuntimeException{
	/**
	 * Constructs a new EmployeeExistsException with the default message.
	 */
	public PassengerExistsException() {
		super("This passenger already exists.");
	}
	/**
	 * Constructs a new EmployeeExistsException with a custom error message.
	 * @param message The message explaining the exception.
	 */
	public PassengerExistsException(String message) {
		super(message);
	}
}
