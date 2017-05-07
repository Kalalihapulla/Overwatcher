/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.util.Map;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Himel
 */
@org.springframework.stereotype.Controller
public class Controller {

    @Value("${welcome.message:test}")
    private String message = "Hello World";

    @RequestMapping("/Usersearch.jsp")
    public String user(Map<String, Object> model) {
        model.put("message", this.message);
        return "Ladderstats";
    }

}
