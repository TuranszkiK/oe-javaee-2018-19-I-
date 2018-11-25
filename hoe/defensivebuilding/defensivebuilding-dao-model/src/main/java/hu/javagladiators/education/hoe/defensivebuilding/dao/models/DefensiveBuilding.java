package hu.javagladiators.education.hoe.defensivebuilding.dao.models;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author nagym
 */

@Entity
@Table(name = "defensivebuilding")
@NamedQueries({
    @NamedQuery(name = "DefensiveBuildings.all", query = "SELECT u FROM DefensiveBuilding u")
})
public class DefensiveBuilding implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    @Column(name = "health")
    private int health;
    
    @Column(name = "attackPoint")
    private int attackPoint;
    
    @Column(name = "defensePoint")
    private int defensePoint;
    
    @Column(name = "buildinglevel")
    private int level;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getAttackPoint() {
        return attackPoint;
    }

    public void setAttackPoint(int attackPoint) {
        this.attackPoint = attackPoint;
    }

    public int getDefensePoint() {
        return defensePoint;
    }

    public void setDefensePoint(int defensePoint) {
        this.defensePoint = defensePoint;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    @Override
    public boolean equals(Object obj) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(obj instanceof DefensiveBuilding)) {
            return false;
        }
        DefensiveBuilding other = (DefensiveBuilding) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) id;
        return hash;
    }

    @Override
    public String toString() {
        return "hu.javagladiators.education.hoe.defensivebuilding.dao.models.DefensiveBuilding[ id=" + id + " ]";
    }
    
    
    
    
}
