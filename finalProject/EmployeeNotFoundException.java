package finalProject;

public class EmployeeNotFoundException extends RuntimeException{
	/**
	 * Constructs a new InvalidFlightRouteException with the default message.
	 */
	public EmployeeNotFoundException() {
		super("This employee was not found.");
	}
	/**
	 * Constructs a new InvalidFlightRouteException with a custom error message.
	 * @param message The message explaining the exception.
	 */
	public EmployeeNotFoundException(String message) {
		super(message);
	}
}
