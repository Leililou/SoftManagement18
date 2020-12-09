package softManagement18;
import java.util.ArrayList;
import java.util.Date;
//import java.util.Date;

public class Controller {

	private ArrayList<Project> listOfProjects = new ArrayList<Project>();
	private ArrayList<Schedule> schedule = new ArrayList<Schedule>();
	private ArrayList<TeamMember> listOfMembers = new ArrayList<TeamMember>();



	/**Leila
	 * 1. add a project to the list of projects #1.1
	 * 2. create a new task #4.1
	 * 3. add a new task to an existing project #4.1
	 * 4. fetchProjectById
	 * 5. fetchTaskById 
	 * 6. addTeamMember
	 * 7. remove a task of a project's list of tasks #4.2
	 * 
	 * 
	 **Nathalie
	 * 8. Search team member by name #2.3
	 * 9. Search team member by ID #2.3
	 * 
	 * Leila
	 * 
	 * 10. Display information about a specific project(calls fetch project by ID) #1.3
	 * 11. Assign a team member to a project(ById)  #1.2
	 * 12. Connect a Task To a Team Member #5.2
	 * 13. Show Task By Id #4.7
	 * 
	 * 
	 * Anwar
	 * 
	 * 
	 * 
	 * 
	 * 
	 * Vinod
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
	

	// 4. fetch project by ID in the list(if found returns index, else -1)
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
	public int fetchTaskById(int indexOfProject,String taskID) {
		//-2: empty list, -1: invalid ID, i: index
		// check the list of tasks (if empty)
		Project CurrentProject=listOfProjects.get(indexOfProject);
		if(CurrentProject.tasks.isEmpty()) {
			System.err.println("\nThe list of tasks is empty! There is no registed task for the moment!\n");
			return -2;
		}else {
			for(int i=0; i<CurrentProject.tasks.size();i++) {
				if (taskID.equals(CurrentProject.tasks.get(i).getID())) {
					return i;//return CurrentProject.tasks.indexOf(products.get(i));
				}
			}
		}
		System.out.println("Invalid ID! Task of ID: "+ taskID +" not found!");
		return -1;
	}
	// 6. Add a team member to the general list of team members 
	public void addMember(String name,String role) {
		TeamMember member = new TeamMember(name, role);
		listOfMembers.add(member);
		System.out.println("The team member:"+member.getName()+ " has been successfully added as a " + role + ". \n");
	}

	// 7. Remove a task from a project
	public void removeTaskOfAProject(String projectId, String taskID) {
		// fetch project by Id
		// fetch task by ID
		int indexOfProject=fetchProjectById(projectId);
		if(indexOfProject>=0) {
			int indexOfTask=fetchTaskById(indexOfProject,taskID);
			if(indexOfTask>=0) {
				listOfProjects.get(indexOfProject).tasks.remove(indexOfTask);
			}
		}
	}

	// 8. Search team member by ID
	public int searchTeamMemberByID(String id) {
		//-2: empty list, -1: invalid ID, i: index
		// check the list of products (if empty)
		if (listOfMembers.isEmpty()) {
			System.err.println("\nThe list of team members is empty! There is no registered team members!\n");
			return -2;
		} else {
			for (int i = 0; i < listOfMembers.size(); i++) {
				if (id.equals(listOfMembers.get(i).getId())) {
					System.out.println(listOfMembers.get(i));
					return i;
				}
			}
		}
		System.out.println("Invalid ID! Team member of ID: " + id + " not found!");
		return -1;
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



	// 10. Display information about a defined project(by ID)
	public void showProjectInfo(String projectID) {
		int index=fetchProjectById(projectID);
		if (index>=0) {
			System.out.println(listOfProjects.get(index)+"\nThe participants in this project are:");
			listOfProjects.get(index).displayParticipants();
		}
		else {
			System.out.println("No data to display!"); 
		}
	}


	// 11. Assign a team member to a project(ById) 
	public void assignTeamMemberToProject(String projectId,String memberID) {
		int indexMember=searchTeamMemberByID(memberID);
		if (indexMember>=0) {
			int indexProject=fetchProjectById(projectId);
			if(indexProject>=0) {
				TeamMember currentParticipant=listOfMembers.get(indexMember);
				Project currentProject=listOfProjects.get(indexProject);
				currentProject.participants.add(currentParticipant);
				System.out.println("Assignement of "+currentParticipant.getName()+" to the project:"+currentProject.getTitle()+" has been sucessful");
			}
		}
		else {
			System.out.println("Asingment of the team member to the project has failed!");
		}
	}
	
	
	//12. Connect a Task To a Team Member
	public void connectTaskToTeamMember(String memberID, String projectID,String taskID) {
		int indexMember=searchTeamMemberByID(memberID);
		if (indexMember>=0) {
			int indexProject=fetchProjectById(taskID);
			if(indexProject>=0) {
				int indexTask=fetchTaskById(indexProject,taskID);
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
	
	// 13. Show Task By Id
	public void showTaskById(String projectID,String taskID) {
		int indexProject=fetchProjectById(projectID);
		if(indexProject>=0) {
			int indexTask=fetchTaskById(indexProject,taskID);
			if(indexTask>=0) {
				System.out.println(listOfProjects.get(indexProject).tasks.get(indexTask));
				listOfProjects.get(indexProject).tasks.get(indexTask).displayParticipants();
			}
		}
	}



	public static void assignTask() {

	}

	public static void viewProjects() {

	}

	public static void viewTasks() {

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

