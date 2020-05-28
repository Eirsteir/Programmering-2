package service;

import domain.TollPassage;
import domain.v1.DieselCar;
import domain.v1.ElectricalCar;
import domain.v1.Vehicle;
import exception.DuplicateVehicleException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import service.v1.VehicleRegisterImpl;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class VehicleRegisterImplTest {

  public static final String LICENSE_PLATE_NUMBER_DIESEL_CAR = "BF 12345678";
  public static final int TOTAL_WEIGHT_IN_KG_ELECTRICAL_CAR = 1500;
  public static final int TOTAL_WEIGHT_IN_KG_DIESEL_CAR = 2000;
  private DieselCar dieselCar;
  private ElectricalCar electricalCar;
  private VehicleRegisterImpl vehicleRegister;

  @BeforeEach
  void setUp() {
    vehicleRegister = new VehicleRegisterImpl();
    dieselCar = new DieselCar(LICENSE_PLATE_NUMBER_DIESEL_CAR, TOTAL_WEIGHT_IN_KG_DIESEL_CAR);
    electricalCar = new ElectricalCar("UE 9876543", TOTAL_WEIGHT_IN_KG_ELECTRICAL_CAR);
  }

  @Test
  void testRegisterVehicleWhenNotExists_thenAddVehicle() {
    vehicleRegister.registerVehicle(dieselCar);

    assertTrue(vehicleRegister.getVehicles().contains(dieselCar));
  }

  @Test
  void testRegisterVehicleWhenNull_thenTrowException() {
    vehicleRegister.registerVehicle(dieselCar);

    assertThrows(NullPointerException.class, () -> vehicleRegister.registerVehicle(dieselCar));
    assertFalse(vehicleRegister.getVehicles().contains(dieselCar));
  }

  @Test
  void testRegisterVehicleWhenDuplicate_thenTrowException() {
    vehicleRegister.registerVehicle(dieselCar);

    assertThrows(DuplicateVehicleException.class, () -> vehicleRegister.registerVehicle(dieselCar));
    assertFalse(vehicleRegister.getVehicles().contains(dieselCar));
  }

  @Test
  void testSearchByLicencePlateNumberWhenVehiclesWithMatchingNumberExists_thenReturnMatchingVehicles() {
    vehicleRegister.registerVehicle(electricalCar);

    List<Vehicle> results = vehicleRegister.searchByLicencePlateNumber(LICENSE_PLATE_NUMBER_DIESEL_CAR);

    assertTrue(results.contains(dieselCar));
    assertFalse(results.contains(electricalCar));
  }

  @Test
  void testSearchByLicencePlateNumberWhenVehiclesWithMatchingNumberNotExists_thenReturnEmptyList() {
    List<Vehicle> results = vehicleRegister.searchByLicencePlateNumber("123");

    assertTrue(results.isEmpty());
  }

  @Test
  void testSearchByTotalWeightOverWhenVehiclesExistsWithTotalWeightOver_thenReturnMatchingVehicles() {
    vehicleRegister.registerVehicle(electricalCar);

    List<Vehicle> results = vehicleRegister.searchByTotalWeightOver(TOTAL_WEIGHT_IN_KG_ELECTRICAL_CAR);

    assertTrue(results.contains(dieselCar));
    assertFalse(results.contains(electricalCar));
  }

  @Test
  void testSearchByTotalWeightOverWhenVehiclesNotExistsWithTotalWeightOver_thenReturnEmptyList() {
    List<Vehicle> results = vehicleRegister.searchByTotalWeightOver(TOTAL_WEIGHT_IN_KG_DIESEL_CAR);

    assertTrue(results.isEmpty());
  }
}