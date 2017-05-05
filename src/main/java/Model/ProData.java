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

    public ProData() {
        this.players = new LinkedList();

        this.taimou = new Player("Taimou", "Taimou-2526", TeamName.Team_EnVyUs);
        this.chipshajen = new Player("chipshajen", "chipshajen-2102", TeamName.Team_EnVyUs);
        this.cocco = new Player("cocco", "cocco-2188", TeamName.Team_EnVyUs);
        this.mickie = new Player("Mickie", "Mickie-11702", TeamName.Team_EnVyUs);
        this.hulk = new Player("INTERNETHULK", "INTERNETHULK-2984", TeamName.Team_EnVyUs);
        this.harry = new Player("HarryHook", "HarryHook-2309", TeamName.Team_EnVyUs);

    }

    public Iterator getPlayers() {
        players.add(taimou);
        players.add(chipshajen);
        players.add(cocco);
        players.add(harry);
        players.add(hulk);
        players.add(mickie);

        return players.iterator();
    }

}
