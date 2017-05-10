
import Model.Update.UpdateHeroes;
import Model.Player;
import Model.QueryMethods;
import Model.Team;
import Model.TeamName;
//import Model.QPlayer;
//import Model.QUserAccount;
//import Model.Rating;
import Model.UserAccount;
import Util.HibernateStuff;
import com.mysema.query.hql.HQLQuery;
import com.mysema.query.hql.hibernate.HibernateQuery;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
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
public class QueryTests extends QueryMethods {
//

    private SessionFactory sessionFactory;
    private static final Logger log = LoggerFactory.getLogger(QueryTests.class);

//    @Test
//    public void qdsl1() throws InterruptedException {
//        try {
//            QUserAccount userAccount = QUserAccount.userAccount;
//            this.sessionFactory = HibernateStuff.getInstance().getSessionFactory();
//
//            Session session
//                    = sessionFactory.openSession();
//            HQLQuery query = new HibernateQuery(session);
//            Thread.sleep(2000);
//            UserAccount bob = query.from(userAccount).where(userAccount.id.eq(1L)).uniqueResult(userAccount);
//
//            assertTrue(bob.getUserid().equals("kapap"));
//
//        } catch (Exception e) {
//            assertTrue(false);
//        }
//
//    }
//
//    @Test
//    public void qdsl2() throws RiotApiException {
//        try {
//
//            ArrayList players = new ArrayList<Player>();
//            RiotApi api = new RiotApi("RGAPI-696ed310-71e7-4f8e-bee1-9b3ee195f98a");
//            this.sessionFactory = HibernateStuff.getInstance().getSessionFactory();
//
//            Session session
//                    = sessionFactory.openSession();
//            HQLQuery query = new HibernateQuery(session);
//            QPlayer player = QPlayer.player;
//
//            List<String> list = query.from(player).groupBy(player.accountName).list(player.accountName);
//            StringBuilder builder = new StringBuilder();
//            for (String name : list) {
//                builder.append(name + ", ");
//
//            }
//
//            builder.deleteCharAt(builder.length() - 1);
//            builder.deleteCharAt(builder.length() - 1);
//
//            System.out.println(builder);
//
//            Map<String, Summoner> summoners = api.getSummonersByName(Region.KR, builder.toString());
//            System.out.println(summoners);
//            Summoner summoner = summoners.get("hideonbush");
//
//            long id = summoner.getId();
//            System.out.println(id);
//            assertTrue(id == 4460427);
//        } catch (Exception e) {
//            System.err.println(e);
//            assertTrue(false);
//        }
    @Test
    public void getPlayer1Id() {
        this.sessionFactory = HibernateStuff.getInstance().getSessionFactory();

        Player player = getPlayer(1L);

        assertTrue(player.getId().equals(1L));

    }

    @Test
    public void getPlayer1Name() {
        this.sessionFactory = HibernateStuff.getInstance().getSessionFactory();

        Player player = getPlayer(1L);

        assertTrue(player.getPlayerName().equals("Taimou"));

    }

    @Test
    public void getPlayer1AccountName() {
        this.sessionFactory = HibernateStuff.getInstance().getSessionFactory();

        Player player = getPlayer(1L);

        assertTrue(player.getAccountName().equals("Taimou-2526"));

    }

    @Test
    public void getPlayer1TeamName() {
        this.sessionFactory = HibernateStuff.getInstance().getSessionFactory();

        Player player = getPlayer(1L);

        assertTrue(player.getTeamName().equals(TeamName.Team_EnVyUs));
    }

    @Test
    public void getPlayer1Rating() {
        this.sessionFactory = HibernateStuff.getInstance().getSessionFactory();
        Session session
                = sessionFactory.openSession();

        Player player
                = (Player) session.get(Player.class, 1L);

        assertTrue(player.getValueRating() >= 0);
    }

    @Test
    public void comparePlayers() {
        this.sessionFactory = HibernateStuff.getInstance().getSessionFactory();
        Session session
                = sessionFactory.openSession();

        Player player
                = (Player) session.get(Player.class, 1L);
        Player player2
                = (Player) session.get(Player.class, 2L);
        System.out.println(player.getPlayerName() + player.valueRank());
        System.out.println(player2.getPlayerName() + player2.valueRank());

        assertTrue(player.compareTo(player2) != 1);

    }

    @Test
    public void getTeam1id() {
        this.sessionFactory = HibernateStuff.getInstance().getSessionFactory();

        Team team = getTeam(1L);

        assertTrue(team.getId() == 1L);
    }

    @Test
    public void getTeam1Name() {
        this.sessionFactory = HibernateStuff.getInstance().getSessionFactory();

        Team team = getTeam(1L);

        assertTrue(team.getTeamName().equals(TeamName.Fnatic));

    }

    @Test
    public void getTeam1Rating() {
        this.sessionFactory = HibernateStuff.getInstance().getSessionFactory();
        Session session
                = sessionFactory.openSession();

        Team team
                = (Team) session.get(Team.class, 1L);

        assertTrue(team.getValueRating() >= 0);
    }

    @Test
    public void getCompareTeams() {
        this.sessionFactory = HibernateStuff.getInstance().getSessionFactory();
        Session session
                = sessionFactory.openSession();

        Team team1
                = (Team) session.get(Team.class, 6L);

        Team team2
                = (Team) session.get(Team.class, 1L);
       

        assertTrue(team1.compareTo(team2) <= 1);
    }
 

}
