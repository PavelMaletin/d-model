package ru.vist.model.domain.ref;

import ru.vist.model.types.RefType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "CORPORATION",schema = "AW_STAT")
@DiscriminatorValue("CORPORATION")
public class Corporation extends ProdUnit{

    public Corporation() {
    }

    public Corporation(String id, String name) {
        super(id, name);
    }    
}
