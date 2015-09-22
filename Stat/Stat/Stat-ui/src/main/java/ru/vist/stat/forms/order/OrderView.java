package ru.vist.stat.forms.order;

import ru.vist.stat.subs.CView;
import com.vaadin.server.FontAwesome;
import com.vaadin.ui.Label;
import cvr.vist.stat.basiccontrols.BasicLabel;

public class OrderView extends CView {
    public static String name = "Наряд-задания22";

    public OrderView() {
        super();

    }

    public OrderView(String n) {
        name = n;
        setName(name);
//        Label label = new BasicLabel(getName());
//        addComponent(label);
    }
    @Override
    public void init() {
        setFa(FontAwesome.RECYCLE);
        Label label = new BasicLabel(getName());
        addComponent(label);    
    }
}
