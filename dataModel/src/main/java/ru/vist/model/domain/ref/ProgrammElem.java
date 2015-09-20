package ru.vist.model.domain.ref;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "PROGRAMM_ELEM",schema = "AW_STAT")
@DiscriminatorValue("PROGRAMM_ELEM")
public class ProgrammElem extends Reference {

    public ProgrammElem() {
    }

    public ProgrammElem(String id, String name) {
        super(id, name);
    }

    private String progValue;

    public String getProgValue() {
        return progValue;
    }

    public void setProgValue(String progValue) {
        this.progValue = progValue;
    }

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "parent_id")
    private ProgrammElem parent;

    public ProgrammElem getParent() {
        return parent;
}

    public void setParent(ProgrammElem parent) {
        this.parent = parent;
    }
    @Override
    public String toString() {
        return super.name;
    }

}
