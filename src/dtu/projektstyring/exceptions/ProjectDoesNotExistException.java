package dtu.projektstyring.exceptions;

public class ProjectDoesNotExistException extends Exception {
	public String getMessage() {
		return "Project with specified ID does not exist";
	}
}
