/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.vist.loader.src;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author chernov


 */
@Entity
@Table(name = "BRIGAD", catalog = "", schema = "AC_STAT", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"UCHAST_K", "BRIGAD_K"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Brigad.findAll", query = "SELECT b FROM Brigad b"),
    @NamedQuery(name = "Brigad.findByBrigadK", query = "SELECT b FROM Brigad b WHERE b.brigadK = :brigadK"),
    @NamedQuery(name = "Brigad.findByBrigadNaim", query = "SELECT b FROM Brigad b WHERE b.brigadNaim = :brigadNaim"),
    @NamedQuery(name = "Brigad.findByBrigadTipK", query = "SELECT b FROM Brigad b WHERE b.brigadTipK = :brigadTipK"),
    @NamedQuery(name = "Brigad.findByBrigadTekst", query = "SELECT b FROM Brigad b WHERE b.brigadTekst = :brigadTekst"),
    @NamedQuery(name = "Brigad.findByEquipment", query = "SELECT b FROM Brigad b WHERE b.equipment = :equipment"),
    @NamedQuery(name = "Brigad.findByEnumber", query = "SELECT b FROM Brigad b WHERE b.enumber = :enumber"),
    @NamedQuery(name = "Brigad.findByIsdangerobject", query = "SELECT b FROM Brigad b WHERE b.isdangerobject = :isdangerobject"),
    @NamedQuery(name = "Brigad.findByEquipmentTipK", query = "SELECT b FROM Brigad b WHERE b.equipmentTipK = :equipmentTipK"),
    @NamedQuery(name = "Brigad.findByPriority", query = "SELECT b FROM Brigad b WHERE b.priority = :priority"),
    @NamedQuery(name = "Brigad.findByDoljK", query = "SELECT b FROM Brigad b WHERE b.doljK = :doljK"),
    @NamedQuery(name = "Brigad.findByRoute", query = "SELECT b FROM Brigad b WHERE b.route = :route"),
    @NamedQuery(name = "Brigad.findByGosNomer", query = "SELECT b FROM Brigad b WHERE b.gosNomer = :gosNomer"),
    @NamedQuery(name = "Brigad.findByGarageNomer", query = "SELECT b FROM Brigad b WHERE b.garageNomer = :garageNomer"),
    @NamedQuery(name = "Brigad.findByNaimTs", query = "SELECT b FROM Brigad b WHERE b.naimTs = :naimTs"),
    @NamedQuery(name = "Brigad.findByDateChg", query = "SELECT b FROM Brigad b WHERE b.dateChg = :dateChg"),
    @NamedQuery(name = "Brigad.findByCounter", query = "SELECT b FROM Brigad b WHERE b.counter = :counter")})
public class Brigad implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "BRIGAD_K", nullable = false)
    private Integer brigadK;
    @Size(max = 250)
    @Column(name = "BRIGAD_NAIM", length = 250)
    private String brigadNaim;
    @Column(name = "BRIGAD_TIP_K")
    private Integer brigadTipK;
    @Size(max = 1)
    @Column(name = "BRIGAD_TEKST", length = 1)
    private String brigadTekst;
    @Size(max = 1)
    @Column(name = "EQUIPMENT", length = 1)
    private String equipment;
    @Size(max = 1000)
    @Column(name = "ENUMBER", length = 1000)
    private String enumber;
    @Size(max = 1)
    @Column(name = "ISDANGEROBJECT", length = 1)
    private String isdangerobject;
    @Column(name = "EQUIPMENT_TIP_K")
    private BigInteger equipmentTipK;
    @Column(name = "PRIORITY")
    private BigInteger priority;
    @Column(name = "DOLJ_K")
    private BigInteger doljK;
    @Column(name = "ROUTE")
    private BigInteger route;
    @Size(max = 250)
    @Column(name = "GOS_NOMER", length = 250)
    private String gosNomer;
    @Size(max = 250)
    @Column(name = "GARAGE_NOMER", length = 250)
    private String garageNomer;
    @Size(max = 250)
    @Column(name = "NAIM_TS", length = 250)
    private String naimTs;
    @Column(name = "DATE_CHG")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateChg;
    @Column(name = "COUNTER")
    private BigInteger counter;
    @JoinColumn(name = "UCHAST_K", referencedColumnName = "UCHAST_K")
    @ManyToOne
    private Uchast uchastK;

    public Brigad() {
    }

    public Brigad(Integer brigadK) {
        this.brigadK = brigadK;
    }

    public Integer getBrigadK() {
        return brigadK;
    }

    public void setBrigadK(Integer brigadK) {
        this.brigadK = brigadK;
    }

    public String getBrigadNaim() {
        return brigadNaim;
    }

    public void setBrigadNaim(String brigadNaim) {
        this.brigadNaim = brigadNaim;
    }

    public Integer getBrigadTipK() {
        return brigadTipK;
    }

    public void setBrigadTipK(Integer brigadTipK) {
        this.brigadTipK = brigadTipK;
    }

    public String getBrigadTekst() {
        return brigadTekst;
    }

    public void setBrigadTekst(String brigadTekst) {
        this.brigadTekst = brigadTekst;
    }

    public String getEquipment() {
        return equipment;
    }

    public void setEquipment(String equipment) {
        this.equipment = equipment;
    }

    public String getEnumber() {
        return enumber;
    }

    public void setEnumber(String enumber) {
        this.enumber = enumber;
    }

    public String getIsdangerobject() {
        return isdangerobject;
    }

    public void setIsdangerobject(String isdangerobject) {
        this.isdangerobject = isdangerobject;
    }

    public BigInteger getEquipmentTipK() {
        return equipmentTipK;
    }

    public void setEquipmentTipK(BigInteger equipmentTipK) {
        this.equipmentTipK = equipmentTipK;
    }

    public BigInteger getPriority() {
        return priority;
    }

    public void setPriority(BigInteger priority) {
        this.priority = priority;
    }

    public BigInteger getDoljK() {
        return doljK;
    }

    public void setDoljK(BigInteger doljK) {
        this.doljK = doljK;
    }

    public BigInteger getRoute() {
        return route;
    }

    public void setRoute(BigInteger route) {
        this.route = route;
    }

    public String getGosNomer() {
        return gosNomer;
    }

    public void setGosNomer(String gosNomer) {
        this.gosNomer = gosNomer;
    }

    public String getGarageNomer() {
        return garageNomer;
    }

    public void setGarageNomer(String garageNomer) {
        this.garageNomer = garageNomer;
    }

    public String getNaimTs() {
        return naimTs;
    }

    public void setNaimTs(String naimTs) {
        this.naimTs = naimTs;
    }

    public Date getDateChg() {
        return dateChg;
    }

    public void setDateChg(Date dateChg) {
        this.dateChg = dateChg;
    }

    public BigInteger getCounter() {
        return counter;
    }

    public void setCounter(BigInteger counter) {
        this.counter = counter;
    }

    public Uchast getUchastK() {
        return uchastK;
    }

    public void setUchastK(Uchast uchastK) {
        this.uchastK = uchastK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (brigadK != null ? brigadK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Brigad))
            return false;
        Brigad other = (Brigad) object;
        if ((this.brigadK == null && other.brigadK != null) || (this.brigadK != null && !this.brigadK.equals(other.brigadK)))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "cvr.vist.ref.loader.src.Brigad[ brigadK=" + brigadK + " ]";
    }
    
}
