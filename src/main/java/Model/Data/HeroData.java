/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Data;

import JSONModel.Hero.HeroModel;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author Himel
 */
public class HeroData {

    private Queue heroes;
    private HeroModel pharah;
    private HeroModel mccree;
    private HeroModel sombra;
    private HeroModel tracer;
    private HeroModel ana;
    private HeroModel soldier76;
    private HeroModel genji;
    private HeroModel roadhog;
    private HeroModel lucio;
    private HeroModel winston;
    private HeroModel mercy;
    private HeroModel reaper;
    private HeroModel widowmaker;
    private HeroModel bastion;
    private HeroModel symmetra;
    private HeroModel torbjorn;
    private HeroModel dva;
    private HeroModel junkrat;
    private HeroModel hanzo;
    private HeroModel zarya;
    private HeroModel reinhardt;
    private HeroModel mei;
    private HeroModel zenyatta;

    public HeroData() {
        heroes = new LinkedList();
        pharah = new HeroModel("Pharah");
        mccree = new HeroModel("McCree");
        sombra = new HeroModel("Sombra");
        tracer = new HeroModel("Tracer");
        ana = new HeroModel("Ana");
        bastion = new HeroModel("Bastion");
        dva = new HeroModel("Dva");
        genji = new HeroModel("Genji");
        hanzo = new HeroModel("Hanzo");
        junkrat = new HeroModel("Junkrat");
        lucio = new HeroModel("Lucio");
        mei = new HeroModel("Mei");
        mercy = new HeroModel("Mercy");
        reaper = new HeroModel("Reaper");
        reinhardt = new HeroModel("Reinhardt");
        roadhog = new HeroModel("Roadhog");
        soldier76 = new HeroModel("Soldier76");
        symmetra = new HeroModel("Symmetra");
        torbjorn = new HeroModel("Torbjorn");
        widowmaker = new HeroModel("Widowmaker");
        winston = new HeroModel("Winston");
        zarya = new HeroModel("Zarya");
        zenyatta = new HeroModel("Zenyatta");
    }

    public Iterator getHeroes() {
        heroes.add(pharah);
        heroes.add(mccree);
        heroes.add(sombra);
        heroes.add(tracer);
        heroes.add(ana);
        heroes.add(bastion);
        heroes.add(dva);
        heroes.add(genji);
        heroes.add(hanzo);
        heroes.add(junkrat);
        heroes.add(mei);
        heroes.add(lucio);
        heroes.add(mercy);
        heroes.add(reaper);
        heroes.add(reinhardt);
        heroes.add(roadhog);
        heroes.add(symmetra);
        heroes.add(soldier76);
        heroes.add(torbjorn);
        heroes.add(widowmaker);
        heroes.add(winston);
        heroes.add(zarya);
        heroes.add(zenyatta);

        return heroes.iterator();
    }

}
