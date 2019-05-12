package dtu.projektstyring.acceptance_tests;

import static org.junit.Assert.assertTrue;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import dtu.projektstyring.app.WorkActivity;
import dtu.projektstyring.app.Developer;
import dtu.projektstyring.app.Project;
import dtu.projektstyring.app.Report;
import dtu.projektstyring.app.SoftwareHuset;
import test_helpers.ActivityHolder;
import test_helpers.ErrorMessageHolder;
import test_helpers.MockDateHolder;
import test_helpers.ProjectHelper;
import test_helpers.UserHelper;

public class GenerateRapportSteps {
	
	private SoftwareHuset softwareHuset;
	private Project project;
	private WorkActivity workActivity;
	private Developer developer, worker, worker2;
	private ErrorMessageHolder errorMessage;
	private Report projectReport;
	
	private UserHelper userHelper;
	private MockDateHolder dateHolder;
	private ProjectHelper projectHelper;
	private ActivityHolder activityHolder;
	
	public GenerateRapportSteps(SoftwareHuset softwareHuset, ErrorMessageHolder errorMessage, 
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
	
    @When("a development worker generates a project development rapport of a project")
    public void aDevelopmentWorkerGeneratesAProjectDevelopmentRapportOfAProject() {
    	project = projectHelper.getProject();
        worker2 = userHelper.getUser2();
        softwareHuset.addDeveloper(worker2);
        try {
			softwareHuset.getRapport(worker2.getInitials(), project.getProjectNumber());
		} catch (Exception e) {
			errorMessage.setErrorMessage(e.getMessage());
		}
    } 
	
	@When("the project leader generates a project development rapport of the project of which the project leader is the project leader of")
	public void theProjectLeaderGeneratesAProjectDevelopmentRapportOfTheProjectOfWhichTheProjectLeaderIsTheProjectLeaderOf() {
	    project = projectHelper.getProject();
	    worker = userHelper.getUser();
        try {
			projectReport = softwareHuset.getRapport(worker.getInitials(), project.getProjectNumber());
		} catch (Exception e) {
			errorMessage.setErrorMessage(e.getMessage());
		}
	}

	@Then("the development rapport is generated")
	public void theGeneratedDevelopmentRapportIsGenerated() {
	    assertTrue(projectReport.getProjectLeader().matches(project.getProjectLeader().getInitials()));
	    assertTrue(projectReport.getProjectNumber() == project.getProjectNumber());
	    assertTrue(projectReport.getProjectName().matches(project.getName()));
	}
}
