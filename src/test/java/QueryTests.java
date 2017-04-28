
import Model.Player;
import Model.QPlayer;
import Model.QUserAccount;
import Model.UserAccount;
import Util.HibernateStuff;
import com.mysema.query.hql.HQLQuery;
import com.mysema.query.hql.hibernate.HibernateQuery;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import net.rithms.riot.api.RiotApi;
import net.rithms.riot.api.RiotApiException;
import net.rithms.riot.constant.Region;
import net.rithms.riot.dto.Summoner.Summoner;
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
public class QueryTests {

    private SessionFactory sessionFactory;

    @Test
    public void qdsl1() throws InterruptedException {
        try {
            QUserAccount userAccount = QUserAccount.userAccount;
            this.sessionFactory = HibernateStuff.getInstance().getSessionFactory();

            Session session
                    = sessionFactory.openSession();
            HQLQuery query = new HibernateQuery(session);
            Thread.sleep(2000);
            UserAccount bob = query.from(userAccount).where(userAccount.id.eq(1L)).uniqueResult(userAccount);

            assertTrue(bob.getUserid().equals("kapap"));

        } catch (Exception e) {
            assertTrue(false);
        }

    }

    @Test
    public void qdsl2() throws RiotApiException {
        try {

            ArrayList players = new ArrayList<Player>();
            RiotApi api = new RiotApi("RGAPI-696ed310-71e7-4f8e-bee1-9b3ee195f98a");
            this.sessionFactory = HibernateStuff.getInstance().getSessionFactory();

            Session session
                    = sessionFactory.openSession();
            HQLQuery query = new HibernateQuery(session);
            QPlayer player = QPlayer.player;

            List<String> list = query.from(player).groupBy(player.accountName).list(player.accountName);
            StringBuilder builder = new StringBuilder();
            for (String name : list) {
                builder.append(name + ", ");

            }

            builder.deleteCharAt(builder.length() - 1);
            builder.deleteCharAt(builder.length() - 1);
     
            System.out.println(builder);

            Map<String, Summoner> summoners = api.getSummonersByName(Region.KR, builder.toString());
            System.out.println(summoners);
            Summoner summoner = summoners.get("hideonbush");

            long id = summoner.getId();
            System.out.println(id);
            assertTrue(id == 4460427);
        } catch (Exception e) {
            System.err.println(e);
            assertTrue(false);
        }

    }

}
