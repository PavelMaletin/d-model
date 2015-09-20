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
 */
@Entity
@Table(name = "PROD_UNIT",schema = "AW_STAT")
@DiscriminatorValue("PROD_UNIT")
@XmlAccessorType(XmlAccessType.FIELD)

public class ProdUnit extends Reference {

    @OneToMany(mappedBy = "placeOfWork", cascade = CascadeType.PERSIST)
    @XmlTransient
    @JsonIgnore
    private List<Worker> workers = new ArrayList<Worker>();

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "chef_id")
    private Worker chef;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "parent_id")
//    @XmlTransient
    private ProdUnit parent;


    public ProdUnit getParent() {
        return parent;
    }

    public void setParent(ProdUnit parent) {
        this.parent = parent;
    }

    @OneToMany(mappedBy = "parent", cascade = CascadeType.PERSIST)
    @XmlTransient
    @JsonIgnore
    private List<ProdUnit> units = new ArrayList<ProdUnit>();

    public List<ProdUnit> getUnits() {
        return units;
    }

    public void setUnits(List<ProdUnit> units) {
        this.units = units;
    }

    public void addUnit(ProdUnit w) {
        w.setParent(this);
        this.units.add(w);
    }

//    @XmlTransient
    @JsonIgnore
    public List<ProdUnit> getActiveUnits() {
        List<ProdUnit> list = new ArrayList<ProdUnit>();
        for (ProdUnit pu : units)
            if (pu.getStatus() == RecStatus.ACTIVE)
                list.add(pu);
        return list;
    }

    public Worker getChef() {
        return chef;
    }

    public void setChef(Worker chef) {
        this.chef = chef;
    }

    public void addWorker(Worker w) {
        w.setPlaceOfWork(this);
        this.workers.add(w);
    }

    public void setWorkers(List<Worker> workers) {
        this.workers = workers;
    }

    public List<Worker> getWorkers() {
        return workers;
    }

    //@XmlTransient
    @JsonIgnore
    public List<Worker> getActiveWorkers() {
        List<Worker> list = new ArrayList<Worker>();
        for (Worker w : workers)
            if (w.getStatus() == RecStatus.ACTIVE)
                list.add(w);
        return list;
    }

    @OneToMany(mappedBy = "prodUnit", cascade = CascadeType.PERSIST)
    @XmlTransient
    @JsonIgnore
    private List<Post> posts = new ArrayList<Post>();

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }
    
    public void addPost(Post post){
        post.setProdUnit(this);
        posts.add(post);
    }
    
    private String props;

    public String getProps() {
        return props;
    }

    public void setProps(String props) {
        this.props = props;
    }

    public ProdUnit(String id, String name) {
        super(id, name);
    }

    public ProdUnit() {
    }

    private String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    private String industry;

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    private String productionType;

    public String getProductionType() {
        return productionType;
    }

    public void setProductionType(String productionType) {
        this.productionType = productionType;
    }
    @Override
    public String toString() {
        return super.name;
    }

}
