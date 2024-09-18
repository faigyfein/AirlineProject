package finalProject;

public class FlightExistsException extends RuntimeException{
	/**
	 * Constructs a new FlightExistsException with the default message.
	 */
	public FlightExistsException() {
		super("This flight already exists.");
	}
	/**
	 * Constructs a new FlightExistsException with a custom error message.
	 * @param message The message explaining the exception.
	 */
	public FlightExistsException(String message) {
		super(message);
	}
}
