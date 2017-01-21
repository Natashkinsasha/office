package by.natashkinsasha.util;


import java.time.*;

public class TimeUtil {


    public static Integer toSecond(LocalTime localTime){
        return localTime.getSecond();
    }


    public static LocalTime toLocalTime(Long second){
        return LocalTime.ofSecondOfDay(second);
    }

    public static LocalDateTime toLocalDateTime(Long unixTime){
        return toLocalDateTime(unixTime, ZoneId.systemDefault());
    }

    public static LocalDateTime toLocalDateTime(Long unixTime, ZoneId zoneId){
        return LocalDateTime.ofInstant(Instant.ofEpochSecond(unixTime), zoneId);
    }


    public static LocalDate toLocalDate(Long unixTime, ZoneId zoneId){
        return Instant.ofEpochSecond(unixTime).atZone(zoneId).toLocalDate();
    }

    public static LocalDate toLocalDate(Long unixTime){
        return toLocalDate(unixTime, ZoneId.systemDefault());
    }

    public static Long toUnixTime(Instant instant){
        return instant.getEpochSecond();
    }


    public static Long toUnixTime(LocalDate localDate, ZoneOffset zoneOffset){
        return toUnixTime(localDate.atStartOfDay().toInstant(zoneOffset));
    }

    public static Long toUnixTime(LocalDate localDate){
        return toUnixTime(localDate, ZoneOffset.UTC);
    }




}
