/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Player;
import Model.ProData;
import Model.RatingHeroes;
import Util.HibernateStuff;
import java.util.Iterator;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author Himel
 */
public class UpdateHeroes {

    private SessionFactory sessionFactory;

    public void insert() {
//        this.sessionFactory = HibernateStuff.getInstance().getSessionFactory();
//
//        Session session
//                = sessionFactory.openSession();
//
//        session.beginTransaction();
        ProData proData = new ProData();
        Iterator<Player> players = proData.getPlayers();
        RestTemplate restTemplate = new RestTemplate();

        while (players.hasNext()) {
            Player player = players.next();
            RatingHeroes rh = restTemplate.getForObject("http://ec2-176-34-130-81.eu-west-1.compute.amazonaws.com:4444/api/v3/u/" + player.getAccountName() + "/heroes", RatingHeroes.class);
            System.out.println(rh.getUs().getHeroes().getStats().getCompetitive().getMccree().getGeneral_stats().getGames_won() + "ddddddddddddddddddddddddd");
            System.out.println(rh.getUs().getHeroes().getStats().getCompetitive().getSombra().getGeneral_stats().getWin_percentage() + "ddddddddddddddddddddddddd");
                System.out.println(rh.getUs().getHeroes().getStats().getCompetitive().getGenji().getAverage_stats().getEliminations_average()+ "ddddddddddddddddddddddddd");
//            session.saveOrUpdate(rh);
        }

//        session.getTransaction().commit();
    }

}
