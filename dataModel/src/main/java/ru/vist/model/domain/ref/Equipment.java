/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.vist.model.domain.ref;

import ru.vist.model.types.RecStatus;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlTransient;
import org.codehaus.jackson.annotate.JsonIgnore;
//import org.codehaus.jackson.annotate.JsonProperty;

/**
 *
 * @author chernov
 * Объекты участка.
 */
@Entity
@Table(name = "PROD_UNIT",schema = "AW_STAT")
@DiscriminatorValue("PROD_UNIT")
@XmlAccessorType(XmlAccessType.FIELD)

public class Equipment extends Reference {

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "parent_id")
//    @XmlTransient
    private Equipment parent;


    public Equipment getParent() {
        return parent;
    }

    public void setParent(Equipment parent) {
        this.parent = parent;
    }

    @OneToMany(mappedBy = "parent", cascade = CascadeType.PERSIST)
    @XmlTransient
    @JsonIgnore
    private List<Equipment> parts = new ArrayList<Equipment>();

    public List<Equipment> getParts() {
        return parts;
    }

    public void setParts(List<Equipment> parts) {
        this.parts = parts;
    }

    public void addPart(Equipment w) {
        w.setParent(this);
        this.parts.add(w);
    }

    public Equipment(String id, String name) {
        super(id, name);
    }

    public Equipment() {
    }

    @Override
    public String toString() {
        return super.name;
    }

}
