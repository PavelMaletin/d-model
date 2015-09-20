/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.vist.model.utils;

import java.io.IOException;
import org.codehaus.jackson.map.ObjectMapper;
/**
 *
 * @author chernov
 */
public class JSON<T> {

    /**
     *
     * @param entity
     * @return
     */
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
