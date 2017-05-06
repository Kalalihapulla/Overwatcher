/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import JSONModel.Region;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author Izymi
 */
@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class RatingPlayer implements Serializable {

    private long id;

    private Region us;
    private Region kr;

    public RatingPlayer() {
        this.id = 0L;
        this.us = new Region();
        this.kr = new Region();

    }

    @Override
    public String toString() {
        return us.toString();
    }

    @OneToOne(targetEntity = Region.class,
            cascade = CascadeType.ALL)
    public Region getUs() {
        return us;
    }

    public void setUs(Region us) {
        this.us = us;
    }

    @GeneratedValue
    @Id
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
   @OneToOne(targetEntity = Region.class,
            cascade = CascadeType.ALL)
    public Region getKr() {
        return kr;
    }

    public void setKr(Region kr) {
        this.kr = kr;
    }

}
