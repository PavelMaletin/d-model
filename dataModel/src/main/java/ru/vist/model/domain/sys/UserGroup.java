package ru.vist.model.domain.sys;

import ru.vist.model.domain.ref.Reference;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "USERGROUP",schema = "AW_STAT")
@DiscriminatorValue("USERGROUP")
public class UserGroup extends Reference {

    public UserGroup() {
    }

//    public UserGroup(long id) {
//        super(id);
//    }
    public UserGroup(String id, String name) {
        super(id, name);
    }

    @Override
    public String toString() {
        return super.name;
    }

}
