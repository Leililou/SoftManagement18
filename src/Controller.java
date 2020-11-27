package softManagement18;
import java.util.ArrayList;
//import java.util.Date;

public class Controller {

	private static ArrayList<Project> listOfProjects = new ArrayList<Project>();
	private static ArrayList<Schedule> schedule = new ArrayList<Schedule>();
	private static ArrayList<TeamMember> listOfMembers = new ArrayList<TeamMember>();

	public static void addProject(String title, String description) {
		Project project=new Project(title, description);
		listOfProjects.add(project);
		System.out.println(project.getTitle()+" successfully added!");
	}


	//********************************

	/**
	 * ask which project to add a task into
	 * list projects (*)
	 * fetch project by ID (*)
	 * if found
	 * create task(*)
	 * add task to project
	 * 
	 * */

	//Task(String title, String description, Date startDate, Date endDate, String priority, String status)
	//Task task=new Task(title,description,startDate,endDate,priority,status);	
	public static void addTaskToProject(String projectId) {

	}




	//********* not yet verified
	/*public static void showMemberList() {
		for (Member member : Member.memberList) {
			if (member != null) {
				System.out.println(member);
			}
		}
	}*/


	public static void searchTeamMemberByID(String id) {
		//-2: empty list, -1: invalid ID, i: index
		// check the list of products (if empty)
		if (listOfMembers.isEmpty()) {
			System.err.println("\nThe list of team members is empty! There is no registered team members!\n");
			// return -2;
		} else {
			for (int i = 0; i < listOfMembers.size(); i++) {
				if (id.equals(listOfMembers.get(i).getId())) {
					// return i;//return products.indexOf(products.get(i));
					System.out.println(listOfMembers.get(i));
				}
			}
		}
		System.out.println("Invalid ID! Team member of ID: " + id + " not found!");
		// return -1;
	}

	public static void searchTeamMemberByName(String name) {
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

	public static void addMember(String name,String role) {
		TeamMember member = new TeamMember(name, role);
		listOfMembers.add(member);
		System.out.println("The team member:"+member.getName()+ " has been successfully added as a " + role + ". \n");
	}


	/*public static void removeUser(String idInput){
        for (int i = 0; i < Member.memberList.size(); i++){
            if(Member.memberList.get(i).getId().equals(idInput)){
                Member.memberList.remove(i);
                System.out.println("Member removed!");
            } else System.out.println("Team member with id" + idInput + " not found");
        }

    }*/


	public static void removeTask() {

	}


	public static void assignTask() {

	}

	public static void viewProjects() {

	}

	public static void viewTasks() {

	}


	public static ArrayList<Schedule> getSchedule() {
		return schedule;
	}

	//********* not yet verified
	/*
	public static void scheduleMeeting() {
		String meetingId = UUID.randomUUID().toString();
		String meetingDay = InputHandler.stringInput("Enter meeting date in form of dd-mm-yyyy");
		String meetingTime = InputHandler.stringInput("Enter meeting time in form of hh:mm:ss");
		String meetingD = meetingDay + " " + meetingTime;
		Date meetingDate = null;
		try {
			meetingDate = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").parse(meetingD);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		String meetingAbout = InputHandler.stringInput("Please specify what the meeting is about in one word: ");
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

