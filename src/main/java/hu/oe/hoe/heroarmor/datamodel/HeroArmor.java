/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.oe.hoe.heroarmor.datamodel;

import hu.oe.hoe.heroarmor.utils.enums.ArmorPart;
import hu.oe.hoe.heroarmor.utils.enums.ArmorType;
import hu.oe.hoe.heroarmor.utils.enums.Durability;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author szark
 */
@Entity
@Table(name = "HeroArmor")
public class HeroArmor implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String description;
    private int armor;
    private ArmorType armorType;
    private ArmorPart armorPart;
    private Durability durability;
    private boolean active;

    public HeroArmor() {
    }

    public HeroArmor(String name,
                     String description,
                     int armor,
                     ArmorType armorType,
                     ArmorPart armorPart,
                     Durability durability) {
        this.name = name;
        this.description = description;
        this.armor= armor;
        this.armorType = armorType;
        this.armorPart = armorPart;
        this.durability = durability;
        this.active = true;

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

    public int getArmor() {
        return armor;
    }

    public ArmorType getArmorType() {
        return armorType;
    }

    public ArmorPart getArmorPart() {
        return armorPart;
    }

    public Durability getDurability() {
        return durability;
    }

    public boolean isActive() {
        return active;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }

    public void setArmorType(ArmorType armorType) {
        this.armorType = armorType;
    }

    public void setArmorPart(ArmorPart armorPart) {
        this.armorPart = armorPart;
    }

    public void setDurability(Durability durability) {
        this.durability = durability;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "hu.oe.hoe.heroarmor.datamodel.HeroArmor[ id=" + id + " ]";
    }
    
}
