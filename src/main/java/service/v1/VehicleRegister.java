package service.v1;

import domain.v1.Vehicle;
import java.util.List;


/**
 * Interface for registries. Defines operations for registering vehicles
 * and searching by licence plate number and total weight over a given weight.
 */
public interface VehicleRegister {

  Vehicle registerVehicle(Vehicle vehicle);

  List<Vehicle> searchByLicencePlateNumber(String licencePlateNumber);

  List<Vehicle> searchByTotalWeightOver(Integer totalWeight);

}
