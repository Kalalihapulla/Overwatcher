/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AbstractModels;

import JSONModel.AverageStats;
import javax.persistence.CascadeType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 *
 * @author Izymi
 */
public abstract class StatisticObject {

    private Long id;
    private AverageStats average_stats;
 

    public StatisticObject() {
        this.average_stats = new AverageStats();
 
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

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
