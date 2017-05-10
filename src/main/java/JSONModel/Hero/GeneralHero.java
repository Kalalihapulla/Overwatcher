/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JSONModel.Hero;

import Model.Calculatable;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author Izymi
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class GeneralHero implements Serializable, Calculatable {


    private double win_percentage;
    private int games_lost;
    private int games_won;
    private int medals;

    public GeneralHero() {

    }

   
 
    @Override
    public int calculate() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    public double getWin_percentage() {
        return win_percentage;
    }

    public void setWin_percentage(Double win_percentage) {
        this.win_percentage = win_percentage;
    }

    public int getGames_lost() {
        return games_lost;
    }

    public void setGames_lost(int games_lost) {
        this.games_lost = games_lost;
    }

    public int getGames_won() {
        return games_won;
    }

    public void setGames_won(int games_won) {
        this.games_won = games_won;
    }

    public int getMedals() {
        return medals;
    }

    public void setMedals(int medals) {
        this.medals = medals;
    }

}
