package ru.vist.stat.forms.precept;

import com.vaadin.data.util.IndexedContainer;
import ru.vist.model.domain.doc.Precept;
import ru.vist.model.domain.ref.ProdUnit;
import ru.vist.model.domain.ref.Worker;
import ru.vist.stat.db.PreceptUtils;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.apache.commons.lang3.time.DateUtils;

public class MyHierarchicalContainer extends IndexedContainer {

    public MyHierarchicalContainer(Date dateStart, Date dateEnd) {
        List<Precept> list = PreceptUtils.findPreceptDateInterval(dateStart, dateEnd);

        Calendar c = Calendar.getInstance();

        this.addContainerProperty("Дата", Date.class, null);
        this.addContainerProperty("Срок исполнения", Date.class, null);
        this.addContainerProperty("Подразделение", ProdUnit.class, null);
        this.addContainerProperty("Объект участка", String.class, null);
        this.addContainerProperty("Объект", String.class, null);
        this.addContainerProperty("Описание", String.class, null);
        this.addContainerProperty("Исполнитель", Worker.class, null);
        int i = 0;
        for (Precept precept : list) {
            this.addItem(i);
            Date issueDate =  DateUtils.round( precept.getIssueDate(),Calendar.DATE);
            this.getContainerProperty(i, "Дата").setValue(issueDate);
            this.getContainerProperty(i, "Срок исполнения").setValue(precept.getExecDate());
            this.getContainerProperty(i, "Подразделение").setValue(precept.getProdUnit());
            this.getContainerProperty(i, "Объект участка").setValue(precept.getOperand());
            this.getContainerProperty(i, "Объект").setValue(precept.getSubOperand());
            this.getContainerProperty(i, "Описание").setValue(precept.getDescription());
            this.getContainerProperty(i, "Исполнитель").setValue(precept.getExecutor());
            i++;
        }
    }
}
