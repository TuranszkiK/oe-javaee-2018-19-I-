/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.javagladiators.education.timesheet.dao.jpa;

import hu.javagladiators.education.timesheet.dao.model.Timesheet;
import java.util.List;

/**
 *
 * @author xpowerfullx
 */
interface TimesheetDao {
    public List<Timesheet> getAll();
    public Timesheet getById(long pId);
    public Timesheet create(Timesheet pData);
    public Timesheet modify(long pId, Timesheet pData);
    public Timesheet delete(long pId);
    public long getNextId();
}
