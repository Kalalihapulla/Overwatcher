/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import JSONModel.Hero.HeroModel;
import Util.HibernateStuff;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Himel
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
        Collections.sort(players);

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
        Collections.sort(teams);

        return teams;

    }

    public boolean createUser(UserAccount account) {
        this.sessionFactory = HibernateStuff.getInstance().getSessionFactory();

        Session session
                = sessionFactory.openSession();
        session.beginTransaction();
        session.saveOrUpdate(account);
        session.getTransaction().commit();
        return true;
    }

    public List<HeroModel> allHero() {
        this.sessionFactory = HibernateStuff.getInstance().getSessionFactory();
        Session session
                = sessionFactory.openSession();
        Criteria criteria = session.createCriteria(HeroModel.class);
        List<HeroModel> heroes = criteria.list();
        return heroes;

    }

}
