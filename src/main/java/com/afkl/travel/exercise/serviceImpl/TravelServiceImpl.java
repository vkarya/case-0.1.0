package com.afkl.travel.exercise.serviceImpl;
/** Represents an Repository service Layer
 * @author Vaibhav Arya
 * @version 0.1.0
 * @since 0.1.0
*/
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
	/** 
	 * Gets all Travel Locations.
	 * @return A List Object representing the Locations
	*/		
	@Override
	public List<Location> getLocations() {
		List<Location> locationObj = new ArrayList<Location>();
		
		 travelRepo.findAll().forEach(eachLocation -> locationObj.add(eachLocation));
		 
		 return locationObj;
	}
	/** 
	 * Gets Travel Locations for a particular Code (Ex. US) and Type (Ex. country).
	 * @return A List Object representing the Locations
	 * @param type representing the any of (country,city,airport)
	 * @param code representing the country code for ex. US
	*/	
	@Override
	public List<Location> getLocationByTypeAndCode(String type, String code) {
		
		return travelRepo.getLocationByTypeAndCode(type, code);
	}
}
