package ru.vist.stat.forms.register;

import com.vaadin.ui.TabSheet;
import com.vaadin.ui.UI;
import com.vaadin.ui.Window;
import com.vaadin.ui.themes.ValoTheme;

public class RegistrationDlg extends Window {

    private final TabSheet sheet = new TabSheet();

    public RegistrationDlg(UI ui) {
        setModal(true);
        setCaption("Регистрация нового пользователя");
        final float height = ui.getHeight() * 0.7f;
        final float width = ui.getWidth() * 0.5f;
        setHeight(height, Unit.PERCENTAGE);
        setWidth(width, Unit.PERCENTAGE);
        center();
        init();
        ui.addWindow(this);
    }

    private void init() {
        sheet.addStyleName(ValoTheme.TABSHEET_FRAMED);
        sheet.addStyleName(ValoTheme.TABSHEET_PADDED_TABBAR);
        sheet.addComponent(new  ContactPerson(sheet));
        sheet.addComponent(new  ContactProdUnit(sheet));
        sheet.addComponent(new  SubSciption  (this));
        sheet.getTab(0).setCaption("Информация о пользователе");
        sheet.getTab(1).setCaption("Информация о предприятии");
        sheet.getTab(1).setEnabled(false);
        sheet.getTab(2).setCaption("Подписки");
        sheet.getTab(2).setEnabled(false);
        this.setContent(sheet);
    }

}
