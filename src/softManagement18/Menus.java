package softManagement18;

import java.util.Date;

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
                case "M" -> {
                    String managerPassword = "1234";
                    String inputPassword = UserInput.readString("Enter password");
                    if (!inputPassword.equals(managerPassword)) {
                        System.out.print("Invalid password! ");
                        showMainMenu();
                    } else { showManagerMenu();}
                }

                case "T" ->
                        System.out.println("\nYou have selected the team member's Menu ");
                //showTeamMemberMenu();
                case "X" -> {
                    System.out.println("\n Thank you for using SoftManagement18 System, see you next time!");
                    System.exit(0);
                }

                default ->
                        System.out.println("Only type M, T or X !");

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
					+ "\n> PROJECT:\n"
					+ "4. Add a new project\n"
					+ "5. Display the list of registered projects\n"
					+ "6. Display information about a specific project (using ID)\n"
					+ "\n7. Manage a project\n"
					+ "\n> EXIT THE SCREEN\n"
					+ "8. Return to Main Menu");

			temp = UserInput.readInt("\nPlease type your choice below: "
					+ "\n>>> ");

			switch (temp) {

			case 1: //Add a team member

				System.out.println("\nAdding an employee to the system ...");
				System.out.println("\nPlease type the employee�s:");
				String name = UserInput.readString("Name :");
				String roleName="";
				//do {
				int role = UserInput.readInt("\nPlease choose a role from the list below:\n"
						+ "> 1. Product Owner\n"
						+ "> 2. Scrum Master\n"
						+ "> 3. Developer\n"
						+ "Note: If no choice has been made from the aption above, the employee \nwill be added as a Developer by default.\n\nPlease type your choice here >>>> :");

				if(role==1) {
					roleName="Product Owner";
				}else if(role==2) {
					roleName="Scrum Master";
				}else if(role==3) {
					roleName="Developer";
				}else {
					System.out.println("Invalid choice ! The role will be defined as Developer by default");
					roleName="Developer";
				}

				Controller.addEmployee(name,roleName);
				break;

			case 2: //View all team members
				System.out.println("\nThe list of all employees registered in the system :");
				Controller.displayTheListOfTeamMembers();
				System.out.println("\n");
				break;

			case 3: //Remove an employee from the system
				String employeeID=UserInput.readString("Please type the employee�s ID to remove from the system :\n>>>");
				Controller.removeEmployee(employeeID);
				break;

				//addProject(String title, String description)
			case 4: //Add a new project

				System.out.println("\nAdding a new project ...");
				System.out.println("\nPlease type the project�s:");
				String title = UserInput.readString("Title :");
				String description = UserInput.readString("Description :");
				Controller.addProject(title,description);
				break;

			case 5: //Display the list of registered projects
				System.out.println("\nThe list of all registered projects in the system :");
				Controller.displayListOfProjects();
				System.out.println("\n");
				break;

			case 6: //Display information about a specific project (using ID)
				String projectID = UserInput.readString("Please enter the ID of the project you want to get information about :");
				Controller.showProjectInfo(projectID);
				break;
			case 7: //Manage a project
				String projectId = UserInput.readString("Please enter the ID of the project you want to manage: ");
				if(Controller.fetchProjectById(projectId)<0) {
					System.out.println("You can't manage a project that doesn't exist, please retry with a valid ID\n"
							+ "A tip: you can view the list of the existing projects by typing (5)");
				}
				else {
					showProjectMenu(projectId);
				}

				break;
			case 8: //Return to Main screen
				System.out.println("Returning to the Main Screen...");
				showMainMenu();
				break;

			default:
				System.out.println("Invalid choice ! please type only numbers from 1 to 8 :");
				return;
			}	

		}while(temp!=8);
	}


	public static void showProjectMenu(String projectID) {
		//String projectTitle = Controller.projectNameByID(projectID);
		Project currentProject=Controller.projectFromID(projectID);
		String projectTitle=currentProject.getTitle();
		int temp=0;
		do {
			System.out.println("\n>> MANAGEMENT SCREEN OF THE PROJECT "+projectTitle+", of ID ("+projectID+"):\n"
					+"\n> TEAM MEMBERS\n"
					+ "1. Assign a team member to this project\n"
					+ "2. View all team members participating in this project\n"
					+ "3. Search a team member by ID in this project\n"
					+ "4. Search a team member by name in this project\n"				
					+ "5. Manage a team member(change role, assign to a task, delete from the project ...)\n"


					+ "\n> TASKS\n"
					+ "6. Create a task in this project\n"
					+ "7. View the tasks of this project\n"
					+ "8. Search a task by ID in this project\n"
					+ "9. Edit a task (change, assign/remove team members, delete ...)\n"


					+ "\n> SCHEDULE\n"
					+ "10. View the schedule\n"
					+ "11. Manage the schedule\n"



					+ "\n> EXIT THE PROJECT MANAGEMENT SCREEN\n"
					+ "12. Return to the Manager's Menu\n"
					+ "13. Return to the Main Menu");

			temp = UserInput.readInt("\nPlease type your choice here >>>> :");
			String tMemberID="";
			String taskID="";

			switch (temp) {

			case 1: //Assign a team member to this project
				System.out.println("\nAssigning a team member to this project...");
				System.out.println("\nThe list of all employees registered in the system :");
				Controller.displayTheListOfTeamMembers();
				System.out.println("\n");
				tMemberID = UserInput.readString("\nPlease pick the team member�s ID that you want to assign to this project from the list above:\n>> ");
				Controller.assignTeamMemberToProject(projectID,tMemberID);
				break;

			case 2: //View all team members participating in this project
				System.out.println("\nThe participants assigned to this project are :");
				Controller.showParticipantsProject(projectID);
				System.out.println("\n");
				break;

			case 3: //Search a team member by ID in this project
				tMemberID = UserInput.readString("Please enter the ID of the team member:");
				Controller.searchTeamMemberByIDInProject(projectID,tMemberID);
				break;

			case 4: //Search a team member by name in this project
				String tMemberName = UserInput.readString("Please enter the name of the team member:");
				Controller.searchTeamMemberByNameInProject(projectID,tMemberName);
				break;

			case 5: //Manage a team member
				tMemberID = UserInput.readString("Please enter the ID of the team member:");

				if(Controller.searchTeamMemberByIDInAList(currentProject.participants,tMemberID)<0) {
					System.out.println("You can't edit a team member that doesn't exist, please retry with a valid ID\n"
							+ "A tip: you can view the list of all team members participating in this projects by typing (2)");
				}
				else {
					showTeamMemberScreen(currentProject, tMemberID);
				}


				break;

			case 6: //Create a task in this project
				String title = UserInput.readString("> Title : \n>> ");
				String description = UserInput.readString("> Description : \n>> ");
				System.out.println("Please enter the start date : ");
				int sYear = UserInput.readInt("> Year: ");
				int sMonth= UserInput.readInt("> Month: ");
				int sDate= UserInput.readInt("> Date: ");
				@SuppressWarnings("deprecation") Date startDate= new Date(sYear-1900,sMonth-1,sDate);
				System.out.println("Please enter the end date :");
				int eYear = UserInput.readInt("> Year: ");
				int eMonth= UserInput.readInt("> Month: ");
				int eDate= UserInput.readInt("> Date: ");
				@SuppressWarnings("deprecation") Date endDate= new Date(eYear-1900,eMonth-1,eDate);
				int choice = UserInput.readInt("Please choose the level of priority from the list below: \n"
						+ "(The priority will be defined as Low by default if none of below options is chosen)\n"
						+ "1. High\n"
						+ "2. Medium\n"
						+ "3. Low\nPlease type your choice here >> ");
				String priority="";
				if(choice==1) {
					priority="High";
				}else if(choice==2) {
					priority="Medium";
				}else if(choice==3) {
					priority="Low";
				}else {
					System.out.println("Invalid choice ! The priority will be defined as Low by default");
					priority="Low";
				}

				Controller.addNewTaskToExistingProject(projectID,title,description, startDate, endDate,priority);
				break;

			case 7: //View the tasks of this project
				System.out.println("\nThe list of tasks planned in this project:");
				Controller.displayTasksOfProject(projectID);
				break;

			case 8: //Search a task by ID in this project
				taskID = UserInput.readString("Please type the ID of the task you are looking for:\n>>");
				Controller.showTaskById(projectID,taskID);
				break;

			case 9:// Edit a task
				taskID = UserInput.readString("Please enter the ID of the task you want to edit:\n>>> ");

				if(Controller.fetchTaskByIDInAList(currentProject.tasks,taskID)<0) {
					System.out.println("You can't edit a task that doesn't exist, please retry with a valid ID\n"
							+ "A tip: you can view the list of all tasks in this projects by typing (7)");
				}
				else {
					showTaskScreen(currentProject,taskID);
				}


			case 10:// View the schedule of this project
				System.out.println(" The schedule of the project"+currentProject.getTitle());
				Controller.showSchedule(currentProject);
				break;

			case 11: // Manage the schedule
				if (currentProject.schedule.isEmpty()) {
					System.out.println("The schedule is empty for now!");
				}else {
					showScheduleScreen(currentProject);
				}
				break;

			case 12: //Return to the Manager's Menu
				showManagerMenu();
				break;

			case 13: //Return to Main screen
				System.out.println("Returning to the Main Screen...");
				showMainMenu();
				break;

			default:
				System.out.println("Invalid choice ! please type only numbers from 1 to 13 :");
				return;
			}	

		}while(temp!=13);
	}

	public static void showTaskScreen(Project currentProject,String taskID) {
		/*Manage a task in a project: change status,
		 *  priority, description, title,
		 *   assign team member*/
		Task currentTask=Controller.taskFromID(currentProject,taskID);
		String memberID="";
		int choice=0;

		int temp=0;
		do {
			System.out.println("\n>> MANAGEMENT SCREEN OF THE TASK: "+currentTask.getTitle()+" of ID ("+taskID+"):\n"
					+"\n> TEAM MEMBERS\n"
					+ "0. Display information about this task\n"
					+ "1. Assign a team member to this task\n"
					+ "2. View all team members assigned to this task\n"
					+ "3. Search a team member by ID in this task\n"
					+ "4. Search a team member by name in this task\n"
					+ "5. Remove a team member from this task\n"
					+ "6. Change the priority of this task\n"
					+ "7. Change the status of this task\n"
					+ "8. Change the start and end dates of the task\n"
					+ "9. Delete this task"

					+ "\n> EXIT THE TASK MANAGEMENT SCREEN\n"
					+ "10. Return to the Project's Menu\n"
					+ "11. Return to the Manager's Menu\n"
					+ "12. Return to the Main Menu"
					);

			temp = UserInput.readInt("\nPlease type your choice below :\n>>>> : ");

			switch (temp) {
			case 0:
				Controller.showTaskById(currentProject.getID(),taskID);

			case 1://Assign a team member to this task
				System.out.println("Please enter the corresponding information to assign a team member to this task:\n");
				String memberId = UserInput.readString("ID of the team member:\n>>");
				Controller.connectTaskToTeamMember(memberId,currentProject.getID(), taskID);
				break;

			case 2://View all team members participating in this task
				Controller.showParticipantsTaskProject(currentProject,currentTask);
				break;

			case 3://Search a team member by ID in this task
				memberID = UserInput.readString("ID of the team member you are looking for:\n>>> ");
				Controller.searchTeamMemberByIDInATaskOfaProject(currentProject.getID(),taskID,memberID);
				break;

			case 4://Search a team member by name in this task
				String memberName = UserInput.readString("Name of the team member you are looking for:\n>>> ");
				Controller.searchTeamMemberByNameInATaskOfaProject(currentProject.getID(),taskID,memberName);
				break;

			case 5://Remove a team member from this task
				memberID = UserInput.readString("ID of the team member you want to remove from this task:\n>>> ");
				Controller.removeParticipantFromTask(currentProject.getID(),memberID, taskID);
				break;

			case 6://Change the priority of this task
				choice = UserInput.readInt("Please choose the level of priority from the list below: \n"
						+ "(The priority will remain the same if none of the options blow is chosen)\n"
						+ "1. High\n"
						+ "2. Medium\n"
						+ "3. Low\nPlease type your choice below:\n>>> ");
				String priority="";
				if(choice==1) {
					priority="High";
				}else if(choice==2) {
					priority="Medium";
				}else if(choice==3) {
					priority="Low";
				}else {
					System.out.println("Invalid choice ! The level of priority will remain the same");
					priority=currentTask.getPriority();
				}
				Controller.changeTaskPriority(currentProject, taskID, priority);
				//Controller
				break;

			case 7://Change the status of this task
				choice = UserInput.readInt("Please choose the status from the list below: \n"
						+ "(The status remain the same if none of the options below is chosen)\n"
						+ "1. To Do\n"
						+ "2. In progress\n"
						+ "3. On hold\n"
						+ "4. Done\n"
						+ "Please type your choice here\n"
						+ ">>> ");
				String status="";
				if(choice==1) {
					status="To Do";
				}else if(choice==2) {
					status="In progress";
				}else if(choice==3) {
					status="On hold";
				}else if(choice==4) {
					status="Done";
				}else {
					System.out.println("Invalid choice ! The status will remain the same");
					status=currentTask.getStatus();
				}

				Controller.changeTaskStatus(currentProject, taskID, status);
				break;

			case 8://change the start and end dates of the task

				System.out.println("Please enter the new start date : ");
				int sYear = UserInput.readInt("> Year: ");
				int sMonth= UserInput.readInt("> Month: ");
				int sDate= UserInput.readInt("> Date: ");
				@SuppressWarnings("deprecation") Date startDate= new Date(sYear-1900,sMonth-1,sDate);
				System.out.println("Please enter the new end date :");
				int eYear = UserInput.readInt("> Year: ");
				int eMonth= UserInput.readInt("> Month: ");
				int eDate= UserInput.readInt("> Date: ");
				@SuppressWarnings("deprecation") Date endDate= new Date(eYear-1900,eMonth-1,eDate);
				Controller.changeTaskdate(currentProject, taskID, startDate, endDate);
				break;

			case 9:// Delete this task"
				Controller.removeTaskOfAProject(currentProject.getID(), taskID);
				break;

			case 10://Return to the Project's Menu
				showProjectMenu(currentProject.getID());
				break;
			case 11://Return to the Manager's Menu
				showManagerMenu();
				break;
			case 12://Return to the Main Menu
				showMainMenu();
				break;


			default:
				System.out.println("Invalid choice ! please type only numbers from 0 to 12 :");
				return;
			}	

		}while(temp!=12);

	}

	public static void showTeamMemberScreen(Project project,String teamMID) {
		/*Manage a participant in a project: change role, remove task*/
		TeamMember currentTM=Controller.teamMFromID(project,teamMID);
		//String memberID="";
		int choice=0;
		int temp=0;
		String taskID="";
		do {
			System.out.println("\n>> MANAGEMENT SCREEN OF THE TEAM MEMBER: "+currentTM.getName()+" of ID ("+teamMID+"):\n\n"
					+ "0. Display information about this team member\n"
					+ "1. Assign this team member to a task\n"
					+ "2. View all tasks the team member is  assigned to\n"
					+ "3. Search a task by ID that this team member is assigned to\n"
					+ "4. Remove a task from this team member's list of tasks\n"
					+ "5. Change the role of this team member\n"
					+ "6. Remove a team member from this project\n"

					+ "\n> EXIT THE TEAM MEMBER'S MANAGEMENT SCREEN\n"
					+ "7. Return to the Project's Menu\n"
					+ "8. Return to the Manager's Menu\n"
					+ "9. Return to the Main Menu"
					);

			temp = UserInput.readInt("\nPlease type your choice below :\n>>>> : ");

			switch (temp) {

			case 0:
				Controller.displayTMInfo(project, currentTM);

			case 1://Assign a team member to this task
				System.out.println("Please enter the corresponding information to assign a team member to this task:\n");
				taskID = UserInput.readString("ID of the task:\n>>");
				Controller.connectTaskToTeamMember(currentTM.getID(),project.getID(), taskID);
				break;


			case 2://View all tasks this team members participating in
				Controller.showTasksTMProject(project,currentTM);
				break;

			case 3://Search a task by ID in this team member
				taskID = UserInput.readString("ID of the task you are looking for:\n>>> ");
				Controller.displayTaskInfoTM(project,currentTM, taskID);
				break;

			case 4://Remove a task from a team member's list of tasks
				taskID = UserInput.readString("ID of the task you want to remove:\n>>> ");
				Controller.removeTaskOfTeamMember(project.getID(),currentTM.getID(), taskID);
				break;

			case 5: //Remove a team member from this project
				String option = UserInput.readString("Are you sure of removing this team member from this project? (yes/no):\n>>> ");
				if(option.equals("yes")||option.equals("Yes")) {
					Controller.removeParticipantFromProject(project,currentTM.getID());
				}else {
					System.out.println("The team member "+currentTM.getName()+" will remain in this project!");	
				}

				break;

			case 6://Change the role of this team member
				choice = UserInput.readInt("Please choose the role of the team member from the list below: \n"
						+ "(The role will remain the same if none of the options blow is chosen)\n"
						+ "1. Product Owner\n"
						+ "2. Scrum Master\n"
						+ "3. Developer\nPlease type your choice below:\n>>> ");
				String role="";
				if(choice==1) {
					role="Product Owner";
				}else if(choice==2) {
					role="Scrum Master";
				}else if(choice==3) {
					role="Developer";
				}else {
					System.out.println("Invalid choice ! The priority will remain the same");
					role=currentTM.getRole();
				}
				Controller.changeTMRole(project, currentTM, role);
				break;

				// Exit

			case 7://Return to the Project's Menu
				showProjectMenu(project.getID());
				break;
			case 8://Return to the Manager's Menu
				showManagerMenu();
				break;
			case 9://Return to the Main Menu
				showMainMenu();
				break;

			default:
				System.out.println("Invalid choice ! please type only numbers from 0 to 11 :");
				return;
			}	

		}while(temp!=11);
	}


	public static void showScheduleScreen(Project project) {
		int temp=0;
		do {
			System.out.println(">> MANAGEMENT OF THE SCHEDULE OF THE PROJECT "+project.getTitle()+":\n"
					+ "\n < MEETINGS >\n"

					+ "0. Display the schedule\n"
					+ "1. Add a meeting to the schedule\n"
					+ "2. Show only meetings\n"	
					+ "3. Manage a meeting (edit/delete ...)\n"

					+ "\n < ACTIVITIES >\n"
					+ "4. Add an activity to the schedule"
					+ "5. Show only activities"
					+ "6. Manage an activity (assign participants, edit/delete ...)\n"

					+ "\n < EXIT THE MEETING MANAGEMENT SCREEN >\n"
					+ "7. Return to the Project's Menu\n"	
					+ "8. Return to the Manager's Menu\n"
					+ "9. Return to the Main Menu");

			temp = UserInput.readInt("\nPlease type your choice here \n>>> : ");
			switch (temp) {

			case 0://Display the schedule
				Controller.showSchedule(project);
				break;

			case 1: //Add a meeting to the schedule
				/******************************************************************************************* HERE ********/
				break;

			case 2: //Manage a meeting (edit/delete ...)
				String meetingID = UserInput.readString("ID of the meeting you want to manage:\n>>> ");
				showMeetingScreen(meetingID);
				break;

			case 3: //Add an activity to the schedule
				
				//Date(int year, int month, int date, int hrs, int min)
				String activityType="";
				int choice = UserInput.readInt("Please choose the type from the list below: \n"
						+ "1. Conference\n"
						+ "2. Event\n"
						+ "3. Workshop\n"
						+ "4. Training\n"
						+ "Please type your choice here\n"
						+ ">>> ");
				String status="";
				if(choice==1) {
					activityType="Conference";
				}else if(choice==2) {
					activityType="Event";
				}else if(choice==3) {
					activityType="Workshop";
				}else if(choice==4) {
					activityType="Training";
				}else {
					System.out.println("Invalid choice ! The type will be Activity by default");
					activityType="Activity";
				}

				
				String activityTitle = UserInput.readString("Please enter the title of the activity:\n>>> ");
				String activityDescription = UserInput.readString("Please give a brief description aboutthe activity:\n>>> ");
				System.out.println("Please enter the date : ");
				int sYear = UserInput.readInt("> Year: ");
				int sMonth= UserInput.readInt("> Month: ");
				int sDate= UserInput.readInt("> Date: ");
				System.out.println("Please enter the start time : ");
				int sHour= UserInput.readInt("> Hour: ");
				int sMin= UserInput.readInt("> Min: ");
				
				@SuppressWarnings("deprecation") Date startTime= new Date(sYear-1900,sMonth-1,sDate,sHour,sMin);
				System.out.println("Please enter the end time :");
				int eHour= UserInput.readInt("> Hour: ");
				int eMin= UserInput.readInt("> Min: ");
				@SuppressWarnings("deprecation") Date endTime= new Date(sYear-1900,sMonth-1,sDate,eHour,eMin);
				
				Controller.addActivity(project,activityTitle, activityDescription,startTime,endTime,activityType);
				break;

			case 4: //Manage an activity (edit/delete assign participants...)
				
				String activityID = UserInput.readString("ID of the activity you want to manage:\n>>> ");
				int indexOfActivity=Controller.searchActivityByIDInScheduleproject(project,activityID);
				if(indexOfActivity>=0) {
					showActivityScreen(activityID);
				}
				break;

			case 5: //Return to the Manager's Menu
				showManagerMenu();
				break;

			case 6: //Return to Main screen
				System.out.println("Returning to the Main Screen...");
				showMainMenu();
				break;

			default:
				System.out.println("Invalid choice ! please type only numbers from 1 to 6 :");
				return;
			}	

		}while(temp!=6);


	}


	/*+ "13. Add a meeting to the schedule\n"
					+ "14. Manage a meeting\n"// 

					+ "15. Add an activity to the schedule\n"
					+ "13. Manage an activity\n"*/

	//activity: conference, event, workshop, training,


	public static void showMeetingScreen(String meetingID) {
		//String projectTitle = Controller.projectNameByID(projectID);
		int temp=0;
		do {
			System.out.println(">> MANAGEMENT OF THE MEETING /*+projectTitle+*/+, of ID:"+meetingID+":\n"
					+ "1. Add a participant to the meeting\n"
					// show participants
					+ "2. Remove a particiant from the meeting\n"
					+ "3. Change the description of the meeting\n"
					+ "4. Delete this meeting from the schedule\n"
					+ "\n> EXIT THE MEETING MANAGEMENT SCREEN\n"
					+ "5. Return to the Manager's Menu\n"
					+ "6. Return to the Main Menu");

			temp = UserInput.readInt("\nPlease type your choice here >>>> :");
			switch (temp) {

			case 1: //
				System.err.println("To be implemented");
				break;

			case 2: //
				System.err.println("To be implemented");
				break;
			case 3: //
				System.err.println("To be implemented");
				break;

			case 4: //
				System.err.println("To be implemented");
				break;

			case 5: //Return to the Manager's Menu
				showManagerMenu();
				break;

			case 6: //Return to Main screen
				System.out.println("Returning to the Main Screen...");
				showMainMenu();
				break;

			default:
				System.out.println("Invalid choice ! please type only numbers from 1 to 6 :");
				return;
			}	

		}while(temp!=6);
	}



	public static void showActivityScreen(String activityID) {
		//String projectTitle = Controller.projectNameByID(projectID);
		int temp=0;
		do {
			System.out.println(">> MANAGEMENT OF THE ACTIVITY of ID:"+activityID+":\n"
					+ "1. Add a participant to the activity\n"
					//show participants
					+ "2. Remove a particiant from the activity\n"
					+ "3. Change the description of the activity\n"
					+ "4. Delete this activity from the schedule\n"
					+ "\n> EXIT THE ACTIVITY MANAGEMENT SCREEN\n"
					+ "5. Return to the Manager's Menu\n"
					+ "6. Return to the Main Menu");

			temp = UserInput.readInt("\nPlease type your choice here >>>> :");
			switch (temp) {

			case 1: //
				System.err.println("To be implemented");
				break;

			case 2: //
				System.err.println("To be implemented");
				break;
			case 3: //
				System.err.println("To be implemented");
				break;

			case 4: //
				System.err.println("To be implemented");
				break;

			case 5: //Return to the Manager's Menu
				showManagerMenu();
				break;

			case 6: //Return to Main screen
				System.out.println("Returning to the Main Screen...");
				showMainMenu();
				break;

			default:
				System.out.println("Invalid choice ! please type only numbers from 1 to 6 :");
				return;
			}	

		}while(temp!=6);
	}



}