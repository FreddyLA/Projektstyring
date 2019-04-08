package dtu.projektstyring.acceptance_tests;

import dtu.projektstyring.app.Developer;

public class UserHelper {
	private Developer developer;
	
	public Developer getUser() {
		if (developer == null) {
			developer = exampleDeveloper();
		}
		return developer;
	}
	
	private Developer exampleDeveloper() {
		Developer developer = new Developer("John Doe", "JDO");
		return developer;
	}
}
