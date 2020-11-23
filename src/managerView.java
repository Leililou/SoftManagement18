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
                "10. Return to Main Menu\n"
        );
        switch (managerMenuChoice){
            case 1 -> addProject();
            case 2 ->addTask();
            case 3 -> addTM();
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
    public static void addTM(){

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
