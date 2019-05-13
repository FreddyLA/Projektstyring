package dtu.projektstyring.app;

import dtu.projektstyring.exceptions.StartDateException;

public class PrivateActivity {
	private String activityName; //Unique for activities in project
	private int activityStartTime, activityEndTime;
	
	public PrivateActivity(String activityName, int activityStartTime, int activityEndTime) throws Exception {
		if(activityStartTime > activityEndTime) {
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
	
	public String getName() {
		return activityName;
	}
	public int getActivityStartTime() {
		return activityStartTime;
	}
	public int getActivityEndTime() {
		return activityEndTime;
	}

	public int getActivityCreationTime() {
		return activityCreationTime;
	}
}
