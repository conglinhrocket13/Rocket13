package com.vti.entity;

public class Staff<K, V> extends MyMap<K, V>{

	public Staff(K key, V value) {
		super(key, value);
		// TODO Auto-generated constructor stub
	}

	public K getID() {
		return super.getKey();
	}
	
	public V getName() {
		return super.getValue();
	}
}
