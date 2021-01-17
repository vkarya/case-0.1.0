package com.afkl.travel.exercise.service;

import java.util.List;

import com.afkl.travel.exercise.model.Location;

public interface TravelService {
	public List<Location> getLocations();
	
	public List<Location> getLocationByTypeAndCode(String type, String code);
}
