/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import JSONModel.HeroRegion;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 *
 * @author Izymi
 */
@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class RatingHeroes implements Serializable {

    private long id;
    private HeroRegion us;
    private HeroRegion eu;

    public RatingHeroes() {
        this.id = 0L;
        this.eu = new HeroRegion();
        this.us = new HeroRegion();
    }

    @Id
    @GeneratedValue
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @OneToOne(targetEntity = HeroRegion.class,
            cascade = CascadeType.ALL)
    public HeroRegion getUs() {
        return us;
    }

    public void setUs(HeroRegion us) {
        this.us = us;
    }

    @OneToOne(targetEntity = HeroRegion.class,
            cascade = CascadeType.ALL)
    public HeroRegion getEu() {
        return eu;
    }

    public void setEu(HeroRegion eu) {
        this.eu = eu;
    }

}
