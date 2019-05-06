package dtu.projektstyring.acceptance_tests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Calendar;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import dtu.projektstyring.app.Activity;
import dtu.projektstyring.app.Developer;
import dtu.projektstyring.app.Project;
import dtu.projektstyring.app.SoftwareHuset;
import dtu.projektstyring.exceptions.NotProjectLeaderException;
import test_helpers.ActivityHolder;
import test_helpers.ErrorMessageHolder;
import test_helpers.MockDateHolder;
import test_helpers.ProjectHelper;
import test_helpers.UserHelper;

public class ActivitySteps {
	
	private SoftwareHuset softwareHuset;
	private Project project;
	private Activity activity;
	private Developer developer, worker, worker2;
	private ErrorMessageHolder errorMessage;
	
	private UserHelper userHelper;
	private MockDateHolder dateHolder;
	private ProjectHelper projectHelper;
	private ActivityHolder activityHolder;
	
	private Calendar calendar;
	
	public ActivitySteps(SoftwareHuset softwareHuset, ErrorMessageHolder errorMessage, 
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
	
	@When("the project leader creates a new activity with the name {string}")
	public void theProjectLeaderCreatesANewActivityWithTheName(String string) throws Exception {
	    this.developer = userHelper.getUser();
	    this.project = projectHelper.getProject();
	    softwareHuset.createAndAddActivityToProject(developer, project.getName(), string);
	    activity = project.getActivity(string);
	    activityHolder.setActivity(activity);
	    assertTrue(activity.getName().matches(string));
	    assertTrue(activity.getAttachedProject().equals(project));
	}
	
	@When("the project leader changes budgettet time to {int}")
	public void theProjectLeaderEditsActivity(int number) throws NotProjectLeaderException {
		developer = userHelper.getUser();
	    activity.setBudgetetTime(developer, number);
	    assertTrue(activity.getBudgetedTime() == number);
	}

	@Then("the activity's budgettet time is {int}")
	public void theActivityIsChanged(int number) {
		assertTrue(activity.getBudgetedTime() == number);
	}

	@Given("a development worker attempts to edit an activity's budgettet time")
	public void aDevelopmentWorkerAttemptsToEditAnActivity() {
	    worker = userHelper.getUser2();
	    try {
		    activity.setBudgetetTime(worker, 10);
	    } catch (Exception e) {
	    	errorMessage.setErrorMessage(e.getMessage());
	    }
	}

	@Then("a new activity with the name {string} is created")
	public void aNewActivityWithTheNameIsCreated(String string) {
	    assertTrue(project.getActivity(string).equals(activity));
	}

	@When("a development worker creates an activity for the project")
	public void aDevelopmentWorkerCreatesAnActivityForTheProject() {
	    worker = userHelper.getUser2();
	    project = projectHelper.getProject();
	    try {
	    	softwareHuset.createAndAddActivityToProject(worker, project.getName(), "test");
	    } catch (Exception e) {
	    	errorMessage.setErrorMessage(e.getMessage());
	    }
	}

	@When("the project leader assigns a deadline to the activity that is before the assigned start date")
	public void theProjectLeaderAssignsAStartDateToTheActivity() throws Exception {
		Calendar startDate = Calendar.getInstance();
	    activity.setStartTime(developer, startDate.get(Calendar.WEEK_OF_YEAR));
	    Calendar prevDate = Calendar.getInstance();
		prevDate.add(Calendar.DAY_OF_MONTH, -5);
		try {
			activity.setEndTime(developer, prevDate.get(Calendar.WEEK_OF_YEAR));
		} catch (Exception e) {
			errorMessage.setErrorMessage(e.getMessage());
		}
	}
	
	@When("the project leader changes the activity's start time")
	public void theProjectLeaderChangesTheActivitySStartTime() throws Exception {
		calendar = softwareHuset.getDateServer().getDate();
	    activity.setStartTime(developer, calendar.get(Calendar.WEEK_OF_YEAR));
	    assertTrue(activity.getStartTime() == calendar.get(Calendar.WEEK_OF_YEAR));
	}

	@Then("the activity's start time has been changed")
	public void theActivitySStartTimeHasBeenChanged() {
		assertTrue(activity.getStartTime() == calendar.get(Calendar.WEEK_OF_YEAR));
	} 
	
	@Given("a development worker is assigned the activity")
	public void aDevelopmentWorkerIsAssignedTheActivity() throws Exception {
		developer = userHelper.getUser();
		worker = userHelper.getUser2();
		softwareHuset.addDeveloperToProjectActivity(developer, worker, project.getName(), activity.getName());
	    assertTrue(softwareHuset.getProjectActivityDevelopers(project.getName(), activity.getName()).contains(worker));
	}
	
	@Given("a development worker is not assigned the activity")
	public void aDevelopmentWorkerIsNotAssignedTheActivity() {
	    worker = userHelper.getUser();
	    assertFalse(activity.getDevelopers().contains(worker));
	}
	
	@Given("a different development worker is not assigned the activity")
	public void aDifferentDevelopmentWorkerIsAssignedTheActivity() {
	    worker2 = userHelper.getUser3();
	    assertFalse(activity.getDevelopers().contains(worker2));
	}
	
	@When("the project leader adds a development worker to an activity")
	public void theProjectLeaderAddsADevelopmentWorkerToAnActivity() {
	    developer = userHelper.getUser();
	    try {
			activity.addDeveloper(developer, worker);
			assertTrue(activity.getDevelopers().contains(worker));
		} catch (Exception e) {
			errorMessage.setErrorMessage(e.getMessage());
		}
	}

	@Then("the development worker has been added to the activity")
	public void theDevelopmentWorkerHasBeenAddedToTheActivity() {
		assertTrue(activity.getDevelopers().contains(worker));
	}
	
	@Given("a development worker exists")
	public void aDevelopmentWorkerExists() {
	    worker = userHelper.getUser2();
	    softwareHuset.addDeveloper(worker);
	}

	@Given("the development worker has {int} activities")
	public void theDevelopmentWorkerHasActivities(Integer int1) throws Exception {
		this.developer = userHelper.getUser();
		this.project = projectHelper.getProject(); 
		Activity activity = null;
		for(int i = 0; i < int1; i++) {
			softwareHuset.createAndAddActivityToProject(developer, project.getName(), "n"+i);
			activity = project.getActivity("n"+i);
			activity.addDeveloper(developer, worker);
		}
		assertTrue(worker.getActivities().size() == int1);
	}
	
	@When("a development worker assigns a new development worker the the activity")
	public void aDevelopmentWorkerAssignsANewDevelopmentWorkerTheTheActivity() {
	    worker2 = userHelper.getUser3();
	    try {
			activity.addDeveloper(worker, worker2);
		} catch (Exception e) {
			errorMessage.setErrorMessage(e.getMessage());
		}
	}
	
	@When("the development worker changes the hours worked on the activity from {int} to {int}")
	public void theDevelopmentWorkerChangesTheHoursWorkedOnTheActivityFromTo(Integer int1, Integer int2) {
		assertTrue(activity.getDevWorkTimeToday(worker) == int1);
	    activity.editDeveloperActivityTime(worker, int2);
	}

	@Then("the development worker's hours on the activity is {int}")
	public void theDevelopmentWorkerSHoursOnTheActivityIs(Integer int1) {
		assertTrue(activity.getDevWorkTimeToday(worker) == int1);
	}
	
	@Given("the activity has a start date and end date")
	public void theActivityHasAStartDateAndEndDate() throws Exception {
		Calendar currTime = softwareHuset.getDateServer().getDate();
	    activity.setStartTime(userHelper.getUser(), currTime.get(Calendar.WEEK_OF_YEAR)+1);
	    activity.setEndTime(userHelper.getUser(), currTime.get(Calendar.WEEK_OF_YEAR)+3);
	}
}
