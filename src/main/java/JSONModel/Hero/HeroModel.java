/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JSONModel.Hero;

import static java.lang.Math.round;

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
    private int damage_done_average;
    private double eliminations_average;
    private double medalsPerTen;

    public HeroModel(String name) {
        this.name = name;
        this.id = 0;
    }

    @Override
    public String toString() {
        return name + " Winrate " + winRate + " Games lost " + games_lost + " Gameswon " + games_won + " Medals " + medals + " Damageavr "
                + damage_done_average + " Eliavr " + eliminations_average + "medlperten " + medalsPerTen;
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

    public void setDamage_done_average(int damage_done_average) {
        this.damage_done_average = damage_done_average;
    }

    public double getEliminations_average() {
        return eliminations_average;
    }

    public void setEliminations_average(double eliminations_average) {
        this.eliminations_average = eliminations_average;
    }

    public void addElis(double eli) {

        if (eli > 10.0) {

            eliminations_average += eli;
            eliminations_average = round(eliminations_average / 2, 2);
        }
    }

    public void addDmgAvr(double dmg) {
        if (dmg > 1000.0) {
            damage_done_average += dmg;
            damage_done_average /= 2;

        }

    }

    public void addMedals(int medal) {
        if (medal > 1) {
            medals += medal;

        }

    }

    public void addWins(int wins) {

        games_won += wins;

    }

    public void addLosses(int losses) {

        games_lost += losses;

    }

    public void addWinRate() {

        setWinRate(round((double) games_won / (double) (games_won + games_lost), 2));

    }

    public static double round(double value, int places) {
        if (places < 0) {
            throw new IllegalArgumentException();
        }

        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }

    /**
     * @return the medalsPerTen
     */
    public double getMedalsPerTen() {
        return medalsPerTen;
    }

    /**
     * @param medalsPerTen the medalsPerTen to set
     */
    public void setMedalsPerTen(double medalsPerTen) {
        this.medalsPerTen = medalsPerTen;
    }

    public void addMedalsPerTen() {
        double value = ((double) medals / (double) (games_won + games_lost) * 10.0);

        setMedalsPerTen(round(value, 1));

    }

}
