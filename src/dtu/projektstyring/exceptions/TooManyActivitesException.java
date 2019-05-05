package dtu.projektstyring.exceptions;

public class TooManyActivitesException extends Exception {
	public String getMessage() {
		return "Selected development worker already assigned to 10 activities";
	}
}
