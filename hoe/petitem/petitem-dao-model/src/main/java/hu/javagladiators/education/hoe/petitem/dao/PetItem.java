/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.javagladiators.education.hoe.petitem.dao;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(
    name = "petitem", 
    indexes = {
        @Index(name = "petitem_id", columnList = "id", unique = true),
        @Index(name = "petitem_name", columnList = "name", unique = true)     
    })
    @NamedQuery(name = "PetItem.all", query = "SELECT u FROM PetItem u ")
public class PetItem implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    public long getId()
    {
        return id;
    }    
    public void setId(long id)
    {
        this.id = id;
    }
    
    @Column(name = "name")
    private String name;
    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        this.name = name;
    }
    
    @Column(name = "description")
    private String description;
    public String getDescription()
    {
        return description;
    }
    public void setDescription(String description)
    {
        this.description = description;
    }
    
    public PetItem(){}
}
