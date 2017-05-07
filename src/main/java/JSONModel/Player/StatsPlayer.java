/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JSONModel.Player;

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
public class StatsPlayer implements Serializable {

    private PlayerGameType competitive;
    private Long id;

    public StatsPlayer() {
        this.competitive = new PlayerGameType();
        this.id = 0L;
    }

    @OneToOne(targetEntity = PlayerGameType.class,
            cascade = CascadeType.ALL)
    public PlayerGameType getCompetitive() {
        return competitive;
    }

    public void setCompetitive(PlayerGameType competitive) {
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
