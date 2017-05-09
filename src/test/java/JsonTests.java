
import Model.UserAccount;
import com.google.gson.Gson;
import java.util.ArrayList;
import static org.junit.Assert.assertEquals;
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
public class JsonTests {

    @Test
    public void json1() {
        UserAccount account = new UserAccount("dd", "F","dd");
        UserAccount account3 = new UserAccount("ddd", "Ffg","dd");
        UserAccount account2 = new UserAccount("dtgfd", "gfgfF","dd");
        ArrayList s = new ArrayList<UserAccount>();
        s.add(account);
        s.add(account2);
        s.add(account3);

        Gson g = new Gson();
        String f = g.toJson(s);
      assertTrue(f.length() > 15);
       

    }

}
