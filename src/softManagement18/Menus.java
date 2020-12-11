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
					//showManagerMenu();
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

