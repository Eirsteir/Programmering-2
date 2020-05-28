import util.RushHourUtil;
import domain.v2.*;
import service.TollPassageRegister;
import service.TollPassageRegisterImpl;
import service.TollPlaza;
import service.TollPlazaImpl;
import service.v2.VehicleRegister;
import service.v2.VehicleRegisterImpl;

public class Client {

  /**
   * Showcase the solution.
   */
  public static void main(String[] args) {

    // Instantiate a vehicle register and a vehicle of each type
    VehicleRegister vehicleRegister = VehicleRegisterImpl.getInstance();
    Vehicle dieselCar = new DieselCar("UF 12345678", 2000);
    Vehicle electricalCar = new ElectricalCar("BF 12345678", 1500);
    Vehicle motorcycle = new Motorcycle("CM 12345678", 200);
    Vehicle truck = new Truck("AU 12345678", 5000);
    Vehicle petrolCar = new PetrolCar("PT 12345678", 1200);

    // Register the vehicles
    vehicleRegister.registerVehicle(dieselCar);
    vehicleRegister.registerVehicle(electricalCar);
    vehicleRegister.registerVehicle(motorcycle);
    vehicleRegister.registerVehicle(truck);
    vehicleRegister.registerVehicle(petrolCar);

    // Instantiate a toll plaza
    TollPassageRegister tollPassageRegister = new TollPassageRegisterImpl();
    TollPlaza tollPlaza = new TollPlazaImpl(1, "Vikebukt bomstasjon", tollPassageRegister, vehicleRegister);

    // Register toll passages
    tollPlaza.registerTollPassage(dieselCar.getLicencePlateNumber());
    tollPlaza.registerTollPassage(electricalCar.getLicencePlateNumber());
    tollPlaza.registerTollPassage(motorcycle.getLicencePlateNumber());
    tollPlaza.registerTollPassage(truck.getLicencePlateNumber());
    tollPlaza.registerTollPassage(petrolCar.getLicencePlateNumber());

    System.out.println("Is rush hour: " + RushHourUtil.getIsRushHour());
    tollPlaza.getTollPassages().forEach(System.out::println);
  }

}
