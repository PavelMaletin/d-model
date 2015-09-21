/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.vist.stat.forms.authentication;

import java.io.Serializable;

/**
 *
 * @author chernov
 */
public interface LoginListener extends Serializable {

    void loginSuccessful();
    
}
