package service.v2;

import domain.v2.Vehicle;

import java.util.List;
import java.util.Optional;


/**
 * Interface for registries. Defines operations for registering vehicles
 * and searching by licence plate number and total weight over a given weight.
 */
public interface VehicleRegister {

  Vehicle registerVehicle(Vehicle vehicle);

  Optional<Vehicle> findByLicencePlateNumber(String licencePlateNumber);

  List<Vehicle> searchByLicencePlateNumber(String licencePlateNumber);

  List<Vehicle> searchByTotalWeightOver(Integer totalWeight);

}
