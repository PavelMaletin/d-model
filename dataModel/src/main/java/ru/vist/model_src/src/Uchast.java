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
@Table(name = "UCHAST", catalog = "", schema = "AC_STAT", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"PREDPR_K", "UCHAST_K"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Uchast.findAll", query = "SELECT u FROM Uchast u"),
    @NamedQuery(name = "Uchast.findByUchastK", query = "SELECT u FROM Uchast u WHERE u.uchastK = :uchastK"),
    @NamedQuery(name = "Uchast.findByUchastNaim", query = "SELECT u FROM Uchast u WHERE u.uchastNaim = :uchastNaim"),
    @NamedQuery(name = "Uchast.findByUchastTipK", query = "SELECT u FROM Uchast u WHERE u.uchastTipK = :uchastTipK"),
    @NamedQuery(name = "Uchast.findBySutki", query = "SELECT u FROM Uchast u WHERE u.sutki = :sutki"),
    @NamedQuery(name = "Uchast.findByBookNaryad", query = "SELECT u FROM Uchast u WHERE u.bookNaryad = :bookNaryad"),
    @NamedQuery(name = "Uchast.findByAccessNaryad", query = "SELECT u FROM Uchast u WHERE u.accessNaryad = :accessNaryad"),
    @NamedQuery(name = "Uchast.findByIsAccessBlank", query = "SELECT u FROM Uchast u WHERE u.isAccessBlank = :isAccessBlank"),
    @NamedQuery(name = "Uchast.findByBlankPredpis", query = "SELECT u FROM Uchast u WHERE u.blankPredpis = :blankPredpis"),
    @NamedQuery(name = "Uchast.findByUchastSpisok", query = "SELECT u FROM Uchast u WHERE u.uchastSpisok = :uchastSpisok"),
    @NamedQuery(name = "Uchast.findByUchastType", query = "SELECT u FROM Uchast u WHERE u.uchastType = :uchastType"),
    @NamedQuery(name = "Uchast.findByIsReport", query = "SELECT u FROM Uchast u WHERE u.isReport = :isReport")})
public class Uchast implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "UCHAST_K", nullable = false)
    private Integer uchastK;
    @Column(name = "UCHAST_NAIM", length = 255)
    private String uchastNaim;
    @Column(name = "UCHAST_TIP_K")
    private Integer uchastTipK;
    @Column(name = "SUTKI")
    private BigInteger sutki;
    @Column(name = "BOOK_NARYAD")
    private BigInteger bookNaryad;
    @Column(name = "ACCESS_NARYAD")
    private BigInteger accessNaryad;
    @Column(name = "IS_ACCESS_BLANK", length = 10)
    private String isAccessBlank;
    @Column(name = "BLANK_PREDPIS")
    private BigInteger blankPredpis;
    @Column(name = "UCHAST_SPISOK", length = 1)
    private String uchastSpisok;
    @Column(name = "UCHAST_TYPE")
    private Integer uchastType;
    @Column(name = "IS_REPORT", length = 1)
    private String isReport;
    @JoinColumn(name = "NACH_K", referencedColumnName = "SOTRUD_K")
    @ManyToOne
    private Sotrud nachK;
    @JoinColumn(name = "PREDPR_K", referencedColumnName = "PREDPR_K")
    @ManyToOne
    private Predpr predprK;
    @OneToMany(mappedBy = "uchastK")
    private List<Brigad> brigadList;
    @OneToMany(mappedBy = "uchastK")
    private List<Sotrud> sotrudList;

    public Uchast() {
    }

    public Uchast(Integer uchastK) {
        this.uchastK = uchastK;
    }

    public Integer getUchastK() {
        return uchastK;
    }

    public void setUchastK(Integer uchastK) {
        this.uchastK = uchastK;
    }

    public String getUchastNaim() {
        return uchastNaim;
    }

    public void setUchastNaim(String uchastNaim) {
        this.uchastNaim = uchastNaim;
    }

    public Integer getUchastTipK() {
        return uchastTipK;
    }

    public void setUchastTipK(Integer uchastTipK) {
        this.uchastTipK = uchastTipK;
    }

    public BigInteger getSutki() {
        return sutki;
    }

    public void setSutki(BigInteger sutki) {
        this.sutki = sutki;
    }

    public BigInteger getBookNaryad() {
        return bookNaryad;
    }

    public void setBookNaryad(BigInteger bookNaryad) {
        this.bookNaryad = bookNaryad;
    }

    public BigInteger getAccessNaryad() {
        return accessNaryad;
    }

    public void setAccessNaryad(BigInteger accessNaryad) {
        this.accessNaryad = accessNaryad;
    }

    public String getIsAccessBlank() {
        return isAccessBlank;
    }

    public void setIsAccessBlank(String isAccessBlank) {
        this.isAccessBlank = isAccessBlank;
    }

    public BigInteger getBlankPredpis() {
        return blankPredpis;
    }

    public void setBlankPredpis(BigInteger blankPredpis) {
        this.blankPredpis = blankPredpis;
    }

    public String getUchastSpisok() {
        return uchastSpisok;
    }

    public void setUchastSpisok(String uchastSpisok) {
        this.uchastSpisok = uchastSpisok;
    }

    public Integer getUchastType() {
        return uchastType;
    }

    public void setUchastType(Integer uchastType) {
        this.uchastType = uchastType;
    }

    public String getIsReport() {
        return isReport;
    }

    public void setIsReport(String isReport) {
        this.isReport = isReport;
    }

    public Sotrud getNachK() {
        return nachK;
    }

    public void setNachK(Sotrud nachK) {
        this.nachK = nachK;
    }

    public Predpr getPredprK() {
        return predprK;
    }

    public void setPredprK(Predpr predprK) {
        this.predprK = predprK;
    }

    @XmlTransient
    public List<Brigad> getBrigadList() {
        return brigadList;
    }

    public void setBrigadList(List<Brigad> brigadList) {
        this.brigadList = brigadList;
    }

    @XmlTransient
    public List<Sotrud> getSotrudList() {
        return sotrudList;
    }

    public void setSotrudList(List<Sotrud> sotrudList) {
        this.sotrudList = sotrudList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (uchastK != null ? uchastK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Uchast))
            return false;
        Uchast other = (Uchast) object;
        if ((this.uchastK == null && other.uchastK != null) || (this.uchastK != null && !this.uchastK.equals(other.uchastK)))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "ru.vist.model.src.Uchast[ uchastK=" + uchastK + " ]";
    }
    
}
