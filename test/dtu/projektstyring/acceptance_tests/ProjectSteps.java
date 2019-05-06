package dtu.projektstyring.acceptance_tests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Calendar;
import java.util.Date;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import dtu.projektstyring.app.Activity;
import dtu.projektstyring.app.Developer;
import dtu.projektstyring.app.Project;
import dtu.projektstyring.app.Rapport;
import dtu.projektstyring.app.SoftwareHuset;
import dtu.projektstyring.exceptions.NotProjectLeaderException;
import test_helpers.ErrorMessageHolder;
import test_helpers.MockDateHolder;
import test_helpers.ProjectHelper;
import test_helpers.UserHelper;

public class ProjectSteps {

	private SoftwareHuset softwareHuset;
	private Project project;
	private Activity activity;
	private Rapport rapport;
	private Developer worker, worker2;
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
	}

	@When("the project leader assigns a start date for the project that is before the project creation date")
	public void theProjectLeaderAssignsAStartDateForTheProjectThatIsBeforeTheProjectCreationDate() {
		Calendar prevDate = Calendar.getInstance();
		prevDate.add(Calendar.DAY_OF_YEAR, -5);
		assertTrue(prevDate.before(project.getCreationTime()));
		try {
			softwareHuset.setProjectStartTime(project, prevDate);
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
    	this.worker = userHelper.getUser();
    	softwareHuset.setProjectLeader(project, worker);
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
            softwareHuset.makeProject(worker, string);
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

    @When("a development worker generates a project development rapport of a project")
    public void aDevelopmentWorkerGeneratesAProjectDevelopmentRapportOfAProject() {
        worker2 = userHelper.getUser2();
        try {
			softwareHuset.getRapport(worker2, project.getProjectNumber());
		} catch (Exception e) {
			errorMessage.setErrorMessage(e.getMessage());
		}
    }
    
    @When("the development worker assigns a development worker to be project leader")
    public void theDevelopmentWorkerThatCreatedTheProjectAssignsADevelopmentWorkerToBeProjectLeader() {
        worker2 = userHelper.getUser2();
        try {
			softwareHuset.setProjectLeader(project, worker, worker2);
		} catch (NotProjectLeaderException e) {
			errorMessage.setErrorMessage(e.getMessage());
		}
    }
    
    @Then("the selected development worker is made leader of the project")
    public void theSelectedDevelopmentWorkerIsMadeLeaderOfTheProject() {
        assertTrue(project.getProjectLeader().equals(worker2));
    }
    
    @Given("a development worker is the leader of the project")
    public void aDevelopmentWorkerIsTheLeaderOfTheProject() {
        assertTrue(project.getProjectLeader().equals(worker));
    }
    
    @Given("a development worker is not the leader of the project")
    public void aDevelopmentWorkerIsNotTheLeaderOfTheProject() {
    	worker = userHelper.getUser2();
    	assertFalse(project.getProjectLeader().equals(worker));
    }
    
}