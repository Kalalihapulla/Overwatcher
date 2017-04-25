
import Controller.UserAccount;
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
    
    @Test
    public void riotJava1() throws RiotApiException {
        RiotApi api = new RiotApi("RGAPI-696ed310-71e7-4f8e-bee1-9b3ee195f98a");
        
        Map<String, Summoner> summoners = api.getSummonersByName(Region.NA, "rithms, tryndamere");
        Summoner summoner = summoners.get("rithms");
        long id = summoner.getId();
        assertTrue(id > 0);
    }
    
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
    
}
