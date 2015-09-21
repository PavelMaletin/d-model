package ru.vist.stat.forms.precept;

import com.vaadin.ui.Button;
import com.vaadin.ui.VerticalLayout;
import cvr.vist.stat.common.Interval;
import cvr.vist.stat.comps.DateFilterArea;
import org.tepi.filtertable.FilterTable;

public class PreceptList extends VerticalLayout{
    private DateFilterArea dfa = new DateFilterArea(null, null, new ClkListener());
    private PreceptTable table;// = new PreceptTable();


    public PreceptList() {
        
        setMargin(true);
        setSizeFull();
        setSpacing(true);
        dfa.setDates(Interval.С_начала_года);
        table = new PreceptTable(dfa.getDateBegin(), dfa.getDateEnd());
        table.setSizeFull();
        addComponent(dfa);
//        table.setData(dfa);
        addComponent(table);
    }
    
    private class ClkListener implements Button.ClickListener {

        @Override
        public void buttonClick(Button.ClickEvent event) {
        }
    }
    
}
