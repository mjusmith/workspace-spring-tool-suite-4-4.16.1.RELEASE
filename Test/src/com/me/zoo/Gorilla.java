package com.me.zoo;

public class Gorilla extends Animal {
	
	public Gorilla() {
		super();
	}
	
	public void throwSomething() {
		super.setEnergy(getEnergy()-5);
		System.out.println("The gorilla threw something!");
	}
	
	public void eatBananas() {
		super.setEnergy(getEnergy()+10);
		System.out.println("Yummy! Bananas!");
	}
	
	public void climb() {
		super.setEnergy(getEnergy()-10);
		System.out.println("The gorilla is climbing up.");
	}
}
