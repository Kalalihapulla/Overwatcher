/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.UserAccount;
import com.google.gson.Gson;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Izymi
 */
@RestController
@EnableAutoConfiguration
public class Userdata {

    @RequestMapping("/")
    String user() {
        return "lul";
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Userdata.class, args);
   
        
    }
}
