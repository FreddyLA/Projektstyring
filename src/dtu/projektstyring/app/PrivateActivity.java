package dtu.projektstyring.app;

import dtu.projektstyring.exceptions.StartDateException;

public class PrivateActivity {
	private String activityName; //Unique for activities in project
	private int activityStartTime, activityEndTime, activityCreationTime;
	
	public PrivateActivity(String activityName, int activityStartTime, int activityEndTime) throws Exception {
		if(activityStartTime < activityEndTime) {
			throw new StartDateException();
		}
		this.activityName = activityName;
		this.activityStartTime = activityStartTime;
		this.activityEndTime = activityEndTime;
	}
	
	public boolean inTimeFrame(int startTime, int endTime) {
		if((startTime < this.activityStartTime && endTime < this.activityStartTime) || 
				startTime > this.activityEndTime && endTime > this.activityEndTime) {
			return false;
		}
		return true;
	}
	
	public int getStartTime() {
		return activityStartTime;
	}
	
	//Set start time of activity. Can't be before creation time of activity
	public void setStartTime(Developer developer, int activityStartTime) throws Exception {
		if(activityStartTime < activityCreationTime) {
			throw new StartDateException();
		}
		this.activityStartTime = activityStartTime;
	}
	
	public int getEndTime() {
		return activityEndTime;
	}
	
	public void setEndTime(Developer developer, int activityEndTime) throws Exception {
		if(activityEndTime < activityStartTime || activityEndTime < activityCreationTime) {
			throw new StartDateException();
		}
		this.activityEndTime = activityEndTime;
	}
	
	public int getCreationTime() {
		return activityCreationTime;
	}
	
	public String getName() {
		return activityName;
	}
}
