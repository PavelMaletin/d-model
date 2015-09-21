/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.vist.stat.forms;

import ru.vist.model.domain.ref.ProdUnit;
import ru.vist.model.domain.ref.Worker;
import ru.vist.model.domain.sys.User;

/**
 *
 * @author chernov
 */
public class Common {
    private static User user;
    private static Worker worker;
    private static  ProdUnit prodUnit;

    public static User getUser() {
        return user;
    }

    public static void setUser(User user) {
        Common.user = user;
    }

    public static Worker getWorker() {
        return worker;
    }

    public static void setWorker(Worker worker) {
        Common.worker = worker;
    }

    public static ProdUnit getProdUnit() {
        return prodUnit;
    }

    public static void setProdUnit(ProdUnit prodUnit) {
        Common.prodUnit = prodUnit;
    }
    
}
