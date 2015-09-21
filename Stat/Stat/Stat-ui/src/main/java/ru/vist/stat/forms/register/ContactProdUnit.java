package ru.vist.stat.forms.register;

import ru.vist.stat.forms.Common;
import com.vaadin.data.Property;
import com.vaadin.ui.Button;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Panel;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.TextField;
import com.vaadin.ui.Window;
import ru.vist.model.domain.ref.Post;
import ru.vist.model.domain.ref.ProdUnit;
import ru.vist.model.domain.ref.Worker;

import cvr.vist.stat.quickforms.QuickForm;
import cvr.vist.stat.common.Utils;
import ru.vist.stat.db.Init;
import ru.vist.stat.db.StringLists;

public class ContactProdUnit extends Panel {

    private final SignupFormProdUnit sf = new SignupFormProdUnit();
    private final QuickForm af = new QuickForm(sf);
//    private final ContainerUtils container = Config.getContainer();
    private final GridLayout gridLayout = (GridLayout) af.getComponent(1);

    private final TextField txtName = (TextField) gridLayout.getComponent(0, 0);
    private final TextField txtAddress = (TextField) gridLayout.getComponent(0, 1);

    private final ComboBox cbProdType = (ComboBox) gridLayout.getComponent(0, 2);
    private final ComboBox cbIndustry = (ComboBox) gridLayout.getComponent(1, 2);
    private final ComboBox cbProductionType = (ComboBox) gridLayout.getComponent(2, 2);

    private final ComboBox cbFam = (ComboBox) gridLayout.getComponent(0, 3);
    private final ComboBox cbIm = (ComboBox) gridLayout.getComponent(1, 3);
    private final ComboBox cbOtch = (ComboBox) gridLayout.getComponent(2, 3);

    private final ComboBox cbPost = (ComboBox) gridLayout.getComponent(0, 4);

    private String name;
    private String address;
    private String fam, im, otch;
    private String postName;
    private String typePred;
    private final TabSheet sheet;

    public ContactProdUnit(TabSheet sheet) {
        this.sheet = sheet;
//        setCaption("Информация о предприятии");
        cbPost.setNewItemsAllowed(true);
        cbPost.addItems(StringLists.getAlPost());
        af.setMargin(true);
        af.getUiBtnCommit().addClickListener(new OkBtnListener());
        af.getUiBtnCommit().setEnabled(false);

        cbPost.addValueChangeListener(new ValChgListener());
        txtName.addValueChangeListener(new ValChgListener());
        txtAddress.addValueChangeListener(new ValChgListener());
        cbIm.addValueChangeListener(new ValChgListener());
        cbOtch.addValueChangeListener(new ValChgListener());
        cbFam.addValueChangeListener(new ValChgListener());

        cbProdType.addItems("Объединение", "Предприятие");
        cbIndustry.addItems("Угледобыча", "НефтеГазовая", "Металлургия");
        cbProductionType.addItems("Открытая разработка", "Подземные работы", "Обогащение");
        cbIm.setNewItemsAllowed(true);
        cbIm.addItems(StringLists.getAlIm());

        cbOtch.setNewItemsAllowed(true);
        cbOtch.addItems(StringLists.getAlOtch());

        cbFam.setNewItemsAllowed(true);
        cbFam.addItems(StringLists.getAlFam());

        setContent(af);
    }

    private void validate() {
        name = txtName.getValue();
        address = txtAddress.getValue();
        fam = cbIm.getValue().toString();
        im = cbOtch.getValue().toString();
        otch = cbFam.getValue().toString();
        postName = cbPost.getValue().toString();
        typePred = cbProdType.getValue().toString();
        boolean ret = !name.isEmpty()
                && !address.isEmpty()
                && !fam.isEmpty()
                && !im.isEmpty()
                && !otch.isEmpty()
                && !postName.isEmpty();
        af.getUiBtnCommit().setEnabled(ret);
    }

    class ValChgListener implements Property.ValueChangeListener {

        @Override
        public void valueChange(Property.ValueChangeEvent event) {
            validate();
        }

    }

    class OkBtnListener implements Button.ClickListener {

        @Override
        public void buttonClick(Button.ClickEvent event) {
            String uuid = Init.newUUID();
            String industry = cbIndustry.getValue().toString();
            String production = cbProductionType.getValue().toString();

            Worker worker = new Worker(uuid, otch, fam, im);
            Post post = Init.findOrCreatePost(postName);
            worker.setPost(post);
            Init.getJpaWorker().addEntity(worker);
            Init.getJpaWorker().commit();
            ProdUnit prodUnit = Init.findOrCreateProdUnit(name, typePred);
            prodUnit.setAddress(address);
            prodUnit.setChef(worker);
            prodUnit.setIndustry(industry);
            prodUnit.setProductionType(production);
            Init.getProdUnits().addEntity(prodUnit);
            Init.getProdUnits().commit();
            af.getUiBtnCommit().setEnabled(false);
            Utils.showNotification(new Notification("Предприятие [" + prodUnit.getName()+"] создано", Notification.Type.TRAY_NOTIFICATION));
            Common.setProdUnit(prodUnit);
            sheet.getTab(0).setEnabled(false);
            sheet.getTab(1).setEnabled(false);
            sheet.getTab(2).setEnabled(true);
            sheet.setSelectedTab(2);
        }
    }
}
