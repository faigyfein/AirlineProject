package finalProject;

public class EmployeeExistsException extends RuntimeException{
	/**
	 * Constructs a new EmployeeExistsException with the default message.
	 */
	public EmployeeExistsException() {
		super("This employee already exists.");
	}
	/**
	 * Constructs a new EmployeeExistsException with a custom error message.
	 * @param message The message explaining the exception.
	 */
	public EmployeeExistsException(String message) {
		super(message);
	}
}
