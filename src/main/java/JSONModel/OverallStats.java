/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JSONModel;

import Model.Calculatable;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author Izymi
 * 
 */

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class OverallStats implements Calculatable, Serializable{
  
    private long id;

    public OverallStats() {
        this.id = 0L;
    }
    

    @Override
    public double calculate() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
