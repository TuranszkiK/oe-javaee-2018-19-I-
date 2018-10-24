package hu.javagladiators.education.hoe.user.dao.model;

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

/**
 * @author krisztian
 */
@Entity
@Table(
    name = "user", 
    indexes = {
        @Index(name = "user_id", columnList = "id", unique = true),
        @Index(name = "user_id", columnList = "name", unique = true)     
    })
@NamedQueries({
    @NamedQuery(name = "User.login", query = "SELECT u FROM User u WHERE u.name=:name AND u.password=:password"),
    @NamedQuery(name = "User.name", query = "SELECT u FROM User u WHERE u.name=:name ")
})
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    public long getId() {return id;}
    public void setId(long id) {this.id = id;}
    
    @Column(name = "name")
    private String name;
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
      
    @Column(name = "role")
    private String role;
    public String getRole() {return role;}
    public void setRole(String role) {this.role = role;}
    
    @Column(name = "password")
    private String password;
    public String getPassword() {return password;}
    public void setPassword(String password) {this.password = password;}
    
    

    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) id;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof User)) {
            return false;
        }
        User other = (User) object;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "hu.javagladiators.education.hoe.user.dao.model.User[ id=" + id + " ]";
    }
    
}
