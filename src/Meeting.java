import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

public class Meeting {
    private String meetingId = UUID.randomUUID().toString();
    private Date meetingDate;
    private String meetingAbout;
    static ArrayList<Meeting> meetingList = new ArrayList<>();

    public Meeting(String meetingId,Date meetingDate, String meetingAbout) {
        this.meetingId = meetingId;
        this.meetingDate = meetingDate;
        this.meetingAbout = meetingAbout;
    }

    public String getMeetingId() {
        return meetingId;
    }

    public void setMeetingId(String meetingId) {
        this.meetingId = meetingId;
    }

    public Date getMeetingDate() {
        return meetingDate;
    }

    public void setMeetingDate(Date meetingDate) {
        this.meetingDate = meetingDate;
    }

    public String getMeetingAbout() {
        return meetingAbout;
    }

    public void setMeetingAbout(String meetingAbout) {
        this.meetingAbout = meetingAbout;
    }
    public static void registerMeeting(Meeting meeting) {
        meetingList.add(meeting);
        System.out.println(meeting);
    }

    @Override
    public String toString() {
        return "Meeting id='" + meetingId + '\'' +
                ", Meeting date=" + meetingDate +
                ", The meeting About='" + meetingAbout + '\'' +
                '}';
    }
}

