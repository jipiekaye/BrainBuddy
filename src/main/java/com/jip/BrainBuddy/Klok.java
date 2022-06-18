package com.jip.BrainBuddy;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Klok {
    private LocalTime tijd = LocalTime.now();
    private LocalDate Datum = LocalDate.now();
    private DayOfWeek today = LocalDate.now().getDayOfWeek();

    public String getTijd() {
        return tijd.truncatedTo(ChronoUnit.SECONDS).format(DateTimeFormatter.ISO_LOCAL_TIME);
    }
}

