/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeSet;
import javax.websocket.Decoder;

/**
 *
 * @author Izymi
 */
public class ProData {

    private Queue<Player> players;
    private Player taimou;
    private Player chipshajen;
    private Player cocco;
    private Player mickie;
    private Player hulk;
    private Player harry;
    private Player surefour;
    private Player mendo;
    private Player roolf;
    private Player adam;
    private Player ryb;
    private Player gods;
    private Player seagull;
    private Player iddqd;
    private Player ajax;
    private Player numlocked;
    private Player dummy;
    private Player harbleu;
    private Player custa;
    private Player coolmatt;
    private Player buds;
    private Player vonethil;
    private Player stoop;
    private Player hafficool;
    private Player zebbosai;
    private Player nevix;
    private Player tviq;
    private Player reinforce;
    private Player manneten;
    private Player zave;
    private Player unkoe;
    private Player winz;
    private Player soon;
    private Player akm;
    private Player knoxxx;

    public ProData() {
        this.players = new LinkedList();

        this.taimou = new Player("Taimou", "Taimou-2526", TeamName.Team_EnVyUs);
        this.chipshajen = new Player("chipshajen", "chipshajen-2102", TeamName.Team_EnVyUs);
        this.cocco = new Player("cocco", "cocco-2188", TeamName.Team_EnVyUs);
        this.mickie = new Player("Mickie", "Mickie-11702", TeamName.Team_EnVyUs);
        this.hulk = new Player("INTERNETHULK", "INTERNETHULK-2984", TeamName.Team_EnVyUs);
        this.harry = new Player("HarryHook", "HarryHook-2309", TeamName.Team_EnVyUs);
        
        this.surefour = new Player("Surefour", "Surefour-2559", TeamName.Cloud9);
        this.mendo = new Player("Mendokusaii", "Mendokusaii-2955", TeamName.Cloud9);
        this.roolf = new Player("Roolf", "Roolf-1732", TeamName.Cloud9);
//        this.adam = new Player("Adam", "", TeamName.Cloud9);
        this.ryb = new Player("Ryb", "ryb-2520", TeamName.Cloud9);
        this.gods = new Player("Gods", "Gods-11104", TeamName.Cloud9);
        
        this.seagull = new Player("Seagull", "Seagull-1894", TeamName.NRG_Esports);
        this.iddqd = new Player("Iddqd", "IDDQD-11988", TeamName.NRG_Esports);
        this.ajax = new Player("Ajax", "AJax-12136", TeamName.NRG_Esports);
        this.numlocked = new Player("Numlocked", "numlocked-21330", TeamName.NRG_Esports);
        this.dummy = new Player("Dummy", "dummy-1173", TeamName.NRG_Esports);
        this.harbleu = new Player("Harbleu", "harbleu-1515", TeamName.NRG_Esports);
        
        this.custa = new Player("Custa", "Custa-1679", TeamName.Fnatic);
        this.coolmatt = new Player("Coolmatt69", "coolmatt69-1231", TeamName.Fnatic);
//        this.buds = new Player("Buds", "", TeamName.Fnatic);
        this.vonethil = new Player("Vonethil", "Vonethil-2761", TeamName.Fnatic);
        this.stoop = new Player("Stoop", "Stoop-1718", TeamName.Fnatic);
        this.hafficool = new Player("Hafficool", "Hafficool-21377", TeamName.Fnatic);

        this.zebbosai = new Player("Zebbosai", "Zebbosai-2381", TeamName.Misfits);
        this.nevix = new Player("Nevix", "Nevix-2877", TeamName.Misfits);
        this.tviq = new Player("TviQ", "TviQ-1503", TeamName.Misfits);
        this.reinforce = new Player("Reinforce", "Reinforce-2978", TeamName.Misfits);
        this.manneten = new Player("Manneten", "Manneten-2445", TeamName.Misfits);
        this.zave = new Player("Zave", "Zave-2150", TeamName.Misfits);
        
        this.unkoe = new Player("uNKOE", "uNKOE-2828", TeamName.Rogue);
        this.winz = new Player("winz", "winz-2621", TeamName.Rogue);
        this.soon = new Player("SoOn", "SoOn-2543", TeamName.Rogue);
        this.akm = new Player("aKm", "aKm-2452", TeamName.Rogue);
        this.knoxxx = new Player("KnOxXx", "KnOxXx-21951", TeamName.Rogue);

    }

    public Iterator getPlayers() {
        players.add(taimou);
        players.add(chipshajen);
        players.add(cocco);
        players.add(harry);
        players.add(hulk);
        players.add(mickie);
        players.add(surefour);
        players.add(mendo);
        players.add(roolf);
//        players.add(adam);
        players.add(ryb);
        players.add(gods);
        players.add(seagull);
        players.add(iddqd);
        players.add(ajax);
        players.add(numlocked);
        players.add(dummy);
        players.add(harbleu);
        players.add(custa);
        players.add(coolmatt);
//        players.add(buds);
        players.add(vonethil);
        players.add(stoop);
        players.add(hafficool);
        players.add(zebbosai);
        players.add(nevix);
        players.add(tviq);
        players.add(reinforce);
        players.add(manneten);
        players.add(zave);
        players.add(unkoe);
        players.add(winz);
        players.add(soon);
        players.add(akm);
        players.add(knoxxx);

        return players.iterator();
    }

}
