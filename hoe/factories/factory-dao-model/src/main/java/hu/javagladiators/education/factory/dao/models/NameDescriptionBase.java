package hu.javagladiators.education.factory.dao.models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import static javax.persistence.InheritanceType.TABLE_PER_CLASS;
import javax.persistence.MappedSuperclass;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Lóci
 */

@MappedSuperclass
public class NameDescriptionBase {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private long Id;
    
    

    /**
     * @return the Id
     */
    public long getId() {
        return Id;
    }

    /**
     * @param Id the Id to set
     */
    public void setId(long Id) {
        this.Id = Id;
    }

    public NameDescriptionBase() {
        
    }

    
}
