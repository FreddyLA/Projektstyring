package dtu.projektstyring.app;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Date;

public class Developer {
	private String name;
	private String initials; //Unique
	private boolean canWorkOn20Activities;
	private List<Project> leaderOf = new ArrayList<>();
	private List<Activity> activities = new ArrayList<>();
	private List<DeveloperActivityTime> workDone = new ArrayList<>();
	private SoftwareHuset sh;
	
	public Developer(String name, String initials, SoftwareHuset sh){
		this.name = name;
		this.initials = initials;
		this.sh = sh;
	}
	
	public boolean isAvailable(Date startTime, Date endTime) {
		int activitiesInTimeFrame = 0;
		for(Activity a: activities) {
			if(a.inTimeFrame(startTime, endTime)) {
				activitiesInTimeFrame++;
			}
		}
		if(activitiesInTimeFrame == 10) {
			return false;
		}
		return true;
	}
	
	public double workDoneToday() {
		double workDoneToday = 0;
		for(int i = workDone.size() - 1; i >= 0; i--) {
			if(workDone.get(i).getTimeStamp().get(Calendar.DAY_OF_YEAR) == sh.getDateServer().getDate().get(Calendar.DAY_OF_YEAR)) {
				workDoneToday += workDone.get(i).getTime();
			}
		}
		return workDoneToday;
	}
	
	public void registerWork(DeveloperActivityTime work) {
		workDone.add(work);
	}

	public String getInitials() {
		return initials;
	}

	public void setInitials(String initials) {
		this.initials = initials;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public List<Project> getLeaderProjects() {
		return leaderOf;
	}

	public List<Activity> getActivities() {
		return activities;
	}

	public void addActivities(Activity activity) {
		this.activities.add(activity);
	}
	
	public void addLeaderOfProject(Project project) {
		leaderOf.add(project);
	}
	
	public void removeLeaderOfProject(Project project) {
		leaderOf.remove(project);
	}
	
	public boolean removeActivity(Activity activity) {
		return this.activities.remove(activity);
	}
	
	public boolean getCanWorkOn20Activities() {
		return canWorkOn20Activities;
	}
	
	public void setCanWorkOn20Activities(boolean b) {
		canWorkOn20Activities = b;
	}
}
