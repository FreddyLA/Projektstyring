package dtu.projektstyring.exceptions;

public class PrivateActivityDuringWorkActivityException extends Exception {
	public String getMessage() {
		return "Can't register personal activity, when worker has an activity";
	}
}
