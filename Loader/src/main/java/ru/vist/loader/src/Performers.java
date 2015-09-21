/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.vist.loader.src;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author chernov
 */
@Entity
@Table(name = "PERFORMERS", catalog = "", schema = "AC_STAT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Performers.findAll", query = "SELECT p FROM Performers p"),
    @NamedQuery(name = "Performers.findByVgs", query = "SELECT p FROM Performers p WHERE p.vgs = :vgs"),
    @NamedQuery(name = "Performers.findByVmp", query = "SELECT p FROM Performers p WHERE p.vmp = :vmp"),
    @NamedQuery(name = "Performers.findByOborka", query = "SELECT p FROM Performers p WHERE p.oborka = :oborka"),
    @NamedQuery(name = "Performers.findByHead", query = "SELECT p FROM Performers p WHERE p.head = :head"),
    @NamedQuery(name = "Performers.findByDoljNaim", query = "SELECT p FROM Performers p WHERE p.doljNaim = :doljNaim"),
    @NamedQuery(name = "Performers.findByPriorityK", query = "SELECT p FROM Performers p WHERE p.priorityK = :priorityK"),
    @NamedQuery(name = "Performers.findByGroz", query = "SELECT p FROM Performers p WHERE p.groz = :groz"),
    @NamedQuery(name = "Performers.findByProchod", query = "SELECT p FROM Performers p WHERE p.prochod = :prochod"),
    @NamedQuery(name = "Performers.findBySlesar", query = "SELECT p FROM Performers p WHERE p.slesar = :slesar"),
    @NamedQuery(name = "Performers.findByGrp", query = "SELECT p FROM Performers p WHERE p.grp = :grp"),
    @NamedQuery(name = "Performers.findByMash", query = "SELECT p FROM Performers p WHERE p.mash = :mash"),
    @NamedQuery(name = "Performers.findByPom", query = "SELECT p FROM Performers p WHERE p.pom = :pom"),
    @NamedQuery(name = "Performers.findByVoditel", query = "SELECT p FROM Performers p WHERE p.voditel = :voditel"),
    @NamedQuery(name = "Performers.findByMgvm", query = "SELECT p FROM Performers p WHERE p.mgvm = :mgvm"),
    @NamedQuery(name = "Performers.findByOthers", query = "SELECT p FROM Performers p WHERE p.others = :others"),
    @NamedQuery(name = "Performers.findByHour", query = "SELECT p FROM Performers p WHERE p.hour = :hour"),
    @NamedQuery(name = "Performers.findByBrigadier", query = "SELECT p FROM Performers p WHERE p.brigadier = :brigadier"),
    @NamedQuery(name = "Performers.findByTime", query = "SELECT p FROM Performers p WHERE p.time = :time"),
    @NamedQuery(name = "Performers.findByNpp", query = "SELECT p FROM Performers p WHERE p.npp = :npp"),
    @NamedQuery(name = "Performers.findById", query = "SELECT p FROM Performers p WHERE p.id = :id")})
public class Performers implements Serializable {
    private static final long serialVersionUID = 1L;
    @Size(max = 1)
    @Column(name = "VGS", length = 1)
    private String vgs;
    @Size(max = 1)
    @Column(name = "VMP", length = 1)
    private String vmp;
    @Size(max = 1)
    @Column(name = "OBORKA", length = 1)
    private String oborka;
    @Size(max = 1)
    @Column(name = "HEAD", length = 1)
    private String head;
    @Size(max = 500)
    @Column(name = "DOLJ_NAIM", length = 500)
    private String doljNaim;
    @Column(name = "PRIORITY_K")
    private BigInteger priorityK;
    @Column(name = "GROZ")
    private BigInteger groz;
    @Column(name = "PROCHOD")
    private BigInteger prochod;
    @Column(name = "SLESAR")
    private BigInteger slesar;
    @Column(name = "GRP")
    private BigInteger grp;
    @Column(name = "MASH")
    private BigInteger mash;
    @Column(name = "POM")
    private BigInteger pom;
    @Column(name = "VODITEL")
    private BigInteger voditel;
    @Column(name = "MGVM")
    private BigInteger mgvm;
    @Column(name = "OTHERS")
    private BigInteger others;
    @Column(name = "HOUR")
    private BigInteger hour;
    @Size(max = 1)
    @Column(name = "BRIGADIER", length = 1)
    private String brigadier;
    @Column(name = "TIME")
    private BigInteger time;
    @Column(name = "NPP")
    private BigInteger npp;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID", nullable = false, precision = 0, scale = -127)
    private BigDecimal id;
    @JoinColumn(name = "SOTRUD_K", referencedColumnName = "SOTRUD_K")
    @ManyToOne
    private Sotrud sotrudK;
    @JoinColumn(name = "PREDPIS_K", referencedColumnName = "PREDPIS_K")
    @ManyToOne
    private Predpis predpisK;
    @JoinColumn(name = "DOLJ_K", referencedColumnName = "KOD")
    @ManyToOne
    private Doljnost doljK;

    public Performers() {
    }

    public Performers(BigDecimal id) {
        this.id = id;
    }

    public String getVgs() {
        return vgs;
    }

    public void setVgs(String vgs) {
        this.vgs = vgs;
    }

    public String getVmp() {
        return vmp;
    }

    public void setVmp(String vmp) {
        this.vmp = vmp;
    }

    public String getOborka() {
        return oborka;
    }

    public void setOborka(String oborka) {
        this.oborka = oborka;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public String getDoljNaim() {
        return doljNaim;
    }

    public void setDoljNaim(String doljNaim) {
        this.doljNaim = doljNaim;
    }

    public BigInteger getPriorityK() {
        return priorityK;
    }

    public void setPriorityK(BigInteger priorityK) {
        this.priorityK = priorityK;
    }

    public BigInteger getGroz() {
        return groz;
    }

    public void setGroz(BigInteger groz) {
        this.groz = groz;
    }

    public BigInteger getProchod() {
        return prochod;
    }

    public void setProchod(BigInteger prochod) {
        this.prochod = prochod;
    }

    public BigInteger getSlesar() {
        return slesar;
    }

    public void setSlesar(BigInteger slesar) {
        this.slesar = slesar;
    }

    public BigInteger getGrp() {
        return grp;
    }

    public void setGrp(BigInteger grp) {
        this.grp = grp;
    }

    public BigInteger getMash() {
        return mash;
    }

    public void setMash(BigInteger mash) {
        this.mash = mash;
    }

    public BigInteger getPom() {
        return pom;
    }

    public void setPom(BigInteger pom) {
        this.pom = pom;
    }

    public BigInteger getVoditel() {
        return voditel;
    }

    public void setVoditel(BigInteger voditel) {
        this.voditel = voditel;
    }

    public BigInteger getMgvm() {
        return mgvm;
    }

    public void setMgvm(BigInteger mgvm) {
        this.mgvm = mgvm;
    }

    public BigInteger getOthers() {
        return others;
    }

    public void setOthers(BigInteger others) {
        this.others = others;
    }

    public BigInteger getHour() {
        return hour;
    }

    public void setHour(BigInteger hour) {
        this.hour = hour;
    }

    public String getBrigadier() {
        return brigadier;
    }

    public void setBrigadier(String brigadier) {
        this.brigadier = brigadier;
    }

    public BigInteger getTime() {
        return time;
    }

    public void setTime(BigInteger time) {
        this.time = time;
    }

    public BigInteger getNpp() {
        return npp;
    }

    public void setNpp(BigInteger npp) {
        this.npp = npp;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public Sotrud getSotrudK() {
        return sotrudK;
    }

    public void setSotrudK(Sotrud sotrudK) {
        this.sotrudK = sotrudK;
    }

    public Predpis getPredpisK() {
        return predpisK;
    }

    public void setPredpisK(Predpis predpisK) {
        this.predpisK = predpisK;
    }

    public Doljnost getDoljK() {
        return doljK;
    }

    public void setDoljK(Doljnost doljK) {
        this.doljK = doljK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Performers))
            return false;
        Performers other = (Performers) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "cvr.vist.ref.loader.src.Performers[ id=" + id + " ]";
    }
    
}
