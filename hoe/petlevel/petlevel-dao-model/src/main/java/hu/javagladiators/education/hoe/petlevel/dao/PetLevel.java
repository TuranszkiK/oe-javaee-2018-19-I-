/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.javagladiators.education.hoe.petlevel.dao;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class PetLevel implements Serializable {

    public PetLevel(long id, String levelName, int fromLevel, int untilLevel) {
        this.id = id;
        this.levelName = levelName;
        this.fromLevel = fromLevel;
        this.untilLevel = untilLevel;
    }
        
    public PetLevel(){}
    
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private long id;
    private String levelName;
    // the range that tells between what levels we call the level like so. 
    private int fromLevel;
    private int untilLevel;  

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLevelName() {
        return levelName;
    }

    public void setLevelName(String levelName) {
        this.levelName = levelName;
    }

    public int getFromLevel() {
        return fromLevel;
    }

    public void setFromLevel(int fromLevel) {
        this.fromLevel = fromLevel;
    }

    public int getUntilLevel() {
        return untilLevel;
    }

    public void setUntilLevel(int untilLevel) {
        this.untilLevel = untilLevel;
    }

        
}
