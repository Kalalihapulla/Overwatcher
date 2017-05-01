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
public class GameStats {
    private int healing_done;

    public GameStats() {
    }

    public int getHealing_done() {
        return healing_done;
    }

    public void setHealing_done(int healing_done) {
        this.healing_done = healing_done;
    }

    @Override
    public String toString() {
        return getHealing_done() + "";
    }
    
    
}
