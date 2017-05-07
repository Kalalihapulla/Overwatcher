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
 * @author Izymi
 */
@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class HeroGameType implements Serializable {

    private Hero pharah;
    private long id;

    public HeroGameType() {
        this.id = 0L;
        this.pharah = new Hero();
    }
   @OneToOne(targetEntity = Hero.class,
            cascade = CascadeType.ALL)
    public Hero getPharah() {
        return pharah;
    }

    public void setPharah(Hero pharah) {
        this.pharah = pharah;
    }

    @Id
    @GeneratedValue
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

}
