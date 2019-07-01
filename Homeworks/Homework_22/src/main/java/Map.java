public interface Map<K, V> {
  void add(K k, V v);
  V get(Object k);
  V put(K k, V v);
  boolean containsKey(Object k);
  void containsValue(Object v);
}
