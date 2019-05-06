package dtu.projektstyring.app;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import dtu.projektstyring.exceptions.NotProjectLeaderException;
import dtu.projektstyring.exceptions.StartDateException;
import dtu.projektstyring.exceptions.TooManyActivitesException;

public class Activity {
	private String name; //Unique for activities in project
	private Date startTime;
	private Date endTime;
	private double budgetetTime;
	private List<Developer> developers = new ArrayList<>();
	private List<DeveloperActivityTime> totalWork = new ArrayList<>();
	private Project attachedProject;
	
	Activity(Project project, String name, Date startTime, Date endTime, double budgetTime){
		this.attachedProject = project;
		this.name = name;
		this.startTime = startTime;
		this.endTime = endTime;
		this.budgetetTime = budgetTime;
	}
	
	Activity(Project project, String activityName) {
		this.attachedProject = project;
		this.name = activityName;
	}

	public Activity(String activityName) {
		this.name = activityName;
	}

	public void registerTime(DeveloperActivityTime work){
		totalWork.add(work);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getStartTime() {
		return startTime;
	}
	
	public boolean inTimeFrame(Date startTime2, Date endTime2) {
		if((startTime2.before(startTime) && endTime2.before(endTime)) || startTime2.after(startTime) && endTime2.after(endTime)) {
			return false;
		}
		return true;
	}

	public void setStartTime(Developer dev,Date startTime) throws NotProjectLeaderException {
		if(!attachedProject.getProjectLeader().equals(dev)) {
			throw new NotProjectLeaderException();
		}
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}
	
	public double getDevWorkTime(Developer dev) {
		double devWorkTime = 0;
		for(DeveloperActivityTime t: totalWork) {
			if(t.getDev().equals(dev)) {
				devWorkTime += t.getTime();
			}
		}
		return devWorkTime;
	}

	public void setEndTime(Developer dev, Date endTime) throws Exception {
		if(endTime.before(startTime)) {
			throw new StartDateException();
		}
		if(!attachedProject.getProjectLeader().equals(dev)) {
			throw new NotProjectLeaderException();
		}
		this.endTime = endTime;
	}

	public double getBudgetetTime() {
		return budgetetTime;
	}

	public void setBudgetetTime(Developer dev, double budgetetTime) throws NotProjectLeaderException {
		if(!attachedProject.getProjectLeader().equals(dev)) {
			throw new NotProjectLeaderException();
		}
		this.budgetetTime = budgetetTime;
	}

	public List<Developer> getDevelopers() {
		return developers;
	}

	public void addDeveloper(Developer dev, Developer developer) throws Exception {
		if(!attachedProject.getProjectLeader().equals(dev)) {
			throw new NotProjectLeaderException();
		}
		if(developer.getActivities().size() == 10) {
			throw new TooManyActivitesException();
		}
		this.developers.add(developer);
		developer.addActivities(this);
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

	public Project getAttachedProject() {
		return attachedProject;
	}

	public void setAttachedProject(Project attachedProject) {
		this.attachedProject = attachedProject;
	}
}