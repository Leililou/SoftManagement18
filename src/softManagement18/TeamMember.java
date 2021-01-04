package softManagement18;

import java.util.ArrayList;
import java.util.UUID;

public class TeamMember {
	
    private String ID;
    private String name;
    private String role;
    
    ArrayList<Task> tasks = new ArrayList<Task>();

// think about assigning roles
    public TeamMember(String name, String role) {
        UUID uuid = UUID.randomUUID();
		this.ID = uuid.toString();
		this.ID = ID.substring(0, Math.min(ID.length(), 3)); 
		
        this.name = name;
        this.role = role;
    }
    
    public String getID() {
		return ID;
	}

    
    public String getName() {
        return name;
    }
    
    public String getRole() {
        return role;
    } 

    public void setName(String name) {
        this.name = name;
    }

    public void setRole(String role) {
        this.role = role;
    }
    
    public void displayListOfTasks() {
    	System.out.println("The tasks that "+this.getName()+" is assigned to:");
    	if(this.tasks.isEmpty()) {
			System.out.println("> This team member is not assigned yet to any task in this project!");
		}
		else {
			for(Task currentTask:this.tasks) {
				System.out.println("+ "+currentTask);
			}
		}
    }


     public String toString() {
        return "> ID: "+this.getID()+", name: "+this.getName()+", Role: "+ this.getRole();
    }

	
}

