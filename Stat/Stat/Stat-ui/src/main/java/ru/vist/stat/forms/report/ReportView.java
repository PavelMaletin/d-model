package ru.vist.stat.forms.report;

import ru.vist.stat.forms.CView;
import com.vaadin.server.FontAwesome;
import com.vaadin.ui.Label;
import cvr.vist.stat.basiccontrols.BasicLabel;

public class ReportView extends CView {
    public static String name = "Отчеты";

    public ReportView() {
        super();
    }


    public ReportView(String n) {
        name = n;
        setName(name);
    }

    @Override
    public void init() {
        setFa(FontAwesome.RECYCLE);
        Label label = new BasicLabel(getName());
        addComponent(label);    
    }

}
