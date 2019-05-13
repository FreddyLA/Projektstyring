package dtu.projektstyring.app;

import java.util.InputMismatchException;
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
		
		while(sh.getDeveloper(in) == null) {
			System.out.println("Wrong initials - Enter initials:");
			in = input.nextLine();
		}
		devInitials = in;
		while(!in.equals("quit")) {
			mainMenu();
		}		
		
	}
	
	private static void mainMenu() throws Exception {
		System.out.println("1. Register time on activity");
		System.out.println("2. Manage personal schedule");
		System.out.println("3. Manage projects");
//		System.out.println("4. View full personel schedule");
		in = input.nextLine();
		mainMenuLogic(in);
	}
	
	private static void mainMenuLogic(String choice) throws Exception {
		switch(choice) {
		case "1":
			System.out.println("Enter project number:");
			try {
				if(sh.getProject(projectNumber = input.nextInt()) == null) {
					System.out.println("Wrong project number");
					input.nextLine();
					return;
				}
			} catch (InputMismatchException e) {
				System.out.println(e.getMessage());
			}
			input.nextLine();
			
			System.out.println("Enter activity name:");
			
			if(sh.getProject(projectNumber).getActivity(activityName = input.nextLine()) == null) {
				System.out.println("Wrong activity");
				return;
			}
			
			System.out.println("Enter worked hours of the day:");
			try {
				hours = input.nextInt();
			} catch (InputMismatchException e) {
				System.out.println(e.getMessage());
			}
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
//		case "4":
//			showFullPersonelSchedule();
//			break;
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
			System.out.println("ID  |Name\t|Start\t\t\t\t|Deadline\t\t\t\t|Activities");
			for(Project p : sh.getProjects()) {
				try {
					if(p.getProjectLeader().getInitials().equals(devInitials)) {
						System.out.print(p.getProjectNumber());
						System.out.print("   |"+p.getName());
						System.out.print("\t|"+p.getStartTime());
						System.out.print("\t|"+p.getEndTime());
						System.out.print("\t|"+p.getActivities().size());
						System.out.println();
					}
				} catch (Exception e) {
					System.out.println(e.getMessage());
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
			Project tmp;
			try {
				if((tmp = sh.getProject(input.nextInt())) == null) {
					System.out.println("Project doesn't exist");
					input.nextLine();
					return;
				}
				input.nextLine();
				if( tmp.getProjectLeader() == null) {
					manageProjectMenu(tmp);
				}
				else if (tmp.getProjectLeader().getInitials().equals(devInitials)) {
					manageProjectMenu(tmp);
				} else {
					System.out.println("You cannot manage a project you are not the leader of");
				}
			} catch (Exception e) {
				System.out.println("Wrong input: " + e.getMessage());
				input.nextLine();
				
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
		switch(in2) {
		case "1":
			System.out.println("Current creation time: "+p.getCreationTime());
			System.out.println("Enter new start time for project:");
			try {	
				startTime = input.nextInt();
				input.nextLine();
			} catch (Exception e)
			{
				System.out.println("Wrong input - not integers");
				break;
			}
			try {
				p.setStartTime(sh.getDeveloper(devInitials), startTime);
			} catch (Exception e) {
				System.out.println("You are not project leader or start time is before creation time");
			}
			break;
		case "2":
			System.out.println("Current deadline: "+p.getEndTime());
			System.out.println("Enter new deadline for project:");
			try {	
				endTime = input.nextInt();
				input.nextLine();
			} catch (Exception e)
			{
				System.out.println("Wrong input - not integers");
				break;
			}
			try {
				p.setEndTime(sh.getDeveloper(devInitials), endTime);
			} catch (Exception e) {
				System.out.println("You are not project leader or deadline is before creation time");			
			}
			break;
		case "3":
//			for(Developer dev : sh.getDevelopers()) {
//				System.out.println(dev.getInitials());
//			}
			System.out.println("Enter initials of new project leader:");
			in = input.nextLine();
			Developer tmp; 
			if((tmp = sh.getDeveloper(in)) == null) {
				System.out.println("Wrong initials - developer doesn't exist");
				break;
			};
			p.setProjectLeader(tmp);
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
		System.out.println("4. Show available developers for an activity");
		System.out.println("5. Add developer to an activity");
		System.out.println("6. Add new activity");
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
			try {
				in = input.nextLine();
				System.out.println(p.getActivity(in).getTotalWorkHours());
			} catch (Exception e) {
				System.out.println("Wrong input or activity doesn't exist: " + e.getMessage());
			}
			break;
		case "3":
			System.out.println("Which activity do you want to edit:");
			activityName = input.nextLine();
			WorkActivity tmpA = p.getActivity(activityName);
			editActivityMenu(tmpA);			
			break;
		case "4":
			System.out.println("For which activity do you want to see available developers:");
			activityName = input.nextLine();
			if((p.getActivity(activityName)) == null) {
				System.out.println("Activity does not exist.");
				break;
			} else if(p.getActivity(activityName).getStartTime() <= 0 || p.getActivity(activityName).getEndTime() <= 0) {
				System.out.println("Please specify start and end time before checking available devs");
			} else {
				for(Developer d : sh.findAvailableDevelopers(p.getProjectNumber(), activityName)) {
					System.out.println("- "+d.getInitials());
				}
			}
			break;
		case "5":
			System.out.println("Which activity do you want to add a developer to:");		
			activityName = input.nextLine();
			if((p.getActivity(activityName)) == null) {
				System.out.println("Activity does not exist.");
				break;
			} else if(p.getActivity(activityName).getStartTime() <= 0 || p.getActivity(activityName).getEndTime() <= 0) {
				System.out.println("Please specify start and end time before checking available devs");
				break;
			} else {
				sh.addDeveloperToProjectActivity(p.getProjectLeader().getInitials(), devInitials, p.getProjectNumber(), activityName);
			}
		case "6":
			System.out.println("Enter name of activity:");
			activityName = input.nextLine();
			sh.createAndAddActivityToProject(devInitials, p.getProjectNumber(), activityName);
			break;
		}
	}

	private static void editActivityMenu(WorkActivity tmpA) {
		System.out.println("What do you want to edit? ");
		System.out.println("1. Start time");
		System.out.println("2. Deadline");
		System.out.println("3. Budgeted time");
		in = input.nextLine();
		editActivityMenuLogic(tmpA, in);
		
	}

	private static void editActivityMenuLogic(WorkActivity tmpA, String in2) {
		switch(in2) {
		case "1":
			System.out.println("Enter new start date:");

			try {			
				startTime = input.nextInt();
				input.nextLine();
				tmpA.setStartTime(sh.getDeveloper(devInitials), startTime);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			break;
		case "2":
			System.out.println("Enter new end date:");
			try {
				endTime = input.nextInt();
				input.nextLine();
				
				tmpA.setEndTime(sh.getDeveloper(devInitials), endTime);
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
				System.out.println("\tStart: week " + tmp.getActivityStartTime());
				System.out.println("\tEnd: week " +tmp.getActivityEndTime());
				
			}
			break;
		case "2":
			System.out.println("Is it vacation or sickness? (Vacation, Sickness)");				
			String answer = input.nextLine();
			System.out.println("Enter to start time in week number");
			try {
				startTime = input.nextInt();
				input.nextLine();
			} catch (Exception e) {
				System.out.println("Wrong input or " + e.getMessage());
			}
			System.out.println("Enter to end time in week number");
			try {
				endTime = input.nextInt();
				input.nextLine();
				sh.registerPrivateActivity(devInitials, answer, startTime, endTime);
			}catch (Exception e) {
				System.out.println("Wrong input or " + e.getMessage());
			}
			break;
		}
	}

//	private static void showFullPersonelSchedule() {
//		int i = 0;
//		List<Developer> devs = sh.getDevelopers();
//		for(Developer tmp : devs) {
//			System.out.print((++i)+". "+tmp.getInitials()+"\t");
//			for(WorkActivity wa : tmp.getWorkActivities()) {
//				System.out.print(wa.getStartTime()+"\t");
//				System.out.print(wa.getEndTime()+"\t");
//				System.out.println(wa.getName());
//			}
//			System.out.println();
//		}
//		
//	}
}
