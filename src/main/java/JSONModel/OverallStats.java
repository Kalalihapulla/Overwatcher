/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JSONModel;

import Model.Calculatable;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author Izymi
 * 
 */

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class OverallStats implements Calculatable, Serializable{
  
    private long id;
    private double win_rate;
    private int comprank;
    private int losses;
    private int wins;
    private int level;
    private int prestige;
    private int games;
    private String rank_image;
    private String avatar;

    public OverallStats() {
        this.id = 0L;
    }
    

    @Override
    public double calculate() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
  @Id
  @GeneratedValue
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getWin_rate() {
        return win_rate;
    }

    public void setWin_rate(double win_rate) {
        this.win_rate = win_rate;
    }

    public int getComprank() {
        return comprank;
    }

    public void setComprank(int comprank) {
        this.comprank = comprank;
    }

    public int getLosses() {
        return losses;
    }

    public void setLosses(int losses) {
        this.losses = losses;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getPrestige() {
        return prestige;
    }

    public void setPrestige(int prestige) {
        this.prestige = prestige;
    }

    public int getGames() {
        return games;
    }

    public void setGames(int games) {
        this.games = games;
    }

    public String getRank_image() {
        return rank_image;
    }

    public void setRank_image(String rank_image) {
        this.rank_image = rank_image;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
    
}
