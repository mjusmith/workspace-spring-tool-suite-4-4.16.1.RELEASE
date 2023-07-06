package com.me.zoo;

public class AnimalTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Gorilla magilla = new Gorilla();
		
		magilla.throwSomething();
		magilla.throwSomething();
		magilla.throwSomething();
		magilla.displayEnergy();
		
		magilla.eatBananas();
		magilla.eatBananas();
		magilla.displayEnergy();
		
		magilla.climb();
		magilla.displayEnergy();
		
		Bat renfield = new Bat();
		
		renfield.attackTown();
		renfield.attackTown();
		renfield.attackTown();
		renfield.displayEnergy();
		
		renfield.eatHumans();
		renfield.eatHumans();
		renfield.displayEnergy();
		
		renfield.fly();
		renfield.fly();
		renfield.displayEnergy();
	}

}
