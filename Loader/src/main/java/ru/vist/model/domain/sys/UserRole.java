package ru.vist.model.domain.sys;

import ru.vist.model.domain.ref.Reference;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "USERROLE",schema = "AW_STAT")
@DiscriminatorValue("USERROLE")
public class UserRole extends Reference {

    public UserRole() {
    }

    public UserRole(String id, String name) {
        super(id, name);
    }
    @Override
    public String toString() {
        return super.name;
    }
    
}
