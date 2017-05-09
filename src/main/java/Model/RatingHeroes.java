/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import JSONModel.Hero.RegionHero;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 *
 * @author Himel
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class RatingHeroes implements Serializable {

    private RegionHero us;
//    private RegionHero kr;

    public RatingHeroes() {

//        this.kr = new RegionHero();
        this.us = new RegionHero();
    }

    @OneToOne(targetEntity = RegionHero.class,
            cascade = CascadeType.ALL)
    public RegionHero getUs() {
        return us;
    }

    public void setUs(RegionHero us) {
        this.us = us;
    }
//
//    @OneToOne(targetEntity = RegionHero.class,
//            cascade = CascadeType.ALL)
//    public RegionHero getKr() {
//        return kr;
//    }
//
//    public void setKr(RegionHero kr) {
//        this.kr = kr;
//    }

}
