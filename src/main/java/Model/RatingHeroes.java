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
public class RatingHeroes implements Serializable, Comparable<RatingHeroes> {

    private RegionHero us;
//    private RegionHero kr;

    public RatingHeroes() {

//        this.kr = new RegionHero();
        this.us = new RegionHero();
    }

    @Override
    public String toString() {
        return us.getHeroes().getStats().getCompetitive().getPharah().getAverage_stats().getEliminations_average() + "";
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

    @Override
    public int compareTo(RatingHeroes o) {
        double value1 = us.getHeroes().getStats().getCompetitive().getDva().getGeneral_stats().getWin_percentage() + us.getHeroes().getStats().getCompetitive().getGenji().getGeneral_stats().getWin_percentage() + us.getHeroes().getStats().getCompetitive().getMccree().getGeneral_stats().getWin_percentage();
        double value2 = o.getUs().getHeroes().getStats().getCompetitive().getDva().getGeneral_stats().getWin_percentage() + o.getUs().getHeroes().getStats().getCompetitive().getGenji().getGeneral_stats().getWin_percentage() + o.getUs().getHeroes().getStats().getCompetitive().getMccree().getGeneral_stats().getWin_percentage();

        if (value1 == value2) {
            return 0;
        }
        if (value1 < value2) {
            return 1;

        } else {
            return -1;
        }

    }

}
