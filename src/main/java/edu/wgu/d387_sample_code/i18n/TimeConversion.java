package edu.wgu.d387_sample_code.i18n;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;


@Component
public class TimeConversion {

    public ArrayList<String> getTimeConversion() {
        ArrayList<String> timeZoned = new ArrayList<>();
        ZoneId zEastern = ZoneId.of("America/New_York");
        ZoneId zMountain = ZoneId.of("America/Denver");
        ZoneId zUniversal = ZoneId.of("UTC");
        ZoneId zoneId = ZoneId.systemDefault();

        LocalDateTime presentationTime = LocalDateTime.of(2024, 2, 10, 17, 00);
        ZonedDateTime zonedPresentationTime = presentationTime.atZone(zoneId);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm z");

        ZonedDateTime zonedDateTimeEastern = zonedPresentationTime.withZoneSameInstant(zEastern);
        String eastern = zonedDateTimeEastern.format(formatter);
        timeZoned.add(eastern);

        ZonedDateTime zonedDateTimeMountain = zonedPresentationTime.withZoneSameInstant(zMountain);
        String mountain = zonedDateTimeMountain.format(formatter);
        timeZoned.add(mountain);

        ZonedDateTime zonedDateTimeUniversal = zonedPresentationTime.withZoneSameInstant(zUniversal);
        String universal = zonedDateTimeUniversal.format(formatter);
        timeZoned.add(universal);

        return timeZoned;
    }
}
