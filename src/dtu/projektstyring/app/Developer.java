package dtu.projektstyring.app;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Developer {
	private String developerName;
	private String developerInitials; //Unique
	private boolean canWorkOn20Activities;
	private List<Project> leaderOf = new ArrayList<>();
	private List<WorkActivity> workActivities = new ArrayList<>();
	private List<DeveloperActivityTime> workDone = new ArrayList<>();
	private List<PrivateActivity> privateActivities = new ArrayList<>();
	private SoftwareHuset softwareHuset;
	
	public Developer(String developerName, String developerInitials, SoftwareHuset softwareHuset){
		this.developerName = developerName;
		this.developerInitials = developerInitials;
		this.softwareHuset = softwareHuset;
	}
	
	//Returns true if a developer is free in a given time frame
	public int isAvailable(int startTime, int endTime) {
		int activitiesInTimeFrame = 0;
		
		for(WorkActivity workActivity: workActivities) {
			if(workActivity.inTimeFrame(startTime, endTime)) {
				activitiesInTimeFrame++;
			}
		}
		return activitiesInTimeFrame;
	}
	
	public boolean hasPrivateActivity(int activityStartTime, int activityEndTime) {
		for(PrivateActivity privateActivity: privateActivities) {
			if(privateActivity.inTimeFrame(activityStartTime, activityEndTime)) {
				return true;
			}
		}
		return false;
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
	
	public List<PrivateActivity> getPrivateActivities() {
		return privateActivities;
	}
	
	public PrivateActivity getPrivateActivity(String activityName) {
		for(PrivateActivity privateActivity: privateActivities) {
			if(privateActivity.getName().matches(activityName)) {
				return privateActivity;
			}
		}
		return null;
	}

	public void addPrivateActivity(PrivateActivity privateActivity) {
		privateActivities.add(privateActivity);
	}
	
	public boolean removePrivateActivity(PrivateActivity privateActivity) {
		return privateActivities.remove(privateActivity);
	}
	
	public List<WorkActivity> getWorkActivities() {
		return workActivities;
	}

	public void addWorkActivity(WorkActivity workActivity) {
		workActivities.add(workActivity);
	}
	
	public boolean removeWorkActivity(WorkActivity workActivity) {
		return workActivities.remove(workActivity);
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
