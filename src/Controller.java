import java.util.UUID;

public class Controller {
    public static void addProject() {

    }
    public static void addTask(){

    }



    public static void showMemberList(){
        for (Member member : Member.memberList) {
            if (member != null){
                System.out.println(member);
            }
        }

    }
    public static void searchTM(){

    }

    public static void addMember(){
        String id = UUID.randomUUID().toString();
        String name = InputHandler.stringInput("Please enter member's name: ");
        String role = InputHandler.stringInput("Please enter member's role: ");
        Member member = new Member(id, name, role);
        Member.registerMember(member);
        System.out.println(name + " was added successfully as a " + role + ". \n");
    }
    public static void removeUser(String idInput){
        for (int i = 0; i < Member.memberList.size(); i++){
            if(Member.memberList.get(i).getId().equals(idInput)){
                Member.memberList.remove(i);
                System.out.println("Member removed!");
            } else System.out.println("Team member with id" + idInput + " not found");
        }

    }



    public static void removeTask(){

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

