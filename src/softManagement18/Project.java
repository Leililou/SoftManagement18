package softManagement18;

import java.util.ArrayList;
import java.util.UUID;

public class Project {


	private String ID;
	private String title;
	private String description;


	ArrayList<TeamMember> participants = new ArrayList<TeamMember>();
	ArrayList<Task> tasks = new ArrayList<Task>();

	public Project(String title, String description) {

		UUID uuid = UUID.randomUUID();
		this.ID = uuid.toString();
		this.ID = ID.substring(0, Math.min(ID.length(), 3)); 

		this.title=title;
		this.description=description;
	}

	String getID() {
		return ID;
	}

	String getTitle() {
		return title;
	}

	String getDescription() {
		return description;
	}


	void setTitle(String title) {
		this.title = title;
	}

	void setDescription(String description) {
		this.description = description;
	}

	void displayParticipants() {
		if(this.participants.isEmpty()) {
			System.out.println("> No participant is assigned yet to this project!");
		}
		else {
			for(TeamMember currentParticipant:this.participants) {
				System.out.println(currentParticipant);
			}
		}
	}

	public String toString() {
		return "\n> Project's ID: "+this.getID()+", Project's title:"+this.getTitle()+", Description:"+this.getDescription();
	}



}