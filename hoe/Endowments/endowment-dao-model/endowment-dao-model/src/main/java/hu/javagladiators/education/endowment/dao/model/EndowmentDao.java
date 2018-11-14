/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.javagladiators.education.endowment.dao.model;

/**
 *
 * @author krisztian
 */
public interface EndowmentDao {    
    public Endowment getByType(String pType);
    public Endowment create(Endowment pEndowment);
}
