/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JSONModel;

import Model.Calculatable;
import Model.Value;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author Izymi
 */
@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class AverageStats extends Value implements Calculatable, Serializable {

    private int damage_done_avg;
    private int healing_done_avg;
    private double objective_time_avg;
    private double solo_kills_avg;
    private double melee_final_blows_avg ;
    private double deaths_avg;
    private double eliminations_avg;
    private double time_spent_on_fire_avg;
    private double final_blows_avg;
    private double objective_kills_avg;
    private long id;

    public AverageStats() {
        this.id = 0L;
      
    }

    @Override
    public String toString() {
        return "solokill " + time_spent_on_fire_avg + "melee " + objective_kills_avg;
    }

    @Basic
    public int getDamage_done_avg() {
        return damage_done_avg;
    }

    public void setDamage_done_avg(int damage_done_avg) {
        this.damage_done_avg = damage_done_avg;
    }

    @Basic
    public int getHealing_done_avg() {
        return healing_done_avg;
    }

    public void setHealing_done_avg(int healing_done_avg) {
        this.healing_done_avg = healing_done_avg;
    }

    @Basic
    public double getObjective_time_avg() {
        return objective_time_avg;
    }

    public void setObjective_time_avg(double objective_time_avg) {
        this.objective_time_avg = objective_time_avg;
    }

    @Basic
    public double getSolo_kills_avg() {
        return solo_kills_avg;
    }

    public void setSolo_kills_avg(double solo_kills_avg) {
        this.solo_kills_avg = solo_kills_avg;
    }

    @Basic
    public double getMelee_final_blows_avg() {
        return melee_final_blows_avg;
    }

    public void setMelee_final_blows_avg(double melee_final_blows_avg) {
        this.melee_final_blows_avg = melee_final_blows_avg;
    }

    @Basic
    public double getDeaths_avg() {
        return deaths_avg;
    }

    public void setDeaths_avg(double deaths_avg) {
        this.deaths_avg = deaths_avg;
    }

    @Basic
    public double getEliminations_avg() {
        return eliminations_avg;
    }

    public void setEliminations_avg(double eliminations_avg) {
        this.eliminations_avg = eliminations_avg;
    }

    @Basic
    public double getTime_spent_on_fire_avg() {
        return time_spent_on_fire_avg;
    }

    public void setTime_spent_on_fire_avg(double time_spent_on_fire_avg) {
        this.time_spent_on_fire_avg = time_spent_on_fire_avg;
    }

    @Basic
    public double getFinal_blows_avg() {
        return final_blows_avg;
    }

    public void setFinal_blows_avg(double final_blows_avg) {
        this.final_blows_avg = final_blows_avg;
    }

    @Basic
    public double getObjective_kills_avg() {
        return objective_kills_avg;
    }

    public void setObjective_kills_avg(double objective_kills_avg) {
        this.objective_kills_avg = objective_kills_avg;
    }

    @Override
    public int calculate() {
        return super.calculate(this);
    }

    @Id
    @GeneratedValue 
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

}
