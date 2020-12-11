package softManagement18;
import java.util.ArrayList;
import java.util.Date;
//import java.util.Date;

//Try

public class Controller {

	private static ArrayList<Project> listOfProjects = new ArrayList<Project>();
	private ArrayList<Schedule> schedule = new ArrayList<Schedule>();
	private static ArrayList<TeamMember> listOfMembers = new ArrayList<TeamMember>();

	/**Missing
	 * remove team member #2.2 Anwar (it's not adabted to the code (classes and names of lists))
	 * 
	 * 
	 */

	/**
	 * **** PROJECT
	 * ** I. ADD
	 * 1. add a project to the list of projects #1.1(Leila)
	 * 
	 * ** II. SEARCH
	 * 4. fetchProjectById(Leila)
	 * 
	 * ** III.REMOVE
	 * (Not yet implemented)
	 * 
	 * ** IV. CHANGE/REPLACE
	 * (Not yet implemented)
	 * 
	 * ** V. DISPLAY/SHOW element by ID or LIST
	 * 18.Display List Of Projects #1.4 (Leila)
	 * 10. Display information about a specific project(calls fetch project by ID) #1.3(Leila)
	 * 
	 * ** V.CONNECT TEAM MEMBER TO A PROJECT
	 * 11. Assign a team member to a project(ById)  #1.2(Leila)
	 *
	 *
	 * **** TASK
	 * ** I. SEARCH
	 * 17. fetch tasks by ID in a list (if found returns index, else -1)(Leila)
	 * 
	 * 
	 * **** TEAM MEMBER
	 * ** I. ADD
	 * 6. add Team Member to the general list of members #2.1 changed by (Anwar)(Leila)
	 * ** II. SEARCH
	 * 8.1 Search a team member in a project(Leila)
	 * 16. Search team member by ID in a list(To define) #2.3(Nathalie)
	 * 9. Search team member by name #2.3(Nathalie)
	 * 
	 * ** III.REMOVE
	 * (Not yet implemented)
	 * 
	 * ** IV. CHANGE/REPLACE
	 * (Not yet implemented)
	 * 
	 * ** V. DISPLAY/SHOW LIST
	 * 19.Display The List Of TeamMembers #2.4 (Leila)
	 * 
	 * **** Participant in a task of a project
	 * ** I. ADD
	 * (Not yet implemented)
	 * 
	 * ** II. SEARCH
	 * 8.2 Search team member by ID participating in a task in a specific project(Leila)
	 * 
	 * ** III.REMOVE
	 * 15. Remove a participant from a task's list (verified) #5.3 (Leila)
	 * 
	 * ** IV. CHANGE/REPLACE
	 * (Not yet implemented)
	 * 
	 * 
	 * ** V. DISPLAY/SHOW LIST
	 * (Not yet implemented)
	 * 
	 * **** TASKS OF A PROJECT
	 * ** I. ADD
	 * 2. create a new task in a project #4.1(Leila)
	 * 3. add a new task to an existing project #4.1(Leila)
	 * 
	 * ** II. SEARCH
	 * 5. fetchTaskById in a project(Leila)
	 * 
	 * ** III.REMOVE
	 * 7. remove a task of a project's list of tasks #4.2(Leila)
	 * 
	 * ** IV. CHANGE/REPLACE
	 * (Not yet implemented)
	 *  
	 * ** V. DISPLAY/SHOW LIST
	 * 13. Show Task By Id #4.7(Leila)
	 * 
	 * **** TASKS OF A TEAM MEMBER IN A PROJECT
	 * ** I. ADD
	 * 12. Connect a Task To a Team Member #5.2(Leila)
	 * 
	 * ** II. SEARCH
	 * (Not yet implemented)
	 * 
	 * ** III.REMOVE
	 * 14. Remove a task from a team member's list #5.4(Leila)
	 * 
	 * ** IV. CHANGE/REPLACE
	 * (Not yet implemented)
	 * 
	 * ** V. DISPLAY/SHOW LIST
	 * (Not yet implemented)
	 * 
	 * 
	 * **** CONNECTION BETWEEN TEAM MEMBER AND TASK
	 * 12. Connect a Task To a Team Member #5.2(Leila)
	 * 
	 * TO IMPLEMENT**
	 * * SCHEDULE
	 * * MEETING
	 * * ACTIVITY
	 * 
	 * 
	 */




	// 1. Create a new project
	public void addProject(String title, String description) {
		Project project=new Project(title, description);
		listOfProjects.add(project);
		System.out.println(project.getTitle()+" of ID:"+project.getID()+", successfully added!");
	}


	// 2. Create a new task(a helping method, called in other methods)
	public Task createNewTask(String title, String description, Date startDate, Date endDate, String priority, String status) {
		Task task=new Task(title,description,startDate,endDate,priority,status);
		return task;
	}

	// 3. add a new task to an existing project
	public void addNewTaskToExistingProject(String projectId,String title, String description, Date startDate, Date endDate, String priority, String status) {
		int indexOfProject=fetchProjectById(projectId);
		if (indexOfProject>=0) {
			Task newTask=createNewTask(title,description,startDate,endDate,priority,status);
			listOfProjects.get(indexOfProject).tasks.add(newTask);
		}
		else {
			System.out.println("Failed to add the new task to the project with ID: "+projectId);
		}
	}


	// 4. fetch project by ID in the list if found returns index, else -1
	public int fetchProjectById(String projectId) {
		//-2: empty list, -1: invalid ID, i: index
		// check the list of projects (if empty)
		if(listOfProjects.isEmpty()) {
			System.err.println("\nThe list of projects is empty! There is no registed project for the moment!\n");
			return -2;
		}else {
			for(int i=0; i<listOfProjects.size();i++) {
				if (projectId.equals(listOfProjects.get(i).getID())) {
					return i;//return listOfProjects.indexOf(products.get(i));
				}
			}
		}
		System.out.println("Invalid ID! Item of ID: "+ projectId +" not found!");
		return -1;
	}

	// 5. fetch tasks by ID in the list of a specific project with a known index(if found returns index, else -1)
	public void fetchTaskByIDInAProject(String projectID,String taskID) {
		if(!listOfProjects.isEmpty()) {
			for(Project currentProject:listOfProjects) {
				if(projectID.equals(currentProject.getID())){
					fetchTaskByIDInAList(currentProject.tasks,taskID);
				}
			}
		}
	}

	// 6. Add a team member to the general list of team members 
	public static void addMember(String name,String role) {
		TeamMember member = new TeamMember(name, role);
		listOfMembers.add(member);
		System.out.println("The team member:"+member.getName()+ " has been successfully added as a " + member.getRole() + ". \n");
	}

	// 7. Remove a task from a project (and from all participants' lists) (verified)
	public void removeTaskOfAProject(String projectID, String taskID) {
		// fetch project by Id
		// fetch task by ID
		int indexOfProject=fetchProjectById(projectID);
		if(indexOfProject>=0) {
			int indexOfTask=fetchTaskByIDInAList(listOfProjects.get(indexOfProject).tasks,taskID);
			if(indexOfTask>=0) {
				for(TeamMember currentParticipant:listOfProjects.get(indexOfProject).participants) {
					removeTaskOfTeamMember(projectID,currentParticipant.getID(), taskID);
				}
				listOfProjects.get(indexOfProject).tasks.remove(indexOfTask);	
			}
		}
	}


	// 8.1. Search team member by ID participating in a specific project
	public void searchTeamMemberByIDInProject(String projectID,String id) {
		if(!listOfProjects.isEmpty()) {
			for(Project currentProject:listOfProjects) {
				if(projectID.equals(currentProject.getID())){
					searchTeamMemberByIDInAList(listOfMembers,id);
				}
			}
		}
	}

	// 8.2. Search team member by ID participating in a task in a specific project
	public void searchTeamMemberByIDInATaskOfaProject(String projectID,String taskID,String memberID) {
		if(!listOfProjects.isEmpty()) {
			for(Project currentProject:listOfProjects) {
				if(projectID.equals(currentProject.getID())){
					for(Task currentTask:currentProject.tasks) {
						if(taskID.equals(currentTask.getID())){
							searchTeamMemberByIDInAList(currentTask.participants,memberID);
						}
					}	
				}
			}
		}
	}

	// 9. Search team member by name
	public void searchTeamMemberByName(String name) {
		//-2: empty list, -1: invalid ID, i: index
		// check the list of products (if empty)
		if (listOfMembers.isEmpty()) {
			System.err.println("\nThe list of team members is empty! There is no registered team members!\n");
			// return -2;
		} else {
			for (int i = 0; i < listOfMembers.size(); i++) {
				if (name.equals(listOfMembers.get(i).getName())) {
					// return i;//return products.indexOf(products.get(i));
					System.out.println(listOfMembers.get(i));
				}
			}
		}
		System.out.println("Invalid Name! Team member: " + name + " not found!");
		// return -1;
	}




	// 10. Display information about a defined project(by ID) (verified)
	public void showProjectInfo(String projectID) {
		int indexP=fetchProjectById(projectID);
		if (indexP>=0) {
			System.out.println(listOfProjects.get(indexP)+"\nThe participants in this project are:");
			/*
			for(TeamMember currentParticipant:listOfProjects.get(indexP).participants) {
			System.out.println(currentParticipant);
			}
			 */
			listOfProjects.get(indexP).displayParticipants();
		}
		else {
			System.out.println("No data to display!"); 
		}
	}


	// 11. Assign a team member to a project(ById) (verified)
	public void assignTeamMemberToProject(String projectId,String memberID) {
		int indexMember=searchTeamMemberByIDInAList(listOfMembers,memberID);
		if (indexMember>=0) {
			int indexProject=fetchProjectById(projectId);
			if(indexProject>=0) {
				TeamMember currentParticipant = listOfMembers.get(indexMember);
				Project currentProject=listOfProjects.get(indexProject);
				currentProject.participants.add(currentParticipant);
				System.out.println("Assignement of "+currentParticipant.getName()+" to the project:"+currentProject.getTitle()+" has been sucessful");
			}
		}
		else {
			System.out.println("Asingment of the team member to the project has failed!");
		}
	}


	//12. Connect a Task To a Team Member in a project (verified)
	public void connectTaskToTeamMember(String memberID, String projectID, String taskID){
		int indexProject=fetchProjectById(taskID);
		if(indexProject>=0) {
			int indexMember=searchTeamMemberByIDInAList(listOfProjects.get(indexProject).participants, memberID);
			if (indexMember>=0) {
				int indexTask=fetchTaskByIDInAList(listOfProjects.get(indexProject).tasks,taskID);
				if(indexTask>=0) {
					Project currentProject=listOfProjects.get(indexProject);
					TeamMember currentParticipant= currentProject.participants.get(indexMember);
					Task currentTask=currentProject.tasks.get(indexTask);
					currentParticipant.tasks.add(currentTask);
					currentTask.participants.add(currentParticipant);
					System.out.println("Connection of "+currentParticipant.getName()+" to the task:"+currentTask.getTitle()+" Of the project:"+currentProject.getTitle()+" has been sucessful");
				}	
			}
		}
		else {
			System.out.println("Asingment of the team member to the task has failed!");
		}
	}

	// 13. Show Task By Id (verified)
	public void showTaskById(String projectID,String taskID) {
		int indexProject=fetchProjectById(projectID);
		if(indexProject>=0) {
			int indexTask=fetchTaskByIDInAList(listOfProjects.get(indexProject).tasks,taskID);
			if(indexTask>=0) {

				System.out.println(listOfProjects.get(indexProject).tasks.get(indexTask));
				/*for(Task currentParticipant:listOfProjects.get(indexProject).tasks.get(indexTask).participants){
				 * System.out.println(currentParticipant);
				 * }
				 */
				listOfProjects.get(indexProject).tasks.get(indexTask).displayParticipants();
			}
		}
	}

	//14. Remove a task from a team member's list (verified)
	public void removeTaskOfTeamMember(String projectId,String teamMemberID, String taskID) {
		int indexP=fetchProjectById(projectId);
		if(indexP>=0){
			int indexTM=searchTeamMemberByIDInAList(listOfProjects.get(indexP).participants,teamMemberID);
			if(indexTM>=0) {
				int indexT=fetchTaskByIDInAList(listOfProjects.get(indexP).participants.get(indexTM).tasks,taskID);
				listOfProjects.get(indexP).participants.get(indexTM).tasks.remove(indexT);	
			}
		}	
	}


	//15. Remove a participant from a task's list (verified)
	public void removeParticipantFromTask(String projectID,String teamMemberID, String taskID) {
		int indexP=fetchProjectById(projectID);
		if(indexP>=0) {
			int indexT=fetchTaskByIDInAList(listOfProjects.get(indexP).tasks,taskID);
			if(indexT>=0) {
				int indexTM=searchTeamMemberByIDInAList(listOfProjects.get(indexP).tasks.get(indexT).participants,teamMemberID);
				listOfProjects.get(indexP).tasks.get(indexT).participants.remove(indexTM);
			}
		}
	}

	// 16. Search team member by ID in a list(To define)
	public int searchTeamMemberByIDInAList(ArrayList<TeamMember>list,String id) {
		//-2: empty list, -1: invalid ID, i: index
		// check the list of products (if empty)
		if (list.isEmpty()) {
			System.err.println("\nThe list is empty! There is no registered team member!\n");
			return -2;
		} else {
			for (int i = 0; i < list.size(); i++) {
				if (id.equals(list.get(i).getID())) {
					System.out.println(list.get(i));
					return i;
				}
			}
		}
		System.out.println("Invalid ID! No such team member of ID: " + id + " found!");
		return -1;
	}

	// 17. fetch tasks by ID in a list (if found returns index, else -1)
	public int fetchTaskByIDInAList(ArrayList<Task> taskList,String taskID) {
		//-2: empty list, -1: invalid ID, i: index
		// check the list of tasks (if empty)
		if (taskList.isEmpty()) {
			System.err.println("\nThe list is empty! There is no registered task!\n");
			return -2;
		} else {
			for (int i = 0; i < taskList.size(); i++) {
				if (taskID.equals(taskList.get(i).getID())) {
					System.out.println(taskList.get(i));
					return i;
				}
			}
		}
		System.out.println("Invalid ID! No such task of ID: " + taskID + " found!");
		return -1;
	}

	//18.DisplayListOfProjects
	public void DisplayListOfProjects() {
		if(listOfProjects.isEmpty()) {
			System.out.println("No data to display! the List of projects is Empty!");
		}
		else{
			for(Project currentProject:listOfProjects)  {
				System.out.println(currentProject);
			}
		}
	}
	//19.DisplayTheListOfTeamMmbers
	public static void displayTheListOfTeamMembers() {
		if(listOfMembers.isEmpty()) {
			System.out.println("No data to display! the List of team members is Empty!");
		}
		else{
			for(TeamMember currentTM:listOfMembers)  {
				System.out.println(currentTM);
			}
		}
	}

	//********* not yet verified
	/*
	public static void scheduleMeeting() {
		String meetingId = UUID.randomUUID().toString();
		String meetingDay = softManagement18.InputHandler.stringInput("Enter meeting date in form of dd-mm-yyyy");
		String meetingTime = softManagement18.InputHandler.stringInput("Enter meeting time in form of hh:mm:ss");
		String meetingD = meetingDay + " " + meetingTime;
		Date meetingDate = null;
		try {
			meetingDate = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").parse(meetingD);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		String meetingAbout = softManagement18.InputHandler.stringInput("Please specify what the meeting is about in one word: ");
		Meeting meeting = new Meeting(meetingId, meetingDate, meetingAbout);
		Meeting.meetingList.add(meeting);
		System.out.println("\t" + meetingDate + "\n " + meetingAbout + "\n");
	}
	 */

	//********* not yet verified
	/*
	 * 
	//The team member should be removed from the lists of tasks first in case he/she is part of it then the general list
	public static void removeMember(String idInput) {
		for (int i = 0; i < Member.memberList.size(); i++) {
			if (Member.memberList.get(i).getId().equals(idInput)) {
				Member.memberList.remove(i);
				System.out.println("Member removed!");
			} else System.out.println("Team member with id" + idInput + " not found");
		}
	}
	 */

	//********* not yet verified
	/*
	public static void showMeetingList() {
		for (Meeting meeting : Meeting.meetingList) {
			if (meeting != null) {
				System.out.println(meeting);
			}
		}
	}
	 */


	//********* not yet verified
	/*
	public static void removeMeeting(String meetingIdInput) {
		for (int i = 0; i < Meeting.meetingList.size(); i++) {
			if (Meeting.meetingList.get(i).getMeetingId().equals(meetingIdInput)) {
				Meeting.meetingList.remove(i);
				System.out.println("Meeting removed!");
			} else System.out.println("Meeting with id" + meetingIdInput + " not found");
		}
	}
	 */
}


