package service.v2;

import domain.v2.Vehicle;
import exception.DuplicateVehicleException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;


/**
 * Singleton class VehicleRegisterImpl with an eagerly initialized static instance.
 * Implemented as a singleton which only allows for one single global instance of this class.
 */
public final class VehicleRegisterImpl implements VehicleRegister {

  private List<Vehicle> vehicles;

  /**
   * Static class instance of this class.
   */
  private static final VehicleRegister INSTANCE = new VehicleRegisterImpl();

  /**
   * Private constructor so class cannot be instantiated.
   */
  private VehicleRegisterImpl() {
    this.vehicles = new ArrayList<>();
  }

  /**
   * Obtain the instance of the class.
   *
   * @return the singleton instance
   */
  public static VehicleRegister getInstance() {
    return INSTANCE;
  }

  @Override
  public Vehicle registerVehicle(Vehicle vehicle) {
    Objects.requireNonNull(vehicle);

    if (vehicles.contains(vehicle)) {
      throw new DuplicateVehicleException("Vehicle with licence plate number -" + vehicle.getLicencePlateNumber()
            + " already exists");
    }
    vehicles.add(vehicle);

    return vehicle;
  }

  @Override
  public Optional<Vehicle> findByLicencePlateNumber(String licencePlateNumber) {
    return searchByLicencePlateNumber(licencePlateNumber).stream()
            .findFirst();
  }

  @Override
  public List<Vehicle> searchByLicencePlateNumber(String licencePlateNumber) {
    return vehicles.stream()
            .filter(vehicle -> vehicle.getLicencePlateNumber().equals(licencePlateNumber))
            .collect(Collectors.toList());
  }

  @Override
  public List<Vehicle> searchByTotalWeightOver(Integer totalWeight) {
    return vehicles.stream()
            .filter(vehicle -> totalWeight < vehicle.getTotalWeightInKg())
            .collect(Collectors.toList());
  }

  public List<Vehicle> getVehicles() {
    return vehicles;
  }
}
