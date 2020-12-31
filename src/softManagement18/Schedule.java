package softManagement18;

//import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

abstract class Schedule {


    private ArrayList<TeamMember> participants=new ArrayList<TeamMember>();
    private String ID;
    private Date date;
    private String description;
    private String startTime;
    private String endTime;


    // date(int year, int month, int date)
    //public Schedule(String meetingId,Date meetingDate, String description,Time startTime,Time endTime)
    public Schedule(String meetingId,Date meetingDate, String description,String startTime,String endTime) {
        UUID uuid = UUID.randomUUID();
        this.ID = uuid.toString();
        this.ID = ID.substring(0, Math.min(ID.length(), 3));

        this.date = meetingDate;
        this.description = description;
        this.startTime=startTime;
        this.endTime=endTime;
        this.participants=new ArrayList<TeamMember>();
    }

    ArrayList<TeamMember> getParticipants() {
        return participants;
    }

    public String getStartTime() {
        return startTime;
    }


    public String getEndTime() {
        return endTime;
    }


    public String getID() {
        return ID;
    }


    public Date getDate() {
        return date;
    }


    public String getDescription() {
        return description;
    }


    public void setDate(Date date) {
        this.date = date;
    }


    public void setDescription(String description) {
        this.description = description;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }


    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public void listOfParticipants() {
        if(this.participants.isEmpty()) {
            System.out.println("\nThe list of participants is currently empty!");
        }else {
            for(TeamMember currentParticipant:participants) {
                System.out.println(currentParticipant+"\n");
            }
        }
    }

    public String toString() {return "";};


}
