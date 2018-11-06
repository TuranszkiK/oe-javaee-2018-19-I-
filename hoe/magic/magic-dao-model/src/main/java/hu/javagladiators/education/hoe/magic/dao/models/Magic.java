package hu.javagladiators.education.hoe.magic.dao.models;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(
    name = "magic", 
    indexes = {
        @Index(name = "magic_id", columnList = "id", unique = true),
        @Index(name = "magic_name", columnList = "name", unique = true)     
    })
@NamedQueries({
    @NamedQuery(name = "Magic.all", query = "SELECT u FROM Magic u "),
    @NamedQuery(name = "Magic.name", query = "SELECT u FROM Magic u WHERE u.name=:name ")
})
public class Magic implements Serializable {
    public final static String AllMagicNamedQuery = "AllMagic";

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;
    
    @Column(name = "description")
    private String description;
    
    @Column(name = "damage")
    private int damage;
    
    @Column(name = "cost")
    private int cost;

    public Magic(){}
    
    public Magic(long id){
        this.id = id;
    }

    public Magic(String name, String description, int damage, int cost){
        this.name = name;
        this.description = description;
        this.damage = damage;
        this.cost = cost;
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
        if (!(object instanceof Magic)) {
            return false;
        }
        Magic other = (Magic) object;
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

    public int getDamage() {
        return damage;
    }
    
    public int getCost() {
        return cost;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDamage(int value) {
        this.damage = damage;
    }
    
     public void setCost(int value) {
        this.cost = cost;
    }
    
    @Override
    public String toString() {
        return "hu.javagladiators.education.magic.user.dao.model.Magic[ id=" + id + " ]";
    }
}
