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
public class HeroStat {
    private int kill_streak_best;
    private int final_blows_most_in_game;

    public int getKill_streak_best() {
        return kill_streak_best;
    }

    public void setKill_streak_best(int kill_streak_best) {
        this.kill_streak_best = kill_streak_best;
    }

    public int getFinal_blows_most_in_game() {
        return final_blows_most_in_game;
    }

    public void setFinal_blows_most_in_game(int final_blows_most_in_game) {
        this.final_blows_most_in_game = final_blows_most_in_game;
    }

    @Override
    public String toString() {
        return getFinal_blows_most_in_game() + "ulu"; 
    }
    
}
