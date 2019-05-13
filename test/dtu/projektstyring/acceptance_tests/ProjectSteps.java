package dtu.projektstyring.acceptance_tests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Calendar;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import dtu.projektstyring.app.Developer;
import dtu.projektstyring.app.Project;
import dtu.projektstyring.app.SoftwareHuset;
import test_helpers.ErrorMessageHolder;
import test_helpers.ProjectHelper;
import test_helpers.UserHelper;

public class ProjectSteps {

	private SoftwareHuset softwareHuset;
	private Project project;
	private Developer worker, worker2, worker3;
	private ErrorMessageHolder errorMessage;
	private Calendar calendar;
	
	private UserHelper userHelper;
	private ProjectHelper projectHelper;
	
	
	public ProjectSteps(SoftwareHuset softwareHuset, ErrorMessageHolder errorMessage, 
								UserHelper userHelper, ProjectHelper projectHelper) {
		this.softwareHuset = softwareHuset;
		this.errorMessage = errorMessage;
		this.userHelper = userHelper;
		userHelper.setSoftwareHuset(softwareHuset);
		this.projectHelper = projectHelper;
		projectHelper.setSoftwareHuset(softwareHuset);
	}
	
	//Author: Frederik
	@Given("the project doesn't have a project leader")
	public void theProjectDoesnTHaveAProjectLeader() throws Exception {
	    assertTrue(softwareHuset.getProjectLeader(project.getProjectNumber()) == null);
	}

	//Author: Frederik
	@When("a developement worker is assigned to be the project leader")
	public void aDevelopementWorkerIsAssignedToBeTheProjectLeader() throws Exception {
	    worker = userHelper.getUser();
	    softwareHuset.addDeveloper(worker);
	    project.setProjectLeader(worker);
	    assertTrue(softwareHuset.getDevelopers().contains(worker));
	}

	//Author: Frederik
	@Then("the project leader of the project is the development worker")
	public void theProjectLeaderOfTheProjectIsTheDevelopmentWorker() throws Exception {
	    assertTrue(softwareHuset.getProjectLeader(project.getProjectNumber()).equals(worker));
	}

	//Author: Kuno
	@When("the project leader assigns a start date for the project that is before the project creation date")
	public void theProjectLeaderAssignsAStartDateForTheProjectThatIsBeforeTheProjectCreationDate() {
		Calendar prevDate = Calendar.getInstance();
		prevDate.add(Calendar.DAY_OF_YEAR, -8);
		assertTrue(prevDate.get(Calendar.WEEK_OF_YEAR) < project.getCreationTime());
		try {
			softwareHuset.setProjectStartTime(worker.getInitials(), project.getProjectNumber(), prevDate.get(Calendar.WEEK_OF_YEAR));
		} catch (Exception e) {
			errorMessage.setErrorMessage(e.getMessage());
		}
	}
	
	//Author: Kuno
	@When("the project leader assigns a end date for the project that is before the project creation date")
	public void theProjectLeaderAssignsAEndDateForTheProjectThatIsBeforeTheProjectCreationDate() {
		Calendar prevDate = Calendar.getInstance();
		prevDate.add(Calendar.DAY_OF_YEAR, -8);
		assertTrue(prevDate.get(Calendar.WEEK_OF_YEAR) < project.getCreationTime());
		try {
			softwareHuset.setProjectEndTime(worker.getInitials(), project.getProjectNumber(), prevDate.get(Calendar.WEEK_OF_YEAR));
		} catch (Exception e) {
			errorMessage.setErrorMessage(e.getMessage());
		}
	}
	
	//Author: Kuno
	@Given("a project with the name {string} exists")
	public void aProjectWithTheNameAlreadyExists(String string) {
	    this.project = projectHelper.getProject();
	    softwareHuset.addProject(project);
	    assertTrue(project.getName().matches(string));
	    assertTrue(softwareHuset.getProjects().contains(project));
	}
    
	//Author: Kuno
    @Given("a project leader has been selected")
    public void aProjectLeaderHasBeenSelected() throws Exception {
    	worker = userHelper.getUser();
    	softwareHuset.addDeveloper(worker);
    	softwareHuset.setProjectLeader(worker.getInitials(), project.getProjectNumber());
        assertTrue(project.getProjectLeader().equals(worker));
    }
    
    //Author: Kuno
    @Given("a development worker is registered in the system")
    public void aDevelopmentWorkerIsRegisteredInTheSystem() {
        this.worker = userHelper.getUser();
        softwareHuset.addDeveloper(worker);
        assertTrue(softwareHuset.getDevelopers().contains(worker));
    }

    //Author: Martin
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

    //Author: Martin
    @Then("a new project is created with the name {string}")
    public void aNewProjectIsCreatedWithTheName(String string) throws Exception {
    	assertFalse(softwareHuset.getProject(string).equals(null));
    }

    //Author: Martin
    @Then("the project is given a unique number for identification.")
    public void theProjectIsGivenAUniqueNumberForIdentification() throws Exception {
    	int id = project.getProjectNumber();
        assertTrue(project.equals(softwareHuset.getProject(id)));
    }
    
    //Author: Martin
    @Then("an error message {string} is presented")
    public void anErrorMessageIsPresented(String string) {
        assertTrue(errorMessage.getErrorMessage().matches(string));
    }
    
    //Author: Martin
    @When("the development worker assigns a development worker to be project leader")
    public void theDevelopmentWorkerThatCreatedTheProjectAssignsADevelopmentWorkerToBeProjectLeader() {
        worker3 = userHelper.getUser3();
        softwareHuset.addDeveloper(worker3);
        try {
			softwareHuset.setProjectLeader(worker2.getInitials(), worker3.getInitials(), project.getProjectNumber());
		} catch (Exception e) {
			errorMessage.setErrorMessage(e.getMessage());
		}
    }
    
    //Author: Michael
    @When("the project leader assigns a development worker to be project leader")
    public void theProjectLeaderThatCreatedTheProjectAssignsADevelopmentWorkerToBeProjectLeader() {
        worker2 = userHelper.getUser2();
        softwareHuset.addDeveloper(worker2);
        try {
			softwareHuset.setProjectLeader(worker.getInitials(), worker2.getInitials(), project.getProjectNumber());
		} catch (Exception e) {
			errorMessage.setErrorMessage(e.getMessage());
		}
    }
    
    //Author: Michael
    @Then("the selected development worker is made leader of the project")
    public void theSelectedDevelopmentWorkerIsMadeLeaderOfTheProject() {
        assertTrue(project.getProjectLeader().equals(worker2));
    }
    
    //Author: Michael
    @Given("a development worker is not the leader of the project")
    public void aDevelopmentWorkerIsNotTheLeaderOfTheProject() {
    	worker2 = userHelper.getUser2();
    	softwareHuset.addDeveloper(worker2);
    	assertFalse(project.getProjectLeader().equals(worker2));
    }
    
    //Author: Michael
    @When("a development worker tries to edit a project that does not exist")
    public void aDevelopmentWorkerTriesToEditAProjectThatDoesNotExist() {
        worker2 = userHelper.getUser2();
        try {
			softwareHuset.setProjectEndTime(worker2.getInitials(),10, 5);
		} catch (Exception e) {
			errorMessage.setErrorMessage(e.getMessage());
		}
    }
    
    //Author: Michael
    @When("a development worker that does not exist tries to edit a project")
    public void aDevelopmentWorkerThatDoesNotExistTriesToEditAProject() {
    	 worker2 = userHelper.getUser2();
         try {
 			softwareHuset.setProjectEndTime("WUT", project.getProjectNumber(), 5);
 		} catch (Exception e) {
 			errorMessage.setErrorMessage(e.getMessage());
 		}
    }
    
    //Author: Frederik
    @When("the project leader changes the project start date")
    public void theProjectLeaderChangesTheProjectStartDate() throws Exception {
    	calendar = softwareHuset.getDateServer().getDate();
        softwareHuset.setProjectStartTime(worker.getInitials(), project.getProjectNumber(), calendar.get(Calendar.WEEK_OF_YEAR)+5);
    }

    //Author: Frederik
    @Then("the project start date has been changed")
    public void theProjectStartDateHasBeenChanged() {
        assertTrue(project.getStartTime() == calendar.get(Calendar.WEEK_OF_YEAR)+5);
    }

    //Author: Frederik
    @When("the project leader changes the project end date")
    public void theProjectLeaderChangesTheProjectEndDate() throws Exception {
    	calendar = softwareHuset.getDateServer().getDate();
    	softwareHuset.setProjectEndTime(worker.getInitials(), project.getProjectNumber(), calendar.get(Calendar.WEEK_OF_YEAR)+5);
    }

    //Author: Frederik
    @Then("the project end date has been changed")
    public void theProjectEndDateHasBeenChanged() {
    	assertTrue(project.getEndTime() == calendar.get(Calendar.WEEK_OF_YEAR)+5);
    }
    
    //Author: Frederik
    @Given("the bugettet time on the project is {int} hours")
    public void theBugettetTimeOnTheProjectIsHours(Integer time) throws Exception {
        softwareHuset.setProjectBudgettetTime(worker.getInitials(), project.getProjectNumber(), time);
    }
}