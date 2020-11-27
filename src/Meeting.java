package softManagement18;
//import java.sql.Time;
import java.util.Date;


public class Meeting extends Schedule{
	
	
// look for how to store time (H,m)
	// date(int year, int month, int date)
	public Meeting(String meetingId,Date meetingDate, String description,int startTime,int endTime) {
		super(meetingId,meetingDate, description,startTime,endTime);
		
	}
	
	@Override
	public String toString() {
		return "> Meeting of ID="+this.getID()+"\nAbout:"+this.getDescription()+""
				+ "\nPlanned on:"+this.getDate()+"\nstarts at:"+this.getStartTime()+""
				+ "\nEnds at:"+this.getEndTime();
	}

}