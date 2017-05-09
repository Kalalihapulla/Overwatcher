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
@Entity
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

    private long id;

    public HeroGameType() {
        id = 0L;
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

    @Id
    @GeneratedValue
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @OneToOne(targetEntity = Hero.class,
            cascade = CascadeType.ALL)
    public Hero getPharah() {
        return pharah;
    }

    public void setPharah(Hero pharah) {
        this.pharah = pharah;
    }

    @OneToOne(targetEntity = Hero.class,
            cascade = CascadeType.ALL)
    public Hero getMccree() {
        return mccree;
    }

    public void setMccree(Hero mccree) {
        this.mccree = mccree;
    }

    @OneToOne(targetEntity = Hero.class,
            cascade = CascadeType.ALL)
    public Hero getSombra() {
        return sombra;
    }

    public void setSombra(Hero sombra) {
        this.sombra = sombra;
    }

    @OneToOne(targetEntity = Hero.class,
            cascade = CascadeType.ALL)
    public Hero getTracer() {
        return tracer;
    }

    public void setTracer(Hero tracer) {
        this.tracer = tracer;
    }

    @OneToOne(targetEntity = Hero.class,
            cascade = CascadeType.ALL)
    public Hero getAna() {
        return ana;
    }

    public void setAna(Hero ana) {
        this.ana = ana;
    }

    @OneToOne(targetEntity = Hero.class,
            cascade = CascadeType.ALL)
    public Hero getSoldier76() {
        return soldier76;
    }

    public void setSoldier76(Hero soldier76) {
        this.soldier76 = soldier76;
    }

    @OneToOne(targetEntity = Hero.class,
            cascade = CascadeType.ALL)
    public Hero getGenji() {
        return genji;
    }

    public void setGenji(Hero genji) {
        this.genji = genji;
    }

    @OneToOne(targetEntity = Hero.class,
            cascade = CascadeType.ALL)
    public Hero getRoadhog() {
        return roadhog;
    }

    public void setRoadhog(Hero roadhog) {
        this.roadhog = roadhog;
    }

    @OneToOne(targetEntity = Hero.class,
            cascade = CascadeType.ALL)
    public Hero getLucio() {
        return lucio;
    }

    public void setLucio(Hero lucio) {
        this.lucio = lucio;
    }

    @OneToOne(targetEntity = Hero.class,
            cascade = CascadeType.ALL)
    public Hero getWinston() {
        return winston;
    }

    public void setWinston(Hero winston) {
        this.winston = winston;
    }

    @OneToOne(targetEntity = Hero.class,
            cascade = CascadeType.ALL)
    public Hero getMercy() {
        return mercy;
    }

    public void setMercy(Hero mercy) {
        this.mercy = mercy;
    }

    @OneToOne(targetEntity = Hero.class,
            cascade = CascadeType.ALL)
    public Hero getReaper() {
        return reaper;
    }

    public void setReaper(Hero reaper) {
        this.reaper = reaper;
    }

    @OneToOne(targetEntity = Hero.class,
            cascade = CascadeType.ALL)
    public Hero getWidowmaker() {
        return widowmaker;
    }

    public void setWidowmaker(Hero widowmaker) {
        this.widowmaker = widowmaker;
    }

    @OneToOne(targetEntity = Hero.class,
            cascade = CascadeType.ALL)
    public Hero getBastion() {
        return bastion;
    }

    public void setBastion(Hero bastion) {
        this.bastion = bastion;
    }

    @OneToOne(targetEntity = Hero.class,
            cascade = CascadeType.ALL)
    public Hero getSymmetra() {
        return symmetra;
    }

    public void setSymmetra(Hero symmetra) {
        this.symmetra = symmetra;
    }

    @OneToOne(targetEntity = Hero.class,
            cascade = CascadeType.ALL)
    public Hero getTorbjorn() {
        return torbjorn;
    }

    public void setTorbjorn(Hero torbjorn) {
        this.torbjorn = torbjorn;
    }

    @OneToOne(targetEntity = Hero.class,
            cascade = CascadeType.ALL)
    public Hero getDva() {
        return dva;
    }

    public void setDva(Hero dva) {
        this.dva = dva;
    }

    @OneToOne(targetEntity = Hero.class,
            cascade = CascadeType.ALL)
    public Hero getJunkrat() {
        return junkrat;
    }

    public void setJunkrat(Hero junkrat) {
        this.junkrat = junkrat;
    }

    @OneToOne(targetEntity = Hero.class,
            cascade = CascadeType.ALL)
    public Hero getHanzo() {
        return hanzo;
    }

    public void setHanzo(Hero hanzo) {
        this.hanzo = hanzo;
    }

    @OneToOne(targetEntity = Hero.class,
            cascade = CascadeType.ALL)
    public Hero getZarya() {
        return zarya;
    }

    public void setZarya(Hero zarya) {
        this.zarya = zarya;
    }

    @OneToOne(targetEntity = Hero.class,
            cascade = CascadeType.ALL)
    public Hero getReinhardt() {
        return reinhardt;
    }

    public void setReinhardt(Hero reinhardt) {
        this.reinhardt = reinhardt;
    }

    @OneToOne(targetEntity = Hero.class,
            cascade = CascadeType.ALL)
    public Hero getMei() {
        return mei;
    }

    public void setMei(Hero mei) {
        this.mei = mei;
    }

    @OneToOne(targetEntity = Hero.class,
            cascade = CascadeType.ALL)
    public Hero getZenyatta() {
        return zenyatta;
    }

    public void setZenyatta(Hero zenyatta) {
        this.zenyatta = zenyatta;
    }

}
