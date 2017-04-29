/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Player;
import Model.TeamName;
import java.util.Map;
import net.rithms.riot.api.RiotApi;
import net.rithms.riot.api.RiotApiException;
import net.rithms.riot.constant.Region;
import net.rithms.riot.dto.Summoner.Summoner;
import org.springframework.boot.SpringApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Izymi
 */
@RestController
public class PlayerController {

    @RequestMapping("/player")
    public Player getPlayer(@RequestParam(value = "name", defaultValue = "Izaye") String name) throws RiotApiException {
        RiotApi api = new RiotApi("RGAPI-696ed310-71e7-4f8e-bee1-9b3ee195f98a");

        Map<String, Summoner> summoners = api.getSummonersByName(Region.EUW, name);
        Summoner summoner = summoners.get(name);
        Player p = new Player();
        return p;

    }
    
 
}
