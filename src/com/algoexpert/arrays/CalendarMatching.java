package com.algoexpert.arrays;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CalendarMatching {

	public static void main(String[] args) {
		test1();
		test2();
	}

	public static List<StringMeeting> calendarMatching(List<StringMeeting> calendar1, StringMeeting dailyBounds1,
			List<StringMeeting> calendar2, StringMeeting dailyBounds2, int meetingDuration) {
		List<StringMeeting> available = new ArrayList<>();

		calendar1.add(0, new StringMeeting("00:00", dailyBounds1.start));
		calendar1.add(calendar1.size(), new StringMeeting(dailyBounds1.end, "23:59"));
		calendar2.add(0, new StringMeeting("00:00", dailyBounds2.start));
		calendar2.add(calendar2.size(), new StringMeeting(dailyBounds2.end, "23:59"));

		for (int i = 0; i < calendar1.size(); i++) {
			StringMeeting m1 = calendar1.get(i);
			int j = 0;
			StringMeeting m2 = calendar2.get(j);
			while (compareTime(m1.start, m2.start) > 0) {
				if (++j == calendar2.size())
					break;
				m2 = calendar2.get(j);
			}
			calendar2.add(j, m1);
		}

		int j = 0;
		while (j + 1 < calendar2.size()) {
			StringMeeting m1 = calendar2.get(j);
			StringMeeting m2 = calendar2.get(j + 1);
			if (compareTime(m1.end, m2.start) > 0) {
				if (compareTime(m1.end, m2.end) <= 0)
					m1.end = m2.end;
				calendar2.remove(j + 1);
			} else {
				j++;
			}
		}

		for (int i = 0; i + 1 < calendar2.size(); i++) {
			findAvailableTime(calendar2.get(i).end, calendar2.get(i + 1).start, available, meetingDuration);
		}

		return available;
	}

	private static void findAvailableTime(String time1, String time2, List<StringMeeting> available,
			int meetingDuration) {
		if (checkDifference(time1, time2) >= meetingDuration)
			available.add(new StringMeeting(time1, time2));
	}

	static class StringMeeting {
		public String start;
		public String end;

		public StringMeeting(String start, String end) {
			this.start = start;
			this.end = end;
		}

		@Override
		public String toString() {
			return start + " " + end;
		}
	}

	private static int compareTime(String time1, String time2) {
		String[] t1 = time1.split(":");
		String[] t2 = time2.split(":");
		if (Integer.valueOf(t1[0]) > Integer.valueOf(t2[0])) {
			return 1;
		} else if (Integer.valueOf(t1[0]) < Integer.valueOf(t2[0])) {
			return -1;
		} else {
			if (Integer.valueOf(t1[1]) > Integer.valueOf(t2[1]))
				return 1;
			else if (Integer.valueOf(t1[1]) < Integer.valueOf(t2[1]))
				return -1;
			else
				return 0;
		}
	}

	static SimpleDateFormat format = new SimpleDateFormat("HH:mm");

	private static long checkDifference(String time1, String time2) {
		long diff = 0;
		try {
			Date date1 = format.parse(time1);
			Date date2 = format.parse(time2);
			diff = date2.getTime() - date1.getTime();

		} catch (ParseException e) {
			e.printStackTrace();
		}
		return (diff / 1000) / 60;
	}

	private static void test1() {
		List<StringMeeting> cal1 = new ArrayList<>();
		List<StringMeeting> cal2 = new ArrayList<>();
		String[] m1 = new String[] { "9:00,10:30", "12:00,13:00", "16:00,18:00" };
		String[] m2 = new String[] { "10:00,11:30", "12:30,14:30", "14:30,15:00", "16:00,17:00" };
		for (String s : m1) {
			String[] a = s.split(",");
			cal1.add(new StringMeeting(a[0], a[1]));
		}
		for (String s : m2) {
			String[] a = s.split(",");
			cal2.add(new StringMeeting(a[0], a[1]));
		}
		StringMeeting db1 = new StringMeeting("9:00", "20:00");
		StringMeeting db2 = new StringMeeting("10:00", "18:30");
		System.out.println(calendarMatching(cal1, db1, cal2, db2, 30));
	}

	private static void test2() {
		List<StringMeeting> cal1 = new ArrayList<>();
		List<StringMeeting> cal2 = new ArrayList<>();
		String[] m1 = new String[] { "8:00,10:30", "11:30,13:30", "14:00,16:00", "16:00,18:00" };
		String[] m2 = new String[] { "10:00,11:30", "12:30,14:30", "14:30,15:00", "16:00,17:00" };
		for (String s : m1) {
			String[] a = s.split(",");
			cal1.add(new StringMeeting(a[0], a[1]));
		}
		for (String s : m2) {
			String[] a = s.split(",");
			cal2.add(new StringMeeting(a[0], a[1]));
		}
		StringMeeting db1 = new StringMeeting("8:00", "18:00");
		StringMeeting db2 = new StringMeeting("7:00", "18:30");
		System.out.println(calendarMatching(cal1, db1, cal2, db2, 15));
	}

}
