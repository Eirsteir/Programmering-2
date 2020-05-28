package util;

import domain.RushHour;

import java.time.LocalTime;


/**
 * Util class for calculating if now is within rush hours.
 */
public class RushHourUtil {

  private static RushHour morningRushHours;
  private static RushHour afternoonRushHours;

  static {
    morningRushHours = new RushHour(LocalTime.of(6, 30), LocalTime.of(8, 59));
    afternoonRushHours = new RushHour(LocalTime.of(14, 30), LocalTime.of(16, 29));
  }

  public static boolean getIsRushHour() {
    LocalTime now = LocalTime.now();
    return isMorningRushHour(now) || isAfternoonRushHour(now);
  }

  private static boolean isMorningRushHour(LocalTime now) {
    return (!now.isBefore(morningRushHours.getStart())) && now.isBefore(morningRushHours.getEnd());
  }

  private static boolean isAfternoonRushHour(LocalTime now) {
    return (!now.isBefore(afternoonRushHours.getStart())) && now.isBefore(afternoonRushHours.getEnd());
  }
}
