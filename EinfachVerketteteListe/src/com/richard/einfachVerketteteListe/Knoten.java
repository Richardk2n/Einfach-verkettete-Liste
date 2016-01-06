package com.richard.einfachVerketteteListe;

public class Knoten<T> {
	
	private Knoten<T> n�chster;
	private T inhalt;
	
	public Knoten(T inhalt, Knoten<T> n�chster){
		this.setInhalt(inhalt);
		this.setN�chster(n�chster);
	}

	public Knoten<T> getN�chster() {
		return n�chster;
	}

	public void setN�chster(Knoten<T> n�chster) {
		this.n�chster = n�chster;
	}

	public T getInhalt() {
		return inhalt;
	}

	public void setInhalt(T inhalt) {
		this.inhalt = inhalt;
	}
	
	public void add(T element){
		if(n�chster instanceof Abschluss<?>){
			n�chster = new Knoten<T>(element, n�chster);
		}else{
			n�chster.add(element);
		}
	}
	
	public void add(int index, int i, T element){
		if(index == i+1){
			n�chster = new Knoten<T>(element, n�chster);
		}else{
			n�chster.add(index, i+1, element);
		}
	}
	
	public T get(int index, int i){
		if(index == i+1){
			return n�chster.getInhalt();
		}else{
			return n�chster.get(index, i+1);
		}
	}
	
	public void remove(int index, int i){
		if(index == i+1){
			n�chster = n�chster.getN�chster();
		}else{
			n�chster.remove(index, i+1);
		}
	}
	
	public boolean remove(T element) {
		if(element.equals(n�chster.getInhalt())){
			n�chster = n�chster.getN�chster();
			return true;
		}else{
			return n�chster.remove(element);
		}
	}
	
	public int indexOf(T element, int i){
		if(element.equals(n�chster.getInhalt())){
			return i+1;
		}else{
			return n�chster.indexOf(element, i+1);
		}
	}

}
