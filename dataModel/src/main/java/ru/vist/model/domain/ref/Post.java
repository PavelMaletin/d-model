package ru.vist.model.domain.ref;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "POST", schema = "AW_STAT")
@DiscriminatorValue("POST")
//@XmlAccessorType(XmlAccessType.FIELD)
//@XmlRootElement
//@NamedQueries({
//    @NamedQuery(name = "Post.findAll", query = "SELECT r FROM Post ")
//})

public class Post extends Reference {

    @ManyToOne
    @JoinColumn(name = "prodUnit_id")
    private ProdUnit prodUnit;

    public ProdUnit getProdUnit() {
        return prodUnit;
    }

    public void setProdUnit(ProdUnit prodUnit) {
        this.prodUnit = prodUnit;
    }

    public Post() {
    }

    public Post(String id, String name) {
        super(id, name);
    }

    private int smen;

    public int getSmen() {
        return smen;
    }

    public void setSmen(int smen) {
        this.smen = smen;
    }

    @Override
    public String toString() {
        return super.name;
    }

}
