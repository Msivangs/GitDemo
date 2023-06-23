package utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateGenerators {

	static SimpleDateFormat UIDateFormat = new SimpleDateFormat("MM/dd/yyyy");
	static Date date;

	public static String getCurrentSystemDate() {

		try {
			date = new Date();
		} catch (Exception e) {
			e.printStackTrace();

		}
		System.out.println("Current system Date: " + UIDateFormat.format(date));
		return UIDateFormat.format(date);
	}

	public static Date getTodayDate() {
		date = new Date();
		return date;
	}

	public static String getFutureSystemDate(int n) {
		Calendar cal = null;
		;
		try {
			date = new Date();
			cal = Calendar.getInstance();
			cal.setTime(date);
			cal.add(Calendar.DATE, n);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Future Date: " + UIDateFormat.format(cal.getTime()));
		return UIDateFormat.format(cal.getTime());
	}

	public static Date getDateInDateFormat(String strDate) {
		// TODO Auto-generated method stub
		try {
			date = UIDateFormat.parse(strDate);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return date;
	}

}
