package service;

import domain.TollPassage;
import domain.v2.Vehicle;
import exception.VehicleNotFoundException;
import service.v2.VehicleRegister;

import java.util.List;

public class TollPlazaImpl implements TollPlaza {

  private Integer id;
  private String name;
  private TollPassageRegister tollPassageRegister;
  private VehicleRegister vehicleRegister;

  /**
   * Create a TollPlaza.
   *
   * @param id Integer, the id of the toll plaza
   * @param name String, the name of the toll plaza
   * @param tollPassageRegister TollPlazaRegister, the toll plaza register
   * @param vehicleRegister VehicleRegister, the vehicle register
   */
  public TollPlazaImpl(Integer id,
                       String name,
                       TollPassageRegister tollPassageRegister,
                       VehicleRegister vehicleRegister) {
    this.id = id;
    this.name = name;
    this.tollPassageRegister = tollPassageRegister;
    this.vehicleRegister = vehicleRegister;
  }

  @Override
  public TollPassage registerTollPassage(String licencePlateNumber) {
    Vehicle vehicle = vehicleRegister.findByLicencePlateNumber(licencePlateNumber)
            .orElseThrow(() -> new VehicleNotFoundException("Vehicle with licence plate number - "
                                                                    + licencePlateNumber
                                                                    + " not found: "));

    return tollPassageRegister.registerTollPassage(new TollPassage(id, vehicle));
  }

  @Override
  public List<TollPassage> getTollPassages() {
    return tollPassageRegister.getTollPassages();
  }
}
