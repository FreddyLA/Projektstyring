package dtu.projektstyring.acceptance_tests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Calendar;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import dtu.projektstyring.app.WorkActivity;
import dtu.projektstyring.app.Developer;
import dtu.projektstyring.app.PrivateActivity;
import dtu.projektstyring.app.Project;
import dtu.projektstyring.app.SoftwareHuset;
import dtu.projektstyring.exceptions.ActivityDoesNotExistException;
import test_helpers.ActivityHolder;
import test_helpers.ErrorMessageHolder;
import test_helpers.ProjectHelper;
import test_helpers.UserHelper;

public class ActivitySteps {
	
	private SoftwareHuset softwareHuset;
	private Project project;
	private WorkActivity workActivity;
	private PrivateActivity privateActivity;
	private Developer worker, worker2, worker3;
	private ErrorMessageHolder errorMessage;
	
	private UserHelper userHelper;
	private ProjectHelper projectHelper;
	private ActivityHolder activityHolder;
	
	private Calendar calendar;
	
	public ActivitySteps(SoftwareHuset softwareHuset, ErrorMessageHolder errorMessage, 
			UserHelper userHelper, ProjectHelper projectHelper, ActivityHolder activityHolder) {
		this.softwareHuset = softwareHuset;
		this.errorMessage = errorMessage;
		this.userHelper = userHelper;
		userHelper.setSoftwareHuset(softwareHuset);
		this.projectHelper = projectHelper;
		projectHelper.setSoftwareHuset(softwareHuset);
		this.activityHolder = activityHolder;
	}
	
	@When("the project leader creates a new activity with the name {string}")
	public void theProjectLeaderCreatesANewActivityWithTheName(String string) throws Exception {
	    worker = userHelper.getUser();
	    project = projectHelper.getProject();
	    softwareHuset.createAndAddActivityToProject(worker.getInitials(), project.getProjectNumber(), string);
	    workActivity = softwareHuset.getProject(project.getName()).getActivity(string);
	    activityHolder.setActivity(workActivity);
	    assertTrue(workActivity.getName().matches(string));
	    assertTrue(workActivity.getAttachedProject().equals(project));
	    assertTrue(project.getActivities().contains(workActivity));
	}
	
	@When("the project leader changes budgettet time to {int}")
	public void theProjectLeaderEditsActivity(int time) throws Exception {
		worker = userHelper.getUser();
		softwareHuset.setActivityBudgettetTime(project.getProjectNumber() ,worker.getInitials(), workActivity.getName(), time);
	    assertTrue(workActivity.getBudgetedTime() == time);
	}

	@Then("the activity's budgettet time is {int}")
	public void theActivityIsChanged(int number) {
		assertTrue(workActivity.getBudgetedTime() == number);
	}

	@Given("a development worker attempts to edit an activity's budgettet time")
	public void aDevelopmentWorkerAttemptsToEditAnActivity() {
		worker2 = userHelper.getUser2();
	    softwareHuset.addDeveloper(worker2);
	    try {
		    softwareHuset.setActivityBudgettetTime(project.getProjectNumber(), worker2.getInitials(), workActivity.getName(), 10);
	    } catch (Exception e) {
	    	errorMessage.setErrorMessage(e.getMessage());
	    }
	}

	@Then("a new activity with the name {string} is created")
	public void aNewActivityWithTheNameIsCreated(String string) throws ActivityDoesNotExistException {
	    assertTrue(project.getActivity(string).equals(workActivity));
	}

	@When("a development worker creates an activity for the project")
	public void aDevelopmentWorkerCreatesAnActivityForTheProject() {
		worker2 = userHelper.getUser2();
	    softwareHuset.addDeveloper(worker2);
	    project = projectHelper.getProject();
	    try {
	    	softwareHuset.createAndAddActivityToProject(worker2.getInitials(), project.getProjectNumber(), "test");
	    } catch (Exception e) {
	    	errorMessage.setErrorMessage(e.getMessage());
	    }
	}

	@When("the project leader assigns a deadline to the activity that is before the assigned start date")
	public void theProjectLeaderAssignsAStartDateToTheActivity() throws Exception {
		Calendar startDate = Calendar.getInstance();
		softwareHuset.setActivityEndTime(project.getProjectNumber(), worker.getInitials(), workActivity.getName(), startDate.get(Calendar.WEEK_OF_YEAR));
	    Calendar prevDate = Calendar.getInstance();
		prevDate.add(Calendar.DAY_OF_MONTH, -10);
		try {
			softwareHuset.setActivityEndTime(project.getProjectNumber(), worker.getInitials(), workActivity.getName(), prevDate.get(Calendar.WEEK_OF_YEAR));
		} catch (Exception e) {
			errorMessage.setErrorMessage(e.getMessage());
		}
	}
	
	@When("the project leader changes the activity's start time")
	public void theProjectLeaderChangesTheActivitySStartTime() throws Exception {
		calendar = softwareHuset.getDateServer().getDate();
		softwareHuset.setActivityStartTime(project.getProjectNumber(), worker.getInitials(), workActivity.getName(), calendar.get(Calendar.WEEK_OF_YEAR));
	    assertTrue(workActivity.getStartTime() == calendar.get(Calendar.WEEK_OF_YEAR));
	}

	@Then("the activity's start time has been changed")
	public void theActivitySStartTimeHasBeenChanged() {
		assertTrue(workActivity.getStartTime() == calendar.get(Calendar.WEEK_OF_YEAR));
	} 
	
	@Given("a development worker is assigned the activity")
	public void aDevelopmentWorkerIsAssignedTheActivity() throws Exception {
		worker = userHelper.getUser();
		worker2 = userHelper.getUser2();
		softwareHuset.addDeveloper(worker2);
		workActivity = activityHolder.getActivity();
		softwareHuset.addDeveloperToProjectActivity(worker.getInitials(), worker2.getInitials(), project.getProjectNumber(), workActivity.getName());
	    assertTrue(softwareHuset.getProjectActivityDevelopers(project.getProjectNumber(), workActivity.getName()).contains(worker2));
	}
	
	@Given("a development worker is not assigned the activity")
	public void aDevelopmentWorkerIsNotAssignedTheActivity() {
		worker2 = userHelper.getUser2();
	    softwareHuset.addDeveloper(worker2);
	    assertFalse(workActivity.getDevelopers().contains(worker2));
	}
	
	@Given("a different development worker is not assigned the activity")
	public void aDifferentDevelopmentWorkerIsAssignedTheActivity() {
		worker3 = userHelper.getUser3();
	    softwareHuset.addDeveloper(worker3);
	    assertFalse(workActivity.getDevelopers().contains(worker3));
	}
	
	@When("the project leader adds a development worker to the activity")
	public void theProjectLeaderAddsADevelopmentWorkerToAnActivity() {
		worker2 = userHelper.getUser2();
		softwareHuset.addDeveloper(worker2);
	    try {
	    	softwareHuset.addDeveloperToProjectActivity(worker.getInitials(), worker2.getInitials(), project.getProjectNumber(), workActivity.getName());
			assertTrue(workActivity.getDevelopers().contains(worker2));
		} catch (Exception e) {
			errorMessage.setErrorMessage(e.getMessage());
		}
	}

	@Then("the development worker has been added to the activity")
	public void theDevelopmentWorkerHasBeenAddedToTheActivity() {
		assertTrue(workActivity.getDevelopers().contains(worker2));
	}

	@Given("a development worker has {int} activities")
	public void theDevelopmentWorkerHasActivities(Integer int1) throws Exception {
		worker = userHelper.getUser();
		project = projectHelper.getProject(); 
		worker2 = userHelper.getUser2();
		softwareHuset.addDeveloper(worker2);
		WorkActivity trashActivity = null;
		for(int i = 0; i < int1; i++) {
			softwareHuset.createAndAddActivityToProject(worker.getInitials(), project.getProjectNumber(), "n"+i);
			trashActivity = project.getActivity("n"+i);
			softwareHuset.setActivityStartTime(project.getProjectNumber(), worker.getInitials(), trashActivity.getName(), workActivity.getStartTime());
			softwareHuset.setActivityEndTime(project.getProjectNumber(), worker.getInitials(), trashActivity.getName(), workActivity.getEndTime());
			softwareHuset.addDeveloperToProjectActivity(worker.getInitials(), worker2.getInitials(), project.getProjectNumber(), workActivity.getName());
		}
		assertTrue(worker2.getWorkActivities().size() == int1);
	}
	
	@When("a development worker assigns a new development worker to the activity")
	public void aDevelopmentWorkerAssignsANewDevelopmentWorkerTheTheActivity() {
		worker2 = userHelper.getUser2();
		worker3 = userHelper.getUser3();
	    softwareHuset.addDeveloper(worker2);
	    softwareHuset.addDeveloper(worker3);
	    try {
	    	softwareHuset.addDeveloperToProjectActivity(worker2.getInitials(), worker3.getInitials(), project.getProjectNumber(), workActivity.getName());
		} catch (Exception e) {
			errorMessage.setErrorMessage(e.getMessage());
		}
	}
	
	@When("the development worker changes the hours worked on the activity from {int} to {int}")
	public void theDevelopmentWorkerChangesTheHoursWorkedOnTheActivityFromTo(Integer int1, Integer int2) throws Exception {
		assertTrue(workActivity.getDevWorkTimeToday(worker2) == int1);
		softwareHuset.editDeveloperActivityTime(project.getProjectNumber(), worker2.getInitials(), workActivity.getName(), int2);
	}

	@Then("the development worker's hours on the activity is {int}")
	public void theDevelopmentWorkerSHoursOnTheActivityIs(Integer int1) {
		assertTrue(workActivity.getDevWorkTimeToday(worker2) == int1);
	}
	
	@Given("the activity has a start date and end date")
	public void theActivityHasAStartDateAndEndDate() throws Exception {
		Calendar currTime = softwareHuset.getDateServer().getDate();
		softwareHuset.setActivityStartTime(project.getProjectNumber(),userHelper.getUser().getInitials(), workActivity.getName(), currTime.get(Calendar.WEEK_OF_YEAR)+1);
		softwareHuset.setActivityEndTime(project.getProjectNumber(),userHelper.getUser().getInitials(), workActivity.getName(), currTime.get(Calendar.WEEK_OF_YEAR)+3);
	}
	
	@When("a development worker registers the private activity {string}")
	public void theDevelopmentWorkerRegistersThePrivateActivity(String string){
		worker2 = userHelper.getUser2();
		softwareHuset.addDeveloper(worker2);
	    try {
			softwareHuset.registerPrivateActivity(worker2.getInitials(), workActivity.getStartTime(), workActivity.getEndTime(), string);
			privateActivity = worker2.getPrivateActivity(string);
		} catch (Exception e) {
			errorMessage.setErrorMessage(e.getMessage());
		}
	}

	@Then("the delopment worker has a private activity {string}")
	public void theDelopmentWorkerHasAPrivateActivity(String string) {
		assertTrue(privateActivity.getName().matches(string));
	    assertTrue(worker2.getPrivateActivities().contains(privateActivity));
	}
	
	@Given("the development worker can work on {int} activities")
	public void theDevelopmentWorkerCanWorkOnActivities(int number) throws Exception {
		softwareHuset.setDeveloperCanWorkOn20Activities(worker2.getInitials(), true);
	}
	
	@Given("a development worker inputs {int} hours worked on the activity with the name {string}")
	public void aDevelopmentWorkerInputsHoursWorkedOnTheActivityWithTheName(Integer hours, String string) throws Exception {
		softwareHuset.addDeveloperToProjectActivity(worker.getInitials(), worker2.getInitials(), project.getProjectNumber(), workActivity.getName());
		softwareHuset.registerTime(worker2.getInitials(), project.getProjectNumber(), string, hours);
	}
}
