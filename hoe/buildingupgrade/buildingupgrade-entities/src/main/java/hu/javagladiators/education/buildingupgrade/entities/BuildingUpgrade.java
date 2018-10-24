/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.javagladiators.education.buildingupgrade.entities;

import javax.persistence.*;

@Entity
@NamedQuery(name="AllBuildingUpgrades", query="SELECT a FROM BuildingUpgrade a")
@Table(name = "BuildingUpgrade")
public class BuildingUpgrade {
    public final static String AllBuildingUpgradesNamedQuery = "AllBuildingUpgrades";

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private long id;

    private String name;
    private String description;
    private long cost;
    private String bonusAttribute;
    private int bonusAttributeValue;

    public BuildingUpgrade(){}
    
    public BuildingUpgrade(long id){
        this.id = id;
    }

    public BuildingUpgrade(String name, String description, long cost, String bonusAttribute, int bonusAttributeValue){
        this.name = name;
        this.description = description;
        this.cost = cost;
        this.bonusAttribute = bonusAttribute;
        this.bonusAttributeValue = bonusAttributeValue;
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

    public long getCost() {
        return cost;
    }

    public String getBonusAttribute() {
        return bonusAttribute;
    }

    public int getBonusAttributeValue() {
        return bonusAttributeValue;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCost(long cost) {
        this.cost = cost;
    }

    public void setBonusAttribute(String bonusAttribute) {
        this.bonusAttribute = bonusAttribute;
    }

    public void setBonusAttributeValue(int bonusAttributeValue) {
        this.bonusAttributeValue = bonusAttributeValue;
    }
}
