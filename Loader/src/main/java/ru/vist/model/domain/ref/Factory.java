package ru.vist.model.domain.ref;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "FACTORY",schema = "AW_STAT")
@DiscriminatorValue("FACTORY")
public class Factory extends ProdUnit {

    public Factory() {
    }

    public Factory(String id, String name) {
        super(id, name);
    }
//    @Override
//    public String toString() {
//        return super.name;
//    }
    
}
