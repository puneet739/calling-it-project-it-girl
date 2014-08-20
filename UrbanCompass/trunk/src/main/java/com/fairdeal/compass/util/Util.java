package com.fairdeal.compass.util;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;


/**
 * This is the class used to store the Utilities which will be used through out the application. 
 * 
 * @author puneetbehl
 */
public class Util {
	
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
}
