/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JSONModel.Hero;

import java.io.Serializable;
import static java.lang.Math.round;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author Izymi
 */
@Entity
public class HeroModel implements Serializable, Comparable<HeroModel> {

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
        this.id = 0L;
    }

    public HeroModel() {
        super();
    }

    @Override
    public String toString() {
        return name + " Winrate " + winRate + " Games lost " + games_lost + " Gameswon " + games_won + " Medals " + medals + " Damageavr "
                + damage_done_average + " Eliavr " + eliminations_average + "medlperten " + medalsPerTen;
    }

    @Id
    @GeneratedValue
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    public double getWinRate() {
        return winRate;
    }

    public void setWinRate(double winRate) {
        this.winRate = winRate;
    }

    @Basic
    public int getGames_lost() {
        return games_lost;
    }

    public void setGames_lost(int games_lost) {
        this.games_lost = games_lost;
    }

    @Basic
    public int getGames_won() {
        return games_won;
    }

    public void setGames_won(int games_won) {
        this.games_won = games_won;
    }

    @Basic
    public int getMedals() {
        return medals;
    }

    public void setMedals(int medals) {
        this.medals = medals;
    }

    @Basic
    public int getDamage_done_average() {
        return damage_done_average;
    }

    public void setDamage_done_average(int damage_done_average) {
        this.damage_done_average = damage_done_average;
    }

    @Basic
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
    @Basic
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

    @Override
    public int compareTo(HeroModel t) {
        if (winRate == t.winRate) {
            return 0;
        }
        if (winRate < t.winRate) {
            return 1;
        } else {
            return -1;
        }
    }

}
