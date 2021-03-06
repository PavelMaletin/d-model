/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.vist.loader.sbean;

import ru.vist.loader.src.Objed;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author chernov
 */
@Stateless
public class ObjedFacade extends AbstractFacade<Objed> implements ObjedFacadeLocal {
    @PersistenceContext(unitName = "SRC_PU")
    private EntityManager em;

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    public ObjedFacade() {
        super(Objed.class);
    }
    
}
