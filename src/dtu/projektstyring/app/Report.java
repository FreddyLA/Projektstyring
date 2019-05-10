package dtu.projektstyring.app;

import java.util.ArrayList;
import java.util.List;

public class Report {
	
	private String projectName;
	private int projectNumber;
	private List<WorkActivity> workActivities = new ArrayList<>();
	private String projectLeader;
	private int startTime;
	
	public Report(Project project) {
		this.projectName = project.getName();
		this.projectNumber = project.getProjectNumber();
		this.workActivities = project.getActivities();
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
		for(WorkActivity workActivity : workActivities) {
			activityInfo +=  "\t" + workActivity + "\n";
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
	
	public List<WorkActivity> getActivities() {
		return workActivities;
	}
	
	public String getProjectLeader() {
		return projectLeader;
	}
	
	public int getStartTime() {
		return startTime;
	}
}