/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.vist.loader.src;

import java.io.Serializable;
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
@Table(name = "USERS", catalog = "", schema = "AC_STAT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Users.findAll", query = "SELECT u FROM Users u"),
    @NamedQuery(name = "Users.findByUserId", query = "SELECT u FROM Users u WHERE u.userId = :userId"),
    @NamedQuery(name = "Users.findByUserName", query = "SELECT u FROM Users u WHERE u.userName = :userName"),
    @NamedQuery(name = "Users.findByUserPassword", query = "SELECT u FROM Users u WHERE u.userPassword = :userPassword"),
    @NamedQuery(name = "Users.findByUserSystem", query = "SELECT u FROM Users u WHERE u.userSystem = :userSystem"),
    @NamedQuery(name = "Users.findByUserLock", query = "SELECT u FROM Users u WHERE u.userLock = :userLock"),
    @NamedQuery(name = "Users.findByUserAdmin", query = "SELECT u FROM Users u WHERE u.userAdmin = :userAdmin"),
    @NamedQuery(name = "Users.findByUserChief", query = "SELECT u FROM Users u WHERE u.userChief = :userChief")})
public class Users implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "USER_ID", nullable = false)
    private Integer userId;
    @Size(max = 30)
    @Column(name = "USER_NAME", length = 30)
    private String userName;
    @Size(max = 16)
    @Column(name = "USER_PASSWORD", length = 16)
    private String userPassword;
    @Size(max = 1)
    @Column(name = "USER_SYSTEM", length = 1)
    private String userSystem;
    @Size(max = 1)
    @Column(name = "USER_LOCK", length = 1)
    private String userLock;
    @Size(max = 1)
    @Column(name = "USER_ADMIN", length = 1)
    private String userAdmin;
    @Size(max = 1)
    @Column(name = "USER_CHIEF", length = 1)
    private String userChief;
    @JoinColumn(name = "GROUP_ID", referencedColumnName = "GROUP_ID")
    @ManyToOne
    private Groups groupId;
    @OneToMany(mappedBy = "userId")
    private List<Sotrud> sotrudList;

    public Users() {
    }

    public Users(Integer userId) {
        this.userId = userId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserSystem() {
        return userSystem;
    }

    public void setUserSystem(String userSystem) {
        this.userSystem = userSystem;
    }

    public String getUserLock() {
        return userLock;
    }

    public void setUserLock(String userLock) {
        this.userLock = userLock;
    }

    public String getUserAdmin() {
        return userAdmin;
    }

    public void setUserAdmin(String userAdmin) {
        this.userAdmin = userAdmin;
    }

    public String getUserChief() {
        return userChief;
    }

    public void setUserChief(String userChief) {
        this.userChief = userChief;
    }

    public Groups getGroupId() {
        return groupId;
    }

    public void setGroupId(Groups groupId) {
        this.groupId = groupId;
    }

    @XmlTransient
    @JsonIgnore
    public List<Sotrud> getSotrudList() {
        return sotrudList;
    }

    public void setSotrudList(List<Sotrud> sotrudList) {
        this.sotrudList = sotrudList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userId != null ? userId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Users))
            return false;
        Users other = (Users) object;
        if ((this.userId == null && other.userId != null) || (this.userId != null && !this.userId.equals(other.userId)))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "cvr.vist.ref.loader.src.Users[ userId=" + userId + " ]";
    }
    
}
