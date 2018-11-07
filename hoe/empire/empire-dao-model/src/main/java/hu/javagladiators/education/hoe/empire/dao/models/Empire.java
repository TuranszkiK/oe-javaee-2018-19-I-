package hu.javagladiators.education.hoe.empire.dao.models;

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

/**
 * @author krisztian
 */
@Entity
@Table(
    name = "empire", 
    indexes = {
        @Index(name = "empire_id", columnList = "id", unique = true),
        @Index(name = "empire_name", columnList = "name", unique = true)     
    })
@NamedQueries({
    @NamedQuery(name = "Empire.all", query = "SELECT u FROM Empire u "),
    @NamedQuery(name = "Empire.name", query = "SELECT u FROM Empire u WHERE u.name=:name ")
})
public class Empire implements Serializable {

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
      
    @Column(name = "description")
    private String description;
    public String getDescription() {return description;}
    public void setDescription(String description) {this.description = description;}
        

    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) id;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Empire)) {
            return false;
        }
        Empire other = (Empire) object;
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
