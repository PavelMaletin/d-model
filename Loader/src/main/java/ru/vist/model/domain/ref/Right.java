package ru.vist.model.domain.ref;

import ru.vist.model.domain.sys.UserRole;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "RIGHT_",schema = "AW_STAT")
@DiscriminatorValue("RIGHT")
public class Right extends Reference {

    public Right() {
    }

    public Right(String id, String name) {
        super(id, name);
    }

    @ManyToOne
    @JoinColumn
    UserRole role;

    @ManyToOne
    @JoinColumn
    Reference controlled;

    private String rightValue;

    public String getRightValue() {
        return rightValue;
    }

    public void setRightValue(String rightValue) {
        this.rightValue = rightValue;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public Reference getControlled() {
        return controlled;
    }

    public void setControlled(Reference controlled) {
        this.controlled = controlled;
    }

    @Override
    public String toString() {
        return super.name;
    }
    
}