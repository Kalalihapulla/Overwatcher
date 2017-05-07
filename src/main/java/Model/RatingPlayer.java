/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import JSONModel.Player.RegionPlayer;
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

    private RegionPlayer us;
    private RegionPlayer kr;

    public RatingPlayer() {
        this.id = 0L;
        this.us = new RegionPlayer();
        this.kr = new RegionPlayer();

    }

    @Override
    public String toString() {
        return us.toString();
    }

    @OneToOne(targetEntity = RegionPlayer.class,
            cascade = CascadeType.ALL)
    public RegionPlayer getUs() {
        return us;
    }

    public void setUs(RegionPlayer us) {
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
   @OneToOne(targetEntity = RegionPlayer.class,
            cascade = CascadeType.ALL)
    public RegionPlayer getKr() {
        return kr;
    }

    public void setKr(RegionPlayer kr) {
        this.kr = kr;
    }

}
