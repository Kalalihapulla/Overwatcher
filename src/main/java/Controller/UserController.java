/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Player;
import Model.QueryMethods;
import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Izymi
 */
@RestController
public class UserController extends QueryMethods {

    @RequestMapping("/createuser")
    public boolean getPlayer(@RequestParam(value = "userId", defaultValue = "unknown") String userId, @RequestParam(value = "bnetId", defaultValue = "unknown") String bnetId, @RequestParam(value = "password", defaultValue = "unknown") String password) {

        return true;

    }


}
