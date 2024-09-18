package finalProject;

public class InvalidFlightRouteException extends RuntimeException{
	/**
	 * Constructs a new InvalidFlightRouteException with the default message.
	 */
	public InvalidFlightRouteException() {
		super("This flight route in invalid.");
	}
	/**
	 * Constructs a new InvalidFlightRouteException with a custom error message.
	 * @param message The message explaining the exception.
	 */
	public InvalidFlightRouteException(String message) {
		super(message);
	}
}
