package com.afkl.travel.exercise.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.afkl.travel.exercise.model.Location;
import com.afkl.travel.exercise.repository.TravelRepository;
import com.afkl.travel.exercise.service.TravelService;

@Service
public class TravelServiceImpl implements TravelService {

	@Autowired
	TravelRepository travelRepo;
	
	@Override
	public List<Location> getLocations() {
		List<Location> locationObj = new ArrayList<Location>();
		
		 travelRepo.findAll().forEach(eachLocation -> locationObj.add(eachLocation));
		 
		 return locationObj;
	}
	
	@Override
	public List<Location> getLocationByTypeAndCode(String type, String code) {
		
		return travelRepo.getLocationByTypeAndCode(type, code);
	}
}
