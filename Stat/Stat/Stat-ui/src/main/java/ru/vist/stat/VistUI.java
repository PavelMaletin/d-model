package ru.vist.stat;

import javax.servlet.annotation.WebServlet;

import ru.vist.stat.forms.MainScreen;
import ru.vist.stat.forms.authentication.AccessControl;
import ru.vist.stat.forms.authentication.BasicAccessControl;
import ru.vist.stat.forms.authentication.LoginScreen;
import ru.vist.stat.forms.authentication.LoginListener;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.annotations.Viewport;
import com.vaadin.annotations.Widgetset;
import com.vaadin.server.Responsive;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.UI;
import com.vaadin.ui.themes.ValoTheme;
import ru.vist.stat.db.Init;

@Viewport("user-scalable=no,initial-scale=1.0")
@Theme("vist")
@Widgetset("cvr.vist.stat.VistWidgetset")
public class VistUI extends UI {
    private static UI ui;
    private AccessControl accessControl = new BasicAccessControl();

    public static UI getUi() {
        return ui;
    }

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        
        Responsive.makeResponsive(this);
        setLocale(vaadinRequest.getLocale());
        getPage().setTitle("Vist");
        if (!accessControl.isUserSignedIn())
            setContent(new LoginScreen(accessControl, new LoginListener() {
                @Override
                public void loginSuccessful() {
                    showMainView();
                }
            }));
        else
            showMainView();
//        Init.initiateDB();
        ui = this;
    }

    protected void showMainView() {
        addStyleName(ValoTheme.UI_WITH_MENU);
        setContent(new MainScreen(VistUI.this));
        getNavigator().navigateTo(getNavigator().getState());
    }

    public static VistUI get() {
        return (VistUI) UI.getCurrent();
    }

    public AccessControl getAccessControl() {
        return accessControl;
    }

    public void setApplCaption(String caption) {
        getPage().setTitle("ПБ[" + caption + "]");
    }

    @WebServlet(urlPatterns = "/*", name = "VistUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = VistUI.class, productionMode = false)
    public static class VistUIServlet extends VaadinServlet {
    }
}
