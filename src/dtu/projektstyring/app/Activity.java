package dtu.projektstyring.app;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import dtu.projektstyring.exceptions.NotProjectLeaderException;
import dtu.projektstyring.exceptions.StartDateException;
import dtu.projektstyring.exceptions.TooManyActivitesException;

public class Activity {
	private String activityName; //Unique for activities in project
	private int activityStartTime, activityEndTime, activityCreationTime; //Week number breakdown
	private double budgetedTime;
	private List<Developer> developers = new ArrayList<>();
	private List<DeveloperActivityTime> totalWork = new ArrayList<>();
	private Project attachedProject;
	
//	//Constructer for an activity with a know start and endtime and budgettet time
//	public Activity(Project attachedProject, String activityName, Calendar activityStartTime, Calendar activityEndTime, double budgetedTime){
//		this.attachedProject = attachedProject;
//		this.activityName = activityName;
//		this.activityStartTime = activityStartTime;
//		this.activityEndTime = activityEndTime;
//		this.budgetedTime = budgetedTime;
//		activityCreationTime = attachedProject.getSoftwareHuset().getDateServer().getDate();
//	}
	
	//Constructer for an activity with only project and name known. Might be better to only have this
	//and set the remaining fields with setters
	public Activity(Project attachedProject, String activityName) {
		this.attachedProject = attachedProject;
		this.activityName = activityName;
		activityCreationTime = attachedProject.getSoftwareHuset().getDateServer().getDate().get(Calendar.WEEK_OF_YEAR);
	}
	
	//Constructer for private activities. Needs work
	public Activity(String activityName) {
		this.activityName = activityName;
	}
	
	//Returns amount of work a developer has done on an activity
	public double getDevWorkTime(Developer developer) {
		double developerWorkTime = 0;
		for(DeveloperActivityTime work: totalWork) {
			if(work.getDeveloper().equals(developer)) {
				developerWorkTime += work.getTimeSpent();
			}
		}
		return developerWorkTime;
	}
	
	//Returns the amount of work a developer has done on an activity on the current day
	public double getDevWorkTimeToday(Developer developer) {
		double developerWorkTime = 0;
		for(DeveloperActivityTime work: totalWork) {
			if(work.getDeveloper().equals(developer) && work.getTimeStamp()
					== attachedProject.getSoftwareHuset().getDateServer().getDate().get(Calendar.DAY_OF_YEAR)) {
				developerWorkTime = work.getTimeSpent();
				return developerWorkTime;
			}
		}
		return developerWorkTime;
	}
	
	//For changing the amount of hours a developer has worked on the activity. Assumes work was on the same day
	//and only one piece of work has be registered
	public void editDeveloperActivityTime(Developer developer, double newHours) {
		for(DeveloperActivityTime work: totalWork) {
			if(work.getDeveloper().equals(developer) && 
					work.getTimeStamp()
						== attachedProject.getSoftwareHuset().getDateServer().getDate().get(Calendar.DAY_OF_YEAR)) {
				work.setTimeSpent(newHours);
				return;
			}
		}
	}
	
	//Check if an activity overlaps with a given timeframe
	public boolean inTimeFrame(int startTime, int endTime) {
		if((startTime < getStartTime() && endTime < getStartTime()) || 
				startTime > getEndTime() && endTime > getEndTime()) {
			return false;
		}
		return true;
	}
	
	public void addDeveloper(Developer projectLeader, Developer developer) throws Exception {
		if(!attachedProject.getProjectLeader().equals(projectLeader)) {
			throw new NotProjectLeaderException();
		}
		if(developer.getActivities().size() == 10) {
			throw new TooManyActivitesException();
		}
		this.developers.add(developer);
		developer.addActivity(this);
	}
	
	public double getTotalWorkHours() {
		double totalWorkHours = 0;
		for(DeveloperActivityTime work: totalWork) {
			totalWorkHours += work.getTimeSpent();
		}
		return totalWorkHours;
	}
	
	public boolean removeDeveloper(Developer developer) {
		developer.removeActivity(this);
		return this.developers.remove(developer);
	}
	
	public void removeActivityFromAllDevelopers() {
		for(Developer d : this.developers) {
			d.removeActivity(this);
		}
		this.developers.clear();
	}
	
	public String toString() {
		return "Name: " + activityName + " Budgeted time: " + budgetedTime + " Time spent: " + getTotalWorkHours();
	}
	
	//Developer registers an amount of work on an activity
	public void registerTime(DeveloperActivityTime work){
		totalWork.add(work);
	}
	
	public List<Developer> getDevelopers() {
		return developers;
	}
	
	public int getStartTime() {
		return activityStartTime;
	}
	
	//Set start time of activity. Can't be before creation time of activity
	public void setStartTime(Developer developer, int activityStartTime) throws Exception {
		if(!attachedProject.getProjectLeader().equals(developer)) {
			throw new NotProjectLeaderException();
		}
		if(activityStartTime < activityCreationTime) {
			throw new StartDateException();
		}
		this.activityStartTime = activityStartTime;
	}
	
	public int getEndTime() {
		return activityEndTime;
	}
	
	//Set end time for an activity. Can't be before start time or creation time
	public void setEndTime(Developer developer, int activityEndTime) throws Exception {
		if(activityEndTime < activityStartTime || activityEndTime < activityCreationTime) {
			throw new StartDateException();
		}
		if(!attachedProject.getProjectLeader().equals(developer)) {
			throw new NotProjectLeaderException();
		}
		this.activityEndTime = activityEndTime;
	}

	
	public double getBudgetedTime() {
		return budgetedTime;
	}

	public void setBudgetetTime(Developer developer, double budgetedTime) throws NotProjectLeaderException {
		if(!attachedProject.getProjectLeader().equals(developer)) {
			throw new NotProjectLeaderException();
		}
		this.budgetedTime = budgetedTime;
	}
	
	public int getCreationTime() {
		return activityCreationTime;
	}

	public Project getAttachedProject() {
		return attachedProject;
	}

	public void setAttachedProject(Project attachedProject) {
		this.attachedProject = attachedProject;
	}
	
	public String getName() {
		return activityName;
	}

	public void setName(String name) {
		this.activityName = name;
	}
}