package domain;

import domain.v2.Vehicle;
import util.RushHourUtil;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;


/**
 * Class TollPassage.
 * The date and time for the passage is based on what time
 * it is when the class is initialized.
 */
public class TollPassage {

  private Integer tollPlazaId;
  private String licensePlateNumber;
  private Integer passageCost;
  private LocalTime passageTime;
  private LocalDate passageDateTime;

  /**
   * Create a toll passage instance.
   *
   * @param tollPlazaId Long, the id of the related toll plaza
   * @param vehiclePassed Vehicle, the vehicle that passed this toll passage
   */
  public TollPassage(Integer tollPlazaId, Vehicle vehiclePassed) {
    this.tollPlazaId = tollPlazaId;
    this.licensePlateNumber = vehiclePassed.getLicencePlateNumber();
    this.passageCost = vehiclePassed.getCost(RushHourUtil.getIsRushHour());
    this.passageTime = LocalTime.now();
    this.passageDateTime = LocalDate.now();
  }

  public Integer getTollPlazaId() {
    return tollPlazaId;
  }

  public String getLicensePlateNumber() {
    return licensePlateNumber;
  }

  public Integer getPassageCost() {
    return passageCost;
  }

  public LocalTime getPassageTime() {
    return passageTime;
  }

  public LocalDate getPassageDateTime() {
    return passageDateTime;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    TollPassage that = (TollPassage) o;
    return Objects.equals(tollPlazaId, that.tollPlazaId) &&
            Objects.equals(licensePlateNumber, that.licensePlateNumber) &&
            Objects.equals(passageCost, that.passageCost) &&
            Objects.equals(passageTime, that.passageTime) &&
            Objects.equals(passageDateTime, that.passageDateTime);
  }

  @Override
  public int hashCode() {
    return Objects.hash(tollPlazaId, licensePlateNumber, passageCost, passageTime, passageDateTime);
  }

  @Override
  public String toString() {
    return "TollPassage{"
            + "tollPlazaId=" + tollPlazaId
            + ", licensePlateNumber='" + licensePlateNumber + '\''
            + ", passageCost=" + passageCost
            + ", passageTime=" + passageTime
            + ", passageDateTime=" + passageDateTime
            + '}';
  }
}
