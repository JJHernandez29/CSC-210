package csc210.CalendarGUI;


public class Calendar {
	
	
	public enum MONTH {JANUARY, FEBRUARY, MARCH, APRIL, MAY, 
			JUNE, JULY, AUGUST, SEPTEMBER, OCTOBER, NOVEMBER, DECEMBER}
	
	public enum DAYS {SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY}
	
	// member variables
	private int[] monthdays = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	
	private String[] days = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday",
							 "Friday", "Saturday"};

	// constructors
	public Calendar () {
		
	}
	


	private int monthtoint(String month) throws IllegalArgumentException {
		String lowermonth = month.toLowerCase();
		
		switch (lowermonth) {
			case "january": return 0;
			case "february": return 1;
			case "march": return 2;
			case "april": return 3;
			case "may": return 4;
			case "june": return 5;
			case "july": return 6;
			case "august": return 7;
			case "september": return 8;
			case "october": return 9;
			case "november": return 10;
			case "december": return 11;
			default: throw new IllegalArgumentException(month + " is not a month");
		}
	}

	private MONTH stringtomonth(String month) throws IllegalArgumentException {
		String lowermonth = month.toLowerCase();
		
		switch (lowermonth) {
			case "january": return MONTH.JANUARY;
			case "february": return MONTH.FEBRUARY;
			case "march": return MONTH.MARCH;
			case "april": return MONTH.APRIL;
			case "may": return MONTH.MAY;
			case "june": return MONTH.JUNE;
			case "july": return MONTH.JULY;
			case "august": return MONTH.AUGUST;
			case "september": return MONTH.SEPTEMBER;
			case "october": return MONTH.OCTOBER;
			case "november": return MONTH.NOVEMBER;
			case "december": return MONTH.DECEMBER;
			default: throw new IllegalArgumentException(month + " is not a month");
		}
	}
	
	// member functions
	public boolean isLeapYear(int year)
	{
		if (year % 4 == 0 && year % 100 != 0) return true;
		else if (year % 400 == 0) return true;
		else return false;
	}

	public String getDay(int targetyear, String targetmonth, int targetday) throws IllegalArgumentException {
		// -- check if targetmonth is valid
		// -- check if target year is valid
		// -- check if target day is valid
		
		// -- count number of leap years from 1900
		int leapyears = 0;
		for (int year = 1900; year < targetyear; ++year) {
			if (this.isLeapYear(year)) {
				++leapyears;
			}
		}
//		System.out.println(leapyears + " leap years since 1900");
		
		// -- count number of years since baseline year
		int years = targetyear - 1900;
//		System.out.println(years + " since 1900");
		
		// -- convert number of years to number of days since baseline year
		int days = years * 365 + leapyears;
		
		// -- count number of days in target year
		for (int i = this.monthtoint("January"); i < this.monthtoint(targetmonth); ++i) {
			days += this.monthdays[i];
		}

		// -- add 1 if target year is a leap year and month is after February
		if (this.isLeapYear(targetyear) && this.monthtoint(targetmonth) > this.monthtoint("february")) {
			++days;
		}
		
		// -- add in number of days in target month
		days += targetday - 1;		
//		System.out.println(days + " since January 1, 1900");
		
		// -- modulo 7 since there are 7 days in a week
		days = days % 7; 

		// -- print final result
//		System.out.println(days + " since Monday");
//		System.out.println(cal.days[(days + 1) % 7]);
		return this.days[(days + 1) % 7];
		
	}

}
