package ru.vist.model.domain.sys;

import ru.vist.model.domain.ref.ProdUnit;
import ru.vist.model.domain.ref.Reference;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "SUBSCRIBER",schema = "AW_STAT")
@DiscriminatorValue("SUBSCRIBER")
public class Subscriber extends Reference {

    public Subscriber() {
    }

    public Subscriber(String id, String name) {
        super(id, name);
    }

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "prod_unit_id")
    private ProdUnit prodUnit;

    public ProdUnit getProdUnit() {
        return prodUnit;
    }

    public void setProdUnit(ProdUnit prodUnit) {
        this.prodUnit = prodUnit;
    }

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "user_id")
    private User user;

//    @ManyToMany
//    @JoinTable(
//            name = "SUBSCIBER_SUBS",
//            joinColumns = {
//                @JoinColumn(name = "SUBSCIBER_ID", referencedColumnName = "ID")},
//            inverseJoinColumns = {
//                @JoinColumn(name = "SUBSCIBE_ID", referencedColumnName = "ID")})
    private List<String> subs = new ArrayList<String>();

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<String> getSubs() {
        return subs;
    }

    public void setSubs(List<String> subs) {
        this.subs = subs;
    }

    public void addSubs(String... sub) {
        for (int i = 0; i < sub.length; i++)
            subs.add(sub[i]);
    }
    @Override
    public String toString() {
        return super.name;
    }
    
}
