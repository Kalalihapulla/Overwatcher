/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Rating;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author Izymi
 */ 
public class Application {

    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String args[]) {
        RestTemplate restTemplate = new RestTemplate();
        Rating r = restTemplate.getForObject("http://ec2-176-34-130-81.eu-west-1.compute.amazonaws.com:4444/api/v3/u/Taimou-2526/stats", Rating.class);
        log.info(r.toString());
      
        System.out.println(r);
        System.out.println(r.getUs().getStats().getCompetitive().getGame_stats().getHealing_done());
    }

}
