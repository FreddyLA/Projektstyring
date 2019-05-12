package dtu.projektstyring.acceptance_tests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Calendar;
import java.util.Date;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import dtu.projektstyring.app.WorkActivity;
import dtu.projektstyring.app.Developer;
import dtu.projektstyring.app.Project;
import dtu.projektstyring.app.Report;
import dtu.projektstyring.app.SoftwareHuset;
import dtu.projektstyring.exceptions.NotProjectLeaderException;
import test_helpers.ErrorMessageHolder;
import test_helpers.MockDateHolder;
import test_helpers.ProjectHelper;
import test_helpers.UserHelper;

public class ProjectSteps {

	private SoftwareHuset softwareHuset;
	private Project project;
	private Developer worker, worker2, worker3;
	private ErrorMessageHolder errorMessage;
	
	private UserHelper userHelper;
	private MockDateHolder dateHolder;
	private ProjectHelper projectHelper;
	
	
	public ProjectSteps(SoftwareHuset softwareHuset, ErrorMessageHolder errorMessage, 
								UserHelper userHelper, MockDateHolder dateHolder, ProjectHelper projectHelper) {
		this.softwareHuset = softwareHuset;
		this.errorMessage = errorMessage;
		this.userHelper = userHelper;
		userHelper.setSoftwareHuset(softwareHuset);
		this.dateHolder = dateHolder;
		this.projectHelper = projectHelper;
		projectHelper.setSoftwareHuset(softwareHuset);
	}
	
	@Given("the project doesn't have a project leader")
	public void theProjectDoesnTHaveAProjectLeader() throws Exception {
	    assertTrue(softwareHuset.getProjectLeader(project.getName()) == null);
	}

	@When("a developement worker is assigned to be the project leader")
	public void aDevelopementWorkerIsAssignedToBeTheProjectLeader() throws Exception {
	    worker = userHelper.getUser();
	    softwareHuset.addDeveloper(worker);
	    project.setProjectLeader(worker);
	    assertTrue(softwareHuset.getDevelopers().contains(worker));
	}

	@Then("the project leader of the project is the development worker")
	public void theProjectLeaderOfTheProjectIsTheDevelopmentWorker() throws Exception {
	    assertTrue(softwareHuset.getProjectLeader(project.getName()).equals(worker));
	}

	@When("the project leader assigns a start date for the project that is before the project creation date")
	public void theProjectLeaderAssignsAStartDateForTheProjectThatIsBeforeTheProjectCreationDate() {
		Calendar prevDate = Calendar.getInstance();
		prevDate.add(Calendar.DAY_OF_YEAR, -8);
		assertTrue(prevDate.get(Calendar.WEEK_OF_YEAR) < project.getCreationTime());
		try {
			softwareHuset.setProjectStartTime(project.getProjectNumber(), prevDate.get(Calendar.WEEK_OF_YEAR));
		} catch (Exception e) {
			errorMessage.setErrorMessage(e.getMessage());
		}
	}
	
	@When("the project leader assigns a end date for the project that is before the project creation date")
	public void theProjectLeaderAssignsAEndDateForTheProjectThatIsBeforeTheProjectCreationDate() {
		Calendar prevDate = Calendar.getInstance();
		prevDate.add(Calendar.DAY_OF_YEAR, -8);
		assertTrue(prevDate.get(Calendar.WEEK_OF_YEAR) < project.getCreationTime());
		try {
			softwareHuset.setProjectEndTime(project.getProjectNumber(), prevDate.get(Calendar.WEEK_OF_YEAR));
		} catch (Exception e) {
			errorMessage.setErrorMessage(e.getMessage());
		}
	}
	
	@Given("a project with the name {string} exists")
	public void aProjectWithTheNameAlreadyExists(String string) {
	    this.project = projectHelper.getProject();
	    softwareHuset.addProject(project);
	    assertTrue(project.getName().matches(string));
	    assertTrue(softwareHuset.getProjects().contains(project));
	}
    
    @Given("a project leader has been selected")
    public void aProjectLeaderHasBeenSelected() throws Exception {
    	worker = userHelper.getUser();
    	softwareHuset.addDeveloper(worker);
    	softwareHuset.setProjectLeader(project.getProjectNumber(), worker.getInitials());
        assertTrue(project.getProjectLeader().equals(worker));
    }
    
    @Given("a development worker is registered in the system")
    public void aDevelopmentWorkerIsRegisteredInTheSystem() {
        this.worker = userHelper.getUser();
        softwareHuset.addDeveloper(worker);
        assertTrue(softwareHuset.getDevelopers().contains(worker));
    }

    @When("a development worker creates a project with the name {string}")
    public void aDevelopmentWorkerCreatesANewProjectWithTheName(String string){
    	try {
            softwareHuset.makeProject(string);
            this.project = softwareHuset.getProject(string);
            assertTrue(project.getName().matches(string));
    	} catch (Exception e) {
    		errorMessage.setErrorMessage(e.getMessage());
    	}
    }

    @Then("a new project is created with the name {string}")
    public void aNewProjectIsCreatedWithTheName(String string) throws Exception {
    	assertFalse(softwareHuset.getProject(string).equals(null));
    }

    @Then("the project is given a unique number for identification.")
    public void theProjectIsGivenAUniqueNumberForIdentification() throws Exception {
    	int id = project.getProjectNumber();
        assertTrue(project.equals(softwareHuset.getProject(id)));
    }
    
    @Then("an error message {string} is presented")
    public void anErrorMessageIsPresented(String string) {
        assertTrue(errorMessage.getErrorMessage().matches(string));
    }
    
    @When("the development worker assigns a development worker to be project leader")
    public void theDevelopmentWorkerThatCreatedTheProjectAssignsADevelopmentWorkerToBeProjectLeader() {
        worker3 = userHelper.getUser3();
        softwareHuset.addDeveloper(worker3);
        try {
			softwareHuset.setProjectLeader(project.getProjectNumber(), worker2.getInitials(), worker3.getInitials());
		} catch (Exception e) {
			errorMessage.setErrorMessage(e.getMessage());
		}
    }
    
    @When("the project leader assigns a development worker to be project leader")
    public void theProjectLeaderThatCreatedTheProjectAssignsADevelopmentWorkerToBeProjectLeader() {
        worker2 = userHelper.getUser2();
        softwareHuset.addDeveloper(worker2);
        try {
			softwareHuset.setProjectLeader(project.getProjectNumber(), worker.getInitials(), worker2.getInitials());
		} catch (Exception e) {
			errorMessage.setErrorMessage(e.getMessage());
		}
    }
    
    @Then("the selected development worker is made leader of the project")
    public void theSelectedDevelopmentWorkerIsMadeLeaderOfTheProject() {
        assertTrue(project.getProjectLeader().equals(worker2));
    }
    
    @Given("a development worker is not the leader of the project")
    public void aDevelopmentWorkerIsNotTheLeaderOfTheProject() {
    	worker2 = userHelper.getUser2();
    	softwareHuset.addDeveloper(worker2);
    	assertFalse(project.getProjectLeader().equals(worker2));
    }
    
}