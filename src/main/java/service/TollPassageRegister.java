package service;

import domain.TollPassage;

import java.util.List;

public interface TollPassageRegister {

  TollPassage registerTollPassage(TollPassage tollPassage);

  List<TollPassage> getTollPassages();

}
