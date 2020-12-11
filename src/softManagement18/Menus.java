package softManagement18;

public class Menus {
	// NOT YET VERIFIED


	public Menus() {
		showMainMenu();
	}

	//1. Show the MainMenu
	private void showMainMenu() {
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
			case "C":
				System.out.println("\nYou have selected the Customer Menu ");
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
	private void showManagerMenu() {
		int temp=0;
		do {


			System.out.println("\n Manager Screen - Type one of the options below");
			System.out.println("1. Add a team member");
			System.out.println("2. View all team members");
			System.out.println("3. Remove a team member");
			System.out.println("4. Add a new project");
			System.out.println("5. Return to Main Menu");

			temp = UserInput.readInt("Please type your choice here >>>> :");

			switch (temp) {

			case 1: //Add a team member

				System.out.println("\nAdding a team member ...");
				System.out.println("\nPlease type the team member’s:");
				String name = UserInput.readString("Name :");
				String role = UserInput.readString("Role :");
				Controller.addMember(name,role);
				break;

			case 2: //View all team members
				Controller.displayTheListOfTeamMembers();
				break;

			case 3: //Remove a team member
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

			case 5: //Return to Main screen
				System.out.println("Returning to the Main Screen...");
				showMainMenu();
				break;

			default:
				System.out.println("Invalid choice ! please type only numbers from 1 to 4 :");
				return;
			}	

		}while(temp!=5);
	}


	//***********************************************************************************************************
	public static void managerMenu() {
		int managerMenuChoice = UserInput.readInt("Manager Screen - Type one of the options below:\n" +
				"1. Add a project\n" +
				"2. Add a task\n" +
				"3. Team members\n" +
				"4. Remove a task\n" +
				"5. View tasks\n" +
				"6. Assign a task to a team member\n" +
				"7. View all projects\n" +
				"8. Schedule a meeting\n" +
				"9. Return to softManagement18.Main Menu\n");
		switch (managerMenuChoice) {

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
}

