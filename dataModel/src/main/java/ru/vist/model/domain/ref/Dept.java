package ru.vist.model.domain.ref;

import ru.vist.model.types.RefType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "DEPT", schema = "AW_STAT")
@DiscriminatorValue("DEPT")
public class Dept extends ProdUnit {

    public Dept() {
    }

    public Dept(String id, String name) {
        super(id, name);
    }
}
