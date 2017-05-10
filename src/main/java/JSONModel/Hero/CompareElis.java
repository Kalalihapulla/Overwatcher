/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JSONModel.Hero;

import java.util.Comparator;

/**
 *
 * @author Izymi
 */
public class CompareElis implements Comparator<HeroModel> {

    @Override
    public int compare(HeroModel t, HeroModel t1) {
        if (t.getEliminations_average() == t1.getEliminations_average()) {
            return 0;
        }
        if (t.getEliminations_average() < t1.getEliminations_average()) {
            return 1;
        } else {
            return -1;
        }
    }

}
