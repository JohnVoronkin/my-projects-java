package collections.generics;

import java.util.List;

public interface BoxList<E, T> extends List<E> {

  T calcSum(E element1, T element2);

}
