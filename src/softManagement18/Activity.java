package softManagement18;
// test
import java.util.Date;

class Activity extends Schedule{

	private String type;

	public Activity(String activityTitle, String description,Date startTime,Date endTime, String type) {
		super(activityTitle, description,startTime,endTime);
		this.type=type;

	}

	String getType() {
        return type;
    }

    void setType(String type) {
        this.type = type;
    }
    
	@Override
	public String toString() {
		return "\n> Activity: "+this.getType()+" of ID="+this.getID()+"\nTitle:"+this.getMeetingTitle()+"\nDesciption:"+this.getDescription()+""
				+ "\nStarts: "+this.getStartTime()+""
				+ "\nEnds  :"+this.getEndTime();
	}

}
