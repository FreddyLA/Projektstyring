package test_helpers;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

//import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

import dtu.projektstyring.app.DateServer;
import dtu.projektstyring.app.SoftwareHuset;

public class MockDateHolder {
	
	DateServer dateServer = mock(DateServer.class);
	
	public MockDateHolder(SoftwareHuset softwareHouse) {
		GregorianCalendar calendar = new GregorianCalendar();
		setDate(calendar);
		softwareHouse.setDateServer(dateServer);
	}

	public void setDate(Calendar calendar) {
		Calendar c = new GregorianCalendar(calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH));
		when(this.dateServer.getDate()).thenReturn(c);
	}
	
	public void advanceDateByDays(int days) {
		Calendar currentDate = dateServer.getDate();
		Calendar nextDate = new GregorianCalendar();
		nextDate.setTime(currentDate.getTime());
		nextDate.add(Calendar.DAY_OF_YEAR, days);
		setDate(nextDate);
	}
}
