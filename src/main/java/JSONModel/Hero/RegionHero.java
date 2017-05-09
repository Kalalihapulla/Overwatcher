/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JSONModel.Hero;

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
public class RegionHero implements Serializable {


    private HeroType heroes;

    public RegionHero() {
        this.heroes = new HeroType();
  
    }

  
 
    public HeroType getHeroes() {
        return heroes;
    }

    public void setHeroes(HeroType heroes) {
        this.heroes = heroes;
    }

}
