package dtu.projektstyring.exceptions;

public class DuplicateNameException extends Exception {
	
	public String getMessage() {
		return "Project with specified name already exists";
	}
}
