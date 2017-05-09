/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JSONModel.Hero;

/**
 *
 * @author Izymi
 */
public class HeroModel {

    private long id;
    private String name;
    private double winRate;
    private int games_lost;
    private int games_won;
    private int medals;
    private double damage_done_average;
    private double eliminations_average;

    public HeroModel() {
        this.id = 0;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getWinRate() {
        return winRate;
    }

    public void setWinRate(double winRate) {
        this.winRate = winRate;
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

    public double getDamage_done_average() {
        return damage_done_average;
    }

    public void setDamage_done_average(double damage_done_average) {
        this.damage_done_average = damage_done_average;
    }

    public double getEliminations_average() {
        return eliminations_average;
    }

    public void setEliminations_average(double eliminations_average) {
        this.eliminations_average = eliminations_average;
    }

}
