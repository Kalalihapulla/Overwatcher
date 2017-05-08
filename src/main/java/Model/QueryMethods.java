/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Util.HibernateStuff;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Izymi
 */
public abstract class QueryMethods implements Serializable {

    private SessionFactory sessionFactory;
    private static final Logger log = LoggerFactory.getLogger(QueryMethods.class);

    public Player getPlayer(Long id) {
        this.sessionFactory = HibernateStuff.getInstance().getSessionFactory();
        Session session
                = sessionFactory.openSession();

        Player player
                = (Player) session.get(Player.class, id);

        return player;

    }

    public List<Player> getAllPlayers() {
        this.sessionFactory = HibernateStuff.getInstance().getSessionFactory();
        Session session
                = sessionFactory.openSession();
        Criteria criteria = session.createCriteria(Player.class);
        List<Player> players = criteria.list();

        return players;
    }

    public Team getTeam(Long id) {
        this.sessionFactory = HibernateStuff.getInstance().getSessionFactory();
        Session session
                = sessionFactory.openSession();

        Team team
                = (Team) session.get(Team.class, id);

        return team;

    }

    public List<Team> allTeam() {
        this.sessionFactory = HibernateStuff.getInstance().getSessionFactory();
        Session session
                = sessionFactory.openSession();
        Criteria criteria = session.createCriteria(Team.class);

        List<Team> teams = criteria.list();
  
        return teams;

    }
}
