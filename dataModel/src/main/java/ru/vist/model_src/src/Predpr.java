/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.vist.model_src.src;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author chernov
 */
@Entity
@Table(name = "PREDPR", catalog = "", schema = "AC_STAT", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"OBJED_K", "PREDPR_K"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Predpr.findAll", query = "SELECT p FROM Predpr p"),
    @NamedQuery(name = "Predpr.findByPredprK", query = "SELECT p FROM Predpr p WHERE p.predprK = :predprK"),
    @NamedQuery(name = "Predpr.findByPredprNaim", query = "SELECT p FROM Predpr p WHERE p.predprNaim = :predprNaim"),
    @NamedQuery(name = "Predpr.findByPredprPoln", query = "SELECT p FROM Predpr p WHERE p.predprPoln = :predprPoln"),
    @NamedQuery(name = "Predpr.findByUchastTipK", query = "SELECT p FROM Predpr p WHERE p.uchastTipK = :uchastTipK"),
    @NamedQuery(name = "Predpr.findByPredpistemplateK", query = "SELECT p FROM Predpr p WHERE p.predpistemplateK = :predpistemplateK"),
    @NamedQuery(name = "Predpr.findByNaryadtemplateK", query = "SELECT p FROM Predpr p WHERE p.naryadtemplateK = :naryadtemplateK"),
    @NamedQuery(name = "Predpr.findByActtemplateK", query = "SELECT p FROM Predpr p WHERE p.acttemplateK = :acttemplateK")})
public class Predpr implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "PREDPR_K", nullable = false)
    private Integer predprK;
    @Column(name = "PREDPR_NAIM", length = 250)
    private String predprNaim;
    @Column(name = "PREDPR_POLN", length = 250)
    private String predprPoln;
    @Column(name = "UCHAST_TIP_K")
    private BigInteger uchastTipK;
    @Column(name = "PREDPISTEMPLATE_K")
    private BigInteger predpistemplateK;
    @Column(name = "NARYADTEMPLATE_K")
    private BigInteger naryadtemplateK;
    @Column(name = "ACTTEMPLATE_K")
    private BigInteger acttemplateK;
    @JoinColumn(name = "DIR_K", referencedColumnName = "SOTRUD_K")
    @ManyToOne
    private Sotrud dirK;
    @JoinColumn(name = "OBJED_K", referencedColumnName = "OBJED_K")
    @ManyToOne
    private Objed objedK;
    @OneToMany(mappedBy = "predprK")
    private List<Doljnost> doljnostList;
    @OneToMany(mappedBy = "predprK")
    private List<Uchast> uchastList;

    public Predpr() {
    }

    public Predpr(Integer predprK) {
        this.predprK = predprK;
    }

    public Integer getPredprK() {
        return predprK;
    }

    public void setPredprK(Integer predprK) {
        this.predprK = predprK;
    }

    public String getPredprNaim() {
        return predprNaim;
    }

    public void setPredprNaim(String predprNaim) {
        this.predprNaim = predprNaim;
    }

    public String getPredprPoln() {
        return predprPoln;
    }

    public void setPredprPoln(String predprPoln) {
        this.predprPoln = predprPoln;
    }

    public BigInteger getUchastTipK() {
        return uchastTipK;
    }

    public void setUchastTipK(BigInteger uchastTipK) {
        this.uchastTipK = uchastTipK;
    }

    public BigInteger getPredpistemplateK() {
        return predpistemplateK;
    }

    public void setPredpistemplateK(BigInteger predpistemplateK) {
        this.predpistemplateK = predpistemplateK;
    }

    public BigInteger getNaryadtemplateK() {
        return naryadtemplateK;
    }

    public void setNaryadtemplateK(BigInteger naryadtemplateK) {
        this.naryadtemplateK = naryadtemplateK;
    }

    public BigInteger getActtemplateK() {
        return acttemplateK;
    }

    public void setActtemplateK(BigInteger acttemplateK) {
        this.acttemplateK = acttemplateK;
    }

    public Sotrud getDirK() {
        return dirK;
    }

    public void setDirK(Sotrud dirK) {
        this.dirK = dirK;
    }

    public Objed getObjedK() {
        return objedK;
    }

    public void setObjedK(Objed objedK) {
        this.objedK = objedK;
    }

    @XmlTransient
    public List<Doljnost> getDoljnostList() {
        return doljnostList;
    }

    public void setDoljnostList(List<Doljnost> doljnostList) {
        this.doljnostList = doljnostList;
    }

    @XmlTransient
    public List<Uchast> getUchastList() {
        return uchastList;
    }

    public void setUchastList(List<Uchast> uchastList) {
        this.uchastList = uchastList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (predprK != null ? predprK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Predpr))
            return false;
        Predpr other = (Predpr) object;
        if ((this.predprK == null && other.predprK != null) || (this.predprK != null && !this.predprK.equals(other.predprK)))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "ru.vist.model.src.Predpr[ predprK=" + predprK + " ]";
    }
    
}
