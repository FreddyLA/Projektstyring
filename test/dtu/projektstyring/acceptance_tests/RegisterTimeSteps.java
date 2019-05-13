package dtu.projektstyring.acceptance_tests;

import static org.junit.Assert.assertTrue;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import dtu.projektstyring.app.SoftwareHuset;
import test_helpers.ActivityHolder;
import test_helpers.ErrorMessageHolder;
import test_helpers.MockDateHolder;
import test_helpers.ProjectHelper;
import test_helpers.UserHelper;
import dtu.projektstyring.app.Project;
import dtu.projektstyring.app.WorkActivity;
import dtu.projektstyring.app.Developer;

public class RegisterTimeSteps {
	
	private SoftwareHuset softwareHuset;

	private Project project;
	private WorkActivity workActivity;
	private Developer worker, worker2;
	private ErrorMessageHolder errorMessage;
	private double workDone;
	
	private UserHelper userHelper;
	private MockDateHolder dateHolder;
	private ProjectHelper projectHelper;
	private ActivityHolder activityHolder;
	
	public RegisterTimeSteps(SoftwareHuset softwareHuset, ErrorMessageHolder errorMessage, 
			UserHelper userHelper, MockDateHolder dateHolder, ProjectHelper projectHelper, ActivityHolder activityHolder) {
		this.softwareHuset = softwareHuset;
		this.errorMessage = errorMessage;
		this.userHelper = userHelper;
		userHelper.setSoftwareHuset(softwareHuset);
		this.dateHolder = dateHolder;
		this.projectHelper = projectHelper;
		projectHelper.setSoftwareHuset(softwareHuset);
		this.activityHolder = activityHolder;
	}

	@Given("the development worker inputs {int} hours worked on the activity into the system")
	public void theDevelopmentWorkerInputsAmountOfHoursWorkedForTheDayIntoTheSystem(double hours){
		workActivity = activityHolder.getActivity();
		project = projectHelper.getProject();
		try {
			softwareHuset.registerTime(userHelper.getUser2().getInitials(), project.getProjectNumber(), workActivity.getName(), hours);
		} catch (Exception e) {
			errorMessage.setErrorMessage(e.getMessage());
		}
	}
	
	@Then("the development worker has worked {int} hours on the activity")
	public void theSystemIsUpdatedWithTheGivenData(double hours) throws Exception {
		assertTrue(softwareHuset.getDevWorkTimeToday(userHelper.getUser2().getInitials(), project.getProjectNumber(),workActivity.getName()) == hours);
	}
	
	@Then("the other worker has worked {int} hours on the activity")
	public void theOtherWorkerHasWorked(double hours) throws Exception {
		assertTrue(softwareHuset.getDevWorkTimeToday(userHelper.getUser3().getInitials(), project.getProjectNumber(), workActivity.getName()) == hours);
	}
	
	@When("the other worker inputs {int} hours to the activity together with the development workers initials")
	public void theWorkerInputsHelpingWorkhoursToTheActivityTogetherWithTheHelpedWorkersInitials(int hours) {
		workActivity = activityHolder.getActivity();
		project = projectHelper.getProject();
		worker = userHelper.getUser2();
		worker2 = userHelper.getUser3();
		try {
			softwareHuset.registerHelpedTime(worker.getInitials(), worker2.getInitials(), project.getProjectNumber(), workActivity.getName(), hours);
		} catch (Exception e) {
			errorMessage.setErrorMessage(e.getMessage());
		}
	}
	
	@Given("the development worker the next day inputs {int} hours worked on the activity into the system")
	public void theDevelopmentWorkerTheNextDayInputsHoursWorkedOnTheActivityIntoTheSystem(Integer int1) {
	    dateHolder.advanceDateByDays(1);
	    workActivity = activityHolder.getActivity();
		project = projectHelper.getProject();
		try {
			softwareHuset.registerTime(userHelper.getUser2().getInitials(), project.getProjectNumber(), workActivity.getName(), int1);
		} catch (Exception e) {
			errorMessage.setErrorMessage(e.getMessage());
		}
	}
	
	@When("the development worker wants to know how many hours he has worked on the day")
	public void theDevelopmentWorkerWantsToKnowHowManyHoursHeHasWorkedOnTheDay() {
	    workDone = userHelper.getUser2().workDoneToday();
	}

	@Then("the development worker is told that he has worked {int} hours on the day")
	public void theDevelopmentWorkerIsToldThatHeHasWorkedHoursOnTheDay(Integer int1) {
	    assertTrue(int1 == workDone);
	}
	
	@When("a development worker registers time on activity that doesn't excist")
	public void aDevelopmentWorkerRegistersTimeOnActivityThatDoesnTExcist() {
		project = projectHelper.getProject();
		worker = userHelper.getUser2();
		softwareHuset.addDeveloper(worker);
		try {
			softwareHuset.registerTime(worker.getInitials(), project.getProjectNumber(), "pølse", 5);
		} catch (Exception e) {
			errorMessage.setErrorMessage(e.getMessage());
		}
	}
}
