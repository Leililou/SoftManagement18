import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;
import java.util.ArrayList;

public class Controller {

    private static ArrayList<Member> memberList = new ArrayList<Member>();

    public static void addProject() {

    }

    public static void addTask() {

    }


    public static void showMemberList() {
        for (Member member : Member.memberList) {
            if (member != null) {
                System.out.println(member);
            }
        }

    }

    public static void searchTMID(String id) {

        //-2: empty list, -1: invalid ID, i: index
        // check the list of products (if empty)
        if (memberList.isEmpty()) {
            System.err.println("\nThe list of team members is empty! There is no registered team members!\n");
            // return -2;
        } else {
            for (int i = 0; i < memberList.size(); i++) {
                if (id.equals(memberList.get(i).getID())) {
                    // return i;//return products.indexOf(products.get(i));
                    system.out.prinln(memberList.get(i));
                }
            }
        }
        System.out.println("Invalid ID! Team member of ID: " + id + " not found!");
        // return -1;

    }

    public static void searchTMName(String name) {

        //-2: empty list, -1: invalid ID, i: index
        // check the list of products (if empty)
        if (memberList.isEmpty()) {
            System.err.println("\nThe list of team members is empty! There is no registered team members!\n");
            // return -2;
        } else {
            for (int i = 0; i < memberList.size(); i++) {
                if (name.equals(memberList.get(i).getName())) {
                    // return i;//return products.indexOf(products.get(i));
                    system.out.prinln(memberList.get(i));
                }
            }
        }
        System.out.println("Invalid Name! Team member: " + name + " not found!");
        // return -1;

    }

    public static void addMember() {
        String id = UUID.randomUUID().toString();
        String name = InputHandler.stringInput("Please enter member's name: ");
        String role = InputHandler.stringInput("Please enter member's role: ");
        Member member = new Member(id, name, role);
        Member.registerMember(member);
        System.out.println(name + " was added successfully as a " + role + ". \n");
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

    public static void removeMember(String idInput) {
        for (int i = 0; i < Member.memberList.size(); i++) {
            if (Member.memberList.get(i).getId().equals(idInput)) {
                Member.memberList.remove(i);
                System.out.println("Member removed!");
            } else System.out.println("Team member with id" + idInput + " not found");
        }
    }


    public static void showMeetingList() {
        for (Meeting meeting : Meeting.meetingList) {
            if (meeting != null) {
                System.out.println(meeting);
            }
        }
    }

    public static void removeMeeting(String meetingIdInput) {
        for (int i = 0; i < Meeting.meetingList.size(); i++) {
            if (Meeting.meetingList.get(i).getMeetingId().equals(meetingIdInput)) {
                Meeting.meetingList.remove(i);
                System.out.println("Meeting removed!");
            } else System.out.println("Meeting with id" + meetingIdInput + " not found");
        }
    }
}

