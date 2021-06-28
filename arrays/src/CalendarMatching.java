import java.util.ArrayList;
import java.util.List;

class CalendarMatching {
    public static List<StringMeeting> calendarMatching(
            List<StringMeeting> calendar1,
            StringMeeting dailyBounds1,
            List<StringMeeting> calendar2,
            StringMeeting dailyBounds2,
            int meetingDuration) {
        List<Meeting> updateCalendar1 = alterCalendar(calendar1, dailyBounds1);
        List<Meeting> updateCalendar2 = alterCalendar(calendar2, dailyBounds2);

        return new ArrayList<StringMeeting>();
    }

    public static int timeToMinutes(String time) {
        int delimPositon = time.indexOf(":");
        int hours = Integer.parseInt(time.substring(0, delimPositon));
        int mins = Integer.parseInt(time.substring(delimPositon + 1));
        return hours * 60 + mins;
    }

    public static List<Meeting> alterCalendar(List<StringMeeting> calendar, StringMeeting dailyBounds) {
        List<StringMeeting> updateCalendar = new ArrayList<>();
        updateCalendar.add(new StringMeeting("0:00", dailyBounds.start));
        updateCalendar.add(new StringMeeting(dailyBounds.end, "23:59"));
        updateCalendar.addAll(calendar);
        List<Meeting> calendarInMinutes = new ArrayList<>();
        updateCalendar.forEach(c ->
                calendarInMinutes.add(
                        new Meeting(
                                timeToMinutes(c.start),
                                timeToMinutes(c.end)
                        )
                )
        );
        return calendarInMinutes;
    }

    static class StringMeeting {
        public String start;
        public String end;

        public StringMeeting(String start, String end) {
            this.start = start;
            this.end = end;
        }
    }

    static class Meeting {
        public int start;
        public int end;

        public Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}