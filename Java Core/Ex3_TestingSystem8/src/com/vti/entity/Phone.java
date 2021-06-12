package com.vti.entity;

public class Phone<K, V> extends MyMap<K, V> {

	public Phone(K key, V value) {
		super(key, value);
		
	}
	
	public K getKey() {
		
		return super.getKey();
	}
	
	public V getNumberPhone() {
		return super.getValue();
	}

	
}
