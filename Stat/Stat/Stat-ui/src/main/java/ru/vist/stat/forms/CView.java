package ru.vist.stat.forms;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.FontAwesome;
import com.vaadin.ui.VerticalLayout;

public abstract class CView extends VerticalLayout implements View {

    protected String name;
    protected FontAwesome fa;
    protected Class clazz;
    
    public abstract void init();

    public CView(String name,Class c) {
        this.name = name;        
        this.clazz = c;
    }

    public CView() {
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
    }

    public String getName() {
        return name;
    }

    public void setName(String n) {
        name = n;
    }

    public FontAwesome getFa() {
        return fa;
    }

    public void setFa(FontAwesome fa) {
        this.fa = fa;
    }

}
