/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import JSONModel.HeroStat;
import JSONModel.Region;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 *
 * @author Izymi
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Rating {

    private String kill_streak_best;
    private String type;
 
    private HeroStat tracer;
    private Region us;

    public Rating() {

    }

    @Override
    public String toString() {
        return us.toString();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }



    public HeroStat getTracer() {
        return tracer;
    }

    public void setTracer(HeroStat tracer) {
        this.tracer = tracer;
    }

    public Region getUs() {
        return us;
    }

    public void setUs(Region us) {
        this.us = us;
    }           

}
