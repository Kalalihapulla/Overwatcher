package Util;

import JSONModel.Hero.*;
import JSONModel.Player.RegionPlayer;
import JSONModel.Player.AverageStats;
import JSONModel.Player.PlayerGameType;
import JSONModel.Player.OverallStats;
import JSONModel.Player.StatsPlayer;
import Model.RatingHeroes;
import Model.RatingPlayer;
import Model.Team;
import Model.UserAccount;
import org.hibernate.SessionFactory;
import org.hibernate.SessionFactoryObserver;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.boot.registry.internal.StandardServiceRegistryImpl;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.tool.hbm2ddl.SchemaExport;

public class HibernateStuff {

    private final SessionFactory sessionFactory;

    /**
     * Configures hibernate
     */
    public HibernateStuff() {
        Configuration config = new Configuration();
//        config.addAnnotatedClass(UserAccount.class);
        config.addAnnotatedClass(Model.Player.class);
        config.addAnnotatedClass(RatingPlayer.class);
        config.addAnnotatedClass(Team.class);
        config.addAnnotatedClass(RegionPlayer.class);
        config.addAnnotatedClass(StatsPlayer.class);
        config.addAnnotatedClass(PlayerGameType.class);
        config.addAnnotatedClass(OverallStats.class);
        config.addAnnotatedClass(AverageStats.class);
        config.addAnnotatedClass(RatingHeroes.class);
        config.addAnnotatedClass(StatsHero.class);
        config.addAnnotatedClass(RegionHero.class);
        config.addAnnotatedClass(HeroType.class);
        config.addAnnotatedClass(HeroGameType.class);
        config.addAnnotatedClass(Hero.class);
        config.addAnnotatedClass(AverageHero.class);
        config = config.configure();
        //new SchemaExport(config).create(true, true);

        StandardServiceRegistryBuilder serviceRegistryBuilder
                = new StandardServiceRegistryBuilder();
        serviceRegistryBuilder.applySettings(config.getProperties());

        final ServiceRegistry serviceRegistry = serviceRegistryBuilder.build();

        config.setSessionFactoryObserver(new SessionFactoryObserver() {
            @Override
            public void sessionFactoryCreated(SessionFactory factory) {
            }

            @Override
            public void sessionFactoryClosed(SessionFactory factory) {
                System.out.println("sessionFactoryClosed()");
                ((StandardServiceRegistryImpl) serviceRegistry).destroy();
            }
        });
        this.sessionFactory = config.buildSessionFactory(serviceRegistry);
    }

    public SessionFactory getSessionFactory() {
        return this.sessionFactory;
    }

    public static HibernateStuff getInstance() {
        return HibernateStuffHolder.INSTANCE;
    }

    private static class HibernateStuffHolder {

        private static final HibernateStuff INSTANCE = new HibernateStuff();
    }
}
