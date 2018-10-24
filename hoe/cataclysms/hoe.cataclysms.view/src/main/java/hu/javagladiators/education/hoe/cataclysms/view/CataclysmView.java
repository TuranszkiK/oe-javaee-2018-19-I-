/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.javagladiators.education.hoe.cataclysms.view;

import hu.javagladiators.education.hoe.cataclysms.enitites.Cataclysm;
import java.util.Date;

public class CataclysmView {
    
    private Integer id;
    private Integer empireId;
    private String description;
    private Short intensity;
    private Integer damage;
    private String date;
    private String time;
    
   public CataclysmView(Integer id, Integer empireId, String description, Short intensity, Integer damage, Date date, Date time){
        this.id = id;
        this.empireId = empireId;
        this.description = description;
        this.intensity = intensity;
        this.damage = damage;             
        this.date = String.valueOf(date.getYear() + 1900) + "-" + extend(date.getMonth()) + "-" + extend(date.getDay());
        this.time = extend(time.getHours()) + ":" + extend(time.getMinutes());
    }
   
   public CataclysmView(Cataclysm cat){
        this.id = cat.getId();
        this.empireId = cat.getEmpireId();
        this.description = cat.getDescription();
        this.intensity = cat.getIntensity();
        this.damage = cat.getDamage();             
        this.date = String.valueOf(cat.getDate().getYear() + 1900) + "-" + String.valueOf(cat.getDate().getMonth()) + "-" + String.valueOf(cat.getDate().getDay());
        this.time = extend(cat.getTime().getHours()) + ":" + extend(cat.getTime().getMinutes());
    }
 
    private String extend(int num) {
        if(num < 10){
            return "0" + String.valueOf(num);
        }
        else{
            return String.valueOf(num);
        }
    }
   
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getEmpireId() {
        return empireId;
    }

    public void setEmpireId(Integer empireId) {
        this.empireId = empireId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Short getIntensity() {
        return intensity;
    }

    public void setIntensity(Short intensity) {
        this.intensity = intensity;
    }

    public Integer getDamage() {
        return damage;
    }

    public void setDamage(Integer damage) {
        this.damage = damage;
    }

    public String getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = String.valueOf(date.getYear()) + "-" + String.valueOf(date.getMonth()) + "-" + String.valueOf(date.getDay());
    }

    public String getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time.toString();
    }
}
