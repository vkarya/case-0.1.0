package com.afkl.travel.exercise.controllers;
/** Represents an REST API Controller.
 * @author Vaibhav Arya
 * @version 0.1.0
 * @since 0.1.0
*/
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.afkl.travel.exercise.exceptions.TravelException_NOTFOUND;
import com.afkl.travel.exercise.exceptions.TravelException_UNAUTHORISED;
import com.afkl.travel.exercise.service.TravelService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(description = "Travel API Rest Controller to provide information about locations")
@RestController
@RequestMapping("/travel")
public class TravelController {
	
	@Autowired
	TravelService travelService;
	
	/** 
	 * Gets all Travel Locations.
	 * @return A ResponseEntity Array Object representing the Locations
	*/	
	@ApiOperation(value = "Fetches an existing List of Locations")	
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "successful operation", response=Object[].class )  })	
	@RequestMapping(value="/locations", method = RequestMethod.GET)
	public ResponseEntity<Object[]> getLocations(@RequestHeader("accept-language") String language)   
	{  
		return new ResponseEntity<Object[]>(travelService.getLocations().toArray(), HttpStatus.OK);  
	} 

	/** 
	 * Gets Travel Locations for a particular Code (Ex. US) and Type (Ex. country).
	 * @return A ResponseEntity Array Object representing the Locations
	 * @param type representing the any of (country,city,airport)
	 * @param code representing the country code for ex. US
	*/	
	@ApiOperation(value = "Fetches an existing List of Locations with Code and Type")		
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "successful operation", response=Object[].class )  })	
    @RequestMapping(value="/locations/{type}/{code}", method = RequestMethod.GET)    
    public Object[] getLocationByTypeAndCode(@RequestHeader("accept-language") String language, @PathVariable("type") String type, @PathVariable("code") String code){
		
    	if(StringUtils.isEmpty(type) || StringUtils.isEmpty(code)) {
    		throw new TravelException_NOTFOUND();
    	}
        return travelService.getLocationByTypeAndCode(type, code).toArray();
    }	
}
