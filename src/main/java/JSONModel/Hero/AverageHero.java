/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JSONModel.Hero;

import Model.Calculatable;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author Himel
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class AverageHero implements Serializable, Calculatable {

    private double damage_done_average;
    private double eliminations_average;
 

    public AverageHero() {
     
    }
   
    public double getDamage_done_average() {
        return damage_done_average;
    }

    public void setDamage_done_average(double damage_done_average) {
        this.damage_done_average = damage_done_average;
    }
   
    public double getEliminations_average() {
        return eliminations_average;
    }

    public void setEliminations_average(double eliminations_average) {
        this.eliminations_average = eliminations_average;
    }



    @Override
    public int calculate() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
