package dtu.projektstyring.app;

import java.util.ArrayList;
import java.util.List;

import dtu.projektstyring.exceptions.CreationDateException;
import dtu.projektstyring.exceptions.NotProjectLeaderException;

public class Project {
	private String projectName; //Unique
	private static int projectCounter = 1;
	private int projectNumber; //Unique
	private ArrayList<WorkActivity> workActivities = new ArrayList<>();
	private Developer projectLeader;
	private int startTime, endTime, creationTime;
	private SoftwareHuset softwareHuset;

	public Project(String projectName, int creationTime, SoftwareHuset softwareHuset){
		this.projectName = projectName;
		this.creationTime = creationTime;
		this.projectNumber = projectCounter++;
		this.softwareHuset = softwareHuset;
	}
	
	public Report getReport() {
		Report projectReport = new Report(this);
		return projectReport;
	}
	
//	public WorkActivity createAndAddActivity(String activityName, Calendar activityStartTime, Calendar activityEndTime,
//			double activityBudgetTime) {
//		WorkActivity newActivity = new WorkActivity(this, activityName, activityStartTime, activityEndTime, activityBudgetTime);
//		workActivities.add(newActivity);
//		return newActivity;
//	}
	
	public void createAndAddActivity(String activityName) {
		WorkActivity newActivity = new WorkActivity(this, activityName);
		workActivities.add(newActivity);
	}

	public void addActivity(WorkActivity workActivity) {
		this.workActivities.add(workActivity);
	}
	
	public ArrayList<WorkActivity> getActivities() {
		ArrayList<WorkActivity> rActivities = new ArrayList<>();;
		for(WorkActivity a: workActivities) {
			rActivities.add(a);
		}
		return rActivities;
	}
	
	public WorkActivity getActivity(String activityName) {
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
	
	public void setStartTime(int startTime) throws Exception {
		if(startTime < creationTime) {
			throw new CreationDateException();
		}
		this.startTime = startTime;
	}
	
	public int getEndTime() {
		return endTime;
	}
	
	public void setEndTime(int endTime) throws CreationDateException {
		if(endTime < creationTime) {
			throw new CreationDateException();
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

	public void setName(String projectName) {
		this.projectName = projectName;
	}
}
