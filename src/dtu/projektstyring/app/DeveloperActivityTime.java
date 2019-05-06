package dtu.projektstyring.app;

import java.util.Calendar;
import java.util.Date;

public class DeveloperActivityTime {
	private Activity activity;
	private Developer dev, helperDev; 
	private Calendar timeStamp;
	private double timeSpent;
	
	public DeveloperActivityTime(Developer dev, Activity activity, double timeSpent, Calendar timeStamp) {
		this.dev = dev;
		this.activity = activity;
		this.timeSpent = timeSpent;
		this.timeStamp = timeStamp;
	}
	
	public DeveloperActivityTime(Developer dev, Developer helperDev, Activity activity, double timeSpent) {
		this.dev = dev;
		this.helperDev = helperDev;
		this.activity = activity;
		this.timeSpent = timeSpent;
	}
	
	public Calendar getTimeStamp() {
		return timeStamp;
	}
	
	public double getTime() {
		return timeSpent;
	}
	
	public void setTime(double newTime) {
		this.timeSpent = newTime;
	}
	
	public Developer getDev() {
		if(helperDev != null) {
			return helperDev;
		}
		return dev;
	}
}
