package com.dateandtime;

import java.time.*;
import java.time.format.DateTimeFormatter;

public class ConvertUtil {
    public static void main(String args[]){
        LocalDate localDate = LocalDate.parse("2020-06-01");
        LocalTime localTime = LocalTime.parse("12:23:46");
        LocalDateTime localDateTime = LocalDateTime.parse("2020-06-01T11:20:15");
        ZonedDateTime zonedDateTime = ZonedDateTime.parse("2020-06-01T10:15:30+09:00[Asia/Tokyo]");
        OffsetTime offsetTime = OffsetTime.parse("10:15:30+01:00");

        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        LocalDate localDateFormatted    = LocalDate.parse("01.06.2020", dateFormatter);

        DateTimeFormatter offsetTimeFormatter
                = DateTimeFormatter.ofPattern("HH mm ss XXXXX");
        OffsetTime offsetTimeFormatted
                = OffsetTime.parse("10 15 30 +01:00", offsetTimeFormatter);

    }
}
