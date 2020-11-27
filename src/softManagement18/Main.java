package softManagement18;

import softManagement18.InputHandler;

class Main {
    public static void main(String[] args) {
        intro();
    }
    public static void intro(){
        String mainMenuChoice = InputHandler.stringInput("Welcome to SoftManagement18," +
                    " Please specify your role by entering one of the options given:\n" +
                    "1. Enter “M” for Manager\n" +
                    "2. Enter “T” for Team member");
            switch (mainMenuChoice) {

                case "M" -> managerView.managerMenu();
                case "T" -> { } }
    }
}