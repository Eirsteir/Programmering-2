package domain.v1;

import exception.VehicleException;

import java.util.Objects;


/**
 * Base class for vehicles.
 * A vehicle has a licence plate number in the form "UF 32512", a total weight in kg
 * and a vehicle type tariff
 */
public abstract class Vehicle {

  private String licensePlateNumber;
  private Integer totalWeightInKg;
  private VehicleTypeCost vehicleTypeCost;

  /**
   * Create a vehicle.
   *
   * @param licensePlateNumber the registration number for this vehicle in the form "UF 32512"
   * @param totalWeightInKg the total weight in kg, must be a positive integer
   * @param vehicleTypeCost the vehicle type cost containing the tariffs for this type of vehicle.
   */
  public Vehicle(String licensePlateNumber, Integer totalWeightInKg, VehicleTypeCost vehicleTypeCost) {
    if (totalWeightInKg < 0) {
      throw new VehicleException("Total weight must be a positive integer, was " + totalWeightInKg);
    }
    Objects.requireNonNull(licensePlateNumber);
    Objects.requireNonNull(vehicleTypeCost);

    this.licensePlateNumber = licensePlateNumber;
    this.totalWeightInKg = totalWeightInKg;
    this.vehicleTypeCost = vehicleTypeCost;
  }

  public String getLicensePlateNumber() {
    return licensePlateNumber;
  }

  public Integer getTotalWeightInKg() {
    return totalWeightInKg;
  }

  public VehicleTypeCost getVehicleTypeCost() {
    return vehicleTypeCost;
  }

  /**
   * Return toll passage cost for this vehicle, depending on whether it is rush hour or not.
   *
   * @param isRushHour boolean, if now is rush hour
   */
  public Integer getTollPassageCost(boolean isRushHour) {
   if (isRushHour) {
     return vehicleTypeCost.getCostInRushHour();
   }

   return vehicleTypeCost.getCostOutsideRushHour();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    Vehicle vehicle = (Vehicle) o;
    return Objects.equals(licensePlateNumber, vehicle.licensePlateNumber)
            && Objects.equals(totalWeightInKg, vehicle.totalWeightInKg);
  }

  @Override
  public String toString() {
    return "Vehicle{"
            + "licensePlateNumber='" + licensePlateNumber + '\''
            + ", totalWeightInKg=" + totalWeightInKg
            + ", vehicleTypeCost=" + vehicleTypeCost
            + '}';
  }
}
