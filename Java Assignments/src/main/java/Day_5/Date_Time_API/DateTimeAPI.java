package Day_5.Date_Time_API;

import java.time.*;
import java.time.chrono.ChronoLocalDate;

public class DateTimeAPI {

    public static LocalDate lastThursday(LocalDate date) {
        LocalDate out = date;

        if(date != null)
            while (out.getDayOfWeek() != DayOfWeek.THURSDAY)
                out.minusDays(1);

        return out;
    }

    public static ZonedDateTime instantToZonedDateTime(Instant instant, ZoneId zone) {
        return instant.atZone(zone);
    }

    public static Instant zonedDateTimeToInstant(ZonedDateTime zonedDateTime) {
        return zonedDateTime.toInstant();
    }

    public static void printYearInfo(Year year) {
        for (int i = 1; i <= 12; i++)
            System.out.printf("%s: There are %s days.\n", year.atMonth(i), year.atMonth(i).lengthOfMonth());
    }

    public static void printMondays(YearMonth yearMonth) {
        LocalDate current = yearMonth.atDay(1);

        System.out.printf("Printing Mondays in %s, %s\n", yearMonth.getMonth(), yearMonth.getYear());

        while (current.getDayOfWeek() != DayOfWeek.MONDAY) {
            current = current.plusDays(1);
        }

        while (current.getMonth() == yearMonth.getMonth()) {
            System.out.println(current);
            current = current.plusWeeks(1);
        }
    }

    public static boolean fridayTheThirteenth(LocalDate date) {
        if (date != null && date.getDayOfWeek().equals(DayOfWeek.FRIDAY) && date.getDayOfMonth() == 13)
            return true;
        return false;
    }


}
