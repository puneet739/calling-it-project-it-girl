package com.fairdeal.compass.util;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.fairdeal.compass.dao.CityCordinates;
import com.fairdeal.compass.generic.Constants;

/**
 * This is the class used to store the Utilities which will be used through out the application. 
 * 
 * @author puneetbehl
 */
public class Util {
	
	private final String googleGraphAPI="https://maps.googleapis.com/maps/api/geocode/json?address={address}&sensor=true";
	RestTemplate restTemplate = new RestTemplate();
	
    /**
     * returns Json Object string.
     * 
     * @param obj
     * @return Json Object
     */
    public static String convertJavaObjectToJson(Object obj) {

        String jsonObject = null;

        ObjectMapper mapper = new ObjectMapper();

        try {
            jsonObject = mapper.writeValueAsString(obj);
        } catch (JsonGenerationException e) {
            LoggerUtil.error("JsonGenerationException caught while Generating JSON:", e);
        } catch (JsonMappingException e) {
            LoggerUtil.error("JsonMappingException caught while Mapping JSON:", e);
        } catch (IOException e) {
            LoggerUtil.error("IOException caught in JsonUtil:", e);
        }
        return jsonObject;
    }

    /**
     * This program will be used to retreive the City cordinates of the city provided as name
     * 
     * @author :: Puneet Behl
     * @param cityName
     * @return
     */
    public CityCordinates getCityCordinatesFromDatabase(String cityName) {
        LoggerUtil.debug("Getting the CityCordinates of :: " + cityName);
        CityCordinates cordinates;
        cordinates = null ; //cityCordinateRepo.getCityCordinates(cityName);

//        if (cordinates != null) {
//            //cityCordinatesMap.put(cityName, cordinates);
//            return cordinates;
//        }
        
        Double lattitude = new Double(0);
        Double longitude = new Double(0);
        try {
            MultiValueMap<String, Object> map = new LinkedMultiValueMap<String, Object>();
            map.add("address", cityName);

            JsonNode outputNode2 = restTemplate.getForObject(googleGraphAPI, JsonNode.class, map);

            if (Constants.GenericConstants.OK.equals(outputNode2.get("status").asText())) {
                LoggerUtil.debug("City Cordinates fetched from " + googleGraphAPI + " :: " + outputNode2.asText());
                JsonNode results = outputNode2.get("results");
                JsonNode firstNode = results.get(0).get("geometry");
                JsonNode locationNode = firstNode.get("location");
                if (locationNode != null) {
                    lattitude = locationNode.get("lat").asDouble();
                    longitude = locationNode.get("lng").asDouble();
                }

                LoggerUtil.debug("Lattitude:: " + lattitude);
                LoggerUtil.debug("Longitude:: " + longitude);
            }
        } catch (Exception e) {
            LoggerUtil.error("Exception is caused fetching the details of CityCordinates:", e);
        }
        cordinates = new CityCordinates();
        cordinates.setCityName(cityName);
        cordinates.setLatitude(lattitude);
        cordinates.setLongitude(longitude);

        //cityCordinatesMap.put(cityName, cordinates);
        //cityCordinateRepo.save(cordinates);
        return cordinates;
    }
}
