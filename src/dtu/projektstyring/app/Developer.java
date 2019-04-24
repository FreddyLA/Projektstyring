package dtu.projektstyring.app;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class Developer {
	private String name;
	private String initials; //Unique
	private boolean isProjectLeader;
	private List<Activity> activities = new ArrayList<Activity>();
	private List<String> schedule = new ArrayList<String>();
	
	public Developer(String name, String initials){
		this.name = name;
		this.initials = initials;
	}
	
	public void registerSchedule(Date from, Date to, String description) {
		String temp = from.toString().concat(",").concat(to.toString()).concat(",").concat(description);
		schedule.add(temp);
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

	public boolean isProjectLeader() {
		return isProjectLeader;
	}

	public void setProjectLeader(boolean isProjectLeader) {
		this.isProjectLeader = isProjectLeader;
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

	public List<Activity> getActivities() {
		return activities;
	}

	public void addActivities(Activity activity) {
		this.activities.add(activity);
	}
	
	public boolean removeActivity(Activity activity) {
		return this.activities.remove(activity);
	}
}
