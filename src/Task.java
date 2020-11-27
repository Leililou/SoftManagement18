package softManagement18;

import java.util.Date;
import java.util.UUID;

public class Task {

    //The task should have a name,a number, a description, a start date, end date and type of priority.
    private String ID;
    private String title;
    private String description;
    private Date startDate;
    private Date endDate;
    private String priority;
    private String status;

    public Task(String title, String description, Date startDate, Date endDate, String priority, String status) {

        UUID uuid = UUID.randomUUID();
        this.ID = uuid.toString();
        this.ID = ID.substring(0, Math.min(ID.length(), 5));

        this.title=title;
        this.description=description;
        this.startDate=startDate;
        this.endDate=endDate;
        this.priority=priority;
        this.status=status;
    }

    public String getStatus() {
        return status;
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

    Date getStartDate() {
        return startDate;
    }

    Date getEndDate() {
        return endDate;
    }

    String getPriority() {
        return priority;
    }

    void setTitle(String title) {
        this.title = title;
    }

    void setDescription(String description) {
        this.description = description;
    }

    void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    //High, Medium, Low
    void setPriority(String priority) {
        this.priority = priority;
    }

    //The status should be To do, Doing or Done.
    public void setStatus(String status) {
        this.status = status;
    }

    public String toString() {
        return "\n\n>> Task of ID: "+this.getID()+
                "\n> Title: "+this.getTitle()+
                "\n> Description: "+this.getDescription()+
                "\n> Start date: "+this.getStartDate()+
                "\n> End date: "+this.getEndDate()+
                "\n>Type of priority: "+this.getPriority()+
                "\n> Status: "+this.getStatus();
    }


}
