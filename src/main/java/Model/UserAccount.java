/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Entity

//@Table(name = "userbase") 
/**
 * Contains methods and parameters for the UserAccount object.
 */
public class UserAccount implements Serializable {

    private Long id;
    private String username;
    private String password;
    private String bnet;

    public UserAccount() {
        this("unknown", "unknown","unknown");

    }

    public UserAccount(String username, String bnet, String password) {

        this.id = 0L;
        this.username = username;
        this.password = password;
        this.bnet = bnet;

    }

  
    @GeneratedValue
    @Id
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    
    @Basic
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    
    @Basic
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return this.username;
    }

    public String getBnet() {
        return bnet;
    }

    public void setBnet(String bnet) {
        this.bnet = bnet;
    }

}
