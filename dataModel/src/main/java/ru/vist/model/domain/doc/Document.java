package ru.vist.model.domain.doc;

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

@Entity
@Table(name = "DOCUMENT",schema = "AW_STAT")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "Document_type")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Document.findActual", query = "SELECT r FROM Document r WHERE r.status = :status"),
})

public abstract class Document implements Serializable {


    @Column(name = "Document_type")
    private String docType;

    public String getDocType() {
        return docType;
    }

    public void setDocType(String docType) {
        this.docType = docType;
    }

    @Id
//    @Size(max = 36, min = 36)
    @Column(length = 36)
    protected String id;
    
    
    
    protected String name;
//    @Size(max = 36, min = 36)
    @Column(length = 36)    
    protected String idd;
    @Column(name = "DATE_EVENT")
    @Temporal(TemporalType.TIMESTAMP)
    protected Date dateEvent = new Date();

    private Long impKey;
    public Long getImpKey() {
        return impKey;
    }

    public void setImpKey(Long impKey) {
        this.impKey = impKey;
    }

    @Enumerated(EnumType.STRING)
    private RecStatus status;

    public RecStatus getStatus() {
        return status;
    }

    public void setStatus(RecStatus status) {
        this.status = status;
    }

    public Document() {
        this.id = UUID.randomUUID().toString();
//        this.npp = initNpp ++;
        this.status = RecStatus.ACTIVE;
    }

    public Document(String id) {
        this.id = id;
        this.idd = id;
        this.status = RecStatus.ACTIVE;
    }

    public Document(String id, String name) {
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

    private Long npp;

    public Long getNpp() {
        return npp;
    }

    public void setNpp(Long npp) {
        this.npp = npp;
    }

    private User owner
            ;

    public User getOw_ner() {
        return owner;
    }

    public void setOw_ner(User ow_ner) {
        this.owner = ow_ner;
    }

    
    public String toJSON() {
        JSON<Document> json = new JSON();
        String ret = json.JsonForEntity(this);
        return ret;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}