/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JSONModel;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 *
 * @author Izymi
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Stats {
    private GameType competitive;

    public Stats() {
    }

    public GameType getCompetitive() {
        return competitive;
    }

    public void setCompetitive(GameType competitive) {
        this.competitive = competitive;
    }
    
}
