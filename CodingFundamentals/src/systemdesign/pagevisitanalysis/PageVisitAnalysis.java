package systemdesign.pagevisitanalysis;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;
import java.util.List;
import java.util.Map.Entry;

public class PageVisitAnalysis {
	
	public static void main(String[] args) {
		PageVisitAnalysis a = new PageVisitAnalysis();
		ArrayList<LogEntry> test = new ArrayList<PageVisitAnalysis.LogEntry>();
		test.add(new LogEntry("A", 10000, "home"));
		test.add(new LogEntry("B", 10000, "about"));
		test.add(new LogEntry("C", 10050, "home"));
		test.add(new LogEntry("A", 10055, "about"));
		test.add(new LogEntry("A", 10056, "contacts"));
		test.add(new LogEntry("C", 10100, "home"));
		test.add(new LogEntry("C", 20000, "contacts"));
		test.add(new LogEntry("B", 100000, "home"));
		
		System.out.println(a.findMostPopularSequence2(test, 2));
		
	}
	
	public String findMostPopularSequence2(List<LogEntry> logList, int windowSize) {
		
		Collections.sort(logList);
		List<List<LogEntry>> sessions = collectSessions(logList);
		String results = "";
		
		Hashtable<String, Integer> windows = new Hashtable<String, Integer>();	
		addWindowsOfTrace(windowSize, sessions, windows);
	
		for (List<LogEntry> session : sessions) {
			
			
			int max = 0;
			String result = "";		
			System.out.println("HT size" + windows.size()); 
			for (Entry<String, Integer> entry : windows.entrySet()){
				if (entry.getValue() > max) {
					max = entry.getValue();
					result += entry.getKey();
				}
			}	
			results += result + "\n";
		}
		return results;	
		
	}
	
	
	private List<List<LogEntry>> collectSessions(List<LogEntry> logList) {
		List<List<LogEntry>> sessions = new ArrayList<List<LogEntry>>();
		
		if (logList.isEmpty())
			return sessions;
		
		String currentUser = "";
		long currentTimestamp = 0;
		List<LogEntry> session = null;
		
		for (LogEntry currentEntry : logList) {		
			if (!currentEntry.user.equals(currentUser) ||
				!(currentEntry.timestamp-10000 <= currentTimestamp)) {
				session = new ArrayList<LogEntry>();
				sessions.add(session);
				currentUser= currentEntry.user;
				currentTimestamp = currentEntry.timestamp;
			}
			session.add(currentEntry);
		}
		return sessions;
		
		
	}


	static public class LogEntry implements Comparable<LogEntry> {
		String user;
		long timestamp;
		String url;
		LogEntry(String user, long timestamp, String url) {
			this.user = user;
			this.timestamp = timestamp;
			this.url = url;
		}
		@Override
		public int compareTo(LogEntry o) {
			if (user.compareTo(o.user) == 0) {
				if (timestamp == o.timestamp) return 0;
				if (timestamp < o.timestamp) return -1;
				return 1;
			}
			return user.compareTo(o.user);
		}
	
		@Override
		public String toString() {
			return String.format("(%s,%s,%s)", user, timestamp, url);
		}
	}
	
	
	public String findMostPopularSequence(List<String> logList, int windowSize) {
		Hashtable<String, Integer> windows = new Hashtable<String, Integer>();		
		logList.forEach(trace->addWindowsOfTrace(windowSize, trace, windows));
	
		int max = 0;
		String result = "";		
		System.out.println("HT size" + windows.size()); 
		for (Entry<String, Integer> entry : windows.entrySet()){
			if (entry.getValue() > max) {
				max = entry.getValue();
				result = entry.getKey();
			}
		}	
		return result;	
	}

	private void addWindowsOfTrace(int windowSize, String trace, Hashtable<String, Integer> windows) {		
		String[] traceTokens = trace.split(",");
		for (int i = 0; i < traceTokens.length-windowSize; i++) {
			String window = getWindowAsString(traceTokens, i, windowSize);		
			int counter = 1;
			if (windows.containsKey(window))
				counter += windows.get(window);
			windows.put(window, counter);							
		}	
	}

	private void addWindowsOfTrace(int windowSize, List<List<LogEntry>> trace, Hashtable<String, Integer> windows) {		
		for (List<LogEntry> list : trace) {
			
		
		for (int i = 0; i < list.size()-windowSize; i++) {
			String window = getWindowAsString(list, i, windowSize);		
			int counter = 1;
			if (windows.containsKey(window))
				counter += windows.get(window);
			windows.put(window, counter);							
		}	
		}
	}
	private String getWindowAsString(List<LogEntry> tokens, int i, int windowSize) {
		StringBuffer b = new StringBuffer();
		 
		for (int j = i; j < i+windowSize; j++) 
			b.append(tokens.get(j).url + " ");
		
		return b.toString().trim();
	}
	
	
	private String getWindowAsString(String[] tokens, int i, int windowSize) {
		StringBuffer b = new StringBuffer();
		 
		for (int j = i; j < i+windowSize; j++) 
			b.append(tokens[j] + " ");
		
		return b.toString().trim();
	}

}
