package dtu.projektstyring.app;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import dtu.projektstyring.app.DateServer;
import dtu.projektstyring.exceptions.DuplicateNameException;
import dtu.projektstyring.exceptions.MissingDateException;
import dtu.projektstyring.exceptions.NotOnActivityException;
import dtu.projektstyring.exceptions.NotProjectLeaderException;
import dtu.projektstyring.exceptions.StartDateException;

public class SoftwareHuset {
	
	private List<Developer> developers = new ArrayList<>();
	private List<Project> projects = new ArrayList<>();
	private List<Activity> privateActivities = new ArrayList<>();
	private DateServer dateServer = new DateServer();
	private List<String> work = new ArrayList<>();
	
	//**********TIL TESTING**********//
	public SoftwareHuset() {
		/**
		Developer defDev = new Developer("John Doe", "JDO", this);
		developers.add(defDev);
		
		Developer newDev = new Developer("Mike Johnson", "MJO", this);
		developers.add(newDev);
		newDev = new Developer("Elias Sandder", "ESA", this);
		developers.add(newDev);
		newDev = new Developer("Melissa Kullins", "MKU", this);
		developers.add(newDev);
		
		Project defProj = new Project("Proj1", dateServer.getDate(), this);
		try {
			defProj.setProjectLeader(defDev);
		} catch (NotProjectLeaderException e) {
			e.printStackTrace();
		}
		projects.add(defProj);
		**/
	}
	//*******************************//
	
	public void makeProject(String projectName) throws Exception {
		if(!projects.isEmpty()) {
			for(Project p : projects) {
				if(p.getName().equals(projectName)) {
					throw new DuplicateNameException();
				}
			}
		}
		Project newProject = new Project(projectName, dateServer.getDate().get(Calendar.WEEK_OF_YEAR), this);
		projects.add(newProject);
	}
	
	//Finds developers available in the time frame of the activity
	public List<Developer> findAvailableDevelopers(int projectNumber, String activityName) throws Exception {
		Project project = getProject(projectNumber);
		Activity activity = project.getActivity(activityName);
		if(activity.getStartTime() == 0) {
			throw new MissingDateException();
		}
		List<Developer> availableDevs = new ArrayList<>();
		for(Developer developer: developers) {
			if(developer.isAvailable(activity.getStartTime(), activity.getEndTime())) {
				availableDevs.add(developer);
			}
		}
		return availableDevs;
	}

	public Report getRapport(Developer developer, int projectNumber) throws Exception {
		Project project = getProject(projectNumber);
		if(!project.getProjectLeader().equals(developer)) {
			throw new NotProjectLeaderException();
		}
		return project.getReport();
	}
	
	public Developer getProjectLeader(String projectName) throws Exception { 
        Project project = getProject(projectName); 
        return project.getProjectLeader(); 
    }
	
	public void registerTime(Developer developer, int projectNumber, String activityName, double hours) throws Exception {
		Project project = getProject(projectNumber);
		Activity activity = project.getActivity(activityName);
		if(developer == null) throw new Exception("Developer does not exist");
		else if(project == null) throw new Exception("Specified project does not exist");
		else if(activity == null) throw new Exception("Specified activity of the project does not exist");
		else if(!activity.getDevelopers().contains(developer)) throw new NotOnActivityException();
		
		if(activity.getDevelopers().contains(developer)) {
			DeveloperActivityTime work = new DeveloperActivityTime(developer, activity, hours, dateServer.getDate().get(Calendar.DAY_OF_YEAR));
			activity.registerTime(work);
			developer.registerWork(work);
		}
	}
	
	public void registerHelpedTime(Developer activityDeveloper, Developer activityHelper, 
									int projectNumber, String activityName, int hours) throws Exception {
		Project project = getProject(projectNumber);
		Activity activity = project.getActivity(activityName);
		if(!activity.getDevelopers().contains(activityDeveloper)) {
			throw new NotOnActivityException();
		}
		DeveloperActivityTime work = new DeveloperActivityTime(activityDeveloper, activityHelper, 
																activity, hours, dateServer.getDate().get(Calendar.DAY_OF_YEAR));
		activity.registerTime(work);
	}
	
	public void registerPrivateActivity(Developer developer, int startTime, int endTime, String activityName) {
		
	}
	
	public void createAndAddActivityToProject(Developer developer, String projectName, String activityName) throws Exception {
		Project project = getProject(projectName);
		if(!project.getProjectLeader().equals(developer)) {
			throw new NotProjectLeaderException();
		}
		project.createAndAddActivity(activityName);
	}
	
	public void addDeveloperToProjectActivity(Developer projectLeader, Developer developer, 
												String projectName, String activityName) throws Exception {
		Project project = getProject(projectName);
		Activity activity = project.getActivity(activityName);
		project.addDeveloperToActivity(projectLeader,developer, activity);
	}
	
	public List<Developer> getProjectActivityDevelopers(String projectName, String activityName) throws Exception{
		Project project = getProject(projectName);
		Activity activity = project.getActivity(activityName);
		return project.getActivityDevelopers(activity);
	}
	
	public void registerPrivateTime(Developer developer, String activityName, double hours) {
		Activity privateActivity = null;
		for(Activity activity: privateActivities) {
			if(activity.getName().matches(activityName)) {
				privateActivity = activity;
			}
		}
		DeveloperActivityTime priv = new DeveloperActivityTime(developer, privateActivity, hours, Calendar.getInstance().get(Calendar.DAY_OF_YEAR));
		privateActivity.registerTime(priv);
	}
	
	public List<String> getFullWork(){
		return work;
	}
	
	public DateServer getDateServer() {
		return this.dateServer;
	}
	
	public void setDateServer(DateServer dateServer) {
		this.dateServer = dateServer;
	}

	public List<Project> getProjects() {
		return projects;
	}
	
	public Project getProject(String projectName) throws Exception {
		for(Project project : projects) {
			if(project.getName().equals(projectName)) {
				return project;
			}
		}
		return null;
	}
	
	public Project getProject(int projectNumber) throws Exception {
		for(Project project : projects) {
			if(project.getProjectNumber() == projectNumber) {
				return project;
			}
		}
		return null;
	}

	public void addProject(Project project) {
		this.projects.add(project);
	}

	public boolean removeProject(Project project) {
		project.removeAllActivities();
		return this.projects.remove(project);
	}
	
	public List<Developer> getDevelopers() {
		return developers;
	}

	public Developer getDeveloper(String initials) throws Exception {
		for(Developer d : developers) {
			if(d.getInitials().equals(initials)) {
				return d;
			}
		}
		throw new Exception("Developer with specified initials does not exist.");
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

	public void setProjectStartTime(Project project, int time) throws Exception {
		 project.setStartTime(time);
	}

	public void setProjectLeader(Project project, Developer developer) throws NotProjectLeaderException {
		project.setProjectLeader(developer);
	}

	public void setProjectLeader(Project project, Developer leader, Developer newLeader) throws NotProjectLeaderException {
		project.setProjectLeader(leader, newLeader);
	}
}
