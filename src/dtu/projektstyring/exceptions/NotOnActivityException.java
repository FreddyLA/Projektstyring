package dtu.projektstyring.exceptions;

public class NotOnActivityException extends Exception {
	public String getMessage() {
		return "Specified user is not assigned to the activity";
	}
}
