package dtu.projektstyring.app;

public class DeveloperActivityTime {
	private Developer developer, helperDeveloper; 
	private int timeStampDay; //Day work was performed. Assume work is always registered the day it is performed
	private double timeSpent;
	
	//Constructer for a developer doing work on an activity
	public DeveloperActivityTime(Developer developer, double timeSpent, int timeStampDay) {
		this.developer = developer;
		this.timeSpent = timeSpent;
		this.timeStampDay = timeStampDay;
	}
	
	//Constructer for a developer getting help on an activity
	public DeveloperActivityTime(Developer developer, Developer helperDeveloper, double timeSpent, int timeStampDay) {
		this.developer = developer;
		this.helperDeveloper = helperDeveloper;
		this.timeSpent = timeSpent;
		this.timeStampDay = timeStampDay;
	}
	
	public int getTimeStamp() {
		return timeStampDay;
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
