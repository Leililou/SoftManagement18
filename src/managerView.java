import java.util.UUID;

public class managerView {


    public static void managerMenu(){
        int managerMenuChoice = InputHandler.intInput("Manager Screen - Type one of the options below:\n" +
                "1. Add a project\n" +
                "2. Add a task\n" +
                "3. add a team member\n" +
                "4. Remove a task\n" +
                "5. Remove a team member\n" +
                "6. Assign a task to a team member\n" +
                "7. View all projects\n" +
                "8. View tasks\n" +
                "9. Schedule a meeting\n" +
                "10. Return to Main Menu\n");
        switch (managerMenuChoice){
            case 1 -> addProject();
            case 2 -> addTask();
            case 3 -> teamMembers();
            case 4 -> removeTask();
            case 5 -> removeTM();
            case 6 -> assignTask();
            case 7 ->viewProjects();
            case 8 ->viewTasks();
            case 9 ->scheduleMeeting();
            case 10 ->{ }}
    }
    public static void addProject() {

    }
    public static void addTask(){

    }
    public static void teamMembers() {
       int tmChoice = InputHandler.intInput("1. View all team members." +
                "\n2. Add new team member." +
               "\n3. Remove a member");
       switch (tmChoice){
           case 1 ->
                   { showMemberList();teamMembers(); }
           case 2 ->
                   { addMember();teamMembers(); }
           case 3 ->
                   { showMemberList();
            String id = InputHandler.stringInput("Which member should be removed? ID: ");
            Member.removeUser(id); teamMembers(); }
       }
    }



    public static void showMemberList(){
        for (Member member : Member.memberList) {
            if (member != null){
                System.out.println(member );
            }
        }

    }
    public static void addMember(){
    String id = UUID.randomUUID().toString();
    String name = InputHandler.stringInput("Please enter member's name: ");
    String role = InputHandler.stringInput("Please enter member's role: ");
    Member member = new Member(id, name, role);
    Member.registerMember(member);
    System.out.println(name + " was added successfully as a " + role + ". \n");
    }


    public static void removeTask(){

    }
    public static void removeTM(){

    }
    public static void assignTask(){

    }
    public static void viewProjects(){

    }
    public static void viewTasks(){

    }
    public static void scheduleMeeting(){

    }
}
