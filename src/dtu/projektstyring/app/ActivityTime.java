package dtu.projektstyring.app;

public class ActivityTime {
	private Activity activity;
	private Developer dev, helperDev; 
	private double timeSpent;
	
	public ActivityTime(Developer dev, Activity activity, double timeSpent) {
		this.dev = dev;
		this.activity = activity;
		this.timeSpent = timeSpent;
	}
	
	public ActivityTime(Developer dev, Developer helperDev, Activity activity, double timeSpent) {
		this.dev = dev;
		this.helperDev = helperDev;
		this.activity = activity;
		this.timeSpent = timeSpent;
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
