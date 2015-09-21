package ru.vist.model.domain.ref;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "POST",schema = "AW_STAT")
@DiscriminatorValue("POST")
public class Post extends Reference {
    public Post() {
    }

    public Post(String id, String name) {
        super(id, name);        
    }
    
    private int smen;

    public int getSmen() {
        return smen;
    }

    public void setSmen(int smen) {
        this.smen = smen;
    }
    @Override
    public String toString() {
        return super.name;
    }

}
