package fr.afcepf.atod.wine.entity;
import java.io.Serializable;
import java.util.*;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * by roro
 */
@Table(name = "ProductVarietal")
@Entity
public class ProductVarietal implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 544340355216822403L;
	/**
     * columns
     */
    @Transient
    private static final int MAX_SIZE = 50;
    /**
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * description
     */
    @Column(name     = "description",
            length   = MAX_SIZE * 2,
            nullable = false)
    private String description;
    
    /**
     * products
     */
    @OneToMany(mappedBy = "productVarietal")
    private Set<ProductWine> productsWine;
    
    
    // -------- Construtors -----------//
    
     /**
     * Default constructor
     */
    public ProductVarietal() {
    }
    
    public ProductVarietal(Integer id, String description) {
        this.id = id;
        this.description = description;
    }
    
    // -------- Getters && Setters ----------//

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<ProductWine> getProductsWine() {
        return productsWine;
    }

    public void setProductsWine(Set<ProductWine> productsWine) {
        this.productsWine = productsWine;
    }

	@Override
	public String toString() {
		return "ProductVarietal [id=" + id + ", description=" + description + "]";
	}
}