/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import JSONModel.Hero.CompareDmg;
import JSONModel.Hero.CompareElis;
import JSONModel.Hero.HeroModel;
import Model.Player;
import Model.QueryMethods;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Himel
 */
@RestController
public class HeroController extends QueryMethods {

    @RequestMapping("/allHeroes")
    public List<HeroModel> allHeroes(@RequestParam(value = "id", defaultValue = "1") String id) {
        List<HeroModel> heroModels = allHero();
        if (id.equals("2")) {
            Collections.sort(heroModels, new CompareDmg());
            return heroModels;

        }
        if (id.equals("3")) {
            Collections.sort(heroModels, new CompareElis());
            return heroModels;

        } else {
            Collections.sort(heroModels);
            return heroModels;

        }

    }
}
