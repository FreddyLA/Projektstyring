package dtu.projektstyring.exceptions;

public class DeveloperDoesNotExistException extends Exception {
	public String getMessage() {
		return "Developer with specified initials does not exist";
	}
}
