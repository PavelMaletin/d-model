package ru.vist.model.domain.ref;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "BRIGADE",schema = "AW_STAT")
@DiscriminatorValue("BRIGADE")
public class Brigade extends ProdUnit {

    public Brigade() {
    }

    public Brigade(String id, String name) {
        super(id, name);
    }
}
