/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 *
 * @author Izymi
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Rating {

    private String kill_streak_best;
    private String quote;

    public Rating() {
        
    }

    @Override
    public String toString() {
        return quote;
    }

}
