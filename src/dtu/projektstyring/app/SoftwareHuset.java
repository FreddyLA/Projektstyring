package dtu.projektstyring.app;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import dtu.projektstyring.app.DateServer;
import dtu.projektstyring.exceptions.DuplicateNameException;
import dtu.projektstyring.exceptions.NotOnActivityException;
import dtu.projektstyring.exceptions.NotProjectLeaderException;

public class SoftwareHuset {
	
	private List<Developer> developers = new ArrayList<>();
	private List<Project> projects = new ArrayList<>();
	private List<Activity> privateActivities = new ArrayList<>();
	private DateServer dateServer = new DateServer();
	private List<String> work = new ArrayList<>();
	private List<String> globalSchedules = new ArrayList<>();
	
	//**********TIL TESTING**********//
	public SoftwareHuset() {
		
		Developer defDev = new Developer("John Doe", "JDO", this);
		developers.add(defDev);
		
		Developer newDev = new Developer("Mike Johnson", "MJO", this);
		developers.add(newDev);
		newDev = new Developer("Elias Sandder", "ESA", this);
		developers.add(newDev);
		newDev = new Developer("Melissa Kullins", "MKU", this);
		developers.add(newDev);
		
		Project defProj = new Project("Proj1", dateServer.getDate());
		try {
			defProj.setProjectLeader(defDev);
		} catch (NotProjectLeaderException e) {
			e.printStackTrace();
		}
		projects.add(defProj);
		
		Activity vacation = new Activity("Vacation");
		Activity sickness = new Activity("Sickness");
		privateActivities.add(vacation);
		privateActivities.add(sickness);
		
	}
	//*******************************//
	
	public boolean makeProject(Developer dev, String name) throws Exception {
		if(!projects.isEmpty()) {
			for(Project p : projects) {
				if(p.getName().equals(name)) {
					throw new DuplicateNameException();
					//return false;
				}
			}
		}
		Project newProject = new Project(name, dateServer.getDate());
		projects.add(newProject);
		return true;
	}
	
	public List<Developer> findAvailableDevelopers(Developer projectLeader, int projectNumber, String activityName) throws Exception {
		Project p = getProject(projectNumber);
		Activity a = p.getActivity(activityName);
		List<Developer> availableDevs = new ArrayList<>();
		for(Developer d: developers) {
			if(d.isAvailable(a.getStartTime(), a.getEndTime())) {
				availableDevs.add(d);
			}
		}
		return availableDevs;
	}
	
	public void addActivityToProject(int projectNum, String activityName, Date activityStartTime, Date activityEndTime, double activityBudgetTime) throws Exception {
		Project p = getProject(projectNum);
		p.createAndAddActivity(activityName, activityStartTime, activityEndTime, activityBudgetTime);
	}
	
	public void addActivityToProject(String projectName, String activityName, Date activityStartTime, Date activityEndTime, double activityBudgetTime) throws Exception {
		Project p = getProject(projectName);
		p.createAndAddActivity(activityName, activityStartTime, activityEndTime, activityBudgetTime);
	}
	
	public Rapport getRapport(Developer dev, int projectNumber) throws Exception {
		Project p = getProject(projectNumber);
		if(!p.getProjectLeader().equals(dev)) {
			throw new NotProjectLeaderException();
		}
		return new Rapport();
	}
	
	public Developer getProjectProjectLeader(String name) throws Exception { 
        Project tmp = getProject(name); 
        return tmp.getProjectLeader(); 
    }
	
	public void registerTime(Developer developer, int projectNumber, String activityName, double hours) throws Exception {
		//Developer d = getDeveloper(developerInitials);
		Date date = Calendar.getInstance().getTime();
		Project p = getProject(projectNumber);
		Activity a = p.getActivity(activityName);
		if(developer == null) throw new Exception("Developer does not exist");
		else if(p == null) throw new Exception("Specified project does not exist");
		else if(a == null) throw new Exception("Specified activity of the project does not exist");
		else if(!a.getDevelopers().contains(developer)) throw new NotOnActivityException();
		
		if(a.getDevelopers().contains(developer)) {
			DeveloperActivityTime work = new DeveloperActivityTime(developer, a, hours, dateServer.getDate());
			a.registerTime(work);
			developer.registerWork(work);
		}
	}
	
	public void registerHelpedTime(Developer activityDeveloper, Developer helper, int projectNumber, String activityName, int hours) throws Exception {
		Project p = getProject(projectNumber);
		Activity a = p.getActivity(activityName);
		if(!a.getDevelopers().contains(activityDeveloper)) {
			throw new NotOnActivityException();
		}
		DeveloperActivityTime work = new DeveloperActivityTime(activityDeveloper, helper, a, hours);
		a.registerTime(work);
	}
	
	public Activity createAndAddActivityToProject(Project project, String activityName, Date activityStartTime, Date activityEndTime, double activityBudgetTime) {
		return project.createAndAddActivity(activityName, activityStartTime, activityEndTime, activityBudgetTime);
	}
	
	public Activity createAndAddActivityToProject(Developer dev, Project project, String activityName) throws NotProjectLeaderException {
		if(!project.getProjectLeader().equals(dev)) {
			throw new NotProjectLeaderException();
		}
		return project.createAndAddActivity(activityName);
	}
	
	public void addDeveloperToProjectActivity(Developer projectLeader, Developer developer, Project project, Activity activity) throws Exception {
		project.addDeveloperToActivity(projectLeader,developer, activity);
	}
	
	public List<Developer> getProjectActivityDevelopers(Project project, Activity activity){
		return project.getActivityDevelopers(activity);
	}
	
	public void registerPrivateTime(Developer dev, String activityName, double hours) {
		Activity activity = null;
		for(Activity a: privateActivities) {
			if(a.getName().matches(activityName)) {
				activity = a;
			}
		}
		DeveloperActivityTime priv = new DeveloperActivityTime(dev, activity, hours, Calendar.getInstance());
		activity.registerTime(priv);
	}
	
	public List<String> getFullWork(){
		return work;
	}
	
	public DateServer getDateServer() {
		return this.dateServer;
	}
	
	public void setDateServer(DateServer dateServer) {
		this.dateServer = dateServer;
	}

	public List<Project> getProjects() {
		return projects;
	}
	
	public Project getProject(String projectName) throws Exception {
		for(Project p : projects) {
			if(p.getName().equals(projectName)) {
				return p;
			}
		}
		return null;
	}
	
	public Project getProject(int projectNumber) throws Exception {
		for(Project p : projects) {
			if(p.getProjectNumber() == projectNumber) {
				return p;
			}
		}
		return null;
	}

	public void addProject(Project projects) {
		this.projects.add(projects);
	}

	public boolean removeProject(Project project) {
		project.removeAllActivities();
		return this.projects.remove(project);
	}
	
	public List<Developer> getDevelopers() {
		return developers;
	}

	public Developer getDeveloper(String initials) throws Exception {
		for(Developer d : developers) {
			if(d.getInitials().equals(initials)) {
				return d;
			}
		}
		throw new Exception("Developer with specified initials does not exist.");
		//return null;
	}
	
	public void addDeveloper(Developer developer) {
		this.developers.add(developer);
	}
	
	public boolean removeDeveloper(Developer developer) {
		for(Project p: this.projects) {
			for(Activity a: p.getActivities()) {
				a.removeDeveloper(developer);
			}
		}
		return this.developers.remove(developer);
	}
	
	public List<String> getFullPersonelSchedule(){
		return globalSchedules;
	}

	public void setProjectStartTime(Project project, Calendar time) throws Exception {
		 project.setStartTime(time);
	}

	public void setProjectLeader(Project project, Developer developer) throws NotProjectLeaderException {
		project.setProjectLeader(developer);
	}

	public void setProjectLeader(Project project, Developer leader, Developer newLeader) throws NotProjectLeaderException {
		project.setProjectLeader(leader, newLeader);
	}
}
