/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.vist.stat.subs;

/**
 *
 * @author chernov
 */
public class Subscribe {

    /**
     *
     * @param code
     * @param name
     * @param clazz
     */
    public Subscribe(String code, String name, Class<? extends  CView> clazz) {
        this.code = code;
        this.name = name;
        this.clazz = clazz;
    }
    
    private String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private Class<? extends CView> clazz;

    public Class getClazz() {
        return clazz;
    }

    public void setClazz(Class clazz) {
        this.clazz = clazz;
    }

    
}
