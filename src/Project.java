package softManagement18;

import java.util.ArrayList;
import java.util.UUID;

public class Project {


	private String ID;
	private String title;
	private String description;
	
	private static ArrayList<Task> tasks = new ArrayList<Task>();

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
	
	static ArrayList<Task> getTasks() {
		return tasks;
	}

	void setTitle(String title) {
		this.title = title;
	}

	void setDescription(String description) {
		this.description = description;
	}
	
	public String toString() {
		return "ID: "+this.getID()+", Project's title:"+this.getTitle()+", Description:"+this.getDescription();
	}



}