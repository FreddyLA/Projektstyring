package dtu.projektstyring.app;

import java.util.ArrayList;
import java.util.List;

import dtu.projektstyring.app.DateServer;

public class SoftwareHuset {
	
	private List<Developer> developers = new ArrayList<Developer>();
	private List<Project> projects = new ArrayList<Project>();
	private DateServer dateServer = new DateServer();
	
	public void makeProject() {
		
	}
	
	public void addActivity() {
		
	}
	
	public void getRapport() {
		
	}
	
	public void setIsProjektLeader() {
		
	}
	
	public void registerTime() {
		
	}	
	
	public void setDateServer(DateServer dateServer) {
		this.dateServer = dateServer;
	}

	public List<Project> getProjects() {
		return projects;
	}

	public void addProject(Project projects) {
		this.projects.add(projects);
	}

	public boolean removeProject(Project project) {
		project.removeAllActivities();
		return this.projects.remove(project);
	}
	
	public List<Developer> getDevelopers() {
		return developers;
	}

	public void addDeveloper(Developer developer) {
		this.developers.add(developer);
	}
	
	public boolean removeDeveloper(Developer developer) {
		for(Project p: this.projects) {
			for(Activity a: p.getActivities()) {
				a.removeDeveloper(developer);
			}
		}
		
		return this.developers.remove(developer);
	}
}
