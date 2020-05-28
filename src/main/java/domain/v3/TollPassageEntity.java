package domain.v3;

import domain.v2.Vehicle;
import util.RushHourUtil;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;


/**
 * Class TollPassageEntity.
 * The date and time for the passage is based on what time
 * it is when the class is initialized.
 */
@Entity
public class TollPassageEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private Integer tollPlazaId;
  private String licensePlateNumber;
  private Integer passageCost;
  private LocalTime passageTime;
  private LocalDate passageDateTime;

  public TollPassageEntity() {
  }

  /**
   * Create a toll passage instance.
   *
   * @param tollPlazaId Long, the id of the related toll plaza
   * @param vehiclePassed Vehicle, the vehicle that passed this toll passage
   */
  public TollPassageEntity(Integer tollPlazaId, Vehicle vehiclePassed) {
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

  public void setId(Long id) {
    this.id = id;
  }

  public void setTollPlazaId(Integer tollPlazaId) {
    this.tollPlazaId = tollPlazaId;
  }

  public void setLicensePlateNumber(String licensePlateNumber) {
    this.licensePlateNumber = licensePlateNumber;
  }

  public void setPassageCost(Integer passageCost) {
    this.passageCost = passageCost;
  }

  public void setPassageTime(LocalTime passageTime) {
    this.passageTime = passageTime;
  }

  public void setPassageDateTime(LocalDate passageDateTime) {
    this.passageDateTime = passageDateTime;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    TollPassageEntity that = (TollPassageEntity) o;
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
