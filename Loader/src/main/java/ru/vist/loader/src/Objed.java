/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.vist.loader.src;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.codehaus.jackson.annotate.JsonIgnore;

/**
 *
 * @author chernov
 */
@Entity
@Table(name = "OBJED", catalog = "", schema = "AC_STAT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Objed.findAll", query = "SELECT o FROM Objed o"),
    @NamedQuery(name = "Objed.findByObjedK", query = "SELECT o FROM Objed o WHERE o.objedK = :objedK"),
    @NamedQuery(name = "Objed.findByObjedNaim", query = "SELECT o FROM Objed o WHERE o.objedNaim = :objedNaim")})
public class Objed implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "OBJED_K", nullable = false)
    private Integer objedK;
    @Size(max = 100)
    @Column(name = "OBJED_NAIM", length = 100)
    private String objedNaim;
    @OneToMany(mappedBy = "objedK")
    private List<Predpr> predprList;

    public Objed() {
    }

    public Objed(Integer objedK) {
        this.objedK = objedK;
    }

    public Integer getObjedK() {
        return objedK;
    }

    public void setObjedK(Integer objedK) {
        this.objedK = objedK;
    }

    public String getObjedNaim() {
        return objedNaim;
    }

    public void setObjedNaim(String objedNaim) {
        this.objedNaim = objedNaim;
    }

    @XmlTransient
    @JsonIgnore
    public List<Predpr> getPredprList() {
        return predprList;
    }

    public void setPredprList(List<Predpr> predprList) {
        this.predprList = predprList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (objedK != null ? objedK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Objed))
            return false;
        Objed other = (Objed) object;
        if ((this.objedK == null && other.objedK != null) || (this.objedK != null && !this.objedK.equals(other.objedK)))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "cvr.vist.ref.loader.src.Objed[ objedK=" + objedK + " ]";
    }
    
}
