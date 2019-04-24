package dtu.projektstyring.app;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import dtu.projektstyring.app.DateServer;

public class SoftwareHuset {
	
	private static List<Developer> developers = new ArrayList<Developer>();
	private static List<Project> projects = new ArrayList<Project>();
	private DateServer dateServer = new DateServer();
	private static List<Project> leaderProjects = new ArrayList<Project>();
	private static List<String> work = new ArrayList<String>();
	private static List<String> globalSchedules = new ArrayList<String>();
	
	//**********TIL TESTING**********//
	SoftwareHuset() {
		Developer defDev = new Developer("John Doe", "JDO");
		developers.add(defDev);
		
		Developer newDev = new Developer("Mike Johnson", "MJO");
		developers.add(newDev);
		newDev = new Developer("Elias Sandder", "ESA");
		developers.add(newDev);
		newDev = new Developer("Melissa Kullins", "MKU");
		developers.add(newDev);
		
		Project defProj = new Project("Proj1", Calendar.getInstance().getTime());
		defProj.setProjectLeader(defDev);
		projects.add(defProj);
	}
	//*******************************//
	
	public boolean makeProject(Developer dev, String name, Date date) throws Exception {
		if(!projects.isEmpty()) {
			for(Project p : projects) {
				if(p.getName().equals(name)) {
					throw new Exception("Project with specified name already exists.");
					//return false;
				}
			}
		}
		Project newProject = new Project(name, date);
		newProject.setProjectLeader(dev);
		projects.add(newProject);
		return true;
	}
	
	public void addActivityToProject(int projectNum, String activityName, Date activityStartTime, Date activityEndTime, double activityBudgetTime) throws Exception {
		Project p = getProject(projectNum);
		p.createAndAddActivity(activityName, activityStartTime, activityEndTime, activityBudgetTime);
	}
	
	public void addActivityToProject(String projectName, String activityName, Date activityStartTime, Date activityEndTime, double activityBudgetTime) throws Exception {
		Project p = getProject(projectName);
		p.createAndAddActivity(activityName, activityStartTime, activityEndTime, activityBudgetTime);
	}
	
	public void getRapport() {
		
	}
	
	public void setIsProjectLeader() {
		
	}
	
	public void registerTime(Developer developer, int projectNumber, String activityName, int hours) throws Exception {
		//Developer d = getDeveloper(developerInitials);
		Date date = Calendar.getInstance().getTime();
		Project p = getProject(projectNumber);
		Activity a = p.getActivity(activityName);
		
		if(developer != null && p != null && a != null) {
			if(a.getDevelopers().contains(developer)) {
				String tmp = developer.getInitials().concat(",").concat(Integer.toString(projectNumber)).concat(",").concat(activityName).concat(",").concat(date.toString()).concat(",").concat(Integer.toString(hours));
				work.add(tmp);
			}
			throw new Exception("Developer is not attached to the activity");
		}
		
		throw new Exception("Specified project or activity of the project does not exist");
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
		throw new Exception("Project not found");
		//return null;
	}
	
	public Project getProject(int projectNumber) throws Exception {
		for(Project p : projects) {
			if(p.getProjectNumber() == projectNumber) {
				return p;
			}
		}
		throw new Exception("Project not found");
		//return null;
	}

	public void addProject(Project projects) {
		SoftwareHuset.projects.add(projects);
	}

	public boolean removeProject(Project project) {
		project.removeAllActivities();
		return SoftwareHuset.projects.remove(project);
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
		SoftwareHuset.developers.add(developer);
	}
	
	public boolean removeDeveloper(Developer developer) {
		for(Project p: SoftwareHuset.projects) {
			for(Activity a: p.getActivities()) {
				a.removeDeveloper(developer);
			}
		}
		return SoftwareHuset.developers.remove(developer);
	}
	
	public void registerDeveloperSchedule(Developer developer, Date from, Date to, String description) {
		globalSchedules.add(from.toString().concat(",").concat(to.toString()).concat(",").concat(description));
		developer.registerSchedule(from, to, description);
	}
	
	public List<String> getDeveloperSchedule(Developer developer){
		return developer.getFullSchedule();
	}
	
	public void removeDeveloperSchedule(Developer developer, int index) {
		String tmp = developer.getSchedule(index);
		globalSchedules.remove(tmp);
		developer.removeFromSchedule(index);
	}
	
	public List<String> getFullPersonelSchedule(){
		return globalSchedules;
	}
	
	public List<Project> getLeaderProjects(Developer developer){
		for(Project p : projects) {
			if(p.getProjectLeader().equals(developer)) {
				leaderProjects.add(p);
			}
		}
		return leaderProjects;		
	}
}
