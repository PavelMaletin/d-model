package ru.vist.stat.forms.precept1;

import com.vaadin.data.util.BeanItemContainer;
import ru.vist.stat.subs.CView;
import com.vaadin.server.FontAwesome;
import com.vaadin.ui.Button;
import cvr.vist.stat.comps.DateFilterArea;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Grid;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.VerticalLayout;
import ru.vist.model.domain.doc.Precept;
import cvr.vist.stat.common.Interval;
import ru.vist.stat.db.PreceptUtils;
import java.util.Date;
import java.util.List;

public class Precept1View extends CView {

    public static String name = "Предписания(Table33)";
    
    VerticalLayout layList = new VerticalLayout();
    VerticalLayout layDetail = new VerticalLayout();
    TabSheet sheet = new TabSheet();
    DateFilterArea dfa = new DateFilterArea(null, null, new ClkListener());
    HorizontalLayout topLayout = new HorizontalLayout();
    private Grid grid = null;
    VerticalLayout barAndGridLayout = new VerticalLayout();

    public Precept1View() {
        super();
        addComponent(sheet);
        sheet.addTab(layList);
        sheet.addTab(layDetail);
        topLayout.setSpacing(true);
        topLayout.setWidth("100%");
        topLayout.setStyleName("top-bar");
//        topLayout.addComponent(filterPanel());
        dfa.setDates(Interval.С_начала_года);
        topLayout.addComponent(dfa);
        layList.addComponent(topLayout);
        layList.addComponent(barAndGridLayout);
    }

//    public HorizontalLayout createTopBar() {
//        return topLayout;
//    }
    private BeanItemContainer<Precept> setFilter() {
        Date dateBegin = dfa.getDateBegin();
        Date dateEnd = dfa.getDateEnd();
        addComponent(dfa);
        List<Precept> precepts = PreceptUtils.findPreceptDateInterval(dateBegin, dateEnd);
        BeanItemContainer<Precept> bic = new BeanItemContainer<>(Precept.class, precepts);
        return bic;
    }

    @Override
    public void init() {
        setMargin(true);
        setFa(FontAwesome.APPLE);
        setSizeFull();
        addStyleName("crud-view");
//        HorizontalLayout topLayout = createTopBar();
        List<Precept> precepts = PreceptUtils.findPreceptDateInterval(dfa.getDateBegin(), dfa.getDateEnd());
        BeanItemContainer<Precept> bic = new BeanItemContainer<>(Precept.class, precepts);

        grid = new Grid(name, bic);
        grid.setSizeFull();
        grid.setSelectionMode(Grid.SelectionMode.SINGLE);
        grid.setContainerDataSource(bic);
        grid.setEditorEnabled(true);
        grid.setFooterVisible(true);

        barAndGridLayout.addComponent(topLayout);
        barAndGridLayout.addComponent(grid);
        barAndGridLayout.setMargin(true);
        barAndGridLayout.setSpacing(true);
        barAndGridLayout.setSizeFull();
        barAndGridLayout.setExpandRatio(grid, 1);
        barAndGridLayout.setStyleName("crud-main-layout");
        addComponent(barAndGridLayout);
    }

    private class ClkListener implements ClickListener {

        @Override
        public void buttonClick(Button.ClickEvent event) {
//            BeanItemContainer<Precept> bic = setFilter();
//            grid.setData(bic);
            init();
        }
    }
}
