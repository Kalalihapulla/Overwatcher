/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JSONModel.Hero;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import javax.annotation.Generated;
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
public class HeroType implements Serializable {

    private StatsHero stats;

    public HeroType() {

        this.stats = new StatsHero();
    }

    public StatsHero getStats() {
        return stats;
    }

    public void setStats(StatsHero stats) {
        this.stats = stats;
    }

}
