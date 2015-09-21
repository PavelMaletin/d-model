/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.vist.loader.src;

import java.io.Serializable;
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
@Table(name = "PREDPIS", catalog = "", schema = "AC_STAT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Predpis.findAll_1", query = "SELECT p FROM Predpis p where p.predpisTipK = 1 and p.predpisK  BETWEEN 47356 and 55337"),
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
    @NotNull
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
    @Size(max = 4000)
    @Column(name = "BRIGAD_TEKST", length = 4000)
    private String brigadTekst;
    @Column(name = "ZAMECH_K")
    private Integer zamechK;
    @Size(max = 4000)
    @Column(name = "ZAMECH_TEKST", length = 4000)
    private String zamechTekst;
    @Column(name = "BAL")
    private Integer bal;
    @Column(name = "VER")
    private Integer ver;
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
    @Size(max = 1)
    @Column(name = "STOP_PRIZN", length = 1)
    private String stopPrizn;
    @Size(max = 4000)
    @Column(name = "FREETEXT", length = 4000)
    private String freetext;
    @Size(max = 4000)
    @Column(name = "PRESENCE", length = 4000)
    private String presence;
    @Column(name = "TIP")
    private Integer tip;
    @Column(name = "DOLJNOST")
    private Integer doljnost;
    @Size(max = 50)
    @Column(name = "RISK", length = 50)
    private String risk;
    @Size(max = 4000)
    @Column(name = "ARRANGEMENT", length = 4000)
    private String arrangement;
    @Column(name = "OZNAKOMLENIE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date oznakomlenie;
    @Column(name = "PREDPIS_TIP_K")
    private Integer predpisTipK;
    @Column(name = "PLAN_FAKT")
    private Integer planFakt;
    @Column(name = "NARUSHIT_K")
    private Integer narushitK;
    @Column(name = "APPROVED_K")
    private Integer approvedK;
    @Size(max = 1)
    @Column(name = "IS_BLANK", length = 1)
    private String isBlank;
    @Column(name = "ROUTE")
    private Integer route;
    @Column(name = "PRIORITY")
    private Integer priority;
    @Size(max = 100)
    @Column(name = "SMENA", length = 100)
    private String smena;
    @Size(max = 4000)
    @Column(name = "REASONS", length = 4000)
    private String reasons;
    @Size(max = 100)
    @Column(name = "PLAN", length = 100)
    private String plan;
    @Size(max = 100)
    @Column(name = "ED_IZM", length = 100)
    private String edIzm;
    @Size(max = 100)
    @Column(name = "PLAN_FAKT_T", length = 100)
    private String planFaktT;
    @Column(name = "NPP")
    private Integer npp;
    @Column(name = "OPERATION_K")
    private Integer operationK;
    @Size(max = 300)
    @Column(name = "OPERATION_TEXT", length = 300)
    private String operationText;
    @Column(name = "SMEN_K")
    private Integer smenK;
    @Column(name = "SUTKI")
    private Integer sutki;
    @Size(max = 1)
    @Column(name = "ISAPPROVED", length = 1)
    private String isapproved;
    @Column(name = "ISAPPROVEDSOTRUDK")
    private Integer isapprovedsotrudk;
    @Column(name = "ISAPPROVEDDATA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date isapproveddata;
    @Size(max = 500)
    @Column(name = "ISAPPROVEDDOLJNAIM", length = 500)
    private String isapproveddoljnaim;
    @Column(name = "NARYAD_DOPUSK_N")
    private Integer naryadDopuskN;
    @Size(max = 4000)
    @Column(name = "MANUFACTORY", length = 4000)
    private String manufactory;
    @Column(name = "N_01")
    private Integer n01;
    @Column(name = "N_02")
    private Integer n02;
    @Column(name = "N_03")
    private Integer n03;
    @Column(name = "N_04")
    private Integer n04;
    @Column(name = "N_05")
    private Integer n05;
    @Column(name = "N_06")
    private Integer n06;
    @Column(name = "N_07")
    private Integer n07;
    @Column(name = "N_08")
    private Integer n08;
    @Column(name = "N_09")
    private Integer n09;
    @Column(name = "N_10")
    private Integer n10;
    @Column(name = "N_11")
    private Integer n11;
    @Column(name = "N_12")
    private Integer n12;
    @Column(name = "N_13")
    private Integer n13;
    @Column(name = "N_14")
    private Integer n14;
    @Column(name = "NARYAD_TIP_K")
    private Integer naryadTipK;
    @Size(max = 4000)
    @Column(name = "DOPSAFETYNORMS", length = 4000)
    private String dopsafetynorms;
    @Column(name = "WORK_START")
    @Temporal(TemporalType.TIMESTAMP)
    private Date workStart;
    @Column(name = "WORK_END")
    @Temporal(TemporalType.TIMESTAMP)
    private Date workEnd;
    @Size(max = 500)
    @Column(name = "FREIGHT_LOAD", length = 500)
    private String freightLoad;
    @Size(max = 500)
    @Column(name = "PICKET_LOAD", length = 500)
    private String picketLoad;
    @Size(max = 500)
    @Column(name = "FREIGHT_UNLOAD", length = 500)
    private String freightUnload;
    @Size(max = 500)
    @Column(name = "PICKET_UNLOAD", length = 500)
    private String picketUnload;
    @Column(name = "FOR_COPY")
    private Integer forCopy;
    @Size(max = 1)
    @Column(name = "IS_EDIT_NARYAD", length = 1)
    private String isEditNaryad;
    @Column(name = "TAKEN_NARYAD")
    private Integer takenNaryad;
    @Size(max = 1)
    @Column(name = "PRIOSTANOVKA", length = 1)
    private String priostanovka;
    @Column(name = "FAKTOR_K")
    private Integer faktorK;
    @Size(max = 1)
    @Column(name = "IS_REQUIRED_NARYAD", length = 1)
    private String isRequiredNaryad;
    @Size(max = 1)
    @Column(name = "IS_SENDED_NARYAD", length = 1)
    private String isSendedNaryad;
    @Size(max = 500)
    @Column(name = "TECHNICAL_CONDITION", length = 500)
    private String technicalCondition;
    @Size(max = 1)
    @Column(name = "IS_EDIT_NARYAD_PROIZV_SLUZHB", length = 1)
    private String isEditNaryadProizvSluzhb;
    @Column(name = "TRAILER")
    private Integer trailer;
    @Size(max = 500)
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

    public Integer getBal() {
        return bal;
    }

    public void setBal(Integer bal) {
        this.bal = bal;
    }

    public Integer getVer() {
        return ver;
    }

    public void setVer(Integer ver) {
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

    public Integer getPredpisTipK() {
        return predpisTipK;
    }

    public void setPredpisTipK(Integer predpisTipK) {
        this.predpisTipK = predpisTipK;
    }

    public Integer getPlanFakt() {
        return planFakt;
    }

    public void setPlanFakt(Integer planFakt) {
        this.planFakt = planFakt;
    }

    public Integer getNarushitK() {
        return narushitK;
    }

    public void setNarushitK(Integer narushitK) {
        this.narushitK = narushitK;
    }

    public Integer getApprovedK() {
        return approvedK;
    }

    public void setApprovedK(Integer approvedK) {
        this.approvedK = approvedK;
    }

    public String getIsBlank() {
        return isBlank;
    }

    public void setIsBlank(String isBlank) {
        this.isBlank = isBlank;
    }

    public Integer getRoute() {
        return route;
    }

    public void setRoute(Integer route) {
        this.route = route;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
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

    public Integer getNpp() {
        return npp;
    }

    public void setNpp(Integer npp) {
        this.npp = npp;
    }

    public Integer getOperationK() {
        return operationK;
    }

    public void setOperationK(Integer operationK) {
        this.operationK = operationK;
    }

    public String getOperationText() {
        return operationText;
    }

    public void setOperationText(String operationText) {
        this.operationText = operationText;
    }

    public Integer getSmenK() {
        return smenK;
    }

    public void setSmenK(Integer smenK) {
        this.smenK = smenK;
    }

    public Integer getSutki() {
        return sutki;
    }

    public void setSutki(Integer sutki) {
        this.sutki = sutki;
    }

    public String getIsapproved() {
        return isapproved;
    }

    public void setIsapproved(String isapproved) {
        this.isapproved = isapproved;
    }

    public Integer getIsapprovedsotrudk() {
        return isapprovedsotrudk;
    }

    public void setIsapprovedsotrudk(Integer isapprovedsotrudk) {
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

    public Integer getNaryadDopuskN() {
        return naryadDopuskN;
    }

    public void setNaryadDopuskN(Integer naryadDopuskN) {
        this.naryadDopuskN = naryadDopuskN;
    }

    public String getManufactory() {
        return manufactory;
    }

    public void setManufactory(String manufactory) {
        this.manufactory = manufactory;
    }

    public Integer getN01() {
        return n01;
    }

    public void setN01(Integer n01) {
        this.n01 = n01;
    }

    public Integer getN02() {
        return n02;
    }

    public void setN02(Integer n02) {
        this.n02 = n02;
    }

    public Integer getN03() {
        return n03;
    }

    public void setN03(Integer n03) {
        this.n03 = n03;
    }

    public Integer getN04() {
        return n04;
    }

    public void setN04(Integer n04) {
        this.n04 = n04;
    }

    public Integer getN05() {
        return n05;
    }

    public void setN05(Integer n05) {
        this.n05 = n05;
    }

    public Integer getN06() {
        return n06;
    }

    public void setN06(Integer n06) {
        this.n06 = n06;
    }

    public Integer getN07() {
        return n07;
    }

    public void setN07(Integer n07) {
        this.n07 = n07;
    }

    public Integer getN08() {
        return n08;
    }

    public void setN08(Integer n08) {
        this.n08 = n08;
    }

    public Integer getN09() {
        return n09;
    }

    public void setN09(Integer n09) {
        this.n09 = n09;
    }

    public Integer getN10() {
        return n10;
    }

    public void setN10(Integer n10) {
        this.n10 = n10;
    }

    public Integer getN11() {
        return n11;
    }

    public void setN11(Integer n11) {
        this.n11 = n11;
    }

    public Integer getN12() {
        return n12;
    }

    public void setN12(Integer n12) {
        this.n12 = n12;
    }

    public Integer getN13() {
        return n13;
    }

    public void setN13(Integer n13) {
        this.n13 = n13;
    }

    public Integer getN14() {
        return n14;
    }

    public void setN14(Integer n14) {
        this.n14 = n14;
    }

    public Integer getNaryadTipK() {
        return naryadTipK;
    }

    public void setNaryadTipK(Integer naryadTipK) {
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

    public Integer getForCopy() {
        return forCopy;
    }

    public void setForCopy(Integer forCopy) {
        this.forCopy = forCopy;
    }

    public String getIsEditNaryad() {
        return isEditNaryad;
    }

    public void setIsEditNaryad(String isEditNaryad) {
        this.isEditNaryad = isEditNaryad;
    }

    public Integer getTakenNaryad() {
        return takenNaryad;
    }

    public void setTakenNaryad(Integer takenNaryad) {
        this.takenNaryad = takenNaryad;
    }

    public String getPriostanovka() {
        return priostanovka;
    }

    public void setPriostanovka(String priostanovka) {
        this.priostanovka = priostanovka;
    }

    public Integer getFaktorK() {
        return faktorK;
    }

    public void setFaktorK(Integer faktorK) {
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

    public Integer getTrailer() {
        return trailer;
    }

    public void setTrailer(Integer trailer) {
        this.trailer = trailer;
    }

    public String getRouteVtb() {
        return routeVtb;
    }

    public void setRouteVtb(String routeVtb) {
        this.routeVtb = routeVtb;
    }

    @XmlTransient
    @JsonIgnore
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
        return "cvr.vist.ref.loader.src.Predpis[ predpisK=" + predpisK + " ]";
    }
    
}
