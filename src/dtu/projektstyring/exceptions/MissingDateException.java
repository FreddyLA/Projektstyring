package dtu.projektstyring.exceptions;

public class MissingDateException extends Exception {
	public String getMessage() {
		return "Activity doesn't have a start/enddate";
	}
}
