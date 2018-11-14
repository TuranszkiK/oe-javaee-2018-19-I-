/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.javagladiators.education.factorylevel.dao.models;
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
 *
 * @author I341314
 */
public class FactoryLevel implements Serializable {

@Entity 
@Table(
    name = "factoryLevel", 
    indexes = {
        @Index(name = "factoryLevel_id", columnList = "id", unique = true),
        @Index(name = "factoryLevel_name", columnList = "name", unique = true)     
    })
@NamedQueries({
    @NamedQuery(name = "FactoryLevel.all", query = "SELECT u FROM FactoryLevel u "),
    @NamedQuery(name = "FactoryLevel.name", query = "SELECT u FROM FactoryLevel u WHERE u.name=:name ")
})


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
    
    @Column(name = "description")
    private String level;
    public String getLevel() {return level;}
    public void setLevel(String level) {this.level = level;}
    
    @Column(name = "description")
    private String extra;
    public String getExtra() {return extra;}
    public void setExtra(String extra) {this.extra = extra;}
        

    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) id;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FactoryLevel)) {
            return false;
        }
        FactoryLevel other = (FactoryLevel) object;
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

