/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.javagladiators.education.timesheet.service.cdi;

import hu.javagladiators.education.timesheet.dao.interfaces.TimesheetDao;
import hu.javagladiators.education.timesheet.dao.model.Timesheet;
import java.util.List;
import java.util.logging.Logger;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

/**
 *
 * @author xpowerfullx
 */

@ApplicationScoped

public class TimesheetServiceImpl implements TimesheetDao{

    private static final Logger log = Logger.getLogger("SpeciesDaoImpl");

    @Inject
    protected TimesheetDao dao;

    public TimesheetServiceImpl() {log.info("create new instance");}
    
    @Override
    public List<Timesheet> getAll() {
        return dao.getAll();
    }

    @Override
    public Timesheet getById(long pId) {
        return dao.getById(pId);
    }

    @Override
    public Timesheet create(Timesheet pData) {
        try{
        return dao.create(pData);
        }catch(Exception ex){
            throw ex;
        }
    }

    @Override
    public Timesheet modify(long pId, Timesheet pData) {
        try{
        return dao.modify(pId, pData);
        }catch(Exception ex){
            throw ex;
        }
    }

    @Override
    public Timesheet delete(long pId) {
        return dao.delete(pId);
    }

    @Override
    public long getNextId() {
        return dao.getNextId();
    }
}
