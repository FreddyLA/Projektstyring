package dtu.projektstyring.app;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import dtu.projektstyring.exceptions.CreationDateException;
import dtu.projektstyring.exceptions.NotProjectLeaderException;

public class Project {
	private String name; //Unique
	private static int projectCounter = 1;
	private int projectNumber; //Unique
	private ArrayList<Activity> activities = new ArrayList<>();
	private Developer projectLeader;
	private Date startTime, creationTime;

	public Project(String name, Date date){
		this.name = name;
		this.creationTime = date;
		this.projectNumber = projectCounter++;
	}
	
	public void getRapport() {
		
	}
	
	public Activity createAndAddActivity(String activityName, Date activityStartTime, Date activityEndTime,
			double activityBudgetTime) {
		Activity newActivity = new Activity(this, activityName, activityStartTime, activityEndTime, activityBudgetTime);
		activities.add(newActivity);
		return newActivity;
	}
	
	public Activity createAndAddActivity(String activityName) {
		Activity newActivity = new Activity(this, activityName);
		activities.add(newActivity);
		return newActivity;
	}
	
	public void addDeveloperToActivity(Developer projectLeader, Developer developer, Activity activity) throws Exception {
		activity.addDeveloper(projectLeader, developer);
	}

	public void addActivity(Activity activity) {
		this.activities.add(activity);
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

	public Date getStartTime() {
		return startTime;
	}
	
	public void setStartTime(Date startTime) throws Exception {
		if(startTime.before(creationTime)) {
			throw new CreationDateException();
		}
		this.startTime = startTime;
	}
	
	public List<Developer> getActivityDevelopers(Activity activity){
		return activity.getDevelopers();
	}
	
	public ArrayList<Activity> getActivities() {
		ArrayList<Activity> rActivities = new ArrayList<>();;
		for(Activity a: activities) {
			rActivities.add(a);
		}
		return rActivities;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Developer getProjectLeader() {
		return projectLeader;
	}
	
	public void setProjectLeader(Developer projectLeader) throws NotProjectLeaderException {
		if(this.projectLeader != null) {
			throw new NotProjectLeaderException();
		}
		projectLeader.addLeaderOfProject(this);
		this.projectLeader = projectLeader;
	}

	public void setProjectLeader(Developer leader, Developer newLeader) throws NotProjectLeaderException {
		if(!projectLeader.equals(leader)) {
			throw new NotProjectLeaderException();
		}
		newLeader.addLeaderOfProject(this);
		projectLeader.removeLeaderOfProject(this);
		projectLeader = newLeader;
	}
	
	public Date getCreationTime() {
		return creationTime;
	}
	
	public int getProjectNumber() {
		return projectNumber;
	}
}
