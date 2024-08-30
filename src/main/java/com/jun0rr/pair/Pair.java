/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.jun0rr.pair;

import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 *
 * @author F6036477
 */
public record Pair<K,V>(K key, V value) implements Map.Entry {

  public <X> X map(Function<Pair<K,V>,X> map) {
    return map.apply(this);
  }
  
  public void take(Consumer<Pair<K,V>> cs) {
    cs.accept(this);
  }
  
  public boolean test(Predicate<Pair<K,V>> p) {
    return p.test(this);
  }
  
  public <X> Pair<X,V> withKey(X newKey) {
    return new Pair(newKey, value);
  }

  public <X> Pair<K,X> withValue(V newValue) {
    return new Pair(key, newValue);
  }

  @Override
  public K getKey() {
    return key;
  }

  @Override
  public V getValue() {
    return value;
  }

  @Override
  public Object setValue(Object value) {
    throw new UnsupportedOperationException();
  }
  
  public static <A,B> Pair<A,B> of(A key, B value) {
    return new Pair(key, value);
  }
  
}
