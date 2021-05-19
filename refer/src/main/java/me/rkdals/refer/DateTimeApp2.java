package me.rkdals.refer;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class DateTimeApp2 {
    public static void main(String[] args) {
        Instant instant = Instant.now();
        System.out.println(instant);  // 기준시 UTC, GMT
        System.out.println(instant.atZone(ZoneId.of("UTC")));  // 기준시 UTC, GMT

        ZonedDateTime zonedDateTime = instant.atZone(ZoneId.systemDefault());
        System.out.println(zonedDateTime);

        System.out.println("=====================================================");

        LocalDateTime now = LocalDateTime.now();  // 내 local에 맞게 설정 -> 만약 서버를 다른 지역에 올리면 다른 시간이 뜰거임
        System.out.println(now);

        ZonedDateTime nowInKorea = ZonedDateTime.now(ZoneId.of("Asia/Seoul"));
        System.out.println(nowInKorea);

        System.out.println("=====================================================");

        Instant nowInstant = Instant.now();
        ZonedDateTime zonedDateTime1 = nowInstant.atZone(ZoneId.of("Asia/Seoul"));
        System.out.println(zonedDateTime1);

        LocalDate today = LocalDate.now();
        LocalDate thisYearBirthday = LocalDate.of(2021, Month.OCTOBER, 26);  // 특정 일시를 리턴
        Period period = Period.between(today, thisYearBirthday);
        System.out.println(period.getDays());

        Period until = today.until(thisYearBirthday);
        System.out.println(until.get(ChronoUnit.DAYS));

        System.out.println("=====================================================");

        Instant now1 = Instant.now();
        Instant plus = now1.plus(10, ChronoUnit.SECONDS);
        Duration between1 = Duration.between(now1, plus);
        System.out.println(between1.getSeconds());

        System.out.println("=====================================================");

        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter MMddyyyy = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        System.out.println(dateTime.format(MMddyyyy));

        LocalDate parse = LocalDate.parse("10/26/1992", MMddyyyy);
        System.out.println(parse);

        System.out.println("=====================================================");

        Date date = new Date();
        Instant instant1 = date.toInstant();
        System.out.println(instant1);
        Date newDate = Date.from(instant);
        System.out.println(newDate);

        System.out.println("=====================================================");

        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        ZonedDateTime dateTime1 = gregorianCalendar.toInstant().atZone(ZoneId.systemDefault());
        System.out.println(dateTime1);
        GregorianCalendar from = GregorianCalendar.from(dateTime1);
        System.out.println(from.getTimeZone().getDisplayName());

        ZoneId zoneId = TimeZone.getTimeZone("PST").toZoneId();
        TimeZone timeZone = TimeZone.getTimeZone(zoneId);
        System.out.println(timeZone.getDisplayName());

    }
}
