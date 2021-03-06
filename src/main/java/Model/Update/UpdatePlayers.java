/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Update;

import Model.Player;
import Model.Data.ProData;
import Model.RatingPlayer;
import Model.Team;
import Model.TeamName;
import Util.HibernateStuff;
import java.util.Iterator;
import java.util.Stack;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author Himel
 */
public class UpdatePlayers {

    private SessionFactory sessionFactory;
    private final Stack<Team> teams = new Stack();
    private final Team envyus;
    private final Team c9;
    private final Team misfits;
    private final Team nrg;
    private final Team fnatic;
    private final Team rogue;
    private static final Logger log = LoggerFactory.getLogger(UpdatePlayers.class);

    public UpdatePlayers() {

        this.envyus = new Team(TeamName.Team_EnVyUs);
        this.c9 = new Team(TeamName.Cloud9);
        this.misfits = new Team(TeamName.Misfits);
        this.nrg = new Team(TeamName.NRG_Esports);
        this.fnatic = new Team(TeamName.Fnatic);
        this.rogue = new Team(TeamName.Rogue);
    }

    public void insertData() {
        addTeams();
        this.sessionFactory = HibernateStuff.getInstance().getSessionFactory();

        Session session
                = sessionFactory.openSession();
        session.beginTransaction();
        ProData proData = new ProData();
        Iterator<Player> players = proData.getPlayers();
        RestTemplate restTemplate = new RestTemplate();

        while (players.hasNext()) {
            Player player = players.next();
            RatingPlayer us = restTemplate.getForObject("http://ec2-176-34-130-81.eu-west-1.compute.amazonaws.com:4444/api/v3/u/" + player.getAccountName() + "/stats", RatingPlayer.class);
            player.setRating(us);
            player.valueRank();
            addToTeam(player);
            session.saveOrUpdate(player);
        }
        while (!teams.isEmpty()) {
            Team team = teams.pop();
            team.valueRank();
            session.saveOrUpdate(team);
        }
        session.getTransaction().commit();
        System.exit(0);
    }

    public void addToTeam(Player p) {

        switch (p.getTeamName()) {
            case Team_EnVyUs:
                envyus.add(p);
                break;
            case Cloud9:
                c9.add(p);
                break;
            case Misfits:
                misfits.add(p);
                break;
            case NRG_Esports:
                nrg.add(p);
                break;
            case Fnatic:
                fnatic.add(p);
                break;
            case Rogue:
                rogue.add(p);
                break;
        }

    }

    public void addTeams() {
        if (teams.empty()) {
            teams.push(envyus);
            teams.push(c9);
            teams.push(misfits);
            teams.push(nrg);
            teams.push(rogue);
            teams.push(fnatic);

        }
    }
}
