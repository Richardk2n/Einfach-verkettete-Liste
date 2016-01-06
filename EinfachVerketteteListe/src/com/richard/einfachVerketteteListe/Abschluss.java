package com.richard.einfachVerketteteListe;

public class Abschluss<T> extends Knoten<T> {

	public Abschluss() {
		super(null, null);
	}
	
	public boolean remove(T element) {
		return false;
	}
	
	public int indexOf(T element, int i){
		return -1;
	}

}
