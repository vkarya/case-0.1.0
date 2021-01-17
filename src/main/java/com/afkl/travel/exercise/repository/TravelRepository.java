package com.afkl.travel.exercise.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.afkl.travel.exercise.model.Location;

@Repository
public interface TravelRepository extends CrudRepository <Location, Long>{
	
	//@Query("select a.id, a.code, a.type, a.longitude, a.latitude, a.parent, b.id, b.location, b.language, b.name, b.description from location a, Translation b where a.id = b.location and a.code = ?1 and a.type=?2")	
	public List<Location> getLocationByTypeAndCode(String type, String code);
	
}
