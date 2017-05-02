import java.text.DateFormat;
import java.text.ParseException;
import java.util.Arrays;
import java.util.Date;


public class TimeIntervals {
	static Date[] sorted ;
	
	
	
             
	
	
	
	
	public static void main(String[] args) throws ParseException {
	
		
		 DateFormat df = DateFormat.getDateInstance();
		 
		 Date[][] dateIntervals = {
				 {df.parse("03.02.2014"), df.parse("20.02.2014")},
				 {df.parse("06.02.2014"), df.parse("05.03.2014")}};
		 
		  
				
				
		sorted= new Date[dateIntervals.length*2];
	
		
		for (int i = 0; i < dateIntervals.length; i++) {
			Date start = dateIntervals[i][0];
			Date end = dateIntervals[i][1];
			sorted[i] = start;
			sorted[i+1] = end;
		}
		
		System.out.println(Arrays.asList(sorted));
		 
		
	}

	private static void add(Date node) {
		
		sorted[getPos(node,  sorted.length/2)] = node;
		
	}

	private static int getPos(Date node, int pos) {
		if(sorted[pos] == null)
			return pos;
		if(sorted[pos].compareTo(node) > 0)
			return getPos(node, pos+ sorted.length-pos/2);
		if(sorted[pos].compareTo(node) < 0)
			return getPos(node, sorted.length-pos/2);
		return -1;
	}
	
	
	
	
	 
}
