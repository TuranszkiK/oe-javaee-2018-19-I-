package hu.javagladiators.education.hoe.pets.dao.models;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(
    name = "pets", 
    indexes = {
        @Index(name = "pets_id", columnList = "id", unique = true),
        @Index(name = "pets_name", columnList = "name", unique = true)     
    })
@NamedQueries({
    @NamedQuery(name = "Pets.all", query = "SELECT u FROM Pets u "),
    @NamedQuery(name = "Pets.name", query = "SELECT u FROM Pets u WHERE u.name=:name ")
})

public class Pets implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    public long getId() {return id;}
    public void setId(long id) {this.id = id;}
    
    @Column(name = "name")
    private String name;
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
      
    @Column(name = "type")
    private String type;
    public String getType() {return type;}
    public void setType(String type) {this.type = type;}
    
     @Column(name = "strength")
    private String strength;
    public String getStrength() {return strength;}
    public void setStrength(String strength) {this.strength = strength;}

    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) id;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pets)) {
            return false;
        }
        Pets other = (Pets) object;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "hu.javagladiators.education.hoe.user.dao.model.User[ id=" + id + " ]";
    }
}
