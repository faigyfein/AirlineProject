package finalProject;

public class ReservationNotFoundException extends RuntimeException{
	/**
	 * Constructs a new ReservationNotFoundException with the default message.
	 */
	public  ReservationNotFoundException() {
		super("This reservation could not be found.");
	}
	/**
	 * Constructs a new ReservationNotFoundException with a custom error message.
	 * @param message The message explaining the exception.
	 */
	public  ReservationNotFoundException(String message) {
		super(message);
	}
}

