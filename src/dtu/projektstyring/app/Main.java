package dtu.projektstyring.app;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import dtu.projektstyring.exceptions.NotProjectLeaderException;

public class Main {
	static String devInitials;
	static SoftwareHuset sh = new SoftwareHuset();
	static Scanner input = new Scanner(System.in);  // Create a Scanner object
	static String in;
	static String projectName;
	static String activityName;
	static int projectNumber;
	static int hours;
	static int startTime;
	static int date;
	static int endTime;
	static String sfrom;
	static String sto;
	static String des;
	
	public static void main(String[] args) throws Exception {
		
		System.out.println("Enter initials:");
		in = input.nextLine();
		devInitials = in;
		while(!in.equals("quit")) {
			mainMenu();
		}		
	}
	
	private static void mainMenu() throws Exception {
		System.out.println("1. Register time on activity");
		System.out.println("2. Manage personal schedule");
		System.out.println("3. Manage projects");
		System.out.println("4. View full personel schedule");
		in = input.nextLine();
		mainMenuLogic(in);
	}
	
	private static void mainMenuLogic(String choice) throws Exception {
		switch(choice) {
		case "1":
			System.out.println("Enter project number:");
			projectNumber = input.nextInt();
			System.out.println("Enter activity name:");
			activityName = input.nextLine();
			System.out.println(activityName);
			System.out.println("Enter worked hours of the day:");
			hours = input.nextInt();
			sh.registerTime(devInitials, projectNumber, activityName, hours);
			break;
		case "2":
			personalScheduleMenu();
			in = input.nextLine();
			personalScheduleMenuLogic(in);
			break;
		case "3":
			projectsMenu();
			in = input.nextLine();
			projectsMenuLogic(in);
			break;
		case "4":
			showFullPersonelSchedule();
			break;
		}
		
	}
	
	private static void projectsMenu() {
		System.out.println("1. Show projects you are leading");
		System.out.println("2. Show all projects");
		System.out.println("3. Manage specific project");
		System.out.println("4. Create new project");
		System.out.println("5. Delete a specific project");
	}
	
	private static void projectsMenuLogic(String choice) throws Exception {
		switch(choice) {
		case "1":
			System.out.println("ID  |Name\t|Start\t\t\t\t|Deadline\t\\t\t\t|Activities");
			for(Project p : sh.getProjects()) {
				if(p.getProjectLeader().getInitials().equals(devInitials)) {
					System.out.print(p.getProjectNumber());
					System.out.print("   |"+p.getName());
					System.out.print("\t|"+p.getStartTime());
					System.out.print("\t|"+p.getEndTime());
					System.out.print("\t|"+p.getActivities().size());
					System.out.println();
				}
			}
			break;
		case "2":
			System.out.println("ID  |Name\t|Start\t\t\t\t|Deadline\t\t\t|Activities\t|Project Leader");
			for(Project p : sh.getProjects()) {
				System.out.print(p.getProjectNumber());
				System.out.print("   |"+p.getName());
				System.out.print("\t|"+p.getStartTime());
				System.out.print("\t|"+p.getEndTime());
				System.out.print("\t|"+p.getActivities().size());
				if(p.getProjectLeader() != null) System.out.print("\t\t|"+p.getProjectLeader().getInitials()); else System.out.print("\t\t|-");
				System.out.println();				
			}
			break;
		case "3":
			System.out.println("Enter project number:");
			in = input.nextLine();
			int projNum = Integer.parseInt(in);
			Project tmp = sh.getProject(projNum);
			if( tmp.getProjectLeader().equals(null) || tmp.getProjectLeader().getInitials().equals(devInitials)) {
				manageProjectMenu(tmp);
			} else {
				System.out.println("You cannot manage a project you are not the leader of");
			}
			break;
		case "4":
			System.out.println("Enter name of project:");
			projectName = input.nextLine();
			//System.out.println("Enter start time for project (week number):");
			//startTime = input.nextInt();
			sh.makeProject(projectName);
			//sh.setProjectStartTime(devInitials, projectID, time);
			break;
		case "5":
			// TODO: remove a specific project from the list of projects
			break;
		}
		
	}

	private static void manageProjectMenu(Project p) throws Exception {
		System.out.print(p.getProjectNumber());
		System.out.print("   |"+p.getName());
		System.out.print("\t|"+p.getStartTime());
		System.out.print("\t|"+p.getEndTime());
		System.out.print("\t|"+p.getActivities().size());
		if(p.getProjectLeader() != null) System.out.print("\t\t|"+p.getProjectLeader().getInitials()); else System.out.print("\t\t|-");
		System.out.println();
		System.out.println("1. Edit project start time");
		System.out.println("2. Edit project deadline");
		System.out.println("3. Select new project leader");
		System.out.println("4. Manage project activities");
		in = input.nextLine();
		manageProjectMenuLogic(in, p);
	}

	private static void manageProjectMenuLogic(String in2, Project p) throws Exception {
		Date date; 
		Calendar calendar;
		switch(in2) {
		case "1":
			System.out.println("Current start time: "+p.getStartTime());
			System.out.println("Enter new start time for project (dd-MM-yyyy):");
			startTime = input.nextInt();
			p.setStartTime(sh.getDeveloper(devInitials), startTime);
			break;
		case "2":
			System.out.println("Current deadline: "+p.getEndTime());
			System.out.println("Enter new deadline for project (dd-MM-yyyy):");
			endTime = input.nextInt();
			p.setEndTime(sh.getDeveloper(devInitials), endTime);
			break;
		case "3":
			for(Developer dev : sh.getDevelopers()) {
				System.out.println(dev.getInitials());
			}
			System.out.println("Enter initials of new project leader:");
			in = input.nextLine();
			Developer tmp = sh.getDeveloper(in);
			if(tmp != null) p.setProjectLeader(tmp);
			break;
		case "4":
			manageProjectActivitiesMenu(p);
			break;
		}
	}
	private static void manageProjectActivitiesMenu(Project p) throws Exception {
		System.out.println("1. Show all activities");
		System.out.println("2. Show all work for an activity");
		System.out.println("3. Edit activity");
		System.out.println("4. Add new activity");
		in = input.nextLine();
		manageProjectActivitiesMenuLogic(in, p);
	}

	private static void manageProjectActivitiesMenuLogic(String in2, Project p) throws Exception {
		switch(in2) {
		case "1":
			System.out.println("Name\t\t|Project\t|Start\t\t\t\t|Deadline\t\t\t|Developers\t|Budgetet time");
			System.out.println("_________________________________________________________________________________________________________________________________");
			for(WorkActivity a : p.getActivities()) {
				System.out.print(a.getName());
				System.out.print("\t|"+p.getName());
				System.out.print("\t\t|"+a.getStartTime());
				System.out.print("\t\t|"+a.getEndTime());
				System.out.print("\t|"+a.getDevelopers().size());
				System.out.println("\t\t|"+a.getBudgetedTime());
			}
			break;
		case "2":
			System.out.println("Enter name of activity:");
			in = input.nextLine();
			p.getActivity(in).getTotalWorkHours();
			break;
		case "3":
			System.out.println("Which activity do you want to edit:");
			activityName = input.nextLine();
			WorkActivity tmpA = p.getActivity(activityName);
			editActivityMenu(tmpA);			
			break;
		case "4":
			System.out.println("Enter name of activity:");
			activityName = input.nextLine();
			sh.createAndAddActivityToProject(devInitials, p.getProjectNumber(), activityName);
			break;
		}
	}

	private static void editActivityMenu(WorkActivity tmpA) {
		System.out.println("What do you want to edit? ");
		System.out.println("2. Start time");
		System.out.println("3. Deadline");
		System.out.println("4. Budgeted time");
		in = input.nextLine();
		editActivityMenuLogic(tmpA, in);
		
	}

	private static void editActivityMenuLogic(WorkActivity tmpA, String in2) {
		switch(in2) {
		case "1":
			System.out.println("Enter new start date:");
			startTime = input.nextInt();
			try {
				tmpA.setStartTime(sh.getDeveloper(devInitials), date);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			break;
		case "2":
			System.out.println("Enter new end date:");
			in = input.nextLine();
			try {
				tmpA.setEndTime(sh.getDeveloper(devInitials), date);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			break;
		case "3":
			System.out.println("Enter new budgetet time:");
			in = input.nextLine();
			try {
				tmpA.setBudgetetTime(sh.getDeveloper(devInitials), Long.parseLong(in));
			} catch (NumberFormatException e) {
				System.out.println(e.getMessage());
			} catch (NotProjectLeaderException e) {
				System.out.println(e.getMessage());
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			break;
			
		}
	}

	private static void personalScheduleMenu() {
		System.out.println("1. Show personal schedule");
		System.out.println("2. Add to personal schedule");
	}
	
	private static void personalScheduleMenuLogic(String choice) throws Exception {
		
		switch(choice) {
		case "1":
			int i = 0;
			List<PrivateActivity> dpa1 = sh.getDeveloper(devInitials).getPrivateActivities();
			for(PrivateActivity tmp : dpa1) {
				System.out.print((++i)+". "+devInitials+"\t");
				System.out.println(tmp.getName());
			}
			break;
		case "2":
			System.out.println("Is it vacation or sickness? (v, s)");				
			String answer = input.nextLine();
			System.out.println("Enter to start time in week number");
			startTime = input.nextInt();
			System.out.println("Enter to end time in week number");
			endTime = input.nextInt();
			sh.registerPrivateActivity(devInitials, startTime, endTime, answer);
			break;
		}
	}

	private static void showFullPersonelSchedule() {
		int i = 0;
		List<Developer> devs = sh.getDevelopers();
		for(Developer tmp : devs) {
			System.out.print((++i)+". "+tmp.getInitials()+"\t");
			for(WorkActivity wa : tmp.getWorkActivities()) {
				System.out.print(wa.getStartTime()+"\t");
				System.out.print(wa.getEndTime()+"\t");
				System.out.println(wa.getName());
			}
		}
		
	}
}
