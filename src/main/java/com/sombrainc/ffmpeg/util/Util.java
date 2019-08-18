package com.sombrainc.ffmpeg.util;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Util {

  public static final String DEFAULT_TIME_PATTERN = "HH:mm:ss.SSS";

  public static long millisFromTime(String time) {
    LocalTime localDateTime;
    try {
      localDateTime = LocalTime.parse(time, DateTimeFormatter.ofPattern(DEFAULT_TIME_PATTERN));
    } catch (DateTimeParseException e) {
      throw new DateTimeParseException(String.format("Please follow next time format pattern: %s", DEFAULT_TIME_PATTERN),
        DEFAULT_TIME_PATTERN, 0, e);
    }
    return localDateTime.toSecondOfDay() * 1000;
  }
}
