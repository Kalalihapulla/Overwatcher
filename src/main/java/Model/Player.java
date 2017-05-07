/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Controller.Observer;
import JSONModel.Player.RegionPlayer;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 *
 * @author Izymi
 */
@Entity
public class Player implements Serializable, Observer, Comparable<Player>, ValueRank {

    private Long id;
    private String playerName;
    private String accountName;
    private TeamName teamName;
    private RatingPlayer rating;
    private int valueRating;

    public Player(String playerName, String accountName, TeamName name) {
        this.id = 0L;
        this.playerName = playerName;
        this.accountName = accountName;
        this.teamName = name;
        this.rating = new RatingPlayer();
        this.valueRating = 0;

    }

    public Player() {
        this("unknown", "unknown", TeamName.Team_EnVyUs);
    }

    @Override
    public String toString() {
        return id + playerName + teamName;
    }

    @GeneratedValue
    @Id
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    @Basic
    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    @Enumerated(EnumType.STRING)
    public TeamName getTeamName() {
        return teamName;
    }

    public void setTeamName(TeamName teamName) {
        this.teamName = teamName;
    }

    @Override
    public void update() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int compareTo(Player t) {
        int value1 = valueRank();
        int value2 = t.valueRank();
        if (value1 == value2) {
            return 0;
        }

        if (value1 > value2) {
            return 1;

        } else {
            return -1;

        }
    }

    @OneToOne(targetEntity = RatingPlayer.class,
            cascade = CascadeType.ALL)
    public RatingPlayer getRating() {
        return rating;
    }

    public void setRating(RatingPlayer rating) {
        this.rating = rating;
    }

    @Override
    public int valueRank() {
        int kr = rating.getKr().getStats().getCompetitive().getAverage_stats().calculate() + rating.getKr().getStats().getCompetitive().getOverall_stats().calculate();
        int us = rating.getUs().getStats().getCompetitive().getAverage_stats().calculate() + rating.getUs().getStats().getCompetitive().getOverall_stats().calculate();
        if (kr > us) {
            valueRating = kr;
            return kr;
        } else {
            valueRating = us;
            return us;
        }
    }

    @Basic
    public int getValueRating() {
        return valueRating;
    }

    public void setValueRating(int valueRating) {
        this.valueRating = valueRating;
    }

}
