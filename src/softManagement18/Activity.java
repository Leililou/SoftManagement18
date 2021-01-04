package softManagement18;
// test
import java.util.Date;

class Activity extends Schedule{

	// private String title;

	public Activity(String activityTitle, Date meetingDate, String description,int startTime,int endTime) {
		super(activityTitle, meetingDate, description,startTime,endTime);
		// this.title=title;

	}

	/*String getTitle() {
        return title;
    }

    void setTitle(String title) {
        this.title = title;
    }
	 */
	@Override
	public String toString() {
		return "\n> Activity of ID="+this.getID()+"\nTitle:"+this.getMeetingTitle()+"\nDesciption:"+this.getDescription()+""
				+ "\nPlanned on:"+this.getDate()+"\nStarts at:"+this.getStartTime()+""
				+ "\nEnds at:"+this.getEndTime();
	}

}
