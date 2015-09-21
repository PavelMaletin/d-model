package cvr.vist.stat.comps;

import com.vaadin.data.Item;
import com.vaadin.data.Property;
import java.util.Collection;
import com.vaadin.data.util.BeanItem;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.data.util.MethodProperty;
import com.vaadin.ui.Grid;
//import cvr.vist.model.domain.doc.Precept;

public class VarHeightRowGrid extends Grid {

    BeanItemContainer bic = null;

    public VarHeightRowGrid(final BeanItemContainer bic) {
        this.bic = bic;
        this.setId("Grid");
        setSizeFull();
        setSelectionMode(SelectionMode.SINGLE);
        setContainerDataSource(bic);
        setEditorEnabled(true);
        setFooterVisible(true);
        setColumnReorderingAllowed(true);
        Grid.Column column = this.getColumn("description");

        this.setStyleName("mygrid");
        this.setRowStyleGenerator(new RowStyleGenerator() {

            @Override
            public String getStyle(RowReference rowReference) {
                Item item = rowReference.getItem();
                Property itemProperty = item.getItemProperty("clog");
                if (itemProperty == null)
                    return null;
                Integer extraHeight = Integer.parseInt(itemProperty.getValue().toString());
                if (extraHeight == null)
                    return null;
                Object value = itemProperty.getValue();
                Integer shift = calculateRowShift(bic.indexOfId(rowReference.getItemId()));
                String style = "";

                if (extraHeight > 1)
                    style += "v-special-height-row-" + extraHeight + " ";
                if (shift > 0)
                    style += "v-special-positioned-row-" + shift;
                return style.equals("") ? null : style.trim();

            }

            private Integer calculateRowShift(int index) {
                int sum = 0;
                for (int i = 0; i < index; i++)
                    sum += (Short) (bic.getItem(bic.getIdByIndex(i)).getItemProperty("clog").getValue()) - 1;
                System.out.println("index = " + index + "   sum =   " + sum);
                return sum;
            }
        });

    }

    public void setDataSet(final BeanItemContainer bic) {
        setContainerDataSource(bic);
    }

    public void setFilter(String filterString) {
//        getContainer().removeAllContainerFilters();
//        if (filterString.length() > 0) {
//            SimpleStringFilter nameFilter = new SimpleStringFilter(
//                    "productName", filterString, true, false);
//            SimpleStringFilter availabilityFilter = new SimpleStringFilter(
//                    "availability", filterString, true, false);
//            SimpleStringFilter categoryFilter = new SimpleStringFilter(
//                    "category", filterString, true, false);
//            getContainer().addContainerFilter(
//                    new Or(nameFilter, availabilityFilter, categoryFilter));
//        }

    }

//    private BeanItemContainer<Precept> getContainer() {
//        return (BeanItemContainer<Precept>) super.getContainerDataSource();
//    }
//
//    @Override
//    public Precept getSelectedRow() throws IllegalStateException {
//        return (Precept) super.getSelectedRow();
//    }
//    public void setProducts(Collection<Precept> products) {
//        getContainer().removeAllItems();
//        getContainer().addAll(products);
//    }
//
//    public void refresh(Precept precept) {
//        BeanItem<Precept> item = getContainer().getItem(precept);
//        if (item != null) {
//            MethodProperty p = (MethodProperty) item.getItemProperty("id");
//            p.fireValueChange();
//        } else
//            getContainer().addBean(precept);
//    }
//
//    public void remove(Precept product) {
//        getContainer().removeItem(product);
//    }
}
