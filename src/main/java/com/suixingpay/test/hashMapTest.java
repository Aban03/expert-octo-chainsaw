package com.suixingpay.test;

import java.util.HashMap;
import java.util.Map;

public class hashMapTest<K,V> implements MapTest<K,V> {

    private static int defaultLength = 16;  //数组长度
    private static double defaultLoad=0.75;  //负载因子
    private Entry<K,V>[] table =null;
    private int size = 0;

    hashMapTest(int defaultLength,double defaultLoad){
         this.defaultLength = defaultLength;
         this.defaultLoad = defaultLoad;
         table = new Entry[defaultLength];  //默认长度
    }

    hashMapTest(){
        this(defaultLength,defaultLoad);
    }

    @Override
    public V put(K key, V value) {

        int index = this.getIndex(key);  //数组下标
        Entry<K,V> e = table[index];
        if(e == null){
            table[index] = new Entry(key,value,null,index);
            size++;
        }else{
            Entry entry = new Entry(key,value,e,index);
            table[index] = entry;
        }

        return table[index].getValue();
    }

    private int getIndex(K key) {
        int m = defaultLength - 3;
        return key.hashCode() % m;
    }

    @Override
    public V get(K key) {
        int index = this.getIndex(key);
        return table[index] == null ? null : table[index].getValue();
    }

    @Override
    public int size() {
        return size;
    }

    class Entry<K,V> implements MapTest.EntryTest<K,V>{

        K key;
        V value;
        Entry<K,V> next;
        int index;

        Entry(K k,V v,Entry<K,V> n,int x){
            key = k;
            value = v;
            index = x;
            /* 数组第一个元素的下一个元素 */
            next = n;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }
    }

    public static void main(String[] args) {
        hashMapTest<String,String> map = new hashMapTest<String,String>();
        map.put("小明","18");
        map.put("huang","20");

        System.out.println("黄亚峰年龄"+ map.get("huang"));
    }
}
