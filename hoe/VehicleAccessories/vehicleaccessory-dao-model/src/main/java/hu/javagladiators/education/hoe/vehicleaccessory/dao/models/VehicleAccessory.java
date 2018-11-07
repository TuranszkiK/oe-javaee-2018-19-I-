/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.javagladiators.education.hoe.vehicleaccessory.dao.models;

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
 * @author Boldi
 */
@Entity
@Table(
    name = "vehicleaccessory", 
    indexes = {
        @Index(name = "vehicleaccessory_id", columnList = "id", unique = true),
        @Index(name = "vehicleaccessory_name", columnList = "name", unique = true)     
    })
@NamedQueries({
    @NamedQuery(name = "Vehicleaccessory.all", query = "SELECT u FROM Vehicleaccessory u "),
    @NamedQuery(name = "Vehicleaccessory.name", query = "SELECT u FROM Vehicleaccessory u WHERE u.name=:name ")
})
public class VehicleAccessory implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "addedShield")
    private int addedShield;
    @Column(name = "addedDamage")
    private int addedDamage;
    @Column(name = "price")
    private int price;

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the addedShield
     */
    public int getAddedShield() {
        return addedShield;
    }

    /**
     * @param addedShield the addedShield to set
     */
    public void setAddedShield(int addedShield) {
        this.addedShield = addedShield;
    }

    /**
     * @return the addedDamage
     */
    public int getAddedDamage() {
        return addedDamage;
    }

    /**
     * @param addedDamage the addedDamage to set
     */
    public void setAddedDamage(int addedDamage) {
        this.addedDamage = addedDamage;
    }

    /**
     * @return the price
     */
    public int getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(int price) {
        this.price = price;
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
        if (!(object instanceof VehicleAccessory)) {
            return false;
        }
        VehicleAccessory other = (VehicleAccessory) object;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
        return "hu.javagladiators.education.hoe.vehicleaccessory.dao.model.User[ id=" + id + " ]";
    }
}
