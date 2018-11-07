/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.settlementdao;

import datamodel.Settlement;

/**
 *
 * @author krisztian
 */
public interface SettlementDao {
    public Settlement getCurrentSettlement();
    public Settlement getbyId(long id) throws Exception;
    public void saveSettlement(Settlement newsett);
    public void deleteSettlement(Settlement sett);
}
