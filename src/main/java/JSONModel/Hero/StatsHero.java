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
@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class StatsHero implements Serializable {

    private HeroGameType competitive;
    private Long id;

    public StatsHero() {
        this.competitive = new HeroGameType();
        this.id = 0L;

    }

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @OneToOne(targetEntity = HeroGameType.class,
            cascade = CascadeType.ALL)
    public HeroGameType getCompetitive() {
        return competitive;
    }

    public void setCompetitive(HeroGameType competitive) {
        this.competitive = competitive;
    }

}
