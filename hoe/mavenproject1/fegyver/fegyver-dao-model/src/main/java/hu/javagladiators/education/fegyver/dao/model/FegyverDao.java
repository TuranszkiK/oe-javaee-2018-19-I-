/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.javagladiators.education.fegyver.dao.model;

import java.util.List;
//import hu.javanetacademy.datamodel.Fegyver;

/**
 *
 * @author tnyarsik
 */
public interface FegyverDao {
    Fegyver keresFegyver(long id);

    List<Fegyver> getFegyver();

    void ujFegyver(Fegyver fegyver);

    void torolFegyver(Fegyver fegyver);

    void szerkesztFegyver(Fegyver fegyver, String name, String desc);
}
