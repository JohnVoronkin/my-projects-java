package collections.lambda;

@FunctionalInterface
public interface Transformable<T> {

  T transform(T t);

}
