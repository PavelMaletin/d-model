/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.vist.stat.db;

import ru.vist.model.domain.sys.Subscribe;
import ru.vist.model.domain.sys.Subscriber;
import ru.vist.model.domain.sys.User;
import ru.vist.model.domain.sys.UserRole;
import static ru.vist.stat.db.Init.findRefObject;
import static ru.vist.stat.db.Init.getJpaRole;
import static ru.vist.stat.db.Init.getJpaSubscribe;
import static ru.vist.stat.db.Init.getJpaSubscriber;
import static ru.vist.stat.db.Init.getJpaUser;
import ru.vist.stat.forms.order.OrderView;
import ru.vist.stat.forms.precept.PreceptView;
import ru.vist.stat.forms.precept1.Precept1View;
import ru.vist.stat.forms.ref.ReferenceView;
import ru.vist.stat.forms.report.ReportView;

/**
 *
 * @author chernov
 */
public class DefaultDbObjects {
    
    

    public static void createDefaultObjects() {
        Integer id = 1;
        String sid = (id++).toString();
        User guest;
        guest = (User) findRefObject(sid);
        if (guest == null)
            guest = new User(sid, "ГОСТЬ");

        sid = (id++).toString();
        UserRole roleGuest;
        roleGuest = (UserRole) findRefObject(sid);
        if (roleGuest == null)
            roleGuest = new UserRole(sid, "GUEST");
        
        guest.setUserRole(roleGuest);
        Subscriber subscriber = new Subscriber((id++).toString(), "Гостевая подписка");

        Subscribe s1 = new Subscribe((id++).toString(), ReferenceView.name, ReferenceView.class);
        Subscribe s2 = new Subscribe((id++).toString(), PreceptView.name, PreceptView.class);
        Subscribe s3 = new Subscribe((id++).toString(), Precept1View.name, Precept1View.class);
        Subscribe s4 = new Subscribe((id++).toString(), OrderView.name, OrderView.class);
        Subscribe s5 = new Subscribe((id++).toString(), ReportView.name, ReportView.class);

        subscriber.addSubs(s1, s2, s3, s4, s5);
        subscriber.setUser(guest);
        guest.setSubscriber(subscriber);

        getJpaRole().addEntity(roleGuest);
        getJpaRole().addEntity(new UserRole((id++).toString(), "superadmin"));
        getJpaRole().addEntity(new UserRole((id++).toString(), "ГОСТЬ"));
        getJpaUser().addEntity(guest);
        getJpaSubscriber().addEntity(subscriber);
        getJpaSubscribe().addEntity(s1);
        getJpaSubscribe().addEntity(s2);
        getJpaSubscribe().addEntity(s3);
        getJpaSubscribe().addEntity(s4);
        getJpaSubscribe().addEntity(s5);

        getJpaRole().commit();
        getJpaUser().commit();
        getJpaSubscribe().commit();
        getJpaSubscriber().commit();

        System.out.println(" Создано " + id + " сиcтемных объектов ");
    }
    
}
