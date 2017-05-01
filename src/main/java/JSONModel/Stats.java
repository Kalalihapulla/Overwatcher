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
public class Stats implements Serializable {

    private GameType competitive;
    private Long id;

    public Stats() {
        this.competitive = new GameType();
        this.id = 0L;
    }

    @OneToOne(targetEntity = GameType.class,
            cascade = CascadeType.ALL)
    public GameType getCompetitive() {
        return competitive;
    }

    public void setCompetitive(GameType competitive) {
        this.competitive = competitive;
    }

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
