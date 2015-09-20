package ru.vist.model.domain.sys;

import ru.vist.model.domain.ref.Reference;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "SUBSCRIBE", schema = "AW_STAT")
@DiscriminatorValue("SUBSCRIBE")
public class Subscribe extends Reference {

    public Subscribe() {
    }

    public Subscribe(String id, String name, Class clazz) {
        super(id, name);
        className = clazz.getCanonicalName();
    }

//    public Subscribe(String id, String name) {
//        super(id, name);
//    }
//
//    public Subscribe(String id, String name,String className) {
//        super(id, name);
//        this.className = className;
//    }
    private String className;

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    @Override
    public String toString() {
        return super.name;
    }

}
