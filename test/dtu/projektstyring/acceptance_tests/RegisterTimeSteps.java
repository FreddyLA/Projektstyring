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

import dtu.projektstyring.acceptance_tests.ErrorMessageHolder;
import dtu.projektstyring.acceptance_tests.MockDateHolder;
import dtu.projektstyring.acceptance_tests.UserHelper;
import dtu.projektstyring.app.SoftwareHuset;
import dtu.projektstyring.app.Project;
import dtu.projektstyring.app.Activity;
import dtu.projektstyring.app.Developer;

public class RegisterTimeSteps {
	
	private SoftwareHuset softwareHuset;

	private Project project;
	private Activity activity;
	private Developer developer;
	private ErrorMessageHolder errorMessage;
	private Date activityEndTime;
	private Date activityStartTime;
	private List<Developer> developers;
	private Map<String, Developer> developerByInitials = new HashMap<>();
	
	private UserHelper helper;
	private MockDateHolder dateHolder;
	
	public RegisterTimeSteps(SoftwareHuset softwareHuset, ErrorMessageHolder errorMessage, UserHelper helper, MockDateHolder dateHolder) {
		this.softwareHuset = softwareHuset;
		this.errorMessage = errorMessage;
		this.helper = helper;
		this.dateHolder = dateHolder;
	}
	
	@Given("the project has an activity")
	public void theProjectHasAnActivity() throws Exception {
		project = softwareHuset.getProject("test");
		activityEndTime = new GregorianCalendar(2019, Calendar.JUNE, 11).getTime();
		activityStartTime = new GregorianCalendar(2019, Calendar.NOVEMBER, 11).getTime();
		double activityBudgetTime = 99999;
		activity = project.createAndAddActivity("testActivity", activityStartTime, activityEndTime, activityBudgetTime);
		assertTrue(!project.getActivity("testActivity").equals(null));
	}

	@Given("a development worker is assigned the activity")
	public void aDevelopmentWorkerIsAssignedTheActivity() throws Exception {
	    activity.addDeveloper(helper.getUser());
	    System.out.println(activity.getDevelopers().get(0).getInitials());
	    assertTrue(!this.activity.getDevelopers().isEmpty());
	}

	@Given("the development worker inputs amount of hours worked for the day into the system")
	public void theDevelopmentWorkerInputsAmountOfHoursWorkedForTheDayIntoTheSystem() throws Exception {
		int hours = 8;
		softwareHuset.registerTime(helper.getUser(), project.getProjectNumber(), activity.getName(), hours);
	}
	
	@Then("the system is updated with the given data")
	public void theSystemIsUpdatedWithTheGivenData() {
		System.out.println(softwareHuset.getFullWork().get(0));
	    assertTrue(!softwareHuset.getFullWork().isEmpty());
	}

}
