public interface Collection <T> extends Iterable<T>{
    void add(T element);
    void add(T ... element);
    boolean remove(T element);
    boolean contains(T element);
    int size();
}
