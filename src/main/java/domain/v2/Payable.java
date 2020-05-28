package domain.v2;


/**
 * Interface for vehicular units which are to pay at a toll collection point.
 */
public interface Payable {

  /**
   * Return the licence plate number for this vehicle.
   */
  String getLicencePlateNumber();


  /**
   * Return the toll passage cost for this vehicle.
   */
  Integer getCost(boolean isWithingRushHours);

}
