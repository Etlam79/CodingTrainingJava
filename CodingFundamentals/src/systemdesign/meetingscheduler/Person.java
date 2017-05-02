package systemdesign.meetingscheduler;

import datastructures.ArrayList;

public class Person {
	private String name;
	private ArrayList<Meeting> meetings;
	
	public Person(String name) {
		this.name = name;
		meetings = new ArrayList<Meeting>();
	}
	
	public ArrayList<Meeting> getMeetings() {
		return meetings;
	}
	
	public String getName() {
		return name;
	}

	public void addMeeting(Meeting meeting) {
		meetings.add(meeting);
		
	}
}
