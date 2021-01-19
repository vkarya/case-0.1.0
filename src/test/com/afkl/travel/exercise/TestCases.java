package com.afkl.travel.exercise;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.afkl.travel.exercise.model.Location;


public class TestCases extends AbstractTest {
   @Override
   @Before
   public void setUp() {
      super.setUp();
   }
   @Test
   public void getAllLocations() throws Exception {
      String uri = "/travel/locations";
      Map<String, String> headerMap = new HashMap<String, String>();
      headerMap.put("Accept-Language", "en-US");
      headerMap.put("userName", "someuser");
      headerMap.put("password", "psw");
      HttpHeaders httpHeaders = new HttpHeaders();
      httpHeaders.setAll(headerMap);      
      MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri).headers(httpHeaders)
         .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
      
      int status = mvcResult.getResponse().getStatus();
      assertEquals(200, status);
      String content = mvcResult.getResponse().getContentAsString();
      Location[] branchlist = super.mapFromJson(content, Location[].class);
      assertTrue(branchlist.length > 0);
   }
   
   @Test
   public void getLocationByTypeAndCode() throws Exception {
      String uri = "/travel/locations/country/US";
      Map<String, String> headerMap = new HashMap<String, String>();
      headerMap.put("Accept-Language", "en-US");
      headerMap.put("userName", "someuser");
      headerMap.put("password", "psw");
      HttpHeaders httpHeaders = new HttpHeaders();
      httpHeaders.setAll(headerMap);
      
      MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri).headers(httpHeaders)
    		  .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
      
      int status = mvcResult.getResponse().getStatus();
      assertEquals(200, status);
   }

}