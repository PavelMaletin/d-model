/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.vist.model_src.src;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author chernov
 */
@Entity
@Table(name = "SOTRUD", catalog = "", schema = "AC_STAT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sotrud.findAll", query = "SELECT s FROM Sotrud s"),
    @NamedQuery(name = "Sotrud.findBySotrudK", query = "SELECT s FROM Sotrud s WHERE s.sotrudK = :sotrudK"),
    @NamedQuery(name = "Sotrud.findBySotrudFam", query = "SELECT s FROM Sotrud s WHERE s.sotrudFam = :sotrudFam"),
    @NamedQuery(name = "Sotrud.findBySotrudIm", query = "SELECT s FROM Sotrud s WHERE s.sotrudIm = :sotrudIm"),
    @NamedQuery(name = "Sotrud.findBySotrudOtch", query = "SELECT s FROM Sotrud s WHERE s.sotrudOtch = :sotrudOtch"),
    @NamedQuery(name = "Sotrud.findByPredprK", query = "SELECT s FROM Sotrud s WHERE s.predprK = :predprK"),
    @NamedQuery(name = "Sotrud.findBySluzhbK", query = "SELECT s FROM Sotrud s WHERE s.sluzhbK = :sluzhbK"),
    @NamedQuery(name = "Sotrud.findByKpkK", query = "SELECT s FROM Sotrud s WHERE s.kpkK = :kpkK"),
    @NamedQuery(name = "Sotrud.findByTabelKadr", query = "SELECT s FROM Sotrud s WHERE s.tabelKadr = :tabelKadr"),
    @NamedQuery(name = "Sotrud.findByDel", query = "SELECT s FROM Sotrud s WHERE s.del = :del"),
    @NamedQuery(name = "Sotrud.findByTelephone", query = "SELECT s FROM Sotrud s WHERE s.telephone = :telephone"),
    @NamedQuery(name = "Sotrud.findByContent", query = "SELECT s FROM Sotrud s WHERE s.content = :content"),
    @NamedQuery(name = "Sotrud.findByBirthDate", query = "SELECT s FROM Sotrud s WHERE s.birthDate = :birthDate"),
    @NamedQuery(name = "Sotrud.findByCardId", query = "SELECT s FROM Sotrud s WHERE s.cardId = :cardId"),
    @NamedQuery(name = "Sotrud.findByPin", query = "SELECT s FROM Sotrud s WHERE s.pin = :pin"),
    @NamedQuery(name = "Sotrud.findByIsmembercontrol", query = "SELECT s FROM Sotrud s WHERE s.ismembercontrol = :ismembercontrol"),
    @NamedQuery(name = "Sotrud.findByRoute", query = "SELECT s FROM Sotrud s WHERE s.route = :route"),
    @NamedQuery(name = "Sotrud.findByTabelSpusk", query = "SELECT s FROM Sotrud s WHERE s.tabelSpusk = :tabelSpusk"),
    @NamedQuery(name = "Sotrud.findByTabelSpusk2", query = "SELECT s FROM Sotrud s WHERE s.tabelSpusk2 = :tabelSpusk2"),
    @NamedQuery(name = "Sotrud.findByPriority", query = "SELECT s FROM Sotrud s WHERE s.priority = :priority"),
    @NamedQuery(name = "Sotrud.findByWindow", query = "SELECT s FROM Sotrud s WHERE s.window = :window"),
    @NamedQuery(name = "Sotrud.findBySubwindow", query = "SELECT s FROM Sotrud s WHERE s.subwindow = :subwindow"),
    @NamedQuery(name = "Sotrud.findByVgk", query = "SELECT s FROM Sotrud s WHERE s.vgk = :vgk"),
    @NamedQuery(name = "Sotrud.findByHiredDate", query = "SELECT s FROM Sotrud s WHERE s.hiredDate = :hiredDate"),
    @NamedQuery(name = "Sotrud.findByEmail", query = "SELECT s FROM Sotrud s WHERE s.email = :email"),
    @NamedQuery(name = "Sotrud.findByDriverLicense", query = "SELECT s FROM Sotrud s WHERE s.driverLicense = :driverLicense")})
public class Sotrud implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "SOTRUD_K", nullable = false)
    private Integer sotrudK;
    @Column(name = "SOTRUD_FAM", length = 60)
    private String sotrudFam;
    @Column(name = "SOTRUD_IM", length = 100)
    private String sotrudIm;
    @Column(name = "SOTRUD_OTCH", length = 100)
    private String sotrudOtch;
    @Column(name = "PREDPR_K")
    private Integer predprK;
    @Column(name = "SLUZHB_K")
    private Integer sluzhbK;
    @Column(name = "KPK_K")
    private Integer kpkK;
    @Column(name = "TABEL_KADR")
    private BigInteger tabelKadr;
    @Column(name = "DEL", length = 1)
    private String del;
    @Column(name = "TELEPHONE", length = 100)
    private String telephone;
    @Lob
    @Column(name = "AUTOGRAPH")
    private Serializable autograph;
    @Column(name = "CONTENT", length = 1)
    private String content;
    @Column(name = "BIRTH_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date birthDate;
    @Column(name = "CARD_ID")
    private BigInteger cardId;
    @Column(name = "PIN")
    private BigInteger pin;
    @Column(name = "ISMEMBERCONTROL", length = 3)
    private String ismembercontrol;
    @Column(name = "ROUTE")
    private BigInteger route;
    @Column(name = "TABEL_SPUSK", length = 1000)
    private String tabelSpusk;
    @Column(name = "TABEL_SPUSK2", length = 1000)
    private String tabelSpusk2;
    @Column(name = "PRIORITY")
    private BigInteger priority;
    @Column(name = "WINDOW")
    private BigInteger window;
    @Column(name = "SUBWINDOW")
    private BigInteger subwindow;
    @Column(name = "VGK", length = 3)
    private String vgk;
    @Column(name = "HIRED_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date hiredDate;
    @Column(name = "EMAIL", length = 100)
    private String email;
    @Column(name = "DRIVER_LICENSE", length = 500)
    private String driverLicense;
    @Lob
    @Column(name = "FOTO")
    private Serializable foto;
    @OneToMany(mappedBy = "dirK")
    private List<Predpr> predprList;
    @OneToMany(mappedBy = "nachK")
    private List<Uchast> uchastList;
    @OneToMany(mappedBy = "sotrudK")
    private List<Performers> performersList;
    @JoinColumn(name = "USER_ID", referencedColumnName = "USER_ID")
    @ManyToOne
    private Users userId;
    @JoinColumn(name = "UCHAST_K", referencedColumnName = "UCHAST_K")
    @ManyToOne
    private Uchast uchastK;
    @JoinColumn(name = "DOLJ_K", referencedColumnName = "KOD")
    @ManyToOne
    private Doljnost doljK;

    public Sotrud() {
    }

    public Sotrud(Integer sotrudK) {
        this.sotrudK = sotrudK;
    }

    public Integer getSotrudK() {
        return sotrudK;
    }

    public void setSotrudK(Integer sotrudK) {
        this.sotrudK = sotrudK;
    }

    public String getSotrudFam() {
        return sotrudFam;
    }

    public void setSotrudFam(String sotrudFam) {
        this.sotrudFam = sotrudFam;
    }

    public String getSotrudIm() {
        return sotrudIm;
    }

    public void setSotrudIm(String sotrudIm) {
        this.sotrudIm = sotrudIm;
    }

    public String getSotrudOtch() {
        return sotrudOtch;
    }

    public void setSotrudOtch(String sotrudOtch) {
        this.sotrudOtch = sotrudOtch;
    }

    public Integer getPredprK() {
        return predprK;
    }

    public void setPredprK(Integer predprK) {
        this.predprK = predprK;
    }

    public Integer getSluzhbK() {
        return sluzhbK;
    }

    public void setSluzhbK(Integer sluzhbK) {
        this.sluzhbK = sluzhbK;
    }

    public Integer getKpkK() {
        return kpkK;
    }

    public void setKpkK(Integer kpkK) {
        this.kpkK = kpkK;
    }

    public BigInteger getTabelKadr() {
        return tabelKadr;
    }

    public void setTabelKadr(BigInteger tabelKadr) {
        this.tabelKadr = tabelKadr;
    }

    public String getDel() {
        return del;
    }

    public void setDel(String del) {
        this.del = del;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Serializable getAutograph() {
        return autograph;
    }

    public void setAutograph(Serializable autograph) {
        this.autograph = autograph;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public BigInteger getCardId() {
        return cardId;
    }

    public void setCardId(BigInteger cardId) {
        this.cardId = cardId;
    }

    public BigInteger getPin() {
        return pin;
    }

    public void setPin(BigInteger pin) {
        this.pin = pin;
    }

    public String getIsmembercontrol() {
        return ismembercontrol;
    }

    public void setIsmembercontrol(String ismembercontrol) {
        this.ismembercontrol = ismembercontrol;
    }

    public BigInteger getRoute() {
        return route;
    }

    public void setRoute(BigInteger route) {
        this.route = route;
    }

    public String getTabelSpusk() {
        return tabelSpusk;
    }

    public void setTabelSpusk(String tabelSpusk) {
        this.tabelSpusk = tabelSpusk;
    }

    public String getTabelSpusk2() {
        return tabelSpusk2;
    }

    public void setTabelSpusk2(String tabelSpusk2) {
        this.tabelSpusk2 = tabelSpusk2;
    }

    public BigInteger getPriority() {
        return priority;
    }

    public void setPriority(BigInteger priority) {
        this.priority = priority;
    }

    public BigInteger getWindow() {
        return window;
    }

    public void setWindow(BigInteger window) {
        this.window = window;
    }

    public BigInteger getSubwindow() {
        return subwindow;
    }

    public void setSubwindow(BigInteger subwindow) {
        this.subwindow = subwindow;
    }

    public String getVgk() {
        return vgk;
    }

    public void setVgk(String vgk) {
        this.vgk = vgk;
    }

    public Date getHiredDate() {
        return hiredDate;
    }

    public void setHiredDate(Date hiredDate) {
        this.hiredDate = hiredDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDriverLicense() {
        return driverLicense;
    }

    public void setDriverLicense(String driverLicense) {
        this.driverLicense = driverLicense;
    }

    public Serializable getFoto() {
        return foto;
    }

    public void setFoto(Serializable foto) {
        this.foto = foto;
    }

    @XmlTransient
    public List<Predpr> getPredprList() {
        return predprList;
    }

    public void setPredprList(List<Predpr> predprList) {
        this.predprList = predprList;
    }

    @XmlTransient
    public List<Uchast> getUchastList() {
        return uchastList;
    }

    public void setUchastList(List<Uchast> uchastList) {
        this.uchastList = uchastList;
    }

    @XmlTransient
    public List<Performers> getPerformersList() {
        return performersList;
    }

    public void setPerformersList(List<Performers> performersList) {
        this.performersList = performersList;
    }

    public Users getUserId() {
        return userId;
    }

    public void setUserId(Users userId) {
        this.userId = userId;
    }

    public Uchast getUchastK() {
        return uchastK;
    }

    public void setUchastK(Uchast uchastK) {
        this.uchastK = uchastK;
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
        hash += (sotrudK != null ? sotrudK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sotrud))
            return false;
        Sotrud other = (Sotrud) object;
        if ((this.sotrudK == null && other.sotrudK != null) || (this.sotrudK != null && !this.sotrudK.equals(other.sotrudK)))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "ru.vist.model.src.Sotrud[ sotrudK=" + sotrudK + " ]";
    }
    
}
