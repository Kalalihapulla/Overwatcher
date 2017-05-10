/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Update;

import JSONModel.Hero.HeroModel;
import Model.Data.HeroData;
import Model.Player;
import Model.Data.ProData;
import Model.RatingHeroes;
import Util.HibernateStuff;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;
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
        HeroData heroData = new HeroData();
        ProData proData = new ProData();
        TreeSet<RatingHeroes> set = new TreeSet();

//        this.sessionFactory = HibernateStuff.getInstance().getSessionFactory();
//
//        Session session
//                = sessionFactory.openSession();
//        session.beginTransaction();
        Iterator<Player> players = proData.getPlayers();
        Iterator<HeroModel> heroes = heroData.getHeroes();
        RestTemplate restTemplate = new RestTemplate();

        while (players.hasNext()) {
            Player player = players.next();
            RatingHeroes rh = restTemplate.getForObject("http://ec2-176-34-130-81.eu-west-1.compute.amazonaws.com:4444/api/v3/u/" + player.getAccountName() + "/heroes", RatingHeroes.class);
//            System.out.println(rh.getUs().getHeroes().getStats().getCompetitive().getMccree().getGeneral_stats().getGames_won() + "ddddddddddddddddddddddddd");
//            System.out.println(rh.getUs().getHeroes().getStats().getCompetitive().getSombra().getGeneral_stats().getWin_percentage() + "ddddddddddddddddddddddddd");
//            System.out.println(rh.getUs().getHeroes().getStats().getCompetitive().getGenji().getAverage_stats().getEliminations_average() + "ddddddddddddddddddddddddd");
            System.out.println(rh.getUs().getHeroes().getStats().getCompetitive().getPharah().getAverage_stats().getDamage_done_average());
            set.add(rh);

        }
        Iterator<RatingHeroes> ratingHe = set.iterator();
        List<RatingHeroes> list;
        list = getList(ratingHe);

        while (heroes.hasNext()) {
            HeroModel hm = heroes.next();
            String name = hm.getName();
            switch (name) {
                case "Pharah":
                    list.forEach((rh) -> {
                        hm.addElis(rh.getUs().getHeroes().getStats().getCompetitive().getPharah().getAverage_stats().getEliminations_average());
                        hm.addDmgAvr(rh.getUs().getHeroes().getStats().getCompetitive().getPharah().getAverage_stats().getDamage_done_average());
                        hm.addMedals(rh.getUs().getHeroes().getStats().getCompetitive().getPharah().getGeneral_stats().getMedals());
                        hm.addWins(rh.getUs().getHeroes().getStats().getCompetitive().getPharah().getGeneral_stats().getGames_won());
                        hm.addLosses(rh.getUs().getHeroes().getStats().getCompetitive().getPharah().getGeneral_stats().getGames_lost());
                        hm.addWinRate();
                    });
                    break;
                case "McCree":
                    list.forEach((rh) -> {
                        hm.addElis(rh.getUs().getHeroes().getStats().getCompetitive().getMccree().getAverage_stats().getEliminations_average());
                        hm.addDmgAvr(rh.getUs().getHeroes().getStats().getCompetitive().getMccree().getAverage_stats().getDamage_done_average());
                        hm.addMedals(rh.getUs().getHeroes().getStats().getCompetitive().getMccree().getGeneral_stats().getMedals());
                        hm.addWins(rh.getUs().getHeroes().getStats().getCompetitive().getMccree().getGeneral_stats().getGames_won());
                        hm.addLosses(rh.getUs().getHeroes().getStats().getCompetitive().getMccree().getGeneral_stats().getGames_lost());
                        hm.addWinRate();
                    });
                    break;
                case "Sombra":
                    list.forEach((rh) -> {
                        hm.addElis(rh.getUs().getHeroes().getStats().getCompetitive().getSombra().getAverage_stats().getEliminations_average());
                        hm.addDmgAvr(rh.getUs().getHeroes().getStats().getCompetitive().getSombra().getAverage_stats().getDamage_done_average());
                        hm.addMedals(rh.getUs().getHeroes().getStats().getCompetitive().getSombra().getGeneral_stats().getMedals());
                        hm.addWins(rh.getUs().getHeroes().getStats().getCompetitive().getSombra().getGeneral_stats().getGames_won());
                        hm.addLosses(rh.getUs().getHeroes().getStats().getCompetitive().getSombra().getGeneral_stats().getGames_lost());
                        hm.addWinRate();
                    });
                    break;
                case "Tracer":
                    list.forEach((rh) -> {
                        hm.addElis(rh.getUs().getHeroes().getStats().getCompetitive().getTracer().getAverage_stats().getEliminations_average());
                        hm.addDmgAvr(rh.getUs().getHeroes().getStats().getCompetitive().getTracer().getAverage_stats().getDamage_done_average());
                        hm.addMedals(rh.getUs().getHeroes().getStats().getCompetitive().getTracer().getGeneral_stats().getMedals());
                        hm.addWins(rh.getUs().getHeroes().getStats().getCompetitive().getTracer().getGeneral_stats().getGames_won());
                        hm.addLosses(rh.getUs().getHeroes().getStats().getCompetitive().getTracer().getGeneral_stats().getGames_lost());
                        hm.addWinRate();
                    });
                    break;
                case "Ana":
                    list.forEach((rh) -> {
                        hm.addElis(rh.getUs().getHeroes().getStats().getCompetitive().getAna().getAverage_stats().getEliminations_average());
                        hm.addDmgAvr(rh.getUs().getHeroes().getStats().getCompetitive().getAna().getAverage_stats().getDamage_done_average());
                        hm.addMedals(rh.getUs().getHeroes().getStats().getCompetitive().getAna().getGeneral_stats().getMedals());
                        hm.addWins(rh.getUs().getHeroes().getStats().getCompetitive().getAna().getGeneral_stats().getGames_won());
                        hm.addLosses(rh.getUs().getHeroes().getStats().getCompetitive().getAna().getGeneral_stats().getGames_lost());
                        hm.addWinRate();
                    });
                    break;
            }
            System.out.println(hm);

        }
        System.out.println(set);
//        session.getTransaction().commit();
    }

    public List<RatingHeroes> getList(Iterator<RatingHeroes> it) {
        List<RatingHeroes> list = new ArrayList<>();
        while (it.hasNext()) {
            list.add(it.next());
        }
        return list;

    }

}
