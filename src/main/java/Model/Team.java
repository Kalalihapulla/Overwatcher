/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import JSONModel.AverageStats;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
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
public class Team implements Serializable {

    private TeamName teamName;
    private List<Player> players;
    private long id;

    public Team() {
        this(TeamName.Team_EnVyUs);
    }

    public Team(TeamName teamName) {
        this.teamName = teamName;
        this.players = new ArrayList();
        this.id = 0L;

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
}
