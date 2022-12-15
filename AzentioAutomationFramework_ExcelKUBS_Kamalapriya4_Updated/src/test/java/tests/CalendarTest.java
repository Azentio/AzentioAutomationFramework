package tests;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.util.Calendar;
import java.util.Date;

public class CalendarTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LocalDate localdate = LocalDate.of(2000, 12, 31);
		//localdate.minusDays(1);
		//localdate.plusDays(1);
		
		System.out.println(localdate.minusDays(1));
		System.out.println(localdate.plusDays(1));
		
		/*String curDate="2022/11/20";
		String nextDate = "";
	        try {
	            Calendar today = Calendar.getInstance();
	            DateFormat format = new SimpleDateFormat("yyyy/MM/dd");
	            Date date = format.parse(curDate);
	            today.setTime(date);
	            today.add(Calendar.DAY_OF_YEAR, 1);
	            nextDate = format.format(today.getTime());
	        } catch (Exception e) {
	        //  System.out.println(nextDate);
	        }
	        System.out.println(nextDate);
	 
*/
	}

}
