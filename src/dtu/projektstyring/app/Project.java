package dtu.projektstyring.app;

import java.util.ArrayList;

public class Project {
	private String name; //Unique
	private static int projectCounter = 1;
	private int projectNumber; //Unique
	private ArrayList<Activity> activities = new ArrayList<Activity>();
	private Developer projectLeader;
	private Date startTime;

	Project(){
		this.projectNumber = projectCounter++;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getProjectNumber() {
		return projectNumber;
	}

	public ArrayList<Activity> getActivities() {
		return activities;
	}

	public void addActivity(Activity activities) {
		this.activities.add(activities);
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

	public Developer getProjectLeader() {
		return projectLeader;
	}

	public void setProjectLeader(Developer projectLeader) {
		if(this.projectLeader != null) {
			this.projectLeader.setProjectLeader(false);
		}
		this.projectLeader = projectLeader;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	
	public void getRapport() {
		
	}
}
