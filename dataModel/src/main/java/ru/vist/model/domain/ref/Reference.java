package ru.vist.model.domain.ref;

import ru.vist.model.domain.sys.User;
import ru.vist.model.types.RecStatus;
import ru.vist.model.utils.JSON;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author chernov
 */
@Entity
@Table(name = "REFERENCE",schema = "AW_STAT")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "Reference_type")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Reference.findActual", query = "SELECT r FROM Reference r WHERE r.status = :status"),
    @NamedQuery(name = "Reference.findByName&Type", query = "SELECT r FROM Reference r WHERE r.name = :name and r.refType =:refType"),
    @NamedQuery(name = "Reference.findById", query = "SELECT r FROM Reference r WHERE r.id = :id"),
    @NamedQuery(name = "Reference.findProdUnit", query = "SELECT r FROM Reference r"
            + "  WHERE r.refType in ('CORPORATION',    'FACTORY',    'DEPT',    'BRIGADE')"
            + " and r.status = :status"),
    @NamedQuery(name = "Reference.findByUnit", query = "SELECT r FROM Reference r"
            + "  WHERE r.refType in ('CORPORATION',    'FACTORY',    'DEPT',    'BRIGADE')"
            + " and r.status = :status"),
    @NamedQuery(name = "Reference.findByImpKey", query = "SELECT r FROM Reference r WHERE r.refType = :refType and r.impKey = :impKey")
})

public abstract class Reference implements Serializable {


    @Column(name = "Reference_type")
    private String refType;

    public String getRefType() {
        return refType;
    }

    public void setRefType(String refType) {
        this.refType = refType;
    }

    @Id
    @Column(length = 36)
    protected String id;
    
    protected String name;

    @Column(length = 36)
    protected String idd;
    @Column(name = "DATE_EVENT")
    @Temporal(TemporalType.TIMESTAMP)
    protected Date dateEvent = new Date();

        private Long npp;

    public Long getNpp() {
        return npp;
    }

    public void setNpp(Long npp) {
        this.npp = npp;
    }

    
    @Enumerated(EnumType.STRING)
    private RecStatus status;

    public RecStatus getStatus() {
        return status;
    }

    public void setStatus(RecStatus status) {
        this.status = status;
    }

    public Reference() {
        this.id = UUID.randomUUID().toString();
        this.status = RecStatus.ACTIVE;
    }

    public Reference(String id) {
        this.id = id;
        this.idd = id;
        this.status = RecStatus.ACTIVE;
    }

    public Reference(String id, String name) {
        this(id);
        this.name = name;
        this.status = RecStatus.ACTIVE;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdd() {
        return idd;
    }

    public void setIdd(String idd) {
        this.idd = idd;
    }

    public Date getDateEvent() {
        return dateEvent;
    }

    public void setDateEvent(Date dateEvent) {
        this.dateEvent = dateEvent;
    }

    private Long impKey;
    public Long getImpKey() {
        return impKey;
    }

    public void setImpKey(Long impKey) {
        this.impKey = impKey;
    }

    private User owner;

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    
    public String toJSON() {
        JSON<Reference> json = new JSON();
        String ret = json.JsonForEntity(this);
        return ret;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}