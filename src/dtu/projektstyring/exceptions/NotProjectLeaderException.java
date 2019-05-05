package dtu.projektstyring.exceptions;

public class NotProjectLeaderException extends Exception {
	public String getMessage() {
		return "Action for project leader only";
	}
}
