package dtu.projektstyring.app;

import java.util.ArrayList;
import java.util.List;

public class Report {
	
	private String projectName;
	private int projectNumber;
	private List<Activity> activities = new ArrayList<>();
	private String projectLeader;
	private int startTime;
	
	public Report(Project project) {
		this.projectName = project.getName();
		this.projectNumber = project.getProjectNumber();
		this.activities = project.getActivities();
		this.projectLeader = project.getProjectLeader().getInitials();
		this.startTime = project.getStartTime();
	}
	
	public String toString() {
		String projectInfo = String.format("Report for project: %s \n"
								  + "Project number: %d \n"
								  + "Project leader: %s \n"
								  + "Start time: %d \n"
								  , projectName, projectNumber, projectLeader, startTime);
		String activityInfo = "";
		for(Activity activity : activities) {
			activityInfo +=  "\t" + activity + "\n";
		}
		
		projectInfo += activityInfo;
		
		return projectInfo;
	}
	
	public String getProjectName() {
		return projectName;
	}
	
	public int getProjectNumber() {
		return projectNumber;
	}
	
	public List<Activity> getActivities() {
		return activities;
	}
	
	public String getProjectLeader() {
		return projectLeader;
	}
	
	public int getStartTime() {
		return startTime;
	}
}