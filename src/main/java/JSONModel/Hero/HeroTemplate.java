/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JSONModel.Hero;

import java.io.Serializable;

/**
 *
 * @author Himel
 */
public abstract class HeroTemplate implements Serializable, Comparable<HeroTemplate>{
    private String name;

    @Override
    public int compareTo(HeroTemplate o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        
    }
    
    
    
    
    
}
