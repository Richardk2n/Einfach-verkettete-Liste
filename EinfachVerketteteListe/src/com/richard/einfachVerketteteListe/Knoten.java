package com.richard.einfachVerketteteListe;

public class Knoten<T> {
	
	private Knoten<T> nächster;
	private T inhalt;
	
	public Knoten(T inhalt, Knoten<T> nächster){
		this.setInhalt(inhalt);
		this.setNächster(nächster);
	}

	public Knoten<T> getNächster() {
		return nächster;
	}

	public void setNächster(Knoten<T> nächster) {
		this.nächster = nächster;
	}

	public T getInhalt() {
		return inhalt;
	}

	public void setInhalt(T inhalt) {
		this.inhalt = inhalt;
	}
	
	public void add(T element){
		if(nächster instanceof Abschluss<?>){
			nächster = new Knoten<T>(element, nächster);
		}else{
			nächster.add(element);
		}
	}
	
	public void add(int index, int i, T element){
		if(index == i+1){
			nächster = new Knoten<T>(element, nächster);
		}else{
			nächster.add(index, i+1, element);
		}
	}
	
	public T get(int index, int i){
		if(index == i+1){
			return nächster.getInhalt();
		}else{
			return nächster.get(index, i+1);
		}
	}
	
	public void remove(int index, int i){
		if(index == i+1){
			nächster = nächster.getNächster();
		}else{
			nächster.remove(index, i+1);
		}
	}
	
	public boolean remove(T element) {
		if(element.equals(nächster.getInhalt())){
			nächster = nächster.getNächster();
			return true;
		}else{
			return nächster.remove(element);
		}
	}
	
	public int indexOf(T element, int i){
		if(element.equals(nächster.getInhalt())){
			return i+1;
		}else{
			return nächster.indexOf(element, i+1);
		}
	}

}
