package test_helpers;

import java.util.Calendar;

import dtu.projektstyring.app.Developer;
import dtu.projektstyring.app.Project;

public class ProjectHelper {
	private Project project;
	
	public Project getProject() {
		if (project == null) {
			project = exampleProject();
		}
		return project;
	}
	
	private Project exampleProject() {
		Project project = new Project("Project 1",Calendar.getInstance().getTime());
		return project;
	}
}
