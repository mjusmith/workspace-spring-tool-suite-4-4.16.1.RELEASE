package com.me.zoo;

public class Animal {
	private int energy;
	
	public Animal(){
		this.energy=100;
	}
	
	public Animal(int energy){
		this.energy=energy;
	}
	
	public void displayEnergy() {
		System.out.println("The current energy is: " + this.energy);
	}

	public int getEnergy() {
		return energy;
	}

	public void setEnergy(int energy) {
		this.energy = energy;
	}
		
}
