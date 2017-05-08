/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Player;
import Model.QueryMethods;
import Model.Team;
import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Himel
 */
@RestController
public class PlayerController extends QueryMethods {

    @RequestMapping("/getPlayer")
    public Player getPlayer(@RequestParam(value = "id", defaultValue = "1") String id) {
        Long idN = Long.parseLong(id);
        return getPlayer(idN);

    }

    @RequestMapping("/allPlayers")
    public List<Player> allPlayers() {

        return getAllPlayers();

    }

}
