/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JSONModel.Player;

import JSONModel.Player.StatsPlayer;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;


/**
 *
 * @author Izymi
 */
@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class RegionPlayer implements Serializable{

    private StatsPlayer stats;

    private long id;

    public RegionPlayer() {
        this.id = 0L;
        this.stats = new StatsPlayer();
    }

    @OneToOne(targetEntity = StatsPlayer.class,
            cascade = CascadeType.ALL)
    public StatsPlayer getStats() {
        return stats;
    }

    public void setStats(StatsPlayer stats) {
        this.stats = stats;
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
