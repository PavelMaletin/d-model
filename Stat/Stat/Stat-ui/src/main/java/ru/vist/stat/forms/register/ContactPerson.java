package ru.vist.stat.forms.register;

import ru.vist.stat.forms.Common;
import com.vaadin.data.Property;
import com.vaadin.data.Property.ValueChangeListener;
import com.vaadin.ui.Button;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Panel;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.TextField;
import ru.vist.model.domain.ref.Post;
import ru.vist.model.domain.sys.User;
import ru.vist.model.domain.ref.Worker;
import ru.vist.model.domain.sys.UserRole;
//import cvr.vist.ref.model.domain.ref.Post;
//import cvr.vist.ref.model.domain.ref.User;
//import cvr.vist.ref.model.domain.ref.Worker;
import cvr.vist.stat.quickforms.QuickForm;
import cvr.vist.stat.common.Utils;
import ru.vist.stat.db.Init;
import ru.vist.stat.db.StringLists;
import java.util.UUID;

public class ContactPerson extends Panel {

    private final TabSheet sheet;
    private final SignupForm sf = new SignupForm("", "");
    private final QuickForm af = new QuickForm(sf);
//    private final ContainerUtils container = Config.getContainer();
    private final GridLayout gridLayout = (GridLayout) af.getComponent(1);

    private final ComboBox cbFam = (ComboBox) gridLayout.getComponent(0, 0);
    private final ComboBox cbIm = (ComboBox) gridLayout.getComponent(1, 0);
    private final ComboBox cbOtch = (ComboBox) gridLayout.getComponent(2, 0);

    private final TextField txtEmail = (TextField) gridLayout.getComponent(0, 1);
    private final TextField txtPhone = (TextField) gridLayout.getComponent(0, 2);
    private final ComboBox cbPost = (ComboBox) gridLayout.getComponent(0, 3);
    private final TextField txtLogin = (TextField) gridLayout.getComponent(0, 4);
    private final PasswordField txtPassword1 = (PasswordField) gridLayout.getComponent(1, 4);
    private final PasswordField txtPassword2 = (PasswordField) gridLayout.getComponent(2, 4);
    private String fam, otch, im, eMail, postName, pass1, pass2, phones, login;

    public ContactPerson(TabSheet sheet) {
        this.sheet = sheet;
//        setCaption("Информация о пользователе");

        cbIm.setNewItemsAllowed(true);
        cbIm.addItems(StringLists.getAlIm());

        cbOtch.setNewItemsAllowed(true);
        cbOtch.addItems(StringLists.getAlOtch());

        cbFam.setNewItemsAllowed(true);
        cbFam.addItems(StringLists.getAlFam());

        cbPost.setNewItemsAllowed(true);
        cbPost.addItems(StringLists.getAlPost());

        txtEmail.addValueChangeListener(new EmailValChgListener());
        txtPhone.addValueChangeListener(new ValChgListener());
        cbIm.addValueChangeListener(new ValChgListener());
        cbOtch.addValueChangeListener(new ValChgListener());
        cbFam.addValueChangeListener(new ValChgListener());

        txtLogin.addValueChangeListener(new ValChgListener());
        txtPassword1.addValueChangeListener(new ValChgListener());
        txtPassword2.addValueChangeListener(new ValChgListener());

        af.setMargin(true);
        af.getUiBtnCommit().addClickListener(new OkBtnListener());
        af.getUiBtnCommit().setEnabled(false);
        setContent(af);
    }

    private boolean validate() {
        boolean ret = false;
        pass1 = txtPassword1.getValue();
        pass2 = txtPassword2.getValue();
        im = cbIm.getValue().toString();
        otch = cbOtch.getValue().toString();
        fam = cbFam.getValue().toString();
        eMail = txtEmail.getValue();
        phones = txtPhone.getValue();
        postName = cbPost.getValue().toString();
        login = txtLogin.getValue();

        ret = (pass1.equals(pass2))
                && !pass2.isEmpty()
                && !fam.isEmpty()
                && !im.isEmpty()
                && !otch.isEmpty();

        af.getUiBtnCommit().setEnabled(ret);
        return ret;
    }

    class ValChgListener implements ValueChangeListener {

        @Override
        public void valueChange(Property.ValueChangeEvent event) {
            validate();
        }
    }

    class EmailValChgListener implements ValueChangeListener {

        @Override
        public void valueChange(Property.ValueChangeEvent event) {
            txtLogin.setValue(txtEmail.getValue());
            validate();
        }
    }

    class OkBtnListener implements Button.ClickListener {

        @Override
        public void buttonClick(Button.ClickEvent event) {
            String uuid = Init.newUUID();
            Worker worker = new Worker(uuid, fam, im, otch);
            worker.setE_mail(eMail);
            worker.setPhones(phones);

            uuid = UUID.randomUUID().toString();
            User user = new User(uuid, login);
            user.setPassword(pass1);
            UserRole userRole = (UserRole) Init.findRefObject("admin", "USERROLE");
            user.setUserRole(userRole);
            user.setWorker(worker);
            worker.setUser(user);

            Post post = Init.findOrCreatePost(postName);
            worker.setPost(post);

            Init.getJpaWorker().addEntity(worker);
            Init.getJpaWorker().commit();
            Init.getJpaUser().addEntity(user);
            Init.getJpaUser().commit();

            Common.setUser(user);
            Common.setWorker(worker);
            af.getUiBtnCommit().setEnabled(false);
            sheet.getTab(0).setEnabled(false);
            sheet.getTab(1).setEnabled(true);
            sheet.setSelectedTab(1);
            Utils.showNotification(new Notification("Пользователь [" + worker.getName()+"] создан", Notification.Type.TRAY_NOTIFICATION));

        }
    }
}
