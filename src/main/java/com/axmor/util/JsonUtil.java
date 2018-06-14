package com.axmor.util;

import com.fasterxml.jackson.databind.*;

import java.io.IOException;
import java.io.StringWriter;

public class JsonUtil {
    public static String dataToJson(Object data) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.enable(SerializationFeature.INDENT_OUTPUT);
            StringWriter sw = new StringWriter();
            mapper.writeValue(sw, data);
            return sw.toString();
        } catch (IOException e) {
         throw new RuntimeException("IOException while mapping object (" + data + ") to JSON");
        }
    }
    public static String parseJson(String data, String fieldName) {
        try {
            ObjectMapper om = new ObjectMapper();
            JsonNode jsonNode = om.readTree(data);
            return jsonNode.path(fieldName).asText();
        } catch (IOException e) {
            throw new RuntimeException("IOException while parsing Json (" + data + ") to String");
        }
    }
}
