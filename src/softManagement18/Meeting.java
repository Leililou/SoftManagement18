package softManagement18;
//import java.sql.Time;
import java.util.Date;


public class Meeting extends Schedule{
	
	
// look for how to store time (H,m)
	// date(int year, int month, int date)
	public Meeting(String meetingTitle, String description,Date startTime,Date endTime) {
		super(meetingTitle,description,startTime,endTime);
		
	}
	
	@Override
	public String toString() {
		return "> Meeting of ID="+this.getID()+"\nAbout:"+this.getDescription()+""
				+ "\nstarts:"+this.getStartTime()+""
				+ "\nEnds :"+this.getEndTime();
	}

}