package com.richard.einfachVerketteteListe;

public class EinfachVerketteteListe<T> {

	private Knoten<T> erster;
	private int size = 0;

	public EinfachVerketteteListe() {
		erster = new Abschluss<>();
	}

	public void add(T element) {
		if(size == 0){
			erster = new Knoten<T>(element, erster);
		}else{
			erster.add(element);
		}
		size++;
	}

	public int size() {
		return size;
	}

	public void add(int index, T element) {
		if (index > size) {
			throw new IndexOutOfBoundsException(
					new StringBuilder("The given index ").append(index).append(" is bigger than the size of the list ").append(size).toString());

		} else {
			if (index == 0) {
				erster = new Knoten<T>(element, erster);
				size++;
			} else {
				erster.add(index, 0, element);
				size++;
			}
		}
	}
	
	public T get(int index){
		if (index >= size) {
			throw new IndexOutOfBoundsException(
					new StringBuilder("The given index ").append(index).append(" is bigger than the size of the list ").append(size).toString());

		} else {
			if (index == 0) {
				return erster.getInhalt();
			} else {
				return erster.get(index, 0);
			}
		}
	}

	public void remove(int index) {
		if (index >= size) {
			throw new IndexOutOfBoundsException(
					new StringBuilder("The given index ").append(index).append(" is bigger than the size of the list ").append(size).toString());
		} else {
			if (index == 0) {
				erster = erster.getNächster();
				size--;
			} else {
				erster.remove(index, 0);
			}
		}
	}

	public void remove(T element) {
		if (element.equals(erster.getInhalt())) {
			erster = erster.getNächster();
			size--;
		}else{
			if(erster.remove(element)){
				size--;
			}
		}
	}
	
	public int indexOf(T element){
		if(element.equals(erster.getInhalt())){
			return 0;
		}else{
			return erster.indexOf(element, 0);
		}
	}

}
