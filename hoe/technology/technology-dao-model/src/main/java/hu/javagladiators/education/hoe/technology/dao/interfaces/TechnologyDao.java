package hu.javagladiators.education.hoe.technology.dao.interfaces;

import java.util.List;
import hu.javagladiators.education.hoe.technology.dao.models.Technology;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author krisztian
 */
public interface TechnologyDao {
    public List<Technology> listTechnologies();
    public Technology getById(long pId);
    public Technology createTechnology(Technology pData);
    public Technology updateTechnology(long pId,Technology pData);
    public void deleteTechnology(long pId);
}
