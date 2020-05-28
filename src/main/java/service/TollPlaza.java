package service;

import domain.TollPassage;
import domain.v2.Vehicle;

import java.util.List;


/**
 * I assume that the toll plazas are automated
 * and will register a toll passage once a vehicle
 * passes through.
 * Therefore, I have let {@link TollPassage} handle
 * date and time related variables and only use {@link Vehicle}
 * as a parameter here.
 *
 * Should it not be automatic, the operation signature would be as follows
 * <pre>
 *   TollPassage registerTollPassage(String licencePlateNumber, LocalDate date, LocalTime time)
 * </pre>
 */
public interface TollPlaza {

  TollPassage registerTollPassage(String licencePlateNumber);

  List<TollPassage> getTollPassages();

}
