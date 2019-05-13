package dtu.projektstyring.exceptions;

public class EmptyNameException extends Exception {
	public String getMessage() {
		return "Can't create a object with no name";
	}
}
