package test_helpers;

import java.util.Calendar;
import java.util.Date;

public class DateHelper {
	private Date date;
	
	public Date getDate() {
		if (date == null) {
			date = exampleDate();
		}
		return date;
	}
	
	private Date exampleDate() {
		Date date = Calendar.getInstance().getTime();
		return date;
	}
}
