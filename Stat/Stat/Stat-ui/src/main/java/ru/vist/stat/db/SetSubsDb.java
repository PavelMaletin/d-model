package ru.vist.stat.db;

import com.vaadin.addon.jpacontainer.EntityItem;
import com.vaadin.addon.jpacontainer.EntityItemProperty;
import com.vaadin.addon.jpacontainer.JPAContainer;
import ru.vist.model.domain.sys.Subscribe;
import ru.vist.model.domain.sys.User;
import static ru.vist.stat.db.Init.getJpaSubscribe;
import ru.vist.stat.forms.CView;
import ru.vist.stat.forms.Common;
import java.util.ArrayList;
import java.util.List;

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
    
    public static List<CView> initSubs() {
        List<CView> ret = new ArrayList<>();
        JPAContainer<Subscribe> subsJPA = getJpaSubscribe();
        List<Object> itemIds = (List<Object>) subsJPA.getItemIds(0, subsJPA.size());
        for (Object o : itemIds) {
            EntityItem<Subscribe> item = subsJPA.getItem(o);
            EntityItemProperty nameProperty = item.getItemProperty("name");
            String name = (String) nameProperty.getValue();
            EntityItemProperty classNameProperty = item.getItemProperty("className");
            String className = (String) classNameProperty.getValue();
            ret.add(createView(name, className));
        }
        return ret;
    }
    
    public static List<CView> getUserViews(User user) {
        if(user == null){
            Init.verifyUser("ГОСТЬ", "");
            user = Common.getUser();
        }
        List<CView> ret = new ArrayList<>();
        List<Subscribe> subs = user.getSubscriber().getSubs();
        for (Subscribe s : subs) {
            String name = s.getName();
            String className = s.getClassName();
            ret.add(createView(name, className));
        }
        return ret;
    }
}
