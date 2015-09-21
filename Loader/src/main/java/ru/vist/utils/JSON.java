package ru.vist.utils;

import java.io.IOException;
import org.codehaus.jackson.map.ObjectMapper;

public class JSON<T> {

    public String JsonForEntity(T entity) {
        ObjectMapper mapper = new ObjectMapper();
        String ret="";
        try {
            ret = mapper.writeValueAsString(entity);
        } catch (IOException ex) {
            System.out.println("***** JsonForEntity ERROR: " + ex.getLocalizedMessage());
        }
        return ret;
    }
}
