/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.javagladiators.education.factory.dao.models;

import javax.persistence.Entity;

/**
 *
 * @author Lóci
 */
@Entity
public class Factory extends NameDescriptionBase {
    private String name, description, product, from_prod;
    
    public Factory() {
        super();
    }

    
    public Factory(String name, String description, String prod, String from_prod) {
        super();
        this.name = name;
        this.description = description;
        this.product = prod;
        this.from_prod = from_prod;
    }

    /**
     * @return the product
     */
    public String getProduct() {
        return product;
    }

    /**
     * @param product the product to set
     */
    public void setProduct(String product) {
        this.product = product;
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
     * @return the from
     */
    public String getFrom() {
        return from_prod;
    }

    /**
     * @param from the from to set
     */
    public void setFrom(String from) {
        this.from_prod = from;
    }
    
}
