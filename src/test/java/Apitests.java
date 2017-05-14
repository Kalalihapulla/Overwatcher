
import Model.Update.UpdatePlayers;
import Model.Update.UpdateHeroes;
import JSONModel.Player.RegionPlayer;
import Model.Player;
import Model.Data.ProData;
import Model.RatingHeroes;
import Model.RatingPlayer;
import Model.Team;
import Model.TeamName;
import Model.UserAccount;
import Util.HibernateStuff;
import java.util.Iterator;
import java.util.Map;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Assert;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Izymi
 */
public class Apitests {
    
    private SessionFactory sessionFactory;
    private static final Logger log = LoggerFactory.getLogger(Apitests.class);

    //
//    @Test
//    public void riotJava1() throws RiotApiException {       
//        RiotApi api = new RiotApi("RGAPI-696ed310-71e7-4f8e-bee1-9b3ee195f98a");
//
//        Map<String, Summoner> summoners = api.getSummonersByName(RegionPlayer.NA, "rithms, tryndamere");
//        Summoner summoner = summoners.get("rithms");
//
//        long id = summoner.getId();
//
//        assertTrue(id > 0);
// 
    @Test
    public void hibernate1() {
        try {
            this.sessionFactory = HibernateStuff.getInstance().getSessionFactory();
            
            Session session
                    = sessionFactory.openSession();
            
            session.beginTransaction();
            UserAccount user = new UserAccount("kapap", "ulu", "ff");
            session.saveOrUpdate(user);
            session.getTransaction().commit();
            
            assertTrue(true);
            
        } catch (HibernateException e) {
            assertTrue(false);
        }
        
    }

//    !API server instance is offline. Tests commented.!    
//
    @Test
    public void teamCreate1() {
//        Player p1 = new Player("Bang", "SKT T1 Bang", TeamName.SKT_T1);
//        Player p2 = new Player("Faker", "Hide on bush", TeamName.SKT_T1);
//        Player p3 = new Player("Peanut", "SKT T1 Peanut", TeamName.SKT_T1);
//        try {
//            this.sessionFactory = HibernateStuff.getInstance().getSessionFactory();
//
//            Session session
//                    = sessionFactory.openSession();
//
//            session.beginTransaction();
//
//            session.saveOrUpdate(p1);
//            session.saveOrUpdate(p2);
//            session.saveOrUpdate(p3);
//            session.getTransaction().commit();
//
//            assertTrue(true);
//
//        } catch (HibernateException e) {
//            assertTrue(false);
//        }
//
    }

    @Test
    public void testStat() {
//        RestTemplate restTemplate = new RestTemplate();
//        RatingPlayer r = restTemplate.getForObject("http://ec2-176-34-130-81.eu-west-1.compute.amazonaws.com:4444/api/v3/u/Taimou-2526/stats", RatingPlayer.class);
//        log.info(r.toString());
//
//        int hld = r.getUs().getStats().getCompetitive().getAverage_stats().getDamage_done_avg();
//        System.out.println(hld);
//        assertTrue(hld > 10000);
//
    }
    
    @Test
    public void savePlayer() {
//        this.sessionFactory = HibernateStuff.getInstance().getSessionFactory();
//
//        Session session
//                = sessionFactory.openSession();
//        session.beginTransaction();
//        RestTemplate restTemplate = new RestTemplate();
//        Player r = restTemplate.getForObject("http://ec2-176-34-130-81.eu-west-1.compute.amazonaws.com:4444/api/v3/u/Taimou-2526/stats", Player.class);
//        r.setPlayerName("Taimou");
//        r.setAccountName("Taimou-2526");
//
//        session.saveOrUpdate(r);
//
//        log.info(r.toString());
//        assertTrue(r.getAccountName().equals("Taimou-2526"));
    }

    @Test
    public void saveTeam() {
//        this.sessionFactory = HibernateStuff.getInstance().getSessionFactory();
//
//        Session session
//                = sessionFactory.openSession();
//        session.beginTransaction();
//        RestTemplate restTemplate = new RestTemplate();
//        Player r = restTemplate.getForObject("http://ec2-176-34-130-81.eu-west-1.compute.amazonaws.com:4444/api/v3/u/Tisumi-11362/stats", Player.class);
//        r.setPlayerName("Surefour");
//        r.setAccountName("Tisumi-11362");
//        r.setTeamName(TeamName.Cloud9);
//        Team c9 = new Team(TeamName.Cloud9);
//        Team envy = new Team(TeamName.Team_EnVyUs);
//        c9.add(r);
//
//        session.saveOrUpdate(r);
//        session.saveOrUpdate(c9);
//        session.saveOrUpdate(envy);
//
//        log.info(r.toString());
//        assertTrue(r.getAccountName().equals("Tisumi-11362"));
//
    }

    @Test
    public void insertData() {
//        UpdatePlayers data = new UpdatePlayers();
//        data.insertData();
//        this.sessionFactory = HibernateStuff.getInstance().getSessionFactory();
//
//        Session session
//                = sessionFactory.openSession();
//        session.beginTransaction();
//        ProData proData = new ProData();
//        Iterator<Player> players = proData.getPlayers();
//        RestTemplate restTemplate = new RestTemplate();
//        while (players.hasNext()) {
//            Player player = players.next();
//            RatingPlayer us = restTemplate.getForObject("http://ec2-176-34-130-81.eu-west-1.compute.amazonaws.com:4444/api/v3/u/" + player.getAccountName() + "/stats", RatingPlayer.class);
//            player.setRating(us);
//            session.saveOrUpdate(player);
//        }
//        session.getTransaction().commit();
//        assertTrue(true);

    }
    
    public void insertHero() {

//        this.sessionFactory = HibernateStuff.getInstance().getSessionFactory();
//
//        Session session
//                = sessionFactory.openSession();
//        session.beginTransaction(); 
//       ProData proData = new ProData();
//        Iterator<Player> players = proData.getPlayers();
//        RestTemplate restTemplate = new RestTemplate();
//        while (players.hasNext()) {
//            Player player = players.next();
//            RatingHeroes rh = restTemplate.getForObject("http://ec2-176-34-130-81.eu-west-1.compute.amazonaws.com:4444/api/v3/u/" + player.getAccountName() + "/heroes", RatingHeroes.class);
//            System.out.println(rh.getUs().getHeroes().getStats().getCompetitive().getPharah().getAverage_stats().getDamage_done_average() + "ddddddddddddddddddddddddd");
//            session.saveOrUpdate(rh);
//        }
//        session.getTransaction().commit();
//        assertTrue(true);
    }
    
    @Test
    public void inserher() {
//        try {//           UpdateHeroes heroes = new UpdateHeroes();
//           heroes.insert();
//            assertTrue(true);
//        } catch (Exception e) {
//            assertTrue(false);
//        }

//     
    }
    
}
