package finalProject;

public class PassengerNotFoundException extends RuntimeException{
	/**
	 * Constructs a new InvalidFlightRouteException with the default message.
	 */
	public PassengerNotFoundException() {
		super("This passenger was not found.");
	}
	/**
	 * Constructs a new InvalidFlightRouteException with a custom error message.
	 * @param message The message explaining the exception.
	 */
	public PassengerNotFoundException(String message) {
		super(message);
	}
}
