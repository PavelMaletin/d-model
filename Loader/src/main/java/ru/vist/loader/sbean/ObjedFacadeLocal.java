/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.vist.loader.sbean;

import ru.vist.loader.src.Objed;
import java.util.List;
import javax.ejb.Local;
import javax.persistence.EntityManager;

/**
 *
 * @author chernov
 */
@Local
public interface ObjedFacadeLocal {

    void create(Objed objed);

    void edit(Objed objed);

    void remove(Objed objed);

    Objed find(Object id);

    List<Objed> findAll();

    List<Objed> findRange(int[] range);

    int count();

    public EntityManager getEntityManager();
}
