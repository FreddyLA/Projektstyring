package dtu.projektstyring.app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import dtu.projektstyring.app.DateServer;
import dtu.projektstyring.exceptions.DuplicateNameException;
import dtu.projektstyring.exceptions.MissingDateException;
import dtu.projektstyring.exceptions.NotOnActivityException;
import dtu.projektstyring.exceptions.NotProjectLeaderException;
import dtu.projektstyring.exceptions.PrivateActivityDuringWorkActivityException;

public class SoftwareHuset {
	
	private List<Developer> developers = new ArrayList<>();
	private List<Project> projects = new ArrayList<>();
	private List<String> privateActivities = new ArrayList<String>(
										Arrays.asList("Vacation", "Sick", "Course"));
	private DateServer dateServer = new DateServer();
	
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
		for(Project project: projects) {
			if(project.getName().equals(projectName)) {
				throw new DuplicateNameException();
			}
		}
		Project newProject = new Project(projectName, dateServer.getDate().get(Calendar.WEEK_OF_YEAR), this);
		projects.add(newProject);
	}
	
	//Finds developers available in the time frame of the activity
	public List<Developer> findAvailableDevelopers(int projectNumber, String activityName) throws Exception {
		Project project = getProject(projectNumber);
		WorkActivity workActivity = project.getActivity(activityName);
		if(workActivity.getStartTime() == 0) {
			throw new MissingDateException();
		}
		List<Developer> availableDevs = new ArrayList<>();
		for(Developer developer: developers) {
			if(developer.isAvailable(workActivity.getStartTime(), workActivity.getEndTime()) < 10) {
				availableDevs.add(developer);
			}
		}
		return availableDevs;
	}

	public Report getRapport(String developerInitials, int projectNumber) throws Exception {
		Developer developer = getDeveloper(developerInitials);
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
	
	public void registerTime(String developerInitials, int projectNumber, String activityName, double hours) throws Exception {
		Developer developer = getDeveloper(developerInitials);
		Project project = getProject(projectNumber);
		WorkActivity workActivity = project.getActivity(activityName);
		if(developer == null) throw new Exception("Developer does not exist");
		else if(project == null) throw new Exception("Specified project does not exist");
		else if(workActivity == null) throw new Exception("Specified activity of the project does not exist");
		else if(!workActivity.getDevelopers().contains(developer)) throw new NotOnActivityException();
		
		if(workActivity.getDevelopers().contains(developer)) {
			DeveloperActivityTime work = new DeveloperActivityTime(developer, workActivity, hours, dateServer.getDate().get(Calendar.DAY_OF_YEAR));
			workActivity.registerTime(work);
			developer.registerWork(work);
		}
	}
	
	public void registerHelpedTime(String developerInitials, String helperInitialsr, 
									int projectNumber, String activityName, int hours) throws Exception {
		Developer activityDeveloper = getDeveloper(developerInitials);
		Developer helperDeveloper = getDeveloper(helperInitialsr);
		Project project = getProject(projectNumber);
		WorkActivity workActivity = project.getActivity(activityName);
		if(!workActivity.getDevelopers().contains(activityDeveloper)) {
			throw new NotOnActivityException();
		}
		DeveloperActivityTime work = new DeveloperActivityTime(activityDeveloper, helperDeveloper, 
																workActivity, hours, dateServer.getDate().get(Calendar.DAY_OF_YEAR));
		workActivity.registerTime(work);
	}
	
	public void registerPrivateActivity(String developerInitials, int startTime, int endTime, String activityName) throws Exception {
		Developer developer = getDeveloper(developerInitials);
		if(developer.isAvailable(startTime, endTime) > 0) {
			throw new PrivateActivityDuringWorkActivityException();
		}
		PrivateActivity privateActivity = new PrivateActivity(activityName, startTime, endTime);
		developer.addPrivateActivity(privateActivity);
	}
	
	public void createAndAddActivityToProject(String developerInitials, String projectName, String activityName) throws Exception {
		Developer developer = getDeveloper(developerInitials);
		Project project = getProject(projectName);
		if(!project.getProjectLeader().equals(developer)) {
			throw new NotProjectLeaderException();
		}
		project.createAndAddActivity(activityName);
	}
	
	public void setActivityStartTime(int projectID, String developerInitials, String activityName, int time) throws Exception {
		Project project = getProject(projectID);
		WorkActivity workActivity = project.getActivity(activityName);
		Developer developer = getDeveloper(developerInitials);
		workActivity.setStartTime(developer, time);
	}
	
	public void setActivityBudgettetTime(int projectID, String developerInitials, String activityName, int time) throws Exception {
		Project project = getProject(projectID);
		WorkActivity workActivity = project.getActivity(activityName);
		Developer developer = getDeveloper(developerInitials);
		workActivity.setBudgetetTime(developer, time);
	}
	
	public void setActivityEndTime(int projectID, String developerInitials, String activityName, int time) throws Exception {
		Project project = getProject(projectID);
		WorkActivity workActivity = project.getActivity(activityName);
		Developer developer = getDeveloper(developerInitials);
		workActivity.setEndTime(developer, time);
	}
	
	public void addDeveloperToProjectActivity(String leaderInitials, String developerInitials, 
												String projectName, String activityName) throws Exception {
		Developer projectLeader = getDeveloper(leaderInitials);
		Developer developer = getDeveloper(developerInitials);
		Project project = getProject(projectName);
		WorkActivity workActivity = project.getActivity(activityName);
		project.addDeveloperToActivity(projectLeader,developer, workActivity);
	}
	
	public List<Developer> getProjectActivityDevelopers(String projectName, String activityName) throws Exception{
		Project project = getProject(projectName);
		WorkActivity workActivity = project.getActivity(activityName);
		return project.getActivityDevelopers(workActivity);
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
	
	public Project getProject(String projectName){
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
		if(developers.contains(developer)) {
			return;
		}
		developers.add(developer);
	}

	public void setProjectStartTime(int projectID, int time) throws Exception {
		Project project = getProject(projectID);
		project.setStartTime(time);
	}

	public void setProjectLeader(int projectID, String developerInitials) throws Exception {
		Project project = getProject(projectID);
		Developer developer = getDeveloper(developerInitials);
		project.setProjectLeader(developer);
	}

	public void setProjectLeader(int projectID, String leaderInitials, String developerInitials) throws Exception {
		Project project = getProject(projectID);
		Developer leader = getDeveloper(leaderInitials);
		Developer newLeader = getDeveloper(developerInitials);
		project.setProjectLeader(leader, newLeader);
	}

	public void setProjectEndTime(int projectID, int time) throws Exception {
		Project project = getProject(projectID); 
		project.setEndTime(time);
	}

	public void editDeveloperActivityTime(int projectID, String developerInitials, String activityName, int time) throws Exception {
		Developer developer = getDeveloper(developerInitials);
		Project project = getProject(projectID);
		WorkActivity workActivity = project.getActivity(activityName);
		workActivity.editDeveloperActivityTime(developer, time);
	}
	
	public void setDeveloperCanWorkOn20Activities(String developerInitials, boolean b) throws Exception {
		Developer developer = getDeveloper(developerInitials);
		developer.setCanWorkOn20Activities(b);
	}

	public double getDevWorkTime(int projectID, String developerInitials, String activityName) throws Exception {
		Developer developer = getDeveloper(developerInitials);
		Project project = getProject(projectID);
		WorkActivity workActivity = project.getActivity(activityName);
		return workActivity.getDevWorkTime(developer);
	}
}
