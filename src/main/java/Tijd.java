import java.time.DayOfWeek;
import java.time.LocalTime;
import java.time.LocalDate;

public class Tijd {
    private static LocalTime Tijd = LocalTime.now();
    private static LocalDate Datum = LocalDate.now();
    private static DayOfWeek today = LocalDate.now().getDayOfWeek();

    public static LocalDate getDatum() {
        return Datum;
    }

    public static LocalTime getTijd() {
        return Tijd;
    }

    public static DayOfWeek getToday() {
        return today;
    }
}

