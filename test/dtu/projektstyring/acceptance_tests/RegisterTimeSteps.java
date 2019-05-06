package dtu.projektstyring.acceptance_tests;

import static org.junit.Assert.assertTrue;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import dtu.projektstyring.app.Activity;
import dtu.projektstyring.app.Developer;

public class RegisterTimeSteps {
	
	private SoftwareHuset softwareHuset;

	private Project project;
	private Activity activity;
	private Developer developer, worker, worker2;
	private ErrorMessageHolder errorMessage;
	private Date activityEndTime;
	private Date activityStartTime;
	private List<Developer> developers;
	private Map<String, Developer> developerByInitials = new HashMap<>();
	
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
		this.activityHolder = activityHolder;
	}

	@Given("the development worker inputs {int} hours worked on the activity into the system")
	public void theDevelopmentWorkerInputsAmountOfHoursWorkedForTheDayIntoTheSystem(double hours){
		activity = activityHolder.getActivity();
		project = projectHelper.getProject();
		try {
			softwareHuset.registerTime(userHelper.getUser2(), project.getProjectNumber(), activity.getName(), hours);
		} catch (Exception e) {
			errorMessage.setErrorMessage(e.getMessage());
		}
	}
	
	@Then("the development worker has worked {int} hours on the activity")
	public void theSystemIsUpdatedWithTheGivenData(double hours) {
		assertTrue(activity.getDevWorkTime(userHelper.getUser2()) == hours);
	}
	
	@Then("the other worker has worked {int} hours on the activity")
	public void theOtherWorkerHasWorked(double hours) {
		assertTrue(activity.getDevWorkTime(userHelper.getUser3()) == hours);
	}
	
	@When("the other worker inputs {int} hours to the activity together with the development workers initials")
	public void theWorkerInputsHelpingWorkhoursToTheActivityTogetherWithTheHelpedWorkersInitials(int hours) {
		activity = activityHolder.getActivity();
		project = projectHelper.getProject();
		worker = userHelper.getUser2();
		worker2 = userHelper.getUser3();
		try {
			softwareHuset.registerHelpedTime(worker, worker2, project.getProjectNumber(), activity.getName(), hours);
		} catch (Exception e) {
			errorMessage.setErrorMessage(e.getMessage());
		}
	}
}
