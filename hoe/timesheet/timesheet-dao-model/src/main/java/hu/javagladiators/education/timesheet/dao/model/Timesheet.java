/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.javagladiators.education.timesheet.dao.model;

import java.util.Date;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(
    name = "timesheet", 
    indexes = {
        @Index(name = "timesheet_id", columnList = "id", unique = true)
    })
@NamedQueries({
    @NamedQuery(name = "timesheet.all", query = "SELECT u FROM Timesheet u "),
     @NamedQuery(name = "timesheet.nextId", query = "SELECT Id+1 FROM Timesheet"),
})
/**
 *
 * @author xpowerfullx
 */
public class Timesheet implements Serializable{
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    public long getId() {return id;}
    public void setId(long id) {this.id = id;}
    
    @Column(name = "dateFrom")
    private Date dateFrom;
    public Date getDateFrom() {return dateFrom;}
    public void setDateFrom(Date dateFrom) {this.dateFrom = dateFrom;}
    
    @Column(name = "dateTo")
    private Date dateTo;
    public Date getDateTo() {return dateTo;}
    public void setDateTo(Date dateTo) {this.dateTo = dateTo;}
      
    @Column(name = "salary")
    private int salary;
    public int getSalary() {return salary;}
    public void setSalary(int salary) {this.salary = salary;}
}
