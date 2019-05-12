package dtu.projektstyring.exceptions;

public class PrivateActivityDuringWorkActivityException extends Exception {
	public String getMessage() {
		return "Private activity not allowed during work activity";
	}
}
