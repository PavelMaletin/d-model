/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.vist.model_src.src;

import java.io.Serializable;
import java.math.BigDecimal;
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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author chernov
 */
@Entity
@Table(name = "DOLJNOST", catalog = "", schema = "AC_STAT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Doljnost.findAll", query = "SELECT d FROM Doljnost d"),
    @NamedQuery(name = "Doljnost.findByKod", query = "SELECT d FROM Doljnost d WHERE d.kod = :kod"),
    @NamedQuery(name = "Doljnost.findByText", query = "SELECT d FROM Doljnost d WHERE d.text = :text"),
    @NamedQuery(name = "Doljnost.findByDel", query = "SELECT d FROM Doljnost d WHERE d.del = :del"),
    @NamedQuery(name = "Doljnost.findByVyd", query = "SELECT d FROM Doljnost d WHERE d.vyd = :vyd"),
    @NamedQuery(name = "Doljnost.findByIsp", query = "SELECT d FROM Doljnost d WHERE d.isp = :isp"),
    @NamedQuery(name = "Doljnost.findByUved", query = "SELECT d FROM Doljnost d WHERE d.uved = :uved"),
    @NamedQuery(name = "Doljnost.findByParentKod", query = "SELECT d FROM Doljnost d WHERE d.parentKod = :parentKod"),
    @NamedQuery(name = "Doljnost.findBySmenK", query = "SELECT d FROM Doljnost d WHERE d.smenK = :smenK"),
    @NamedQuery(name = "Doljnost.findByPriority", query = "SELECT d FROM Doljnost d WHERE d.priority = :priority"),
    @NamedQuery(name = "Doljnost.findByNaim", query = "SELECT d FROM Doljnost d WHERE d.naim = :naim"),
    @NamedQuery(name = "Doljnost.findByVtb", query = "SELECT d FROM Doljnost d WHERE d.vtb = :vtb")})
public class Doljnost implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "KOD", nullable = false, precision = 0, scale = -127)
    private BigDecimal kod;
    @Column(name = "TEXT", length = 255)
    private String text;
    @Column(name = "DEL", length = 1)
    private String del;
    @Column(name = "VYD", length = 1)
    private String vyd;
    @Column(name = "ISP", length = 1)
    private String isp;
    @Column(name = "UVED", length = 1)
    private String uved;
    @Column(name = "PARENT_KOD")
    private Integer parentKod;
    @Column(name = "SMEN_K")
    private BigInteger smenK;
    @Column(name = "PRIORITY")
    private BigInteger priority;
    @Column(name = "NAIM", length = 255)
    private String naim;
    @Column(name = "VTB", length = 1)
    private String vtb;
    @JoinColumn(name = "PREDPR_K", referencedColumnName = "PREDPR_K")
    @ManyToOne
    private Predpr predprK;
    @OneToMany(mappedBy = "doljK")
    private List<Performers> performersList;
    @OneToMany(mappedBy = "doljK")
    private List<Sotrud> sotrudList;

    public Doljnost() {
    }

    public Doljnost(BigDecimal kod) {
        this.kod = kod;
    }

    public BigDecimal getKod() {
        return kod;
    }

    public void setKod(BigDecimal kod) {
        this.kod = kod;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getDel() {
        return del;
    }

    public void setDel(String del) {
        this.del = del;
    }

    public String getVyd() {
        return vyd;
    }

    public void setVyd(String vyd) {
        this.vyd = vyd;
    }

    public String getIsp() {
        return isp;
    }

    public void setIsp(String isp) {
        this.isp = isp;
    }

    public String getUved() {
        return uved;
    }

    public void setUved(String uved) {
        this.uved = uved;
    }

    public Integer getParentKod() {
        return parentKod;
    }

    public void setParentKod(Integer parentKod) {
        this.parentKod = parentKod;
    }

    public BigInteger getSmenK() {
        return smenK;
    }

    public void setSmenK(BigInteger smenK) {
        this.smenK = smenK;
    }

    public BigInteger getPriority() {
        return priority;
    }

    public void setPriority(BigInteger priority) {
        this.priority = priority;
    }

    public String getNaim() {
        return naim;
    }

    public void setNaim(String naim) {
        this.naim = naim;
    }

    public String getVtb() {
        return vtb;
    }

    public void setVtb(String vtb) {
        this.vtb = vtb;
    }

    public Predpr getPredprK() {
        return predprK;
    }

    public void setPredprK(Predpr predprK) {
        this.predprK = predprK;
    }

    @XmlTransient
    public List<Performers> getPerformersList() {
        return performersList;
    }

    public void setPerformersList(List<Performers> performersList) {
        this.performersList = performersList;
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
        hash += (kod != null ? kod.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Doljnost))
            return false;
        Doljnost other = (Doljnost) object;
        if ((this.kod == null && other.kod != null) || (this.kod != null && !this.kod.equals(other.kod)))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "ru.vist.model.src.Doljnost[ kod=" + kod + " ]";
    }
    
}
