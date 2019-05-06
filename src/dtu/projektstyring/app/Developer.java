package dtu.projektstyring.app;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Developer {
	private String developerName;
	private String developerInitials; //Unique
	private boolean canWorkOn20Activities;
	private List<Project> leaderOf = new ArrayList<>();
	private List<Activity> activities = new ArrayList<>();
	private List<DeveloperActivityTime> workDone = new ArrayList<>();
	private SoftwareHuset softwareHuset;
	
	public Developer(String developerName, String developerInitials, SoftwareHuset softwareHuset){
		this.developerName = developerName;
		this.developerInitials = developerInitials;
		this.softwareHuset = softwareHuset;
	}
	
	//Returns true if a developer is free in a given time frame
	public boolean isAvailable(int startTime, int endTime) {
		int activitiesInTimeFrame = 0;
		for(Activity activity: activities) {
			if(activity.inTimeFrame(startTime, endTime)) {
				activitiesInTimeFrame++;
			}
		}
		if(activitiesInTimeFrame >= 10 && !canWorkOn20Activities) {
			return false;
		} else if (activitiesInTimeFrame >= 20) {
			return false;
		}
		return true;
	}
	
	public double workDoneToday() {
		double workDoneToday = 0;
		for(int i = workDone.size() - 1; i >= 0; i--) {
			if(workDone.get(i).getTimeStamp() == softwareHuset.getDateServer().getDate().get(Calendar.DAY_OF_YEAR)) {
				workDoneToday += workDone.get(i).getTimeSpent();
			}
		}
		return workDoneToday;
	}
	
	public void registerWork(DeveloperActivityTime work) {
		workDone.add(work);
	}
	
	public List<Project> getLeaderProjects() {
		return leaderOf;
	}

	public void addLeaderOfProject(Project project) {
		leaderOf.add(project);
	}
	
	public void removeLeaderOfProject(Project project) {
		leaderOf.remove(project);
	}
	
	public List<Activity> getActivities() {
		return activities;
	}

	public void addActivity(Activity activity) {
		activities.add(activity);
	}
	
	public boolean removeActivity(Activity activity) {
		return activities.remove(activity);
	}
	
	public String getInitials() {
		return developerInitials;
	}

	public void setInitials(String developerInitials) {
		this.developerInitials = developerInitials;
	}
	
	public String getName() {
		return developerName;
	}

	public void setName(String developerName) {
		this.developerName = developerName;
	}
	
	public boolean getCanWorkOn20Activities() {
		return canWorkOn20Activities;
	}
	
	public void setCanWorkOn20Activities(boolean b) {
		canWorkOn20Activities = b;
	}
}
