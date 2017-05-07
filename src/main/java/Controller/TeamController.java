/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.QueryMethods;
import Model.Team;
import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Izymi
 */
@RestController
public class TeamController extends QueryMethods {

    @RequestMapping("/getTeam")
    public Team getTeam(@RequestParam(value = "id", defaultValue = "1") String id) {
        Long idN = Long.parseLong(id);
        return getTeam(idN);

    }

    @RequestMapping("/allTeams")
    public List<Team> allTeams() {

        return allTeam();

    }

}
