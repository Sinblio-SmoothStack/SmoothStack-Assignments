package Day_5_Tests;

import Day_5.Date_Time_API.DateTimeAPI;
import org.junit.jupiter.api.Test;

import java.time.Year;
import java.time.YearMonth;

public class DateTimeAPITest {

    @Test
    public void testPrintYearInfo() {
        DateTimeAPI.printYearInfo(Year.now());
    }

    @Test
    public void testPrintMondays() {
        DateTimeAPI.printMondays(YearMonth.now());
    }
}
