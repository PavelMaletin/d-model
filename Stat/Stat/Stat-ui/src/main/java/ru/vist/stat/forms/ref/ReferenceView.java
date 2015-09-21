package ru.vist.stat.forms.ref;

import ru.vist.stat.forms.CView;
import com.vaadin.server.FontAwesome;
import com.vaadin.ui.Label;
import cvr.vist.stat.basiccontrols.BasicLabel;

public class ReferenceView extends CView {
    public static String name = "Справочники";

    public ReferenceView() {
        super();
    }


    public ReferenceView(String n) {
        name = n;
        setName(name);
        setFa(FontAwesome.MAP_MARKER);
        Label label = new BasicLabel(getName());
        addComponent(label);
    }

    @Override
    public void init() {
        setFa(FontAwesome.ANDROID);
        Label label = new BasicLabel(getName());
        addComponent(label);    
    }

}
