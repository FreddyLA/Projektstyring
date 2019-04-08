package dtu.projektstyring.app;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Activity {
	private String name;
	private Date startTime;
	private Date endTime;
	private double budgetetTime;
	private List<Developer> developers = new ArrayList<Developer>();
	private String attachedProject;
	
	public void registerTime(){
		
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

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public double getBudgetetTime() {
		return budgetetTime;
	}

	public void setBudgetetTime(double budgetetTime) {
		this.budgetetTime = budgetetTime;
	}

	public List<Developer> getDevelopers() {
		return developers;
	}

	public void addDeveloper(List<Developer> developers) {
		this.developers = developers;
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

	public String getAttachedProject() {
		return attachedProject;
	}

	public void setAttachedProject(String attachedProject) {
		this.attachedProject = attachedProject;
	}
}