package vist.stat.vaadinjpacontainertest;

import com.vaadin.addon.jpacontainer.JPAContainer;
import com.vaadin.addon.jpacontainer.JPAContainerFactory;
import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.annotations.Widgetset;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.shared.ui.grid.HeightMode;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Grid;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import ru.vist.model.domain.ref.Reference;
import ru.vist.model.types.RecStatus;

/**
 *
 */
@Theme("mytheme")
@Widgetset("vist.stat.vaadinjpacontainertest.MyAppWidgetset")
public class MyUI extends UI {

    private final JPAContainer<Reference> jpaPost = JPAContainerFactory.make(Reference.class, "vist.stat_VaadinJPAContainerTest_war_1.0PU");
    private final EntityManager em = jpaPost.getEntityProvider().getEntityManager();

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        final VerticalLayout layout = new VerticalLayout();
        layout.setMargin(true);
        setContent(layout);

        Button button = new Button("Click Me");
//        button.addClickListener(new Button.ClickListener() {
//            @Override
//            public void buttonClick(ClickEvent event) {
//                Query qwr = em.createNamedQuery("Reference.findActual");
//                qwr.setParameter("status", RecStatus.ACTIVE);
//                List<Reference> resultList = qwr.getResultList();
//                for (Reference post : resultList)
//                    layout.addComponent(new Label(post.getName()));
//            }
//        });
        layout.addComponent(showGrid());
        layout.addComponent(button);
    }

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }

    private Grid showGrid() {
        Grid grid = new Grid("Справочник", jpaPost);
        grid.setSizeFull();
        
        return grid;
    }
}
