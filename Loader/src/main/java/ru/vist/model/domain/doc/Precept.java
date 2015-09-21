package ru.vist.model.domain.doc;

import ru.vist.model.domain.ref.ProdUnit;
import ru.vist.model.domain.ref.Worker;
import ru.vist.model.types.CheckingType;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
//import javax.validation.constraints.Size;

@Entity
@Table(name = "PRECEPT",schema = "AW_STAT")
@DiscriminatorValue("PRECEPT")
@NamedQueries({
    @NamedQuery(name = "Precept.findDateInterval", query = "SELECT r FROM Precept r "
            + "WHERE r.status = :status and "
            + "r.issueDate BETWEEN :dateBegin and :dateEnd "
            + "ORDER BY r.issueDate DESC"),
    @NamedQuery(name = "Precept.findDateIntervalDept", query = "SELECT r FROM Precept r "
            + "WHERE r.status = :status and "
            + "r.issueDate BETWEEN :dateBegin and :dateEnd and "
            + "r.prodUnit =:prodUnit")
})

public class Precept extends Document {

    public Precept() {
    }

    public Precept(String id, String name) {
        super(id, name);
    }

    @Temporal(TemporalType.TIMESTAMP)
    private Date issueDate;

    public Date getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }

    @Temporal(TemporalType.TIMESTAMP)
    private Date execDate;

    public Date getExecDate() {
        return execDate;
    }

    public void setExecDate(Date execDate) {
        this.execDate = execDate;
    }

    @Temporal(TemporalType.TIMESTAMP)
    private Date planExecDate;

    public Date getPlanExecDate() {
        return planExecDate;
    }

    public void setPlanExecDate(Date planExecDate) {
        this.planExecDate = planExecDate;
    }

    @Temporal(TemporalType.TIMESTAMP)
    private Date noticeDate;

    public Date getNoticeDate() {
        return noticeDate;
    }

    public void setNoticeDate(Date noticeDate) {
        this.noticeDate = noticeDate;
    }

    private Worker notificator;

    public Worker getNotificator() {
        return notificator;
    }

    public void setNotificator(Worker notificator) {
        this.notificator = notificator;
    }

    @Temporal(TemporalType.TIMESTAMP)
    private Date reviewDate;

    public Date getReviewDate() {
        return reviewDate;
    }

    public void setReviewDate(Date reviewDate) {
        this.reviewDate = reviewDate;
    }

    private Worker reviewer;

    public Worker getReviewer() {
        return reviewer;
    }

    public void setReviewer(Worker reviewer) {
        this.reviewer = reviewer;
    }

    private Boolean letupWork;

    public Boolean isLetupWork() {
        return letupWork;
    }

    public void setLetupWork(Boolean letupWork) {
        this.letupWork = letupWork;
    }

    private String letupByShift;

    public String getLetupByShift() {
        return letupByShift;
    }

    public void setLetupByShift(String letupByShift) {
        this.letupByShift = letupByShift;
    }

    private ProdUnit prodUnit;

    public ProdUnit getProdUnit() {
        return prodUnit;
    }

    public void setProdUnit(ProdUnit prodUnit) {
        this.prodUnit = prodUnit;
    }

    private ProdUnit subProdUnit;

    public ProdUnit getSubProdUnit() {
        return subProdUnit;
    }

    public void setSubProdUnit(ProdUnit subProdUnit) {
        this.subProdUnit = subProdUnit;
    }

    private Worker author;

    public Worker getAuthor() {
        return author;
    }

    public void setAuthor(Worker author) {
        this.author = author;
    }

    private List<Worker> coauthors;

    public List<Worker> getCoauthors() {
        return coauthors;
    }

    public void setCoauthors(List<Worker> coauthors) {
        this.coauthors = coauthors;
    }

//    private CheckingType checkingType;
    @Column(length = 40)
    private String checkingType;
    public String getCheckingType() {
        return checkingType;
    }

    public void setCheckingType(String checkingType) {
        this.checkingType = checkingType;
    }

    private String route;

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    private Worker executor;

    public Worker getExecutor() {
        return executor;
    }

    public void setExecutor(Worker executor) {
        this.executor = executor;
    }

    private List<Worker> coExecutors;

    public List<Worker> getCoExecutors() {
        return coExecutors;
    }

    public void setCoExecutors(List<Worker> coExecutors) {
        this.coExecutors = coExecutors;
    }

    private String operand;

    public String getOperand() {
        return operand;
    }

    public void setOperand(String operand) {
        this.operand = operand;
    }

    private String subOperand;

    public String getSubOperand() {
        return subOperand;
    }

    public void setSubOperand(String subOperand) {
        this.subOperand = subOperand;
    }
    @Column(length = 4000)
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    @Column(length = 500)
    private String lawArticle;

    public String getLawArticle() {
        return lawArticle;
    }

    public void setLawArticle(String lawArticle) {
        this.lawArticle = lawArticle;
    }

    @Column(length = 4000)
    private String causeOfProblem;

    public String getCauseOfProblem() {
        return causeOfProblem;
    }

    public void setCauseOfProblem(String causeOfProblem) {
        this.causeOfProblem = causeOfProblem;
    }

    private String danger;

    public String getDanger() {
        return danger;
    }

    public void setDanger(String danger) {
        this.danger = danger;
    }
    @Column(length = 1)
    private Short clog;

    public Short getClog() {
        return clog;
    }

    public void setClog(Short clog) {
        this.clog = clog;
    }

    @Column(length = 1)
    private Short possibility;

    public Short getPossibility() {
        return possibility;
    }

    public void setPossibility(Short possibility) {
        this.possibility = possibility;
    }

    private Boolean requaredOrder;

    public Boolean isRequaredOrder() {
        return requaredOrder;
    }

    public void setRequaredOrder(Boolean requaredOrder) {
        this.requaredOrder = requaredOrder;
    }
}
