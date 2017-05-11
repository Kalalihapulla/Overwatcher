package Controller;

import Util.HibernateStuff;
import java.util.Map;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PageRedirect {

    // inject RequestParam(value = "id", defaultValue = "1") String idvia application.properties
//    @Value("${welcome.message:test}")
    //private String message = "Hello World";
    private SessionFactory sessionFactory;

    @RequestMapping("/")
    public String welcome(Map<String, Object> model) {
//        model.put("message", this.message);
        return "Usersearch";
    }

    @RequestMapping("/ladderstats")
    public String ladder() {
        //@RequestParam(value = "user", defaultValue = "Taimou") String user
        //model.put("message", "lul");
//        this.sessionFactory = HibernateStuff.getInstance().getSessionFactory();
//
//        Session session
//                = sessionFactory.openSession();
//        session.beginTransaction();
        return "Ladderstats";
    }

    @RequestMapping("/usersearch")
    public String user() {

        return "Usersearch";
    }

    @RequestMapping("/userstats")
    public String stats() {

        return "Userstats";
    }

    @RequestMapping("/about")
    public String about() {

        return "About";
    }
    @RequestMapping("/teamstats")
    public String teamstats() {

        return "Teamstats";
    }

    @RequestMapping("/heroes")
    public String heroest() {

        return "Heroes";
    }

}
