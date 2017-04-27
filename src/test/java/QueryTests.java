
import Model.QUserAccount;
import Model.UserAccount;
import Util.HibernateStuff;
import com.mysema.query.hql.HQLQuery;
import com.mysema.query.hql.hibernate.HibernateQuery;
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
    public void qdsl1() {
        QUserAccount userAccount = QUserAccount.userAccount;
        this.sessionFactory = HibernateStuff.getInstance().getSessionFactory();

        Session session
                = sessionFactory.openSession();
        HQLQuery query = new HibernateQuery(session);
        UserAccount bob = query.from(userAccount).where(userAccount.id.eq(1L)).uniqueResult(userAccount);

        assertTrue(bob.getUserid().equals("kapap"));
    }

}
