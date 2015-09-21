package ru.vist.model.domain.sys;

import ru.vist.model.domain.ref.Reference;
import ru.vist.model.domain.ref.Worker;
import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "USER_",schema = "AW_STAT")
@DiscriminatorValue("USER_")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "User.verifyUser", query = "SELECT r FROM User r WHERE r.name = :name and r.password = :password"),
    @NamedQuery(name = "User.UserByName", query = "SELECT r FROM User r WHERE r.name = :name")
})

public class User extends Reference {

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "worker_id")
    private Worker worker;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "group_id")
    private UserGroup userGroup;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "role_id")
    private UserRole userRole;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "subscriber_id")
    private Subscriber subscriber;

    public UserGroup getUserGroup() {
        return userGroup;
    }

    public void setUserGroup(UserGroup userGroup) {
        this.userGroup = userGroup;
    }

    public Subscriber getSubscriber() {
        return subscriber;
    }

    public void setSubscriber(Subscriber subscriber) {
        this.subscriber = subscriber;
    }
    
    
    public Worker getWorker() {
        return worker;
    }

    public void setWorker(Worker worker) {
        this.worker = worker;
    }

    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }

    public UserGroup getGroup() {
        return userGroup;
    }

    public void setGroup(UserGroup group) {
        this.userGroup = group;
    }

    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
    public User(String id, String name) {
        super(id, name);        
    }

    public User(Worker worker, UserGroup group, String id, String name, String password) {
        super(id, name);
        this.worker = worker;
        this.userGroup = group;
        this.password = password;
    }

    public User() {
    }
    @Override
    public String toString() {
        return super.name;
    }

}
