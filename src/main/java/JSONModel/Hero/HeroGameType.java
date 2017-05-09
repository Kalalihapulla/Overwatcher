/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JSONModel.Hero;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 *
 * @author Himel
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class HeroGameType implements Serializable {

    private Hero pharah;
    private Hero mccree;
    private Hero sombra;
    private Hero tracer;
    private Hero ana;
    private Hero soldier76;
    private Hero genji;
    private Hero roadhog;
    private Hero lucio;
    private Hero winston;
    private Hero mercy;
    private Hero reaper;
    private Hero widowmaker;
    private Hero bastion;
    private Hero symmetra;
    private Hero torbjorn;
    private Hero dva;
    private Hero junkrat;
    private Hero hanzo;
    private Hero zarya;
    private Hero reinhardt;
    private Hero mei;
    private Hero zenyatta;

  

    public HeroGameType() {
      
        pharah = new Hero();
        mccree = new Hero();
        sombra = new Hero();
        tracer = new Hero();
        ana = new Hero();
        bastion = new Hero();
        dva = new Hero();
        genji = new Hero();
        hanzo = new Hero();
        junkrat = new Hero();
        lucio = new Hero();
        mei = new Hero();
        mercy = new Hero();
        reaper = new Hero();
        reinhardt = new Hero();
        roadhog = new Hero();
        soldier76 = new Hero();
        sombra = new Hero();
        symmetra = new Hero();
        torbjorn = new Hero();
        widowmaker = new Hero();
        winston = new Hero();
        zarya = new Hero();
        zenyatta = new Hero();

    }



    public Hero getPharah() {
        return pharah;
    }

    public void setPharah(Hero pharah) {
        this.pharah = pharah;
    }

 
    public Hero getMccree() {
        return mccree;
    }

    public void setMccree(Hero mccree) {
        this.mccree = mccree;
    }


    public Hero getSombra() {
        return sombra;
    }

    public void setSombra(Hero sombra) {
        this.sombra = sombra;
    }

  
    public Hero getTracer() {
        return tracer;
    }

    public void setTracer(Hero tracer) {
        this.tracer = tracer;
    }

    public Hero getAna() {
        return ana;
    }

    public void setAna(Hero ana) {
        this.ana = ana;
    }

    
    public Hero getSoldier76() {
        return soldier76;
    }

    public void setSoldier76(Hero soldier76) {
        this.soldier76 = soldier76;
    }

 
    public Hero getGenji() {
        return genji;
    }

    public void setGenji(Hero genji) {
        this.genji = genji;
    }


    public Hero getRoadhog() {
        return roadhog;
    }

    public void setRoadhog(Hero roadhog) {
        this.roadhog = roadhog;
    }


    public Hero getLucio() {
        return lucio;
    }

    public void setLucio(Hero lucio) {
        this.lucio = lucio;
    }

    public Hero getWinston() {
        return winston;
    }

    public void setWinston(Hero winston) {
        this.winston = winston;
    }


    public Hero getMercy() {
        return mercy;
    }

    public void setMercy(Hero mercy) {
        this.mercy = mercy;
    }


    public Hero getReaper() {
        return reaper;
    }

    public void setReaper(Hero reaper) {
        this.reaper = reaper;
    }


    public Hero getWidowmaker() {
        return widowmaker;
    }

    public void setWidowmaker(Hero widowmaker) {
        this.widowmaker = widowmaker;
    }

    public Hero getBastion() {
        return bastion;
    }

    public void setBastion(Hero bastion) {
        this.bastion = bastion;
    }


    public Hero getSymmetra() {
        return symmetra;
    }

    public void setSymmetra(Hero symmetra) {
        this.symmetra = symmetra;
    }

    public Hero getTorbjorn() {
        return torbjorn;
    }

    public void setTorbjorn(Hero torbjorn) {
        this.torbjorn = torbjorn;
    }


    public Hero getDva() {
        return dva;
    }

    public void setDva(Hero dva) {
        this.dva = dva;
    }


    public Hero getJunkrat() {
        return junkrat;
    }

    public void setJunkrat(Hero junkrat) {
        this.junkrat = junkrat;
    }

  
    public Hero getHanzo() {
        return hanzo;
    }

    public void setHanzo(Hero hanzo) {
        this.hanzo = hanzo;
    }

    public Hero getZarya() {
        return zarya;
    }

    public void setZarya(Hero zarya) {
        this.zarya = zarya;
    }


    public Hero getReinhardt() {
        return reinhardt;
    }

    public void setReinhardt(Hero reinhardt) {
        this.reinhardt = reinhardt;
    }

    public Hero getMei() {
        return mei;
    }

    public void setMei(Hero mei) {
        this.mei = mei;
    }

    public Hero getZenyatta() {
        return zenyatta;
    }

    public void setZenyatta(Hero zenyatta) {
        this.zenyatta = zenyatta;
    }

}
