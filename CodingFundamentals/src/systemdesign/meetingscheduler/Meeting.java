package systemdesign.meetingscheduler;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import datastructures.ArrayList;

public class Meeting {
	private String title;
	private String location;
	private Date start;
	private Date end;
	private ArrayList<Person> attendees;
	
	private Meeting(String title) {
		this.title = title;
		this.attendees = new ArrayList<Person>();
		this.location = "N/A";
	}
	
	public Meeting(String title,Date start, Date end) {
		this(title);
		this.start = start;
		this.end = end;
		
	}
	
	public Meeting(String title, String start, String end) throws ParseException {
		this(title);
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");	
		this.start =  dateFormat.parse(start);
		this.end = dateFormat.parse(end);
		
		
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public void addAttendee(Person toBeAdded) {
		attendees.add(toBeAdded);
		toBeAdded.addMeeting(this);
	}
	
	public String getTitle() {
		return title;
	}
	
	public Date getStart() {
		return start;
	}
	
	public Date getEnd() {
		return end;
	}
	
	public ArrayList<Person> getAttendees() {
		return attendees;
	}
}
