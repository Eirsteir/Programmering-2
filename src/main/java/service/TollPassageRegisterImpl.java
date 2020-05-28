package service;

import domain.TollPassage;
import exception.DuplicateTollPassageException;

import java.util.*;
import java.util.function.Consumer;


/**
 * Class TollPassageRegisterImpl.
 * Container class for {@link TollPassage}s implementing {@link Iterable}
 * to provide direct usage of the toll passages.
 */
public class TollPassageRegisterImpl implements TollPassageRegister, Iterable<TollPassage> {

  private List<TollPassage> tollPassages = new ArrayList<>();

  /**
   * Register and return given {@link TollPassage}.
   *
   * @param tollPassage TollPassage, the {@link TollPassage} to register. Not null.
   */
  @Override
  public TollPassage registerTollPassage(TollPassage tollPassage) {
    Objects.requireNonNull(tollPassage);
    if (tollPassages.contains(tollPassage)) {
      throw new DuplicateTollPassageException("Toll passage already exists: " + tollPassage);
    }

    tollPassages.add(tollPassage);
    return tollPassage;
  }

  @Override
  public List<TollPassage> getTollPassages() {
    return tollPassages;
  }

  @Override
  public Iterator<TollPassage> iterator() {
    return tollPassages.iterator();
  }

  @Override
  public void forEach(Consumer<? super TollPassage> action) {
    tollPassages.forEach(action);
  }

  @Override
  public Spliterator<TollPassage> spliterator() {
    return tollPassages.spliterator();
  }
}
