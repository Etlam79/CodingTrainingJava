package systemdesign.meetingscheduler;

public class TimeSlot {
	public static final int SLOT_MINUTES = 15;
	private String name;
	private boolean blocked;

	public TimeSlot(String name) {
		this.name = name;
	}
	
	
	public String getName() {
		return name;
	}


	public void setBlocked() {
		this.blocked = true;
		
	}
	
	public boolean isBlocked() {
		return this.blocked;
	}
}
