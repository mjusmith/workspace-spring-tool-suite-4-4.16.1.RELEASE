package com.me.zoo;

public class Bat extends Animal {
	
	public Bat() {
		super(300);
	}
	
	public void fly() {
		super.setEnergy(getEnergy()-50);
		System.out.println("The bat is in the air! Run!");
	}
	
	public void eatHumans() {
		super.setEnergy(getEnergy()+25);
		System.out.println("Someone didn't run fast enough..The bat is feasting.");
	}
	
	public void attackTown() {
		super.setEnergy(getEnergy()-100);
		System.out.println("Reminds me of Nick Cage walking into a self-help group.");
	}
}
