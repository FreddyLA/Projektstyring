package dtu.projektstyring.acceptance_tests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import dtu.projektstyring.app.WorkActivity;
import dtu.projektstyring.app.Developer;
import dtu.projektstyring.app.Project;
import dtu.projektstyring.app.SoftwareHuset;
import test_helpers.ActivityHolder;
import test_helpers.ErrorMessageHolder;
import test_helpers.ProjectHelper;
import test_helpers.UserHelper;

public class ProjectOverviewSteps {
	private SoftwareHuset softwareHuset;
	private Project project;
	private WorkActivity workActivity;
	private Developer worker, worker2, worker3;
	private ErrorMessageHolder errorMessage;
	private List<Developer> availableDevelopers = new ArrayList<>();
	private double timeSpentActivity, timeSpentProject, timeRemainingProject;
	
	private UserHelper userHelper;
	private ProjectHelper projectHelper;
	private ActivityHolder activityHolder;
	
	public ProjectOverviewSteps(SoftwareHuset softwareHuset, ErrorMessageHolder errorMessage, 
			UserHelper userHelper, ProjectHelper projectHelper, 
			 ActivityHolder activityHolder) {
		this.softwareHuset = softwareHuset;
		this.errorMessage = errorMessage;
		this.userHelper = userHelper;
		userHelper.setSoftwareHuset(softwareHuset);
		this.projectHelper = projectHelper;
		projectHelper.setSoftwareHuset(softwareHuset);
		this.activityHolder = activityHolder;
	}
	
	@Given("a development worker is available in the given timeperiod")
	public void aDevelopmentWorkerIsAvailableInTheGivenTimeperiod() {
		worker2 = userHelper.getUser2();
	    softwareHuset.addDeveloper(worker2);
	    workActivity = activityHolder.getActivity();
	    assertTrue(worker2.isAvailable(workActivity.getStartTime(), workActivity.getEndTime()) < 10);
	}
	
	@Given("a development worker is not available in the given timeperiod")
	public void anotherDevelopemntWorkerIsNotAvailableInTheGivenTimeperiod() throws Exception {
		worker = userHelper.getUser();
		project = projectHelper.getProject();
		workActivity = activityHolder.getActivity();
		worker3 = userHelper.getUser3();
	    softwareHuset.addDeveloper(worker3);
	    WorkActivity trashActivity = null;
	    for(int i = 0; i < 10; i++) {
			softwareHuset.createAndAddActivityToProject(worker.getInitials(), project.getProjectNumber(), "n"+i);
			trashActivity = project.getActivity("n"+i);
			softwareHuset.setActivityStartTime(worker.getInitials(), project.getProjectNumber(), trashActivity.getName(), workActivity.getStartTime());
			softwareHuset.setActivityEndTime(worker.getInitials(), project.getProjectNumber(), trashActivity.getName(), workActivity.getEndTime());
			softwareHuset.addDeveloperToProjectActivity(worker.getInitials(), worker3.getInitials(), project.getProjectNumber(), trashActivity.getName());
		}
	    assertFalse(worker3.isAvailable(workActivity.getStartTime(), workActivity.getEndTime()) < 10);
	}
	
	@When("the project leader wants a list of available developers for the activity {string}")
	public void theProjectLeaderWantsAListOfAvailableDevelopers(String activityName){
		project = projectHelper.getProject();
	    try {
			availableDevelopers = softwareHuset.findAvailableDevelopers(project.getProjectNumber(), activityName);
		} catch (Exception e) {
			errorMessage.setErrorMessage(e.getMessage());
		}
	}
	
	@Then("the project leader gets a list of developers, which contains the available development worker")
	public void theProjectLeaderGetsAListOfDevelopersWhichContainsTheAvailableDevelopmentWorker() {
	    assertTrue(availableDevelopers.contains(worker2));
	}

	@Then("the list doesn't contain the unavailable developer")
	public void theListDoesnTContainTheUnavailableDeveloper() {
		assertFalse(availableDevelopers.contains(worker3));
	}
	
	@Given("the activity doesn't has a start date")
	public void theActivityDoesnTHasAStartDate() {
		workActivity = activityHolder.getActivity();
	    assertTrue(workActivity.getStartTime() == 0);
	}

	@Given("the activity doesn't has a end date")
	public void theActivityDoesnTHasAEndDate() {
		workActivity = activityHolder.getActivity();
	    assertTrue(workActivity.getEndTime() == 0);
	}
	
	@When("the project leader asks for time spent on the activity with the name {string}")
	public void theProjectLeaderAsksForTimeSpentOnTheActivityWithTheName(String string) throws Exception {
		worker = userHelper.getUser();
		project = projectHelper.getProject();
		timeSpentActivity = softwareHuset.getTimeSpentActivity(worker.getInitials(), project.getProjectNumber(), string);
	}
	
	@Then("the project leader is told that {int} hours has been spent on the activity")
	public void theProjectLeaderIsToldThatHoursHasBeenSpentOnTheActivity(Integer int1) {
	    assertTrue(timeSpentActivity == int1);
	}
	
	@When("the project leader asks for time spent on the project")
	public void theProjectLeaderAsksForTimeSpentOnTheProject() throws Exception {
		worker = userHelper.getUser();
		project = projectHelper.getProject();
		timeSpentProject = softwareHuset.getTimeSpentProject(worker.getInitials(), project.getProjectNumber());
	}
	
	@Then("the project leader is told that {int} hours has been spent on the project")
	public void theProjectLeaderIsToldThatHoursHasBeenSpentOnTheProject(Integer int1) {
		assertTrue(timeSpentProject == int1);
	}
	
	@When("the project leader asks work remains on the project")
	public void theProjectLeaderAsksWorkRemainsOnTheProject() throws Exception {
		worker = userHelper.getUser();
		project = projectHelper.getProject();
		timeRemainingProject = softwareHuset.getProjectWorkRemaining(worker.getInitials(), project.getProjectNumber());
	}
	
	@Then("the project leader is told that {int} hours remain on the project")
	public void theProjectLeaderIsToldThatHoursRemainOnTheProject(Integer int1) {
	    assertTrue(timeRemainingProject == int1);
	}
}
