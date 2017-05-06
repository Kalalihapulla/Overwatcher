/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JSONModel;

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
public class RegionHero implements Serializable {

    private long id;
    private HeroType heroes;

    public RegionHero() {
        this.heroes = new HeroType();
    }

    @Id
    @GeneratedValue
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @OneToOne(targetEntity = HeroType.class,
            cascade = CascadeType.ALL)
    public HeroType getHeroes() {
        return heroes;
    }

    public void setHeroes(HeroType heroes) {
        this.heroes = heroes;
    }

}
