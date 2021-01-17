package com.afkl.travel.exercise.client;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class TravelClient {

    public static void main(String[] args) {

        try {

          URL restUrl = new URL("http://localhost:8080/travel/locations/country/US");
          
          HttpURLConnection conn = (HttpURLConnection) restUrl.openConnection();
          conn.setRequestMethod("GET");
          conn.setRequestProperty("Accept", "application/json");
          if (conn.getResponseCode() != 200) {
              throw new RuntimeException("Failed : HTTP error code : "
                      + conn.getResponseCode());
          }
          BufferedReader br = new BufferedReader(new InputStreamReader(
              (conn.getInputStream())));

          String output;
          System.out.println("Response from Service:");
          while ((output = br.readLine()) != null) {
              System.out.println(output);
          }
          conn.disconnect();
        }catch (Exception e) {
        	e.printStackTrace();
        }
      }

}
