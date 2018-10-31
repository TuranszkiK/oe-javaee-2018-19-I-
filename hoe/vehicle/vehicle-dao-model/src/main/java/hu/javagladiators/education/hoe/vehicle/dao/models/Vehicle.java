/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.javagladiators.education.hoe.vehicle.dao.models;

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
    name = "vehicle", 
    indexes = {
        @Index(name = "vehicle_id", columnList = "id", unique = true),
        @Index(name = "vehicle_name", columnList = "name", unique = true)     
    })
@NamedQueries({
    @NamedQuery(name = "Vehicle.all", query = "SELECT u FROM Vehicle u "),
    @NamedQuery(name = "Vehicle.name", query = "SELECT u FROM Vehicle u WHERE u.name=:name ")
})
public class Vehicle implements Serializable {

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
        if (!(object instanceof Vehicle)) {
            return false;
        }
        Vehicle other = (Vehicle) object;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "hu.javagladiators.education.hoe.vehicle.dao.models[ id=" + id + " ]";
    }
    
}
