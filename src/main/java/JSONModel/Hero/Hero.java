/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JSONModel.Hero;

import JSONModel.Player.AverageStats;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.annotation.Generated;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 *
 * @author Izymi
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class Hero {

 
    private AverageHero average_stats;
    private GeneralHero general_stats;

    public Hero() {
      
        this.average_stats = new AverageHero();
        this.general_stats = new GeneralHero();
    }




    public AverageHero getAverage_stats() {
        return average_stats;
    }

    public void setAverage_stats(AverageHero average_stats) {
        this.average_stats = average_stats;
    }

    public GeneralHero getGeneral_stats() {
        return general_stats;
    }

    public void setGeneral_stats(GeneralHero general_stats) {
        this.general_stats = general_stats;
    }

}
