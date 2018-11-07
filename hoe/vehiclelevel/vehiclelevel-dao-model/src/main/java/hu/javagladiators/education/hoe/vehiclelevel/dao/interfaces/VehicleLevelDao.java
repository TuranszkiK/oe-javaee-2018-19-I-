/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.javagladiators.education.hoe.vehiclelevel.dao.interfaces;

import hu.javagladiators.education.hoe.vehiclelevel.dao.models.VehicleLevel;
import java.util.List;

/**
 *
 * @author KTengely
 */
public interface VehicleLevelDao {
    public List<VehicleLevel> getAll();
    public VehicleLevel getById(long pId);
    public VehicleLevel create(VehicleLevel pVehLev);
    public VehicleLevel modify(long pId, VehicleLevel pData);
    public VehicleLevel delete(long pId);
}
