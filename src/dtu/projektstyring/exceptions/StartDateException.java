package dtu.projektstyring.exceptions;

public class StartDateException extends Exception {
	public String getMessage() {
		return "Deadline cannot be before the assigned start date";
	}
}
