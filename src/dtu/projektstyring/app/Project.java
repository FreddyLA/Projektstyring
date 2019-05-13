package dtu.projektstyring.app;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import dtu.projektstyring.exceptions.ActivityDoesNotExistException;
import dtu.projektstyring.exceptions.CreationDateException;
import dtu.projektstyring.exceptions.NotProjectLeaderException;

public class Project {
	private String projectName; //Unique
	private static int projectCounter = 1;
	private int projectNumber; //Unique
	private ArrayList<WorkActivity> workActivities = new ArrayList<>();
	private Developer projectLeader;
	private int startTime, endTime, creationTime;
	private double budgetetTime;
	private SoftwareHuset softwareHuset;

	public Project(String projectName, int creationTime, SoftwareHuset softwareHuset){
		this.projectName = projectName;
		this.creationTime = creationTime;
		this.projectNumber = Integer.parseInt((projectCounter + "" + Calendar.getInstance().get(Calendar.YEAR)));
		projectCounter++;	
		this.softwareHuset = softwareHuset;
	}
	
	public Report getReport() {
		Report projectReport = new Report(this);
		return projectReport;
	}
	
	public void createAndAddActivity(String activityName) {
		WorkActivity newActivity = new WorkActivity(this, activityName);
		workActivities.add(newActivity);
	}
	
	public ArrayList<WorkActivity> getActivities() {
		ArrayList<WorkActivity> activitiesCopy = new ArrayList<>();;
		for(WorkActivity a: workActivities) {
			activitiesCopy.add(a);
		}
		return activitiesCopy;
	}
	
	public WorkActivity getActivity(String activityName) throws ActivityDoesNotExistException {
		for(WorkActivity a : workActivities) {
			if(a.getName().equals(activityName)) {
				return a;
			}
		}
		return null;
	}
	
	public List<Developer> getActivityDevelopers(WorkActivity workActivity){
		return workActivity.getDevelopers();
	}
	
	public void addDeveloperToActivity(Developer projectLeader, Developer developer, WorkActivity workActivity) throws Exception {
		workActivity.addDeveloper(projectLeader, developer);
	}

	public Developer getProjectLeader() {
		return projectLeader;
	}
	
	//Set an initial project leader for a project
	public void setProjectLeader(Developer projectLeader) throws NotProjectLeaderException {
		if(this.projectLeader != null) {
			throw new NotProjectLeaderException();
		}
		projectLeader.addLeaderOfProject(this);
		this.projectLeader = projectLeader;
	}
	
	//Author: Michael
	//Set a new project leader for a project. Can only be done by project leader
	public void setProjectLeader(Developer projectLeader, Developer newProjectLeader) throws NotProjectLeaderException {
		if(!projectLeader.equals(this.projectLeader)) {
			throw new NotProjectLeaderException();
		}
		newProjectLeader.addLeaderOfProject(this);
		projectLeader.removeLeaderOfProject(this);
		this.projectLeader = newProjectLeader;
	}
	
	public int getStartTime() {
		return startTime;
	}
	
	public void setStartTime(Developer developer, int startTime) throws Exception {
		if(startTime < creationTime) {
			throw new CreationDateException();
		}
		if(!projectLeader.equals(developer)) {
			throw new NotProjectLeaderException();
		}
		this.startTime = startTime;
	}
	
	public double getBudgetetTime() {
		return budgetetTime;
	}
	
	public void setBudgetetTime(Developer developer,double budgetetTime) throws Exception {
		if(!projectLeader.equals(developer)) {
			throw new NotProjectLeaderException();
		}
		this.budgetetTime = budgetetTime;
	}
	
	public int getEndTime() {
		return endTime;
	}
	
	public void setEndTime(Developer developer, int endTime) throws CreationDateException, NotProjectLeaderException {
		if(endTime < creationTime) {
			throw new CreationDateException();
		}
		if(!projectLeader.equals(developer)) {
			throw new NotProjectLeaderException();
		}
		this.endTime = endTime;
	}
	
	public int getCreationTime() {
		return creationTime;
	}
	
	public int getProjectNumber() {
		return projectNumber;
	}
	
	public SoftwareHuset getSoftwareHuset() {
		return softwareHuset;
	}
	
	public String getName() {
		return projectName;
	}
	
	//Author: Frederik
	public double getTotalWorkHours() {
		double totalWorkHours = 0;
		for(WorkActivity workActivity: workActivities) {
			totalWorkHours += workActivity.getTotalWorkHours();
		}
		return totalWorkHours;
	}

	public double getWorkRemaining() {
		return budgetetTime - getTotalWorkHours();
	}
}
