package com.afkl.travel.exercise.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.afkl.travel.exercise.exceptions.TravelException_NOTFOUND;
import com.afkl.travel.exercise.exceptions.TravelException_UNAUTHORISED;
import com.afkl.travel.exercise.service.TravelService;

@RestController
@RequestMapping("/travel")
public class TravelController {
	
	@Autowired
	TravelService travelService;
	
	@Value("${app.userName}")
	private String appUserName;
	
	@Value("${app.password}")
	private String appPassword;	
	
	@RequestMapping(value="/locations", method = RequestMethod.GET)

	public ResponseEntity<Object[]> getLocations(@RequestHeader("accept-language") String language, @RequestHeader("userName") String headerUserName, @RequestHeader("password") String headerPassword)   
	{  
		if(!appUserName.equals(headerUserName) || !appPassword.equals(headerPassword)) {
			throw new TravelException_UNAUTHORISED();
		}
		return new ResponseEntity<Object[]>(travelService.getLocations().toArray(), HttpStatus.OK);  
	} 
	
    @RequestMapping(value="/locations/{type}/{code}", method = RequestMethod.GET)    
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public Object[] getLocationByTypeAndCode(@RequestHeader("userName") String headerUserName, @RequestHeader("password") String headerPassword, @PathVariable("type") String type, @PathVariable("code") String code){
    	
		if(!appUserName.equals(headerUserName) || !appPassword.equals(headerPassword)) {
			throw new TravelException_UNAUTHORISED();
		}
		
    	if(StringUtils.isEmpty(type) || StringUtils.isEmpty(code)) {
    		throw new TravelException_NOTFOUND();
    	}
        return travelService.getLocationByTypeAndCode(type, code).toArray();
    }	
}
