package com.msmith.dojosninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.msmith.dojosninjas.models.Dojo;
import com.msmith.dojosninjas.repositories.DojoRepository;

@Service
public class DojoServices {
	
	@Autowired
	private DojoRepository dojoRepo;
	
	//find all
	public List<Dojo> allDojos(){
		return dojoRepo.findAll();
	}
	
	// find one
	public Dojo oneDojo(Long id) {
		Optional<Dojo> optionalDojo = dojoRepo.findById(id);
		if(optionalDojo.isPresent()) {
			return optionalDojo.get();
		}
		else {
			return null;
		}
	}
	
	//create
	public Dojo createDojo(Dojo dojo) {
		return dojoRepo.save(dojo);
	}
}
