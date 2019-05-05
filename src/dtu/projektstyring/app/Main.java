package dtu.projektstyring.app;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
	static SoftwareHuset sh = new SoftwareHuset();
	static Scanner input = new Scanner(System.in);  // Create a Scanner object
	static String in;
	static String projectName;
	static String activityName;
	static int projectNumber;
	static int hours;
	static String sdate;
	static String sfrom;
	static String sto;
	static String des;
	
	public static void main(String[] args) throws Exception {
		
		System.out.println("Enter initials:");
		in = input.nextLine();
		
		Developer d = sh.getDeveloper(in);
		
		while(!in.equals("quit")) {
			mainMenu();
			
			in = input.nextLine();
			
			mainMenuLogic(d, in);
			
		}		
	}
	
	private static void mainMenuLogic(Developer d, String choice) throws Exception {
		switch(choice) {
		case "1":
			System.out.println("Enter project name:");
			projectNumber = input.nextInt();
			System.out.println("Enter activity name:");
			activityName = input.nextLine();
			System.out.println("Enter worked hours of the day:");
			hours = input.nextInt();
			sh.registerTime(d, projectNumber, activityName, hours);
			break;
		case "2":
			personalScheduleMenu();
			in = input.nextLine();
			personalScheduleMenuLogic(d, in);
			break;
		case "3":
			projectsMenu();
			in = input.nextLine();
			projectsMenuLogic(d, in);
			break;
		case "4":
			showFullPersonelSchedule();
			break;
		}
		
	}
	private static void projectsMenuLogic(Developer d, String choice) throws Exception {
		switch(choice) {
		case "1":
			System.out.println("ID  |Name\t|Start\t\t\t\t|Activities");
			for(Project p : d.getLeaderProjects()) {
				System.out.print(p.getProjectNumber());
				System.out.print("   |"+p.getName());
				System.out.print("\t|"+p.getStartTime());
				System.out.print("\t|"+p.getActivities().size());
				System.out.println();
			}
			break;
		case "2":
			System.out.println("ID  |Name\t|Start\t\t\t\t|Activities\t|Project Leader");
			for(Project p : sh.getProjects()) {
				System.out.print(p.getProjectNumber());
				System.out.print("   |"+p.getName());
				System.out.print("\t|"+p.getStartTime());
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
			if( tmp.getProjectLeader().equals(null) || tmp.getProjectLeader().equals(d)) {
				manageProjectMenu(tmp);
			} else {
				System.out.println("You cannot manage a project you are not the leader of");
			}
			break;
		case "4":
			System.out.println("Enter name of project:");
			projectName = input.nextLine();
			System.out.println("Enter start date for project (dd-MM-yyyy):");
			sdate = input.nextLine();
			Date date = new SimpleDateFormat("dd-MM-yyyy").parse(sdate); 
			sh.makeProject(d, projectName, date);
			break;
		case "5":
			// TODO: remove a specific project from the list of projects
			break;
		}
		
	}

	private static void manageProjectMenu(Project p) {
		// TODO Get and Set shit for a project
		
	}

	private static void personalScheduleMenuLogic(Developer d, String choice) throws ParseException {
		switch(choice) {
		case "1":
			int i = 0;
			for(String s : d.getFullSchedule()) {
				System.out.println((++i)+". "+s);
			}
			break;
		case "2":
			System.out.println("Enter from date (dd-MM-yyyy):");
			sfrom = input.nextLine();
			Date from = new SimpleDateFormat("dd-MM-yyyy").parse(sfrom); 
			System.out.println("Enter to date dd-MM-yyyy:");
			sto = input.nextLine();
			Date to = new SimpleDateFormat("dd-MM-yyyy").parse(sto); 
			System.out.println("Enter description:");
			des = input.nextLine();
			sh.registerDeveloperSchedule(d, from, to, des); 
			break;
		case "3":
			System.out.println("Enter index of schedules to remove:");
			int index = input.nextInt();
			d.removeFromSchedule(index);
			break;
		}	
	}

	private static void showFullPersonelSchedule() {
		int i = 0;
		for(String s : sh.getFullPersonelSchedule()) {
			System.out.println((++i)+". "+s);
		}
	}

	private static void projectsMenu() {
		System.out.println("1. Show projects you are leading");
		System.out.println("2. Show all projects");
		System.out.println("3. Manage specific project");
		System.out.println("4. Create new project");
		System.out.println("5. Delete a specific project");
	}

	private static void personalScheduleMenu() {
		System.out.println("1. Show personal schedule");
		System.out.println("2. Add to personal schedule");
		System.out.println("3. Remove from personal schedule");
	}

	private static void mainMenu() {
		System.out.println("1. Register time on activity");
		System.out.println("2. Manage personal schedule");
		System.out.println("3. Manage projects");
		System.out.println("4. View full personel schedule");
	}
}
