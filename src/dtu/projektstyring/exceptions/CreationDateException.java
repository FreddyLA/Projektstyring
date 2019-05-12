package dtu.projektstyring.exceptions;

public class CreationDateException extends Exception {
	
	public String getMessage() {
		return "Project start/end date cannot be before the project creation date";
	}
}
