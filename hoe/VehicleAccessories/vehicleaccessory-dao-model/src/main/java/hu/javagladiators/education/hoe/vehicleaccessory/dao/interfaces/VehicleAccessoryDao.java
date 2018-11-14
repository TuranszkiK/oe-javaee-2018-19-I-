/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.javagladiators.education.hoe.vehicleaccessory.dao.interfaces;

import java.util.List;

/**
 *
 * @author Boldi
 */
public interface VehicleAccessoryDao {
    public List<VehicleAccessoryDao> getAll();
    public VehicleAccessoryDao getById(long pId);
    public VehicleAccessoryDao getByName(String pName);
    public VehicleAccessoryDao create(VehicleAccessoryDao pData);
    public VehicleAccessoryDao modify(long pId,VehicleAccessoryDao pData);
    public VehicleAccessoryDao delete(long pId);
}
