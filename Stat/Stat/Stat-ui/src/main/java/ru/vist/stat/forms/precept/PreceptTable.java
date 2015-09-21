/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.vist.stat.forms.precept;

import com.vaadin.ui.CustomTable;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.Reindeer;
import java.util.Date;
import org.tepi.filtertable.FilterTable;
import org.tepi.filtertable.FilterTreeTable;

/**
 *
 * @author chernov
 */
public class PreceptTable extends Panel {

    private Date dateStart;
    private Date dateEnd;

    public PreceptTable(Date dateStart, Date dateEnd) {
        this.dateEnd = dateEnd;
        this.dateStart = dateStart;

        FilterTreeTable filterTreeTable = buildFilterTreeTable();

        final VerticalLayout mainLayout = new VerticalLayout();
        mainLayout.setSizeFull();
        mainLayout.setSpacing(true);
        mainLayout.setMargin(true);
        mainLayout.addComponent(filterTreeTable);
        mainLayout.setExpandRatio(filterTreeTable, 1);
//        mainLayout.addComponent(Util.buildButtons((FilterTable)filterTreeTable));

        setStyleName(Reindeer.PANEL_LIGHT);
        setSizeFull();
        setContent(mainLayout);

    }

    private FilterTreeTable buildFilterTreeTable() {
        FilterTreeTable filterTable = new FilterTreeTable();
        filterTable.setSizeFull();

//        filterTable.setFilterDecorator(new FilterDecorator());
//      filterTable.setFilterGenerator(new FilterGenerator());
        filterTable.setFilterBarVisible(true);

        filterTable.setSelectable(true);
        filterTable.setImmediate(true);
        filterTable.setMultiSelect(true);

        filterTable.setRowHeaderMode(CustomTable.RowHeaderMode.INDEX);

        filterTable.setColumnCollapsingAllowed(true);

//        filterTable.setColumnCollapsed("state", true);

        filterTable.setColumnReorderingAllowed(true);

        filterTable.setContainerDataSource(new MyHierarchicalContainer(dateStart, dateEnd));

        filterTable.addGeneratedColumn("статус", new CustomTable.ColumnGenerator() {
            @Override
            public Object generateCell(CustomTable source, Object itemId,
                    Object columnId) {
                System.out.println("source = " + source);
                return source.getValue() + "testing";
            }
        });

//        filterTable.setVisibleColumns((Object[]) new String[]{"name", "id",            "foo", "state", "date", "validated", "checked"});
        return filterTable;
    }

}
