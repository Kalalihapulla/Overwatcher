
import Model.Player;
import Model.TeamName;
import Model.UserAccount;
import Util.HibernateStuff;
import java.util.Map;
import net.rithms.riot.api.RiotApi;
import net.rithms.riot.api.RiotApiException;
import net.rithms.riot.constant.Region;
import net.rithms.riot.dto.Summoner.Summoner;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Assert;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

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

//    @Test
//    public void riotJava1() throws RiotApiException {       
//        RiotApi api = new RiotApi("RGAPI-696ed310-71e7-4f8e-bee1-9b3ee195f98a");
//
//        Map<String, Summoner> summoners = api.getSummonersByName(Region.NA, "rithms, tryndamere");
//        Summoner summoner = summoners.get("rithms");
//
//        long id = summoner.getId();
//
//        assertTrue(id > 0);
// 
//    }
    @Test
    public void hibernate1() {
        try {
            this.sessionFactory = HibernateStuff.getInstance().getSessionFactory();

            Session session
                    = sessionFactory.openSession();

            session.beginTransaction();
            UserAccount user = new UserAccount("kapap", "ulu");
            session.saveOrUpdate(user);
            session.getTransaction().commit();

            assertTrue(true);

        } catch (HibernateException e) {
            assertTrue(false);
        }

    }

    @Test
    public void teamCreate1() {
        Player p1 = new Player("Bang", "SKT T1 Bang", TeamName.SKT_T1);
        Player p2 = new Player("Faker", "Hide on bush", TeamName.SKT_T1);
        Player p3 = new Player("Peanut", "SKT T1 Peanut", TeamName.SKT_T1);
        try {
            this.sessionFactory = HibernateStuff.getInstance().getSessionFactory();

            Session session
                    = sessionFactory.openSession();

            session.beginTransaction();

            session.saveOrUpdate(p1);
            session.saveOrUpdate(p2);
            session.saveOrUpdate(p3);
            session.getTransaction().commit();

            assertTrue(true);

        } catch (HibernateException e) {
            assertTrue(false);
        }

    }

}
