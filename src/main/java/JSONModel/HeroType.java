/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JSONModel;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import javax.annotation.Generated;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 *
 * @author Izymi
 */
@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class HeroType implements Serializable {

    private long id;
    private DataType stats;

    public HeroType() {
        this.id = 0L;
        this.stats = new DataType();
    }

    @Id
    @GeneratedValue

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @OneToOne(targetEntity = DataType.class,
            cascade = CascadeType.ALL)
    public DataType getStats() {
        return stats;
    }

    public void setStats(DataType stats) {
        this.stats = stats;
    }

}
