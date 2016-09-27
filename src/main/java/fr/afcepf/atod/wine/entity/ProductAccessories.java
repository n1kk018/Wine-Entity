package fr.afcepf.atod.wine.entity;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
/**
 * by Roro
 */
@Entity
@DiscriminatorValue(value = "ACCESSORIES")
public class ProductAccessories extends Product implements Serializable {
        
    /**
	 * serail.
	 */
	private static final long serialVersionUID = 6310251186149020639L;
    
	/**
     * Default constructor.
     */
    public ProductAccessories() {
    }

    public ProductAccessories(Integer id, String name, Double price, String description, Date createdAt) {
        super(id, name, price, description);
    }
}