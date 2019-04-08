package dtu.projektstyring.acceptance_tests;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class CucumberTest {
	
	@Given("that cucumber works")
	public void that_cucumber_works() {
	    System.out.println("Cucumber works");
	}

	@Then("cucumber works")
	public void cucumber_works() {
		System.out.println("Cucumber works");
	}

}
