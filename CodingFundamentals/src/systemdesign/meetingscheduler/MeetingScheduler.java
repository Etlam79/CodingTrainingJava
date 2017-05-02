package systemdesign.meetingscheduler;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import datastructures.ArrayList;
import datastructures.HashMap;

public class MeetingScheduler {	
	private Date start;
	private Date end;
	private Meeting meeting;
	private TimeSlot[] timeSlots;
	private ArrayList<Person> attendees;
	private long slotInMillis = TimeSlot.SLOT_MINUTES *60*1000;
	
	

	
	public MeetingScheduler(Meeting m, String start, String end) throws ParseException {
		this(m);
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");	
		this.start = dateFormat.parse(start);
		this.end = dateFormat.parse(end);
	}
	
	public MeetingScheduler(Meeting m, Date start, Date end) {
		this(m);
		this.end = end;
		this.start = start;
	}
	
	private MeetingScheduler(Meeting m) {
		this.meeting = m;
		this.attendees  = new ArrayList<Person>();
	}

	public HashMap<Person, String[]> getAvailableSlots() {
		long timeRange = end.getTime()-start.getTime();
		HashMap<Person, String[]> slotsOfAttendees = new HashMap<Person, String[]>(); 
		
		if (timeRange < 0)
			return slotsOfAttendees;
		
		int numberOfSlots = (int) (timeRange / slotInMillis);
				
		for (Person attendee : attendees ) {
			for (Meeting meeting : attendee.getMeetings()) {
				String[] timeSlots = new String[numberOfSlots];
				checkAvailablility(attendee, meeting, timeSlots);
				slotsOfAttendees.put(attendee, timeSlots);
			}
		}
		return slotsOfAttendees;
	}

	private void checkAvailablility(Person attendee, Meeting meeting, String[] slots) {
		int startIndex = -1;
		int endIndex = -1;
	
		long meetingStart = meeting.getStart().getTime();
		long meetingEnd = meeting.getEnd().getTime();
		long slotStart = this.start.getTime();		
		long slotEnd = this.end.getTime();
											
		if (meetingStart < slotEnd ) {		
			startIndex = (int) Math.max(0, (meetingStart-slotStart) / slotInMillis);
		}
		if (meetingEnd > slotStart  ) {
			endIndex = (int) Math.min(slotEnd, (meetingEnd-slotStart) / slotInMillis);
		}
		
		if(startIndex > 0 && endIndex > 0) {
			blockSlots(slots, startIndex, endIndex, meeting.getTitle());
		}
			
		
	}

	private void blockSlots(String[] slots, int startIndex, int endIndex, String title) {
		slots[startIndex]="[" +title;
	
		
			for (int i = startIndex+1; i < endIndex-1; i++) {
					slots[i]="------------";
			}
		
		slots[endIndex-1]="-----------]";
	}
	
	public ArrayList<Person> getAttendees() {
		return attendees;
	}
	
	
	public static void main(String[] args) throws ParseException {	
		Person a = new Person("A");		
		Person b = new Person("B");		
		Person c = new Person("C");		
		Meeting m = new Meeting("Besprechung", "2015-01-23 14:30", "2015-01-23 15:30" );
		m.addAttendee(a);
		m.addAttendee(b);
		
		Meeting m2 = new Meeting("Lunch", "2015-01-23 12:00", "2015-01-23 13:30" );
		m2.addAttendee(c);
		
		Meeting newMeeting = new Meeting("wichtige Besprechung", "2015-01-23 15:00", "2015-01-23 16:00" );
		
		
		MeetingScheduler s = new MeetingScheduler(newMeeting, "2015-01-23 09:00", "2015-01-23 18:00");
		s.inviteAttendee(a);
		s.inviteAttendee(b);
		s.inviteAttendee(c);
		
		HashMap<Person, String[]> slots = s.getAvailableSlots();
		
		
				
		for (Person attendee : s.getAttendees()) {
			System.out.printf("%s: ", attendee.getName());
			
			for (String slot : slots.get(attendee)) {
				System.out.printf("%s", slot!= null ? slot : "____________");
			}
			System.out.println();
			
		}
	}

	public void inviteAttendee(Person b) {
		attendees.add(b);
		
	}

}
