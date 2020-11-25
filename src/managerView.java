
public class managerView {


    public static void managerMenu() {
        int managerMenuChoice = InputHandler.intInput("Manager Screen - Type one of the options below:\n" +
                "1. Add a project\n" +
                "2. Add a task\n" +
                "3. Team members\n" +
                "4. Remove a task\n" +
                "5. Remove a team member\n" +
                "6. Assign a task to a team member\n" +
                "7. View all projects\n" +
                "8. View tasks\n" +
                "9. Schedule a meeting\n" +
                "10. Return to Main Menu\n");
        switch (managerMenuChoice) {
            case 1 -> Controller.addProject();
            case 2 -> Controller.addTask();
            case 3 -> teamMembers();
            case 4 -> Controller.removeTask();
            case 5 -> Controller.viewTasks();
            case 6 -> Controller.assignTask();
            case 7 -> Controller.viewProjects();
            case 9 -> Controller.scheduleMeeting();
            default -> Main.intro();
        }
    }
    public static void teamMembers() {
        int tmChoice = InputHandler.intInput("1. Add new team member." +
                "\n2. Remove a team member." +
                "\n3. View all team members." +
                "\n4. Go back to previous menu");
        switch (tmChoice){
            case 1 -> { Controller.addMember();teamMembers(); }
            case 2 -> { Controller.showMemberList();
                String id = InputHandler.stringInput("Which member should be removed? ID: ");
                Controller.removeUser(id); teamMembers();}
            case 3 -> { Controller.showMemberList();teamMembers(); }
            case 4 -> Controller.searchTM();
            default -> { }
        }
    }
}

