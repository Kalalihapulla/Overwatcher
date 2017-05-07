/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Util.HibernateStuff;
import java.io.Serializable;
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
        session.close();
        return player;

    }
}
