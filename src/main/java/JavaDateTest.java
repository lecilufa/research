
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class JavaDateTest {

	public static void main(String[] args) {
		
		DateTimeFormatter fmt = DateTimeFormat.forPattern("yyyyMM");
		
		DateTime lockMonth = fmt.parseDateTime("201807");
		
		System.out.println(lockMonth);
		
		DateTime d1 = new DateTime("2018-07");
		
		d1 = d1.plusMonths(1).minusDays(1);
		
		System.out.println(d1.toString("yyyy-MM-dd"));
		
		DateTime d2 = new DateTime("2018-06-3");
		
		boolean b = d2.isAfter(d1);
		
		System.out.println(b);
	}

}
