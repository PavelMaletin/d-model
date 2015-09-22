package ru.vist.stat.db;

import ru.vist.model.domain.sys.User;
import ru.vist.stat.subs.CView;
import ru.vist.stat.forms.Common;
import java.util.ArrayList;
import java.util.List;
import ru.vist.stat.subs.Subs;
import ru.vist.stat.subs.Subscribe;

public class SetSubsDb {
    
    private static CView createView(final String name, final String className) {
        Class object = null;
        CView cv = null;
        try {
            object = Class.forName(className);
            cv = (CView) object.newInstance();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            System.out.println(" ex " + ex.getLocalizedMessage());
        }
        cv.setName(name);
        cv.init();
        return cv;
    }
    
    
    public static List<CView> getUserViews(User user) {
        if(user == null){
            Init.verifyUser("ГОСТЬ", "");
            user = Common.getUser();
        }
        List<CView> ret = new ArrayList<>();
        List<String> subs = user.getSubscriber().getSubs();
        for (String s : subs) {
            Subscribe subscribe = Subs.getSubscribe(s);
            String className = subscribe.getClazz().getName();
            ret.add(createView(subscribe.getName(), className));
        }
        return ret;
    }
}
