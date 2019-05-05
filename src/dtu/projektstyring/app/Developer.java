package dtu.projektstyring.app;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class Developer {
	private String name;
	private String initials; //Unique
	private boolean canWorkOn20Activities;
	private List<Project> leaderOf = new ArrayList<>();
	private List<Activity> activities = new ArrayList<>();
	private List<String> schedule = new ArrayList<>();
	
	public Developer(String name, String initials){
		this.name = name;
		this.initials = initials;
	}
	
	public void registerSchedule(Date from, Date to, String description) {
		String temp = from.toString().concat(",").concat(to.toString()).concat(",").concat(description);
		schedule.add(temp);
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
	
	public void removeFromSchedule(int index) {
		schedule.remove(index);
	}
	
	public List<String> getFullSchedule(){
		return schedule;
	}
	
	public String getSchedule(int index) {
		return schedule.get(index);
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
}
