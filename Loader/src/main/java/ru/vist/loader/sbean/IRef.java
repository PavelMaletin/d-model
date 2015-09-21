/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.vist.loader.sbean;

import ru.vist.model.domain.ref.Reference;
import javax.ejb.Local;

/**
 *
 * @author chernov
 */
@Local
public interface IRef {

//    Reference find(String id);
//
//    int loadRefs();
//
//    int loadDocs();

    int laod();
}
