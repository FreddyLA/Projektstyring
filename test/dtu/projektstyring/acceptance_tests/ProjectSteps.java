package dtu.projektstyring.acceptance_tests;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.Calendar;

import cucumber.api.java.en.Given;
import dtu.projektstyring.app.Activity;
import dtu.projektstyring.app.Developer;
import dtu.projektstyring.app.Project;
import dtu.projektstyring.app.SoftwareHuset;

public class ProjectSteps {

	private SoftwareHuset softwareHuset;
	private Project project;
	private Activity activity;
	private Developer developer;
	private ErrorMessageHolder errorMessage;
	
	private UserHelper helper;
	private MockDateHolder dateHolder;
	
	
	public ProjectSteps(SoftwareHuset softwareHuset, ErrorMessageHolder errorMessage, UserHelper helper, MockDateHolder dateHolder) {
		this.softwareHuset = softwareHuset;
		this.errorMessage = errorMessage;
		this.helper = helper;
		this.dateHolder = dateHolder;
	}
	
    @Given("a project has been created")
    public void aProjectHasBeenCreated() throws Exception {
    	softwareHuset.addDeveloper(helper.getUser());
        softwareHuset.makeProject(softwareHuset.getDeveloper("JDO"), "test", Calendar.getInstance().getTime());
    	assertTrue(!softwareHuset.getProjects().isEmpty());
    }
    
    @Given("a project leader has been selected")
    public void aProjectLeaderHasBeenSelected() throws Exception {
        assertThat(helper.getUser(),is(equalTo(softwareHuset.getProjectProjectLeader("test"))));
    }
    

}