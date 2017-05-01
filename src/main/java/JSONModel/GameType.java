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
public class GameType {
    private GameStats game_stats;

    public GameType() {
    }

    public GameStats getGame_stats() {
        return game_stats;
    }

    public void setGame_stats(GameStats game_stats) {
        this.game_stats = game_stats;
    }
    
}
