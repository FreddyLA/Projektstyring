package dtu.projektstyring.exceptions;

public class ActivityDoesNotExistException extends Exception {
	public String getMessage() {
		return "Activity with specified name does not exist";
	}
}
