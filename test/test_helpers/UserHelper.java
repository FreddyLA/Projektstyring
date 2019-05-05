package test_helpers;

import dtu.projektstyring.app.Developer;

public class UserHelper {
	private Developer developer, developer2, developer3;
	
	public Developer getUser() {
		if (developer == null) {
			developer = exampleDeveloper();
		}
		return developer;
	}
	
	public Developer getUser2() {
		if (developer2 == null) {
			developer2 = exampleDeveloper2();
		}
		return developer2;
	}
	
	public Developer getUser3() {
		if (developer3 == null) {
			developer3 = exampleDeveloper3();
		}
		return developer3;
	}
	
	private Developer exampleDeveloper() {
		Developer developer = new Developer("John Doe", "JDO");
		return developer;
	}
	private Developer exampleDeveloper2() {
		Developer developer = new Developer("Mark Tres", "MTR");
		return developer;
	}
	private Developer exampleDeveloper3() {
		Developer developer = new Developer("Judas Quatre", "JQT");
		return developer;
	}
}
