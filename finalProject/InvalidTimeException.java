package finalProject;

public class InvalidTimeException extends RuntimeException{
	/**
	 * Constructs a new InvalidTimeException with the default message.
	 */
	public InvalidTimeException() {
		super("Invalid Time");
	}
	/**
	 * Constructs a new InvalidTimeException with a custom error message.
	 * @param message The message explaining the exception.
	 */
	public InvalidTimeException(String message) {
		super(message);
	}
}
