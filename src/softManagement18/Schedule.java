package softManagement18;

//import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

abstract class Schedule {


    ArrayList<TeamMember> participants=new ArrayList<TeamMember>();
    private String ID;
    private String description;
    private Date startTime;
    private Date endTime;
    private String meetingTitle;


    // date(int year, int month, int date)
    //public Schedule(String meetingId,Date meetingDate, String description,Time startTime,Time endTime)
    public Schedule(String meetingTitle, String description,Date startTime,Date endTime) {
        UUID uuid = UUID.randomUUID();
        this.ID = uuid.toString();
        this.ID = ID.substring(0, Math.min(ID.length(), 3));

        this.setMeetingTitle(meetingTitle);
        this.description = description;
        this.startTime=startTime;
        this.endTime=endTime;
        this.participants=new ArrayList<TeamMember>();
    }

    ArrayList<TeamMember> getParticipants() {
        return participants;
    }

    public Date getStartTime() {
        return startTime;
    }


    public Date getEndTime() {
        return endTime;
    }


    public String getID() {
        return ID;
    }


    public String getMeetingTitle() {
		return meetingTitle;
	}

	public void setMeetingTitle(String meetingTitle) {
		this.meetingTitle = meetingTitle;
	}


    public String getDescription() {
        return description;
    }


    public void setDescription(String description) {
        this.description = description;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }


    public void setEndTime(Date endTime) {
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
