package com.afkl.travel.exercise.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.afkl.travel.exercise.model.Location;

@Repository
public interface TravelRepository extends CrudRepository <Location, Long>{
	
	public List<Location> getLocationByTypeAndCode(String type, String code);
	
}
