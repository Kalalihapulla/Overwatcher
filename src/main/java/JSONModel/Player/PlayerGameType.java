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
public class PlayerGameType implements Serializable {

    private Long id;
    private AverageStats average_stats;
    private OverallStats overall_stats;

    public PlayerGameType() {

        this.overall_stats = new OverallStats();
        this.id = 0L;
    }

    @OneToOne(targetEntity = AverageStats.class,
            cascade = CascadeType.ALL)
    public AverageStats getAverage_stats() {
        return average_stats;
    }

    public void setAverage_stats(AverageStats average_stats) {
        this.average_stats = average_stats;
    }

    @OneToOne(targetEntity = OverallStats.class,
            cascade = CascadeType.ALL)
    public OverallStats getOverall_stats() {
        return overall_stats;

    }

    public void setOverall_stats(OverallStats overall_stats) {
        this.overall_stats = overall_stats;
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
