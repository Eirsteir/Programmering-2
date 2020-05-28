package domain;

import java.time.LocalTime;

public class RushHour {

  private LocalTime start;
  private LocalTime end;

  public RushHour(LocalTime start, LocalTime end) {
    this.start = start;
    this.end = end;
  }

  public LocalTime getStart() {
    return start;
  }

  public LocalTime getEnd() {
    return end;
  }
}
