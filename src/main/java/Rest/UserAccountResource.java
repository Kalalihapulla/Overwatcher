//
//package Rest;
//
//import Util.HibernateStuff;
//import Model.UserAccount;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import org.hibernate.Criteria;
//import org.hibernate.Session;
//import org.hibernate.criterion.Restrictions;
//
//
//@Path("useraccount")
//public class UserAccountResource {
//
//    @Context
//    private UriInfo context;
//
//
//    public UserAccountResource() {
//    }
//
//    @GET
//    @Produces(MediaType.APPLICATION_XML)
//    public void getXml() {
//        
//    }
//
//    @PUT
//    @Consumes(MediaType.TEXT_PLAIN)
//    @Produces("text/plain")
//    public String putXml(String content) {
//        String[] stringArray = content.split(",");
//
//        Session session = HibernateStuff.getInstance().getSessionFactory().openSession();
//        session.beginTransaction();
//
//        List userPersons = session.createCriteria(UserAccount.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).add(Restrictions.eq("name", stringArray[0])).list();
//
//        if (userPersons.isEmpty()) {
//            UserAccount u1 = new UserAccount(stringArray[0], stringArray[1]);
//            session.saveOrUpdate(u1);
//            session.getTransaction().commit();
//            return "Correct";
//        } else {
//            session.getTransaction().commit();
//            return "error";
//        }
//    }
//    
//    @Path("All")
//    @GET
//    @Produces(MediaType.APPLICATION_XML)
//    public List getAllUserAccounts(){
//        Session session = HibernateStuff.getInstance().getSessionFactory().openSession();
//        session.beginTransaction();
//        List users = session.createCriteria(UserAccount.class).list();
//        
//         session.getTransaction().commit();
//        
//        return users;
//    }
//    
//    @Path("/All/Names")
//    @GET
//    @Produces(MediaType.APPLICATION_XML)
//    public String getAllNames(){
//        Session session = HibernateStuff.getInstance().getSessionFactory().openSession();
//        session.beginTransaction();
//        List users = session.createCriteria(UserAccount.class).list();
//        
//        StringBuffer sb = new StringBuffer("<names>");
//        
//        for(Object i : users){
//            UserAccount ua  = (UserAccount)i;
//            
//            sb.append("<name>");
//            sb.append(ua.getUsername());
//            sb.append("</name>");
//        }
//        sb.append("</names>");
//        session.getTransaction().commit();
//        return sb.toString();
//    }
//
//    @Path("/{userId}/")
//    @GET
//    @Produces(MediaType.APPLICATION_XML)
//    public UserAccount getUserAccount(@PathParam("userId") String id) {
//        Session session = HibernateStuff.getInstance().getSessionFactory().openSession();
//        session.beginTransaction();
//
//        List users = session.createCriteria(UserAccount.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).add(Restrictions.eq("name", id)).list();
//        session.getTransaction().commit();
//        UserAccount ua = (UserAccount) users.get(0);
//
//        return ua;
//    }
//
//    @Path("/{userId}/{userPassword}/password")
//    @POST
//    @Consumes(MediaType.TEXT_PLAIN)
//    @Produces(MediaType.TEXT_PLAIN)
//    public String setPassword(@PathParam("userId") String userId, @PathParam("userPassword") String userPassword, String password) throws Exception {
//        Session session = HibernateStuff.getInstance().getSessionFactory().openSession();
//        session.beginTransaction();
//
//        List userAccounts = session.createCriteria(UserAccount.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).add(Restrictions.eq("name", userId)).list();
//        UserAccount userAccount = (UserAccount) userAccounts.get(0);
//
//        if (userAccount.getPassword().equals(userPassword)) {
//
//            List users = session.createCriteria(UserAccount.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).add(Restrictions.eq("name", userId)).list();
//            UserAccount user = (UserAccount) users.get(0);
//
//            user.setPassword(password);
//
//            session.saveOrUpdate(user);
//            session.getTransaction().commit();
//
//            return user.getPassword();
//        } else {
//            session.getTransaction().commit();
//            throw new Exception("Wrong Username or password");
//        }
//    }
//}
