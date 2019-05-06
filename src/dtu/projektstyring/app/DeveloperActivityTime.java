package dtu.projektstyring.app;

import java.util.Calendar;
import java.util.Date;

public class DeveloperActivityTime {
	private Activity attachedActivity;
	private Developer developer, helperDeveloper; 
	private Calendar timeStamp; //Day work was performed. Assume work is always registered the day it is performed
	private double timeSpent;
	
	//Constructer for a developer doing work on an activity
	public DeveloperActivityTime(Developer developer, Activity attachedActivity, double timeSpent, Calendar timeStamp) {
		this.developer = developer;
		this.attachedActivity = attachedActivity;
		this.timeSpent = timeSpent;
		this.timeStamp = timeStamp;
	}
	
	//Constructer for a developer getting help on an activity
	public DeveloperActivityTime(Developer developer, Developer helperDeveloper, Activity attachedActivity, double timeSpent, Calendar timeStamp) {
		this.developer = developer;
		this.helperDeveloper = helperDeveloper;
		this.attachedActivity = attachedActivity;
		this.timeSpent = timeSpent;
		this.timeStamp = timeStamp;
	}
	
	public int getTimeStamp() {
		return timeStamp.get(Calendar.DAY_OF_YEAR);
	}
	
	public double getTimeSpent() {
		return timeSpent;
	}
	
	//For editing time spent on an amount of work
	public void setTimeSpent(double timeSpent) {
		this.timeSpent = timeSpent;
	}
	
	//Returns developer responsible for work. helperDeveloper is returned if developer got help else developer is returned
	public Developer getDeveloper() {
		if(helperDeveloper != null) {
			return helperDeveloper;
		}
		return developer;
	}
}
