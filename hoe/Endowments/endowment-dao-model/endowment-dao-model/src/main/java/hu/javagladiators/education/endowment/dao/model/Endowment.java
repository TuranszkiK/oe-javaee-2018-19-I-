/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.javagladiators.education.endowment.dao.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Index;
import javax.persistence.Table;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;


/**
 *
 * @author krisztian
 */
@Entity
@Table(
    name = "user", 
    indexes = {
        @Index(name = "endowment_name", columnList = "name", unique = true),
        @Index(name = "endowment_desc", columnList = "desc", unique = true)     
    })
@NamedQueries({
    @NamedQuery(name = "Endowment.type", query = "SELECT e FROM Endowment e WHERE e.type=:type")
})
public class Endowment implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   
    @Column(name = "type")
    private String type;
    public String getType() {return type;}
    public void setType(String type) {this.type = type;}
      
    @Column(name = "desc")
    private String desc;
    public String getRole() {return desc;}
    public void setRole(String role) {this.desc = desc;}
     
}
