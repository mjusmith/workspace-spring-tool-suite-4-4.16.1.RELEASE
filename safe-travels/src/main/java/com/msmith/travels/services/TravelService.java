package com.msmith.travels.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.msmith.travels.models.Travel;
import com.msmith.travels.repositories.TravelRepository;

@Service
public class TravelService {
	
	private final TravelRepository travelRepo;
	
	public TravelService(TravelRepository travelRepo) {
		this.travelRepo= travelRepo;
	}
	
	public List<Travel> allCosts(){
		return travelRepo.findAll();
	}
	
	public Travel oneTravel(Long id) {
		Optional<Travel> optionalTravel = travelRepo.findById(id);
		if (optionalTravel.isPresent()) {
			return optionalTravel.get();
		}
		else {
			return null;
		}
	}
	
	public Travel createTravel(Travel newTravel) {
		return travelRepo.save(newTravel);
	}
	
	public Travel updateTravel(Travel updatedTravel) {
		return travelRepo.save(updatedTravel);
	}
	
	public void deleteTravelById(Long id) {
		travelRepo.deleteById(id);
	}
}
