package com.suixingpay.test;

public interface MapTest<K,V> {

     V put(K key, V value);
     V get(K key);

     int size();

     interface EntryTest<K,V>{
         K getKey();
         V getValue();
     }
}
