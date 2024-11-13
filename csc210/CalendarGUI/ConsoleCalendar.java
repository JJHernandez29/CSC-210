package csc210.CalendarGUI;

import java.util.Scanner;

public class ConsoleCalendar {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		System.out.print("year past 1900: ");
		int targetyear = kb.nextInt();
		System.out.print("month: ");
		String targetmonth = kb.next();
		System.out.print("date: ");
		int targetday = kb.nextInt();
		
		Calendar cal = new Calendar();
		try {
			System.out.println(targetyear + ", " + targetmonth + ", " + targetday +
					" is a " + cal.getDay(targetyear, targetmonth, targetday));
		}
		catch (IllegalArgumentException e) {
			
		}

	}

}
