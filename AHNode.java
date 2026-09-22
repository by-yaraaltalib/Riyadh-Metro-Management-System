package com.mycompany.riyadhmetromanagmentsystem;

public class AHNode <Key , E> {
	private Key key;
	private E value;

	public AHNode(Key key , E value) {
		this.key=key;
		this.value=value;
	}

	public void setKey(Key k) {
		key = k;
	}

	public void setValue(E v) {
		value = v;
	}

	public Key getKey() {
		return key;
	}

	public E getValue() {
		return value;
	}
}
