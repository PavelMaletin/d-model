/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.vist.stat.db;

import ru.vist.model.domain.doc.Precept;
import ru.vist.model.types.RecStatus;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author chernov
 */
public class PreceptUtils {
    private static final EntityManager em = Init.getEm();
    
    public static List<Precept> findPreceptDateInterval(Date dateStart, Date dateEnd) {
        List<Precept> list = new ArrayList<>();
        Query qwr = em.createNamedQuery("Precept.findDateInterval");
        qwr.setParameter("dateBegin", dateStart);
        qwr.setParameter("dateEnd", dateEnd);
        qwr.setParameter("status", RecStatus.ACTIVE);
        list = qwr.getResultList();
        return list;
    }

    public static EntityManager getEM() {
        return em;
    }
    
}
