/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import JSONModel.Player.AverageStats;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author Izymi
 */
@Entity
public class Team implements Serializable, Comparable<Team>, ValueRank {

    private TeamName teamName;
    private List<Player> players;
    private int valueRating;
    private long id;

    public Team() {
        this(TeamName.Team_EnVyUs);
    }

    public Team(TeamName teamName) {
        this.teamName = teamName;
        this.players = new ArrayList();
        this.id = 0L;
        this.valueRating = 0;

    }

    @Id
    @GeneratedValue
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void add(Player p) {
        this.getPlayers().add(p);
    }

    @Enumerated(EnumType.STRING)
    public TeamName getTeamName() {
        return teamName;
    }

    public void setTeamName(TeamName teamName) {
        this.teamName = teamName;
    }

    @OneToMany(targetEntity = Player.class,
            cascade = CascadeType.ALL)
    public List getPlayers() {
        return players;
    }

    public void setPlayers(List players) {
        this.players = players;
    }

    @Override
    public int compareTo(Team t) {
        int value1 = valueRank();
        int value2 = t.valueRank();

        if (value1 == value2) {

            return 0;
        }
        if (value1 > 1) {
            return 1;
        } else {
            return -1;
        }

    }

    @Override
    public int valueRank() {
        int value1 = 0;
        int size = 0;
        Iterator<Player> iterator1 = this.players.listIterator();
        while (iterator1.hasNext()) {
            value1 += iterator1.next().valueRank();
            size++;

        }
        return value1 / size;
    }

    @Basic
    public int getValueRating() {
        return valueRating;
    }

    public void setValueRating(int valueRating) {
        this.valueRating = valueRating;
    }

}
