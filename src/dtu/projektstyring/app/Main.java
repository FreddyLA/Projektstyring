package dtu.projektstyring.app;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Main {
	static SoftwareHuset sh = new SoftwareHuset();
	static Scanner input = new Scanner(System.in);  // Create a Scanner object
	static String in;
	static String projectName;
	static String activityName;
	static int hours;
	static String sdate;
	static String sfrom;
	static String sto;
	static String des;
	
	static Project project;
	
	public static void main(String[] args) throws Exception {
		System.out.println("Avilable developers:");
		for(Developer developer: sh.getDevelopers()) {
			System.out.print(developer.getInitials() + " ");
		}
		System.out.println("\nEnter initials:");
		in = input.nextLine();
		
		Developer d = sh.getDeveloper(in);
		
		while(!in.equals("quit")) {
			mainMenu();
			
			in = input.nextLine();
			
			mainMenuLogic(d, in);
			
		}		
	}
	
	private static void mainMenuLogic(Developer d, String choice){
		switch(choice) {
		case "1":
			System.out.println("Enter project ID:");
			int projectID = input.nextInt();
			try {
				project = sh.getProject(projectID);
			} catch (Exception e) {
				e.printStackTrace();
			}
			projectMenu();
			in = input.nextLine();
			break;
		case "2":
			createNewProject();
			break;
		case "3":
			createNewPrivateActivity();
			break;	
		case "4":
			privateActivitiesMenu();
			break;
		case "5":
			manageDeveloperMenu();
			break;
		}
		
	}
	
	private static void manageDeveloperMenu() {
		// TODO Auto-generated method stub
		
	}

	private static void privateActivitiesMenu() {
		// TODO Auto-generated method stub
		
	}

	private static void createNewPrivateActivity() {
		// TODO Auto-generated method stub
		
	}

	private static void createNewProject() {
		// TODO Auto-generated method stub
		
	}

	private static void projectMenu() {
		System.out.println("1. Manage project");
		System.out.println("2. Activities");
	}

	private static void mainMenu() {
		System.out.println("1. Open project");
		System.out.println("2. New project");
		System.out.println("3. New Private Activity");
		System.out.println("4. Manage private activities");
		System.out.println("5. Manage developer");
	}
}
