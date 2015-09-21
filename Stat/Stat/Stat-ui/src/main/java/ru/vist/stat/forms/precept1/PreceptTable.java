/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.vist.stat.forms.precept1;

import com.vaadin.ui.Table;

/**
 *
 * @author chernov
 */
public class PreceptTable extends Table{

    public PreceptTable() {
        this.setRowGenerator(new RowGenerator() {

            @Override
            public GeneratedRow generateRow(Table table, Object itemId) {
                GeneratedRow gr = new GeneratedRow("","");
                return  gr;
            }
        });
    }
    
}
