package com.dateandtime;

import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class ConvertUtil {
    public static void main(String args[]){

        // Convert String to diffrent type of Date in java
        LocalDate localDate = LocalDate.parse("2020-06-01");
        LocalTime localTime = LocalTime.parse("12:23:46");
        LocalDateTime localDateTime = LocalDateTime.parse("2020-06-01T11:20:15");
        ZonedDateTime zonedDateTime = ZonedDateTime.parse("2020-06-01T10:15:30+09:00[Asia/Tokyo]");
        OffsetTime offsetTime = OffsetTime.parse("10:15:30+01:00");

        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        LocalDate localDateFormatted    = LocalDate.parse("01.06.2020", dateFormatter);

        DateTimeFormatter offsetTimeFormatter = DateTimeFormatter.ofPattern("HH mm ss XXXXX");
        OffsetTime offsetTimeFormatted  = OffsetTime.parse("10 15 30 +01:00", offsetTimeFormatter);


        DateTimeFormatter zonedDateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy, HH:mm:ssXXXXX '['VV']'");
        ZonedDateTime zonedDateTimeFormatted  = ZonedDateTime.parse("01.06.2020, 11:20:15+09:00 [Asia/Tokyo]", zonedDateTimeFormatter);

        // Convert diffrent type of Date in java To String format
        // 2020-06-01 results in ISO_LOCAL_DATE, 2020-06-01
        String localDateAsString = localDate.toString();

        // 01.06.2020 results in ISO_LOCAL_DATE, 2020-06-01
        String localDateAsString2 = localDateFormatted.toString();

        // 2020-06-01T10:15:30+09:00[Asia/Tokyo]
        // results in ISO_ZONED_DATE_TIME,
        // 2020-06-01T11:20:15+09:00[Asia/Tokyo]
        String zonedDateTimeAsString = zonedDateTime.toString();

        // 01.06.2020
        String localDateAsFormattedString = dateFormatter.format(localDateFormatted);


        DateTimeFormatter zonedDateTimeFormatter2 = DateTimeFormatter.ofPattern("dd.MM.yyyy, HH:mm:ssXXXXX '['VV']'").withZone(ZoneId.of("Europe/Paris"));

        // yyyy-MM-dd
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String stringDate = formatter.format(date);

        // or shortly
        String stringLD = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        // or shortly
        String stringLT = LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));

        String stringZDT = ZonedDateTime.now() .format(DateTimeFormatter.ofPattern("E MMM yyyy HH:mm:ss.SSSZ"));

        // 2019-02-24
        LocalDate onlyDate = LocalDate.now();
        //12:53:28.812637300
        LocalTime onlyTime = LocalTime.now();

        LocalDateTime ldt = LocalDateTime.of (2020, 4, 1, 12, 33, 21, 675);

        // 2019-02-24T15:05:21.781049600Z
        Instant timestamp = Instant.now();
        Clock clock = Clock.systemUTC();

        // 2019-02-24T14:31:33.197021300Z   Converting String to instant
        Instant timestampFromString = Instant.parse("2019-02-24T14:31:33.197021300Z");

        Instant twoHourLater = Instant.now().plus(2, ChronoUnit.HOURS);

        Instant tenMinutesEarlier = Instant.now().minus(10, ChronoUnit.MINUTES);

        //Comparing Instant objects
        Instant timestamp1 = Instant.now();
        Instant timestamp2 = timestamp1.plusSeconds(10);
        boolean isAfter = timestamp1.isAfter(timestamp2); // false
        boolean isBefore = timestamp1.isBefore(timestamp2); // true
        // 10 seconds
        long difference = timestamp1.until(timestamp2, ChronoUnit.SECONDS);

        //Convert between Instant and LocalDateTime
        // 2019-02-24T15:27:13.990103700
        LocalDateTime ldt2 = LocalDateTime.ofInstant(Instant.now(), ZoneOffset.UTC);

        // 2019-02-24T17:27:14.013105Z
        Instant instantLDT = LocalDateTime.now().toInstant(ZoneOffset.UTC);

        //Convert between Instant and ZonedDateTime
        // 2019-02-24T16:34:36.138393100+01:00[Europe/Paris]
        ZonedDateTime zdt = Instant.now().atZone(ZoneId.of("Europe/Paris"));

        //Convert between Instant and OffsetDateTime
        // 2019-02-24T17:34:36.151393900+02:00
        OffsetDateTime odt = Instant.now().atOffset(ZoneOffset.of("+02:00"));
        // 2019-02-24T15:34:36.153394Z
        Instant instantODT = LocalDateTime.now().atOffset(ZoneOffset.of("+02:00")).toInstant();

        //Period of time using date-based values
        Period fromDays = Period.ofDays(120); // P120D
        Period periodFromUnits = Period.of(2000, 11, 24); // P2000Y11M24D
        LocalDate localDate3 = LocalDate.now();
        Period periodFromLocalDate = Period.of(localDate.getYear(),
                localDate.getMonthValue(), localDate.getDayOfMonth());

        //For example, the P2019Y2M25D string represents  2019 years, 2 months, and 25 days:
        Period periodFromString = Period.parse("P2019Y2M25D");

        // the real power of Period is revealed when it is used to represent a period of time
        //between two dates

        LocalDate startLocalDate = LocalDate.of(2018, 3, 12);
        LocalDate endLocalDate = LocalDate.of(2019, 7, 20);
        Period periodBetween = Period.between(startLocalDate, endLocalDate);

        //the duration of time between 04:14:20.000000670 and 06:10:10.000000720
        LocalTime startLocalTime = LocalTime.of(4, 14, 20, 670);
        LocalTime endLocalTime = LocalTime.of(6, 10, 10, 720);
        // PT1H55M50.00000005S, or 6950 seconds
        Duration durationBetweenLT = Duration.between(startLocalTime, endLocalTime);

        //Getting date and time units
        int year = ldt.getYear();
        int month = ldt.getMonthValue();
        int day = ldt.getDayOfMonth();
        int hour = ldt.getHour();
        int minute = ldt.getMinute();
        int second = ldt.getSecond();
        int nano = ldt.getNano();

        //Getting all time zones with UTC and GMT
        Set<String> zoneIds = ZoneId.getAvailableZoneIds();

        //At the second step, each time zone ID should be used to create a ZoneId instance.
        //This can be accomplished via the ZoneId.of(String zoneId) method
       // ZoneId zoneid = ZoneId.of(current_zone_Id);


        String utcffset = zdt.getOffset().getId().replace("Z", "+00:00");

        List<String> timezones
                = ConvertUtil.fetchTimeZones("OffsetType");
        Collections.sort(timezones); // optional sort
        timezones.forEach(System.out::println);
    }

    public static List<String> fetchTimeZones(String type) {
        List<String> timezones = new ArrayList<>();
        Set<String> zoneIds = ZoneId.getAvailableZoneIds();
        LocalDateTime now = LocalDateTime.now();
        zoneIds.forEach((zoneId) -> {
            timezones.add("(" + type + now.atZone(ZoneId.of(zoneId))
                    .getOffset().getId().replace("Z", "+00:00") + ") " + zoneId);
        });
        return timezones;
    }
}
