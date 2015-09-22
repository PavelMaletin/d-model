/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.vist.stat.forms.register;

import ru.vist.stat.forms.Common;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.CheckBox;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import ru.vist.model.domain.sys.Subscriber;
import ru.vist.model.domain.sys.User;
import cvr.vist.stat.basiccontrols.BasicButton;
import cvr.vist.stat.basiccontrols.BasicHorizontalLayout;
import cvr.vist.stat.common.Utils;
import ru.vist.stat.db.Init;
import ru.vist.stat.db.SetSubsDb;
import ru.vist.stat.subs.CView;
import java.util.ArrayList;
import java.util.List;
import ru.vist.stat.subs.Subs;
import ru.vist.stat.subs.Subscribe;

/**
 *
 * @author chernov
 */
public class SubSciption extends Panel {

    private final Window window;
    private final List<CheckBox> boxes = new ArrayList<>();

    public SubSciption(final Window window) {
        this.window = window;
        VerticalLayout layout = new VerticalLayout();
        setCaption("Доступные подписки");
        layout.setMargin(true);
        List<CView> list = SetSubsDb.getUserViews( Common.getUser()); //VistUI.getSubs().getList();
        for (CView cv : list) {
            CheckBox box = new CheckBox(cv.getName());
            box.setValue(Boolean.TRUE);
            layout.addComponent(box);
            boxes.add(box);
        }
        HorizontalLayout hl = new BasicHorizontalLayout();
        BasicButton btnSave = new BasicButton("Сохранить", "Записать выбранные подписки ");
        btnSave.addClickListener(new SaveClickListener());
        hl.addComponent(btnSave);
        BasicButton btnCancel = new BasicButton("Отменить", "Закрыть форму");
        hl.addComponent(btnCancel);
        btnCancel.addClickListener(new CancelClickListener());
        layout.addComponent(hl);
        setContent(layout);
    }

    private class CancelClickListener implements ClickListener {

        @Override
        public void buttonClick(Button.ClickEvent event) {
            window.close();
        }
    }

    private class SaveClickListener implements ClickListener {

        @Override
        public void buttonClick(Button.ClickEvent event) {
            Utils.showNotification(new Notification("Пользователю назначены права", Notification.Type.TRAY_NOTIFICATION));

            Subscriber subscriber = new Subscriber(Init.newUUID(), Common.getWorker().getName());
            subscriber.setUser(Common.getUser());
            User user = Common.getUser();
            user.setSubscriber(subscriber);
            Init.getJpaUser().addEntity(user);
            subscriber.setProdUnit(Common.getProdUnit());
            List<String> ses = new ArrayList<>();
            for(CheckBox box : boxes){
                if(box.getValue()){
                    String caption = box.getCaption();
                    String s = Subs.getSubCode(caption);
                    ses.add(s);
                }
            }
            subscriber.setSubs(ses);
            Init.getJpaSubscriber().addEntity(subscriber);
            window.close();
        }
    }

}
