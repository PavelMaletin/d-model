package ru.vist.model.domain.ref;

import ru.vist.model.domain.sys.User;
import ru.vist.utils.Other;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "WORKER",schema = "AW_STAT")
@DiscriminatorValue("WORKER")
@NamedQueries({
    @NamedQuery(name = "Worker.findByImpKey", query = "SELECT r FROM Worker r WHERE r.impKey = :impKey"),})
public class Worker extends Reference {

    @ManyToOne
    @JoinColumn(name = "prodUnit_id")
    private ProdUnit placeOfWork;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "post_id")
    private Post post;
//  
//   При импорте данных РАСКОМЕНТАРИТЬ    
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "user_id")
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public ProdUnit getPlaceOfWork() {
        return placeOfWork;
    }

    public void setPlaceOfWork(ProdUnit placeOfWork) {
        this.placeOfWork = placeOfWork;
    }

    private String im;

    public String getIm() {
        return im;
    }

    public void setIm(String fn) {
        this.im = fn;
        this.name = Other.fio(fam, fn, otch);
    }

    private String otch;

    public String getOtch() {
        return otch;
    }

    public void setOtch(String mn) {
        this.otch = mn;
        this.name = Other.fio(fam, im, mn);
    }

    private String fam;

    public String getFam() {
        return fam;
    }

    public void setFam(String ln) {
        this.fam = ln;
        this.name = Other.fio(ln, im, otch);
    }

    public Worker(String id, String ln, String fn, String mn) {
        super(id);
        this.fam = ln;
        this.im = fn;
        this.otch = mn;
        this.name = Other.fio(ln, fn, mn);
    }

    private String e_mail;

    public String getE_mail() {
        return e_mail;
    }

    public void setE_mail(String e_mail) {
        this.e_mail = e_mail;
    }

    private String phones;

    public String getPhones() {
        return phones;
    }

    public void setPhones(String phones) {
        this.phones = phones;
    }

    public Worker() {
    }

    @Override
    public String toString() {
        return fam +" " + im.substring(0,1).toUpperCase()+ "."+otch.substring(0,1).toUpperCase()+ ".";
    }
    
    
}
