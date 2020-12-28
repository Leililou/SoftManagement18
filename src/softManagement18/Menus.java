package softManagement18;

public class Menus {
	// NOT YET VERIFIED


	public Menus() {
		showMainMenu();
	}

	//1. Show the MainMenu
	private static void showMainMenu() {
		String choice="";
		do { 
			//Display the options
			System.out.println("> Main Screen :");
			System.out.println("\n Please specify your role by entering one of the options given: \n "
					+ "1. Enter \"M\" for Manager\n "
					+ "2. " + "Enter \"T\" for Team member \n "
					+ "3. Enter \"X\" to exit the system");

			choice = UserInput.readString("Please type your choice here >>>> : ");

			switch (choice) {
			case "M":
				System.out.println("\nYou have selected the Manager's Menu ");
				showManagerMenu();
				break;
			case "T":
				System.out.println("\nYou have selected the team member's Menu ");
				//showTeamMemberMenu();
				break;
			case "X":
				System.out.println("\n Thank you for using SoftManagement18 System, see you next time!");
				System.exit(0);
				break;
			default:
				System.out.println("Only type M, T or X !");
				break;
			}	
		} while(! choice.equals("X") );
	}



	// 2. Show the Manager's Menu
	private static void showManagerMenu() {
		int temp=0;
		do {


			System.out.println("\n Manager Screen - Type one of the options below"
					+ "\n\n> EMPLOYEE:\n"
					+ "1. Add an employee to the system\n"
					+ "2. View all employees registered in the system\n"
					+ "3. Remove an employee from the system\n"
					+ "\n\n> PROJECT:\n"
					+ "4. Add a new project\n"
					+ "5. Display the list of registered projects\n"
					+ "6. Display information about a specific project (using ID)\n"
					+ "7. Manage a project\n");

			/*
			System.out.println("5. Return to Main Menu");
			System.out.println("5. Return to Main Menu");
			System.out.println("5. Return to Main Menu");
			System.out.println("5. Return to Main Menu");
			 */
			System.out.println("\n\n> EXIT THE SCREEN"
					+ "8. Return to Main Menu");

			temp = UserInput.readInt("\nPlease type your choice here >>>> :");

			switch (temp) {

			case 1: //Add a team member

				System.out.println("\nAdding an employee to the system ...");
				System.out.println("\nPlease type the employee’s:");
				String name = UserInput.readString("Name :");
				String role = UserInput.readString("Role :");
				Controller.addMember(name,role);
				break;

			case 2: //View all team members
				Controller.displayTheListOfTeamMembers();
				break;

			case 3: //Remove an employee from the system
				System.out.println("Not yet implemented");
				break;

				//addProject(String title, String description)
			case 4: //Add a new project

				System.out.println("\nAdding a new project ...");
				System.out.println("\nPlease type the project’s:");
				String title = UserInput.readString("Title :");
				String description = UserInput.readString("Description :");
				Controller.addProject(title,description);
				break;

			case 5: //Display the list of registered projects
				Controller.displayListOfProjects();
				break;

			case 6: //Display information about a specific project (using ID)
				String projectID = UserInput.readString("Please enter the ID of the project you want to get information about :");
				Controller.showProjectInfo(projectID);
				break;
			case 7: //Manage a project
				String projectId = UserInput.readString("Please enter the ID of the project you want to manage: ");
				showProjectMenu(projectId);
				break;
			case 8: //Return to Main screen
				System.out.println("Returning to the Main Screen...");
				showMainMenu();
				break;

			default:
				System.out.println("Invalid choice ! please type only numbers from 1 to 4 :");
				return;
			}	

		}while(temp!=8);
	}


	public static void showProjectMenu(String projectID) {
		String projectTitle = Controller.projectNameByID(projectID);
		int temp=0;
		do {
			System.out.println(">> MANAGEMENT OF THE PROJECT "+projectTitle+", of ID:"+projectID+":\n"
					+"\n> TEAM MEMBERS\n"
					+ "1. Assign a team member to this project\n"
					+ "2. View all team members participating in this project\n"
					+ "3. Search a team member by ID in this project\n"
					+ "4. Search a team member by name in this project\n"
					+ "5. Remove a team member from this project\n"
					
					+ "\n> TASKS\n"
					+ "6. Create a task in this project\n"
					+ "7. View the tasks of this project\n"
					+ "8. Search a task by ID in this project\n"
					+ "9. Remove a task from this project\n"
					
					+ "\n> TEAM MEMBERS-TASKS (connection)\n"
					+ "10. Assign a task to a team member\n"
					+ "11. Remove a task from a team member's list of tasks\n"
					+ "\n> EXIT THE PROJECT MANAGEMENT SCREEN\n"
					+ "12. Return to the Manager's Menu\n"
					+ "13. Return to the Main Menu");

			temp = UserInput.readInt("\nPlease type your choice here >>>> :");

			switch (temp) {

			case 1: //Assign a team member to this project
				System.out.println("\nAssigning a team member to this project...");
				String memberID = UserInput.readString("\nPlease type the team member’s ID that you want to assign to this project:\n");
				Controller.assignTeamMemberToProject(projectID,memberID);
				break;

			case 2: //View all team members participating in this project
				System.err.println("To be implemented");
				break;

			case 3: //Search a team member by ID in this project
				String tMemberID = UserInput.readString("Please enter the ID of the team member:");
				Controller.searchTeamMemberByIDInProject(projectID,tMemberID);
				break;

			case 4: //Search a team member by name in this project
				String tMemberName = UserInput.readString("Please enter the name of the team member:");
				Controller.searchTeamMemberByIDInProject(projectID,tMemberName);
				break;
			case 5: //Remove a team member from this project
				System.err.println("To be implemented");
				break;
			case 6: //Create a task in this project
				break;
			case 7: //View the tasks of this project
				break;
			case 8: //Search a task by ID in this project
				break;
			case 9: //Remove a task from this project
				break;
			case 10: //Assign a task to a team member
				break;
			case 11: //Remove a task from a team member's list of tasks
				break;
				
			case 12: //Return to the Manager's Menu
				showManagerMenu();
				break;

			case 13: //Return to Main screen
				System.out.println("Returning to the Main Screen...");
				showMainMenu();
				break;

			default:
				System.out.println("Invalid choice ! please type only numbers from 1 to 4 :");
				return;
			}	

		}while(temp!=13);
	}


}

/*public static void Meetings(){
        int mChoice = InputHandler.intInput("1. Schedule new meeting." +
                "\n2. Remove a meeting." +
                "\n3. View all scheduled meeting." +
                "\n4. Go back to previous menu.");
        switch (mChoice) {
            case 1 -> { Controller.scheduleMeeting();
                Meetings(); }
            case 2 -> { Controller.showMeetingList();
            String id = InputHandler.stringInput("Which meeting should be removed? ID: ");
            Controller.removeMeeting(id); Meetings();}
            case 3 -> { Controller.showMeetingList(); Meetings(); }
            default -> {}
        }

    }
    public static void teamMembers() {
        int tmChoice = InputHandler.intInput("1. Add new team member." +
                "\n2. Remove a team member." +
                "\n3. View all team members." +
                "\n4. Go back to previous menu.");
        switch (tmChoice){
            case 1 -> { Controller.addMember();teamMembers(); }
            case 2 -> { Controller.showMemberList();
                String id = InputHandler.stringInput("Which member should be removed? ID: ");
                Controller.removeMember(id); teamMembers();}
            case 3 -> { Controller.showMemberList();teamMembers(); }
            case 4 -> Controller.searchTM();
            default -> { }
        }
    }*/

