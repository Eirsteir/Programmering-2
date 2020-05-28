package domain.v1;

import exception.VehicleException;

public class DieselCar extends Vehicle {

  /**
   * Create a diesel car.
   *
   * @param licensePlateNumber the registration number for this vehicle in the form "UF 32512"
   * @param totalWeightInKg    the total weight in kg, must be a positive integer
   * @throws VehicleException if the total weight is a negative integer
   */
  public DieselCar(String licensePlateNumber, Integer totalWeightInKg)  {
    super(licensePlateNumber, totalWeightInKg, VehicleTypeCost.DIESEL_CAR);
  }
}
