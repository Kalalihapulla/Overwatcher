
package SessionControl;

import Model.UserAccount;
import Util.HibernateStuff;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Markus
 */
@WebServlet(name = "LogInServlet", urlPatterns = {"/LogInServlet"})
public class LogInServlet extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
     @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String user = request.getParameter("username");
        String pwd = request.getParameter("password");

        Session session = HibernateStuff.getInstance().getSessionFactory().openSession();
        session.beginTransaction();

        List users = session.createCriteria(UserAccount.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).add(Restrictions.eq("name", user)).list();
        session.getTransaction().commit();
        String password = "";
        try {
            UserAccount person = (UserAccount) users.get(0);
            password = person.getPassword();
        } catch (IndexOutOfBoundsException e) {
            System.err.println("Caught IOException: " + e.getMessage());
        }

        if (!users.isEmpty() && password.equals(pwd)) {
            Cookie loginCookie = new Cookie("user", "" + user);
            //setting cookie to expiry in 30 mins
            loginCookie.setMaxAge(30 * 60);
            response.addCookie(loginCookie);
            response.sendRedirect("Ladderstats.jsp");
        } else {
            RequestDispatcher rd = getServletContext().getRequestDispatcher("Usersearch.jsp");
            PrintWriter out = response.getWriter();
            out.println("Either username or password is wrong");
            rd.include(request, response);
        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
