public interface List<T> extends Collection<T> {
  T get(int index);
  void removeAt(int index);
  void insert(T element, int index);
}
