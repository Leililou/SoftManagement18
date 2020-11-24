
import java.util.ArrayList;
import java.util.UUID;

public class Member {
    protected String id = UUID.randomUUID().toString();
    private String name;
    private String role;
    static ArrayList<Member> memberList = new ArrayList<>();


    public Member(String id, String name, String role) {
        this.id = id;
        this.name = name;
        this.role = role;


    }
    public static void registerMember(Member member) {
        memberList.add(member);
        System.out.println(member);
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public static void removeUser(String idInput){
        for (int i = 0; i < memberList.size(); i++){
            if(memberList.get(i).getId().equals(idInput)){
                memberList.remove(i);
                System.out.println("Member removed!");
            } else System.out.println("ID " + idInput + " is not found\n");
        }

    }



     public String toString() {
        return "ID: "+ this.id + ": " + this.name + ", Role: " + this.role;
    }

}

