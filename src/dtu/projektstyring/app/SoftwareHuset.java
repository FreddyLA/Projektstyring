package dtu.projektstyring.app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import dtu.projektstyring.exceptions.ActivityDoesNotExistException;
import dtu.projektstyring.exceptions.DeveloperDoesNotExistException;
import dtu.projektstyring.exceptions.DuplicateNameException;
import dtu.projektstyring.exceptions.MissingDateException;
import dtu.projektstyring.exceptions.NotOnActivityException;
import dtu.projektstyring.exceptions.NotProjectLeaderException;
import dtu.projektstyring.exceptions.PrivateActivityDuringWorkActivityException;
import dtu.projektstyring.exceptions.ProjectDoesNotExistException;

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
		
		Project defProj = new Project("Proj1", dateServer.getDate().get(Calendar.WEEK_OF_YEAR), this);
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
		if(project == null) {
			throw new ProjectDoesNotExistException();
		}
		WorkActivity workActivity = project.getActivity(activityName);
		if(workActivity == null) {
			throw new ActivityDoesNotExistException();
		}
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
		if(developer == null) {
			throw new DeveloperDoesNotExistException();
		}
		Project project = getProject(projectNumber);
		if(project == null) {
			throw new ProjectDoesNotExistException();
		}
		if(!project.getProjectLeader().equals(developer)) {
			throw new NotProjectLeaderException();
		}
		return project.getReport();
	}
	
	public Developer getProjectLeader(int projectID) throws Exception { 
        Project project = getProject(projectID); 
        if(project == null) {
			throw new ProjectDoesNotExistException();
		}
        return project.getProjectLeader(); 
    }
	
	public void registerTime(String developerInitials, int projectNumber, String activityName, double hours) throws Exception {
		Developer developer = getDeveloper(developerInitials);
		if(developer == null) {
			throw new DeveloperDoesNotExistException();
		}
		Project project = getProject(projectNumber);
		if(project == null) {
			throw new ProjectDoesNotExistException();
		}
		WorkActivity workActivity = project.getActivity(activityName);
		if(workActivity == null) {
			throw new ActivityDoesNotExistException();
		}
		if(!workActivity.getDevelopers().contains(developer)) {
			throw new NotOnActivityException();
		}
		
		DeveloperActivityTime work = new DeveloperActivityTime(developer, hours, dateServer.getDate().get(Calendar.DAY_OF_YEAR));
		workActivity.registerTime(work);
		developer.registerWork(work);
	}
	
	public void registerHelpedTime(String developerInitials, String helperInitialsr, 
									int projectNumber, String activityName, int hours) throws Exception {
		Developer activityDeveloper = getDeveloper(developerInitials);
		if(activityDeveloper == null) {
			throw new DeveloperDoesNotExistException();
		}
		Developer helperDeveloper = getDeveloper(helperInitialsr);
		if(helperDeveloper == null) {
			throw new DeveloperDoesNotExistException();
		}
		Project project = getProject(projectNumber);
		if(project == null) {
			throw new ProjectDoesNotExistException();
		}
		WorkActivity workActivity = project.getActivity(activityName);
		if(workActivity == null) {
			throw new ActivityDoesNotExistException();
		}
		if(!workActivity.getDevelopers().contains(activityDeveloper)) {
			throw new NotOnActivityException();
		}
		DeveloperActivityTime work = new DeveloperActivityTime(activityDeveloper, helperDeveloper, hours, dateServer.getDate().get(Calendar.DAY_OF_YEAR));
		workActivity.registerTime(work);
	}
	
	public void registerPrivateActivity(String developerInitials, int startTime, int endTime, String activityName) throws Exception {
		Developer developer = getDeveloper(developerInitials);
		if(developer == null) {
			throw new DeveloperDoesNotExistException();
		}
		if(developer.isAvailable(startTime, endTime) > 0) {
			throw new PrivateActivityDuringWorkActivityException();
		}
		boolean stringMatch = false;
		for(String string: privateActivities) {
			if(string.matches(activityName)) {
				stringMatch = true;
			}
		}
		if(!stringMatch) {
			throw new ActivityDoesNotExistException();
		}
		PrivateActivity privateActivity = new PrivateActivity(activityName, startTime, endTime);
		developer.addPrivateActivity(privateActivity);
	}
	
	public void createAndAddActivityToProject(String developerInitials, int projectID, String activityName) throws Exception {
		Developer developer = getDeveloper(developerInitials);
		if(developer == null) {
			throw new DeveloperDoesNotExistException();
		}
		Project project = getProject(projectID);
		if(project == null) {
			throw new ProjectDoesNotExistException();
		}
		if(!project.getProjectLeader().equals(developer)) {
			throw new NotProjectLeaderException();
		}
		project.createAndAddActivity(activityName);
	}
	
	public void setActivityStartTime(int projectID, String developerInitials, String activityName, int time) throws Exception {
		Project project = getProject(projectID);
		if(project == null) {
			throw new ProjectDoesNotExistException();
		}
		WorkActivity workActivity = project.getActivity(activityName);
		if(workActivity == null) {
			throw new ActivityDoesNotExistException();
		}
		Developer developer = getDeveloper(developerInitials);
		if(developer == null) {
			throw new DeveloperDoesNotExistException();
		}
		workActivity.setStartTime(developer, time);
	}
	
	public void setActivityBudgettetTime(int projectID, String developerInitials, String activityName, int time) throws Exception {
		Project project = getProject(projectID);
		if(project == null) {
			throw new ProjectDoesNotExistException();
		}
		WorkActivity workActivity = project.getActivity(activityName);
		if(workActivity == null) {
			throw new ActivityDoesNotExistException();
		}
		Developer developer = getDeveloper(developerInitials);
		if(developer == null) {
			throw new DeveloperDoesNotExistException();
		}
		workActivity.setBudgetetTime(developer, time);
	}
	
	public void setActivityEndTime(int projectID, String developerInitials, String activityName, int time) throws Exception {
		Project project = getProject(projectID);
		if(project == null) {
			throw new ProjectDoesNotExistException();
		}
		WorkActivity workActivity = project.getActivity(activityName);
		if(workActivity == null) {
			throw new ActivityDoesNotExistException();
		}
		Developer developer = getDeveloper(developerInitials);
		if(developer == null) {
			throw new DeveloperDoesNotExistException();
		}
		workActivity.setEndTime(developer, time);
	}
	
	public void addDeveloperToProjectActivity(String leaderInitials, String developerInitials, 
												int projectID, String activityName) throws Exception {
		Developer projectLeader = getDeveloper(leaderInitials);
		if(projectLeader == null) {
			throw new DeveloperDoesNotExistException();
		}
		Developer developer = getDeveloper(developerInitials);
		if(developer == null) {
			throw new DeveloperDoesNotExistException();
		}
		Project project = getProject(projectID);
		if(project == null) {
			throw new ProjectDoesNotExistException();
		}
		WorkActivity workActivity = project.getActivity(activityName);
		if(workActivity == null) {
			throw new ActivityDoesNotExistException();
		}
		project.addDeveloperToActivity(projectLeader,developer, workActivity);
	}
	
	public List<Developer> getProjectActivityDevelopers(int projectID, String activityName) throws Exception{
		Project project = getProject(projectID);
		if(project == null) {
			throw new ProjectDoesNotExistException();
		}
		WorkActivity workActivity = project.getActivity(activityName);
		if(workActivity == null) {
			throw new ActivityDoesNotExistException();
		}
		return project.getActivityDevelopers(workActivity);
	}

	public void setProjectStartTime(String developerInitials, int projectID, int time) throws Exception {
		Project project = getProject(projectID);
		if(project == null) {
			throw new ProjectDoesNotExistException();
		}
		Developer developer = getDeveloper(developerInitials);
		if(developer == null) {
			throw new DeveloperDoesNotExistException();
		}
		project.setStartTime(developer, time);
	}

	public void setProjectLeader(int projectID, String developerInitials) throws Exception {
		Project project = getProject(projectID);
		if(project == null) {
			throw new ProjectDoesNotExistException();
		}
		Developer developer = getDeveloper(developerInitials);
		if(developer == null) {
			throw new DeveloperDoesNotExistException();
		}
		project.setProjectLeader(developer);
	}

	public void setProjectLeader(int projectID, String leaderInitials, String developerInitials) throws Exception {
		Project project = getProject(projectID);
		if(project == null) {
			throw new ProjectDoesNotExistException();
		}
		Developer leader = getDeveloper(leaderInitials);
		if(leader == null) {
			throw new DeveloperDoesNotExistException();
		}
		Developer newLeader = getDeveloper(developerInitials);
		
		if(newLeader == null) {
			throw new DeveloperDoesNotExistException();
		}
		project.setProjectLeader(leader, newLeader);
	}

	public void setProjectEndTime(String developerInitials, int projectID, int time) throws Exception {
		Project project = getProject(projectID); 
		if(project == null) {
			throw new ProjectDoesNotExistException();
		}
		Developer developer = getDeveloper(developerInitials);
		if(developer == null) {
			throw new DeveloperDoesNotExistException();
		}
		project.setEndTime(developer, time);
	}

	public void editDeveloperActivityTime(int projectID, String developerInitials, String activityName, int time) throws Exception {
		Developer developer = getDeveloper(developerInitials);
		if(developer == null) {
			throw new DeveloperDoesNotExistException();
		}
		Project project = getProject(projectID);
		if(project == null) {
			throw new ProjectDoesNotExistException();
		}
		WorkActivity workActivity = project.getActivity(activityName);
		if(workActivity == null) {
			throw new ActivityDoesNotExistException();
		}
		workActivity.editDeveloperActivityTime(developer, time);
	}
	
	public void setDeveloperCanWorkOn20Activities(String developerInitials, boolean b) throws Exception {
		Developer developer = getDeveloper(developerInitials);
		if(developer == null) {
			throw new DeveloperDoesNotExistException();
		}
		developer.setCanWorkOn20Activities(b);
	}

	public double getDevWorkTimeToday(int projectID, String developerInitials, String activityName) throws Exception {
		Developer developer = getDeveloper(developerInitials);
		if(developer == null) {
			throw new DeveloperDoesNotExistException();
		}
		Project project = getProject(projectID);
		if(project == null) {
			throw new ProjectDoesNotExistException();
		}
		WorkActivity workActivity = project.getActivity(activityName);
		if(workActivity == null) {
			throw new ActivityDoesNotExistException();
		}
		return workActivity.getDevWorkTimeToday(developer);
	}

	public double getTimeSpentActivity(String developerInitials, int projectID, String activityName) throws Exception {
		Developer developer = getDeveloper(developerInitials);
		if(developer == null) {
			throw new DeveloperDoesNotExistException();
		}
		Project project = getProject(projectID);
		if(project == null) {
			throw new ProjectDoesNotExistException();
		}
		WorkActivity workActivity = project.getActivity(activityName);
		if(workActivity == null) {
			throw new ActivityDoesNotExistException();
		}
		return workActivity.getTotalWorkHours();
	}

	public double getTimeSpentProject(String developerInitials, int projectID) throws Exception {
		Developer developer = getDeveloper(developerInitials);
		if(developer == null) {
			throw new DeveloperDoesNotExistException();
		}
		Project project = getProject(projectID);
		if(project == null) {
			throw new ProjectDoesNotExistException();
		}
		return project.getTotalWorkHours();
	}

	public void setProjectBudgettetTime(int projectID, String developerInitials, double time) throws Exception {
		Developer developer = getDeveloper(developerInitials);
		if(developer == null) {
			throw new DeveloperDoesNotExistException();
		}
		Project project = getProject(projectID);
		if(project == null) {
			throw new ProjectDoesNotExistException();
		}
		project.setBudgetetTime(developer, time);
	}

	public double getProjectWorkRemaining(String developerInitials, int projectID) throws Exception {
		Developer developer = getDeveloper(developerInitials);
		if(developer == null) {
			throw new DeveloperDoesNotExistException();
		}
		Project project = getProject(projectID);
		if(project == null) {
			throw new ProjectDoesNotExistException();
		}
		return project.getWorkRemaining();
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
	
	public Project getProject(int projectNumber){
		for(Project project : projects) {
			if(project.getProjectNumber() == projectNumber) {
				return project;
			}
		}
		return null;
	}
	
	public Project getProject(String projectName) throws ProjectDoesNotExistException{
		for(Project project : projects) {
			if(project.getName().equals(projectName)) {
				return project;
			}
		}
		throw new ProjectDoesNotExistException();
	}

	public void addProject(Project project) {
		this.projects.add(project);
	}
	
	public List<Developer> getDevelopers() {
		return developers;
	}

	public Developer getDeveloper(String initials){
		for(Developer d : developers) {
			if(d.getInitials().equals(initials)) {
				return d;
			}
		}
		return null;
	}
	
	public void addDeveloper(Developer developer) {
		if(developers.contains(developer)) {
			return;
		}
		developers.add(developer);
	}
}
