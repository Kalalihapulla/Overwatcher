/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import JSONModel.Player.AverageStats;
import JSONModel.Player.OverallStats;
import java.io.Serializable;

/**
 *
 * @author Himel
 */
public abstract class ValueCalculate implements Serializable{

    private static final double damage_done_avgC = 0.007;
    private static final double healing_done_avgC = 0.015;
    private static final double objective_time_avgC = 5000.0;
    private static final double solo_kills_avgC = 5.0;
    private static final double melee_final_blows_avgC = 70.0;
    private static final double deaths_avgC = -7.0;
    private static final double eliminations_avgC = 3;
    private static final double time_spent_on_fire_avgC = 700.0;
    private static final double final_blows_avgC = 1.5;
    private static final double objective_kills_avgC = 2.5;
    private static final double win_rateC = 1.5;
    private static final double comprankC = 0.02;

    public int calculate(AverageStats averageStat) {
        try {
            double value = 0.0;
            value += averageStat.getEliminations_avg() * eliminations_avgC + averageStat.getDamage_done_avg() * damage_done_avgC
                    + averageStat.getHealing_done_avg() * healing_done_avgC + averageStat.getObjective_time_avg() * objective_time_avgC
                    + averageStat.getSolo_kills_avg() * solo_kills_avgC + averageStat.getMelee_final_blows_avg() * melee_final_blows_avgC
                    + averageStat.getDeaths_avg() * deaths_avgC + averageStat.getTime_spent_on_fire_avg() * time_spent_on_fire_avgC
                    + averageStat.getFinal_blows_avg() * final_blows_avgC + averageStat.getObjective_kills_avg() * objective_kills_avgC;
            return (int) value;

        } catch (Exception e) {
            return 0;
        }

    }

    public int calculate(OverallStats overallStats) {
        try {
            int value = 0;
            value += overallStats.getComprank() * comprankC + win_rateC * overallStats.getWin_rate();
            return value;

        } catch (Exception e) {
            return 0;
        }

    }

}
