package hu.javagladiators.education.hoe.bonusattributes.dao.models;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(
    name = "bonusattributes", 
    indexes = {
        @Index(name = "bonusattributes_id", columnList = "id", unique = true),
        @Index(name = "bonusattributes_name", columnList = "name", unique = true)     
    })
@NamedQueries({
    @NamedQuery(name = "BonusAttributes.all", query = "SELECT u FROM BonusAttributes u "),
    @NamedQuery(name = "BonusAttributes.name", query = "SELECT u FROM BonusAttributes u WHERE u.name=:name ")
})
public class BonusAttributes implements Serializable {
    public final static String AllBonusAttributesNamedQuery = "AllBonusAttributes";

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;
    
    @Column(name = "description")
    private String description;
    
    @Column(name = "value")
    private int value;

    public BonusAttributes(){}
    
    public BonusAttributes(long id){
        this.id = id;
    }

    public BonusAttributes(String name, String description, int value){
        this.name = name;
        this.description = description;
        this.value = value;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) id;
        return hash;
    }
    
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BonusAttributes)) {
            return false;
        }
        BonusAttributes other = (BonusAttributes) object;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
    
    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getValue() {
        return value;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setValue(int value) {
        this.value = value;
    }
    
    @Override
    public String toString() {
        return "hu.javagladiators.education.bonusattributes.user.dao.model.BonusAttributes[ id=" + id + " ]";
    }
}
