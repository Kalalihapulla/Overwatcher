/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import JSONModel.Hero.HeroModel;
import Model.Player;
import Model.QueryMethods;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Himel
 */
@RestController
public class HeroController extends QueryMethods {

    @RequestMapping("/allHeroes")
    public List<HeroModel> allHeroes() {

        return allHero();

    }
}
