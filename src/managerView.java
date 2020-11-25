public class managerView {


    public static void managerMenu() {
        int managerMenuChoice = InputHandler.intInput("Manager Screen - Type one of the options below:\n" +
                "1. Add a project\n" +
                "2. Add a task\n" +
                "3. Team members\n" +
                "4. Remove a task\n" +
                "5. View tasks\n" +
                "6. Assign a task to a team member\n" +
                "7. View all projects\n" +
                "8. Schedule a meeting\n" +
                "9. Return to Main Menu\n");
        switch (managerMenuChoice) {
            case 1 -> Controller.addProject();
            case 2 -> Controller.addTask();
            case 3 -> teamMembers();
            case 4 -> Controller.removeTask();
            case 5 -> Controller.viewTasks();
            case 6 -> Controller.assignTask();
            case 7 -> Controller.viewProjects();
            case 8-> Meetings();
            default->{ }
        }
    }

    public static void Meetings(){
        int mChoice = InputHandler.intInput("1. Schedule new meeting." +
                "\n2. Remove a meeting." +
                "\n3. View all scheduled meeting");
        switch (mChoice) {
            case 1 -> { Controller.scheduleMeeting();
                Meetings(); }
            case 2 -> { Controller.showMeetingList();
            String id = InputHandler.stringInput("Which meeting should be removed? ID: ");
            Controller.removeMeeting(id); Meetings();}
            case 3 -> { Controller.showMeetingList(); Meetings(); }
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
                Controller.removeMember(id); teamMembers();}
            case 3 -> { Controller.showMemberList();teamMembers(); }
            case 4 -> Controller.searchTM();
            default -> { }
        }
    }
}

