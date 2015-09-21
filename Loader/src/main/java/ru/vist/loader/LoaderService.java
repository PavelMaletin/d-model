/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.vist.loader;

import javax.ejb.EJB;
import javax.jws.WebService;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import ru.vist.loader.sbean.IRef;

/**
 *
 * @author chernov
 */
@WebService(serviceName = "LoaderService")
@Stateless()
public class LoaderService {
    @EJB
    private IRef ejbRef;// Add business logic below. (Right-click in editor and choose
    // "Web Service > Add Operation"

    @WebMethod(operationName = "laod")
    public int laod() {
        return ejbRef.laod();
    }
    
}
