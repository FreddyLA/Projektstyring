package dtu.projektstyring.app;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import dtu.projektstyring.exceptions.NotProjectLeaderException;
import dtu.projektstyring.exceptions.PrivateActivityDuringWorkActivityException;
import dtu.projektstyring.exceptions.StartDateException;
import dtu.projektstyring.exceptions.TooManyActivitesException;

public class WorkActivity {
	private String activityName; //Unique for activities in project
	private int activityStartTime, activityEndTime, activityCreationTime; //Week number breakdown
	private double budgetedTime;
	private List<Developer> developers = new ArrayList<>();
	private List<DeveloperActivityTime> totalWork = new ArrayList<>();
	private Project attachedProject;
	
//	//Constructer for an activity with a know start and endtime and budgettet time
//	public WorkActivity(Project attachedProject, String activityName, Calendar activityStartTime, Calendar activityEndTime, double budgetedTime){
//		this.attachedProject = attachedProject;
//		this.activityName = activityName;
//		this.activityStartTime = activityStartTime;
//		this.activityEndTime = activityEndTime;
//		this.budgetedTime = budgetedTime;
//		activityCreationTime = attachedProject.getSoftwareHuset().getDateServer().getDate();
//	}
	
	//Constructer for an activity with only project and name known. Might be better to only have this
	//and set the remaining fields with setters
	public WorkActivity(Project attachedProject, String activityName) {
		this.attachedProject = attachedProject;
		this.activityName = activityName;
		activityCreationTime = attachedProject.getSoftwareHuset().getDateServer().getDate().get(Calendar.WEEK_OF_YEAR);
	}
	
	//Author: Michael
	public double getTotalWorkHours() {
		double totalWorkHours = 0;
		for(DeveloperActivityTime work: totalWork) {
			totalWorkHours += work.getTimeSpent();
		}
		return totalWorkHours;
	}
	
	//Author: Frederik
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
	
	//Author: Kuno
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
	
	//Author: Martin
	//Check if an activity overlaps with a given timeframe
	public boolean inTimeFrame(int startTime, int endTime) {
		if((startTime < this.activityStartTime && endTime < this.activityStartTime) || 
				startTime > this.activityEndTime && endTime > this.activityEndTime) {
			return false;
		}
		return true;
	}
	
	//Author: Michael
	public void addDeveloper(Developer projectLeader, Developer developer) throws Exception {
		if(!attachedProject.getProjectLeader().equals(projectLeader)) {
			throw new NotProjectLeaderException();
		}
		if(developer.isAvailable(activityStartTime, activityEndTime) >= 20) {
			throw new TooManyActivitesException();
		} else if (developer.isAvailable(activityStartTime, activityEndTime) >= 10 && !developer.getCanWorkOn20Activities()) {
			throw new TooManyActivitesException();
		}
		if(developer.hasPrivateActivity(activityStartTime, activityEndTime)) {
			throw new PrivateActivityDuringWorkActivityException();
		}
		this.developers.add(developer);
		developer.addWorkActivity(this);
	}
	
	//Author: Frederik
	//Developer registers an amount of work on an activity
	public void registerTime(DeveloperActivityTime work){
		totalWork.add(work);
	}
	
	//Author: Kuno
	public List<Developer> getDevelopers() {
		List<Developer> developersCopy = new ArrayList<>();
		for(Developer developer: developers) {
			developersCopy.add(developer);
		}
		return developersCopy;
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
	

	public Project getAttachedProject() {
		return attachedProject;
	}
	
	public String getName() {
		return activityName;
	}
}