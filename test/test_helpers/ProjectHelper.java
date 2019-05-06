package test_helpers;

import java.util.Calendar;

import dtu.projektstyring.app.Developer;
import dtu.projektstyring.app.Project;
import dtu.projektstyring.app.SoftwareHuset;

public class ProjectHelper {
	private Project project;
	private SoftwareHuset sh;
	
	public Project getProject() {
		if (project == null) {
			project = exampleProject();
		}
		return project;
	}
	
	private Project exampleProject() {
		Project project = new Project("Project 1",Calendar.getInstance(), sh);
		return project;
	}
	
	public void setSoftwareHuset(SoftwareHuset sh) {
		this.sh = sh;
	}
}
