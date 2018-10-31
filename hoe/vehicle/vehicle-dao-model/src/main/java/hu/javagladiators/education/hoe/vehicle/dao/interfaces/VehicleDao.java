/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.javagladiators.education.hoe.vehicle.dao.interfaces;

import hu.javagladiators.education.hoe.vehicle.dao.models.Vehicle;
import java.util.List;

/**
 *
 * @author TYIPPI
 */
public interface VehicleDao {
    public List<Vehicle> getAll();
    public Vehicle getById(long pId);
    public Vehicle getByName(String pName);
    public Vehicle create(Vehicle pData);
    public Vehicle modify(long pId,Vehicle pData);
    public Vehicle delete(long pId);
}
