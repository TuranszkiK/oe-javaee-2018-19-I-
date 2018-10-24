package hu.javagladiators.education.hoe.cataclysms.enitites;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "CATACLYSM")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cataclysm.findAll", query = "SELECT c FROM Cataclysm c")
    , @NamedQuery(name = "Cataclysm.findById", query = "SELECT c FROM Cataclysm c WHERE c.id = :id")
    , @NamedQuery(name = "Cataclysm.findByEmpireId", query = "SELECT c FROM Cataclysm c WHERE c.empireId = :empireId")
    , @NamedQuery(name = "Cataclysm.findByDescription", query = "SELECT c FROM Cataclysm c WHERE c.description = :description")
    , @NamedQuery(name = "Cataclysm.findByIntensity", query = "SELECT c FROM Cataclysm c WHERE c.intensity = :intensity")
    , @NamedQuery(name = "Cataclysm.findByDamage", query = "SELECT c FROM Cataclysm c WHERE c.damage = :damage")
    , @NamedQuery(name = "Cataclysm.findByDate", query = "SELECT c FROM Cataclysm c WHERE c.date = :date")
    , @NamedQuery(name = "Cataclysm.findByTime", query = "SELECT c FROM Cataclysm c WHERE c.time = :time")})
public class Cataclysm implements Serializable {
    
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "EMPIRE_ID")
    private Integer empireId;
    @Size(max = 200)
    @Column(name = "DESCRIPTION")
    private String description;
    @Column(name = "INTENSITY")
    private Short intensity;
    @Column(name = "DAMAGE")
    private Integer damage;
    @Column(name = "DATE")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Column(name = "TIME")
    @Temporal(TemporalType.TIME)
    private Date time;
    
    public Cataclysm() {
    }

    public Cataclysm(Integer id) {
        this.id = id;
    }
    
   public Cataclysm(Integer id, Integer empireId, String description, Short intensity, Integer damage, Date date, Date time) {
        this.id = id;
        this.empireId = empireId;
        this.description = description;
        this.intensity = intensity;
        this.damage = damage;      
        this.date = date;
        this.time = time;
    }
   
   public Cataclysm(Integer empireId, String description, Short intensity, Integer damage, Date date, Date time) {
        this.empireId = empireId;
        this.description = description;
        this.intensity = intensity;
        this.damage = damage;      
        this.date = date;
        this.time = time;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cataclysm)) {
            return false;
        }
        Cataclysm other = (Cataclysm) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Cataclysm[ id=" + id + " ]";
    }
}
