package com.msmith.dojosninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.msmith.dojosninjas.models.Ninja;
import com.msmith.dojosninjas.repositories.NinjaRepository;

@Service
public class NinjaServices {
	
	@Autowired
	private NinjaRepository ninjaRepo;
	
	//find all
	public List<Ninja> allNinjas(){
		return ninjaRepo.findAll();
	}
	
	// find one
	public Ninja oneNinja(Long id) {
		Optional<Ninja> optionalNinja = ninjaRepo.findById(id);
		if(optionalNinja.isPresent()) {
			return optionalNinja.get();
		}
		else {
			return null;
		}
	}
	
	//create
	public Ninja createNinja(Ninja ninja) {
		return ninjaRepo.save(ninja);
	}
}
