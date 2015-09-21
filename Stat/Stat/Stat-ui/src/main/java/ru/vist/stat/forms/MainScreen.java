package ru.vist.stat.forms;

import ru.vist.stat.VistUI;

import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.HorizontalLayout;
import ru.vist.model.domain.sys.User;
import ru.vist.stat.db.SetSubsDb;
import java.util.List;

public class MainScreen extends HorizontalLayout {

    private Menu menu;
    private String name;

    public Menu getMenu() {
        return menu;
    }

    public MainScreen(VistUI ui) {

        setStyleName("main-screen");

        CssLayout viewContainer = new CssLayout();
        viewContainer.addStyleName("valo-content");
        viewContainer.setSizeFull();

        final Navigator navigator = new Navigator(ui, viewContainer);
        navigator.setErrorView(ErrorView.class);

//        List<CView> list = VistUI.getSubs().getList();
        User user = Common.getUser();
        List<CView> list = SetSubsDb.getUserViews(user);
        menu = new Menu(navigator);
        for (CView cv : list) {
            name = cv.getName();
            System.out.println(" name = " + name);

            menu.addView(cv, name, cv.getFa());
        }
        navigator.addViewChangeListener(viewChangeListener);

        addComponent(menu);
        addComponent(viewContainer);
        setExpandRatio(viewContainer, 1);
        setSizeFull();
    }

    ViewChangeListener viewChangeListener = new ViewChangeListener() {

        @Override
        public boolean beforeViewChange(ViewChangeEvent event) {
            return true;
        }

        @Override
        public void afterViewChange(ViewChangeEvent event) {
            menu.setActiveView(event.getViewName());
        }
    };
}
