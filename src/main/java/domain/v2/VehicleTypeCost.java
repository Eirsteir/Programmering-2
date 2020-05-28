package domain.v2;


/**
 * Enumerations containing tariffs for vehicle types
 * in and outside rush hour.
 */
public enum VehicleTypeCost {

  DIESEL_CAR(23, 19),
  ELECTRICAL_CAR(8, 4),
  PETROL_CAR(21, 17),
  TRUCK(101, 86),
  MOTORCYCLE(0, 0);

  private Integer costInRushHour;
  private Integer costOutsideRushHour;

  VehicleTypeCost(Integer costInRushHour, Integer costOutsideRushHour) {
    this.costInRushHour = costInRushHour;
    this.costOutsideRushHour = costOutsideRushHour;
  }

  public Integer getCostInRushHour() {
    return costInRushHour;
  }

  public Integer getCostOutsideRushHour() {
    return costOutsideRushHour;
  }
}
