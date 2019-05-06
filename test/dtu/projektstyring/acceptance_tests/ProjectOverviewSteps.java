package dtu.projektstyring.acceptance_tests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

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
	private List<Developer> availableDevelopers = new ArrayList<>();
	
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
	    worker = userHelper.getUser2();
	    softwareHuset.addDeveloper(worker);
	    activity = activityHolder.getActivity();
	    assertTrue(worker.isAvailable(activity.getStartTime(), activity.getEndTime()));
	}
	
	@Given("a development worker is not available in the given timeperiod")
	public void anotherDevelopemntWorkerIsNotAvailableInTheGivenTimeperiod() throws Exception {
		developer = userHelper.getUser();
		project = projectHelper.getProject();
		activity = activityHolder.getActivity();
	    worker2 = userHelper.getUser3();
	    softwareHuset.addDeveloper(worker2);
	    Activity trashActivity = null;
	    for(int i = 0; i < 10; i++) {
			softwareHuset.createAndAddActivityToProject(developer, project.getName(), "n"+i);
			trashActivity = project.getActivity("n"+i);
			trashActivity.setStartTime(developer, activity.getStartTime());
			trashActivity.setEndTime(developer, activity.getEndTime());
			trashActivity.addDeveloper(developer, worker2);
		}
	    assertFalse(worker2.isAvailable(activity.getStartTime(), activity.getEndTime()));
	}
	
	@When("the project leader wants a list of available developers")
	public void theProjectLeaderWantsAListOfAvailableDevelopers(){
		project = projectHelper.getProject();
	    try {
			availableDevelopers = softwareHuset.findAvailableDevelopers(project.getProjectNumber(), activity.getName());
		} catch (Exception e) {
			errorMessage.setErrorMessage(e.getMessage());
		}
	}
	
	@Then("the project leader gets a list of developers, which contains the available development worker")
	public void theProjectLeaderGetsAListOfDevelopersWhichContainsTheAvailableDevelopmentWorker() {
	    assertTrue(availableDevelopers.contains(worker));
	}

	@Then("the list doesn't contain the unavailable developer")
	public void theListDoesnTContainTheUnavailableDeveloper() {
		assertFalse(availableDevelopers.contains(worker2));
	}
	
	@Given("the activity doesn't has a start date")
	public void theActivityDoesnTHasAStartDate() {
		activity = activityHolder.getActivity();
	    assertTrue(activity.getStartTime() == 0);
	}

	@Given("the activity doesn't has a end date")
	public void theActivityDoesnTHasAEndDate() {
		activity = activityHolder.getActivity();
	    assertTrue(activity.getEndTime() == 0);
	}
	
	@Then("the list doesn't contain any developers")
	public void theListDoesnTContainAnyDevelopers() {
	    assertTrue(availableDevelopers.isEmpty());
	}
}
