/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cvr.vist.stat.comps;

import com.vaadin.data.Property;
import com.vaadin.shared.ui.datefield.Resolution;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.CheckBox;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.DateField;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.JavaScript;
import com.vaadin.ui.Label;
import cvr.vist.stat.common.Interval;
import java.util.Calendar;
import java.util.Date;
import org.apache.commons.lang3.time.DateUtils;


/**
 *
 * @author chernov
 */
public class DateFilterArea extends GridLayout {

    private final DateField dateFrom = new DateField();
    private final DateField dateTo = new DateField();
    private final ComboBox bcbInterval = new ComboBox();
    private final CheckBox chgExecuted = new CheckBox(" включая выполненные");

    public DateFilterArea(Date dateMin, Date dateMax, ClickListener clickListener) {
        super(5, 2);
        this.setDefaultComponentAlignment(Alignment.MIDDLE_RIGHT);
        this.setSpacing(true);
        Label bl = new Label("Период :");
        this.addComponent(bl, 0, 0);
        dateFrom.setValue(new Date());
        dateFrom.setResolution(Resolution.DAY);
        dateFrom.setRangeStart(dateMin);
        this.addComponent(dateFrom, 1, 0);
        dateTo.setValue(new Date());
        dateTo.setResolution(Resolution.DAY);
        dateTo.setRangeEnd(dateMax);
        this.addComponent(dateTo, 2, 0);
        this.addComponent(chgExecuted, 3, 0, 4, 0);
        Label bl1 = new Label("Отрезок времени :");
        this.addComponent(bl1, 0, 1);
        bcbInterval.setNullSelectionAllowed(false);
        bcbInterval.setWidth("100%");
        this.addComponent(bcbInterval, 1, 1, 2, 1);
        Button bbFilter = new Button("Фильтр");
        this.addComponent(bbFilter, 3, 1);
        Button bbCancel = new Button("Очистить");
        this.addComponent(bbCancel, 4, 1);
        bcbInterval.addItems(Interval.Со_вчерашнего_дня.toString(), Interval.С_начала_недели.toString(), Interval.С_начала_месяца.toString(), Interval.С_начала_года.toString());
        bcbInterval.addValueChangeListener(new Property.ValueChangeListener() {
            @Override
            public void valueChange(Property.ValueChangeEvent event) {
                Interval interval = Interval.valueOf(bcbInterval.getValue().toString());
                setDates(interval);

            }
        });
        bbFilter.addClickListener(clickListener);
        dateFrom.addListener(new Listener() {

            @Override
            public void componentEvent(Event event) {
                dateTo.setRangeStart(dateFrom.getValue());
            }
        });
        dateTo.addListener(new Listener() {

            @Override
            public void componentEvent(Event event) {
                dateFrom.setRangeEnd(dateTo.getValue());
            }
        });
    }

    public void setDates(Interval interval) { 
        bcbInterval.setValue(interval.toString());
        dateTo.setValue(new Date());
        dateFrom.setValue(Interval.getStartDate(interval));
    }
    
    public boolean withExecuted(){
        return chgExecuted.getValue();
    } 

    public Date getDateBegin() {
        
        return DateUtils.truncate(dateFrom.getValue(),Calendar.DATE);
    }

    public Date getDateEnd() {
        return DateUtils.truncate(dateTo.getValue(),Calendar.DATE);
    }

}
