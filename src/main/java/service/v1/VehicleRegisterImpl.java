package service.v1;

import domain.v1.Vehicle;
import exception.DuplicateVehicleException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class VehicleRegisterImpl implements VehicleRegister {

  private List<Vehicle> vehicles;

  public VehicleRegisterImpl() {
    this.vehicles = new ArrayList<>();
  }

  @Override
  public Vehicle registerVehicle(Vehicle vehicle) {
    Objects.requireNonNull(vehicle);

    if (vehicles.contains(vehicle)) {
      throw new DuplicateVehicleException("Vehicle with licence plate number -" + vehicle.getLicensePlateNumber()
            + " already exists");
    }
    vehicles.add(vehicle);

    return vehicle;
  }

  @Override
  public List<Vehicle> searchByLicencePlateNumber(String licencePlateNumber) {
    return vehicles.stream()
            .filter(vehicle -> vehicle.getLicensePlateNumber().equals(licencePlateNumber))
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
