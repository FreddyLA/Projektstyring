package dtu.projektstyring.app;

import java.util.ArrayList;
import java.util.List;

import dtu.projektstyring.exceptions.CreationDateException;
import dtu.projektstyring.exceptions.NotProjectLeaderException;

public class Project {
	private String projectName; //Unique
	private static int projectCounter = 1;
	private int projectNumber; //Unique
	private ArrayList<Activity> activities = new ArrayList<>();
	private Developer projectLeader;
	private int startTime, creationTime;
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
	
//	public Activity createAndAddActivity(String activityName, Calendar activityStartTime, Calendar activityEndTime,
//			double activityBudgetTime) {
//		Activity newActivity = new Activity(this, activityName, activityStartTime, activityEndTime, activityBudgetTime);
//		activities.add(newActivity);
//		return newActivity;
//	}
	
	public void createAndAddActivity(String activityName) {
		Activity newActivity = new Activity(this, activityName);
		activities.add(newActivity);
	}

	public void addActivity(Activity activity) {
		this.activities.add(activity);
	}
	
	public ArrayList<Activity> getActivities() {
		ArrayList<Activity> rActivities = new ArrayList<>();;
		for(Activity a: activities) {
			rActivities.add(a);
		}
		return rActivities;
	}
	
	public Activity getActivity(String activityName) {
		for(Activity a : activities) {
			if(a.getName().equals(activityName)) {
				return a;
			}
		}
		return null;
	}
	
	public boolean removeActivity(Activity activity) {
		activity.removeActivityFromAllDevelopers();
		return this.activities.remove(activity);
	}
	
	public boolean removeAllActivities() {
		for(Activity a : this.activities) {
			a.removeActivityFromAllDevelopers();
			this.activities.remove(a);
			return true;
		}
		return false;
	}
	
	public List<Developer> getActivityDevelopers(Activity activity){
		return activity.getDevelopers();
	}
	
	public void addDeveloperToActivity(Developer projectLeader, Developer developer, Activity activity) throws Exception {
		activity.addDeveloper(projectLeader, developer);
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
