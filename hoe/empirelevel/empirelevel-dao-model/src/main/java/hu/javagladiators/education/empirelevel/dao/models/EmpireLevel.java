/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.javagladiators.education.empirelevel.dao.models;

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
    name = "vehiclelevel", 
    indexes = {
        @Index(name = "vl_id", columnList = "id", unique = true)   
    })
@NamedQueries({
    @NamedQuery(name = "VehicleLevel.name", query = "SELECT u FROM VehicleLevel u WHERE u.name=:name "),
        @NamedQuery(name = "VehicleLevel.all", query = "SELECT u FROM VehicleLevel u ")
})
public class EmpireLevel implements Serializable{
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
    
    @Column(name = "desc")
    private String desc;
    public String getDesc() {return desc;}
    public void setDesc(String desc) {this.desc = desc;}
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) id;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof EmpireLevel)) {
            return false;
        }
        EmpireLevel other = (EmpireLevel) object;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "hu.javagladiators.education.hoe.empirelevel.dao.model.EmpireLevel[ id=" + id + " ]";
    }
}
