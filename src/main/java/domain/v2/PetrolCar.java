package domain.v2;

import exception.VehicleException;

public class PetrolCar extends Vehicle {

  /**
   * Create a petrol car.
   *
   * @param licensePlateNumber the registration number for this vehicle in the form "UF 32512"
   * @param totalWeightInKg    the total weight in kg, must be a positive integer
   * @throws VehicleException if the total weight is a negative integer
   */
  public PetrolCar(String licensePlateNumber, Integer totalWeightInKg) {
    super(licensePlateNumber, totalWeightInKg, VehicleTypeCost.PETROL_CAR);
  }
}
