package dtu.projektstyring.acceptance_tests;

import java.util.Calendar;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import dtu.projektstyring.app.Activity;
import dtu.projektstyring.app.Developer;
import dtu.projektstyring.app.Project;
import dtu.projektstyring.app.SoftwareHuset;
import test_helpers.ActivityHolder;
import test_helpers.ErrorMessageHolder;
import test_helpers.MockDateHolder;
import test_helpers.ProjectHelper;
import test_helpers.UserHelper;

public class ProjectOverviewSteps {
	private SoftwareHuset softwareHuset;
	private Project project;
	private Activity activity;
	private Developer developer, worker, worker2;
	private ErrorMessageHolder errorMessage;
	
	private UserHelper userHelper;
	private MockDateHolder dateHolder;
	private ProjectHelper projectHelper;
	private ActivityHolder activityHolder;
	
	public ProjectOverviewSteps(SoftwareHuset softwareHuset, ErrorMessageHolder errorMessage, 
			UserHelper userHelper, MockDateHolder dateHolder, ProjectHelper projectHelper, 
			 ActivityHolder activityHolder) {
		this.softwareHuset = softwareHuset;
		this.errorMessage = errorMessage;
		this.userHelper = userHelper;
		userHelper.setSoftwareHuset(softwareHuset);
		this.dateHolder = dateHolder;
		this.projectHelper = projectHelper;
		projectHelper.setSoftwareHuset(softwareHuset);
		this.activityHolder = activityHolder;
	}
	
	@Given("a development worker is available in the given timeperiod")
	public void aDevelopmentWorkerIsAvailableInTheGivenTimeperiod() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new cucumber.api.PendingException();
	}
	
	@Given("another developemnt worker is not available in the given timeperiod")
	public void anotherDevelopemntWorkerIsNotAvailableInTheGivenTimeperiod() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new cucumber.api.PendingException();
	}
	
	@When("the project leader wants a list of available developers")
	public void theProjectLeaderWantsAListOfAvailableDevelopers() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new cucumber.api.PendingException();
	}
	
	@Then("the project leader gets a list of developers, which contains the available development worker")
	public void theProjectLeaderGetsAListOfDevelopersWhichContainsTheAvailableDevelopmentWorker() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new cucumber.api.PendingException();
	}

	@Then("the list doesn't contain the unavailable developer")
	public void theListDoesnTContainTheUnavailableDeveloper() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new cucumber.api.PendingException();
	}
	
	@Given("the activity doesn't has a start date")
	public void theActivityDoesnTHasAStartDate() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new cucumber.api.PendingException();
	}

	@Given("the activity doesn't has a end date")
	public void theActivityDoesnTHasAEndDate() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new cucumber.api.PendingException();
	}

	@Given("no developers are available in the given time period")
	public void noDevelopersAreAvailableInTheGivenTimePeriod() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new cucumber.api.PendingException();
	}

	@Then("the list doesn't contain any developers")
	public void theListDoesnTContainAnyDevelopers() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new cucumber.api.PendingException();
	}
}
