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
@Table(name = "PREDPIS", catalog = "", schema = "AC_STAT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Predpis.findAll", query = "SELECT p FROM Predpis p"),
    @NamedQuery(name = "Predpis.findByPredpisK", query = "SELECT p FROM Predpis p WHERE p.predpisK = :predpisK"),
    @NamedQuery(name = "Predpis.findByObjedK", query = "SELECT p FROM Predpis p WHERE p.objedK = :objedK"),
    @NamedQuery(name = "Predpis.findByPredprK", query = "SELECT p FROM Predpis p WHERE p.predprK = :predprK"),
    @NamedQuery(name = "Predpis.findByUchastK", query = "SELECT p FROM Predpis p WHERE p.uchastK = :uchastK"),
    @NamedQuery(name = "Predpis.findByUchastTipK", query = "SELECT p FROM Predpis p WHERE p.uchastTipK = :uchastTipK"),
    @NamedQuery(name = "Predpis.findByNachK", query = "SELECT p FROM Predpis p WHERE p.nachK = :nachK"),
    @NamedQuery(name = "Predpis.findByBrigadK", query = "SELECT p FROM Predpis p WHERE p.brigadK = :brigadK"),
    @NamedQuery(name = "Predpis.findByBrigadTipK", query = "SELECT p FROM Predpis p WHERE p.brigadTipK = :brigadTipK"),
    @NamedQuery(name = "Predpis.findByBrigadTekst", query = "SELECT p FROM Predpis p WHERE p.brigadTekst = :brigadTekst"),
    @NamedQuery(name = "Predpis.findByZamechK", query = "SELECT p FROM Predpis p WHERE p.zamechK = :zamechK"),
    @NamedQuery(name = "Predpis.findByZamechTekst", query = "SELECT p FROM Predpis p WHERE p.zamechTekst = :zamechTekst"),
    @NamedQuery(name = "Predpis.findByBal", query = "SELECT p FROM Predpis p WHERE p.bal = :bal"),
    @NamedQuery(name = "Predpis.findByVer", query = "SELECT p FROM Predpis p WHERE p.ver = :ver"),
    @NamedQuery(name = "Predpis.findByVydData", query = "SELECT p FROM Predpis p WHERE p.vydData = :vydData"),
    @NamedQuery(name = "Predpis.findByVydSotrK", query = "SELECT p FROM Predpis p WHERE p.vydSotrK = :vydSotrK"),
    @NamedQuery(name = "Predpis.findByUvData", query = "SELECT p FROM Predpis p WHERE p.uvData = :uvData"),
    @NamedQuery(name = "Predpis.findByUvSotrK", query = "SELECT p FROM Predpis p WHERE p.uvSotrK = :uvSotrK"),
    @NamedQuery(name = "Predpis.findByIspData", query = "SELECT p FROM Predpis p WHERE p.ispData = :ispData"),
    @NamedQuery(name = "Predpis.findByIspSotrK", query = "SELECT p FROM Predpis p WHERE p.ispSotrK = :ispSotrK"),
    @NamedQuery(name = "Predpis.findByIspSrok", query = "SELECT p FROM Predpis p WHERE p.ispSrok = :ispSrok"),
    @NamedQuery(name = "Predpis.findByStopPrizn", query = "SELECT p FROM Predpis p WHERE p.stopPrizn = :stopPrizn"),
    @NamedQuery(name = "Predpis.findByFreetext", query = "SELECT p FROM Predpis p WHERE p.freetext = :freetext"),
    @NamedQuery(name = "Predpis.findByPresence", query = "SELECT p FROM Predpis p WHERE p.presence = :presence"),
    @NamedQuery(name = "Predpis.findByTip", query = "SELECT p FROM Predpis p WHERE p.tip = :tip"),
    @NamedQuery(name = "Predpis.findByDoljnost", query = "SELECT p FROM Predpis p WHERE p.doljnost = :doljnost"),
    @NamedQuery(name = "Predpis.findByRisk", query = "SELECT p FROM Predpis p WHERE p.risk = :risk"),
    @NamedQuery(name = "Predpis.findByArrangement", query = "SELECT p FROM Predpis p WHERE p.arrangement = :arrangement"),
    @NamedQuery(name = "Predpis.findByOznakomlenie", query = "SELECT p FROM Predpis p WHERE p.oznakomlenie = :oznakomlenie"),
    @NamedQuery(name = "Predpis.findByPredpisTipK", query = "SELECT p FROM Predpis p WHERE p.predpisTipK = :predpisTipK"),
    @NamedQuery(name = "Predpis.findByPlanFakt", query = "SELECT p FROM Predpis p WHERE p.planFakt = :planFakt"),
    @NamedQuery(name = "Predpis.findByNarushitK", query = "SELECT p FROM Predpis p WHERE p.narushitK = :narushitK"),
    @NamedQuery(name = "Predpis.findByApprovedK", query = "SELECT p FROM Predpis p WHERE p.approvedK = :approvedK"),
    @NamedQuery(name = "Predpis.findByIsBlank", query = "SELECT p FROM Predpis p WHERE p.isBlank = :isBlank"),
    @NamedQuery(name = "Predpis.findByRoute", query = "SELECT p FROM Predpis p WHERE p.route = :route"),
    @NamedQuery(name = "Predpis.findByPriority", query = "SELECT p FROM Predpis p WHERE p.priority = :priority"),
    @NamedQuery(name = "Predpis.findBySmena", query = "SELECT p FROM Predpis p WHERE p.smena = :smena"),
    @NamedQuery(name = "Predpis.findByReasons", query = "SELECT p FROM Predpis p WHERE p.reasons = :reasons"),
    @NamedQuery(name = "Predpis.findByPlan", query = "SELECT p FROM Predpis p WHERE p.plan = :plan"),
    @NamedQuery(name = "Predpis.findByEdIzm", query = "SELECT p FROM Predpis p WHERE p.edIzm = :edIzm"),
    @NamedQuery(name = "Predpis.findByPlanFaktT", query = "SELECT p FROM Predpis p WHERE p.planFaktT = :planFaktT"),
    @NamedQuery(name = "Predpis.findByNpp", query = "SELECT p FROM Predpis p WHERE p.npp = :npp"),
    @NamedQuery(name = "Predpis.findByOperationK", query = "SELECT p FROM Predpis p WHERE p.operationK = :operationK"),
    @NamedQuery(name = "Predpis.findByOperationText", query = "SELECT p FROM Predpis p WHERE p.operationText = :operationText"),
    @NamedQuery(name = "Predpis.findBySmenK", query = "SELECT p FROM Predpis p WHERE p.smenK = :smenK"),
    @NamedQuery(name = "Predpis.findBySutki", query = "SELECT p FROM Predpis p WHERE p.sutki = :sutki"),
    @NamedQuery(name = "Predpis.findByIsapproved", query = "SELECT p FROM Predpis p WHERE p.isapproved = :isapproved"),
    @NamedQuery(name = "Predpis.findByIsapprovedsotrudk", query = "SELECT p FROM Predpis p WHERE p.isapprovedsotrudk = :isapprovedsotrudk"),
    @NamedQuery(name = "Predpis.findByIsapproveddata", query = "SELECT p FROM Predpis p WHERE p.isapproveddata = :isapproveddata"),
    @NamedQuery(name = "Predpis.findByIsapproveddoljnaim", query = "SELECT p FROM Predpis p WHERE p.isapproveddoljnaim = :isapproveddoljnaim"),
    @NamedQuery(name = "Predpis.findByNaryadDopuskN", query = "SELECT p FROM Predpis p WHERE p.naryadDopuskN = :naryadDopuskN"),
    @NamedQuery(name = "Predpis.findByManufactory", query = "SELECT p FROM Predpis p WHERE p.manufactory = :manufactory"),
    @NamedQuery(name = "Predpis.findByN01", query = "SELECT p FROM Predpis p WHERE p.n01 = :n01"),
    @NamedQuery(name = "Predpis.findByN02", query = "SELECT p FROM Predpis p WHERE p.n02 = :n02"),
    @NamedQuery(name = "Predpis.findByN03", query = "SELECT p FROM Predpis p WHERE p.n03 = :n03"),
    @NamedQuery(name = "Predpis.findByN04", query = "SELECT p FROM Predpis p WHERE p.n04 = :n04"),
    @NamedQuery(name = "Predpis.findByN05", query = "SELECT p FROM Predpis p WHERE p.n05 = :n05"),
    @NamedQuery(name = "Predpis.findByN06", query = "SELECT p FROM Predpis p WHERE p.n06 = :n06"),
    @NamedQuery(name = "Predpis.findByN07", query = "SELECT p FROM Predpis p WHERE p.n07 = :n07"),
    @NamedQuery(name = "Predpis.findByN08", query = "SELECT p FROM Predpis p WHERE p.n08 = :n08"),
    @NamedQuery(name = "Predpis.findByN09", query = "SELECT p FROM Predpis p WHERE p.n09 = :n09"),
    @NamedQuery(name = "Predpis.findByN10", query = "SELECT p FROM Predpis p WHERE p.n10 = :n10"),
    @NamedQuery(name = "Predpis.findByN11", query = "SELECT p FROM Predpis p WHERE p.n11 = :n11"),
    @NamedQuery(name = "Predpis.findByN12", query = "SELECT p FROM Predpis p WHERE p.n12 = :n12"),
    @NamedQuery(name = "Predpis.findByN13", query = "SELECT p FROM Predpis p WHERE p.n13 = :n13"),
    @NamedQuery(name = "Predpis.findByN14", query = "SELECT p FROM Predpis p WHERE p.n14 = :n14"),
    @NamedQuery(name = "Predpis.findByNaryadTipK", query = "SELECT p FROM Predpis p WHERE p.naryadTipK = :naryadTipK"),
    @NamedQuery(name = "Predpis.findByDopsafetynorms", query = "SELECT p FROM Predpis p WHERE p.dopsafetynorms = :dopsafetynorms"),
    @NamedQuery(name = "Predpis.findByWorkStart", query = "SELECT p FROM Predpis p WHERE p.workStart = :workStart"),
    @NamedQuery(name = "Predpis.findByWorkEnd", query = "SELECT p FROM Predpis p WHERE p.workEnd = :workEnd"),
    @NamedQuery(name = "Predpis.findByFreightLoad", query = "SELECT p FROM Predpis p WHERE p.freightLoad = :freightLoad"),
    @NamedQuery(name = "Predpis.findByPicketLoad", query = "SELECT p FROM Predpis p WHERE p.picketLoad = :picketLoad"),
    @NamedQuery(name = "Predpis.findByFreightUnload", query = "SELECT p FROM Predpis p WHERE p.freightUnload = :freightUnload"),
    @NamedQuery(name = "Predpis.findByPicketUnload", query = "SELECT p FROM Predpis p WHERE p.picketUnload = :picketUnload"),
    @NamedQuery(name = "Predpis.findByForCopy", query = "SELECT p FROM Predpis p WHERE p.forCopy = :forCopy"),
    @NamedQuery(name = "Predpis.findByIsEditNaryad", query = "SELECT p FROM Predpis p WHERE p.isEditNaryad = :isEditNaryad"),
    @NamedQuery(name = "Predpis.findByTakenNaryad", query = "SELECT p FROM Predpis p WHERE p.takenNaryad = :takenNaryad"),
    @NamedQuery(name = "Predpis.findByPriostanovka", query = "SELECT p FROM Predpis p WHERE p.priostanovka = :priostanovka"),
    @NamedQuery(name = "Predpis.findByFaktorK", query = "SELECT p FROM Predpis p WHERE p.faktorK = :faktorK"),
    @NamedQuery(name = "Predpis.findByIsRequiredNaryad", query = "SELECT p FROM Predpis p WHERE p.isRequiredNaryad = :isRequiredNaryad"),
    @NamedQuery(name = "Predpis.findByIsSendedNaryad", query = "SELECT p FROM Predpis p WHERE p.isSendedNaryad = :isSendedNaryad"),
    @NamedQuery(name = "Predpis.findByTechnicalCondition", query = "SELECT p FROM Predpis p WHERE p.technicalCondition = :technicalCondition"),
    @NamedQuery(name = "Predpis.findByIsEditNaryadProizvSluzhb", query = "SELECT p FROM Predpis p WHERE p.isEditNaryadProizvSluzhb = :isEditNaryadProizvSluzhb"),
    @NamedQuery(name = "Predpis.findByTrailer", query = "SELECT p FROM Predpis p WHERE p.trailer = :trailer"),
    @NamedQuery(name = "Predpis.findByRouteVtb", query = "SELECT p FROM Predpis p WHERE p.routeVtb = :routeVtb")})
public class Predpis implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "PREDPIS_K", nullable = false)
    private Integer predpisK;
    @Column(name = "OBJED_K")
    private Integer objedK;
    @Column(name = "PREDPR_K")
    private Integer predprK;
    @Column(name = "UCHAST_K")
    private Integer uchastK;
    @Column(name = "UCHAST_TIP_K")
    private Integer uchastTipK;
    @Column(name = "NACH_K")
    private Integer nachK;
    @Column(name = "BRIGAD_K")
    private Integer brigadK;
    @Column(name = "BRIGAD_TIP_K")
    private Integer brigadTipK;
    @Column(name = "BRIGAD_TEKST", length = 4000)
    private String brigadTekst;
    @Column(name = "ZAMECH_K")
    private Integer zamechK;
    @Column(name = "ZAMECH_TEKST", length = 4000)
    private String zamechTekst;
    @Column(name = "BAL")
    private BigInteger bal;
    @Column(name = "VER")
    private BigInteger ver;
    @Column(name = "VYD_DATA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date vydData;
    @Column(name = "VYD_SOTR_K")
    private Integer vydSotrK;
    @Column(name = "UV_DATA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date uvData;
    @Column(name = "UV_SOTR_K")
    private Integer uvSotrK;
    @Column(name = "ISP_DATA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ispData;
    @Column(name = "ISP_SOTR_K")
    private Integer ispSotrK;
    @Column(name = "ISP_SROK")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ispSrok;
    @Column(name = "STOP_PRIZN", length = 1)
    private String stopPrizn;
    @Column(name = "FREETEXT", length = 4000)
    private String freetext;
    @Column(name = "PRESENCE", length = 4000)
    private String presence;
    @Column(name = "TIP")
    private Integer tip;
    @Column(name = "DOLJNOST")
    private Integer doljnost;
    @Column(name = "RISK", length = 50)
    private String risk;
    @Column(name = "ARRANGEMENT", length = 4000)
    private String arrangement;
    @Column(name = "OZNAKOMLENIE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date oznakomlenie;
    @Column(name = "PREDPIS_TIP_K")
    private BigInteger predpisTipK;
    @Column(name = "PLAN_FAKT")
    private BigInteger planFakt;
    @Column(name = "NARUSHIT_K")
    private BigInteger narushitK;
    @Column(name = "APPROVED_K")
    private BigInteger approvedK;
    @Column(name = "IS_BLANK", length = 1)
    private String isBlank;
    @Column(name = "ROUTE")
    private BigInteger route;
    @Column(name = "PRIORITY")
    private BigInteger priority;
    @Column(name = "SMENA", length = 100)
    private String smena;
    @Column(name = "REASONS", length = 4000)
    private String reasons;
    @Column(name = "PLAN", length = 100)
    private String plan;
    @Column(name = "ED_IZM", length = 100)
    private String edIzm;
    @Column(name = "PLAN_FAKT_T", length = 100)
    private String planFaktT;
    @Column(name = "NPP")
    private BigInteger npp;
    @Column(name = "OPERATION_K")
    private BigInteger operationK;
    @Column(name = "OPERATION_TEXT", length = 300)
    private String operationText;
    @Column(name = "SMEN_K")
    private BigInteger smenK;
    @Column(name = "SUTKI")
    private BigInteger sutki;
    @Column(name = "ISAPPROVED", length = 1)
    private String isapproved;
    @Column(name = "ISAPPROVEDSOTRUDK")
    private BigInteger isapprovedsotrudk;
    @Column(name = "ISAPPROVEDDATA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date isapproveddata;
    @Column(name = "ISAPPROVEDDOLJNAIM", length = 500)
    private String isapproveddoljnaim;
    @Column(name = "NARYAD_DOPUSK_N")
    private BigInteger naryadDopuskN;
    @Column(name = "MANUFACTORY", length = 4000)
    private String manufactory;
    @Column(name = "N_01")
    private BigInteger n01;
    @Column(name = "N_02")
    private BigInteger n02;
    @Column(name = "N_03")
    private BigInteger n03;
    @Column(name = "N_04")
    private BigInteger n04;
    @Column(name = "N_05")
    private BigInteger n05;
    @Column(name = "N_06")
    private BigInteger n06;
    @Column(name = "N_07")
    private BigInteger n07;
    @Column(name = "N_08")
    private BigInteger n08;
    @Column(name = "N_09")
    private BigInteger n09;
    @Column(name = "N_10")
    private BigInteger n10;
    @Column(name = "N_11")
    private BigInteger n11;
    @Column(name = "N_12")
    private BigInteger n12;
    @Column(name = "N_13")
    private BigInteger n13;
    @Column(name = "N_14")
    private BigInteger n14;
    @Column(name = "NARYAD_TIP_K")
    private BigInteger naryadTipK;
    @Column(name = "DOPSAFETYNORMS", length = 4000)
    private String dopsafetynorms;
    @Column(name = "WORK_START")
    @Temporal(TemporalType.TIMESTAMP)
    private Date workStart;
    @Column(name = "WORK_END")
    @Temporal(TemporalType.TIMESTAMP)
    private Date workEnd;
    @Column(name = "FREIGHT_LOAD", length = 500)
    private String freightLoad;
    @Column(name = "PICKET_LOAD", length = 500)
    private String picketLoad;
    @Column(name = "FREIGHT_UNLOAD", length = 500)
    private String freightUnload;
    @Column(name = "PICKET_UNLOAD", length = 500)
    private String picketUnload;
    @Column(name = "FOR_COPY")
    private BigInteger forCopy;
    @Column(name = "IS_EDIT_NARYAD", length = 1)
    private String isEditNaryad;
    @Column(name = "TAKEN_NARYAD")
    private BigInteger takenNaryad;
    @Column(name = "PRIOSTANOVKA", length = 1)
    private String priostanovka;
    @Column(name = "FAKTOR_K")
    private BigInteger faktorK;
    @Column(name = "IS_REQUIRED_NARYAD", length = 1)
    private String isRequiredNaryad;
    @Column(name = "IS_SENDED_NARYAD", length = 1)
    private String isSendedNaryad;
    @Column(name = "TECHNICAL_CONDITION", length = 500)
    private String technicalCondition;
    @Column(name = "IS_EDIT_NARYAD_PROIZV_SLUZHB", length = 1)
    private String isEditNaryadProizvSluzhb;
    @Column(name = "TRAILER")
    private BigInteger trailer;
    @Column(name = "ROUTE_VTB", length = 500)
    private String routeVtb;
    @OneToMany(mappedBy = "predpisK")
    private List<Performers> performersList;

    public Predpis() {
    }

    public Predpis(Integer predpisK) {
        this.predpisK = predpisK;
    }

    public Integer getPredpisK() {
        return predpisK;
    }

    public void setPredpisK(Integer predpisK) {
        this.predpisK = predpisK;
    }

    public Integer getObjedK() {
        return objedK;
    }

    public void setObjedK(Integer objedK) {
        this.objedK = objedK;
    }

    public Integer getPredprK() {
        return predprK;
    }

    public void setPredprK(Integer predprK) {
        this.predprK = predprK;
    }

    public Integer getUchastK() {
        return uchastK;
    }

    public void setUchastK(Integer uchastK) {
        this.uchastK = uchastK;
    }

    public Integer getUchastTipK() {
        return uchastTipK;
    }

    public void setUchastTipK(Integer uchastTipK) {
        this.uchastTipK = uchastTipK;
    }

    public Integer getNachK() {
        return nachK;
    }

    public void setNachK(Integer nachK) {
        this.nachK = nachK;
    }

    public Integer getBrigadK() {
        return brigadK;
    }

    public void setBrigadK(Integer brigadK) {
        this.brigadK = brigadK;
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

    public Integer getZamechK() {
        return zamechK;
    }

    public void setZamechK(Integer zamechK) {
        this.zamechK = zamechK;
    }

    public String getZamechTekst() {
        return zamechTekst;
    }

    public void setZamechTekst(String zamechTekst) {
        this.zamechTekst = zamechTekst;
    }

    public BigInteger getBal() {
        return bal;
    }

    public void setBal(BigInteger bal) {
        this.bal = bal;
    }

    public BigInteger getVer() {
        return ver;
    }

    public void setVer(BigInteger ver) {
        this.ver = ver;
    }

    public Date getVydData() {
        return vydData;
    }

    public void setVydData(Date vydData) {
        this.vydData = vydData;
    }

    public Integer getVydSotrK() {
        return vydSotrK;
    }

    public void setVydSotrK(Integer vydSotrK) {
        this.vydSotrK = vydSotrK;
    }

    public Date getUvData() {
        return uvData;
    }

    public void setUvData(Date uvData) {
        this.uvData = uvData;
    }

    public Integer getUvSotrK() {
        return uvSotrK;
    }

    public void setUvSotrK(Integer uvSotrK) {
        this.uvSotrK = uvSotrK;
    }

    public Date getIspData() {
        return ispData;
    }

    public void setIspData(Date ispData) {
        this.ispData = ispData;
    }

    public Integer getIspSotrK() {
        return ispSotrK;
    }

    public void setIspSotrK(Integer ispSotrK) {
        this.ispSotrK = ispSotrK;
    }

    public Date getIspSrok() {
        return ispSrok;
    }

    public void setIspSrok(Date ispSrok) {
        this.ispSrok = ispSrok;
    }

    public String getStopPrizn() {
        return stopPrizn;
    }

    public void setStopPrizn(String stopPrizn) {
        this.stopPrizn = stopPrizn;
    }

    public String getFreetext() {
        return freetext;
    }

    public void setFreetext(String freetext) {
        this.freetext = freetext;
    }

    public String getPresence() {
        return presence;
    }

    public void setPresence(String presence) {
        this.presence = presence;
    }

    public Integer getTip() {
        return tip;
    }

    public void setTip(Integer tip) {
        this.tip = tip;
    }

    public Integer getDoljnost() {
        return doljnost;
    }

    public void setDoljnost(Integer doljnost) {
        this.doljnost = doljnost;
    }

    public String getRisk() {
        return risk;
    }

    public void setRisk(String risk) {
        this.risk = risk;
    }

    public String getArrangement() {
        return arrangement;
    }

    public void setArrangement(String arrangement) {
        this.arrangement = arrangement;
    }

    public Date getOznakomlenie() {
        return oznakomlenie;
    }

    public void setOznakomlenie(Date oznakomlenie) {
        this.oznakomlenie = oznakomlenie;
    }

    public BigInteger getPredpisTipK() {
        return predpisTipK;
    }

    public void setPredpisTipK(BigInteger predpisTipK) {
        this.predpisTipK = predpisTipK;
    }

    public BigInteger getPlanFakt() {
        return planFakt;
    }

    public void setPlanFakt(BigInteger planFakt) {
        this.planFakt = planFakt;
    }

    public BigInteger getNarushitK() {
        return narushitK;
    }

    public void setNarushitK(BigInteger narushitK) {
        this.narushitK = narushitK;
    }

    public BigInteger getApprovedK() {
        return approvedK;
    }

    public void setApprovedK(BigInteger approvedK) {
        this.approvedK = approvedK;
    }

    public String getIsBlank() {
        return isBlank;
    }

    public void setIsBlank(String isBlank) {
        this.isBlank = isBlank;
    }

    public BigInteger getRoute() {
        return route;
    }

    public void setRoute(BigInteger route) {
        this.route = route;
    }

    public BigInteger getPriority() {
        return priority;
    }

    public void setPriority(BigInteger priority) {
        this.priority = priority;
    }

    public String getSmena() {
        return smena;
    }

    public void setSmena(String smena) {
        this.smena = smena;
    }

    public String getReasons() {
        return reasons;
    }

    public void setReasons(String reasons) {
        this.reasons = reasons;
    }

    public String getPlan() {
        return plan;
    }

    public void setPlan(String plan) {
        this.plan = plan;
    }

    public String getEdIzm() {
        return edIzm;
    }

    public void setEdIzm(String edIzm) {
        this.edIzm = edIzm;
    }

    public String getPlanFaktT() {
        return planFaktT;
    }

    public void setPlanFaktT(String planFaktT) {
        this.planFaktT = planFaktT;
    }

    public BigInteger getNpp() {
        return npp;
    }

    public void setNpp(BigInteger npp) {
        this.npp = npp;
    }

    public BigInteger getOperationK() {
        return operationK;
    }

    public void setOperationK(BigInteger operationK) {
        this.operationK = operationK;
    }

    public String getOperationText() {
        return operationText;
    }

    public void setOperationText(String operationText) {
        this.operationText = operationText;
    }

    public BigInteger getSmenK() {
        return smenK;
    }

    public void setSmenK(BigInteger smenK) {
        this.smenK = smenK;
    }

    public BigInteger getSutki() {
        return sutki;
    }

    public void setSutki(BigInteger sutki) {
        this.sutki = sutki;
    }

    public String getIsapproved() {
        return isapproved;
    }

    public void setIsapproved(String isapproved) {
        this.isapproved = isapproved;
    }

    public BigInteger getIsapprovedsotrudk() {
        return isapprovedsotrudk;
    }

    public void setIsapprovedsotrudk(BigInteger isapprovedsotrudk) {
        this.isapprovedsotrudk = isapprovedsotrudk;
    }

    public Date getIsapproveddata() {
        return isapproveddata;
    }

    public void setIsapproveddata(Date isapproveddata) {
        this.isapproveddata = isapproveddata;
    }

    public String getIsapproveddoljnaim() {
        return isapproveddoljnaim;
    }

    public void setIsapproveddoljnaim(String isapproveddoljnaim) {
        this.isapproveddoljnaim = isapproveddoljnaim;
    }

    public BigInteger getNaryadDopuskN() {
        return naryadDopuskN;
    }

    public void setNaryadDopuskN(BigInteger naryadDopuskN) {
        this.naryadDopuskN = naryadDopuskN;
    }

    public String getManufactory() {
        return manufactory;
    }

    public void setManufactory(String manufactory) {
        this.manufactory = manufactory;
    }

    public BigInteger getN01() {
        return n01;
    }

    public void setN01(BigInteger n01) {
        this.n01 = n01;
    }

    public BigInteger getN02() {
        return n02;
    }

    public void setN02(BigInteger n02) {
        this.n02 = n02;
    }

    public BigInteger getN03() {
        return n03;
    }

    public void setN03(BigInteger n03) {
        this.n03 = n03;
    }

    public BigInteger getN04() {
        return n04;
    }

    public void setN04(BigInteger n04) {
        this.n04 = n04;
    }

    public BigInteger getN05() {
        return n05;
    }

    public void setN05(BigInteger n05) {
        this.n05 = n05;
    }

    public BigInteger getN06() {
        return n06;
    }

    public void setN06(BigInteger n06) {
        this.n06 = n06;
    }

    public BigInteger getN07() {
        return n07;
    }

    public void setN07(BigInteger n07) {
        this.n07 = n07;
    }

    public BigInteger getN08() {
        return n08;
    }

    public void setN08(BigInteger n08) {
        this.n08 = n08;
    }

    public BigInteger getN09() {
        return n09;
    }

    public void setN09(BigInteger n09) {
        this.n09 = n09;
    }

    public BigInteger getN10() {
        return n10;
    }

    public void setN10(BigInteger n10) {
        this.n10 = n10;
    }

    public BigInteger getN11() {
        return n11;
    }

    public void setN11(BigInteger n11) {
        this.n11 = n11;
    }

    public BigInteger getN12() {
        return n12;
    }

    public void setN12(BigInteger n12) {
        this.n12 = n12;
    }

    public BigInteger getN13() {
        return n13;
    }

    public void setN13(BigInteger n13) {
        this.n13 = n13;
    }

    public BigInteger getN14() {
        return n14;
    }

    public void setN14(BigInteger n14) {
        this.n14 = n14;
    }

    public BigInteger getNaryadTipK() {
        return naryadTipK;
    }

    public void setNaryadTipK(BigInteger naryadTipK) {
        this.naryadTipK = naryadTipK;
    }

    public String getDopsafetynorms() {
        return dopsafetynorms;
    }

    public void setDopsafetynorms(String dopsafetynorms) {
        this.dopsafetynorms = dopsafetynorms;
    }

    public Date getWorkStart() {
        return workStart;
    }

    public void setWorkStart(Date workStart) {
        this.workStart = workStart;
    }

    public Date getWorkEnd() {
        return workEnd;
    }

    public void setWorkEnd(Date workEnd) {
        this.workEnd = workEnd;
    }

    public String getFreightLoad() {
        return freightLoad;
    }

    public void setFreightLoad(String freightLoad) {
        this.freightLoad = freightLoad;
    }

    public String getPicketLoad() {
        return picketLoad;
    }

    public void setPicketLoad(String picketLoad) {
        this.picketLoad = picketLoad;
    }

    public String getFreightUnload() {
        return freightUnload;
    }

    public void setFreightUnload(String freightUnload) {
        this.freightUnload = freightUnload;
    }

    public String getPicketUnload() {
        return picketUnload;
    }

    public void setPicketUnload(String picketUnload) {
        this.picketUnload = picketUnload;
    }

    public BigInteger getForCopy() {
        return forCopy;
    }

    public void setForCopy(BigInteger forCopy) {
        this.forCopy = forCopy;
    }

    public String getIsEditNaryad() {
        return isEditNaryad;
    }

    public void setIsEditNaryad(String isEditNaryad) {
        this.isEditNaryad = isEditNaryad;
    }

    public BigInteger getTakenNaryad() {
        return takenNaryad;
    }

    public void setTakenNaryad(BigInteger takenNaryad) {
        this.takenNaryad = takenNaryad;
    }

    public String getPriostanovka() {
        return priostanovka;
    }

    public void setPriostanovka(String priostanovka) {
        this.priostanovka = priostanovka;
    }

    public BigInteger getFaktorK() {
        return faktorK;
    }

    public void setFaktorK(BigInteger faktorK) {
        this.faktorK = faktorK;
    }

    public String getIsRequiredNaryad() {
        return isRequiredNaryad;
    }

    public void setIsRequiredNaryad(String isRequiredNaryad) {
        this.isRequiredNaryad = isRequiredNaryad;
    }

    public String getIsSendedNaryad() {
        return isSendedNaryad;
    }

    public void setIsSendedNaryad(String isSendedNaryad) {
        this.isSendedNaryad = isSendedNaryad;
    }

    public String getTechnicalCondition() {
        return technicalCondition;
    }

    public void setTechnicalCondition(String technicalCondition) {
        this.technicalCondition = technicalCondition;
    }

    public String getIsEditNaryadProizvSluzhb() {
        return isEditNaryadProizvSluzhb;
    }

    public void setIsEditNaryadProizvSluzhb(String isEditNaryadProizvSluzhb) {
        this.isEditNaryadProizvSluzhb = isEditNaryadProizvSluzhb;
    }

    public BigInteger getTrailer() {
        return trailer;
    }

    public void setTrailer(BigInteger trailer) {
        this.trailer = trailer;
    }

    public String getRouteVtb() {
        return routeVtb;
    }

    public void setRouteVtb(String routeVtb) {
        this.routeVtb = routeVtb;
    }

    @XmlTransient
    public List<Performers> getPerformersList() {
        return performersList;
    }

    public void setPerformersList(List<Performers> performersList) {
        this.performersList = performersList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (predpisK != null ? predpisK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Predpis))
            return false;
        Predpis other = (Predpis) object;
        if ((this.predpisK == null && other.predpisK != null) || (this.predpisK != null && !this.predpisK.equals(other.predpisK)))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "ru.vist.model.src.Predpis[ predpisK=" + predpisK + " ]";
    }
    
}
